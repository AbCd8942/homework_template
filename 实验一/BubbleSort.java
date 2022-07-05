package exp;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
public class BubbleSort {
	public static void maopao(int []a) {         
		for(int i=0;i<a.length-1;i++) {
			for(int j =0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}

	}

	public static  void main(String[] args) {		
		
		System.out.println("请输入数组中的数(并以空格为分界)");    //把输入的字符串弄成数组
		Scanner a = new Scanner(System.in);
		String b =a.nextLine().toString();
		String []c = b.split(" ");
		int []d = new int[c.length];
		for(int j =0;j<d.length;j++) {
			d[j]=Integer.parseInt(c[j]);	
		}
				
		maopao(d);
				
		System.out.println("结果为："+Arrays.toString(d));		
	}
}
