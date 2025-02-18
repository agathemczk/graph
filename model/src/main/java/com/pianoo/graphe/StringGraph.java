package com.pianoo.graphe;

import com.google.gson.Gson;
import com.pianoo.graphe.entity.Links;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;

public class StringGraph extends Graph<String> {
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
            for (com.pianoo.graphe.entity.Link link : links) {
                if(!this.hasAlrealdyNodeValuedAs(link.nodes()[0])) this.getNodes().add(new Node<>(link.nodes()[0]));
                if(!this.hasAlrealdyNodeValuedAs(link.nodes()[1])) this.getNodes().add(new Node<>(link.nodes()[1]));
                INode<String> start = this.getNodeByValue(link.nodes()[0]);
                INode<String> end = this.getNodeByValue(link.nodes()[1]);
                start.addLink(new Link<>(start, end, link.weight()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private INode<String> getNodeByValue(final String node) {
        return this.getNodes().stream().filter(n -> n.getValue().equals(node)).findFirst().orElse(null);
    }

    private boolean hasAlrealdyNodeValuedAs(final String node) {
        return this.getNodes().stream().anyMatch(n -> n.getValue().equals(node));
    }

    @Override
    public Gson toJson() {
        return null;
    }
}
