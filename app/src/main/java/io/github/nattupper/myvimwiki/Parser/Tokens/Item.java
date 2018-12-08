package io.github.nattupper.myvimwiki.Parser.Tokens;

public class Item extends SimpleNode {
    private boolean ordered;
    private String type = "Item";

    public boolean isOrdered(){
        return ordered;
    }

    public void makeOrdered(){
        ordered = true;
    }

    public void makeUnordered(){
        ordered = false;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void printTree() {
        System.out.printf("%"+depth+"s%s: %s\n", " ", type, content);
    }
}
