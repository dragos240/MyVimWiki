package io.github.nattupper.myvimwiki.Parser.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Header extends SimpleNode {
    private Pattern[] headerPatterns = {
            Pattern.compile("=====(.*?)====="),
            Pattern.compile("====(.*?)===="),
            Pattern.compile("===(.*?)==="),
            Pattern.compile("==(.*?)=="),
            Pattern.compile("=(.*?)=")
    };
    private String type = "Header";
    private int level = 0;

    @Override
    public boolean isNode(String s){
        return isHeader(s);
    }

    public boolean isHeader(String s){
        for(int i=0; i < headerPatterns.length; i++){
            Pattern pattern = headerPatterns[i];
            if(pattern.matcher(s).matches()) {
                level = i;
                return true;
            }
        }

        return false;
    }

    @Override
    public String getContent(){
        return content;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int processAndStore(String data, int offset){
        String s = data.substring(offset);
        if(!isHeader(s))
            return -1;
        Matcher matcher = headerPatterns[level].matcher(s);
        matcher.matches();
        content = matcher.group(1);
        return offset+matcher.end();
    }

    @Override
    public void printTree() {
        String fmtStr;
        if(depth != 0)
            fmtStr = "%"+depth+"s%s(%d): %s\n";
        else
            fmtStr = "%s%s(%d): %s\n";
        System.out.printf(fmtStr, " ", type, level, content);
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
