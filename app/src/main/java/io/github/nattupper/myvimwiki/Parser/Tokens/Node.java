package io.github.nattupper.myvimwiki.Parser.Tokens;

public interface Node {
    public void accept(Visitor visitor);
}
