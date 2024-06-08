package BinarySearch;

public class BS {

    /**
     * Search an item with binarySearch algorithm.
     *
     * @param arr sorted array to search
     * @param item an item to search
     * @return if item is found, return the index position of the array item otherwise return -1
     */
  
    public static int binarySearch(int[] arr, int left, int right, int item) {
      if (right >= left) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == item) {
          return mid;
        }
  
        if (arr[mid] > item) {
          return binarySearch(arr, left, mid - 1, item);
        }
  
        return binarySearch(arr, mid + 1, right, item);
      }
      return -1;
    }   
  }