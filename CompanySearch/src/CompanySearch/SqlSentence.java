package CompanySearch;

import java.util.ArrayList;
import java.util.Iterator;

public class SqlSentence {
	ArrayList<Linker> AO = new ArrayList<Linker>();
	
	public void putRequest(Linker linker) {
		this.AO.add(linker);
	}
	
	public String getSqlSentence() {
		String sqlSentence = "Select * from Company_table where ";
		Iterator<Linker> ite = AO.iterator();
		for(;ite.hasNext();) {
			Linker SS =  ite.next();
			sqlSentence += SS.getSql();
		}
		return sqlSentence;
	}
}
