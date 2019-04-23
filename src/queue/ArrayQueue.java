package queue;

/**
 * description 使用数组实现队列
 *
 * @author fanglingxiao
 * @date 2019/4/23
 */
public class ArrayQueue {
    private String[] items;
    private int lengh;
    /**
    head队列头指针 tail表示尾指针
     */
    private int head;
    private int tail;

    public ArrayQueue(int lengh){
        this.lengh = lengh;
        items = new String[lengh];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String item){
        if (lengh == tail){
            if (head == 0){
                return false;
            }
            //数据迁移
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            tail = tail-head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if (head == tail){
            return null;
        }
        return items[head++];
    }
}
