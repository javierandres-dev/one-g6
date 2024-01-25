'use strict';
// 1. Descarga otro proyecto haciendo clic en este enlace y ábrelo en Visual Studio Code.
// 2. Cambia el contenido de la etiqueta h1 con document.querySelector y asigna el siguiente texto: "Hora del Desafío".
const $h1 = document.querySelector('h1');
$h1.textContent = 'Hora del Desafío';
// 3. Crea una función que muestre en la consola el mensaje "El botón fue clicado" siempre que se presione el botón "Console".
function handleClickConsole() {
  console.log('El botón fue clicado');
}
// 4. Crea una función que se ejecute cuando se haga clic en el botón "prompt", preguntando el nombre de una ciudad de Brasil. Luego, muestra una alerta con el mensaje concatenando la respuesta con el texto: "Estuve en {ciudad} y me acordé de ti".
function handleClickPrompt() {
  const ciudad = prompt('¿Nombre de una ciudad de Brasil?');
  alert(`Estuve en ${ciudad} y me acordé de ti`);
}
// 5. Crea una función que muestre una alerta con el mensaje: "Yo amo JS" siempre que se presione el botón "Alerta".
function handleClickAlert() {
  alert('Yo amo JS');
}
// 6. Al hacer clic en el botón "suma", pide 2 números y muestra el resultado de la suma en una alerta.
function handleClickSuma() {
  const num1 = +prompt('Introduce un número');
  const num2 = +prompt('Introduce otro número');
  alert(num1 + num2);
}
