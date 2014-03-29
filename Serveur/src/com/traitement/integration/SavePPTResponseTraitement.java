package com.traitement.integration;

import java.io.File;

import com.generatedClasses.integration.SavePPTResponse;
import com.generatedClasses.presentation.CreateOrUpdatePPTResponse;
import com.generatedClasses.presentation.CreateOrUpdatePPTResponse.Response;
import com.interfaces.M2iInterface;
import com.outils.Codeur;

public class SavePPTResponseTraitement extends TraitementI {

	SavePPTResponse savePPTResponse;

	public SavePPTResponseTraitement(M2iInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
		savePPTResponse = (SavePPTResponse) requete;
	}

	public Void call() throws Exception {

		CreateOrUpdatePPTResponse createOrUpdatePPTResponse = new CreateOrUpdatePPTResponse();
		createOrUpdatePPTResponse.setIdentifiant(savePPTResponse.getIdentifiant());
		
		//V�rification si le fichier PPT est bien ins�r�.
		if (!savePPTResponse.isInserted()) {
			//Sc�nario d'exception.
			new File(servletContext.getRealPath(accountsFolder + savePPTResponse.getIdentifiant() + "/" + savePPTResponse.getNomDocument())).delete();
			createOrUpdatePPTResponse.setError("Ins�rtion refus�e cot� Integration [Error DataBase]");
		} else {
			//Creation d'objet de r�ponse Sc�nario nominal.
			Response response = new Response();
			response.setIdDocument(savePPTResponse.getIdDocument());
			response.setInserted(true);
			response.setNomDocument(savePPTResponse.getNomDocument());
			
			createOrUpdatePPTResponse.setResponse(response);
		}
			
		responseXMLMessage = Codeur.convert(createOrUpdatePPTResponse);

		producerM2P.setMessage(responseXMLMessage, idMessage, idCorrelation);
		poolProducers.submit(producerM2P);

		return null;

	}

}