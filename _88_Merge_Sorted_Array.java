import java.util.Arrays;

public class _88_Merge_Sorted_Array {

  private static void merge(int i, int j, int m, int[] buffer) {
    int arr1Pointer = i;
    int arr2Pointer = m + 1;
    int[] tempBuffer = new int[(j - i) + 1];
    int idx = 0;
    while (arr1Pointer <= m && arr2Pointer <= j) {
      if (buffer[arr1Pointer] <= buffer[arr2Pointer]) tempBuffer[idx++] =
        buffer[arr1Pointer++];
      else tempBuffer[idx++] = buffer[arr2Pointer++];
    }
    while (arr1Pointer < m + 1) tempBuffer[idx++] = buffer[arr1Pointer++];
    while (arr2Pointer < j) tempBuffer[idx++] = buffer[arr2Pointer++];

    idx = i;
    int localIdx = 0;
    while (idx < j + 1) buffer[idx++] = tempBuffer[localIdx++];
  }

  private static void mergeSort(int i, int j, int[] buffer) {
    if (i >= j) return;
    int mid = (j + i) / 2;
    mergeSort(i, mid, buffer);
    mergeSort(mid + 1, j, buffer);
    merge(i, j, mid, buffer);
    System.out.println(Arrays.toString(buffer));
  }

  public static void main(String[] args) {
    int[] arr = { 210, 34, 12, 3, 4, 5, 32, 2 };
    mergeSort(0, arr.length - 1, arr);
  }
}
