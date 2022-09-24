package com.country.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.country.model.Country;

@RestController
public class CountryListController {

	@GetMapping(path = "/countries")
	public List<Country> countries() {
		List<Country> countries = new ArrayList<>();
		String[] isoCountries = Locale.getISOCountries();
		for (int i = 0; i < isoCountries.length; i++) {
			String country = isoCountries[i];
			Locale locale = new Locale("en", country);
			countries.add(new Country((i + 1) + "", locale.getCountry(), locale.getDisplayCountry()));
		}
		return countries;
	}
	
	@GetMapping(path = "/countries/{countryCode}")
	public List<Country> countryByCode(@PathVariable("countryCode") String countryCode) {
		List<Country> countries = new ArrayList<>();
		String[] isoCountries = Locale.getISOCountries();
		for (int i = 0; i < isoCountries.length; i++) {
			String country = isoCountries[i];
			Locale locale = new Locale("en", country);
			if(locale.getCountry().equalsIgnoreCase(countryCode)) {
				countries.add(new Country((i + 1) + "", locale.getCountry(), locale.getDisplayCountry()));
				return countries;
			}
		}
		return countries;
	}
}
