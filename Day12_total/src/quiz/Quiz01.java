package quiz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz01 {
	public static void main(String[] args) throws ParseException {
		String str="1919년03월01일";
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
		Date date=sdf.parse(str);
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd(E)");
		String result=sdf2.format(date);
		
		System.out.println(result);
	}

}
