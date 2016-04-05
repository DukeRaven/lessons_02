package com.kirill;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kirill on 05.04.2016.
 */
public class Main {

    private static AtomicLong seq = new AtomicLong();

    public static void main(String[] args) {
        //
        long i = seq.getAndIncrement();

        System.out.println("i = " + i);

        i = seq.getAndIncrement();

        System.out.println("i = " + i);
    }

}
