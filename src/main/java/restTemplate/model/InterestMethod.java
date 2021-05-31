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
public class InterestMethod {
	private String postingCategory;
	private String rateTableId;
	private Computation computation;
	private Accrual accrual;
	private Liquidation liquidation;
}
