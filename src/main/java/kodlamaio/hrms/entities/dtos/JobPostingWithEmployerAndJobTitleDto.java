package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingWithEmployerAndJobTitleDto {

	private String companyName;
	
	private String jobTitle;
	
	private int numberOfOpenPositions;
	
	private LocalDate createdAt;
	
	private LocalDate deadlineDate;
	
	
}
