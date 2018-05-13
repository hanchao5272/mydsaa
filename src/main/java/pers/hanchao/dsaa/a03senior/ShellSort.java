package pers.hanchao.dsaa.a03senior;

import java.util.Arrays;

/**
 * 希尔排序-使用克努斯间隔序列(knuth)
 */
public class ShellSort {
    /**
     * 希尔排序
     */
    public static void shell(int[] array){
        //设定初始比较间隔为1
        int step = 1;
        int len = array.length;
        //计算序列间隔
        while (step < len / 3){
            step = 3 * step + 1;
        }
        //对每个排序间隔分别进行插入排序
        while(step > 0){
            System.out.println("增量间隔=" + step);
            //从第step个元素开始，与前面的元素进行比较，然后插入
            //这是一次插入排序
            for (int i = step; i < len; i++) {
                //获取当前待插入元素
                int current = array[i];
                //定义待比较的元素下标
                int frontIndex = i;
                System.out.println("i=" + i + ",current=" + current + ",array[" + (frontIndex - step) +"]=" + array[frontIndex - step]);
                //将当前元素依次与前面的多个间隔元素进行比较，找到合适位置后，进行插入
                while (frontIndex >= step && current <= array[frontIndex - step]){
                    //如果当前元素比待比较元素小，则将待比较元素后移
                    array[frontIndex] = array[frontIndex - step];
                    System.out.println("array[" + frontIndex + "] = array[" + (frontIndex - step) +"]");
                    //计算下一个待比较的间隔元素下标
                    frontIndex = frontIndex - step;
                }
                //将当前元素插入到找到的位置
                array[frontIndex] = current;
            }
            System.out.println("增量间隔=" + step + "的排序结果：" + Arrays.toString(array));
            //缩小排序间隔,继续进行比较
            step = (step - 1) / 3;
        }
        System.out.println("最终排序结果：" + Arrays.toString(array));
    }

    /**
     * <p></p>
     * @author hanchao 2018/5/13 11:12
     **/
    public static void main(String[] args) {
        int[] array = {4,2,18,9,5,17,6,1,13,10,8,4,7,3,16,20};
        shell(array);
    }
}
