package com.pianoo.graphe;

import com.am.treenode.NaryTreeNode;
import com.google.gson.Gson;
import lombok.NonNull;

import java.util.List;

public interface IGraph<E> {
    List<INode<E>> getNodes();
    void addNode(@NonNull final INode<E> node);

    void loadFromJson(final String jsonFileName);
    Gson toJson();

    NaryTreeNode<INode<E>> getMinSpanningTreeByPrim();
}