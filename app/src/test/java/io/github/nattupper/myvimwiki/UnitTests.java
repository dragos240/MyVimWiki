package io.github.nattupper.myvimwiki;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.nattupper.myvimwiki.Parser.Tokens.Document;
import io.github.nattupper.myvimwiki.Parser.Tokens.Header;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    public void formattedTextTest(){
        String[] patternStrings = {
                "===Test===", "==Test==", "=Test=",
                "* Test", "1. Test", "*Test*",
                "_Test_", "[[Test1]]", "[[Test1|Test2]]",
                "[[]]", "Test", "_*Test*_"
        };
        String multilineString = "===Test===";

        //VisitorImpl vi = new VisitorImpl();
        Document document = new Document(patternStrings[3]);
        //vi.feed(patternStrings[0]);
        document.printTree();
    }

    @Test
    public void patternMatchTest(){
        String testStr = "===Test===";
        Pattern pattern = Pattern.compile("===(.*?)===");
        Matcher matcher = pattern.matcher(testStr);
        System.out.println("Matches?: "+matcher.matches());
        System.out.println("gc: "+matcher.groupCount());
        System.out.println("First group match: "+matcher.group(1));
        System.out.println("End: "+matcher.end(1));
    }

    @Test
    public void printfTest(){
        int num = 3;
        System.out.printf("%"+num+"s%s(%d): %s\n", " ", "Str", 0, "Str2");
    }
}