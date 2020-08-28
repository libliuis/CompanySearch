package CompanySearch;

public class CalculatorEqual extends Calculator{
	public CalculatorEqual(String a, String b) {
		super(a, b);
	}
	
	@Override
	public String getSql() {
		return this.a + "=" + this.b;
	}
}
