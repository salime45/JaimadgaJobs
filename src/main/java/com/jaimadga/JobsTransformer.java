package com.jaimadga;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.json.JSONArray;
import org.json.JSONObject;

public class JobsTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

        //String test = message.getSessionProperty("test");

		String msg = "";
		
		try {
			msg += message.getPayloadAsString(outputEncoding);
			JSONObject aux = new JSONObject(msg);	

			String array = aux.getJSONArray("offers").toString();
			JSONArray jobs = new JSONArray(array);
			
			for (int i = 0; i < jobs.length(); i++) {
			    JSONObject row = jobs.getJSONObject(i);
			    
			    //System.out.println("---> " + row.toString());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		

		
		return msg;
	}

}
