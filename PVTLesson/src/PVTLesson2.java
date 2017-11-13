public class PVTLesson2 {
    /**
     * Коментарии для документации
     * @param args
     */

    public static void main(String[] args) {
        int[] array = new  int[5];
        array[0] = 1;
        array[1] = 5;
        array[2] = 10;
        array[3] = 15;
        array[4] = 20;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum= 0;



        for (int i = 0; i < array.length; i++)
            {
                sum = sum + array[i];
                if (array[i]> max) max = array[i];
                if (array[i]< min) min = array[i];
            }
        double avg = (double)sum/array.length;
        System.out.println(sum);
        System.out.println("averege = " + avg);
        System.out.println("max = " + max);
        System.out.println("min = " + min);

        //    for (int i = 0; i< array.length; i++) {
   //         System.out.println("i = " + i);
   //         System.out.println(array[i]);
   //     }

 //       for (int i = array.length - 1; i >= 0; i--)
   //     {
     //       System.out.println(array[i]);
     //   }

       // for (int value: array){
      //      System.out.println(value);
     //   }

     //   int i =0;
     //   while(i < array.length){
     //       System.out.println(array[i]);
     //       i++;
    //    }

    //    do {

    //    }while (false);


        System.out.println("Finish");

    String s = String.valueOf(sum);
        System.out.println(args[0] + args[1]);
    }

}
