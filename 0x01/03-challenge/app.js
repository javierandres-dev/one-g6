'use strict';
// 1. Crea una función que calcule el índice de masa corporal (IMC) de una persona a partir de su altura en metros y peso en kilogramos, que se recibirán como parámetros.  IMC = weight(Kg) / height(m)2
function getIMC(height, weight) {
  return weight / (height * height);
}
console.log(getIMC(1.69, 72));
console.log(getIMC(1.65, 68));
// 2. Crea una función que calcule el valor del factorial de un número pasado como parámetro.  F = n(n-1)!
function getFactorial(num) {
  let product = 0,
    i = num;
  while (i > 0) {}
}
console.log(getFactorial(3));
console.log(getFactorial(5));
// 3. Crea una función que convierta un valor en dólares, pasado como parámetro, y devuelva el valor equivalente en reales(moneda brasileña,si deseas puedes hacerlo con el valor del dólar en tu país). Para esto, considera la cotización del dólar igual a R$4,80.
// 4. Crea una función que muestre en pantalla el área y el perímetro de una sala rectangular, utilizando la altura y la anchura que se proporcionarán como parámetros.
// 5. Crea una función que muestre en pantalla el área y el perímetro de una sala circular, utilizando su radio que se proporcionará como parámetro. Considera Pi = 3,14.
// 6. Crea una función que muestre en pantalla la tabla de multiplicar de un número dado como parámetro.
