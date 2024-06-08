package BinarySearch2D;
public class BinarySearch2D {

    /**
     * Search an item with binarySearch algorithm.
     *
     * @param matrix should be sorted
     * @param target an item to search
     * @return if location of item is found, otherwise return {-1,-1}
     */
    public static int[] binarySearchIn2darr(int[][] matrix, int target) {
      int rows = matrix.length - 1;
      int cols = matrix[0].length - 1;
  
      if (rows == 1) {
        return binarySearch(matrix, target, 0, 0, cols);
      }
  
      int rstart = 0;
      int rend = rows;
      int cmid = cols / 2;
  
      while (rstart < rend - 1) {
        int rmid = rstart + (rend - rstart) / 2;
        if (matrix[rmid][cmid] > target) {
          rend = rmid;
        } else if (matrix[rmid][cmid] < target) {
          rstart = rmid;
        } else {
          return new int[]{rmid, cmid};
        }
      }
      if (matrix[rstart][cmid] == target) {
        return new int[]{rstart, cmid};
      }
      if (matrix[rend][cmid] == target) {
        return new int[]{rend, cmid};
      }
      if (target <= matrix[rstart][cmid - 1]) {
        return binarySearch(matrix, target, rstart, 0, cmid - 1);
      }
      if (target >= matrix[rstart][cmid + 1]) {
        return binarySearch(matrix, target, rstart, cmid + 1, cols);
      }
      if (target <= matrix[rend][cmid - 1]) {
        return binarySearch(matrix, target, rend, 0, cmid - 1);
      }
      if (target <= matrix[rend][cmid + 1]) {
        return binarySearch(matrix, target, rend, cmid + 1, cols);
      }
      return new int[]{-1, -1};
    }
  
    static int[] binarySearch(int[][] matrix, int target, int row, int cstart, int cend) {
      while (cstart <= cend) {
        int cmid = cstart + (cend - cstart) / 2;
        if (matrix[row][cmid] > target) {
          cend = cmid - 1;
        } else if (matrix[row][cmid] < target) {
          cstart = cmid + 1;
        } else {
          return new int[]{row, cmid};
        }
      }
      return new int[]{-1, -1};
    }
  
    public static void main(String[] args) {
      int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
      };
      int target = 3;
      int[] result = binarySearchIn2darr(matrix, target);
      System.out.println("Found at: [" + result[0] + ", " + result[1] + "]");
    }
  }
  