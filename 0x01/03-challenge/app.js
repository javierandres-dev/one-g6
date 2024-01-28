'use strict';
// 1. Crea una función que calcule el índice de masa corporal (IMC) de una persona a partir de su altura en metros y peso en kilogramos, que se recibirán como parámetros.  IMC = weight(Kg) / height(m)²
function getIMC(height, weight) {
  return weight / (height * height);
}
console.log(getIMC(1.69, 72));
console.log(getIMC(1.65, 68));
// 2. Crea una función que calcule el valor del factorial de un número pasado como parámetro.  F = n(n-1)!
function getFactorial(num) {
  let product = 1,
    i = num;
  while (i > 0) {
    product *= i;
    i--;
  }
  return product;
}
console.log(getFactorial(1));
console.log(getFactorial(2));
console.log(getFactorial(3));
console.log(getFactorial(4));
console.log(getFactorial(5));

function getFactorialRecursive(num) {
  console.log('num:', num);
  if (num === 1) {
    console.log('if...num:', num);
    const r = 1;
    console.log('if...return:', r);
    return r;
  } else {
    console.log('else...num:', num);
    const r = num * getFactorialRecursive(num - 1);
    console.log('else...return:', r);
    return r;
  }
}
console.log(getFactorialRecursive(1));
console.log(getFactorialRecursive(2));
console.log(getFactorialRecursive(3));
console.log(getFactorialRecursive(4));
console.log(getFactorialRecursive(5));

function getFactorialRecursiveSlim(num) {
  if (num === 1) return 1;
  else return num * getFactorialRecursiveSlim(num - 1);
}
console.log(getFactorialRecursiveSlim(1));
console.log(getFactorialRecursiveSlim(2));
console.log(getFactorialRecursiveSlim(3));
console.log(getFactorialRecursiveSlim(4));
console.log(getFactorialRecursiveSlim(5));
// 3. Crea una función que convierta un valor en dólares, pasado como parámetro, y devuelva el valor equivalente en reales(moneda brasileña,si deseas puedes hacerlo con el valor del dólar en tu país). Para esto, considera la cotización del dólar igual a R$4,80.
function dollarsToReales(usd) {
  return usd * 4.8;
}
console.log(dollarsToReales(1));
console.log(dollarsToReales(5));
console.log(dollarsToReales(10));
console.log(dollarsToReales(50));
function dollarsToPesos(usd) {
  return usd * 3925.26;
}
console.log(dollarsToPesos(1));
console.log(dollarsToPesos(5));
console.log(dollarsToPesos(10));
console.log(dollarsToPesos(50));
// 4. Crea una función que muestre en pantalla el área y el perímetro de una sala rectangular, utilizando la altura y la anchura que se proporcionarán como parámetros.  A = height * width  P = height + width * 2
function getRectangleArea(height, width) {
  return height * width;
}
function getRectanglePerimeter(height, width) {
  return (height + width) * 2;
}
function getRectangleAreaAndPerimeter(height, width) {
  const area = getRectangleArea(height, width);
  const perimeter = getRectanglePerimeter(height, width);
  console.log(`Rectangle Area: ${area}\nRectangle Perimeter: ${perimeter}`);
}
getRectangleAreaAndPerimeter(5, 7);
getRectangleAreaAndPerimeter(10, 12);
// 5. Crea una función que muestre en pantalla el área y el perímetro de una sala circular, utilizando su radio que se proporcionará como parámetro. Considera Pi = 3,14.  A = PI * radius²  P = 2PI * radius
function getCircleArea(radius) {
  return Math.PI * (radius * radius);
}
function getCirclePerimeter(radius) {
  return Math.PI * 2 * radius;
}
function getCircleAreaAndPerimeter(radius) {
  const area = getCircleArea(radius);
  const perimeter = getCirclePerimeter(radius);
  console.log(`Circle Area: ${area}\nCircle Perimeter: ${perimeter}`);
}
getCircleAreaAndPerimeter(2);
getCircleAreaAndPerimeter(5);
getCircleAreaAndPerimeter(10);
// 6. Crea una función que muestre en pantalla la tabla de multiplicar de un número dado como parámetro.
function getMultiplicationTable(num) {
  let result = '';
  for (let i = 1; i <= num; i++) {
    result += `${num} x ${i} = ${num * i}\n`;
  }
  return result;
}
console.log(getMultiplicationTable(1));
console.log(getMultiplicationTable(2));
console.log(getMultiplicationTable(3));
console.log(getMultiplicationTable(4));
console.log(getMultiplicationTable(5));
console.log(getMultiplicationTable(6));
console.log(getMultiplicationTable(7));
console.log(getMultiplicationTable(8));
console.log(getMultiplicationTable(9));
console.log(getMultiplicationTable(10));
