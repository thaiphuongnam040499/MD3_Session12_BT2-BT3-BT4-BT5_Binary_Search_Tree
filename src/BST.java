import java.util.Comparator;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size;

    public BST() {
    }

    public BST(E[] object) {
        for (int i = 0; i < object.length; i++) {
            insert(object[i]);
        }
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    public void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        postorder(root.left);
        postorder(root.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    public void delete(E key) {
      root =  deleteElement(root, key);
    }

    @Override
    public TreeNode<E> deleteElement(TreeNode<E> root, E key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.element) < 0) {
            root.left = deleteElement(root.left, key);
        } else if (key.compareTo(root.element) > 0) {
            root.right = deleteElement(root.right, key);
        } else {
            // nút hiện tại là nút cần xóa
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.element = minValue(root.right);
            root.right = deleteElement(root.right, root.element);
        }
        return root;
    }

    E minValue(TreeNode<E> root) {
        E minVal = root.element;
        while (root.left != null) {
            minVal = root.left.element;
            root = root.left;
        }
        return minVal;
    }


    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    @Override
    public void preorder() {
        preorder(root);
    }
}
