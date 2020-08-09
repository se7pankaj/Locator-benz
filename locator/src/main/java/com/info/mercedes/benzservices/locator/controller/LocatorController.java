/**
 * 
 */
package com.info.mercedes.benzservices.locator.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.mercedes.benzservices.locator.annotations.ValidateRequestParam;
import com.info.mercedes.benzservices.locator.model.LocationResponse;
import com.info.mercedes.benzservices.locator.presentation.LocatorPresentationImpl;

/**
 * 
 * @author Pankaj Kumar
 *
 */
@Validated
@RestController
public class LocatorController {

	@Autowired
	LocatorPresentationImpl LocatorPresentation;
	
	private final static Logger logger = LoggerFactory.getLogger(LocatorController.class);
	
	@GetMapping("locator/location")
	public ResponseEntity<?> getLocationDetails(
			@RequestHeader(value = "authorization",defaultValue = "Bearer ") String authorization,
			@RequestParam("name") @ValidateRequestParam( values = { "Brandenburg Gate","Europe" }) String location) throws Exception{
		logger.info("Request received to getLocationDetails >>");
		
		LocationResponse response = null;
		if(StringUtils.isNotBlank(location)) {
			response = LocatorPresentation.getLocationDetails(location);
		}else {
			return new ResponseEntity<String>("Unprocessable Request",HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if(response==null)
			return ResponseEntity.notFound().build();
		logger.info("response status -" + response.getStatus());
		
		return ResponseEntity.ok(response);
	}
}
