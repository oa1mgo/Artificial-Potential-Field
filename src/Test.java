import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Artificial-Potential-Field-master
 * @description: Main
 * @author: Miao Jiaxin
 * @create: 2019-12-15 23:56
 **/

public class Test {
    public static void main(String[] args) {
//        Map defaultMap = new Map();
//        ArtificialPotentialField artificialPotentialField = new ArtificialPotentialField(defaultMap);
//        artificialPotentialField.findPath();
        Node iNode = new Node(90, 10, 2);
        Node fNode = new Node(30, 70, 3);
        int[][] blockList = new int[][]{{10, 20}, {20, 70}, {40, 60}, {41, 60}, {40, 61}, {41, 61}, {60, 80}, {70, 10}, {80, 50}};
        Map mMap = new Map(100, 100, iNode, fNode, blockList);
        ArtificialPotentialField artificialPotentialField = new ArtificialPotentialField(mMap);
        artificialPotentialField.findPath();

    }


}
