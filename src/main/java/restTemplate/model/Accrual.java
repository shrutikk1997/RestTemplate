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
public class Accrual {

	private String accrualCycle;
	private Integer thresholdLimit;
	private PayoffVariance payoffVariance;
	private Integer graceDays;

}
