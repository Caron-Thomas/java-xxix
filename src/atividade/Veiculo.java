package atividade;

abstract class Veiculo {
	
	private String placa, marca, modelo, cor;	 
	private float  velocMax; 
	private int	   qtdRodas; 
	private Motor  motor;
	
	public Veiculo() {
		this.placa    = "";
		this.marca    = "";
		this.modelo   = "";
		this.cor      = "";
		this.velocMax = 0;
		this.qtdRodas = 0;
		this.motor    = new Motor();
	}

	public String getPlaca() {
		return this.placa;
	}

	final public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return this.marca;
	}

	final public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	final public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return this.cor;
	}

	final public void setCor(String cor) {
		this.cor = cor;
	}

	public float getVelocMax() {
		return this.velocMax;
	}

	final public void setVelocMax(float velocMax) throws VelocException {
		int velMin = 80;
		int velMax = 110;
		if(velocMax >= velMin && velocMax <= velMax) {
			this.velocMax = velocMax;
		} else {
			throw new VelocException();
		}
	}

	public int getQtdRodas() {
		return this.qtdRodas;
	}

	final public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public Motor getMotor() {
		return this.motor;
	}
	
	final public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public abstract float calcVel(float veloMax); 
}
