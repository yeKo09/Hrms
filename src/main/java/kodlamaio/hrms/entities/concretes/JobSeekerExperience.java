package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobSeekerExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "workplace_name")
	@NotBlank
	private String workplaceName;
	
	@Column(name = "position_name")
	@NotBlank
	private String positionName;
	
	@Column(name = "started_at")
	@NotNull
	private String experienceStartedAt;
	
	@Column(name = "quitted_at")
	private String quittedAt;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "cv_id", referencedColumnName = "id")
	private JobSeekerCv jobSeekerCv;
	
}
