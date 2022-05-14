package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        if (N < 1) {
            return new long[0];
        }
        List<Long> numbers = new ArrayList<>();
        for (long i = 1; i < N; i++){
            if (i < 100){
                if (i < 10) numbers.add(i);
                continue;
            }
            byte length = 0;
            if (i < 10000000000L) {
                if (i < 100000) {
                    if (i < 100) {
                        if (i < 10) {
                            length = 1;
                        } else {
                            length = 2;
                        }
                    } else {
                        if (i < 1000) {
                            length = 3;
                        } else {
                            if (i < 10000) {
                                length = 4;
                            } else {
                                length = 5;
                            }
                        }
                    }
                } else {
                    if (i < 10000000) {
                        if (i < 1000000) {
                            length = 6;
                        } else {
                            length = 7;
                        }
                    } else {
                        if (i < 100000000) {
                            length = 8;
                        } else {
                            if (i < 1000000000) {
                                length = 9;
                            } else {
                                length = 10;
                            }
                        }
                    }
                }
            } else {
                if (i < 1000000000000000L) {
                    if (i < 1000000000000L) {
                        if (i < 100000000000L) {
                            length = 11;
                        } else length = 12;
                    } else {
                        if (i < 10000000000000L) {
                            length = 13;
                        } else {
                            if (i < 100000000000000L) {
                                length = 14;
                            } else length = 15;
                        }
                    }
                } else {
                    if (i < 100000000000000000L) {
                        if (i < 10000000000000000L) {
                            length = 16;
                        } else length = 17;
                    } else {
                        if (i < 1000000000000000000L) {
                            length = 18;
                        } else length = 19;
                    }
                }
            }
            long number = 0;
            long firstNumber = i;
            while (firstNumber != 0){
                long figure = (long) (firstNumber % 10);
                firstNumber /= 10;
                if (figure == 0) continue;
                byte e = length;
                long b = 1;
                while(e > 0) {
                    if((e & 1) != 0) {
                        b *= figure;
                    }
                    figure *= figure;
                    e >>= 1;
                }
               number += b;
            }
            if (i == number) {
                numbers.add(i);
            }
        }

        long[] result = new long[numbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }

    private static int get;

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
