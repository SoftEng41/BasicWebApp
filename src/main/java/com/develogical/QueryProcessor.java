package com.develogical;

import java.util.*;

public class QueryProcessor {

    public String process(String query) {
            if (query.toLowerCase().contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            } else if (query.toLowerCase().contains("hang")) {
                return "Hang Li Li is a Computing student at Imperial College London";
            } else if (query.toLowerCase().contains("largest")) {
                String[] parts = query.split(":");
                String[] nums = parts[2].split(",");
                Integer max = Integer.MIN_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    max = Math.max(max, Integer.parseInt(nums[i].replaceAll("\\s+", "")));
                }
                return max.toString();
            } else if (query.toLowerCase().contains("plus")) {
                String[] s = query.toLowerCase().split("is");
                String[] s1 = s[1].split("plus");
		        return "" + (Integer.parseInt(s1[0].replaceAll("\\s+", "")) + Integer.parseInt(s1[1].replaceAll("\\s+", "")));
            } else if (query.toLowerCase().contains("multiplied")) {
                String[] s = query.toLowerCase().split("is");
                String[] s1 = s[1].split("multiplied by");
                return "" + (Integer.parseInt(s1[0].replaceAll("\\s+", "")) * Integer
                        .parseInt(s1[1].replaceAll("\\s+", "")));
            } else if (query.toLowerCase().contains("minus")) {
                String[] s = query.toLowerCase().split("is");
                String[] s1 = s[1].split("minus");
                return "" + (Integer.parseInt(s1[0].replaceAll("\\s+", "")) - Integer
                        .parseInt(s1[1].replaceAll("\\s+", "")));
            } else if (query.toLowerCase().contains("square") && query.toLowerCase().contains("cube")) {
                String[] parts = query.split(":");
                String[] nums = parts[2].split(",");
                for (int i = 0; i < nums.length; i++) {
                    String num = nums[i].replaceAll("\\s+", "");
                    if (isRootInteger(Integer.parseInt(num), 2) && isRootInteger(
                            Integer.parseInt(num), 3)) {
                        return num;
                    }
                }
                return "";
                // /api/?q=1c3d9be0:%20what%20is%20the%2017th%20number%20in%20the%20Fibonacci%20sequence
            } else if (query.toLowerCase().contains("fibonacci")) {
                String[] s = query.toLowerCase().split("the");
                String[] s1 = s[1].split("th");
                String num = s1[0].replaceAll("\\s+", "");
                return String.valueOf(fib(Integer.parseInt(num)));
            } else if (query.toLowerCase().contains("theresa may")) {
                return "2016";
            } else if (query.toLowerCase().contains("james bond")) {
                return "Sean Connery";
                // 3e0:%20which%20of%20the%20following%20numbers%20are%20primes:%20539,%20541"
            } else if (query.toLowerCase().contains("primes")) {
                String[] parts = query.split(":");
                String[] nums = parts[2].split(",");
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    String num = nums[i].replaceAll("\\s+", "");
                    if (isPrime(Integer.parseInt(num))) {
                        list.add(Integer.parseInt(num));
                    }
                }
                return list.toString();
            } else if (query.toLowerCase().contains("banana")) {
                return "yellow";
            } else if (query.toLowerCase().contains("eiffel")) {
                return "Paris";
            }  else {
                return "";
            }
        }

    private static boolean isRootInteger(int number, int root) {
        double dResult = Math.pow(number, 1.0 / root);

        if ((dResult == Math.floor(dResult)) && !Double.isInfinite(dResult)) {
            return true;
        }
        return false;
    }

    private static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    private static int fib(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
