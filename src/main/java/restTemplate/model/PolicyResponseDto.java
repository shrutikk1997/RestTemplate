package restTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponseDto {

	private Integer id;
	private String version;
	private String creationDate;
	private String modificationDate;
	private String validFrom;
	private String validTill;

	private String ifi;
	private InterestPolicy attribute;

}
