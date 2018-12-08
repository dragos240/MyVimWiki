package io.github.nattupper.myvimwiki.Parser.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class List extends SimpleNode {
    private Pattern listPattern = Pattern.compile("(?:\\* |\\d\\. )(.+)");
    private Pattern orderedPattern = Pattern.compile("\\d\\. (.+)");
    private Pattern unorderedPattern = Pattern.compile("\\* (.+)");
    private String type = "List";

    @Override
    public boolean isNode(String s) {
        return listPattern.matcher(s).matches();
    }

    public int isList(String s){
        if(orderedPattern.matcher(s).matches())
            return 0;
        else if(unorderedPattern.matcher(s).matches())
            return 1;
        else
            return -1;
    }

    @Override
    public int processAndStore(String data, int offset){
        String s = data.substring(offset);
        int pos = 0;
        Matcher matcher = null;
        String line = null;
        while(pos < s.length()-1) {
            if(s.indexOf('\n', pos) == -1)
                break;
            line = s.substring(pos, s.indexOf('\n', pos));
            if (isList(line) < 0)
                break;
            matcher = listPattern.matcher(line);
            matcher.matches();
            Item item = new Item();
            item.setParent(this);
            item.setContent(matcher.group(1));
            addChild(item);
            pos = s.indexOf('\n', pos);
        }
        System.out.println("Test");
        if(matcher != null) {
            return offset + pos + matcher.end();
        }
        else
            return offset;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void printTree() {
        System.out.println(type);
        for(SimpleNode child: children){
            child.printTree();
        }
    }

    public boolean isOrdered(){
        return ((Item)children[0]).isOrdered();
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
