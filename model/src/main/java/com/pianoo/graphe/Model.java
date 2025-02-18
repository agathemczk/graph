package com.pianoo.graphe;

public class Model implements IModel {
    private final IGraph <String> graph = new StringGraph();

    public Model () {
        this.graph.loadFromJson("AventuriersDuRailEurope.json");
        StringTreeNode root = new StringTreeNode("Paris");
        root.addChild(new StringTreeNode("Londres"));
        root.addChild(new StringTreeNode("Brest"));
        System.out.println(root);
        System.out.println(root.toPrettyText());
    }
}
