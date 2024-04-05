package exams;
import classes.Product;

public class Exam01 {
	public static void main(String[] args) {
		Product[] products=new Product[3];
		
		products[0]=new Product("1","사과",1000,0);
		products[1]=new Product("2","딸기", 2000, 2);
		products[2]=new Product("3","배", 1500, 1);
		
		for(int i=0; i<products.length; i++) {
			System.out.println(products[i]);
		}
		
		
		Product[] pro=new Product[] {
				new Product("1001","LG-GRAM",150000,12),
				new Product("1002","IPad",180000,15),
				new Product("1003","samsung",200000,20),		
		}; //끝에 세미콜론!!
		
		for(int i=0; i<pro.length; i++) {
			System.out.println(pro[i]);
		}
		

	}

}
