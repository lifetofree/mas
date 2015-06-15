package com.dev.mas.service;

import com.dev.mas.exception.SequenceException;

public interface HostingService {

	void save(String name) throws SequenceException;
	
}
