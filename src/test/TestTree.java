package test;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/4
 */
public class TestTree {

    public class Node {
        public Node parent;
        public Node left;
        public Node right;
        public String data;   // “a”, “b”, “c”, …等各个节点的各自具体的值。
    }
    public interface INodeHandler {
        public void handle(Node n);
    }
    public class NodePrinter  implements INodeHandler{
        @Override
        public void handle(Node n){
            System.out.print(n.data);  // 在控制台上打印出节点，无回车换行。
        }
    }
    public class Tree {
        private Node root;
        public Tree (Node root){
            this.root = root;
        }
        public void travel (INodeHandler  nh)
        {
            this.travel(nh, root);
        }
        private void travel(INodeHandler nh,  Node node){
            if (null == node){
                return;
            }
            nh.handle(node);
            if (node.left != null){
                travel(nh,node.left);
            }
            if (node.right != null){
                travel(nh,node.right);
            }
        }
    }
}
