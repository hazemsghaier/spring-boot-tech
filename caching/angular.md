Les pipes sont une fonctionnalité essentielle
d’Angular qui permettent de transformer des données
directement dans les templates.

Un pipe est une classe décorée avec
@Pipe qui implémente l’interface PipeTransform

**Type des pipes**:
+ Pipes purs (Pure pipes) – par défaut:Sont exécutés uniquement quand
l’entrée change (par référence pour les objets/tableaux).
+ Pipes impurs (Impure pipes):Sont exécutés à chaque itération de la boucle de rendu.


providedIn: Component :
Créer un service local à un composant

Component({
selector: 'app-counter',
template: `
    <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
      <p>Compteur : {{ counterService.count }}</p>
      <button (click)="counterService.increment()">+1</button>
      <button (click)="counterService.reset()">Reset</button>
    </div>
  `,
standalone: true,
providers: [CounterService] // ← Clé du comportement !
})

Les providers sont exécutés au démarrage de l'application, dans le fichier main.ts
