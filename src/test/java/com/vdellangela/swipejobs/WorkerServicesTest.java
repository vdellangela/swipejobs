package com.vdellangela.swipejobs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vdellangela.swipejobs.models.Worker;
import com.vdellangela.swipejobs.services.WorkerServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerServicesTest {
	@Autowired
	private WorkerServices workerServices;

	@Test
	public void testExistingWorker() throws Exception {
		Worker worker = workerServices.getWorker(0);

		assertNotNull(worker);
		assertEquals(Integer.valueOf(0), worker.getUserId());
	}

	@Test
	public void testNonExistingWorker() throws Exception {
		Worker worker = workerServices.getWorker(-10);

		assertNull(worker);
	}
}
