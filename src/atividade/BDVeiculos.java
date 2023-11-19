package atividade;

public class BDVeiculos {
	//vetores  utilizados durante periodo de execução 
	private static Passeio vetPasseio[] = new Passeio[5];
	private static Carga   vetCarga[]   = new Carga[5];
	
	public static boolean cadastraVPasseio(int i, Passeio vPasseio) {
		if(vPasseio == null)
			return true;
		
		vetPasseio[i] = vPasseio;
		System.out.println("\n>>> Veículo salvo na posição "+ i +" <<<");				
		return true;
	}
	
	public static int achaEndVagoPasseio() {
		for (int i = 0; i < vetPasseio.length; i++) {
			if(vetPasseio[i] == null)
				return i;
		}
		return -1;
	}
	
	public static boolean cadastraVCarga(int i, Carga vCarga) {
		if(vCarga == null)
			return true;
		
		vetCarga[i] = vCarga;
		System.out.println("\n>>> Veículo salvo na posição "+ i +" <<<");				
		return true;
	}
	
	public static int achaEndVagoCarga() {
		for (int i = 0; i < vetCarga.length; i++) {
			if(vetCarga[i] == null)
				return i;
		}
		return -1;
	}
	
	public static int buscaPlaca(String placa, int j) throws VeicExistException {
		try {
			switch(j){
				case 1:
					for(int i = 0; i < vetPasseio.length; i++) {
						if(vetPasseio[i].getPlaca().toLowerCase().equals(placa.toLowerCase())) {
							return i;
						}
					}
				case 2:
					for(int i = 0; i < vetCarga.length; i++) {
						if(vetCarga[i].getPlaca().toLowerCase().equals(placa.toLowerCase())) {
							return i;
						}
					}	
				}
		} catch(NullPointerException npe) {
				throw new VeicExistException();
			}
		return -1;
	} 
	
	public static void imprimirVeiculoPasseio(String placa) throws VeicExistException {
		if(placa != null) {
			int posicao = -1;
			posicao = buscaPlaca(placa, 1);
			imprimirDetalhePasseio(posicao);

		} else {
			for (int i = 0; i < vetPasseio.length; i++) {
				try { 
					imprimirDetalhePasseio(i);
				}catch(NullPointerException npe) {
					break;
				};
			}
		}
	}
	
	public static void imprimirDetalhePasseio(int i) {
		vetPasseio[i].getMarca();		
		System.out.printf("\n  ============== VEÍCULO DE PASSEIO nº %d ==============", i + 1);
		System.out.println("\n  Marca.....................:" + vetPasseio[i].getMarca());
		System.out.println("  Modelo....................:" + vetPasseio[i].getModelo());
		System.out.println("  Cor.......................:" + vetPasseio[i].getCor());
		System.out.println("  Placa.....................:" + vetPasseio[i].getPlaca());
		System.out.println("  Qdt Rodas.................:" + vetPasseio[i].getQtdRodas());
		System.out.println("  Velocidade Máxima km/h....:" + vetPasseio[i].getVelocMax());
		System.out.println("  Velocidade Máxima  m/h....:" + vetPasseio[i].calcVel(vetPasseio[i].getVelocMax()));
		System.out.println("  Qtd Passageiros...........:" + vetPasseio[i].getQtdPassageiros());
		System.out.println("  Potência do Motor cv......:" + vetPasseio[i].getMotor().getPotencia());
		System.out.println("  Qtd Pistões do Motor......:" + vetPasseio[i].getMotor().getQtdPist());
		System.out.println("  Valor Calculado Interface.:" + vetPasseio[i].calcular());
		
	}
	
	
	
	public static void imprimirCarga(String placa)throws VeicExistException {
		if(placa != null) {
			int posicao = -1;
			posicao = buscaPlaca(placa, 2);
			imprimirDetalhePasseio(posicao);

		} else {
			for (int i = 0; i < vetCarga.length; i++) {
				try { 
					imprimirDetalheCarga(i);
				}catch(NullPointerException npe) {
					break;
				};
			}
		}
	}
	
	public static void imprimirDetalheCarga(int i) {
		vetCarga[i].getMarca();
		System.out.printf("\n  =============== VEÍCULO DE CARGA nº %d ===============", i + 1);
		System.out.println("\n  Marca......................:" + vetCarga[i].getMarca());
		System.out.println("  Modelo.....................:" + vetCarga[i].getModelo());
		System.out.println("  Cor........................:" + vetCarga[i].getCor());
		System.out.println("  Placa......................:" + vetCarga[i].getPlaca());
		System.out.println("  Qdt Rodas..................:" + vetCarga[i].getQtdRodas());
		System.out.println("  Velocidade Máxima km/h.....:" + vetCarga[i].getVelocMax());
		System.out.println("  Velocidade Máxima cm/h.....:" + vetCarga[i].calcVel(vetCarga[i].getVelocMax()));
		System.out.println("  Capacidade Máxima de Carga.:" + vetCarga[i].getCargaMax());
		System.out.println("  Tara do Veículo de Carga...:" + vetCarga[i].getTara());
		System.out.println("  Potência do Motor cv.......:" + vetCarga[i].getMotor().getPotencia());
		System.out.println("  Qtd Pistões do Motor.......:" + vetCarga[i].getMotor().getQtdPist());
		System.out.println("  Valor Calculado Interface..:" + vetCarga[i].calcular());
		
	}
	
}
