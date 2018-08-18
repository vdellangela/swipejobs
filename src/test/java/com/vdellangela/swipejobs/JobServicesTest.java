package com.vdellangela.swipejobs;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vdellangela.swipejobs.models.Job;
import com.vdellangela.swipejobs.models.Worker;
import com.vdellangela.swipejobs.services.JobServices;
import com.vdellangela.swipejobs.services.WorkerServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServicesTest {
	@Autowired
	private JobServices jobServices;
	@Autowired
	private WorkerServices workerServices;

	@Test
	public void testExistingJob() throws Exception {
		Worker worker = workerServices.getWorker(1);
		List<Job> listJobs = jobServices.getRecommendedJobs(worker);

		assertThat(listJobs, hasSize(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNonExistingJob() throws Exception {
		Worker worker = null;
		List<Job> listJobs = jobServices.getRecommendedJobs(worker);
	}
}
