package io.github.nattupper.myvimwiki.Parser.Tokens;

import java.util.ArrayList;
import java.util.List;

public class Line extends SimpleNode {
    public Node[] parse(String in){
        List<Node> nodes = new ArrayList<Node>();

        //do parsing here
        //check for a match in whole string
        //check for a match in matching substr

        return nodes.toArray(new Node[nodes.size()]);
    }
}
