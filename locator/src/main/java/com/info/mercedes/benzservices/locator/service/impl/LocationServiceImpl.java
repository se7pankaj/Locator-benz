package com.info.mercedes.benzservices.locator.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.info.mercedes.benzservices.locator.exceptions.ClientErrorException;
import com.info.mercedes.benzservices.locator.exceptions.advice.ErrorResponse;
import com.info.mercedes.benzservices.locator.model.LocationValue;
import com.info.mercedes.benzservices.locator.model.Locations;
import com.info.mercedes.benzservices.locator.model.extapi_res.LocationExtAPIResponse;
import com.info.mercedes.benzservices.locator.service.LocationServiceApi;
import com.info.mercedes.benzservices.locator.utility.HttpHeadersUtility;

@Service
public class LocationServiceImpl implements LocationServiceApi {
	@Autowired
	HttpHeadersUtility httpHeadersUtility;

	@Autowired
	@Qualifier(value = "benzAPIRestTemplate")
	RestTemplate restTemplate;

	public static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Override
	@Async
	public CompletableFuture<List<Locations>> getLocationList(String url,String locationType) {
		logger.info("Request received to getLocationList >>");
		String response = "";
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, httpHeadersUtility.getHttpHeader(), String.class)
					.getBody();
		} catch (HttpClientErrorException exception) {
			logger.error(exception.getResponseBodyAsString());
			ErrorResponse error = new ErrorResponse(exception.getResponseBodyAsString(), exception.getRawStatusCode(),
					exception.getStatusText(), exception.getStatusCode());
			ClientErrorException clientErrorException = new ClientErrorException();
			clientErrorException.setError(error);
		} catch (HttpStatusCodeException exception) {
			logger.error(exception.getResponseBodyAsString());
			ErrorResponse error = new ErrorResponse(exception.getResponseBodyAsString(), exception.getRawStatusCode(),
					exception.getStatusText(), exception.getStatusCode());
			ClientErrorException clientErrorException = new ClientErrorException();
			clientErrorException.setError(error);
		}
		Gson gson = new Gson();
		LocationExtAPIResponse locationExtAPIResponse = gson.fromJson(response, LocationExtAPIResponse.class);

		List<Locations> locationList = new ArrayList<Locations>();
		Locations locations = new Locations();
		List<LocationValue> responseList=new ArrayList<LocationValue>();
		if (null != locationExtAPIResponse && locationExtAPIResponse.getResults() != null
				&& locationExtAPIResponse.getResults().getItems() != null
				&& !locationExtAPIResponse.getResults().getItems().isEmpty()) {
			
			 responseList =	locationExtAPIResponse.getResults().getItems().stream().filter(data->data.getCategory().getId().equals("restaurant")
					||data.getCategory().getId().equals("transport")
					||data.getCategory().getId().equals("petrol-station")).map(data->{ 
						
				LocationValue locVal = new LocationValue();
				locVal.setLocationId(data.getId());
				locVal.setAddress(data.getVicinity());
				locVal.setName(data.getTitle());
				locVal.setRating(data.getAverageRating());
				locVal.setDistance(Double.parseDouble(data.getDistance()));
				if(data.getOpeningHours()!=null)
				locVal.setOpeningHours(data.getOpeningHours().getText());
				locVal.setIcon(data.getIcon());
				
				return locVal;
			}).collect(Collectors.toList());
			locations.setLocationType(locationType);
			locations.setResponseValue(responseList);
			locations.getResponseValue().sort(Comparator.comparingDouble(LocationValue::getDistance));
			locationList.add(locations);
			logger.info("Method getLocationList End>>");
		}
		return CompletableFuture.completedFuture(locationList);
	}

}
