package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

public interface JobSeekerTalentDao extends JpaRepository<JobSeekerTalent, Integer>{

}
