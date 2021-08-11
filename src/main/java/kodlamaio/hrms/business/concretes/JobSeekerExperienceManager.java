package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService{

	private JobSeekerExperienceDao jobSeekerExperienceDao;
	
	@Autowired
	public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao) {
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
	}

	@Override
	public Result add(JobSeekerExperience jobSeekerExperience) {
		this.jobSeekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult("İş tecrübesi başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAll() {
		return new SuccessDataResult<List<JobSeekerExperience>>(this.jobSeekerExperienceDao.findAll(),
				"Bütün iş tecrübeleri döndürüldü.");
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getByCvIdOrderByQuittedAtDesc(int id) {
		List<JobSeekerExperience> newList = this.jobSeekerExperienceDao.getByJobSeekerCv_IdOrderByQuittedAtDesc(id);
		for (JobSeekerExperience jobSeekerExperience : newList) {
			if(jobSeekerExperience.getQuittedAt() == null) {
				jobSeekerExperience.setQuittedAt("Devam ediyor");
			}
		}
		return new SuccessDataResult<List<JobSeekerExperience>>(newList, id + " numaralı cv'ye ait bütün iş tecrübeleri listelenmiştir.");
	}

}
