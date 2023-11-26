package atividade;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	//vetores  utilizados durante periodo de execução 
	private static List<Passeio> vetPasseio = new ArrayList<>();
	private static List<Carga>   vetCarga   = new ArrayList<>();
	
	public static boolean cadastraVPasseio(Passeio vPasseio) {
		if(vPasseio == null)
			return true;
		
		vetPasseio.add(vPasseio);
		System.out.println("\n>>> Veículo salvo <<<");				
		return true;
	}
	
	public static boolean cadastraVCarga(Carga vCarga) {
		if(vCarga == null)
			return true;
		
		vetCarga.add(vCarga);
		System.out.println("\n>>> Veículo salvo <<<");				
		return true;
	}
	
	public static int buscaPlaca(String placa, int j) {
		switch(j){
				case 1:
					for(int i = 0; i < vetPasseio.size() ; i++) {
						if(vetPasseio.get(i).getPlaca().toLowerCase().equals(placa.toLowerCase())) {
							return i;
						}
					}
					break;
				case 2:
					for(int i = 0; i < vetCarga.size(); i++) {
						if(vetCarga.get(i).getPlaca().toLowerCase().equals(placa.toLowerCase())) {
							return i;
						}
					}
					break;
				}
		return -1;
	} 
	
	public static void imprimirVeiculoPasseio(String placa) {
		try {
			if(placa != null) {
				int posicao = -1;
				posicao = buscaPlaca(placa, 1);
				imprimirDetalhePasseio(posicao);
			}
			 else {
				for (int i = 0; i < vetPasseio.size(); i++) {
					imprimirDetalhePasseio(i);
				}
			 }
		} catch(VeicExistException vee) {
				 vee.veicNaoExistException();  ;
			}
	}
	
	public static void imprimirCarga(String placa) {
		try {
			if(placa != null) {
				int posicao = -1;
				posicao = buscaPlaca(placa, 2);
				imprimirDetalheCarga(posicao);
			}
			 else {
				for (int i = 0; i < vetPasseio.size(); i++) {
					imprimirDetalheCarga(i);
				}
			 }
		} catch(VeicExistException vee) {
				 vee.veicNaoExistException();  ;
			}
	}
	
	public static void excluirVeiculoPasseio(String placa)throws VeicExistException {
			int posicao = -1;
			posicao = buscaPlaca(placa, 1);
			try {
				vetPasseio.remove(posicao);
			} catch(IndexOutOfBoundsException ioobe) {
				throw new VeicExistException();
			}
			System.out.println(" Veículo Placa: "+ placa + " excluido com sucesso.");
	}

	public static void excluirVeiculoCarga(String placa)throws VeicExistException {
			int posicao = -1;
			posicao = buscaPlaca(placa, 1);
			try {
				vetCarga.remove(posicao);
			} catch(IndexOutOfBoundsException ioobe) {
				throw new VeicExistException();
			}
			System.out.println(" Veículo Placa: "+ placa + " excluido com sucesso.");
	}
	
	public static void imprimirDetalhePasseio(int i) throws VeicExistException {
		try {
		vetPasseio.get(i).getMarca();		
		System.out.printf("\n  ============== VEÍCULO DE PASSEIO nº %d ==============", i + 1);
		System.out.println("\n  Marca.....................:" + vetPasseio.get(i).getMarca());
		System.out.println("  Modelo....................:" + vetPasseio.get(i).getModelo());
		System.out.println("  Cor.......................:" + vetPasseio.get(i).getCor());
		System.out.println("  Placa.....................:" + vetPasseio.get(i).getPlaca());
		System.out.println("  Qdt Rodas.................:" + vetPasseio.get(i).getQtdRodas());
		System.out.println("  Velocidade Máxima km/h....:" + vetPasseio.get(i).getVelocMax());
		System.out.println("  Velocidade Máxima  m/h....:" + vetPasseio.get(i).calcVel(vetPasseio.get(i).getVelocMax()));
		System.out.println("  Qtd Passageiros...........:" + vetPasseio.get(i).getQtdPassageiros());
		System.out.println("  Potência do Motor cv......:" + vetPasseio.get(i).getMotor().getPotencia());
		System.out.println("  Qtd Pistões do Motor......:" + vetPasseio.get(i).getMotor().getQtdPist());
		System.out.println("  Valor Calculado Interface.:" + vetPasseio.get(i).calcular());
		}
		catch(IndexOutOfBoundsException ioobe) {
			throw new VeicExistException();
		}
		
	}
	
	public static void imprimirDetalheCarga(int i)throws VeicExistException {
		try {
		vetCarga.get(i).getMarca();
		System.out.printf("\n  =============== VEÍCULO DE CARGA nº %d ===============", i + 1);
		System.out.println("\n  Marca......................:" + vetCarga.get(i).getMarca());
		System.out.println("  Modelo.....................:" + vetCarga.get(i).getModelo());
		System.out.println("  Cor........................:" + vetCarga.get(i).getCor());
		System.out.println("  Placa......................:" + vetCarga.get(i).getPlaca());
		System.out.println("  Qdt Rodas..................:" + vetCarga.get(i).getQtdRodas());
		System.out.println("  Velocidade Máxima km/h.....:" + vetCarga.get(i).getVelocMax());
		System.out.println("  Velocidade Máxima cm/h.....:" + vetCarga.get(i).calcVel(vetCarga.get(i).getVelocMax()));
		System.out.println("  Capacidade Máxima de Carga.:" + vetCarga.get(i).getCargaMax());
		System.out.println("  Tara do Veículo de Carga...:" + vetCarga.get(i).getTara());
		System.out.println("  Potência do Motor cv.......:" + vetCarga.get(i).getMotor().getPotencia());
		System.out.println("  Qtd Pistões do Motor.......:" + vetCarga.get(i).getMotor().getQtdPist());
		System.out.println("  Valor Calculado Interface..:" + vetCarga.get(i).calcular());
		} catch(IndexOutOfBoundsException ioobe) {
			throw new VeicExistException();
		}
	}
}
