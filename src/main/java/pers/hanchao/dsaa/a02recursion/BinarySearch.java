package pers.hanchao.dsaa.a02recursion;

/**
 * 二分查找的递归和非递归实现形式
 */
public class BinarySearch {
    /**
     * 二分查找的非递归算法
     *
     * @return
     */
    public int binarySearchWithoutRecursion(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;

        while (end >= start) {
            int mid = (end - start) / 2 + start;
            System.out.println("start=" + start + ",mid=" + mid + ",end=" + end);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {//中部值大于查找值，则查找左半部分
                end = mid - 1;
            } else if (array[mid] < value) {//中部值小于查找值，则查找右半部分
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归算法
     * @param array
     * @param value
     * @return
     */
    public int binarySearchWithRecursion(int[] array, int value, int start, int end){
        int mid = (end - start) / 2 + start;
        if(end >= start){
            if (array[mid] == value){
                return mid;
            }else if (array[mid] > value){
                return binarySearchWithRecursion(array,value,start,mid - 1);
            }else if(array[mid] < value){
                return binarySearchWithRecursion(array,value,mid + 1,end);
            }
        }
        return -1;
    }

    /**
     * <p>测试二分查找</p>
     *
     * @author hanchao 2018/5/13 0:37
     **/
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearchWithoutRecursion(array, 4));
        System.out.println(binarySearch.binarySearchWithoutRecursion(array, 5));

        System.out.println(binarySearch.binarySearchWithRecursion(array, 4,0,array.length));
        System.out.println(binarySearch.binarySearchWithRecursion(array, 5,0,array.length));
    }
}
