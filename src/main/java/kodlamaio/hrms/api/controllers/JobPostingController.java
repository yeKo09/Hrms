package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/jobposting")
@CrossOrigin
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("/addJobPosting")
	public ResponseEntity<Result> addJobPosting(@Valid @RequestBody JobPosting jobPosting) {
		return ResponseEntity.ok(this.jobPostingService.addJobPosting(jobPosting));
	}
	
	@GetMapping("/getAllActiveJobPostings")
	public ResponseEntity<DataResult<List<JobPosting>>> getAllActiveJobPostings(){
		return ResponseEntity.ok(this.jobPostingService.getAllActiveJobPostings());
	}
	
	@GetMapping("/getByCompanyName")
	public ResponseEntity<?> getByCompanyName(@RequestParam String companyName){
		return ResponseEntity.ok(this.jobPostingService.getByCompanyNameDto(companyName));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
	
		Map<String,String> validationErrors = new HashMap<String, String>();
		
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Do??rulama hatalar??");
		
		return errors;
		
	}
	
	@GetMapping("/getAllSortedByDateASC")
	public ResponseEntity<?> getAllSortedByDateASC(){
		return ResponseEntity.ok(this.jobPostingService.getAllSortedByDateDtoASC());
	}
	
	@GetMapping("/getAllSortedByDateDESC")
	public ResponseEntity<?> getAllSortedByDateDESC(){
		return ResponseEntity.ok(this.jobPostingService.getAllSortedByDateDtoDESC());
	}
	
	@GetMapping("/getAllActiveJobPostingsWithDto")
	public ResponseEntity<?> getAllActiveJobPostingsWithDto(){
		return ResponseEntity.ok(this.jobPostingService.getAllActiveJobPostingsWithDto());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(this.jobPostingService.getById(id));
	}
	
	@PutMapping("/deactivateJobPosting")
	public ResponseEntity<Result> deactivateJobPosting(@RequestParam int id) {
		return ResponseEntity.ok(this.jobPostingService.deactivateJobPosting(id));
	}
}
