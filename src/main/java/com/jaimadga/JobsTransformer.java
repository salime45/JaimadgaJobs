package com.jaimadga;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class JobsTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

		String msg = "";
        String array = message.getSessionProperty("jobs").toString();

		
		
		try {

			msg += message.getPayloadAsString(outputEncoding);
//			JSONObject aux = new JSONObject(msg);	
//
//			JSONArray jobs = new JSONArray(array);
//		
//			for (int i = 0; i < jobs.length(); i++) {
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
		return msg;
	}

}
