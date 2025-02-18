package com.pianoo.graphe;

public class Model implements IModel {
    private final IGraph <String> graph = new StringGraph();

    public Model () {
        this.graph.loadFromJson("AventuriersDuRailEurope.json");
    }
}
