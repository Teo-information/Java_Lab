
window.calcular = function () {
  const num1 = parseFloat(document.getElementById('num1').value);
  const num2 = parseFloat(document.getElementById('num2').value);
  const operacion = document.getElementById('operacion').value;
  let resultado = '';

  if (isNaN(num1) || isNaN(num2)) {
    resultado = 'Por favor ingresa ambos números.';
  } else {
    switch (operacion) {
      case 'suma':
        resultado = num1 + num2;
        break;
      case 'resta':
        resultado = num1 - num2;
        break;
      case 'multiplicacion':
        resultado = num1 * num2;
        break;
      case 'division':
        if (num2 === 0) {
          resultado = 'No se puede dividir por cero.';
        } else {
          resultado = num1 / num2;
        }
        break;
      default:
        resultado = 'Operación no válida.';
    }
  }
  document.getElementById('resultado').textContent = `Resultado: ${resultado}`;
};
