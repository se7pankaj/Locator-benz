/**
 * 
 */
package com.info.mercedes.benzservices.locator.service;

import com.info.mercedes.benzservices.locator.model.LocationResponse;

/**
 * 
 * @author Pankaj Kumar
 *
 */
public interface LocatorService {

	public LocationResponse getLocationDetails(String location) throws Exception;
}
