package HW_5;
public class Task_3 {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 7, 9, 6, 4, 500, 2, 1, 33 };
        headSort(arr);
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void headSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }

    }

    public static void heapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int lergest = i;

        if (l < n && arr[l] > arr[lergest])
            lergest = l;
        if (r < n && arr[r] > arr[lergest])
            lergest = r;

        if (i != lergest) {
            int temp = arr[i];
            arr[i] = arr[lergest];
            arr[lergest] = temp;

            heapify(arr, lergest, n);
        }
    }
}
