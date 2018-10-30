package Maquina;

public class Maquina {

	int _25centavos;
	int _50centavos;
	int _1real;

	public String LigarMaquina() {
		String ligar = "Maquina de Refrigerante ligada";

		return ligar;
	}
	
	public Double CalculoCompra(Double valorInserido,Double ValorProduto) {
		
		Double troco =  valorInserido - ValorProduto;

		return troco;	
	}
	
	public Double SomaMoedas(Double valor1,Double valor2,Double valor3)
	{
		Double valor = (valor1*0.25) + (valor2*0.50) + valor3;
		
		return valor;	
	}
	
	public Double ConvetMoeda25(Double moeda) {
		
		return moeda*0.25;
		
	}

	public Double ConvetMoeda50(Double moeda) {
		
		return moeda*0.50;
		
	}
	
	public int get_25centavos() {
		return _25centavos;
	}

	public void set_25centavos(int _25centavos) {
		this._25centavos = _25centavos;
	}

	public int get_50centavos() {
		return _50centavos;
	}

	public void set_50centavos(int _50centavos) {
		this._50centavos = _50centavos;
	}

	public int get_1real() {
		return _1real;
	}

	public void set_1real(int _1real) {
		this._1real = _1real;
	}

}
