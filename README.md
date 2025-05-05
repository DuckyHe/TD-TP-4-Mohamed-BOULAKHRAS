Exercice 5
1) Ascendante.
Parce qu'on teste d'abord les petites méthodes (comme toMinutes()), avant les grandes méthodes (comme compareTo()), pour trouver les erreurs plus facilement.

2) La partition d'équivalence n'est pas utile pour toMinutes()
Parce que toMinutes() fait juste un calcul simple (heure × 60 + minutes). Il n'y a pas de cas différents à séparer.

3) Il faut versionner
À chaque ajout ou modification de méthode, il faut faire un commit avec un message clair.

4) Ordonner les tests et re-exécuter
Il faut mettre un @Order différent pour chaque test, puis relancer les tests et vérifier que tout passe.

5) Non,
Chaque test doit avoir un numéro d'ordre unique. Sinon l'ordre d'exécution n'est pas garanti.

Exercice 6 

4) assertNotNull(plage) :
Vérifie que l'objet PlageHoraire a bien été créé et n'est pas null.

assertEquals(60, plage.getDuree()) :
Vérifie que la méthode getDuree() retourne la durée correcte (en minutes) entre les horaires de début et de fin.
