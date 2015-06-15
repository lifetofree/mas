package com.dev.mas.dao;

import com.dev.mas.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;
	
}
