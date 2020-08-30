package CompanySearch;

public class CalculatorInequal extends Calculator{
	public CalculatorInequal(String a, String b) {
		super(a, b);
	}
	
	public String getSql() {
		return this.a + "<>" + "'" + this.b + "'";
	}
}
