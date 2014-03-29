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
import com.interfaces.M2iInterface;
import com.outils.DecodeurI2M;
import com.traitement.integration.TraitementI;

public class ServletRetour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("message") != null){
			String mm = request.getParameter("message");
			String[] tab = mm.split("///");
			
			M2iInterface object = DecodeurI2M.convert(tab[0]);
			try{
				Class<?> classeTemp = Class.forName("com.traitement.integration." + object.getClass().getSimpleName() + "Traitement") ;
				Constructor<?> classeDeTraitement = classeTemp.getDeclaredConstructor(M2iInterface.class, String.class, String.class);
				TraitementI traitement = (TraitementI) classeDeTraitement.newInstance(object, tab[2], tab[1]);
				pool.submit(traitement);
			} catch (Exception e){}
		}
	}

	public void destroy(){
		pool.shutdown();
	}

}
