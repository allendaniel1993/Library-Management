

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Room {

	int room_Number;
	boolean allocated;
	
	public Room(int room_Number, boolean allocated) {
		super();
		this.room_Number = room_Number;
		this.allocated = allocated;
	}
	
	public int getRoom_Number() {
		return room_Number;
	}
	
	public void setRoom_Number(int room_Number) {
		this.room_Number = room_Number;
	}
	
	public boolean get_Allocated() {
		return allocated;
	}
	
	public void set_Allocated(boolean allocated) {
		this.allocated = allocated;
	}
	
	
}
