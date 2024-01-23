'use strict';
// 1.  Pregunta al usuario qué día de la semana es. Si la respuesta es "Sábado" o "Domingo", muestra "¡Buen fin de semana!". De lo contrario, muestra "¡Buena semana!".
const diaDeLaSemana = prompt('¿Día de la semana?');
if (diaDeLaSemana === 'Sábado' || diaDeLaSemana === 'Domingo') {
  alert('¡Buen fin de semana!');
} else {
  alert('¡Buena semana!');
}
// 2.  Verifica si un número ingresado por el usuario es positivo o negativo. Muestra una alerta informativa.
const numero = prompt('Ingrese un número:');
if (numero < 0) {
  alert('El número es negativo');
} else if (numero > 0) {
  alert('El número es positivo');
} else {
  alert('El número es 0');
}
// 3.  Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100, muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intenta nuevamente para ganar.".
const puntuacion = 100;
if (puntuacion >= 100) {
  alert('¡Felicidades, has ganado!');
} else {
  alert('Intenta nuevamente para ganar.');
}
// 4.  Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un template string para incluir el valor del saldo.
const saldo = 1000;
const saldoMensaje = `Tu saldo es: $${saldo}`;
alert(saldoMensaje);
// 5.  Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de bienvenida usando ese nombre.
const nombreUsuario = prompt('Ingrese su nombre:');
alert(`¡Bienvenido ${nombreUsuario}!`);
