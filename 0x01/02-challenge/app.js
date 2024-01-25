'use strict';
// 1. Crear una función que muestre "¡Hola, mundo!" en la consola.
function logHello() {
  console.log('¡Hola, mundo!');
}
logHello();
// 2. Crear una función que reciba un nombre como parámetro y muestre "¡Hola, [nombre]!" en la consola.
function logHelloName(name) {
  console.log(`¡Hola, ${name}!`);
}
logHelloName('Javi');
// 3. Crear una función que reciba un número como parámetro y devuelva el doble de ese número.
function getDouble(num) {
  return num * 2;
}
console.log(getDouble(1));
console.log(getDouble(2));
console.log(getDouble(3));
// 4. Crear una función que reciba tres números como parámetros y devuelva su promedio.
function getAverage(num1, num2, num3) {
  return (num1 + num2 + num3) / 3;
}
console.log(getAverage(2, 4, 6));
// 5. Crear una función que reciba dos números como parámetros y devuelva el mayor de ellos.
function getMax(num1, num2) {
  return num1 > num2 ? num1 : num2;
}
console.log(getMax(2, 4));
console.log(getMax(8, 4));
// 6. Crear una función que reciba un número como parámetro y devuelva el resultado de multiplicar ese número por sí mismo.
function getSquare(num) {
  return num * num;
}
console.log(getSquare(2));
console.log(getSquare(3));
