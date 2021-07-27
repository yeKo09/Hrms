package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerifyEmailService;

@Service
public class VerifyEmailManager implements VerifyEmailService{

	@Override
	public boolean verifyEmailAddress(String emailAddress) {
		return true;
	}

}
