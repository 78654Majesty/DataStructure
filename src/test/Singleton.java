package test;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/4
 */
public class Singleton {
    /**
     * 单例设计模式
     *  饿汉、懒汉、静态内部类、枚举、双检锁
     *  下面是双检锁的实现
     */
    public Singleton(){}

    private volatile static Singleton instance;

    public Singleton getInstance(){
        if (null == instance){
            synchronized (Singleton.class){
                if (null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
