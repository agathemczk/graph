package com.pianoo.graph;

import com.pianoo.graphe.IController;
import com.pianoo.graphe.IModel;
import com.pianoo.graphe.IView;
import lombok.Setter;

public class View implements IView {
    @Setter
    private IModel model;
    @Setter
    private IController controller;
}