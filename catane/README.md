Bonjour, bienvenue sur notre projet.
Pour tester notre jeu veuillez proceder aux etapes suivantes :

1. Creer le repertoire Cortial-Mollo

2. Decompresser l'archive Cortial-Mollo.zip dans le repertoire ci-dessus

3. Nous avons un projet Maven donc si vous souhaitez lancer les tests veuillez proceder ainsi :
    
    - Telecharger Maven (3.6.x)
    - Se mettre a la racine du sous repertoire catane/
    - Faire la commande "mvn test" qui va lancer tout les tests unitaires

4. Notre jeu peut se jouer a la fois dans une interface graphique et dans le terminal. Vous pouvez le lancer de 2 manières differentes :

    - Premiere façon de faire :
        - Se mettre a la racine du sous repertoire projetPJ/
        - Faire la commande "./CataneConsole.sh" si vous voulez lancer la version du jeu qui se joue dans le terminal
        - Faire la commande "./CataneGui.sh" si vous voulez lancer la version du jeu qui se joue dans l'interface graphique

    - Deuxieme façon de faire :
    
    A la racine de catane/ vous avez un fichier qui se nomme pom.xml. Dans ce fichier dans la balise <properties> (ligne 95 à 104)
    vous avez deux lignes pour lancer le jeu.
    Soit la version interface graphique :
            <main.class>gui.CataneGui</main.class>
    Soit la version du terminal :
            <main.class>principal.Catane</main.class>
    Si vous voulez lancer la version interface graphique mettez en commentaire (<!-- la ligne pour la version terminal -->) et vice versa.

    Maintenant pour lancer le jeu suivre ces instructions :
    - Se mettre a la racine de catane/
    - Faire la commande "mvn package"
    - Se placer a la racine de target/ (un sous reperoire de catane/) 
    - Faire la commande "java -jar catane-1.0.0-SNAPSHOT.jar"

    
    
