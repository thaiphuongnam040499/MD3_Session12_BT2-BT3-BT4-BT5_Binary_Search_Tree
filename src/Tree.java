public interface Tree<E> {
    public boolean insert(E e);
    public void postorder(TreeNode<E> root);
    public int getSize();
}
