package commons;

import org.apache.commons.dbcp2.BasicDataSource;

public class Statics {
	public static BasicDataSource bds=new BasicDataSource(); //베이직으로부터 커넥션을 빌려올 것.
	
	//생성자에 넣어주면 딱 한번 실행되고 말 수 있다.
	//static -> 메인이 시작될 때 알아서 적용되는
		static {
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bds.setUsername("keduu");
			bds.setPassword("keduu");
			bds.setInitialSize(20); //만들어 놓을 커넥션 사이즈
		}
}
