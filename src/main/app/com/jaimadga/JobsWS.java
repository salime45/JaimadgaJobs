package com.jaimadga;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;



@WebService
public interface JobsWS {
	
	@WebMethod
	public Collection<Job> getJobs();

}