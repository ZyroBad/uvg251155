package com.sebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap = new HashMap<>();
    private Set<String> userCollection = new HashSet<>();
    
    public void loadPokemons(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Leer encabezado y descartarlo
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 8) continue;
                Pokemon p = new Pokemon(data[0], data[2], data[3], data[7]);
                pokemonMap.put(p.name, p);
            }
        }
    }
    
    public void addPokemonToCollection(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado");
            return;
        }
        if (!userCollection.add(name)) {
            System.out.println("Error: Pokémon ya en la colección");
        }
    }
    
    public void showPokemon(String name) {
        System.out.println(pokemonMap.getOrDefault(name, new Pokemon("No encontrado", "", "", "")));
    }
    
    public void showUserCollection() {
        userCollection.stream()
            .map(pokemonMap::get)
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(System.out::println);
    }
    
    public void showAllByType() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(System.out::println);
    }
    
    public void searchByAbility(String ability) {
        pokemonMap.values().stream()
            .filter(p -> p.abilities.contains(ability))
            .forEach(System.out::println);
    }
}

