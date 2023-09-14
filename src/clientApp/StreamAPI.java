package clientApp;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
	
	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>();

		map.put("anil",1000);
		map.put("basanth",5000);
		map.put("Ganesh",2500);
		map.put("Cris",1500);
		map.put("vinay",2500);
		
		//Map.Entry<String,Integer>  val =map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()).get(1);
		
		Map.Entry<Integer,List<String>>   val = map.entrySet().stream().collect(Collectors.groupingBy(map1 -> map1.getValue(),
								Collectors.mapping(map2 -> map2.getKey(), Collectors.toList()))).entrySet()
				.stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(1);
		
		System.out.println(val);
	}
	
	
}
