package modele;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class HoraireTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compareTo() {
            Horaire h1 = new Horaire(14, 0); // 14h00
            Horaire h2 = new Horaire(12, 0); // 12h00
            Assertions.assertTrue(h1.compareTo(h2) > 0, "h1 doit être après h2");
            Assertions.assertTrue(h2.compareTo(h1) < 0, "h1 doit être avant h2");
            Horaire h3 = new Horaire(9, 30); // 09h30
            Horaire h4 = new Horaire(9, 30); // 09h30

            Assertions.assertEquals(0, h3.compareTo(h4));
        }

}