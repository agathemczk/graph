//le record ça sert à stocker des objets qui ne sont pas modifiables
package com.pianoo.graphe.entity;
import java.util.List;

public record Link(int weight, String[] nodes) {

}
