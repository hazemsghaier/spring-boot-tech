## c est quoi elasticSearch ?
 - Elasticsearch est un moteur de recherche distribué, open source, très puissant et largement utilisé pour la recherche en texte intégral, l’analyse de logs,
  la surveillance, la recherche sémantique
## index :
  - un index dans elasticsearch est comme une base du donnée dans un systeme sgbd .
  - Quand tu indexe un document, Elasticsearch infère automatiquement le type de chaque champ 
  - Ce mapping est stocké au niveau de l’index, pas du document.
  - Si un nouveau document contient un nouveau champ, Elasticsearch l’ajoute au mapping .
  - Si tu essaies d’indexer **un champ déjà existant** dans le mapping, mais avec **un type incompatible** , Elasticsearch refusera le document.
## Document :
  - un document est **un objet JSON** qui est indexé dans un index.
  - Unité de base de données dans Elasticsearch.
  - Chaque document a un ID unique.
## Les Type D elasticSearch :
 - **Binary** : 
    -  Sert à stocker des données binaires encodées en Base64 .
    - Non stocké individuellement par défaut.
    - Accessible uniquement via _source.
 - **Boolean** : 
   -  Représente les valeurs true / false.
   -  Indexé et searchable.
   -  Utilisable dans les agrégations, tris et scripts.
 - **Number** : 
    - Indexés, searchable, triables.
    - Parfaits pour agrégations.
    - Pas de mélange de types : un champ integer ne peut pas recevoir une valeur double après coup.
 - **Date** : 
   -  Stocke des dates/heures au format millisecondes UNIX .
   -  Indexé et searchable : filtres par plage (range), tri, agrégations temporelles (date_histogram).
   - Si le format entrant ne correspond pas au mapping → erreur d’indexation.
 - **Object**:
   - 
 - **Ip** : 
   -  Un type optimisé pour stocker et interroger des adresses IPv4 ou IPv6.
- <span style="color:Green;font-size:20px">**Keyword**</span> :
    - Le type keyword sert à stocker des textes qu’on veut traiter comme des valeurs exactes — sans les découper ni les modifier.
    - Indexés, triable, filtrable.
 - <span style="color:Green;font-size:20px">**Text**</span>   : 
   - Le type text est utilisé pour le contenu textuel qu’on veut rendre recherchable en texte intégral (full-text search).
   - Ce que tu NE PEUX PAS faire avec text:
     - Filtrer avec term
     - Trier
     - Agréger avec terms
 


# Search API:
C’est l’API principale pour interroger les données dans Elasticsearch.
  - from :le point du depart d ou en return la resultat
  - size :le nombre de resultat a return 
  - timeOut :le temps d execution de la requete maximum a attendée.
  - _source: qu elle champ a retournée.
  - query: Définit CE QUI est recherché
  - sort: Définit la façon dont les résultats seront triés.
  - aggs: Définit les agrégations à effectuer sur les résultats.
  - post_filter: Filtre APRES les agrégations.
# Deep pagination :
 -  Au lieu de compter les pages, tu continues à partir du dernier résultat vu.
 -  u dois trier sur un champ unique (ex : _id ou timestamp + _id).
 - Tu récupères le dernier sort value de la page précédente
 - Tu le passes dans search_after
 - Pas de saut direct à la page 500 (tu dois parcourir séquentiellement)
 - il faut stocker la dernier sort value du recherche avant.
 - necessite un recherche avant.
 - Nécessite un tri stable et unique
#  Ingest Pipeline:
Un ingest pipeline est une chaîne de traitement qui transforme un document avant qu’il soit indexé dans Elasticsearch.
 -
# SQL API :
L’SQL API permet d’interroger Elasticsearch avec une syntaxe SQL (comme dans une base de données relationnelle),
au lieu d’utiliser le JSON Query DSL.
- Tu veux faire des requêtes simples (filtres, agrégations, tris).