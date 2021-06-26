package de.moscon.extern_systems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CustomerSimulator {

	@Autowired
	ResourceLoader resourceLoader;

	public Resource importDataAsCsv() {
		return resourceLoader.getResource("file:data/input/kunden.csv");
	}
}
