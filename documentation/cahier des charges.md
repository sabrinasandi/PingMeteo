# Sommaire 

- [Cadrage & périmètre](#cadrage--périmètre) 
     
- [Expression fonctionnelle du besoin](#expression-fonctionnelle-du-besoin)
  - [Modélisation conceptuelle et logique des données](#modélisation-conceptuelle-des-données)  
  - [Répartition des tâches](#répartition-des-tâches)

- [Méthodes et contraintes ](#méthode-et-contraintes) 
  - [Méthode](#méthode)
- [Délais et parties prenantes ](#délais-et-parties-prenantes) 
   - [Délais](#délais)
   - [Parties prenantes](#parties-prenantes)
- [Outils](#outils)
- [Conclusion](#conclusion)

- [Bibliographie ](#bibliographie)

# Cadrage & périmètre

Le projet consiste à mettre en place une application mobile météorologique. Le but de se projet est de monter en compétence en programmation mobile, en management de projet et en communication.

# Expression fonctionnelle du besoin

Afin de schématiser nos données et leurs liens entre elles, nous avons choisi de les représenter sous forme de diagramme de classe.

## Modélisation conceptuelle des données

## Diagramme de classe 

![UML 1](https://user-images.githubusercontent.com/57767498/194040310-571c23de-e4e3-4a62-8544-575856a602e4.jpg)
![UML 2](https://user-images.githubusercontent.com/57767498/194040311-2294cb36-adb2-459d-8f25-77fe931a4df4.jpg)

## Répartition des tâches

#### Fonctionnalité 
| Fonction                         | Fonctionnelle (oui/non) |
|:---------------------------------|:------------------------|
| `Afficher informations météo`    |            oui          |
| `Afficher des notifications`     |            non          |
| `Afficher des données récupérées`|            oui          |
| `Seuil`                          |            oui          |
| `Enregistrer des villes`         |            oui          |



# Méthode et contraintes
## Méthode

Nous avons choisi d’utiliser la méthode Kanban pour ce projet. En effet, cette méthode nous permet de travailler de façon organisée. 

>Le kanban fait partie des méthodes agiles, il permet de rendre les processus de travail plus flexible. 
>Les tâches sont divisées en petites étapes à traiter les unes à la suite des autres.
>Cette méthode exige que chaque étape soit achevée avant qu’il ne soit possible de se consacrer à une nouvelle. 
Pour mettre en place cette méthode nous avons choisi l’outil Trello. 
En effet, sur Trello, nous pouvons faire des user stories mais également voir ce qui a déjà été fait ou a déjà été affecté à quelqu'un. Cette méthode d'organisation nous a permis de voir l'avancer du projet chaque semaine et d'adapter la quantité de tâches en cas dépassement de délai sur le développement d'une fonctionnalité par exemple.

## Contraintes
Les contraintes liées aux projets sont nombreuses. Pour cela, nous pouvons les classer en catégorie.  
- Outils rédactionnels & organisationnels  : utilisation de Markdown, Trello et Git 
- Langage de programmation : Java, XML
- Outils de développement : Android Studio, Intellij 
- Récupération des datas : OpenWeather 

# Délais et parties prenantes
## Délais 
Le projet est à livrer à partir de mars 2023.
## Parties prenantes 
| Personnes                | Fonction                                        
| :----------------------- | :-----------------------------|
| Sabrina Sandirasegarane  | Maître d’ouvrage/ Développeuse|
| Davia Moujabber          | Maître d’ouvrage/ Développeuse|
| Keryann In               | Développeur                   |

# Outils

- Outils rédactionnels & organisationnels  : utilisation de Markdown, Trello et Git 
- Langage de programmation : Java, XML
- Récupération des datas : OpenWeather
- Outils diverses : documentation, internet
- Patterns de programmation : MVC
- Base de données : FireBase



# Conclusion 

#### Problèmes rencontrés 
Nous avons eu un petit temps d'adaptation sur l'utilisation d'Android Studio et du langage Java car nous avions peu de pratique au préalable. 

#### Solution trouvées  
Malgré certains problèmes rencontrés, nous avons su faire ça, notre équipe  ont compris l'importance de communiquer via l'outil Trello. Nous avons choisi de bien organiser le code afin d'avoir un code de qualité. En effet, nous avons choisi le pattern de programmation MVC ( modèle vue contrôleur) afin de faire un code de qualité avec le moins de maintenance possible en cas de suppression ou rajout de fonctionnalité. 

Nous avons eu une idée pour améliorer notre application mobile. Celle de l'optimisation en factorisant les demandes d'API sur Firebase pour diminuer les actions requises sur l'application afin d'éviter la surchages de l'application. 

#### Retour personnel sur module 

Ce projet nous a permis de montrer nos compétences, de mettre en place les notions théoriques apprises à la pratique mais aussi d'apprendre de nouveaux outils. Grâce au module, nous avons pu apprendre à mieux travailler en équipe via github. En effet, l'utilisation du Git étant assez floue pour la plupart des membres de l'équipe, ce projet a permis de mieux comprendre le fonctionnement et l'utilisation de Git. 

Il est toujours difficile de réaliser un travail en groupe mais nous avons pu avancer ensemble sur la réalisation de ce projet tout en respectant les méthodes d'organisation que nous avons mise en place dès le début du projet et nous avons atteint tous les objectifs principaux au niveau des fonctionnalités principales que nous avions fixés. 

# Bibliographie 
- [Aide alias de commande](https://github.com/ViBiOh/dotfiles/blob/main/symlinks/gitconfig)
- [Aide Markdown](https://github.com/InseeFrLab/utilitR/blob/master/03_Fiches_thematiques/Fiche_rmarkdown.Rmd)
- [Editeur Markdown](readme.so)

