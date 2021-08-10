package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

@RestController
@RequestMapping("/api/jobseekercv")
public class JobSeekerCvController {

	private JobSeekerCvService jobSeekerCvService;

	@Autowired
	public JobSeekerCvController(JobSeekerCvService jobSeekerCvService) {
		this.jobSeekerCvService = jobSeekerCvService;
	}
	
	@PostMapping("/addcv")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerCv jobSeekerCv) throws IOException {
		return ResponseEntity.ok(this.jobSeekerCvService.add(jobSeekerCv));
	}
	
}
