package exp;
 
import java.util.Scanner;
 
public class Fibonacci{
	public static void main(String[] args){
		try{
			System.out.println("请输入参数：");
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			System.out.println("分治法：Fibonacci(" + n +")=" + fibonacci1(n));
			System.out.println("动态规划法：Fibonacci(" + n +")=" + fibonacci2(n));
		}
		catch(Exception e){
			System.out.println("invalid input.");
		}
	}
//分治法求Fibonacci数列
	public static int fibonacci1(int n){
		if(n==1||n==2){
			return 1;
		}
		return fibonacci1(n-1) + fibonacci1(n-2);
	}
//动态规划法求Fibonacci数列
	public static int fibonacci2(int n)
	{
		int result = 1,f1 = 1,f2 = 1;
		if(n==1||n==2)
		{
			return 1;
		}
		for(int i=3;i<=n;i++)
		{
			result = f1 + f2;
			f1 = f2;
			f2 = result;
		}
		return result;
	}
}
