package com.baykalsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OddOccurence {


  public static void main(String[] args) {
    int[] a = {9, 3, 9, 3, 9, 7, 9};
    List<Integer> list = new ArrayList<>();

    for (int e : a) {
      list.add(Integer.valueOf(e));
    }
    System.out.println(list);

    int pos0 = 0;
//    a = list.get(pos0);

    int i = 0;
    boolean counted;

    HashMap<Integer, Integer> elementFound = new HashMap<>();
    for (int b : list) {

      for (int e : list) {
        if (e == b)
          i++;
      }
      elementFound.put(b,i);
      System.out.println(i);
      i = 0;
    }

    System.out.println(elementFound);


//    System.out.println(list);
//    System.out.println(list.indexOf(9));
//    System.out.println(list.);
//    System.out.println(list.lastIndexOf(9));


  }


}
