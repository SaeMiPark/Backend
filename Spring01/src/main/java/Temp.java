import java.util.HashMap;
import java.util.Map;

public class Temp {

	public static void main(String[] args) {
		//Java의 map == DTO == JavaScript Json
		Map<String, String> map = new HashMap<>(); 
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.get("key1");  //출력 value1
		
		
		for(String key :map.keySet()) {
			System.out.println("key"+key+"value"+map.get(key));
		}
		
	}

}
