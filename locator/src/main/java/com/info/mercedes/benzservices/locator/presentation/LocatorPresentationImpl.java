package com.info.mercedes.benzservices.locator.presentation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.mercedes.benzservices.locator.exceptions.AccessDeniedException;
import com.info.mercedes.benzservices.locator.exceptions.BadRequestException;
import com.info.mercedes.benzservices.locator.exceptions.ResourceNotFoundException;
import com.info.mercedes.benzservices.locator.model.LocationResponse;
import com.info.mercedes.benzservices.locator.service.LocatorService;
/**
 * 
 * @author Pankaj Kumar
 *
 */
@Service
public class LocatorPresentationImpl {

	@Autowired
	LocatorService locatorService;
	
	private final static Logger logger = LoggerFactory.getLogger(LocatorPresentationImpl.class);
	
	public LocationResponse getLocationDetails(String location) throws Exception{
		logger.info("Request received to getLocationDetails >>");
		LocationResponse response=null;
		  try {
		  response = locatorService.getLocationDetails(location);
		  }catch(ResourceNotFoundException e) {
			  logger.error("The ResourceNotFoundException occured while getting location details. "+e.getMessage());
			  throw e;
		  }catch(AccessDeniedException e) {
			  logger.error("The AccessDeniedException occured while getting location details. "+e.getMessage());
			  throw e;
		  }catch(Exception e) {
			  logger.error("The error occured while getting the location details. "+e.getMessage());
			  throw e;
		  }
		if(response.getStatus()==400) {
			throw new BadRequestException("Bad Request - could not send request");
		}else if(response.getStatus()==401) {
			throw new BadRequestException("Authentication failed");
		}else if(response.getStatus()==403) {
			throw new BadRequestException("Unauthorized access");
		}else if(response.getStatus()==404) {
			throw new BadRequestException("Location details not exist");
		}
		logger.info(" getLocationDetails end <<<");
		return response;
	}
	
}
