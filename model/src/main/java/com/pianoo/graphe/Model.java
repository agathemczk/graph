package com.pianoo.graphe;

public class Model implements IModel {
    private final IGraph <Node<String>> graph = new Graph<>();

    public Model () {
        this.graph.loadFromJson("AventuriersDuRailEurope.json");
    }
}
