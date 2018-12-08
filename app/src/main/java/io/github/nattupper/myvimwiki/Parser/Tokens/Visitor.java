package io.github.nattupper.myvimwiki.Parser.Tokens;

public interface Visitor {
    void visit(Document node);

    void visit(Header node);

    void visit(List node);

    //void visit(LineBreak node);

    void visit(Paragraph node);
}
