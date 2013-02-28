package net.yummycode.jsfplate.ajax;

import java.util.List;

import org.atmosphere.config.service.BroadcasterCacheService;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.BroadcasterCache;

@BroadcasterCacheService
public class SampleBroadcasterCache implements BroadcasterCache {

	@Override
	public void addToCache(String arg0, AtmosphereResource arg1, Object arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Object> retrieveFromCache(String arg0, AtmosphereResource arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

}
