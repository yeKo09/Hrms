package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	Result signUp(JobSeeker jobSeeker) throws NumberFormatException, RemoteException;
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<JobSeeker> getByFirstName(String firstName);
}
