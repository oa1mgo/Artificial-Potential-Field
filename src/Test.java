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
        Map mMap = new Map();
        ArtificialPotentialField artificialPotentialField = new ArtificialPotentialField(mMap);
        ArrayList<Node> nodeList = (ArrayList<Node>) artificialPotentialField.findPath();


    }


}
