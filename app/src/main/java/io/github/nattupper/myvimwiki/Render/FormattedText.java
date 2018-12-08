package io.github.nattupper.myvimwiki.Render;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormattedText {
    /*
    Heading: ==Test==, = Test =
    Unordered list: * Test
    Ordered list: 2. Test
    Bold: *Test*
    Italic: _Test_
    Link: [[test/path|Test]]
    Plain: Test

    Link+Bold+Italic: [[test/path|*_Test_*]]
    */

    /*

    private SpanToken[] children;

    private SpanToken[] tokenTypes = {
            new H3(), new H2(), new H1(),
            new ULElem(), new OLElem(), new Bold(),
            new Italic(), new Link()
    };

    public FormattedText(String line){
        children = tokenize(line);
    }

    public SpanToken[] getChildren(){
        return children;
    }

    private SpanToken[] tokenize(String content){
        SpanToken[] tokens;
        ArrayList<SpanToken> tokensAL = new ArrayList<>();
        int start = 0;
        while(start != content.length()){
            FNTResult fntResult = findNearestToken(content, start);
            int index = fntResult.index;
            Matcher matchObj = fntResult.matchObj;
            SpanToken tokenType = fntResult.tokenType;

            if(matchObj != null)
                tokenType.init(matchObj);
            if(matchObj != null && matchObj.matches()){
                tokensAL.add(tokenType);
                start = matchObj.end();
            }
            if(index != start){
                System.out.println("index: "+index); //TODO: Remove after testing
                System.out.println("content.length(): "+content.length()); //TODO: Remove after testing
                tokensAL.add(new RawContent(content.substring(start, index)));
                start = index;
            }
        }
        System.out.println("Finished loop"); //TODO: Remove after testing
        tokens = tokensAL.toArray(new SpanToken[tokensAL.size()]);
        return tokens;
    }

    private FNTResult findNearestToken(String content, int start){
        int minIndex = content.length();
        Matcher minMatchObj = null;
        SpanToken minTokenType = null;
        for(int i=0; i < tokenTypes.length; i++){
            SpanToken tokenType = tokenTypes[i];
            Matcher matchObj = tokenType.getPattern().matcher(content);
            if(!matchObj.find(start)) {
                continue;
            }
            if(matchObj.start() < minIndex){
                minIndex = matchObj.start();
                minMatchObj = matchObj;
                minTokenType = tokenType;
                break;
            }
        }
        return new FNTResult(minIndex, minMatchObj, minTokenType);
    }

    public abstract class SpanToken{
        private Pattern pattern = null;
        private SpanToken[] children;
        private String content = null;

        public SpanToken(){}

        public SpanToken(Matcher matchObj){
            init(matchObj);
        }

        public void init(Matcher matchObj, Callable<SpanToken[]> tokenize){
            String group = matchObj.group(1);
            // If match is of type link, group(1) may be null
            if(group == null)
                group = matchObj.group(2);
            children = tokenize(group);
        }

        public abstract Pattern getPattern();

        public abstract String getContent();

        public SpanToken[] getChildren(){
            return children;
        }
    }

    public class H3 extends SpanToken{
        private Pattern pattern = Pattern.compile("\\=\\=\\=([^\\s*].*?)\\=\\=\\=");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class H2 extends SpanToken{
        private Pattern pattern = Pattern.compile("\\=\\=([^\\s*].*?)\\=\\=");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class H1 extends SpanToken{
        private Pattern pattern = Pattern.compile("=(.*?)=");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class ULElem extends SpanToken{
        private Pattern pattern = Pattern.compile("\\* ([^\\s*].*)$");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class OLElem extends SpanToken{
        private Pattern pattern = Pattern.compile("\\d\\. ([^\\s*].*)$");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class Bold extends SpanToken{
        private Pattern pattern = Pattern.compile("\\*(.*?)\\*");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class Italic extends SpanToken{
        private Pattern pattern = Pattern.compile("_(.*?)_");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class Link extends SpanToken{
        private Pattern pattern = Pattern.compile("\\[\\[(?:(.*?)\\|)*(.*?)\\]\\]");

        public Pattern getPattern(){
            return pattern;
        }

        public String getContent(){
            return super.content;
        }
    }

    public class RawContent extends SpanToken{
        public Pattern pattern = Pattern.compile(".*");
        private String content = null;
        public String link = null;

        public Pattern getPattern(){
            return pattern;
        }

        public RawContent(String content){
            this.content = content;
        }

        public RawContent(String content, String link){
            this.content = content;
            this.link = link;
        }

        public String getContent(){
            return content;
        }
    }

    private class FNTResult{
        public int index;
        public Matcher matchObj;
        public SpanToken tokenType;

        public FNTResult(){}

        public FNTResult(int index, Matcher matchObj, SpanToken tokenType){
            this.index = index;
            this.matchObj = matchObj;
            this.tokenType = tokenType;
        }
    }
    */
}
