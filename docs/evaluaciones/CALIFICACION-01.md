# Retroalimentación — Laboratorio 1: Codificación del diseño OO

**Grupo:** Grupo1 · **Proyecto:** Clínica Veterinaria
**Fecha límite:** 2026-09-08 23:59 · **Versión revisada:** commit `4c90016`

Buen trabajo en general. La jerarquía de clases está bien armada y el programa funciona.

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| El código sigue el diagrama UML | 60% | 4.0 |
| Pruebas: creación de objetos en el programa | 20% | 5.0 |
| Buenas prácticas de programación | 20% | 4.0 |
| **Nota del laboratorio** | | **4.20** |

La nota se calcula así: 60% diseño UML + 20% pruebas + 20% buenas prácticas.

## 1. El código sigue el diagrama UML (4.0)
**Lo que hicieron bien:**
- La interfaz `RolEnClinica` tiene los dos métodos que pide el diagrama.
- `Persona` es abstracta, guarda sus datos como privados y revisa que la `identificacion` no llegue vacía. Implementa `datosResumen()` y deja `rolEnClinica()` para que lo resuelva cada hija, como pide el diagrama.
- `Dueño` y `Veterinario` heredan de `Persona`, llaman a `super(...)` y cada uno responde `rolEnClinica()` a su manera.
- `Animal` es una clase independiente (no hereda de `Persona`), tal como debe ser.
- Un `Dueño` puede tener uno o varios `Animal`, y lo resolvieron bien con un arreglo.

**Lo que pueden mejorar:**
- En `Animal` escribieron el método `verificarNumeroficha(...)`, pero el constructor nunca lo llama. Por eso la validación de `numeroFicha` no se ejecuta en la práctica.
- Faltan relaciones del diagrama: una `Consulta` debe saber a qué `Animal` y a qué `Veterinario` corresponde, y una `Vacuna` debe saber a qué `Animal` se aplicó. Hoy esas clases no guardan esas referencias.
- Hay un archivo suelto `src/App.Java` (con "J" mayúscula y fuera del paquete) que es una copia del `App.java` real. No se usa; conviene borrarlo.

## 2. Pruebas: creación de objetos (5.0)
**Lo que hicieron bien:**
- Su `App` crea un `Dueño` y un `Veterinario`, les agrega animales a los dueños y luego recorre un arreglo de `Persona` llamando `rolEnClinica()` sin usar `instanceof`. Así se ve que cada tipo de persona responde distinto. Cumple todo lo pedido.

## 3. Buenas prácticas (4.0)
**Lo que hicieron bien:**
- Varios integrantes hicieron commits seguido, y la mayoría de mensajes explican bien el cambio.
- Cada integrante trabajó en su propia rama y luego unieron todo en `development` antes de pasarlo a `main`.

**Lo que pueden mejorar:**
- Un commit de merge quedó con el texto automático de Git ("Please enter a commit message..."). Eso indica que no revisaron el mensaje antes de guardarlo.
- Revisen los nombres: el método `MostrarInfo()` debería ser `mostrarInfo()` y el atributo `Fecha` de `Consulta` debería ser `fecha`. En Java, métodos y atributos empiezan con minúscula.

## ¿El programa funciona?
Sí. El código compila sin errores y al ejecutarlo crea todos los objetos y muestra el rol de cada persona como se esperaba.

## Para el próximo laboratorio
- Agreguen a `Consulta` y `Vacuna` las referencias a `Animal` (y a `Veterinario` en `Consulta`).
- Llamen a la validación de `numeroFicha` desde el constructor de `Animal`.
- Borren el archivo duplicado `src/App.Java`.
- Revisen el mensaje de cada commit antes de guardarlo.
- Usen siempre minúscula inicial (camelCase) en métodos y atributos.
