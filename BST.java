class BST {
    Node root;

    BST() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node rt, int value) {
        if (rt == null) {
            rt = new Node(value);
        } else {
            if (value > rt.val) {
                rt.right = insert(rt.right, value);
            } else {
                rt.left = insert(rt.left, value);
            }
        }
        return rt;
    }

    public Node search(Node rt, int value) {
        if (value == rt.val)
            return rt;
        else {
            if (value < rt.val)
                return search(rt.left, value);
            else
                return search(rt.right, value);
        }
    }

    public Node FindParent(Node rt, int value) {
        if (rt.right != null && rt.right.val == value) {
            return rt;
        } else if (rt.left != null && rt.left.val == value) {
            return rt;
        } else {
            if (rt.val > value) {
                return FindParent(rt.left, value);
            } else {
                return FindParent(rt.right, value);
            }
        }
    }

    public void Delete(int value) {
        Node t = search(root, value);
        if (t.right == null && t.left == null) {
            if (t.val == root.val)
                root = null;
            {
                Node Parent = FindParent(root, value);
                if (Parent.val > t.val)
                    Parent.left = null;
                else
                    Parent.right = null;
            }
        } else if (t.right == null) {
            if (t.val == root.val) {
                if (root.left.right == null || root.left.left == null)
                    root = root.left;
            } else {
                Node Parent = FindParent(root, value);
                if (Parent.val > t.val)
                    Parent.left = t.left;
                else
                    Parent.right = t.left;
            }
        } else if (t.left == null) {
            if (t.val == root.val) {
                root = root.right;
            } else {
                Node Parent = FindParent(root, value);
                if (Parent.val > t.val)
                    Parent.left = t.right;
                else
                    Parent.right = t.right;
            }
        } else {
            Node Child = Child(t.right);
            int temp = Child.val;
            Delete(Child.val);
            t.val = temp;
        }
    }

    public Node Child(Node x) {
        if (x.left == null)
            return x;
        else
            return Child(x.left);
    }

    public void infixTraverse(Node r) {
        if (r == null)
            return;
        infixTraverse(r.left);
        System.out.print(r.val + "\t");
        infixTraverse(r.right);
    }

    public void postTraverse(Node r) {
        if (r == null)
            return;
        postTraverse(r.left);
        postTraverse(r.right);
        System.out.print(r.val + "\t");
    }

    public void preTraverse(Node r) {
        if (r == null)
            return;
        System.out.print(r.val + "\t");
        preTraverse(r.left);
        preTraverse(r.right);
    }
}
