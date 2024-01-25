'use strict';
// 1.  Crea un contador que comience en 1 y vaya hasta 10 usando un bucle 'while'. Muestra cada número.
let contador = 1;
while (contador <= 10) {
  console.log(contador);
  contador = contador + 1;
}
// 2.  Crea un contador que comience en 10 y vaya hasta 0 usando un bucle 'while'. Muestra cada número.
contador = 10;
while (contador >= 0) {
  console.log(contador);
  contador = contador - 1;
}
// 3.  Crea un programa de cuenta progresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.
let numero = prompt('Ingrese un número:');
contador = 0;
while (contador <= numero) {
  console.log(contador);
  contador = contador + 1;
}
// 4.  Crea un programa de cuenta regresiva. Pide un número y cuenta desde ese número hasta 0 utilizando un bucle 'while' en la consola del navegador.
numero = prompt('Ingrese un número:');
contador = numero;
while (contador >= 0) {
  console.log(contador);
  contador = contador - 1;
}
