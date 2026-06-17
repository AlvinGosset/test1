package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StatistiqueTests {
    Statistique statistique;
    @BeforeEach
    void setUp(){
        statistique = new StatistiqueImpl();
    }

    @Test
    void testAjouter(){
        Voiture voiture = new Voiture("Peugeot", 20000);
        assertThrows(NullPointerException.class, () -> statistique.ajouter(null));
        statistique.ajouter(voiture);
        assertEquals(1, statistique.prixMoyen().getNombreDeVoitures());
        assertEquals(20000, statistique.prixMoyen().getPrixMoyen());
    }

    @Test
    void testPrixMoyen(){
        Voiture voiture = new Voiture("Peugeot", 20000);
        Voiture voiture2 = new Voiture("Renault", 15000);
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
        statistique.ajouter(voiture);
        statistique.ajouter(voiture2);
        assertEquals(2, statistique.prixMoyen().getNombreDeVoitures());
        assertEquals(17500, statistique.prixMoyen().getPrixMoyen());
    }

    

}
