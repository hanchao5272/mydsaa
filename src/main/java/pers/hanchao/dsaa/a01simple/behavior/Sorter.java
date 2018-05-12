package pers.hanchao.dsaa.a01simple.behavior;

/**
 * <p>排序接口</p>
 * @author hanchao 2018/5/12 9:38
 **/
public abstract class Sorter {
    /**
     * 排序
     * @param array 待排序数组
     * @return 排序结果
     */
    public abstract int[] sort(int[] array);
    /**
     * 打印数组
     *
     * @param array
     */
    public void display(int[] array) {
        System.out.print("array{ ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }
}
