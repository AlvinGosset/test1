package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture v = new Voiture("Peugeot", 20000);
        assertEquals("Peugeot", v.getMarque());
        assertEquals(20000, v.getPrix());
    }

    @Test
    void testModifications(){
        Voiture v = new Voiture("Peugeot", 20000);
        v.setMarque("Renault");
        v.setPrix(15000);
        assertEquals("Renault", v.getMarque());
        assertEquals(15000, v.getPrix());
    }

    @Test
    void testVoitureId(){
        Voiture v = new Voiture("Peugeot", 20000);
        assertEquals(0, v.getId());
        v.setId(1);
        assertEquals(1, v.getId());
    }

    @Test
    void testToString(){
        Voiture v = new Voiture("Peugeot", 20000);
        v.setId(2);
        assertEquals("Car{marque='Peugeot', prix=20000, id=2}", v.toString());
    }
}
