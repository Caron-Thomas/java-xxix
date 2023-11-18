package atividade;

final public class Carga extends Veiculo implements Calcular{

	private int cargaMax, tara;
	
	public Carga() {
		this.cargaMax = 0;
		this.tara = 0;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	@Override
	public float calcVel(float veloMax) {
		return veloMax * 100000;
	}

	@Override
	public int calcular() {
		
		int soma = 0;
		soma = this.getTara() + this.getCargaMax() + this.getQtdRodas() + this.getMotor().getPotencia()
				+ this.getMotor().getQtdPist() + (int) this.getVelocMax() ;
		
		return soma;
	}
}
