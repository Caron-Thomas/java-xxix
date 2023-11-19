package atividade;

public final class Passeio extends Veiculo implements Calcular{

	private int qtdPassageiros;
	
	public Passeio() {
		this.qtdPassageiros = 0;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	@Override
	public float calcVel(float veloMAx) {
		return veloMAx * 1000;
	}

	@Override
	public int calcular() {
		
		int soma = 0;
		
		soma =  this.getPlaca().length();
		soma += this.getMarca().length();
		soma += this.getModelo().length();
		soma += this.getCor().length();
		
		return soma;
	}
}


