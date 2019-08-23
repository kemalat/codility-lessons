package com.baykalsoft;

public class BinaryGap {


    public static void main(String[] args) throws InterruptedException {



//        int num = 1977;
//        System.out.println("Binary is " + Integer.toBinaryString(num));
//        String bin  = Integer.toBinaryString(num);
        String bin  = "1110001000001";

        int pos0 = 0, max = 0;
        while(bin.indexOf('0',pos0) > 0) {

            int start = bin.indexOf('0',pos0);
            int end = bin.indexOf('1',start);
            int len = end -start;
            System.out.println(len);
            pos0 = end;
            System.out.println(bin.indexOf('0',pos0));
            if(len > max)
                max = len;

        }
        System.out.println("max len "+max);


//        int pos0 = 0;
//        int start = bin.indexOf('0',pos0);
//        int end = bin.indexOf('1',start);
//        int len = end -start;
//        System.out.println(len);
//        pos0 = end;
//        System.out.println(bin.indexOf('0',pos0));
//        start = bin.indexOf('0',pos0);
//        end = bin.indexOf('1',start);
//        len = end -start;
//        System.out.println(len);
//        pos0 =end;
//        System.out.println(bin.indexOf('0',pos0));


//        System.out.println(bin.indexOf('1',4));
//        int len = end -start;
//        System.out.println(len);
//
//        int max = 0;
//        while(true) {
//            System.out.println(bin.indexOf('0'),);
//            System.out.println(bin.indexOf('1',4));
//            int start = bin.indexOf('0');
//            int end = bin.indexOf('1',start);
//            int len = end -start;
//            if(len > max)
//                max= len;
//
//            Thread.sleep(1000);
//
//        }


    }

}