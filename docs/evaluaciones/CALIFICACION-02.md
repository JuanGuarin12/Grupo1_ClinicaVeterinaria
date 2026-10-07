# Retroalimentación — Laboratorio Lista Simple (Momento 2), Parte 2: implementación

**Grupo:** Grupo1 · **Proyecto:** Clínica Veterinaria

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| Relaciones uno-a-muchos | 20 % | 5.0 |
| `ListaSimple<T>` integrada al `Service` | 30 % | 3.5 |
| Menú en consola | 15 % | 4.5 |
| Reemplazo del arreglo previo, sin código muerto | 20 % | 4.5 |
| Buenas prácticas (commits y nombres) | 15 % | 4.0 |
| **Nota de la implementación** | | **4.23** |

La nota se calcula así: 20% relaciones + 30% integración al `Service` + 15% menú + 20% reemplazo del arreglo + 15% buenas prácticas.

## 1. Relaciones uno-a-muchos (5.0)
**Lo que hicieron bien:**
- Eligieron `Animal` con muchas `Consulta` y `Animal` con muchas `Vacuna`: son relaciones reales del caso y coinciden con las sugeridas.
- Además, `Dueño` guarda sus `Animal` en una `ListaSimple`, lo cual tiene sentido.

## 2. `ListaSimple<T>` integrada al `Service` (3.5)
**Lo que hicieron bien:**
- `Animal` guarda las consultas y las vacunas en atributos `ListaSimple`, creados en el constructor.
- `AnimalService` agrega con `insertarFinal`, busca con `buscarPorIndice` y elimina con `eliminarPorValor`.
- `ListaSimple` y `Nodo` están bien hechas y están en su carpeta `structures`.

**Lo que pueden mejorar:**
- La vista `MenuListasView` importa y usa `ListaSimple` directamente. La vista solo debe hablar con el `Service`; que el `Service` entregue los datos de otra forma (por ejemplo, la cantidad de elementos y cada elemento por posición).
- El `Service` no ofrece búsqueda por valor, y la lista no tiene `buscarPorValor`.

## 3. Menú en consola (4.0)
**Lo que hicieron bien:**
- `MenuListasView` permite agregar, listar y eliminar consultas y vacunas, siempre llamando a `AnimalService`.
- En la prueba, todas las opciones funcionaron y mostraron mensajes claros.

**Lo que pueden mejorar:**
- No hay una opción para buscar por nombre o dato, solo listar y eliminar por posición.
- Si la entrada se corta, el menú se repite sin parar en vez de salir.

## 4. Reemplazo del arreglo previo (4.5)
**Lo que hicieron bien:**
- El arreglo de `Dueño` fue reemplazado por `ListaSimple<Animal>` y ya no quedan arreglos ni `ArrayList` en el código.
- Eliminaron comentarios y el `App.Java` viejo.

**Lo que pueden mejorar:**
- Quedó un método `verificarNumeroFicha` en `Animal` que no se usa, y un `TODO` automático en `App`.

## 5. Buenas prácticas (3.5)
**Lo que hicieron bien:**
- Trabajaron con ramas por integrante y las unieron con merges; hay varios commits del grupo.
- Los nombres de clases, métodos y variables siguen las convenciones de Java.

**Lo que pueden mejorar:**
- Algunos mensajes de commit son poco claros (`Update AnimalService.java`, `Eliminacion de comentarios`).
- El último cambio se hizo directo sobre `main`.
- No siguieron la estructura de carpetas acordada en clase: `App` está dentro de `models/domain` en vez de fuera del dominio.

## ¿El programa funciona?
Sí compila sin errores y corre. El menú agregó, listó y eliminó consultas y vacunas correctamente.

## Para el próximo laboratorio
- Que la vista no use `ListaSimple`: que solo reciba datos del `Service`.
- Agregar búsqueda por valor en la lista, el `Service` y el menú.
- Sacar `App` de `domain`.
- Escribir mensajes de commit descriptivos y no trabajar directo en `main`.
