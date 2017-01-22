package com.jaimadga;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class JobsTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

        String test = message.getSessionProperty("test");

		String msg = test + "--------------------------------------------------------------------------------";
		
		
		try {
			msg += message.getPayloadAsString(outputEncoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}

}
