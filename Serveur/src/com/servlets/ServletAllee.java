package com.servlets;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.interfaces.P2mInterface;
import com.outils.DecodeurP2M;
import com.outils.LoggerSingleton;
import com.traitement.presentation.TraitementP;

import fr.projet9.consumer.Consumer;

public class ServletAllee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	private Consumer consumerP2M;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
		consumerP2M = new Consumer("metierP2M");
		consumerP2M.doConnection("ReqPM");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("message") != null){
			String mm = request.getParameter("message");
			String[] tab = mm.split("///");

			P2mInterface object = DecodeurP2M.convert(tab[0]);
			try{
				Class<?> classeTemp = Class.forName("com.traitement.presentation." + object.getClass().getSimpleName() + "Traitement") ;
				Constructor<?> classeDeTraitement = classeTemp.getDeclaredConstructor(P2mInterface.class, String.class, String.class);
				TraitementP traitement = (TraitementP) classeDeTraitement.newInstance(object, tab[2], tab[1]);
				pool.submit(traitement);
				
			} catch (Exception e) {
				e.printStackTrace();
				LoggerSingleton.getInstance().addWarningLog(e.getMessage());
			}
			
		}

	}


	public void destroy(){
		pool.shutdown();
		consumerP2M.closeConnection();
	}


}
