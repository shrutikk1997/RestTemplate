package restTemplate.model;

import java.util.List;


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
public class InterestPolicy  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dayCountMethod;

	private Integer margin;
	private String roundingOption;

	private String postingExceptionAction;
	private List<InterestMethod> interestMethods;
}
