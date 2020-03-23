package com.baykalsoft.miscellaneous;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinaryGap {

    // fields used together with @Parameter must be public
    @Parameter(0)
    public int a;
    @Parameter(1)
    public int result;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 10, 5 } };
        return Arrays.asList(data);
    }

    @Test
    public void testBinaryGapSolution() {
        BinaryGap tester = new BinaryGap();
        assertEquals("Result", result, tester.solution(a));
    }

    public static void main(String[] args) {
        new BinaryGap().solution(10);
    }




    String toBinary(int x) {
        char[] buff = new char[32];

        for (int i = 31; i >= 0 ; i--) {
            int mask = 1 << i;
            buff[31 - i] = (x & mask) != 0 ? '1' : '0';
        }

        return new String(buff);
    }

    public int solution (int num)  {


        String bin  = toBinary(num);

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
        return  max;

    }


}
