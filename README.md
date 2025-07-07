# Renamor
## Projet
------
Script Java utilitaire pour renommer automatiquement les photos au format standardisé "yyyy-MM-dd HH-mm-ss" en utilisant les données EXIF ou la date de création du fichier.

## C'est quoi ?
------------
Renamor est un petit outil pratique qui permet d'organiser ses photos en les renommant selon un format de date standardisé. Il lit intelligemment les métadonnées EXIF des photos pour extraire la date de prise de vue réelle, et utilise la date de création du fichier comme solution de repli si les données EXIF ne sont pas disponibles. C'est l'outil parfait pour ranger sa photothèque de manière cohérente et chronologique.

## Technologies Utilisées
-----------------------
- **Langage**: Java
- **Bibliothèque**: metadata-extractor (Drew Noakes)
- **Format de sortie**: yyyy-MM-dd HH-mm-ss
- **Types supportés**: JPG, JPEG

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)
![metadata-extractor](https://img.shields.io/badge/metadata--extractor-2.18.0-blue)

## Fonctionnalités Clés
---------------------
- **Lecture EXIF intelligente**: Priorité aux données EXIF pour la date de prise de vue réelle
- **Fallback automatique**: Utilise la date de création du fichier si pas d'EXIF disponible
- **Format standardisé**: Renommage au format "yyyy-MM-dd HH-mm-ss" pour un tri chronologique optimal
- **Gestion d'erreurs**: Affichage des erreurs et continue le traitement des autres fichiers
- **Filtrage automatique**: Ne traite que les fichiers JPG et JPEG
- **Feedback utilisateur**: Affichage en temps réel des fichiers traités

## Architecture du Projet
------------------------
```
Renamor/
├── src/
│   └── Renamor/
│       └── RenamePhotos.java    # Classe principale
├── lib/
│   └── metadata-extractor.jar   # Bibliothèque pour lecture EXIF
├── build/
│   └── classes/                 # Fichiers compilés
└── README.md                    # Documentation
```

Architecture simple et efficace pour un utilitaire de traitement par lots.

## Par quoi commencer ? 
--------------------
Pour utiliser Renamor sur vos photos :

1. **Prérequis** : Java 8 ou supérieur installé sur votre système

2. **Téléchargement** : Clonez le dépôt
```bash
git clone https://github.com/J4cKr0y/renamor.git
cd renamor
```

3. **Configuration** : Modifiez le chemin dans le code source
```java
File dir = new File("VOTRE_CHEMIN_VERS_DOSSIER_PHOTOS");
```

4. **Compilation** : Compilez le projet
```bash
javac -cp "lib/*" src/Renamor/RenamePhotos.java -d build/classes
```

5. **Exécution** : Lancez le script
```bash
java -cp "build/classes:lib/*" Renamor.RenamePhotos
```

**⚠️ Attention** : Faites toujours une sauvegarde de vos photos avant d'exécuter le script !

## Exemple d'utilisation
----------------------
```
Avant : IMG_20231225_143022.jpg
Après  : 2023-12-25 14-30-22.jpg

Avant : DSC_0001.jpg (sans EXIF)
Après  : 2023-12-25 16-45-30.jpg (basé sur la date de création)
```

## Roadmap et Améliorations Prévues
----------------------------------
- [ ] Support d'autres formats d'image (PNG, TIFF, RAW)
- [ ] Interface graphique simple
- [ ] Gestion des doublons avec suffixes automatiques
- [ ] Configuration par fichier de paramètres
- [ ] Mode batch avec surveillance de dossier
- [ ] Prévisualisation avant renommage
- [ ] Support des fuseaux horaires EXIF
- [ ] Création d'un JAR exécutable

Les contributions sont bienvenues ! N'hésitez pas à ouvrir une issue ou soumettre une pull request.

---
*Développé avec ❤️ par J4cKr0y - Pour une photothèque bien organisée*