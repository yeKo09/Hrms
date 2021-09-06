package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingStaffValidationService;
import kodlamaio.hrms.entities.concretes.JobPostingStaffValidation;

@RestController
@RequestMapping("/api/jobpostingstaffvalidation")
@CrossOrigin
public class JobPostingStaffValidationController {

	private JobPostingStaffValidationService jobPostingStaffValidationService;

	@Autowired
	public JobPostingStaffValidationController(JobPostingStaffValidationService jobPostingStaffValidationService) {
		this.jobPostingStaffValidationService = jobPostingStaffValidationService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobPostingStaffValidationService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid JobPostingStaffValidation jobPostingStaffValidation){
		return ResponseEntity.ok(this.jobPostingStaffValidationService.add(jobPostingStaffValidation));
	}
	
	@PutMapping("/verifyJobPosting")
	public ResponseEntity<?> verifyJobPosting(@RequestParam int id){
		return ResponseEntity.ok(this.jobPostingStaffValidationService.verifyJobPosting(id));
	}
	
	@DeleteMapping("/deleteJobPosting")
	public ResponseEntity<?> deleteJobPosting(@RequestParam int jobPostingId){
		return ResponseEntity.ok(this.jobPostingStaffValidationService.deleteJobPosting(jobPostingId));
	}
	
}
