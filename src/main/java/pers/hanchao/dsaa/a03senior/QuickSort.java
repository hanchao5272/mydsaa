package pers.hanchao.dsaa.a03senior;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 数组元素交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 快速排序的迭代方式
     * @param array
     * @param left
     * @param right
     */
    public static void quickSortWithRecursion(int[] array,int left,int right){
        //如果左游标大于右游标，则不再递归
        if (left >= right){
            return;
        }else {
            //将当前数组进行划分
            int partition = partition(array,left,right);
            //对左数组继续进行递归快排
            quickSortWithRecursion(array,left,partition - 1);
            //基数元素不动
            //对右数组继续继续递归快排
            quickSortWithRecursion(array,partition + 1,right);
        }
    }

    /**
     * 将数组划分为左右两个数组，左数组元素肯定小于等于右数组元素
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] array, int left, int right) {
        //定义左游标和右游标
        int i = left;
        int j = right + 1;//+1的原因是因为需要从-- j开始
        //选取基准元素
        int pivot = array[left];
        while(true){
            //从左向右移动左游标，条件：当元素值小于基数时
            while(i < right && array[++ i] < pivot);
            //从右向左移动右游标
            while (j > left && array[-- j] > pivot);
            //如果左右游标相遇，则结束本次划分
            if (i >= j){
                break;
            }else {//游标相遇，交换两个游标的元素,继续进行循环
                swap(array,i,j);
            }
        }
        //左右游标相遇，将基准元素交换至相遇处
        swap(array,left,j);
        //返回基准元素所在下标
        return j;
    }

    /**
     * <p>测试快速排序</p>
     * @author hanchao 2018/5/13 13:50
     **/
    public static void main(String[] args) {
        int[] array = {4,2,18,9,5,17,6,1,13,10,8,4,7,3,16,20};
        System.out.println(Arrays.toString(array));
        quickSortWithRecursion(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
