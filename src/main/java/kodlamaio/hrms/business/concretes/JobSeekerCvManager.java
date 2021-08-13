package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.adapters.SaveImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTalentDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import kodlamaio.hrms.entities.concretes.JobSeekerSchool;
import kodlamaio.hrms.entities.concretes.JobSeekerTalent;


@Service
public class JobSeekerCvManager implements JobSeekerCvService{

	private JobSeekerCvDao jobSeekerCvDao;
	private SaveImageService saveImageService;
	private JobSeekerExperienceDao jobSeekerExperienceDao;
	private JobSeekerSchoolDao jobSeekerSchoolDao;
	private JobSeekerLanguageDao jobSeekerLanguageDao;
	private JobSeekerTalentDao jobSeekerTalentDao;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, SaveImageService saveImageService,
			JobSeekerExperienceDao jobSeekerExperienceDao, JobSeekerSchoolDao jobSeekerSchoolDao,
			JobSeekerLanguageDao jobSeekerLanguageDao, JobSeekerTalentDao jobSeekerTalentDao) {
		this.jobSeekerCvDao = jobSeekerCvDao;
		this.saveImageService = saveImageService;
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
		this.jobSeekerSchoolDao = jobSeekerSchoolDao;
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
		this.jobSeekerTalentDao = jobSeekerTalentDao;
	}

	@Override
	public Result add(JobSeekerCv jobSeekerCv) throws IOException {
		String imageUrl = this.saveImageService.saveImage(jobSeekerCv.getCvPhotoUrl());
		jobSeekerCv.setCvPhotoUrl(imageUrl);
		this.jobSeekerCvDao.save(jobSeekerCv);
		List<JobSeekerSchool> jsSchools = new ArrayList<JobSeekerSchool>();
		for (JobSeekerSchool jobSeekerSchool : jobSeekerCv.getJobSeekerSchools()) {
			jsSchools.add(new JobSeekerSchool((int) 0L,
					jobSeekerSchool.getSchoolName(),jobSeekerSchool.getDepartmentName(),
					jobSeekerSchool.getSchoolStartedAt(), jobSeekerSchool.getGraduatedAt(),
					jobSeekerCv));
		}
		List<JobSeekerExperience> jsExperiences = new ArrayList<JobSeekerExperience>();
		for (JobSeekerExperience jobSeekerExperience : jobSeekerCv.getJobSeekerExperiences()) {
			jsExperiences.add(new JobSeekerExperience((int) 0L,
					jobSeekerExperience.getWorkplaceName(),jobSeekerExperience.getPositionName(),
					jobSeekerExperience.getExperienceStartedAt(), jobSeekerExperience.getQuittedAt(),
					jobSeekerCv));
		}
		List<JobSeekerLanguage> jsLanguages = new ArrayList<JobSeekerLanguage>();
		for (JobSeekerLanguage jobSeekerLanguage : jobSeekerCv.getJobSeekerLanguages()) {
			jsLanguages.add(new JobSeekerLanguage((int) 0L,
					jobSeekerLanguage.getLanguageName(),jobSeekerLanguage.getLanguageLevel(),
					jobSeekerCv));
		}
		List<JobSeekerTalent> jsTalents = new ArrayList<JobSeekerTalent>();
		for (JobSeekerTalent jobSeekerTalent : jobSeekerCv.getJobSeekerTalents()) {
			jsTalents.add(new JobSeekerTalent((int) 0L,
					jobSeekerTalent.getTalentName(),
					jobSeekerCv));
		}
		this.jobSeekerSchoolDao.saveAll(jsSchools);
		this.jobSeekerExperienceDao.saveAll(jsExperiences);
		this.jobSeekerLanguageDao.saveAll(jsLanguages);
		this.jobSeekerTalentDao.saveAll(jsTalents);
		return new SuccessResult("Cv başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobSeekerCv>> getAll() {
		return new SuccessDataResult<List<JobSeekerCv>>(this.jobSeekerCvDao.findAll(), "Bütün cvler listelendi.");
	}

	@Override
	public DataResult<JobSeekerCv> getCvById(int id) {
	    JobSeekerCv newJsCv = this.jobSeekerCvDao.getById(id);
	    newJsCv.setJobSeekerSchools(this.jobSeekerSchoolDao.getByJobSeekerCv_IdOrderByGraduatedAtDesc(id));
	    for (JobSeekerSchool jobSeekerSchool : newJsCv.getJobSeekerSchools()) {
			if(jobSeekerSchool.getGraduatedAt() == null) {
				jobSeekerSchool.setGraduatedAt("Devam ediyor");
			}
		}
	    newJsCv.setJobSeekerExperiences(this.jobSeekerExperienceDao.getByJobSeekerCv_IdOrderByQuittedAtDesc(id));
	    for (JobSeekerExperience jobSeekerExperience : newJsCv.getJobSeekerExperiences()) {
			if(jobSeekerExperience.getQuittedAt() == null) {
				jobSeekerExperience.setQuittedAt("Devam ediyor");
			}
		}
		return new SuccessDataResult<JobSeekerCv>(newJsCv);
	}

	
	
	
	
}
