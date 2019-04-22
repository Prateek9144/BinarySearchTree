class BST<D> {
    Node<D> root;

    BST(D value) {
        root = new Node(value);
    }

    public void insert(D val) {
        insert(root, val);
    }

    private Node insert(Node rt, D value) {
        if (rt == null) {
            rt = new Node(value);
        } else {
            if ((Integer) value > (Integer) rt.val) {

                rt.right = insert(rt.right, value);
            } else {
                rt.left = insert(rt.left, value);
            }
        }
        return rt;
    }

    public Node search(Node rt, D value) {
        if ((Integer) value == (Integer) rt.val)
            return rt;
        else if ((Integer) value < (Integer) rt.val) {
            if (rt.left != null)
                rt=rt.left;
        } else {
            if (rt.right != null)
                rt=rt.right;
        }
    }

    public Node FindParent(Node rt, D value) {
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
            Node Parent = FindParent(root, value);
            if((Integer)Parent.val >(Integer) t.val)
                Parent.left=null;
            else
                Parent.right = null;
        
        } else if (t.right == null) {
            Node Parent = FindParent(root, value);
            if((Integer)Parent.val >(Integer) t.val)
                Parent.left=t.left;
            else
                Parent.right = t.left;
        } else if (t.left == null) {
            Node Parent = FindParent(root, value);
            if((Integer)Parent.val > (Integer) t.val)
                Parent.left=t.right;
            else
                Parent.right = t.right;
        }
        else{
            Node<D> Child = Child(t.right);
            Integer  temp = (Integer)Child.val;
            Delete(Child.val);
            t.val=(D)temp;
        }
    }
    public Node Child(Node x){
        if(x.left == null)
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
