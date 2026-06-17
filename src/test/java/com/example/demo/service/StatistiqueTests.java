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
    Voiture voiture;
    Voiture voiture2;

    @BeforeEach
    void setUp(){
        statistique = new StatistiqueImpl();
        voiture = new Voiture("Peugeot", 20000);
        voiture2 = new Voiture("Renault", 15000);
    }

    @Test
    void testAjouter(){
        statistique.ajouter(voiture);
        assertEquals(1, statistique.prixMoyen().getNombreDeVoitures());
        assertEquals(20000, statistique.prixMoyen().getPrixMoyen());
    }

    @Test
    void testPrixMoyen(){
        statistique.ajouter(voiture);
        statistique.ajouter(voiture2);
        assertEquals(2, statistique.prixMoyen().getNombreDeVoitures());
        assertEquals(17500, statistique.prixMoyen().getPrixMoyen());
    }

    @Test
    void testPrixMoyenException(){
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }

    @Test
    void testAjouterException(){
        statistique.ajouter(null);
        assertThrows(NullPointerException.class, () -> statistique.prixMoyen());
    }

}
