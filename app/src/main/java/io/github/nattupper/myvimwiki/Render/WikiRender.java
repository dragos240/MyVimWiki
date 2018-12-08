package io.github.nattupper.myvimwiki.Render;

public class WikiRender {
    private String data;
    private FormattedText formattedText;

    public WikiRender(){
        this.data = null;
    }

    public WikiRender(String data){
        this.data = data;
    }

    public void processData(){
        //split into lines
        for(String line: data.split("\n")){
            //Headings
            for(String word: line.split("\\ ")){
                if(word.equals("===")){
                }
            }
            //Ordered lists
            //Unordered lists
            //Bold
            //Italic
        }
    }
}
