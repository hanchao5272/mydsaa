package pers.hanchao.dsaa.a01simple;

/**
 * <p>冒泡排序</p>
 *
 * @author hanchao 2018/5/10 22:28
 **/
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     * @return 排序完成的有序数组
     */
    public static int[] sort(int[] array) {
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
            System.out.print("第" + i + "交换结果：");
            display(array);
            //如果没进行交换，则表示已经排序结束
            if (!swap) {
                System.out.println("交换完成");
                break;
            }
        }
        return array;
    }

    /**
     * 打印数组
     *
     * @param array
     */
    private static void display(int[] array) {
        System.out.print("array{ ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }

    /**
     * <p>测试冒泡排序</p>
     *
     * @author hanchao 2018/5/10 22:41
     **/
    public static void main(String[] args) {
        //定义并初始化数组
        int[] array = {8,6,1,3,9,7,4,6,5,0};
        //打印初始数组
        System.out.print("初始数组：");
        display(array);
        //进行冒泡排序
        sort(array);

        System.out.println();
        //定义并初始化数组
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        //打印初始数组
        System.out.print("初始数组：");
        display(array1);
        //进行冒泡排序
        sort(array1);

        System.out.println();
        //定义并初始化数组
        int[] array2 = {9,8,7,6,5,0,1,2,3,4};
        //打印初始数组
        System.out.print("初始数组：");
        display(array2);
        //进行冒泡排序
        sort(array2);
    }
}
