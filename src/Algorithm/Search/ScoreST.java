package Algorithm.Search;

import Algorithm.Fundamental.BinarySearch;

import java.util.HashMap;
import java.util.Scanner;

public class ScoreST {


//    private class Grade implements Comparable<Grade> {
//        //There is level and subLevel contained, for example A+,A is level,+ is subLevel
//        private String level;
//        private String subLevel;
//
//        public Grade(String level, String subLevel) {
//            this.level = level;
//            this.subLevel = subLevel;
//        }
//
//        @Override
//        public int compareTo(Grade o) {
//            //If level and subLevel are equal,then are the same grade
//            if(level.equals(o.level)) {
//                if(subLevel.equals(o.subLevel)) {
//                    return 1;
//                } else if () {
//
//                }
//            } else {
//
//            }
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof Grade) {
//                Grade newGrade = (Grade) obj;
//                return this.level.equals(newGrade.level) && this.subLevel.equals(newGrade.subLevel);
//            }
//            return false;
//        }
//    }


    public static void main(String[] args) {
        var st = new BinarySearchST<String,Double>(10);

        var myScanner = new Scanner(System.in);

        var buffer = "";

        while(!((buffer = myScanner.nextLine()).equals("quit"))) {
            var strArr = buffer.split(",");
            String key = strArr[0];
            Double value = Double.valueOf(strArr[1]);
            st.put(key, value);
        }


        for(String index : st.keys(st.min(),st.max())) {
            System.out.println(index);
            System.out.println(st.get(index));
        }
    }

}
