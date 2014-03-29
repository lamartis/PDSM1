package com.traitement.integration;

import java.io.File;

import com.generatedClasses.integration.RemovePPTResponse;
import com.generatedClasses.presentation.DeletePPTResponse;
import com.generatedClasses.presentation.DeletePPTResponse.Response;
import com.interfaces.M2iInterface;
import com.outils.Codeur;

public class RemovePPTResponseTraitement extends TraitementI {

	RemovePPTResponse removePPTResponse = (RemovePPTResponse) requete;
	
	public RemovePPTResponseTraitement(M2iInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
	}

	@Override
	public Void call() throws Exception {
		
		//Delete File.
		new File(servletContext.getRealPath(accountsFolder + "/" + removePPTResponse.getIdentifiant() + "/" + removePPTResponse.getNomDocument())).delete();
		
		//Prepare message to send
		
		Response response = new Response();
		response.setDeleted(true);
		response.setIdDocument(removePPTResponse.getIdDocument());
		
		DeletePPTResponse deletePPTResponse = new DeletePPTResponse();
		deletePPTResponse.setResponse(response);
		deletePPTResponse.setIdentifiant(removePPTResponse.getIdentifiant());

		responseXMLMessage = Codeur.convert(deletePPTResponse);

		producerM2P.setMessage(responseXMLMessage, idMessage, idCorrelation);
		poolProducers.submit(producerM2P);

		return null;

	}

}
