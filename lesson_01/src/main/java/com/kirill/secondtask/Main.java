package com.kirill.secondtask;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Khokhlachev on 05.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        //first variant
        List<String> s1 = Arrays.asList("aaa", "b", "cd");
        // Should return {b, cd , aaa}
        Collections.sort(s1, new LengthComparator() );
        System.out.println("s1 = " + s1.toString());

        //Second variant
        List<String> s2 = Arrays.asList("aaa", "b", "cd");
        Collections.sort(s2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() == o2.length())
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("s2 = " + s2.toString());
    }
}
