package com.info.mercedes.benzservices.locator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.info.mercedes.benzservices.locator.exceptions.AccessDeniedException;
import com.info.mercedes.benzservices.locator.exceptions.BadRequestException;
import com.info.mercedes.benzservices.locator.model.LocationResJsonBody;
import com.info.mercedes.benzservices.locator.model.LocationResponse;
import com.info.mercedes.benzservices.locator.model.LocationResponseValue;
import com.info.mercedes.benzservices.locator.model.Locations;
import com.info.mercedes.benzservices.locator.service.LocationServiceApi;
import com.info.mercedes.benzservices.locator.service.LocatorService;
import com.info.mercedes.benzservices.locator.utility.HttpHeadersUtility;

@Service
public class LocatorServiceImpl implements LocatorService {

	@Autowired
	HttpHeadersUtility httpHeadersUtility;

	@Autowired
	@Qualifier(value = "benzAPIRestTemplate")
	RestTemplate restTemplate;

	@Autowired
	Environment env;

	@Autowired
	LocationServiceApi locationServiceApi;

	public static final Logger logger = LoggerFactory.getLogger(LocatorServiceImpl.class);

	@Override
	@Cacheable(value = "cache-search", keyGenerator = "SearchLocationKeyGenerator")
	public LocationResponse getLocationDetails(String location) throws Exception {
		logger.info("Request received to getLocationDetails >>");
		
		LocationResponse response = new LocationResponse();
		// Here assuming based on location name we are getting location longitude
		// latitude
		// [skipping Logic] should be like based on user entered location , will find position.
		// Here i m hard coding the location name & [Position] longitude latitude as 52.5159,13.3777
		location = "Brandenburg Gate";
		String latitude = "52.5159,13.3777";
		String restaurantLocURL = new StringBuilder(env.getProperty("hdev.base.url") + env.getProperty("hdev.location.restaurant").replace("_next_", latitude)).toString();
		
		String transportLocURL = new StringBuilder(env.getProperty("hdev.base.url") + env.getProperty("hdev.location.transport").replace("_next_", latitude)).toString();
		
		String fuelStationLocURL = new StringBuilder(env.getProperty("hdev.base.url") + env.getProperty("hdev.location.petrol_station").replace("_next_", latitude)).toString();
		
		List<Locations> allLocationList = new ArrayList<Locations>();
		CompletableFuture<List<Locations>> restaurant;
		CompletableFuture<List<Locations>> transport;
		CompletableFuture<List<Locations>> fuelStation;
		
		try{
			restaurant = locationServiceApi.getLocationList(restaurantLocURL,"restaurant");
			transport = locationServiceApi.getLocationList(transportLocURL, "transport");
			fuelStation = locationServiceApi.getLocationList(fuelStationLocURL,"petrol-station");
			if (restaurant != null) {
				allLocationList.addAll(restaurant.get());
			}
			if (transport != null) {
				allLocationList.addAll(transport.get());
			}
			if (fuelStation != null) {
				allLocationList.addAll(fuelStation.get());
			}
			
		}catch(AccessDeniedException exception) {
			logger.info("access Denied : "+exception.getMessage());
			throw new AccessDeniedException("Access Denied : unable to complete the process");
		}catch(BadRequestException exception) {
			logger.info("Exception Occured : "+exception.getMessage());
			throw new BadRequestException("BadRequest : unable to complete the process");
		}catch(Exception exception) {
			throw new Exception(exception.getMessage());
		}
		
		LocationResJsonBody jsnBody = new LocationResJsonBody();
		LocationResponseValue value = new LocationResponseValue();
		value.setLocations(allLocationList);
		jsnBody.setValue(value);
		response.setStatus(200);
		response.setJsonBody(jsnBody);
		logger.info("End getLocationDetails and response : << "+response.getStatus());
		return response;
	}
}
