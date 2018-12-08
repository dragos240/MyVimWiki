package io.github.nattupper.myvimwiki.Parser;

import java.util.ArrayList;

import io.github.nattupper.myvimwiki.Parser.Tokens.*;

//Takes an input
public class Parser{
    private Node[] nodes = {
            new Header(), new List(), new Paragraph()
    };

    public Parser(){
    }

    public Parser(String in){
        Document document = new Document(in);
    }
}
