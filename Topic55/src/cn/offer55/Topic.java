package cn.offer55;

public class Topic {

    public static void main(String[] args) {
        // ţ�Ͳ���
    }

    /**
     * �ж�ƽ�������
     * 
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return isBalancedCore(root, new int[1]);
    }

    public static boolean isBalancedCore(TreeNode root, int[] depth) {
        if (root == null)
            return true;

        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalancedCore(root.left, left) && isBalancedCore(root.right, right)) {
            int tmp = left[0] - right[0];
            if (tmp < -1 || tmp > 1)
                return false;
            else {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
    }

    /**
     * ����������ȣ��������һ���ڵ㣬�ֱ�����������������õ���ȣ��Լ�����Ⱦ��������нϴ��+1
     * 
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return 1 + (left > right ? left : right);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}