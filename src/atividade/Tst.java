package atividade;

public class Tst {
	
	//atributos  utilizados durante periodo de execução 
	private static Passeio vPasseio = new Passeio();
	private static Carga   vCarga   = new Carga();
	
	private static Passeio vetPasseio[] = new Passeio[3];
	private static Carga   vetCarga[]   = new Carga[2];
	
	private static Leitura l = new Leitura();
	
	public static void main(String arg[]) {
		
		boolean run = true;
		boolean cadastra = false;
		int opcao   = 0;
				
		System.out.print(" +---------------------------------------+");
		System.out.print("\n |              BEM VINDO!!              |");
		System.out.println("\n +---------------------------------------+\n");
		
		while(run) {
			System.out.println("============================================");
			System.out.println("Sistema de Gestão de Veiculos - Menu Inicial");
			System.out.println("\n1) Cadastrar Veiculo de Passeio");
			System.out.println("2) Cadastrar Veiculo de Carga");
			System.out.println("3) Imprimir Todos os Veiculo de Passeio");
			System.out.println("4) Imprimir Todos os Veiculo de Carga");
			System.out.println("5) Imprimir Veiculo de Passeio pela Placa");
			System.out.println("6) Imprimir Veiculo de Carga pela Placa");
			System.out.println("7) Sair do Sistema");
			System.out.println("\n============================================");
			System.out.println("Digite uma das opções acima:");
			
			try {
			opcao = Integer.parseInt(l.entDados(">>> "));
			}
			catch (NumberFormatException e) {
				System.out.println("\n=== Opção digitada deve ser um valor inteiro ===");
				l.entDados("=== Press<ENTER> to continue... ");
				continue;
			}
			
			switch(opcao) {
			
				case 1:
					cadastra = true;
					while(cadastra) {
					System.out.println("  ========= CADASTRO DE VEÍCULO DE PASSEIO =========");
					int i = achaEndVagoPasseio(); 
					if(i == -1) {
						System.out.println("\n   Cadastro de veículos Passeio lotado.");
						l.entDados("\n=== Press<ENTER> to continue... ");
						cadastra = false;
						break;
					}
					
					vPasseio = new Passeio();
					vetPasseio[i] = cadastrarPasseio(vPasseio);
					System.out.println("\n>>> Veículo salvo na posição "+ i +" <<<");				
					cadastra = (l.entDados("Deseja cadastrar novo veículo de passeio? >> Digite S/N <<  ")
												.toLowerCase()
												.equals("s"))
												? true
												: false;
					} break;
			
				case 2:
					cadastra = true;
					while(cadastra) {
					System.out.println("  ========== CADASTRO DE VEÍCULO DE CARGA ==========");
					int j = achaEndVagoCarga(); 
					if(j == -1) {
						System.out.println("\n   Cadastro de veículos Carga lotado.");
						l.entDados("\n=== Press<ENTER> to continue... ");
						cadastra = false;
						break;
					}
					
					vCarga = new Carga();
					vetCarga[j] = cadastrarCarga(vCarga);
					System.out.println("\n>>> Veículo salvo na posição "+ j +" <<<");	
					cadastra = (l.entDados("Deseja cadastrar novo veículo de carga? >> Digite S/N <<  ")
							.toLowerCase()
							.equals("s"))
							? true
							: false;
					} break;
			
				case 3:
					System.out.println("  =========== IMPRIMIR VEÍCULO DE PASSEIO ============");
					
					imprimirPasseio(null);
					break;
					
				case 4:
					System.out.println("  ============ IMPRIMIR VEÍCULO DE CARGA =============");
					
					imprimirCarga(null);
					break;
					
				case 5:
					System.out.println("  =========== IMPRIMIR VEÍCULO DE PASSEIO ============");
					String placa = "";
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					imprimirPasseio(placa);
					break;
					
				case 6:
					System.out.println("  ============ IMPRIMIR VEÍCULO DE CARGA =============");
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					imprimirCarga(placa);
					break;
					
				case 7:
					System.out.println("   sair");
					try {
						System.out.println(" .");
						Thread.sleep(1100);
						System.out.println(" .");
						Thread.sleep(900);
						System.out.println(" .");
						Thread.sleep(300);
						System.out.println(" Encerrando processos...");
						Thread.sleep(450);
						System.out.println(" .");
						Thread.sleep(500);
						System.out.println(" .");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("System error...");
					}

					System.out.print(" +--------------------------------------------------+");
					System.out.print("\n |            Agradecemos a preferência:            |");
					System.out.println("\n +--------------------------------------------------+\n");
					run = false;
					break;
					
				default:
					System.out.println("\nPor favor, escolha entre as opções 1 a 7.\n");
					l.entDados("=== Press<ENTER> to continue... ");
			}
			
			
		}
		
	}
	
