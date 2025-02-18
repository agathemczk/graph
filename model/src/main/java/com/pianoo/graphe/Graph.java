package com.pianoo.graphe;

import com.google.gson.Gson;
import com.pianoo.graphe.entity.Links;
import lombok.Getter;
import lombok.NonNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public void addNode(@NonNull final INode<E> node) {
        if (!this.nodes.contains(node)) {
            this.nodes.add(node);
        }
    }
}
