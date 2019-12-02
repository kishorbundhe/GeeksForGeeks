package Practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person {

    public static void main(String[] args) {
//            int data[]={2010,2012,2014,2015,2014};
//            int key=2014;
//            int count=0;
//            for(int e:data){
//                if(e!=key){
//                    continue;
//                    count++;
//                }
//            }
        LocalDateTime dt = LocalDateTime.of(2014, 7, 31, 1, 1);
        dt.plusDays(30);
        dt.plusMonths(1);
        System.out.println(dt.format(DateTimeFormatter.ISO_DATE_TIME));

        //        float f=2.3f;
//        String mystr="Hello World";
//        int i=mystr.indexOf(" ");
//        System.out.println(i);
//       ArrayList<Integer> points= new ArrayList<>();
//       points.add(1);
//       points.add(2);
//        points.add(3);
//        points.add(4);
//        points.add(null);
//        points.remove(2);
//        points.remove(null);
//        System.out.println(points);
//        int numbers[]=new int[2];
//        numbers[0]=10;
//        numbers[1]=20;
//        numbers=new int[4];
//        numbers[2]=30;
//        numbers[3]=40;
//        for(int x:numbers){
//            System.out.println(""+x);
//        }
    }

}
