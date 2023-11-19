package atividade;

public class VelocException extends Exception {

	//private static final long serialVersionUID = 1L;

	public VelocException() {
		System.out.println("A velocidade máxima está fora dos limites brasileiros.");
	}
	
	public void impSolucao() {
		System.out.println("Adotado velocidade máxima padrão para o tipo de veículo");
	}
}
