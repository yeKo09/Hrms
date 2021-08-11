package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService{

	private JobSeekerLanguageDao jobSeekerLanguageDao;
	
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult("Dil eklendi.");
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAll() {
		return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.findAll(), "Bütün bilinen diller döndürüldü.");
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getLanguagesByCvId(int id) {
		return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.getByJobSeekerCv_Id(id),
				id + " numaralı cv'ye ait bütün bilinen diller listelenmiştir.");
	}
	

}
