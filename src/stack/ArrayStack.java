package stack;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description 顺序栈
 *
 * @author fanglingxiao
 * @date 2019/4/19
 */
public class ArrayStack {
    //顺序栈数组
    private String[] items;
    //元素个数
    private int count;
    //数组长度
    private int lenth;

    public ArrayStack(int lenth){
        this.items = new String[lenth];
        this.lenth = lenth;
        this.count = 0;
    }

    public boolean push(String item){
        if (lenth == 0){
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    public String pop(){
        if (lenth == 0){
            return null;
        }
        String item = items[count - 1];
        --count;
        return item;
    }
}
