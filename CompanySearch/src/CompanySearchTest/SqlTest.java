package CompanySearchTest;

import static org.junit.Assert.*;

import org.junit.Test;

import CompanySearch.CalculatorContains;
import CompanySearch.CalculatorEqual;
import CompanySearch.CalculatorInequal;
import CompanySearch.LinkerAnd;
import CompanySearch.LinkerOr;
import CompanySearch.LinkerXor;
import CompanySearch.SqlSentence;

public class SqlTest {

	@Test
	public void testAnd() {
		SqlSentence SS = new SqlSentence();
		CalculatorEqual calculatorEqual = new CalculatorEqual("CompanyName", "华泰证券");
		SS.putRequest(calculatorEqual);
		LinkerAnd linkerAnd = new LinkerAnd();
		SS.putRequest(linkerAnd);
		CalculatorInequal calculatorInequal = new CalculatorInequal("Location", "秦淮区");
		SS.putRequest(calculatorInequal);
		assertEquals("GenSql", "Select * from Company_table where CompanyName='华泰证券' and Location<>'秦淮区'", SS.getSqlSentence());
	}
	
	@Test
	public void testOr() {
		SqlSentence SS = new SqlSentence();
		CalculatorEqual calculatorEqual = new CalculatorEqual("CompanyName", "华泰证券");
		SS.putRequest(calculatorEqual);
		LinkerOr linkerOr = new LinkerOr();
		SS.putRequest(linkerOr);
		CalculatorInequal calculatorInequal = new CalculatorInequal("Location", "建邺区");
		SS.putRequest(calculatorInequal);
		assertEquals("GenSql", "Select * from Company_table where CompanyName='华泰证券' or Location<>'建邺区'", SS.getSqlSentence());
	}
	
	@Test
	public void testXor() {
		SqlSentence SS = new SqlSentence();
		CalculatorEqual calculatorEqual = new CalculatorEqual("CompanyName", "华泰证券");
		SS.putRequest(calculatorEqual);
		LinkerXor linkerXor = new LinkerXor();
		SS.putRequest(linkerXor);
		CalculatorInequal calculatorInequal = new CalculatorInequal("Location", "建邺区");
		SS.putRequest(calculatorInequal);
		assertEquals("GenSql", "Select * from Company_table where CompanyName='华泰证券' xor Location<>'建邺区'", SS.getSqlSentence());
	}
	
	@Test
	public void testContains() {
		SqlSentence SS = new SqlSentence();
		CalculatorEqual calculatorEqual = new CalculatorEqual("CompanyName", "华泰证券");
		SS.putRequest(calculatorEqual);
		LinkerXor linkerXor = new LinkerXor();
		SS.putRequest(linkerXor);
		CalculatorContains calculatorContains = new CalculatorContains("Location", "建邺区");
		SS.putRequest(calculatorContains);
		assertEquals("GenSql", "Select * from Company_table where CompanyName='华泰证券' xor CONTAINS(Location,'建邺区')", SS.getSqlSentence());
	}
}
