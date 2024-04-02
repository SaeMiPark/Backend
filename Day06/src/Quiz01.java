
public class Quiz01 {
	public static int bigger(int a, int b) {
		if(a>b) {
			return a;
		}else if(a<b) {
			return b;
		}else
			return 0;
	}
	
	public static double divide(int a, int b) {
		double result=(double)a/b;
		return result;
	}
	
	
	public static int myRand(int x, int y) {
		int result=(int)(Math.random()*(y-x+1)+x);
		return result;
	}

	public static void main(String[] args) {
		double result=divide(23,6);
		System.out.println(result);
		int result2=bigger(10,20);
		System.out.println(result2);
		int result3=myRand(5,17);
		System.out.println(result3);
	}

}
