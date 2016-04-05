package com.kirill.secondtask;

import java.util.Comparator;

/**
 * Created by Khokhlachev on 05.04.2016.
 */
public class LengthComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if ((o1 instanceof  String) && (o2 instanceof  String)) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            if (s1.length() > s2.length())
                return 1;
            else if (s1.length() == s2.length())
                return 0;
            else
                return -1;
        } else {
            return 0;
        }
    }
}
