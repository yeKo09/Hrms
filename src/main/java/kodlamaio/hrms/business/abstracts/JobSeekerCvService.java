package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

public interface JobSeekerCvService {

	Result add(JobSeekerCv jobSeekerCv) throws IOException;
	
}
