'use strict';
// 1. Crea una lista vacía llamada "listaGenerica".
const listaGenerica = [];
// 2. Crea una lista de lenguajes de programación llamada "lenguagesDeProgramacion con los siguientes elementos: 'JavaScript', 'C', 'C++', 'Kotlin' y 'Python'.
const lenguagesDeProgramacion = ['JavaScript', 'C', 'C++', 'Kotlin', 'Python'];
// 3. Agrega a la lista "lenguagesDeProgramacion los siguientes elementos: 'Java', 'Ruby' y 'GoLang'.
lenguagesDeProgramacion.push('Java', 'Ruby', 'GoLang');
// 4. Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion.
function getElements(arr) {
  for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
  }
}
getElements(lenguagesDeProgramacion);
// 5. Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion en orden inverso.
function getElementsReversed(arr) {
  for (let i = arr.length - 1; i >= 0; i--) {
    console.log(arr[i]);
  }
}
getElementsReversed(lenguagesDeProgramacion);
console.log(lenguagesDeProgramacion.reverse());
// 6. Crea una función que calcule el promedio de los elementos en una lista de números.
function getAverage(arr) {
  let sum = 0,
    i = 0;
  while (i < arr.length) {
    sum += arr[i];
    i++;
  }
  return sum / arr.length;
}
console.log(getAverage([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
console.log(getAverage([2, 4, 6, 8, 10]));
// 7. Crea una función que muestre en la consola el número más grande y el número más pequeño en una lista.
function getMaxAndMin(arr) {
  const max = Math.max(...arr);
  const min = Math.min(...arr);
  return `Max: ${max}\nMin: ${min}`;
}
console.log(getMaxAndMin([2, 4, 6, 8, 10]));
console.log(getMaxAndMin([1, 3, 5, 7, 9]));
// 8. Crea una función que devuelva la suma de todos los elementos en una lista.
function getSum(arr) {
  return arr.reduce((accumulator, current) => accumulator + current, 0);
}
console.log(getSum([1, 3, 5, 7, 9]));
console.log(getSum([2, 4, 6, 8, 10]));
console.log(getSum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
// 9. Crea una función que devuelva la posición en la lista donde se encuentra un elemento pasado como parámetro, o -1 si no existe en la lista.
function getPosition(ele, arr) {
  return arr.indexOf(ele);
}
console.log(getPosition(1, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
console.log(getPosition(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
console.log(getPosition(5, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
console.log(getPosition(50, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
// 10. Crea una función que reciba dos listas de números del mismo tamaño y devuelva una nueva lista con la suma de los elementos uno a uno.
function getSums(arr1, arr2) {
  const arr = [...arr1, ...arr2];
  return arr.reduce((accumulator, current) => accumulator + current, 0);
}
console.log(getSums([1, 3, 5, 7, 9], [2, 4, 6, 8, 10]));
// 11. Crea una función que reciba una lista de números y devuelva una nueva lista con el cuadrado de cada número.
function getSquare(arr) {
  const newArr = [];
  for (let i = 0; i < arr.length; i++) {
    newArr.push(arr[i] * arr[i]);
  }
  return newArr;
}
console.log(getSquare([1, 3, 5, 7, 9]));
console.log(getSquare([2, 4, 6, 8, 10]));
console.log(getSquare([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
