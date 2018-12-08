package io.github.nattupper.myvimwiki.Parser.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emphasis extends SimpleNode {
    private Pattern italicPattern = Pattern.compile("_(.*?)_");
    private Pattern boldPattern = Pattern.compile("\\*(.*?)\\*");

    public boolean isItalic(){
        if(content == null)
            return false;
        return italicPattern.matcher(content).matches();
    }

    public boolean isBold(){
        if(content == null)
            return false;
        return boldPattern.matcher(content).matches();
    }
}
