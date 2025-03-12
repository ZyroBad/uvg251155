package com.sebas;

import java.io.IOException;
import java.util.Scanner;

public class PokemonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokemonManager manager = new PokemonManager();
        
        try {
            System.out.print("Ingrese la ruta del archivo CSV: ");
            String filePath = scanner.nextLine();
            manager.loadPokemons(filePath);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return;
        }
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección del usuario");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    manager.addPokemonToCollection(name);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    name = scanner.nextLine();
                    manager.showPokemon(name);
                    break;
                case 3:
                    manager.showUserCollection();
                    break;
                case 4:
                    manager.showAllByType();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = scanner.nextLine();
                    manager.searchByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}

