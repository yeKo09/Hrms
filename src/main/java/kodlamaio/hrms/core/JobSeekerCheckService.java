package kodlamaio.hrms.core;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {

	boolean checkIfRealJobSeeker(JobSeeker jobSeeker) throws NumberFormatException, RemoteException;
	
}
