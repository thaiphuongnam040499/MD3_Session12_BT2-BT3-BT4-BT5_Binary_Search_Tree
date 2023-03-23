public interface Tree<E> {
    public boolean insert(E e);
    public void postorder(TreeNode<E> root);
    public int getSize();
    public boolean delete(E e);
    public boolean search(E e);

    void preorder(TreeNode<E> root);
}
