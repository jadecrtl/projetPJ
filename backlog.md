# ProjetPJ

## Les règles à implémenter dans le jeu :

1. Il faut qu’un joueur soit capable de :

- [ ] construire des routes, colonies, villes;
- [ ] consulter ses ressources ;
- [ ] gérer le personnage du voleur en cas de 7 aux dés ;
- [ ] acheter, stocker, utiliser les cartes spéciales de développement ;
- [ ] échanger des ressources via les ports.

* Le score se calcule simplement à partir du nombre de ville et de cités construites.

2. Vous remarquerez cependant qu’il y a aussi des bonus particuliers :
- [ ] le tirage d’une certaine carte de développement ;
- [ ] le fait d’être celui qui a joué le plus de chevaliers ;
- [ ] le fait d’être le joueur qui a la route la plus longue
    **(ce problème est un peu plus délicat et intéressant algorithmiquement).**


3. Dans le projet il faudra une classe pour :
- [ ] Plateau.java qui aura un attribut de type enum pour le type de la tuile (champ, foret, pre, montagne, colline, desert);
- [ ] Jeu.java qui gerera tout les tours et ce que peux faire le joueur et ce qu'il obtiendra
- [ ] Joueur.java qui aura un attribut de type enum pour la couleur (bleu, blanc, rouge); couleur des colonies, routes et villes
- [ ] Ressources.java qui aura un attribut de type enum pour le type de la ressource (ble, bois, laine, minerai, argile);
- [ ] De6Faces.java qui s'occupera de lancer un dé pour obtenir un chiffre entre 1 et 6;
- [ ] TypeDeveloppement.java qui est une classe enum pour les cartes de développement;
- [ ] IA.java qui est une classe pour gérer ce que fait l'IA;
- [ ] interface Piece qui aura un attribut enum Couleur et un int pv et autres méthodes;
- [ ] Route.java qui implemente l'interface Piece;
- [ ] Colonie.java qui implemente l'interface Piece;
- [ ] Ville.java qui implemente l'interface Piece;
- [ ] Voleur.java qui héritera de la classe Joueur.java;
- [ ] TuileCarree.java qui a un attribut int jeton;
- [ ] PocheDeJetons.java il faut trouver le nombres de jeton de chaques chiffres comme dans le vrai jeu catan et après on pioche dedans



4. Liste de story et méthodes :
- [ ] Pouvoir choisir le nombre de joueurs dans la partie (3 ou 4)
- [ ] Pouvoir sélectionner "IA" ou "humain" pour chaques joueurs
- [ ] Concevoir le plateau avec les cases
- [ ] Assigner à chaques cases du plateau un chiffre entre 2 et 12 
            Sur le plateau il y a :
            - Une case désert
            - Une case 2, une case 3, une case 4, une case 11 et une case 12
            - Deux cases 5, deux cases 6, deux cases 8, deux cases 9 et deux cases 10
            - Pas de case 7 (quand on a 7 on a le cas du personnage voleur)
- [ ] créer une option en appuyant sur une touche pour voir nos ressources (matériaux et cartes et fiche)
- [ ] on doit pouvoir connaître les ressources dispo de tout le monde
- [ ] Faire la somme des résultats des 2 dés qui sont lancés
- [ ] Pouvoir acheter, stocker et utiliser des cartes spéciales de développement
- [ ] Au bout d'une suite de 5 routes recevoir la fiche "route la plus longue" (a voir)
- [ ] Faire le bonus de sauvegarder et charger notre partie
