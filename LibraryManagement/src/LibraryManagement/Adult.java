package LibraryManagement;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

public class Adult extends Member{
	
	public Adult() 
	{
		super();
	}

	public Adult(String name) 
	{
		super(name);
	}
	public double adult_membership_Fee(int years)
	{
		return 250.00*years;
	}
	
}
