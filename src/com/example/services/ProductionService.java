package com.example.services;

import com.example.IMDB;
import com.example.production.Production;

import java.util.List;

public class ProductionService {
    public static List<Production> getAllProductions() {
        return IMDB.getInstance().getProductions();
    }

    public static void addProduction(Production production) {
        getAllProductions().add(production);
    }

    public static void removeProduction(Production production) {
        getAllProductions().remove(production);
    }
}
