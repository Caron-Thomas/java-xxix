package atividade;

public class VelocException extends Exception {

	public void VelocException() {
		System.out.println("A velocidade máxima está fora dos limites brasileiros.");
	}
	
	public void impSolucao() {
		System.out.println("Adotado velocidade máxima padrão para o tipo de veículo");
	}
}
