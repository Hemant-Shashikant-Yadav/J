package CollegeDAA.E1;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array = ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
		a[i]=sc.nextInt(); 
        }
	
	System.out.print("Enter the search key = ");
	int key = sc.nextInt();
	binarySearch(a,key,0,a.length-1);
	
    }

    public static void binarySearch(int[] a, int key,int low,int high){
    	int mid = (low+high)/2;
	if(a[mid]==key){
		System.out.println("The key element is found in index :"+mid);
		return;
	}
	else if(a[mid]<key){
		binarySearch(a,key,mid+1,high);
	}
	else
	{
		binarySearch(a,key,low,mid-1);
	}
	
   }	
}
