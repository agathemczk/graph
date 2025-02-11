package com.pianoo.graphe;

import lombok.NonNull;

public interface IController {
    void setModel(@NonNull final IModel model);
    void setView(@NonNull final IView view);
}