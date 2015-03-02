import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

class Paths {
	public Map<String,Set<String>> pathsMap;
	public Set<String> allCities;
	public Paths(){
		pathsMap=new HashMap<String,Set<String>>();
		allCities=new HashSet<String>();
	}
	public boolean hasCity(String city){
		return allCities.contains(city);
	}
	public void addPath(String source, String destination){
		if(source==null || destination==null) return ;
		Set<String> allPaths=new HashSet<String>();
		if(hasCity(source)) allPaths=pathsMap.get(source);
		allPaths.add(new String(destination));
		pathsMap.put(source,allPaths);
		allCities.add(source);
		allCities.add(destination);
	}
	public boolean hasPath(String source,String destination){
		if(!pathsMap.containsKey(source)) return false;
		Set<String> destinations=pathsMap.get(source);
		return destinations.contains(destination);
	}
	public boolean hasAnyPath(String source, String destination){
		return hasPath(source,destination) || hasPath(destination,source);
	}
	public Result search(String source, String destination){
		Result result=new Result();
		result.notFound=hasCity(source)?hasCity(destination)?null:destination:source;
		result.isAvailable=hasPath(source,destination);
		result.entirePath=findPath(source,destination);
		return result;
	}
	public String[] findPath(String source, String destination){
		return null;
	}
	public static void main(String[] args) {
		Paths paths=new Paths();
		paths.addPath("Bangalore","Singapore");
		paths.addPath("Singapore","Seoul");
		paths.addPath("Singapore","Dubai");
		paths.addPath("Seoul","Beijing");
		paths.addPath("Beijing","Tokyo");
		Result result=paths.search(args[0],args[1]);
		System.out.println(result.toString());
	}
}
class Result {
	public boolean isAvailable;
	public String notFound;
	public String[] entirePath;
	@Override
	public String toString(){
		if(notFound!=null) return "No city named \""+notFound+"\" in database";
		if(isAvailable){
			String output="";
			for (String p: entirePath)
				output+=p;
			return output;
		}
		else return "false";
	}
}
