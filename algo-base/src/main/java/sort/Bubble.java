package sort;

import java.util.Arrays;
import java.util.Random;

public class Bubble {

    /**
     * 升序从小到大
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 添加是否已经有序的校验
     *
     * @param arr
     */
    public static void bubbleSortAdv(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        boolean isSort = false;
        for (int i = 0; i < arr.length && !isSort; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                isSort = true;
                if (arr[j] < arr[j - 1]) {
                    isSort = false;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * algorithm: selection sort，选择排序
     * <p>
     * description:
     * 遍历数组array，下标 i 的范围是[0, length)；
     * 当遍历到下标为 i 的元素时，当前元素和 [i, length)中的最小元素交换位置。
     * <p>
     * 通俗的描述是，
     * 遍历数组，选择当前位置到末尾的所有元素中的最小者，与当前元素交换位置
     * 也即是，不断地选择剩余元素（包含当前元素）中的最小者，与当前元素交换位置
     * <p>
     * expense: 时间复杂度 O(n^2)
     * <p>
     * character:
     * 缺点，运行时间与输入无关。
     * 为了找出剩余元素中的最小者而扫描一遍数组，但并不能为下一遍的扫描提供可以利用的信息。
     * 对于一个有序的数组（或者全部元素都相等的数组）和一个元素随机排列的数组所需要的排序时间是一样的。
     * 而其他算法更善于利用输入的初始状态。
     * 优点，数据移动是最少的。
     * 选择排序用了 N 次交换 —— 交换次数和数组的大小是线性相关的。
     * 而其他排序算法的交换次数大多是线性对数或者平方级别的。
     */
    public static void main(String[] args) {
        Random random = new Random();
        int N = 20;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = random.nextInt(100);
        int[] arrAdv = new int[]{2,3,5,6,8,9};
        System.out.println(Arrays.toString(arr));
        Bubble.bubbleSortAdv(arrAdv);
        System.out.println(Arrays.toString(arr));
    }
}
