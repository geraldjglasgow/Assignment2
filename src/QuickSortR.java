import java.util.Random;

/**
 * Created by oit_hd on 6/2/2017.
 */

public class QuickSortR {
    private int a [];
    Random rnd = new Random();

    public QuickSortR(int [] a){
        this.a = a;
        quickSort(0, a.length-1);
    }


    public void quickSort(int start, int end){
        printArray();
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    public int partition(int start, int end){
        int pivot = getRandom(start, end);
        while(start<=end){
            while(a[start] < pivot){
                start++;
            }
            while(a[end] > pivot){
                end--;
            }
            if(start <= end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++; end--;
            }
        } // end while
        return start;
    }
    public int getRandom(int start, int end){
        int temp = a[rnd.nextInt(end-start)+start];
        a[rnd.nextInt(end-start)+start] = a[start];
        a[start] = temp;
        return a[start];
    }
    public void printArray() {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
