package test;

import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/4
 */
public class DeadLock {
    /**
     * 思想为：定义两个ArrayList,将他们都加上锁A,B，线程1,2，1拿住了锁A ，
     * 请求锁B，2拿住了锁B请求锁A，在等待对方释放锁的过程中谁也不让出已获得的锁。
     */
    public static void main(String[] args) {
        final List<Integer> list1 = Arrays.asList(1, 2, 3);
        final List<Integer> list2 = Arrays.asList(1, 2, 3);

        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (list1) {
                    for (Integer i1 : list1) {
                        System.out.println(i1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (list2) {
                        for (Integer i2 : list2) {
                            System.out.println(i2);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (list2) {
                    for (Integer i2 : list2) {
                        System.out.println(i2);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (list1) {
                        for (Integer i1 : list1) {
                            System.out.println(i1);
                        }
                    }
                }
            }
        }).start();
    }
}
