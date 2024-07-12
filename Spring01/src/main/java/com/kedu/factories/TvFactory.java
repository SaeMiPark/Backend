package com.kedu.factories;

import com.kedu.beans.LgTV;
import com.kedu.beans.SamsungTV;
import com.kedu.interfaces.TV;

public class TvFactory {
	
	public static TV getTv(String type) {
		if(type.equals("samsung")) {
			return new SamsungTV();
		}else if(type.equals("lg")){
			return new LgTV();
		}else if(type==null) {
			return null;
		}
		
		return null;
	}

}
