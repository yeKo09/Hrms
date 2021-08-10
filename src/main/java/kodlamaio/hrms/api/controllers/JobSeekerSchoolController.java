package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerSchoolService;
import kodlamaio.hrms.entities.concretes.JobSeekerSchool;

@RestController
@RequestMapping("/api/jobseekerschool")
public class JobSeekerSchoolController {

	private JobSeekerSchoolService jobSeekerSchoolService;

	@Autowired
	public JobSeekerSchoolController(JobSeekerSchoolService jobSeekerSchoolService) {
		this.jobSeekerSchoolService = jobSeekerSchoolService;
	}
	
	@PostMapping("/addschool")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerSchool jobSeekerSchool){
		return ResponseEntity.ok(this.jobSeekerSchoolService.add(jobSeekerSchool));
	}
	
}
