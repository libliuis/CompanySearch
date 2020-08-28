package CompanySearch;

public abstract class Calculator extends Linker{
	String a;
	String b;
	
	public Calculator(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public abstract String getSql();
}
