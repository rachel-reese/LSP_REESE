package org.howard.edu.lsp.finalExam;

import java.util.HashMap;

public class MapUtilities {
	public static int commonKeyValuePairs(
	        HashMap<String, String> map1,
	        HashMap<String, String> map2)throws NullMapException {
			if (map1 == null || map2 == null) {
				throw new NullMapException("One or both maps are null!");
			}
			else if (map1.isEmpty() || map2.isEmpty()) {
				return 0;
			}
			Integer inCommon = 0;
			HashMap<String, String> newMap1 = new HashMap<String, String>();
			HashMap<String, String> newMap2 = new HashMap<String, String>();
			for(String i: map1.keySet()) {
				newMap1.put(i.toLowerCase(), map1.get(i));
			}
			for(String i: map2.keySet()) {
				newMap2.put(i.toLowerCase(), map2.get(i));
			}
				for(String i: newMap1.keySet()) {
					if (newMap2.containsKey(i)) {
						if(newMap1.get(i).toLowerCase().equals(newMap2.get(i).toLowerCase())) {
							inCommon += 1;
						}
					}
				}
		
				return inCommon;
	    }

}
