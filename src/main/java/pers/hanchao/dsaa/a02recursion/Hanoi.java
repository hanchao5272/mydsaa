package pers.hanchao.dsaa.a02recursion;

/**
 * 汉诺塔问题
 */
public class Hanoi {
    /**
     * 汉诺塔的递归解法
     * @param N 盘子
     * @param A 初始塔
     * @param B 中介塔
     * @param C 目标塔
     */
    public static void move(int N, String A, String B, String C){
        if (N == 1){
            //0.如果只有一个盘子，则直接挪动到塔C
            System.out.println(N + " from " + A + " to " + C);
        }else {
            //1.塔A借助中介塔C，将N-1个盘子，挪动到了塔B
            move(N - 1,A,C,B);
            //2.塔A将第N个盘子挪动到了塔C
            System.out.println(N + " from " + A + " to " + C);
            //3.塔B借助中介塔A，将N-1个盘子，挪动到了塔C
            move(N - 1,B,A,C);
        }
    }

    /**
     * <p></p>
     * @author hanchao 2018/5/13 1:10
     **/
    public static void main(String[] args) {
        move(3,"A","B","C");
    }
}
