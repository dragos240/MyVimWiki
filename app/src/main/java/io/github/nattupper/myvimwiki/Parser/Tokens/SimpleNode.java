package io.github.nattupper.myvimwiki.Parser.Tokens;

public class SimpleNode implements Node {
    private static final SimpleNode[] EMPTY_ARRAY = new SimpleNode[0];

    protected SimpleNode parent;
    protected SimpleNode[] children = EMPTY_ARRAY;
    protected String content;
    protected int depth = 0;
    protected String type = "SimpleNode";

    public void setParent(SimpleNode parent){
        this.parent = parent;
        depth = parent.getDepth()+1;
    }

    public int getDepth(){
        return depth;
    }

    public String getType(){
        return type;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public boolean isNode(String s){
        return false;
    }

    public int processAndStore(String data, int offset){
        return -1;
    }

    public void printTree(){}

    public void addChild(SimpleNode node){
        if(children == null)
            children = new SimpleNode[1];
        else{
            SimpleNode c[] = new SimpleNode[children.length+1];
            System.arraycopy(children, 0, c, 0, children.length);
            children = c;
        }
        children[children.length-1] = node;
    }

    public void accept(Visitor visitor){}
}
