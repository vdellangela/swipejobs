package com.vdellangela.swipejobs.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vdellangela.swipejobs.models.Worker;

@Service
public class WorkerServices {
	@Autowired
	private RestTemplate restTemplate;
	private final String API_URL = "http://test.swipejobs.com/api/workers";

	/**
	 * Return a worker based on his id
	 * 
	 * @param id
	 * @return
	 */
	public Worker getWorker(Integer id) {
		Worker[] workers = restTemplate.getForObject(API_URL, Worker[].class);
		Worker worker = Arrays.asList(workers).stream().filter(p -> p.getUserId().equals(id)).findFirst().orElse(null);

		return worker;
	}
}
