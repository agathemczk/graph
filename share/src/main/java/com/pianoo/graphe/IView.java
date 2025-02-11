package com.pianoo.graphe;

import lombok.NonNull;

public interface IView {
    void setModel(@NonNull final IModel model);
    void setController(@NonNull final IController controller);
}