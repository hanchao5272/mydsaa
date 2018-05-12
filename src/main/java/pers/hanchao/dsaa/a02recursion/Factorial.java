package pers.hanchao.dsaa.a02recursion;

/**
 * N Factorial N的阶乘问题
 */
public class Factorial {

    /**
     * N的阶乘的非递归算法
     * n! = n*(n-1)*(n-2)*(n-3)...*1
     * @param n
     * @return
     */
    public int getFactorialWithoutRecursion(int n){
        int result = 1;
        if (n >= 0){
            for (int i = 1; i <= n; i++) {
                result *= i;
            }

        }else {
            return -1;
        }
        return result;
    }

    /**
     * N的阶乘的递归算法
     * n! = n*(n-1)!
     * @param n
     * @return
     */
    public int getFactorialWithRecursion(int n){
        if (n >= 0){
            if (n == 0){
                return 1;
            }else {
                return n * getFactorialWithRecursion(n -1 );
            }
        }else {
            return -1;
        }
    }
    /**
     * <p></p>
     * @author hanchao 2018/5/13 0:18
     **/
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
         System.out.println("1! = " + factorial.getFactorialWithoutRecursion(1));
         System.out.println("2! = " + factorial.getFactorialWithoutRecursion(2));
         System.out.println("3! = " + factorial.getFactorialWithoutRecursion(3));
         System.out.println("4! = " + factorial.getFactorialWithoutRecursion(4));
         System.out.println("1! = " + factorial.getFactorialWithRecursion(1));
         System.out.println("2! = " + factorial.getFactorialWithRecursion(2));
         System.out.println("3! = " + factorial.getFactorialWithRecursion(3));
         System.out.println("4! = " + factorial.getFactorialWithRecursion(4));
    }
}
