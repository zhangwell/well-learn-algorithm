package sort.select;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangwei02
 * @version 1.0.0
 * @ClassName HeapSort.java
 * @Description TODO
 * @createTime 2022年03月01日 10:57:00
 */
public class HeapSort {

    public static void sort (Comparable[] arr){
        if (arr == null || arr.length < 2) return;

        // 自底向上使每一个有孩子的结点都成为一个有序堆（宏观角度）
        for (int i = arr.length/2-1; i >= 0; i --)  // 完全二叉树中最后一个非叶子结点是 N/2-1
            maxHeapify(arr, i, arr.length);

        // 循环地将剩余的元素堆化
        // 下面的程序基础是，只有根结点相对孩子结点是无序的，也就只需要把该根结点移动到合适的位置即可
        for (int j = arr.length - 1; j > 0; j --) {
            swap(arr, 0, j);  // 将最大元素放在数组末尾，也就是堆首元素不断和堆尾元素交换位置，堆的大小减 1
            maxHeapify(arr, 0, j);  // 将去掉一个元素的新堆调整为最大堆（有序堆）
        }
    }


    /**
     * 从上到下有序化堆，使小于孩子的父结点下沉（sink）
     * 此时，根结点的左右子树都是最大堆，只有根结点相对于左右孩子结点是无序的，
     * 也就只需要把该根结点移动至合适的位置即可，因此不需要递归操作
     *
     * 过程：
     *      当前根结点是否有左孩子，则执行下面两个步骤：
     *          当前根结点与其左右孩子中的较大者交换位置；
     *          并将当前结点左右孩子的较大者设置为新的需要排序的根结点；
     *
     * @param arr 二叉堆
     * @param index 待调整的子堆的根结点
     * @param newSize 除了排序后的元素外，堆中剩余元素的个数
     */
    private static void maxHeapify (Comparable[] arr, int index, int newSize){
        while (2 * index + 1 < newSize){  // 当前结点至少有左孩子
            int childIdx = 2 * index + 1;  // index 左孩子的下标
            // 存在右孩子，且右孩子比左孩子更大，则记录右孩子的下标
            if (childIdx + 1 < newSize && arr[childIdx].compareTo(arr[childIdx+1]) < 0) childIdx ++;
            if (arr[childIdx].compareTo(arr[index]) <= 0) break;  // 两个孩子均小于等于当前元素，则退出循环
            swap(arr, index, childIdx);
            index = childIdx;  // 当前不断跟新的孩子比较，跟其中一个较大的孩子交换位置
        }
    }


    private static void swap(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int N = 5;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
