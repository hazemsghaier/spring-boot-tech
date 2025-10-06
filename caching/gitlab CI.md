# Gitlab CI
 ## Runner :
   - un runner est un agent qui exécute les jobs d’un pipeline.
   - Chaque runner utilise un executor qui définit comment les jobs sont exécutés.
   - les Type d executor sont les suivant :
     - shell : Exécute les commandes directement dans le
       shell du serveur
     - kubernetes : Crée des pods Kubernetes pour chaque job
 ## tags :
   - les tags permettent de filtrer les runners disponibles pour un job.
 ## stages :
   - les stages (étapes) permettent d’organiser les jobs (tâches) d’un pipeline en une séquence logique d’exécution.
   - Chaque stage regroupe un ou plusieurs jobs qui peuvent s’exécuter en parallèle, mais les stages eux-mêmes s’exécutent dans l’ordre défini.
 ## Job :
   - contient un ensemble d’instructions à exécuter sur un runner.
   - S’exécute de façon isolée (dans son propre environnement).
   - Peut appartenir à un stage (étape) spécifique.
   - Peut produire ou consommer des artefacts.
   - Peut être conditionné (ex : exécuté uniquement sur certaines branches).
   ### Composant du job :
   - script : **Obligatoire** Liste des commandes shell à exécuter.
   - stage : Définit à quel stage le job appartient.
   - image : Spécifie l’image Docker à utiliser pour exécuter le job (si le runner est un conteneur).
   - **Services** :  
     - lance un conteneur Docker à côté.
     -  Lit les variables d'environnement
     -  Accessible via son nom (pas localhost)
   - **before_script** : 
     - Scripts qui s'exécutent AVANT le script principal pour PRÉPARER l'environnement.
     - before_script échoue → script NE S'EXÉCUTE PAS
     - il a deux niveau **Globale** et **Local** le premiere s execute avant chaque job et l autre e t specifique a une job .
   - **after_script** :
     - Scripts qui s'exécutent APRÈS le script principal pour NETTOYER ou FINALISER.
     - s'exécute TOUJOURS, même si le job échoue !
     - il a deux niveau **Globale** et **Local** le premiere s execute avant chaque job et l autre e t specifique a une job .
     - Le LOCAL REMPLACE COMPLÈTEMENT le GLOBAL
     - after_script échoue → Le job reste dans son état
     - on peut l utilisée pour faire une tache apres l execution  qu elle n est pas obligatoire ou du netoyer les donnée utilisée.
   - **Rules** : Contrôle SI et QUAND un job doit s'exécuter avec une logique conditionnelle puissante.
   - **allow_failure**:Permet au job d'échouer SANS faire échouer le pipeline entier.
   - **when** :Contrôle QUAND le job doit démarrer.
     - on_success: Défaut - Exécute si les jobs précédents réussissent
     - on_failure: Exécute si un job précédent échoue
     - always: Exécute toujours, peu importe le résultat
     - never: Exécute jamais, peu importe le résultat
     - manualExécute : seulement si déclenché manuellement
   - **needs** : permet à un job d'attendre des jobs SPÉCIFIQUES (même dans d'autres stages).
  ## Artifacts :
   - Les artifacts sont stockés sur le serveur GitLab, pas dans les conteneurs.
   - Les jobs du même pipeline téléchargent automatiquement TOUS les artifacts des jobs précédents.
   - Chaque exécution (run) du pipeline a ses PROPRES artifacts isolés.
   - **artifacts** nous permet du selection les artifacte et meme le donnée un nom.
   - 
   - **dependencies** : Contrôler QUELS artifacts télécharger.
   - **needs** : attendre des job a complete avant qu il va s executée.
  ## Variables dans GitLab CI :
   - GitLab fournit automatiquement des variables pour chaque pipeline (Built_in).
   - Variables de Projet : éfinies dans l'interface GitLab : Settings > CI/CD > Variables.
   - Variables de Groupe: Définies au niveau du groupe : Group > Settings > CI/CD > Variables
   -  Protected Variables : Disponibles SEULEMENT sur les branches et tags protégés.
   -  Masked Variables :  Masquées dans les logs du job.
   - **variabeles** : cette keyword nous permet de definir des variable dans le fichier .gitlab-ci.yml.
   - Type des variable : Variable,File,



     
