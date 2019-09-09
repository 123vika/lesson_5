public class Lesson_5_2 {

    static class SampleThread extends Thread {
        int processingCount;
        float[] arr;

        SampleThread(int processingCount,float[] arr) {
            this.processingCount = processingCount;
            this.arr = arr;
        }
        @Override
        public void run() {

            method(arr);
        }
    }
    /*  static class ToThread implements Runnable {
        @Override
        public void run() {
            final int size = 10;//000000;
            final int h = size / 2;
            float[] arr = new float[size];

            float[] a1 = new float[h];
            float[] a2 = new float[h];

            long af = System.currentTimeMillis();

            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);

            for (int  j =0; j<h; j++ ) {
                System.out.println(" arr1 : " +a1[j]);
            }

            for (int  j =0; j<h; j++ ) {
                System.out.println(" arr2 : " +a2[j]);
            }

            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            for (int  j =0; j<size; j++ ) {
                System.out.println(" arr3 : " + arr[j]);
            }
            long bf = System.currentTimeMillis();
            float cf = bf - af;
            System.out.println(" Programm ran : " + cf );
        }
    }*/
    public static void main(String[] args) {
       // new Thread(new method()).start();
       // new Thread(new ToThread()).start();

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.out.println(" i'm  here: " );
        long startTime = System.currentTimeMillis();
        
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

   /*     for (int  j =0; j<h; j++ ) {
            System.out.println(" arr1 : " +a1[j]);
        }

        for (int  j =0; j<h; j++ ) {
            System.out.println(" arr2 : " +a2[j]);
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        for (int  j =0; j<size; j++ ) {
            System.out.println(" arr3 : " + arr[j]);
        }
        long bf = System.currentTimeMillis();
        float cf = bf - af;
        System.out.println(" Programm ran : " + cf );
        */
       // new Thread(() -> method(a1)).start();
       // new Thread(() -> method(a2)).start();

        SampleThread t1 = new SampleThread(1,a1);
        SampleThread t2 = new SampleThread(1,a2);

        t1.start();
        t2.start();
       // t1.join();
        try
        {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            t1.join();
        }
        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        try
        {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            t2.join();
        }
        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(" total time is  : " + (endTime-startTime) );
    }

    public synchronized static void method(float[] arr  ) {
        System.out.println("start");

        for (int  i =0; i<arr.length; i++ ){

            // arr[i]=i;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //System.out.println(" arr0: " + arr[i]);
        }


        System.out.println("end");
    }
}
