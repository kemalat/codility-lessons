package com.baykalsoft.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InversionCount {



  public int[] solutionBubble (int[] arr)  {

    int n = arr.length;
    int temp = 0;
    for(int i=0; i < n; i++){
      for(int j=1; j < (n-i); j++){
        if(arr[j-1] > arr[j]){
          //swap elements
          temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
//          System.out.println("swap pairs "+arr[j-1]+":"+arr[j]);
        }

      }
    }
    List<Integer> list = Arrays.stream(arr)
        .boxed()
        .collect(Collectors.toList());

    System.out.println(list);
    return  arr;
  }


  public static void main(String[] args) {
    int[] A  ={2, 5, 3, 1,10};
    new InversionCount().solutionBubble(A);
  }






  }



