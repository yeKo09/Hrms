package kodlamaio.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.SaveImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

@Service
public class JobSeekerCvManager implements JobSeekerCvService{

	private JobSeekerCvDao jobSeekerCvDao;
	private SaveImageService saveImageService;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao,SaveImageService saveImageService) {
		this.jobSeekerCvDao = jobSeekerCvDao;
		this.saveImageService = saveImageService;
	}

	@Override
	public Result add(JobSeekerCv jobSeekerCv) throws IOException {
		String imageUrl = this.saveImageService.saveImage(jobSeekerCv.getCvPhotoUrl());
		jobSeekerCv.setCvPhotoUrl(imageUrl);
		this.jobSeekerCvDao.save(jobSeekerCv);
		return new SuccessResult("Cv başarıyla eklendi.");
	}
	
}
