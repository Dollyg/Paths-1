import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest {
	public Paths paths;
	public void setUp(){
		paths=new Paths();
	}
	@Test
	public void addPath_creates_the_path_for_the_given_cities_and_adds(){
		setUp();
		paths.addPath("Bangalore","Singapore");
		Path path1=paths.getPath(0);
		Path path2=new Path("Bangalore","Singapore");
		assertEquals(true,path1.equals(path2));
	}
	@Test
	public void getPath_gives_the_path_at_the_given_index(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Path path1=paths.getPath(0);
		Path path2=new Path("Bangalore","Seoul");
		assertEquals(true,path1.equals(path2));
	}
	@Test
	public void hasPath_gives_true_String_when_the_path_exists_between_two_given_cities(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasPath("Bangalore","Seoul"));
	}
	@Test
	public void hasPath_gives_false_String_when_the_path_does_not_exist(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		paths.addPath("Seoul","Singapore");
		assertEquals(false,paths.hasPath("Bangalore","Singapore"));
	}
}
