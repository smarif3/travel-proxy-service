package com.project.travel.controller;

import com.project.travel.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/travel/v1/proxy")
public class ProxyController {

	@Autowired
	private ProxyService proxyService;
	
	@RequestMapping(value = "/currencies", method= RequestMethod.GET)
	public String currencyRates() {
		return proxyService.getExchangeRates();
	}
	
	@RequestMapping(value = "/events", method= RequestMethod.GET)
	public String events(@RequestParam String location) {
		return proxyService.getEvents(location);
	}
}
