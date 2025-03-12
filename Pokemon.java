package com.sebas;

import java.util.Arrays;
import java.util.List;

public class Pokemon {
    String name;
    String type1;
    String type2;
    List<String> abilities;
    
    public Pokemon(String name, String type1, String type2, String abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = Arrays.asList(abilities.split(", "));
    }
    
    @Override
    public String toString() {
        return name + " - " + type1 + (type2.isEmpty() ? "" : "/" + type2) + " - " + String.join(", ", abilities);
    }
}
