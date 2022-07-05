package exp;

import java.util.Random;

public class DivideAndConquer {
	public static void main(String[] args) {
		//生成一百个随机数，放入数组，然后排序输出。
		Random random = new Random();
		int [] arr = new int[100];//动态初始化一个长度为100的数组
		int [] arr1,arr2,arr3 = new int[100];//存放三种排序方法的结果
		for (int i = 0; i <arr.length ; i++) {   // 调用Random 通过遍历的形式为数组赋初值。
			arr[i]  = random.nextInt(100);
		}
		System.out.print("原数组：");
		for (int i = 0; i < arr.length; i++) {
		     System.out.print(arr[i]+" ");
		}
		System.out.println();
        arr1=BubbleSort(arr);
        System.out.print("冒泡排序之后的数组：");
        for (int i = 0; i < arr1.length; i++) {
           System.out.print(arr1[i]+" ");
        }
		System.out.println();
        arr2=MergeSort(arr);
        System.out.print("合并排序之后的数组：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
		System.out.println();
		arr3=QuickSort(arr, 0, arr.length - 1);
		System.out.print("快速排序之后的数组：");
		for (int i = 0; i < arr3.length; i++) {
		    System.out.print(arr3[i]+" ");
		}
	}
	
	public static int[] BubbleSort(int []a) {//冒泡排序      
		for(int i=0;i<a.length-1;i++) {
			for(int j =0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a;
	}
	
	private static int[] MergeSort(int[] arr) {//存放合并排序的结果
	    mergeSort(arr, 0, arr.length - 1);
	    return arr;
	}
    //将tmp和Cctr当做参数传入，方便调用merge方法时获得这两个参数
    private static void mergeSort(int[] arr, int left, int right) {//合并排序
        int mid = (left + right) / 2;
        //当分到只剩下一个元素的情况,则退出递归程序
        if (left >= right) {
           return;
        }
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        //声明三个计时器
        int Actr = left;
        int Bctr = mid + 1;
        int Cctr = 0;
        //创建临时数组,长度为A，B数组长度之和
        int[] tmp = new int[right - left + 1];
        //循环A，B中长度较短的长度次数的二倍的次数
        while (Actr <= mid && Bctr <= right) {
            if (arr[Actr] <= arr[Bctr]) {
                tmp[Cctr++] = arr[Actr];
                Actr++;
            } else {
                tmp[Cctr++] = arr[Bctr];
                Bctr++;
            }
        }
        //如果左边的还有剩余，将左边剩余的合并
        while (Actr <= mid){
            tmp[Cctr ++] = arr[Actr ++];
        }
        //如果右边的还有剩余，将右边剩余的合并
        while (Bctr <= right){
            tmp[Cctr ++] = arr[Bctr ++];
        }
        //将临时数组更新到原数组
        for (int i = 0; i < tmp.length; i++) {
            arr[left++] = tmp[i];
        }
    }
    
    public static int[] QuickSort(int arr[],int left,int right) {//快速排序
        int pivot = arr[left];//轴值
        int i = left;//左下标
        int j = right;//右下标
        while (i < j) {
            //在右边找到一个比中值小或者相等的值
            while (i < j && arr[j] > pivot) {
                j--;
            }
            //在左边找到一个比中值大或者相等的值
            while (i < j && arr[i] < pivot) {
                i++;
            }
            //在i和j没有相遇时，如果 arr[i] == arr[j] 此时让i+1
            //即让arr[i+1] 与arr[j]进行交换 ，使两个相同的数在一起
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {//交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //左半部递归
        if (i-1 > left) {
            arr=QuickSort(arr,left,i-1);
        }
        //右半部递归
        if (j+1 < right) {
            arr=QuickSort(arr,j+1,right);
        }

        return arr;
    }
}
