export class CalculatorService {
  constructor(operationAdapter) {
    this.operationAdapter = operationAdapter;
  }

  calcular(a, b, operacion) {
    switch (operacion) {
      case 'suma':
        return this.operationAdapter.sum(a, b);
      case 'resta':
        return this.operationAdapter.subtract(a, b);
      case 'multiplicacion':
        return this.operationAdapter.multiply(a, b);
      case 'division':
        return this.operationAdapter.divide(a, b);
      default:
        throw new Error('Operación no válida');
    }
  }
}
