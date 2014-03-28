package fr.projet26.producteur;

import java.util.HashMap;
import java.util.Map;

public class CorrelationSingleton {
	private static CorrelationSingleton instance;
	private static Map<String, String> correlationMap = new HashMap<String, String>();

	public static synchronized CorrelationSingleton getInstance() {
		if (null == instance) { 
			if (null == instance) {
				instance = new CorrelationSingleton();
			}
		}
		return instance;
	}

	private CorrelationSingleton() {}

	public static synchronized String get(String idMessageEnvoye) {
		return correlationMap.get(idMessageEnvoye);
	}

	public static synchronized void add(String idMessageEnvoyee, String idMessageRecu) {
		correlationMap.put(idMessageEnvoyee, idMessageRecu);
		LoggerSingleton.getInstance().addInfoLog("[" + idMessageEnvoyee + ", " + idMessageRecu + "] added with success on correlationMap");
	}
	
	public static synchronized void remove(String idMessageEnvoyee){
		correlationMap.remove(idMessageEnvoyee);
		LoggerSingleton.getInstance().addInfoLog("[" + idMessageEnvoyee + "] removed with success from correlationMap || total = " + correlationMap.size());
	}
	
}
