import java.util.List;

/**
 * @program: Artificial-Potential-Field
 * @description: artificial potential field algorithm
 * @author: Miao Jiaxin
 * @create: 2019-12-16 16:46
 **/

public class ArtificialPotentialField {
    private Map mMap;
    Node initialNode;
    Node finalNode;
    public int iteration = 0;
    public int stepLength = 1;

    public ArtificialPotentialField(Map mMap) {
        if(mMap != null) {
            this.mMap = mMap;
            this.initialNode = mMap.initialNode;
            this.finalNode = mMap.finalNode;
        }
    }

    public List<Node> findPath() {
        //TODO:
        /***
         * 1.搜索规定区域内的障碍物和终点
         * 2.判断是否到达终点或迭代次数超过规定值
         * 3.计算合力的方向
         * 4.移动一步
         * 5.跳到步骤2
         * */
        Node currentNode = initialNode;
        int[][] obstacleList = mMap.blockList;
        int obstacleListSize = obstacleList.length;
        while (currentNode != finalNode || iteration < 100) {

        }

        return null;
    }
}
