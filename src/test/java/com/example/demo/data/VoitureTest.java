package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class VoitureTest {

    private Voiture v;
    @BeforeEach
    void setUp() {
        v = new Voiture("Peugeot", 20000);
    }

    @Test
    void creerVoiture(){
        assertEquals("Peugeot", v.getMarque());
        assertEquals(20000, v.getPrix());
    }

    @Test
    void testModifications(){
        v.setMarque("Renault");
        v.setPrix(15000);
        assertEquals("Renault", v.getMarque());
        assertEquals(15000, v.getPrix());
    }

    @Test
    void testVoitureId(){
        assertEquals(0, v.getId());
        v.setId(1);
        assertEquals(1, v.getId());
    }

    @Test
    void testToString(){
        v.setId(2);
        assertEquals("Car{marque='Peugeot', prix=20000, id=2}", v.toString());
    }
}
