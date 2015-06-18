package com.dev.mas.service;

import java.util.List;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Hosting;

public interface HostingService {

	public void save(String name) throws SequenceException;
	public List<Hosting> list() throws SequenceException;
	
}
