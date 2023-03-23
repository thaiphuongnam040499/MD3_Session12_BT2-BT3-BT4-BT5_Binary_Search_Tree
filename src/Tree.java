public interface Tree<E> {
    public boolean insert(E e);
    public void postorder(TreeNode<E> root);
    public int getSize();
    public TreeNode<E> deleteElement(TreeNode<E> root,E key);
    public boolean search(E e);

    void preorder(TreeNode<E> root);
}
