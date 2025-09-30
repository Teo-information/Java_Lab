
import { BasicOperationAdapter } from './infrastructure/BasicOperationAdapter.js';
import { CalculatorService } from './application/CalculatorService.js';

const operationAdapter = new BasicOperationAdapter();
const calculatorService = new CalculatorService(operationAdapter);

window.calcular = function () {
  const num1 = parseFloat(document.getElementById('num1').value);
  const num2 = parseFloat(document.getElementById('num2').value);
  const operacion = document.getElementById('operacion').value;
  let resultado = '';

  if (isNaN(num1) || isNaN(num2)) {
    resultado = 'Por favor ingresa ambos números.';
  } else {
    try {
      resultado = calculatorService.calcular(num1, num2, operacion);
    } catch (e) {
      resultado = e.message;
    }
  }
  document.getElementById('resultado').textContent = `Resultado: ${resultado}`;
};
