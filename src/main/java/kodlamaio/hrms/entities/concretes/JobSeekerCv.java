package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobSeekerCv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cv_photo_url")
	@NotBlank
	private String cvPhotoUrl;
	
	@Column(name = "github_address_url")
	@NotBlank
	private String githubAddressUrl;
	
	@Column(name = "linkedin_address_url")
	@NotBlank
	private String linkedinAddressUrl;
	
	@Column(name = "cover_letter")
	@NotBlank
	private String coverLetter;
	
	@OneToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerSchool> jobSeekerSchools;
	
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerExperience> jobSeekerExperiences;
	
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerTalent> jobSeekerTalents;
	
}
