package com.vdellangela.swipejobs.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vdellangela.swipejobs.models.Job;
import com.vdellangela.swipejobs.models.Worker;

@Service
public class JobServices {
	private final int NB_RESULTS = 3;
	private final String API_URL = "http://test.swipejobs.com/api/jobs";

	@Autowired
	private LocationServices locationServices;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Return recommended jobs for a worker
	 * 
	 * @param worker
	 * @return
	 */
	public List<Job> getRecommendedJobs(Worker worker) {
		if (null == worker) {
			throw new IllegalArgumentException("{\"error\":\"Invalid worker Id\"}");
		}

		Job[] jobs = restTemplate.getForObject(API_URL, Job[].class);

		Predicate<Job> driverLicensePredicate = j -> j.hasDriverLicenseRequired().equals(worker.hasDriversLicense());
		Predicate<Job> locationPredicate = j -> locationServices.calculateDistanceInKilometer(
				j.getLocation().getLatitude(), j.getLocation().getLongitude(),
				worker.getJobSearchAddress().getLatitude(),
				worker.getJobSearchAddress().getLongitude()) <= worker.getJobSearchAddress().getMaxJobDistance();
		Predicate<Job> certificationsPredicate = j -> worker.getCertificates().containsAll(j.getRequiredCertificates());
		Predicate<Job> skillPredicate = j -> worker.getSkills().contains(j.getJobTitle());
		Predicate<Job> startDatePredicate = j -> worker.getAvailability().stream()
				.anyMatch(w -> w.getDayIndex().equals(j.getStartDate().getDayOfWeek().getValue()));

		List<Predicate<Job>> predicates = Arrays.asList(driverLicensePredicate, locationPredicate,
				certificationsPredicate, skillPredicate, startDatePredicate);

		List<Job> sortedListOfJobsByPredicateMatchCount = Arrays.asList(jobs).stream()
				.sorted(Comparator
						.comparingLong(j -> predicates.stream().filter(predicate -> predicate.test((Job) j)).count())
						.reversed())
				.limit(NB_RESULTS).collect(Collectors.toList());

		return sortedListOfJobsByPredicateMatchCount;
	}
}
