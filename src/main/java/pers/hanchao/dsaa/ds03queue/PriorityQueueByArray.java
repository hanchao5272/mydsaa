package pers.hanchao.dsaa.ds03queue;

import java.util.Arrays;

/**
 * <p>数组实现优先级队列</p>
 * @author hanchao 2018/5/12 16:32
 **/
public class PriorityQueueByArray {
    /** 优先级数组 */
    private int[] priorityElements;
    /** 容量 */
    private int capacity;
    /** 用来 */
    private int length;

    public PriorityQueueByArray(int capacity) {
        this.capacity = capacity;
        length = 0;
        priorityElements = new int[this.capacity];
    }

    /**
     * 是否已满
     * @return
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isFull(){
        return length == capacity;
    }

    /**
     * 添加
     * @param value
     */
    public void add(int value){
        //如果已满，则不能再添加
        if (isFull()){
            System.out.println("队列已满！");
        }else{
            //获取当前元素的最大值的下标
            int index = length - 1;
            //通过插入排序进行数组排序
            //如果新元素小于排序元素，则将排序元素后移，最终形成有小到大的排序
            while(index >= 0 && priorityElements[index] < value){
                //元素后移
                priorityElements[index + 1] = priorityElements[index];
                index --;
            }
            //插入新元素
            priorityElements[index + 1] = value;
            length ++;
        }
    }

    /**
     * 顶部元素出队
     * @return
     */
    public int remove(){
        //如果队列为空，则不能出队
        if (isEmpty()){
            System.out.println("队列已空！");
            return Integer.MIN_VALUE;
        }
        //获取头部元素
        int value = priorityElements[length - 1];
        //移除头部元素
        priorityElements[length - 1] = Integer.MIN_VALUE;
        length --;
        return value;
    }

    /**
     * 查看优先级最大的元素
     * @return
     */
    public int element(){
        return priorityElements[length - 1];
    }


    @Override
    public String toString() {
        return "PriorityQueueByArray{" +
                "priorityElements=" + Arrays.toString(priorityElements) +
                ", capacity=" + capacity +
                ", length=" + length +
                '}';
    }

    /**
     * <p>测试</p>
     * @author hanchao 2018/5/12 16:50
     **/
    public static void main(String[] args) {
        PriorityQueueByArray priorityQueue = new PriorityQueueByArray(5);
        System.out.println(priorityQueue);
        //入队
        priorityQueue.add(5);
        System.out.println(priorityQueue);
        priorityQueue.add(3);
        System.out.println(priorityQueue);
        priorityQueue.add(6);
        System.out.println(priorityQueue);
        priorityQueue.add(9);
        System.out.println(priorityQueue);
        priorityQueue.add(1);
        System.out.println(priorityQueue);
        priorityQueue.add(10);
        System.out.println(priorityQueue);
        System.out.println();

        //出队
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
    }
}
