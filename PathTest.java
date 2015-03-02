import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {
	@Test
	public void new_Path_gives_a_new_path_with_given_cities(){
		Path path=new Path("Bangalore","Singapore");
		assertEquals(true,path.equals(new Path("Bangalore","Singapore")));
	}
	@Test
	public void path_A_to_B_and_path_B_to_A_are_different(){
		Path path=new Path("Bangalore","Singapore");
		assertEquals(false,path.equals(new Path("Singapore","Bangalore")));
	}
}
