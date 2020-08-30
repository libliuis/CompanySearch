package CompanySearch;

public class CalculatorContains extends Calculator{
	public CalculatorContains(String a, String b) {
		super(a, b);
	}
	
	@Override
	public String getSql() {
		return "CONTAINS(" + this.a + "," + "'" + this.b + "'" + ")";
	}
}
