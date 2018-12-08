package io.github.nattupper.myvimwiki.Parser.Tokens;

import java.util.ArrayList;
import java.util.List;

// Does the parsing for a single paragraph
// Paragraphs are separated by a LineBreak
public class Paragraph extends SimpleNode {
    private List<String> lines = new ArrayList<String>();

    void addLine(String line){
        lines.add(line);
    }

    List<String> getLines(){
        return lines;
    }
}
