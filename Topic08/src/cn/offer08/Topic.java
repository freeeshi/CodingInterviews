package cn.offer08;

public class Topic {

    public static void main(String[] args) {

    }

    /**
     * ����һ�������������ָ���ڵ㣬�ҳ��������ʱָ���ڵ����һ���ڵ�
     * 
     * @param node
     * @return ��һ�������Ľڵ㣬�������ڣ�����null
     */
    public static TreeNode getNext(TreeNode node) {
        if (node == null)
            return null;

        if (node.right != null) {
            TreeNode left = node.right;
            while (left.left != null) {
                left = left.left;
            }
            return left;
        }

        TreeNode parent = node.parent;
        TreeNode child = node;
        while (parent != null && parent.left != child) {
            child = parent;
            parent = parent.parent;
        }

        return parent;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}