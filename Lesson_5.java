public class Lesson_5 {

    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();

        for (int  i =0; i<size; i++ ){
           // arr[i]=i;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //System.out.println(" arr0: " + arr[i]);
        }
        System.out.println(" Programm is finished ");

        long b = System.currentTimeMillis();
        float c = b - a;

        System.out.println(" Programm ran 1: " + c );
        long af = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        for (int  j =0; j<h; j++ ) {
            //System.out.println(" arr1 : " +a1[j]);
        }
        for (int  j =0; j<h; j++ ) {
           // System.out.println(" arr2 : " +a2[j]);
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        for (int  j =0; j<size; j++ ) {
           // System.out.println(" arr3 : " + arr[j]);
        }
        long bf = System.currentTimeMillis();
        float cf = bf - af;
        System.out.println(" Programm ran /h: " + cf );
    }
}
