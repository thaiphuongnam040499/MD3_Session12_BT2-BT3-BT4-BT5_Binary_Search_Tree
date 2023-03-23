public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);
        System.out.println("postorder (sorted): ");
        tree.postorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.println("preorder (sorted): ");
        tree.preorder();
        System.out.println("search (sorted): ");
        System.out.println(tree.search(27));
        tree.delete(14);
        tree.preorder();
    }
}
