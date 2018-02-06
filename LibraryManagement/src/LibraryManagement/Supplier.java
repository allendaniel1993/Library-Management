package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Supplier {
	int Supplier_Id;
	String Supplier_Name;
	public Supplier(int supplier_Id, String supplier_Name) {
		super();
		Supplier_Id = supplier_Id;
		Supplier_Name = supplier_Name;
	}
	public int getSupplier_Id() {
		return Supplier_Id;
	}
	public void setSupplier_Id(int supplier_Id) {
		Supplier_Id = supplier_Id;
	}
	public String getSupplier_Name() {
		return Supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		Supplier_Name = supplier_Name;
	}

}
