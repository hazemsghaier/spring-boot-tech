# Caching Spring boot :
  ### @EnableCaching: 
 pour mettre en place le caching dans une application 
 spring boot, il faut ajouter l'annotation **@EnableCaching**
 sur la classe principale de l'application.
 ### @CachePut:
   1.  Toujours exécuter la méthode, puis mettre à jour le cache avec le nouveau résultat.
   2. La méthode est toujours exécutée.
   3. Le résultat est stocké dans le cache, même s’il existait déjà.
   4. Utilisation typique : Opérations de mise à jour (save, update)
  ### @Cachabale :
 1. À l’appel de la méthode, Spring intercepte l’appel (grâce à un proxy AOP).
 2. Il calcule une clé de cache (par défaut, basée sur les paramètres de la méthode).
    3. Il vérifie si une valeur correspondant à cette clé existe déjà dans le cache spécifié.
        - ✅ Si oui : la méthode n’est pas exécutée. La valeur en cache est directement retournée.
        - ❌ Si non : la méthode est exécutée normalement, son résultat est stocké dans le cache, puis retourné.
 ### CacheManage :
Le CacheManager est une interface centrale dans Spring 
qui gère l’accès aux caches utilisés par l’application. 
C’est lui qui crée, récupère et supervise
les instances de cache (comme "users", "products", etc.) 
## Type of caching :
### InMemoryCaching :
  - elle ne peut pas servrire dans un architecture 
   micro-service ou une scalability horisantale
### Distributed caching: 
  - distributed caching is using an externaltool like redis for caching data
  - this approche will help beacause it give us concetency of caching 
   across multiple instances of the application.
## Level of caching: 
  1. Client Level : 
        - it is the most efficient way 
        like the client store frequent accessed image in his web browser
  2. CDN caching : 
  3. WebServer caching : 
  4. Application caching : 
  5. Database caching : 
## evication policy : 
  - LRU : least recently used.
  - LFU : least frequently use.
  - TTL : time to live.
  - LIFO : last in first out.
  - Random Replacement.