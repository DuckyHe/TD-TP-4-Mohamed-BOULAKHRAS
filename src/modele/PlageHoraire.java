package modele;

public class PlageHoraire implements Comparable<PlageHoraire> {
    private static final int DUREE_MIN = 15;
    private Horaire debut;
    private Horaire fin;

    public PlageHoraire(Horaire debut, Horaire fin) {
        this.debut = debut;
        this.fin = fin;
    
        // Vérifie si l'horaire de fin est avant ou égal à l'horaire de début
        if (fin.toMinutes() <= debut.toMinutes()) {
            throw new ExceptionPlanning("L'horaire de fin doit être après l'horaire de début");
        }
    
        // Vérifie si la durée est inférieure à la durée minimale
        int duree = getDuree();
        if (duree < DUREE_MIN) {
            throw new ExceptionPlanning("La durée doit être d'au moins " + DUREE_MIN + " minutes");
        }
    }

    public int getDuree() {
        int debutMinutes = debut.toMinutes();
        int finMinutes = fin.toMinutes();
        return finMinutes - debutMinutes;
    }

    public String toString() {
        return debut + " - " + fin + " (" + getDuree() + " minutes)";
    }

    public int compareTo(PlageHoraire autre) {
        int debutThis = this.debut.getHeure() * 60 + this.debut.getMinutes();
        int debutAutre = autre.debut.getHeure() * 60 + autre.debut.getMinutes();

        if (debutThis < debutAutre) {
            return -1;
        } else if (debutThis > debutAutre) {
            return 1;
        }
        return 0;
    }
}