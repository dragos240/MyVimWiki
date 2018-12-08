package io.github.nattupper.myvimwiki.Parser.Tokens;

public class Document extends SimpleNode {
    private Class[] nodeClasses = {
            Header.class, List.class, //Paragraph.class
    };
    private String type = "Document";

    public Document(String in){
        int offset = 0;

        while(offset < in.length()-1) {
            System.out.println("offset: "+offset);
            for (Class nodeClass : nodeClasses) {
                SimpleNode node = null;
                try {
                    node = (SimpleNode) nodeClass.newInstance();
                    if (node.isNode(in)) {
                        int output = node.processAndStore(in, offset);
                        if(output != -1)
                            offset = output;

                        addChild(node);
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void printTree() {
        System.out.printf("Printing node tree for %d nodes...\n", children.length);
        System.out.println(type);
        for(SimpleNode child: children){
            if(child.children.length == 0){
                child.printTree();
            }
        }
    }

    public SimpleNode[] getChildren(){
        return children;
    }
}
