package pers.hanchao.dsaa.a01simple.client;

import pers.hanchao.dsaa.a01simple.behavior.Sorter;
import pers.hanchao.dsaa.a01simple.behavior.impl.BubbleSorter;
import pers.hanchao.dsaa.a01simple.behavior.impl.SelectSorter;

/**
 * <p>排序测试</p>
 * @author hanchao 2018/5/12 9:48
 **/
public class SortClient {
    /** 策略模式 **/
    private Sorter sorter;
    /** 带排序数组 **/
    private int[][] arrays;

    public SortClient(Sorter sorter) {
        this.sorter = sorter;
        initArray();
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
        //对数组进行初始化
        initArray();
    }

    public int[][] getArrays() {
        return arrays;
    }

    /**
     * 对数组进行初始化
     */
    public void initArray(){
        arrays = new int[][]{{8, 6, 1, 3, 9, 7, 4, 2, 5, 0}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {9, 8, 7, 6, 5, 0, 1, 2, 3, 4}};
    }
    /**
     * 进行排序
     */
    public void doSort(){
        for (int i = 0; i < arrays.length; i++) {
            //打印初始数组
            System.out.print("初始数组：");
            sorter.display(arrays[i]);
            //进行选择排序
            sorter.sort(arrays[i]);
            System.out.println();
        }
        System.out.println("========================= sort end =========================");
    }
    /**
     * <p>测试</p>
     * @author hanchao 2018/5/12 9:49
     **/
    public static void main(String[] args) {
        //定义一个以冒泡排序为模式排序算法的排序器
        SortClient sortClient = new SortClient(new BubbleSorter());
        //进行冒泡排序
        System.out.println("冒泡排序测试：");
        sortClient.doSort();

        //更换排序器
        sortClient.setSorter(new SelectSorter());
        //进行选择排序
        System.out.println("选择排序测试：");
        sortClient.doSort();

    }
}
