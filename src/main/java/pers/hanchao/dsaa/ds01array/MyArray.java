package pers.hanchao.dsaa.ds01array;

import java.util.Arrays;

/**
 * 在Java中以类的形式实现数组
 * Created by 韩超 on 2018/5/10.
 */
public class MyArray {
    /* 定义存放数组元素的容器 */
    private int[] elements;
    /* 定义数组的容量 */
    private int capacity;
    /* 定义数组的有效长度 */
    private int length;

    /**
     * 默认构造函数（默认容量为10）
     */
    public MyArray() {
        //默认数组容量为10
        this.capacity = 10;
        //初始化数组
        this.elements = new int[this.capacity];
        //定义初识有效长度
        this.length = 0;
    }

    /**
     * 容量构造函数
     * @param capacity
     */
    public MyArray(int capacity) {
        this.capacity = capacity;
        //初始化数组
        this.elements = new int[this.capacity];
        //定义初识有效长度
        this.length = 0;
    }

    /**
     * 获取容量
     * @return 容量
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 获取有效长度
     * @return 有效长度
     */
    public int getLength() {
        return length;
    }

    /**
     * 打印所有元素
     */
    public void printAll(){
        System.out.print("[");
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.elements[i] + ",");
        }
        System.out.println("]");
    }

    /**
     * 添加元素并返回下标
     * @param value 元素值
     * @return 此元素存储位置
     */
    public int add(int value){
        //如果容量不足，则返回-1
        if (this.capacity == this.length){
            System.out.println("数组已满，无法添加！");
            return -1;
        }else{
            //将新元素放在最后
            this.elements[length] = value;
//            int index = length;
            //有效长度加一，返回所在所有
            return length ++ ;
        }
    }

    /**
     * 以下标获取元素
     * @param index 下标
     * @return 元素值
     */
    public int get(int index){
        //判断下标合法性
        if (index < 0 || index > this.length){
            System.out.println("下标越界");
        }
        return this.elements[index];
    }

    /**
     * 查找数组中是否包含某个值，存在则返回其下标，不存在返回-1
     * @param value 目标元素值
     * @return 元素所在下标
     */
    public int find(int value){
        //定义下标
        int index = -1;
        //循环对比
        for(int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 删除一个元素
     * @return
     */
    public boolean delete(int value){
        //找到元素
        int index = find(value);
        //如果没找到，直接返回
        if (index == -1){
            System.out.println("要删除的元素不存在.");
            return false;
        }else{//找到元素则移动此元素后的元素
            for (int i = index;i < this.length;i ++){
                this.elements[i] = this.elements[i + 1];
            }
            //有限长度减一
            this.length --;
            return true;
        }
    }

    /**
     * 修改元素值
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 修改结果
     */
    public boolean modify(int oldValue,int newValue){
        //查找旧值所在
        int index = find(oldValue);
        //旧值不存在，无需修改
        if (-1 == index){
            System.out.println("旧值不存在，无需修改");
            return false;
        }else {
            this.elements[index] = newValue;
            return true;
        }
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "elements=" + Arrays.toString(elements) +
                ", capacity=" + capacity +
                ", length=" + length +
                '}';
    }

    /**
     * <p>Title: 测试</p>
     * @author 韩超 2018/5/10 11:57
     */
    public static void main(String[] args){
        //构造
        MyArray myArray = new MyArray();
        System.out.println("原始值：    " + myArray);
        //取值
        System.out.println("获取第3个元素：" + myArray.get(2));
        //添加值
        myArray.add(5);
        System.out.println("添加一个5：    " + myArray);
        myArray.add(2);
        System.out.println("添加一个2：    " + myArray);
        myArray.add(7);
        System.out.println("添加一个7：    " + myArray);
        myArray.add(8);
        System.out.println("添加一个8：    " + myArray);
        //索引查询
        System.out.println("获取第3个元素：" + myArray.get(2));
        //元素值查询
        System.out.println("查找4所在索引：" + myArray.find(4));
        System.out.println("查找5所在索引：" + myArray.find(5));
        //修改
        myArray.modify(7,17);
        System.out.println("将7修改为17：    " + myArray);
        //删除
        myArray.delete(2);
        System.out.println("删除2：    " + myArray);
        //打印所有
        System.out.print("打印所有元素：");
        myArray.printAll();
        //打印容量和用量
        System.out.println("数组用量/容量：" + myArray.getLength() + "/" + myArray.getCapacity());
    }
}
