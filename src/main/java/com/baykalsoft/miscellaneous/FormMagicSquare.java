package com.baykalsoft.miscellaneous;

import java.io.IOException;
import java.util.Scanner;

public class FormMagicSquare {

  // Complete the formingMagicSquare function below.
  static int formingMagicSquare(int[][] s) {


    int[][] a = new int[][]{
        { 4, 8, 2},
        { 4, 5, 7},
        { 6, 1, 6}
    };

//    { 4, 9, 2},
//    { 3, 5, 7},
//    { 8, 1, 6}

    int x  = a[0][0]+ a[0][1]+ a[0][2];
    int y  = a[1][0]+ a[1][1]+ a[1][2];
    int z  = a[2][0]+ a[2][1]+ a[2][2];

    int p  = a[0][0]+ a[1][0]+ a[2][0];
    int o  = a[0][1]+ a[1][1]+ a[2][1];
    int r  = a[0][2]+ a[1][2]+ a[2][2];

    int k = 0 ;

    for(int i=0; i < 3; i++) {
      for(int j=0; j < 3; j++) {
         k = a[i][j]+k;
      }
      System.out.println("k = " + k);
      k = 0;
    }

    System.out.println("\n");

    int l = 0;
    for(int i=0; i < 3; i++) {
      for(int j=0; j < 3; j++) {
        l = a[j][i]+l;
      }
      System.out.println("l = " + l);
      l = 0;
    }

      boolean find = false;
      for(int i=0; i < 3; i++) {
        for(int j=0; j < 3; j++) {
          for(int q=1;  q < 10; q++) {
            if(a[i][j] == q){
            }
          }
        }
      }





//    System.out.println("x = " + x);
//    System.out.println("y = " + y);
//    System.out.println("z = " + z);
//
//    System.out.println("p = " + p);
//    System.out.println("o = " + o);
//    System.out.println("r = " + r);


    return 0;
  }

  private static final Scanner scanner = new Scanner(System.in);


  static int getMissingNo(int a[], int n)
  {
    int i, total;
    total = (n + 1) * (n + 2) / 2;
    for (i = 0; i < n; i++)
      total -= a[i];
    return total;
  }


  public static void main(String[] args) throws IOException {

    int a[] = { 1, 2, 4 };
    int miss = getMissingNo(a, 3);
    System.out.println(miss);
  }
}
