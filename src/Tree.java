/**
 * https://monsieursongsong.tistory.com/6
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.addLeftSubTree(node2);
        node1.addRightSubTree(node3);
        node2.addLeftSubTree(node4);
        node2.addRightSubTree(node5);
        node3.addLeftSubTree(node6);
        node3.addRightSubTree(node7);

        preOrder(node1);
        System.out.println();
        inOrder(node1);
        System.out.println();
        postOrder(node1);
        System.out.println();
    }

    /**
     * 전위 순회
     * @param node
     */
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.format(" %s ", node.getData());
        preOrder(node.getLeftSubTree());
        preOrder(node.getRightSubTree());
    }

    /**
     * 중위 순회
     * @param node
     */
    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.getLeftSubTree());
        System.out.format(" %s ", node.getData());
        inOrder(node.getRightSubTree());
    }

    /**
     * 후위 순회
     * @param node
     */
    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.getLeftSubTree());
        postOrder(node.getRightSubTree());
        System.out.format(" %s ", node.getData());
    }
}

class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Object data;

    public TreeNode(Object item) {
        left = null;
        right = null;
        this.data = item;
    }
    public void addLeftSubTree(TreeNode sub) {
        if (this.left != null) return;
        this.left = sub;
    }
    public void addRightSubTree(TreeNode sub) {
        if (this.right != null) return;
        this.right = sub;
    }
    public Object getData() {
        return this.data;
    }
    public TreeNode getLeftSubTree() {
        return this.left;
    }
    public TreeNode getRightSubTree() {
        return this.right;
    }
}
