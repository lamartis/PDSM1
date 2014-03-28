package com.traitement.integration;

import com.generatedClasses.integration.RemoveArchiveResponse;
import com.generatedClasses.presentation.DeleteArchiveResponse;
import com.generatedClasses.presentation.DeleteArchiveResponse.Response;
import com.interfaces.M2iInterface;
import com.outils.Codeur;

public class RemoveArchiveResponseTraitement extends TraitementI {

	RemoveArchiveResponse removeArchiveResponse = (RemoveArchiveResponse) requete;
	
	public RemoveArchiveResponseTraitement(M2iInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
	}

	@Override
	public Void call() throws Exception {

		//Prepare message to send
		DeleteArchiveResponse deleteArchiveResponse = new DeleteArchiveResponse();
		deleteArchiveResponse.setIdentifiant(removeArchiveResponse.getIdentifiant());
		Response response = new Response();
		response.setIdArchive(removeArchiveResponse.getIdArchive());
		response.setDeleted(removeArchiveResponse.isRemoved());
		deleteArchiveResponse.setResponse(response);

		responseXMLMessage = Codeur.convert(deleteArchiveResponse);

		producerM2P.setMessage(responseXMLMessage, idMessage, idCorrelation);
		poolProducers.submit(producerM2P);

		return null;

	}

}
