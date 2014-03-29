package com.traitement.presentation;

import com.generatedClasses.integration.RemovePPTRequest;
import com.generatedClasses.presentation.DeletePPTRequest;
import com.interfaces.P2mInterface;
import com.outils.Codeur;

public class DeletePPTRequestTraitement extends TraitementP{

	DeletePPTRequest deletePPTRequest = (DeletePPTRequest) requete;

	public DeletePPTRequestTraitement(P2mInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
	}

	@Override
	public Void call() throws Exception {

		//Prepare message à envoyer à l'integration
		RemovePPTRequest removePPTRequest = new RemovePPTRequest();
		removePPTRequest.setIdentifiant(deletePPTRequest.getIdentifiant());
		removePPTRequest.setIdDocument(deletePPTRequest.getIdDocument());

		responseXMLMessage = Codeur.convert(removePPTRequest);

		producerM2I.setMessage(responseXMLMessage, idMessage, idCorrelation);
		poolProducers.submit(producerM2I);

		return null;

	}

}
