package pers.hanchao.dsaa.a01simple.behavior.impl;

import pers.hanchao.dsaa.a01simple.behavior.Sorter;

/**
 * <p>冒泡排序</p>
 *
 * @author hanchao 2018/5/10 22:28
 **/
public class BubbleSorter extends Sorter {
    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     * @return 排序完成的有序数组
     */
    @Override
    public int[] sort(int[] array) {
        //最外层循环表示需要进行多少轮排序
        //注意一共进行了n-1次循环，而不是n次
        for (int i = 1; i < array.length; i++) {
            //设定一个标志，用于表示本轮冒泡是否进行了交换，如果没有进行交换，则表示数组已经是有序的
            boolean swap = false;
            //进行一次冒泡
            //j < array.length - i,表示每次参与冒泡的元素在逐步减少
            for (int j = 0; j < array.length - i; j++) {
                //如果第j个元素大于第j+1个元素，则交换两个元素
                if (array[j] > array[j + 1]) {
                    //交换两个元素
                    //定义一个中介变量
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //将交换标志位置为true
                    swap = true;
                }
            }
            //打印当前数组
            System.out.print("第" + i + "冒泡结果：");
            display(array);
            //如果没进行交换，则表示已经排序结束
            if (!swap) {
                System.out.println("冒泡完成");
                break;
            }
        }
        return array;
    }
}
