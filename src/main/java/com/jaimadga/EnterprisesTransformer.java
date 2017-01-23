package com.jaimadga;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class EnterprisesTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

        //String test = message.getSessionProperty("test");

		String msg = "";
		//String empresas = "";
		ArrayList<String> empresas = new ArrayList<>();
		try {
			
			msg += message.getPayloadAsString(outputEncoding);
			JSONObject aux = new JSONObject(msg);	

			String array = aux.getJSONArray("offers").toString();
			JSONArray jobs = new JSONArray(array);
			message.setSessionProperty("jobs", jobs.toString());
		
			
			for (int i = 0; i < jobs.length(); i++) {
				
			    empresas.add(jobs.getJSONObject(i).getJSONObject("author").getString("name"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
		return empresas;
	}
}
