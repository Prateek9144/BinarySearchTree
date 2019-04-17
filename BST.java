class BST<D>{
    Node<D> root;
    BST()
    {
        root=null;
    }
    public void insert(D val){
        Node<D>ob = new Node<D>(val);
        Node<D>hop = root;
        if(root==null){
            root =ob;
        }
        else{
            while(true){
                if((Integer)val>(int)hop.val){
                    if(hop.right==null)
                        break;
                    else
                        hop=hop.right;              
                }
                else{   
                    if(hop.left==null)
                        break;
                    else
                        hop=hop.left;               
                }
            }
            if((Integer)val>(int)hop.val)
                hop.right = ob;
            else
                hop.left = ob;
        } 
    }
    public void infixTraverse(Node r){
        if(r==null)
            return ;
        infixTraverse(r.left);
        System.out.print(r.val+"\t");
        infixTraverse(r.right);
    }
    public void postTraverse(Node r){
        if(r==null)
            return ;
        postTraverse(r.left);
        postTraverse(r.right);
        System.out.print(r.val+"\t");
    }
      private Node search(Integer val, Node<D> rt)
    {
        if(val==rt.val)
        return rt;
        else if(val<rt.val)
        {
            if(rt.left!=null)
                return search(val, rt.left);
            else
                return null;
        }
        else
        {
            if(rt.right!=null)
                return search(val, rt.right);
            else
                return null;
        }
    }
    public void search(Integer val)
    {
        Node<D> x=search(val, root);
        if(x==null)
        System.out.println("Element not found");
        else
        System.out.println("Element Found");
    }
    public void preTraverse(Node r){
        if(r==null)
            return ;
        System.out.print(r.val+"\t");
        preTraverse(r.left);
        preTraverse(r.right);
    }
     public void delete(Integer val)
    {
        TreeNode x=search(val, root);
        if(x==null)
        throw new NoSuchElementException();
        else
        {
            if(x.right==null && x.left==null)
            x=null;
            else if(x.right==null && x.left!=null)
            {
                Node parent=findParent(x,root);
                if(parent.right==x)
                parent.right=x.left;
                else
                parent.left=x.left;
            }
            else if(x.left==null && x.right!=null)
            {
                Node parent=findParent(x,root);
                if(parent.right==x)
                parent.right=x.right;
                else
                parent.left=x.right;
            }
            else
            {
                Node<D> par=x.left;
                while(par.right!=null)
                {
                    par=par.right;
                }
                int temp=par.val;
                delete(par.val);
                x.val=temp;
            }
        }
    }
  
    public static void main(String[] args){
           BST a = new BST();
           a.insert(3);
           a.insert(-2);
           a.insert(10);
           a.insert(0);
           a.insert(-4);
           a.insert(-10);
           a.insert(5);
           a.insert(11);           
           a.insert(6);
           System.out.println("\nInorder Traversal");
           a.infixTraverse(a.root);
           System.out.println("\nPostorder Traversal");
           a.postTraverse(a.root);
           System.out.println("\nPreorder Traversal");
           a.preTraverse(a.root);
    }
}
