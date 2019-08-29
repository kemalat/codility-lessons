package com.baykalsoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {

  public int[] solution (int[] A, int K)  {

    List<Integer> list = Arrays.stream(A)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(list);

    for (int i = 0; i < K; i++) {
      int last = list.remove(list.size()-1);
      list.add(0,last);

    }

    int[] array = list.stream().mapToInt(i->i).toArray();
    System.out.println();
    return array;
  }


  public static void main(String[] args) {
    int[] a = {3,8,9,7,6};
    List<Integer> list = Arrays.stream(a)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(list);

    for (int i = 0; i < 3; i++) {
      int last = list.remove(list.size()-1);
      list.add(0,last);

    }

    System.out.println(list);


    //
//    for (int e : a) {
//      list.add(Integer.valueOf(e));
//    }
//
//    for (int e : a) {
//      list.add(Integer.valueOf(e));
//    }





  }


}
