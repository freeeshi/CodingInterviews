package cn.offer54;

public class Topic {

    public static void main(String[] args) {
        // 牛客测试
    }

    /**
     * 二叉搜索树的第k大节点，用中序遍历即可
     * 
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0)
            return null;
        int[] count = {0};
        return KthNodeCore(pRoot, k, count);
    }

    public static TreeNode KthNodeCore(TreeNode pRoot, int k, int[] count) {
        if (pRoot == null)
            return null;

        TreeNode result = null;
        result = KthNodeCore(pRoot.left, k, count);
        if (result != null)
            return result;

        count[0]++;
        if (count[0] == k)
            return pRoot;

        return KthNodeCore(pRoot.right, k, count);
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