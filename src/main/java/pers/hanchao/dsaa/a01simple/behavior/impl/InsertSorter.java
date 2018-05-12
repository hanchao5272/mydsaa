package pers.hanchao.dsaa.a01simple.behavior.impl;

import pers.hanchao.dsaa.a01simple.behavior.Sorter;

/**
 * <p>插入排序</p>
 * @author hanchao 2018/5/12 10:20
 **/
public class InsertSorter extends Sorter {
    /**
     * 插入排序
     * @param array 待排序数组
     * @return 排序结果
     */
    @Override
    public int[] sort(int[] array) {
        //第一层N-1次循环：第一个元素无需插入，因为只有一个元素时，默认是有序的
        for (int i = 1; i < array.length; i++) {
            //选择一个元素
            int temp = array[i];
            //定义插入位置
            int insertIndex = i;
            //在已排序的数组中，从右向左查找，如果元素大于temp，则进行后移
            while(insertIndex > 0 && array[insertIndex - 1] > temp){
                array[insertIndex] = array[insertIndex - 1];
                insertIndex --;
            }
            //将temp插入到空出的位置上
            array[insertIndex] = temp;
            //打印当前数组
            System.out.print("第" + i + "插入结果：");
            display(array);
        }
        return array;
    }
}
