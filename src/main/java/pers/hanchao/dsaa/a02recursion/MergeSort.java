package pers.hanchao.dsaa.a02recursion;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并算法的非递归实现
     * @param array
     */
    public static void mergeWithoutRecursion(int[] array){
        //将初始子数组长度设置为1
        int len = 1;
        //当子数组长度小于大数组长度时，循环进行归并
        while(len < array.length){
            //当每个子数组长度为len时，需要进行 array.length / (2 * len)次循环
            for (int i = 0; i < array.length; i += 2 * len) {
                //对数组array的第i个元素进行合并，合并长度为len
                merge(array,i,len);
            }
            //子数组长度加倍
            len *= 2;
        }
    }

    /**
     * 在数组array中，从第i个元素开始，对len*2个元素进行归并
     * @param array 待归并数组
     * @param i 起始下标
     * @param len 每个数组的长度
     */
    private static void merge(int[] array, int i, int len) {
        //计算第一个数组范围
        int aIndex = i;
        int aEnd = Math.min(aIndex + len,array.length);
        //计算第二个数组范围
        int bIndex = aEnd;
        //第二数组的结束下标有可能超出array.length,需要判断
        int bEnd = Math.min(bIndex + len,array.length);
        //定义一个临时数组存储两个数组的合并结果
        int[] temp = new int[bEnd - aIndex];
        //定义临时数组的下标
        int tempIndex = 0;
        System.out.print("len=" + len + ",a[" + aIndex + "," + aEnd + "] + b[" + bIndex + "," + bEnd + "] = c[0," + temp.length + "] ==>" );
        //当前两个子数组都不空时，进行比较合并
        while (aIndex < aEnd && bIndex < bEnd){
            //谁小将谁存放谁
            if (array[aIndex] < array[bIndex]){
                temp[tempIndex ++] = array[aIndex ++];
            }else {
                temp[tempIndex ++] = array[bIndex ++];
            }
        }
        //当数组a空b不空时，将b拷贝至临时数组
        while(aIndex == aEnd && bIndex < bEnd){
            temp[tempIndex ++] = array[bIndex ++];
        }
        //当数组b空a不空时，将a拷贝至临时数组
        while(bIndex == bEnd && aIndex < aEnd){
            temp[tempIndex ++] = array[aIndex ++];
        }
        display(temp);
        //将临时数组的内容拷贝至原数组
        //定义临时下标
        int tempI = i;
        for (int n = 0; n < temp.length;) {
            array[tempI ++] = temp[n ++];
        }
    }


    public static void mergeWithRecursion(int[] array,int start,int end){
        if (end > start){
            //计算中间值
            int mid = (end - start) / 2 + start;
            System.out.println("[" + start + "," + mid + "] + [" + (mid + 1) + "," + end + "]");
            //对左边进行归并
            mergeWithRecursion(array,start,mid);
            //对右边进行归并
            mergeWithRecursion(array,mid + 1,end);
            //合并结果
            merge(array,start,mid,end);
        }
    }

    /**
     * 合并数组
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] array, int start, int mid, int end) {
        //计算第一个数组范围
        int aIndex = start;
        int aEnd = mid;
        //计算第二个数组范围
        int bIndex = mid + 1;
        //第二数组的结束下标有可能超出array.length,需要判断
        int bEnd = end;
        //定义一个临时数组存储两个数组的合并结果
        int[] temp = new int[end - start + 1];
        //定义临时数组的下标
        int tempIndex = 0;
        System.out.print("len=" + (mid - start) + ",a[" + aIndex + "," + aEnd + "] + b[" + bIndex + "," + bEnd + "] = c[0," + temp.length + "] ==>" );
        //当前两个子数组都不空时，进行比较合并
        while (aIndex < aEnd && bIndex < bEnd){
            //谁小将谁存放谁
            if (array[aIndex] < array[bIndex]){
                temp[tempIndex ++] = array[aIndex ++];
            }else {
                temp[tempIndex ++] = array[bIndex ++];
            }
        }
        //当数组a空b不空时，将b拷贝至临时数组
        while(aIndex == aEnd && bIndex < bEnd){
            temp[tempIndex ++] = array[bIndex ++];
        }
        //当数组b空a不空时，将a拷贝至临时数组
        while(bIndex == bEnd && aIndex < aEnd){
            temp[tempIndex ++] = array[aIndex ++];
        }
        display(temp);
        //将临时数组的内容拷贝至原数组
        //定义临时下标
        int tempI = start;
        for (int n = 0; n < temp.length;) {
            array[tempI ++] = temp[n ++];
        }
    }

    /**
     * 打印数组
     * @param array
     */
    public  static void display(int[] array){
        for (int item : array ){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * <p></p>
     * @author hanchao 2018/5/13 1:53
     **/
    public static void main(String[] args) {
        //归并的非递归算法
        int[] array = {2,4,1,7,5,9,0,3,6};
        display(array);
        mergeWithoutRecursion(array);
        display(array);
        System.out.println();
        //归并的递归算法-有问题
        int[] array1 = {2,4,1,7,5,9,0,3,6};
        display(array1);
        mergeWithRecursion(array1,0,array.length - 1);
        display(array1);
    }
}
