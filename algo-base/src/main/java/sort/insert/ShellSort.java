package sort.insert;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangwei02
 * @version 1.0.0
 * @ClassName ShellSort.java
 * @Description TODO
 * @createTime 2022年03月01日 10:55:00
 */
public class ShellSort {

    public static void sort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int step = arr.length;
        do {
            step = step / 3 + 1;
            for (int i = step; i < arr.length; i++) {
                int base = arr[i];
                int j = i - step;
                for (; j >= 0 && arr[j] > base; j -= step)
                    arr[j + step] = arr[j];
                arr[j + step] = base;
            }
        } while (step > 1);
    }

    /**
     * algorithm: shell sort，希尔排序，也成为缩减增量排序算法，递减增量排序算法
     *
     *
     * algorithm description:
     *      1、先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
     *      2、所有距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序。
     *      3、取第二个增量d2<d1重复上述的分组和排序，
     *      4、直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
     *
     *
     * description:
     *      在数组内的元素基本有序的情况下，直接插入排序是非常高效的。
     *      而希尔排序就是通过对局部数据使用直接插入排序而创造出数组基本有序的条件，之后对数组整体进行直接插入排序。
     *
     *      希尔排序的做法是，
     *          将数组间隔为increment的元素分别划分到若干个小组，对每一个小组进行直接插入排序（每一小组的数据量较小，操作代价更小）；
     *          不断地减小间隔，将数组划分为更多个小组，继续对每一个小组进行直接插入排序（可以使近邻的元素基本有序）；
     *          最后，将数组划分为 N 个小组，也即是对全体元素进行一次直接插入排序。
     *          （最后一步，数组已经基本有序，就对数组直接插入排序）
     *
     *      解释它的做法，
     *          希尔排序的思想是使数组中任意间隔为 increment 元素都是有序的。
     *          对间隔为increment的元素进行直接插入排序，可以使一个元素一次性地朝着最终位置前进一大步。
     *          缩小间隔 increment，可以使任意一个局部的元素都是基本有序的。
     *          当数组基本有序时，对全体元素进行直接插入排序。
     *
     * expense: 时间复杂度 O(n^(3/2))
     *
     * character:
     */
    public static void main(String[] args) {
        int N = 30;
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
