package atividade;

public class VeicExistException extends Exception{
	
	public void veicExistException() {
		System.out.println("Já existe um veículo com esta placa");
	}
	
	public void veicNaoExistException() {
		System.out.println("veículo não encontrado na base de dados.");
	}

}
