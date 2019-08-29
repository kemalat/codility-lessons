package com.baykalsoft;

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
        Object[][] data = new Object[][] { { 1977, 5 } };
        return Arrays.asList(data);
    }

    @Test
    public void testBinaryGapSolution() {
        BinaryGap tester = new BinaryGap();
        assertEquals("Result", result, tester.solution(a));
    }

    public int solution (int num)  {


        String bin  = Integer.toBinaryString(num);

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