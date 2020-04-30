package com.baykalsoft.recursive;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SockMerchant {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] arr) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int result = 0;

    for (int i = 0; i < arr.length; i++) {

      if(map.containsKey(arr[i])) {
        int count = map.get(arr[i]);
        map.replace(arr[i],count+1);
      } else
        map.put(arr[i],1);
    }
    System.out.println(map);
    Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, Integer> entry = iterator.next();
      if(entry.getValue() >=2) {
        result = entry.getValue() / 2 +result;
      }
    }
    System.out.println(result);

    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    int n = scanner.nextInt();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    int[] ar = new int[n];
//
//    String[] arItems = scanner.nextLine().split(" ");
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    for (int i = 0; i < n; i++) {
//      int arItem = Integer.parseInt(arItems[i]);
//      ar[i] = arItem;
//    }
    int n = 10;
    int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20,50,20};

    int result = sockMerchant(n, ar);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//
//    scanner.close();
  }
}
