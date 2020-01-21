package com.develogical;

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
                String num1 = nums[0].replaceAll("\\s+", "");
                String num2 = nums[1].replaceAll("\\s+", "");
                if (isRootInteger(Integer.parseInt(num1), 2) && isRootInteger(Integer.parseInt(num1), 3)) {
                    return num1;
                } else {
                    return num2;
                }
            } else if (query.toLowerCase().contains("Theresa May")) {
                return "2016";
            } else if (query.toLowerCase().contains("James Bond")) {
                return "Sean Connery";
            } else {
                return "";
            }
        }

    public static boolean isRootInteger(int number, int root) {
        double dResult = Math.pow(number, 1.0 / root);

        if ((dResult == Math.floor(dResult)) && !Double.isInfinite(dResult)) {
            return true;
        }
        return false;
    }
}
