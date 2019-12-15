/**
 * @program: Artificial-Potential-Field-master
 * @description: construct node
 * @author: Miao Jiaxin
 * @create: 2019-12-15 23:58
 **/

public class Node {
    public static int BLOCK = 1;
    public static int UNBLOCK = 0;

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
