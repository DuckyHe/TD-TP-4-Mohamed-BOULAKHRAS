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
    @Order(3)
    @Test
    void testGetDuree() {
        Horaire debut = new Horaire(8, 0); // 08h00
        Horaire fin = new Horaire(10, 30); // 10h30
        PlageHoraire plage = new PlageHoraire(debut, fin);
        assertEquals(150, plage.getDuree(), "La durée entre 08h00 et 10h30 doit être 150 minutes");
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
        Horaire debut1 = new Horaire(8, 0); // 08h00
        Horaire fin1 = new Horaire(9, 0); // 09h00
        Horaire debut2 = new Horaire(9, 0); // 09h00
        Horaire fin2 = new Horaire(10, 0); // 10h00
        PlageHoraire plage1 = new PlageHoraire(debut1, fin1);
        PlageHoraire plage2 = new PlageHoraire(debut2, fin2);
        assertTrue(plage1.compareTo(plage2) < 0, "La première plage doit être avant la deuxième");
        assertTrue(plage2.compareTo(plage1) > 0, "La deuxième plage doit être après la première");
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

    @Order(4)
    @Test
    void testConstructeur() {
    Horaire debut = new Horaire(8, 30); // 08h30
    Horaire fin = new Horaire(9, 30); // 09h30
    PlageHoraire plage = new PlageHoraire(debut, fin);
    assertNotNull(plage, "L'objet PlageHoraire ne doit pas être null");
    assertEquals(60, plage.getDuree(), "La durée doit être de 60 minutes");
    }

    @Order(5)
    @Test
    void testConstructeurExceptionHoraireInvalide() {
        Horaire debut = new Horaire(10, 0); // 10h00
        Horaire fin = new Horaire(9, 0); // 09h00 (fin avant début)
        ExceptionPlanning exception = assertThrows(ExceptionPlanning.class, () -> {
            new PlageHoraire(debut, fin);
        });
        assertEquals("L'horaire de fin doit être après l'horaire de début", exception.getMessage());
        }
}