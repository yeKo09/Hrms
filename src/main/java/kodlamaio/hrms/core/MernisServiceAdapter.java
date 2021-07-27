package kodlamaio.hrms.core;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements JobSeekerCheckService{

	@Override
	public boolean checkIfRealJobSeeker(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		/*KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();		
		return kpsPublic.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()), jobSeeker.getFirstName(), 
				jobSeeker.getLastName(), jobSeeker.getDateOfBirth().getYear());*/
		return true;
	}

}
