package Umbrella;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter number of elements in array = ");
        a = sc.nextInt();
        int b[] = new int[a];
        System.out.print("Enter elements of array = ");
        for (int i = 0; i <  b.length; i++) {
            b[i] = sc.nextInt();
        }
        System.err.println("Enter number = ");
        int c = sc.nextInt();
        for (int i = 0; i < b.length-1; i++) {
            for (int j = 1; j < b.length; j++) {
                if ((b[i]+b[j])==c) {
                    System.err.println("("+i+","+j+")");
                    System.exit(0);
                }
            }
        }
    }
}
