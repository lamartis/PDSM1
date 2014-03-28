package com.traitement.presentation;

import java.text.MessageFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

import com.generatedClasses.integration.RemoveArchiveRequest;
import com.generatedClasses.integration.SaveHistoryRequest;
import com.generatedClasses.presentation.DeleteArchiveRequest;
import com.generatedClasses.presentation.DeleteArchiveResponse;
import com.generatedClasses.presentation.User;
import com.interfaces.P2mInterface;
import com.outils.Codeur;
import com.outils.ConnectedUsers;

public class DeleteArchiveRequestTraitement extends TraitementP{

	DeleteArchiveRequest deleteArchiveRequest = (DeleteArchiveRequest) requete;
	User user;

	public DeleteArchiveRequestTraitement(P2mInterface object, String idMessage, String correlationId){
		super(object, idMessage, correlationId);
	}

	@Override
	public Void call() throws Exception {

		user = ConnectedUsers.get(deleteArchiveRequest.getIdentifiant());

		if (user != null){

			//Prepare message � envoyer � l'integration
			RemoveArchiveRequest removeArchiveRequest =new RemoveArchiveRequest();
			removeArchiveRequest.setIdArchive(deleteArchiveRequest.getIdArchive());
			removeArchiveRequest.setIdentifiant(deleteArchiveRequest.getIdentifiant());

			responseXMLMessage = Codeur.convert(removeArchiveRequest);

			producerM2I.setMessage(responseXMLMessage, idMessage, idCorrelation);
			poolProducers.submit(producerM2I);

			Thread.sleep(100);
			//Save History//////////////////////////////////////////////////////////
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());

			SaveHistoryRequest saveHistoryRequest = new SaveHistoryRequest();
			saveHistoryRequest.setDepotID(user.getDepoID());
			saveHistoryRequest.setMessage(MessageFormat.format(properties.getProperty("history.zip.deleted"), user.getLogin(), deleteArchiveRequest.getIdArchive()));
			saveHistoryRequest.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));

			producerM2I.setMessage(Codeur.convert(saveHistoryRequest), "", "");
			poolProducers.submit(producerM2I);
			
		} else {

			//Prepare message � envoyer � la pr�sentation
			DeleteArchiveResponse deleteArchiveResponse = new DeleteArchiveResponse();
			
			deleteArchiveResponse.setIdentifiant(deleteArchiveResponse.getIdentifiant());
			deleteArchiveResponse.setError(properties.getProperty("error.userNotConnected"));
			
			responseXMLMessage = Codeur.convert(deleteArchiveResponse);

			producerM2P.setMessage(responseXMLMessage, idMessage, idMessage);
			poolProducers.submit(producerM2P);
			Thread.sleep(100);
		}
		
		return null;
		
	}

}
