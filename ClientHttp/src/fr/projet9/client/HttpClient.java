package fr.projet9.client;
//http://alvinalexander.com/blog/post/java/how-open-url-read-contents-httpurl-connection-java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import fr.projet9.interfaces.Client;

public class HttpClient implements Client{

	URL url = null;

	public HttpClient(URL urlServlet) {
		try {
			this.url = urlServlet;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendMessage(String message) throws Exception {

		try {
			// create the HttpURLConnection

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.connect();

			PrintWriter osw		 	= new PrintWriter(connection.getOutputStream());
			String data				= "message=" + message;


			//*******************Envoi d'informations à la servelt***************************
			osw.write(data);
			osw.flush();
			osw.close();	

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}


}