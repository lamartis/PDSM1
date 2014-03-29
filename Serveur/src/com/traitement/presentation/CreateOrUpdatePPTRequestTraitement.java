package com.traitement.presentation;

import java.io.File;

import com.outils.Codeur;
import com.outils.LoggerSingleton;
import com.generatedClasses.integration.SavePPTRequest;
import com.generatedClasses.presentation.*;
import com.interfaces.P2mInterface;

public class CreateOrUpdatePPTRequestTraitement extends TraitementP {

	CreateOrUpdatePPTRequest createOrUpdatePPTRequest;

	public CreateOrUpdatePPTRequestTraitement(P2mInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
		createOrUpdatePPTRequest = (CreateOrUpdatePPTRequest) requete;
	}

	public boolean verifyAllFileBeforeSending(){
		//Je verifie pour chaque emplacement d'element s'il existe bien, dans le serveur.
		LoggerSingleton.getInstance().addInfoLog("Verify All elements :");
		try {
			File file = new File( this.getAbsolutPathFromURL(createOrUpdatePPTRequest.getDocument().getEmplacement()));
			LoggerSingleton.getInstance().addInfoLog("Result : " + file.exists());
			if (!file.exists()) 
				return false;
		} catch (Exception e) {
			LoggerSingleton.getInstance().addWarningLog(e.getMessage());
		}

		LoggerSingleton.getInstance().addInfoLog(properties.getProperty("message.verification"));
		return true;
	}

	private String getAbsolutPathFromURL(String url) {
		String s = servletContext.getRealPath(accountsFolder + "/" + createOrUpdatePPTRequest.getIdentifiant() + "/" + url);
		return s;
	}

	public Void call() throws Exception {
		if (!this.verifyAllFileBeforeSending()){

			CreateOrUpdatePPTResponse createOrUpdatePPTResponse = new CreateOrUpdatePPTResponse();
			createOrUpdatePPTResponse.setIdentifiant(createOrUpdatePPTResponse.getIdentifiant());
			createOrUpdatePPTResponse.setError(properties.getProperty("error.elements"));

			//Convertir l'object SaveArchiveRequest en XML pour l'envoyer au JMS.
			responseXMLMessage = Codeur.convert(createOrUpdatePPTResponse);

			producerM2P.setMessage(responseXMLMessage, idMessage, idMessage);
			poolProducers.submit(producerM2P);

		} else {

			//Creation de l'object de r�ponse: SaveArchiveRequest.
			SavePPTRequest savePPTRequest = new SavePPTRequest();
			savePPTRequest.setIdDocument(createOrUpdatePPTRequest.getDocument().getId());
			savePPTRequest.setIdentifiant(createOrUpdatePPTRequest.getIdentifiant());
			savePPTRequest.setEmplacement(projectUrl + accountsFolder + createOrUpdatePPTRequest.getIdentifiant() +  "/" + createOrUpdatePPTRequest.getDocument().getEmplacement());

			//Convertir l'object SaveArchiveRequest en XML pour l'envoyer au JMS.
			responseXMLMessage = Codeur.convert(savePPTRequest);

			producerM2I.setMessage(responseXMLMessage, idMessage, idCorrelation);
			poolProducers.submit(producerM2I);
		
		}

		return null;
	}

}
