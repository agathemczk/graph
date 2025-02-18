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
public class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public void addNode(@NonNull final INode<E> node) {
        if (!this.nodes.contains(node)) {
            this.nodes.add(node);
        }
    }

    @Override
    public void loadFromJson(final String jsonFileName) {
        final URL url = this.getClass().getClassLoader().getResource(jsonFileName);
        if (url == null) throw new FileSystemNotFoundException("Ressource not found: " + jsonFileName);

        final StringBuilder jsonString = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();
            Links links = new Gson().fromJson(jsonString.toString(), Links.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Gson toJson() {
        return null;
    }
}
