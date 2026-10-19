# Retroalimentación — Laboratorio de Pilas y Colas

**Grupo:** Grupo1 · **Proyecto:** Clínica Veterinaria

Muy buen trabajo con la Cola: quedó casi perfecta. La Pila tiene detalles por pulir.

## Nota

| Criterio | Pilas | Colas |
|---|---|---|
| `Pila<T>` / `Cola<T>` correcta | 25 / 30 | 30 / 30 |
| Casos límite | 5 / 10 | 10 / 10 |
| Integración en entidad y `Service` (Pilas) · Entidad dueña `SalaDeEspera` (Colas, 15) | 20 / 30 | 15 / 15 |
| Menú en `view/` (Pilas 15 · Colas 10) | 6 / 15 | 9 / 10 |
| Integración en el `Service` (solo Colas) | — | 25 / 25 |
| Buenas prácticas (Pilas 15 · Colas 10) | 10 / 15 | 6 / 10 |
| **Total** | **66 / 100** | **95 / 100** |

**Nota del laboratorio: 4.03**

La nota se calcula así: (66 + 95) / 2 = 80.5 sobre 100, y eso dividido entre 20.

## 1. Estructuras `Pila<T>` y `Cola<T>`
**Lo que hicieron bien:**
- Ambas usan `Nodo<T>`, no usan colecciones de Java y ninguna operación recorre la cadena.
- En la Cola, al sacar al último elemento `frente` y `fin` quedan vacíos; encolar después de vaciarla funciona.
- `pop`, `peek`, `dequeue` y `front` avisan con excepción y mensaje cuando no hay nada.

**Lo que pueden mejorar:**
- La Pila no tiene un método llamado `size()` (lo llamaron `getTamanio()`).
- `push(null)` se acepta y mete un elemento vacío en la pila; debía lanzar `IllegalArgumentException`.

## 2. Entidad que aloja la estructura
**Lo que hicieron bien:**
- `Animal` guarda la pila de consultas como atributo privado y la crea en el constructor.
- `SalaDeEspera` es igual al diagrama: nombre validado, la fila privada creada en el constructor, solo el getter y sin lógica de filas.

## 3. Integración en el `Service`
**Lo que hicieron bien:**
- Los métodos de la Cola están completos: llegada, atender, ver quién sigue, hay alguien, contar y listar. El listado por rotación deja la fila intacta y atender no borra al animal de la lista.
- El listado de la Pila usa una pila auxiliar y no la destruye.
- Ninguna firma del `Service` entrega la `Pila` ni la `Cola` a la vista.

**Lo que pueden mejorar:**
- `contarConsultas` cuenta la lista y no la pila.
- Para "ver la última consulta" sacan el elemento y lo vuelven a poner; basta con `peek`.
- Deshacer con la pila vacía devuelve `null` en lugar de dejar que la pila avise.

## 4. Menús en `view/`
**Lo que hicieron bien:**
- `MenuColaView` es muy buena: usa `ConsoleUtils`, no usa `try/catch`, pregunta si hay animales antes de atender y no importa nada de las estructuras.
- Ambos menús tienen las seis opciones.

**Lo que pueden mejorar:**
- `MenuPilaView` lee con `Scanner` directamente en vez de `ConsoleUtils` y usa `try/catch`.
- `MenuPilaView` crea su propio `AnimalService` en lugar de recibir el que se creó en `App`: ese servicio no comparte datos con el resto del programa.
- Antes de deshacer o consultar no se pregunta con `sinConsultasPorDeshacer`; se espera a que el servicio devuelva `null`.

## 5. Buenas prácticas
**Lo que hicieron bien:**
- Trabajaron en las ramas `feature/pila-en-el-proyecto` y `feature/cola-en-el-proyecto` y las fusionaron a `main`.
- Hubo commits frecuentes de varios integrantes, casi todos con mensajes claros.

**Lo que pueden mejorar:**
- No siguieron la estructura de carpetas acordada: `ConsoleUtils` está en `view/` en vez de `utils/`.
- Algunos mensajes son poco útiles ("Update App.java").
- La clase `Dueño` lleva eñe en el nombre; es mejor evitarla en nombres de Java.
