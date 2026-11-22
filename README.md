# Sistema de Gestión de Repuestos de Cocina

Aplicación de consola desarrollada en **Java** para administrar el inventario, ventas y pedidos de una tienda de repuestos de cocina mediante estructuras de datos dinámicas implementadas desde cero (Lista Enlazada, Pila y Cola), sin depender de colecciones nativas ni bases de datos externas.

> **Curso:** Algoritmo y Estructura de Datos — V Ciclo  
> **Institución:** Universidad Tecnológica del Perú (UTP)  
> **Autor:** Palomares Dueñas, Israel Adrian (`U18302252`)  
> **Docente:** Salvatierra Velarde, Dorio Alejandro 

---

## Características y Funcionalidades

El sistema opera mediante un menú interactivo en consola con 14 opciones organizadas por estructura de datos:

### Inventario (`Lista` — Lista Enlazada Simple)
* **[1] Registrar repuesto:** Agrega un nuevo nodo al final de la lista con `ID`, `Nombre`, `Precio` y `Stock`.
* **[2] Mostrar repuestos:** Recorre la lista desde la cabeza y muestra los registros en formato de tabla.
* **[3] Buscar repuesto:** Realiza una búsqueda secuencial por `ID`.
* **[4] Actualizar repuesto:** Modifica `Nombre`, `Precio` y `Stock` de un repuesto existente ubicándolo por `ID`.
* **[5] Eliminar repuesto:** Desconecta y elimina un nodo de la lista según su `ID`.
* **[6] Ordenar repuestos:** Ordena los repuestos de menor a mayor `ID` mediante el algoritmo de ordenamiento burbuja (*Bubble Sort*).
* **[7] Calcular stock:** Suma las unidades disponibles de todos los repuestos registrados.

### Ventas (`PilaDinamica` — Estructura LIFO)
* **[8] Registrar venta:** Apila una nueva venta (`Fecha`, `ID`, `Cantidad`, `Precio`) en la cima de la pila.
* **[9] Mostrar ventas:** Recorre la pila desde la cima mostrando las ventas de la más reciente a la más antigua.
* **[10] Calcular ganancias:** Calcula el ingreso total acumulado sumando `Precio * Cantidad` de cada venta.

### Pedidos (`ColaDinamica` — Estructura FIFO)
* **[11] Agregar pedido:** Encola un nuevo pedido (`ID`, `Cantidad`) con estado `PENDIENTE` al final de la cola.
* **[12] Atender pedido:** Desencola el pedido al frente, cambia su estado a `ATENDIENDO` y muestra sus datos.
* **[13] Ver pedido pendiente:** Consulta el primer pedido de la cola (`peek`) sin retirarlo.

---

## Arquitectura y Estructuras de Datos

El código fuente se organiza en las siguientes clases principales:

* `GestionDeRepuestosDeCocina`: Clase principal que contiene el método `main`, el bucle del menú y el manejo de entrada con `Scanner`.
* `NodoLista` y `Lista`: Implementan la lista enlazada dinámica para el catálogo de repuestos.
* `PilaDinamica` (con su nodo interno `NodoPila`): Implementa la pila LIFO para el historial de ventas.
* `ColaDinamica` (con su nodo interno `Nodo`): Implementa la cola FIFO para la atención de pedidos.

---

## Análisis de Complejidad

### Complejidad Temporal

| Operación | Estructura | Complejidad |
| :--- | :--- | :--- |
| Registrar repuesto | Lista Enlazada | $O(n)$ |
| Mostrar repuestos | Lista Enlazada | $O(n)$ |
| Buscar repuesto | Lista Enlazada | $O(n)$ |
| Actualizar repuesto | Lista Enlazada | $O(n)$ |
| Eliminar repuesto | Lista Enlazada | $O(n)$ |
| Ordenar repuestos (Burbuja) | Lista Enlazada | $O(n^2)$ |
| Calcular stock | Lista Enlazada | $O(n)$ |
| Registrar venta (`push`) | Pila | $O(1)$ |
| Mostrar ventas | Pila | $O(n)$ |
| Calcular ganancias | Pila | $O(n)$ |
| Agregar pedido (`enqueue`) | Cola | $O(1)$ |
| Atender pedido (`dequeue`) | Cola | $O(1)$ |
| Ver pedido pendiente (`peek`) | Cola | $O(1)$ |

### Complejidad Espacial
* **Estructuras (`Lista`, `PilaDinamica`, `ColaDinamica`):** $O(n)$, ya que cada elemento se almacena en un nodo asignado dinámicamente en memoria.
* **Recorridos, búsqueda y ordenamiento:** $O(1)$ de espacio auxiliar adicional (el ordenamiento intercambia valores entre nodos existentes sin crear copias de la lista).

---

## Ejecución del Proyecto

### Requisitos
* **JDK** (Java Development Kit) instalado (Java 8 o superior).

### Compilar y ejecutar desde terminal
```bash
javac GestionDeRepuestosDeCocina.java
java GestionDeRepuestosDeCocina
```

*(También puedes abrir y ejecutar el proyecto directamente desde un IDE como **NetBeans**.)*

---

## Limitaciones Actuales y Mejoras Futuras

* **Persistencia de datos:** La información se mantiene en memoria durante la ejecución; al cerrar el programa se pierde. Se proyecta integrar una base de datos relacional.
* **Escalabilidad:** Para inventarios grandes, el ordenamiento burbuja ($O(n^2)$) y la búsqueda secuencial ($O(n)$) pueden reemplazarse por algoritmos más eficientes (como *Merge Sort*) y estructuras de búsqueda más rápidas.
* **Interfaz y filtros:** Incorporar interfaz gráfica y opciones de búsqueda/ordenamiento por nombre o precio.