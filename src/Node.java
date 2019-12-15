/**
 * @program: Artificial-Potential-Field-master
 * @description: construct node
 * @author: Miao Jiaxin
 * @create: 2019-12-15 23:58
 **/

public class Node {
    public static int UNBLOCK_NODE = 0;
    public static int BLOCK_NODE = 1;
    public static int INITIAL_NODE = 2;
    public static int FINAL_NODE = 3;

    public int x;
    public int y;
    public int state;

    public Node(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Node: " + "[" + x + "," + y + "], state = " + state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Node node = (Node) obj;
        return node.x == x && node.y == y && node.state == state;
    }
}
