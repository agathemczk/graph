package com.pianoo;
import com.pianoo.graph.View;
import com.pianoo.graph.Controller;
import com.pianoo.graphe.*;

public class Main {
    public static void main(String[] args) {
        IView view = new View();
        IModel model = new Model();
        IController controller = new Controller();
        controller.setModel(model);
        controller.setView(view);
    }
}