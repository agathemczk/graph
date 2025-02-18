package com.pianoo.graphe.entity;

import java.util.ArrayList;
import java.util.List;

public class ELink extends Entity {
    private final int weight;
    private final List<String> nodes = new ArrayList<>();

    public ELink(final int weight) {
        this.weight = weight;
    }

}
