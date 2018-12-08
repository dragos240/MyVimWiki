package io.github.nattupper.myvimwiki;

import io.github.nattupper.myvimwiki.Parser.Tokens.*;

//Takes an output
public class VisitorImpl implements Visitor {
    private SimpleNode node;

    private StringBuilder buffer;

    public VisitorImpl(){
        buffer = new StringBuilder();
    }

    public void feed(String in){
        if(node.processAndStore(in, 0) != -1) {
            buffer.append(node.getContent());
        }
        else
            System.out.println("Could not find match!");
    }

    public String getBuffer(){
        return buffer.toString();
    }

    public void visit(Document node){}

    public void visit(Header node){
        this.node = node;
    }

    public void visit(List node){}

    //void visit(LineBreak node){}

    public void visit(Paragraph node){}
}
