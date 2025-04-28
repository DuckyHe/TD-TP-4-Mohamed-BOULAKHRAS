package modele;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder( MethodOrderer.OrderAnnotation.class)
public class HoraireTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Order(1)
    @Test
    public void testToMinutes() {
        Horaire h = new Horaire(8, 30);
        assertEquals(510, h.toMinutes(), "8h30 doit donner 510 minutes");
        Horaire h1 = new Horaire(12, 0);
        assertEquals(720, h1.toMinutes(), "12h00 doit donner 720 minutes");
        Horaire h2 = new Horaire(23, 59);
        assertEquals(1439, h2.toMinutes(), "23h59 doit donner 1439 minutes");
    }
    @Order(2)
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