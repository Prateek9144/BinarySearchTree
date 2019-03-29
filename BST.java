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
    public void preTraverse(Node r){
        if(r==null)
            return ;
        System.out.print(r.val+"\t");
        preTraverse(r.left);
        preTraverse(r.right);
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
