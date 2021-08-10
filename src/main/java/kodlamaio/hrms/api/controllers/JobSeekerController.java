package kodlamaio.hrms.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Result> signUp(@RequestBody JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		return ResponseEntity.ok(this.jobSeekerService.signUp(jobSeeker));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeeker>>> getAll(){
		return ResponseEntity.ok(this.jobSeekerService.getAll());
	}
	
	@GetMapping("/getByFirstName")
	public ResponseEntity<DataResult<JobSeeker>> getByFirstName(@RequestParam String firstName){
		return ResponseEntity.ok(this.jobSeekerService.getByFirstName(firstName));
	}
}
