class BST<D> {
    Node<D> root;

    BST() {
        root = null;
    }

    public void insert(D val) {
        root = insert(root, val);
    }

    private Node<D> insert(Node<D> rt, D value) {
        if (rt == null) {
            rt = new Node<D>(value);
        } else {
            if ((Integer) value > (Integer) rt.val) {
                rt.right = insert(rt.right, value);
            } else {
                rt.left = insert(rt.left, value);
            }
        }
        return rt;
    }

    public Node<D> search(Node<D> rt, D value) {
        if ((Integer) value == (Integer) rt.val)
            return rt;
        else {
            if ((Integer) value < (Integer) rt.val)            
                    return search(rt.left, value);
            else 
                    return search(rt.right, value);              
        }
    }

    public Node<D> FindParent(Node<D> rt, D value) {
        if (rt.right != null && rt.right.val == value) {
            return rt;
        } else if (rt.left != null && rt.left.val == value) {
            return rt;
        } else {
            if ((Integer) rt.val > (Integer) value) {
                return FindParent(rt.left, value);
            } else {
                return FindParent(rt.right, value);
            }
        }
    }

    public void Delete(D value) {
        Node t = search(root, value);
        if (t.right == null && t.left == null) {
            if ((Integer) t.val == (Integer) root.val)
                root = null;
            {
                Node Parent = FindParent(root, value);
                if ((Integer) Parent.val > (Integer) t.val)
                    Parent.left = null;
                else
                    Parent.right = null;
            }
        } else if (t.right == null) {
            if ((Integer) t.val == (Integer) root.val) {
                if (root.left.right == null || root.left.left == null) 
                root=root.left;  
            } else {
                Node Parent = FindParent(root, value);
                if ((Integer) Parent.val > (Integer) t.val)
                    Parent.left = t.left;
                else
                    Parent.right = t.left;
            }
        } else if (t.left == null) {
            if ((Integer) t.val == (Integer) root.val) {
                root=root.right;
            } else {
            Node Parent = FindParent(root, value);
            if ((Integer) Parent.val > (Integer) t.val)
                Parent.left = t.right;
            else
                Parent.right = t.right;
 }       } else {
            Node<D> Child = Child(t.right);
            Integer temp = (Integer) Child.val;
            Delete(Child.val);
            t.val = (D) temp;
        }
    }

    public Node<D> Child(Node<D> x) {
        if (x.left == null)
            return x;
        else
            return Child(x.left);
    }
 
    public void infixTraverse(Node<D> r) {
        if (r == null)
            return;
        infixTraverse(r.left);
        System.out.print(r.val + "\t");
        infixTraverse(r.right);
    }

    public void postTraverse(Node<D> r) {
        if (r == null)
            return;
        postTraverse(r.left);
        postTraverse(r.right);
        System.out.print(r.val + "\t");
    }

    public void preTraverse(Node<D> r) {
        if (r == null)
            return;
        System.out.print(r.val + "\t");
        preTraverse(r.left);
        preTraverse(r.right);
    }
}
