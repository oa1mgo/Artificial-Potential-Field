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

    public int col;
    public int row;
    public int state;

    public Node(int col, int row, int state) {
        this.col = col;
        this.row = row;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Node: " + "[" + col + "," + row + "], state = " + state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Node node = (Node) obj;
        return node.col == col && node.row == row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getState() {
        return state;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setState(int state) {
        this.state = state;
    }
}
