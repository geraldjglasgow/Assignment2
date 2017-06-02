/**
 * Created by oit_hd on 6/2/2017.
 * This version of QuickSort chooses the median of the first, middle, and last elements
 * for the pivot.
 */
public class QuickSortM {
    private int a [];

    public QuickSortM(int [] a){
        this.a = a;
        quickSort(0, a.length-1);
    }


    public void quickSort(int start, int end){
        //printArray();
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    public int partition(int start, int end){
        int pivot = getMedian(start, end);

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
    public int getMedian(int start, int end){
        int temp;
        if(a[start] > a[(start+end-1)/2]){
             temp = a[(start+end-1)/2];
            a[(start+end-1)/2] = a[start];
            a[start] = temp;
        }
        if(a[start] > a[end]){
            temp = a[end];
            a[end] = a[start];
            a[start] = temp;
        }
        if(a[(start+end-1)/2] > a[end]){
            temp = a[(start+end-1)/2];
            a[(start+end-1)/2] = a[end];
            a[end] = temp;
        }
        temp = a[(start+end-1)/2];
        a[(start+end-1)/2] = a[start];
        a[start] = temp;
        return a[start];
    }
    public void printArray(){
        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + ", ");
        }
    }


}
