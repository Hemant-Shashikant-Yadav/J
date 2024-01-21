package CollegeDAA.E1;

public class MinMax {
    static class minMax{
        int min,max;
    }
    static minMax findMinMax( int[] arr, int low, int high){
        minMax minmax = new minMax();
        minMax minmaxleft = new minMax();
        minMax minmaxright = new minMax();

        if (low == high){
            minmax.min = arr[low];
            minmax.max = arr[low];
            return  minmax;
        }
        if (high == low+1){
            if (arr[low]<arr[high]){
                minmax.max = arr[high];
                minmax.min = arr[low];
                return  minmax;
            }
            else {
                minmax.min= arr[high];
                minmax.max = arr[low];
                return  minmax;
            }
        }

        int mid  = (low+high)/2;
        minmaxleft = findMinMax(arr,low,mid);
        minmaxright = findMinMax(arr,mid+1,high);

        if (minmaxleft.min< minmaxright.min){
            minmax.min = minmaxleft.min;
        }
        else {
            minmax.min = minmaxright.min;
        }
        if (minmaxleft.max> minmaxright.max){
            minmax.max= minmaxleft.max;
        }
        else {
            minmax.max = minmaxright.max;
        }

        return minmax;

    }
    public static void main(String[] args) {
        int[] arr = {12,233,5,87,34,877,2};
        minMax MINMAX = findMinMax(arr,0,6);
        System.out.println(MINMAX.max+" "+MINMAX.min);
    }
}
