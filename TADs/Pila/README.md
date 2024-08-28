## Pila
Elementos o nodos encadenados linealmente. Con una estructura LIFO. **Dos abstracciones:**  
1. Una pila sin elementos (pila vacía)  
2. Una pila con algún elemento (puede ser infinita)  

*¿Qué tipo de dato conocemos que puede soportar esta estrucutra?*
-> En java tenemos los arreglos (estático) y las List (dinámico)

*Algunas operaciones de las pilas*
- **apilar**(T: elemento): Void
Añade un elemento a la pila
- **desapilar**(): T
Lee y retira el elemento superior de la pila
- **Tope**(): T
Lee el elemento superior de la pila sin retirarlo
- **esVacia**(): Bool
Devuelve cierto si la pila está sin elementos o falso en caso de que contenga alguno
