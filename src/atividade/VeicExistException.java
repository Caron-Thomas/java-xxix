package atividade;

public class VeicExistException extends Exception{
	
	public void veicExistException() {
		System.out.println("J� existe um ve�culo com esta placa");
	}
	
	public void veicNaoExistException() {
		System.out.println("ve�culo n�o encontrado na base de dados.");
	}

}
