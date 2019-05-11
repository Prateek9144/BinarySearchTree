import org.omg.CORBA.portable.Delegate;

class BST {
    NodeBST root;

    BST() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private NodeBST insert(NodeBST rt, int value) {
        if (rt == null) {
            rt = new NodeBST(value);
        } else {
            if (value > rt.val) {
                rt.right = insert(rt.right, value);
            } else {
                rt.left = insert(rt.left, value);
            }
        }
        return rt;
    }

    public void Delete(int value) {
        root = Delete(root, value);
    }

    private NodeBST Delete(NodeBST rt, int value) {
        if (rt.val == value) {
            if (rt.left == null && rt.right == null)
                rt = null;
            else {
                if (rt.right == null)
                    rt = rt.left;
                else if (rt.left == null)
                    rt = rt.right;
                else {
                    NodeBST temp = rt.left;
                    while (temp.right != null)
                        temp = temp.right;
                    int x = temp.val;
                    Delete(temp.val);
                    rt.val = x;
                }
            }
        } else {
            if (value > rt.val) {
                rt.right = Delete(rt.right, value);
            } else {
                rt.left = Delete(rt.left, value);
            }
        }
        return rt;
    }

    public void infixTraverse(NodeBST r) {
        if (r == null)
            return;
        infixTraverse(r.left);
        System.out.print(r.val + "\t");
        infixTraverse(r.right);
    }

    public void postTraverse(NodeBST r) {
        if (r == null)
            return;
        postTraverse(r.left);
        postTraverse(r.right);
        System.out.print(r.val + "\t");
    }

    public void preTraverse(NodeBST r) {
        if (r == null)
            return;
        System.out.print(r.val + "\t");
        preTraverse(r.left);
        preTraverse(r.right);
    }
}