	public static int achaEndVagoPasseio() {
		
		for (int i = 0; i < vetPasseio.length; i++) {
			if(vetPasseio[i] == null)
				return i;
		}
		return -1;
	}
	
	public static Passeio cadastrarPasseio(Passeio vPasseio) {
		
		System.out.print(" +-------------------------------------------------+");
		System.out.print("\n |  Insira os dados e valores solicitados abaixo:  |");
		System.out.print("\n +-------------------------------------------------+\n");
		vPasseio.setPlaca(l.entDados("   Entre com a Placa.....................: "));
		vPasseio.setMarca(l.entDados("   Entre com a Marca.....................: "));
		vPasseio.setModelo(l.entDados("   Entre com a Modelo....................: "));
		vPasseio.setCor(l.entDados("   Entre com a Cor.......................: "));
		vPasseio.setQtdRodas(Integer.parseInt(l.entDados("   Entre com a Qtd de Rodas..............: ")));
		vPasseio.setQtdPassageiros(Integer.parseInt(l.entDados("   Entre com a Capacidade Passageiros....: ")));
		try {
		vPasseio.setVelocMax(Float.parseFloat(l.entDados("   Entre com a Velocidade Máxima.........: ")));
		} catch(VelocException ve) {
			ve.impSolucao();
			try {
				vPasseio.setVelocMax(100F);
			} catch (VelocException vPasseioe) {
				System.out.println(vPasseioe.getCause());
			}
			
		}
		vPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("   Entre com a potência do Motor.........: ")));
		vPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("   Entre com a Qtd de Pistões do Motor...: ")));

		l.entDados("\n Press<ENTER> to save... ");
		
		return vPasseio;
	}

	
	public static void imprimirPasseio(String placa) {
		
		if(placa != null) {
			int posicao = -1;
		
			for(int i = 0; i < vetPasseio.length; i++) {
				if(vetPasseio[i].getPlaca().toLowerCase().equals(placa.toLowerCase())) {
					posicao = i;
					break;
				}
			}
			
			if(posicao == -1) {
				System.out.println("\n>>> Veículo não encontrado, verifique digitação <<<");
			} else imprimirDetalhePasseio(posicao);

		} else {
			
			for (int i = 0; i < vetPasseio.length; i++) {
				imprimirDetalhePasseio(i);
			}
		}
	};
	
	public static void imprimirDetalhePasseio(int i) {
				
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
	
	public static int achaEndVagoCarga() {
		
		for (int i = 0; i < vetCarga.length; i++) {
			if(vetCarga[i] == null)
				return i;
		}
		return -1;
	}
	
	public static Carga cadastrarCarga(Carga vCarga) {
		
		System.out.print(" +-------------------------------------------------+");
		System.out.print("\n |  Insira os dados e valores solicitados abaixo:  |");
		System.out.print("\n +-------------------------------------------------+\n");
		vCarga.setPlaca(l.entDados("   Entre com a Placa......................: "));
		vCarga.setMarca(l.entDados("   Entre com a Marca......................: "));
		vCarga.setModelo(l.entDados("   Entre com a Modelo.....................: "));
		vCarga.setCor(l.entDados("   Entre com a Cor........................: "));
		vCarga.setQtdRodas(Integer.parseInt(l.entDados("   Entre com a Qtd de Rodas...............: ")));
		vCarga.setCargaMax(Integer.parseInt(l.entDados("   Entre com a Capacidade de Carga Máxima.: ")));
		vCarga.setTara(Integer.parseInt(l.entDados("   Entre com a Tara do Veiculo de Carga...: ")));
		try {
		vCarga.setVelocMax(Float.parseFloat(l.entDados("   Entre com a Velocidade Máxima..........: ")));
		} catch (VelocException ve) {
			ve.impSolucao();
			try {
				vCarga.setVelocMax(90F);
			} catch (VelocException vCargae) {
				System.out.println(vCargae.getCause());
			}
		} 
		vCarga.getMotor().setPotencia(Integer.parseInt(l.entDados("   Entre com a potência do Motor..........: ")));
		vCarga.getMotor().setQtdPist(Integer.parseInt(l.entDados("   Entre com a Qtd de Pistões do Motor....: ")));

		l.entDados("\n Press<ENTER> to save... ");
		
		return vCarga;
	}

	public static void imprimirCarga(String placa) {
		
		if(placa != null) {
			int posicao = -1;
		
			for(int i = 0; i < vetCarga.length; i++) {
				if(vetCarga[i].getPlaca().toLowerCase().equals(placa.toLowerCase())) {
					posicao = i;
					break;
				}
			}
			
			if(posicao == -1) {
				System.out.println("\n>>> Veículo não encontrado, verifique digitação <<<");
			} else imprimirDetalheCarga(posicao);

		} else {
			
			for (int i = 0; i < vetCarga.length; i++) {
				imprimirDetalheCarga(i);
			}
		}
	}
	
	public static void imprimirDetalheCarga(int i) {
		
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
