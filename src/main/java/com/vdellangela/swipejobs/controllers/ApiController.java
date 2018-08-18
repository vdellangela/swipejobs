package com.vdellangela.swipejobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vdellangela.swipejobs.models.Job;
import com.vdellangela.swipejobs.models.Worker;
import com.vdellangela.swipejobs.services.JobServices;
import com.vdellangela.swipejobs.services.WorkerServices;

@RestController
public class ApiController {
	@Autowired
	private WorkerServices workerServices;
	@Autowired
	private JobServices jobServices;

	@GetMapping("/worker/{id}")
	@ResponseBody
	public ResponseEntity<List<Job>> check(@PathVariable Integer id) {

		Worker worker = workerServices.getWorker(id);
		List<Job> listJobs = jobServices.getRecommendedJobs(worker);

		return new ResponseEntity<>(listJobs, HttpStatus.OK);
	}
}