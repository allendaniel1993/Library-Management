

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Student extends Member{
	
	private int Student_Id;
	
	public Student() 
	{
	
	}
	
	public Student(String name,int id) 
	{
		super(name);
		this.Student_Id =id;
	}
	
	public int getStudent_Id() {
		return Student_Id;
	}

	public void setStudent_Id(int student_Id) {
		Student_Id = student_Id;
	}

	public double student_membership_Fee(int years)
	{
		return years*100.00;
	}
}
