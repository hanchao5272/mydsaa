package pers.hanchao.dsaa.a01simple.behavior.impl;

import pers.hanchao.dsaa.a01simple.behavior.Sorter;

/**
 * <p>选择排序</p>
 * @author hanchao 2018/5/12 9:21
 **/
public class SelectSorter extends Sorter {
    /**
     * 选择排序
     * @param array 待排序数组
     * @return 排序完成的有序数组
     */
    @Override
    public int[] sort(int[] array){
        //需要进行N-1次选择:当最后只剩下一个元素时，这个元素一定是最大的元素，无需排序
        for (int i = 0; i < array.length - 1; i++) {
            //定义最小元素下标为当前待选择序列的首个
            int minIndex = i;
            //获取最小的元素：和后续的元素做比较
            for (int j = i + 1; j < array.length; j++) {
                //如果当前元素小于目前最小值，则交换
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //如果最小元素不是当前待排序序列的首个，则进行交换
            if (minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            //打印当前数组
            System.out.print("第" + i + "选择结果：");
            display(array);
        }
        return array;
    }
}
