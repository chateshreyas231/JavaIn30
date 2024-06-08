package BubbleSort;

public class BS {

    /**
     * Sort an array with bubbleSort algorithm.
     *
     * @param arr array to sort
     */
    public static void bubbleSort(int[] arr) {
      var lastIndex = arr.length - 1;
  
      for (var j = 0; j < lastIndex; j++) {
        for (var i = 0; i < lastIndex - j; i++) {
          if (arr[i] > arr[i + 1]) {
            var tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
          }
        }
      }
    }
  }