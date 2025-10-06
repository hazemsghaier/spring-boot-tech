# Keycloak :
 ## Les Type des Token :
   - **Access Token** : 
     - C'est le token principal qui permet à l'utilisateur d'accéder aux ressources protégées.
   - **Refresh Token** : 
     - C'est un token temporaire qui permet de récupérer un nouveau access token.
   - **ID Token** : 
     - C'est un token qui contient des informations sur l'utilisateur.
     - Il est utilisé pour authentifier l'utilisateur.
   - **Action Token** : 
     -  c’est un lien temporaire et sécurisé que Keycloak génère pour permettre à un utilisateur de faire une action sensible sans être connecté.
 ## Realm :
   - c’est comme un espace isolé où tu gères :Les utilisateurs, Les applications (clients), Les rôles, Les politiques d’authentification, Et d’autres paramètres de sécurité.
   - **Realm Configuration** :
     - **Unmanaged Attributes** dans Keycloak, c’est un endroit où tu peux stocker des données personnalisées (comme des métadonnées) sur un utilisateur, sans que Keycloak ne les gère ni ne les valide.
     - **Display name** : Nom d'affichage pour l'interface utilisateur.
     - **HTML Display name** : Nom avec formatage HTML
     - **Email** : configuration SMTP pour envoyer des emails.
     - **Clients**: les applications autorisées à utiliser ce Realm.
     - **Users**: les utilisateurs autorisés à utiliser ce Realm.
     - **Theme** : l'apparence des pages de login, d’inscription, etc.
     - **Login Settings**: 
       - **User registration** : Permet aux utilisateurs de s'inscrire eux-mêmes
       - **Edit username** : Permet aux utilisateurs de modifier leur nom d'utilisateur
       - **Forgot password** : Active la fonctionnalité de récupération de mot de passe.
       - **Remember Me** : Ajoute une case "Se souvenir de moi" sur la page de connexion.
       - *Verify email** : Demande vérification de l'email à l'inscription
       - **Duplicate emails** : Autorise plusieurs comptes avec le même email
     - **Events** : un évènement important qui se produit dans Keycloak 
     (Un utilisateur s’inscrit ✅ Un utilisateur se connecte 🔐 Un mot de passe est changé 🔄 Une session expire ⏳)
       - **Event Listener** : C’est un module qui écoute ces événements et fait quelque chose quand ils arrivent.
       - **User events settings** : quels événements utilisateur tu veux logger .
       - **Admin events settings** : événements d’admin
     - Client Policy :
       - La Client Policy (politique client) dans Keycloak, c’est un ensemble de règles de sécurité que tu imposes aux applications (appelées clients) qui veulent se connecter à Keycloak.
       - on definit des regle (appelées policies) et des conditions (profiles) :
         -  Règle : « L’URI de redirection doit commencer par https://. »
       - Executor : définit l’action à prendre quand une règle n’est pas respectée.
         - pkce-enforcer → Vérifie que PKCE est utilisé, sinon bloque la requête.
     - **User Registration** : C’est la fonctionnalité qui permet à un utilisateur de créer son propre compte dans Keycloak sans l’aide d’un admin.
     - **User Profile**:
       - Définit quels champs(email, téléphone, etc.) sont demandés, obligatoires ou cachés
       - on peut ajouter des validateur .
       - on peut ajouter les permission pour un champ ou si il est required ou non.
     - **Authentication Flow**:c’est l’enchaînement des étapes qu’un utilisateur doit suivre pour se connecter.
## Notion Securite :
  + **scope**: c’est une étiquette qui dit. C’est un moyen de limiter les permissions d’une application.
  + **Client Scope**: c’est un paquet de configurations réutilisable que tu peux attacher à un ou plusieurs clients.
  + Le nom d’un Client Scope (ex. : admin-api) devient lui-même un scope OAuth que les clients peuvent demander.
  + **Mapper**: c’est un composant qui définit comment les données utilisateur sont mappées dans le token.
  +  **Assign Role to a Scope**C’est une façon de lier des rôles  à un Client Scope, pour qu’ils soient inclus automatiquement dans le token seulement si ce scope est demandé.
  + **Realm Role**: est une étiquette de permission que tu crées au niveau du Realm (ton espace Keycloak) pour gérer ce qu’un utilisateur a le droit de faire.
  + 

   
-+ pour liée keycloak a une base de donnée au lieu du h2 database par defaut il faut le configurer avec le enviroment variables
 ou via le fichier du configuration
-+ si on veut ajouter un page de login ou autre en peut crée un theme personalisée