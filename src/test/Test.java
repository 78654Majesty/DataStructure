package test;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/4
 */
public class Test {
    public static void main(String[] args) {
//        Son son = new Son();
//        System.out.println(son.getValue());

    }

}

class Parent{
    int i =1;
    Parent(){
        System.out.println("Parent i="+i);
        int x = getValue();
        System.out.println("Parent x="+x);
    }
    {i=2;}
    protected int getValue(){
        return i;
    }
}

class Son extends Parent{
    int j=1;
    Son (){
        j=2;
    }
    {j=3;}
    @Override
    protected int getValue(){
        return j;
    }
}