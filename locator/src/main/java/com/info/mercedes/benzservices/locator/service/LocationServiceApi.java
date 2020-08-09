package com.info.mercedes.benzservices.locator.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.info.mercedes.benzservices.locator.model.Locations;

public interface LocationServiceApi {

	public CompletableFuture<List<Locations>> getLocationList(String url,String locationType);
}
