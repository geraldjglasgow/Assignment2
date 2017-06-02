/**
 * Created by oit_hd on 6/2/2017.
 *
 * This class is meant to QuickSort an array with the pivot value being
 * the first element in the array.
 */
public class QuickSortF {

    private int a [];

    public QuickSortF(int [] a){
        this.a = a;
        quickSort(0, a.length-1);
    }


    public void quickSort(int start, int end){
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    public int partition(int start, int end){
        int pivot = a[start];
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
}
