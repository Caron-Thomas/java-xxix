package atividade;

public class Tst {
	
	private static Leitura l = new Leitura();
	
	public static void main(String arg[]) {
		
		boolean run = true;
		boolean cadastra = false;
		int opcao   = 0;
		String placa = "";
				
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
			System.out.println("7) Excluir Veiculo de Passeio pela Placa");
			System.out.println("8) Excluir Veiculo de Carga pela Placa");
			System.out.println("9) Sair do Sistema");
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
						
						Passeio p = carregarPasseio();
						BDVeiculos.cadastraVPasseio(p);
						cadastra = l.entDados("Deseja cadastrar novo veículo de passeio? >>"
								+ " Digite S/N <<  ").toLowerCase().equals("s");
					
					} break;
			
				case 2:
					cadastra = true;
					while(cadastra) {
						System.out.println("  ========== CADASTRO DE VEÍCULO DE CARGA ==========");
												
						Carga c = carregarCarga();
						BDVeiculos.cadastraVCarga(c);
						cadastra = l.entDados("Deseja cadastrar novo veículo de passeio? >>"
								+ " Digite S/N <<  ").toLowerCase().equals("s");
					
					} break;
			
				case 3:
					System.out.println("  =========== IMPRIMIR VEÍCULO DE PASSEIO ============");
					
					BDVeiculos.imprimirVeiculoPasseio(null);
					break;
					
				case 4:
					System.out.println("  ============ IMPRIMIR VEÍCULO DE CARGA =============");
					
					BDVeiculos.imprimirCarga(null);
					break;
					
				case 5:
					System.out.println("  =========== IMPRIMIR VEÍCULO DE PASSEIO ============");
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					BDVeiculos.imprimirVeiculoPasseio(placa);
					break;
					
				case 6:
					System.out.println("  ============ IMPRIMIR VEÍCULO DE CARGA =============");
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					BDVeiculos.imprimirCarga(placa);
					break;
				
				case 7:
					System.out.println("  ============ EXCLUIR VEÍCULO DE PASSEIO ============");
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					try {
						BDVeiculos.excluirVeiculoPasseio(placa);
					} catch(VeicExistException vee) {
						vee.veicNaoExistException();
					}
					break;
					
				case 8:
					System.out.println("  ============ EXCLUIR VEÍCULO DE CARGA =============");
					
					System.out.println("   Para escolher um veículo, por favor digite a placa:");
					placa = (l.entDados("   Entre com a Placa.....................: "));
					try {
						BDVeiculos.excluirVeiculoCarga(placa);
					} catch(VeicExistException vee) {
						vee.veicNaoExistException();
					}
					break;
					
				case 9:
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
	
	public static Passeio carregarPasseio() {
		Passeio vPasseio = new Passeio();
		System.out.print(" +-------------------------------------------------+");
		System.out.print("\n |  Insira os dados e valores solicitados abaixo:  |");
		System.out.print("\n +-------------------------------------------------+\n");
		try {
		vPasseio.setPlaca(l.entDados("   Entre com a Placa.....................: "));
		if(BDVeiculos.buscaPlaca(vPasseio.getPlaca(), 1) != -1) {
				System.out.println("Já existe veiculo cadastrado com esta placa.");	
				return null;
			}
		vPasseio.setMarca(l.entDados("   Entre com a Marca.....................: "));
		vPasseio.setModelo(l.entDados("   Entre com a Modelo....................: "));
		vPasseio.setCor(l.entDados("   Entre com a Cor.......................: "));
		vPasseio.setQtdRodas(Integer.parseInt(l.entDados("   Entre com a Qtd de Rodas..............: ")));
		vPasseio.setQtdPassageiros(Integer.parseInt(l.entDados("   Entre com a Capacidade Passageiros....: ")));
		vPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("   Entre com a potência do Motor.........: ")));
		vPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("   Entre com a Qtd de Pistões do Motor...: ")));
		vPasseio.setVelocMax(Float.parseFloat(l.entDados("   Entre com a Velocidade Máxima.........: ")));

		} catch(VelocException ve) {
			ve.impSolucao();
			try {
				vPasseio.setVelocMax(100F);
			} catch (VelocException vPasseioe) {
				System.out.println(vPasseioe.getCause());
			}
		}
		catch(NumberFormatException nfe) {
			System.out.println("O valor deve ser um número");
			return null;
		}
		
		l.entDados("\n Press<ENTER> to save... ");
		
		return vPasseio;
	}
	
	public static Carga carregarCarga() {
		Carga vCarga = new Carga();
		System.out.print(" +-------------------------------------------------+");
		System.out.print("\n |  Insira os dados e valores solicitados abaixo:  |");
		System.out.print("\n +-------------------------------------------------+\n");
		try {
		vCarga.setPlaca(l.entDados("   Entre com a Placa......................: "));
		if(BDVeiculos.buscaPlaca(vCarga.getPlaca(), 2) != -1) {
				System.out.println("Já existe veiculo cadastrado com esta placa.");
				return null;
			}
		vCarga.setMarca(l.entDados("   Entre com a Marca......................: "));
		vCarga.setModelo(l.entDados("   Entre com a Modelo.....................: "));
		vCarga.setCor(l.entDados("   Entre com a Cor........................: "));
		vCarga.setQtdRodas(Integer.parseInt(l.entDados("   Entre com a Qtd de Rodas...............: ")));
		vCarga.setCargaMax(Integer.parseInt(l.entDados("   Entre com a Capacidade de Carga Máxima.: ")));
		vCarga.setTara(Integer.parseInt(l.entDados("   Entre com a Tara do Veiculo de Carga...: ")));
		vCarga.getMotor().setPotencia(Integer.parseInt(l.entDados("   Entre com a potência do Motor..........: ")));
		vCarga.getMotor().setQtdPist(Integer.parseInt(l.entDados("   Entre com a Qtd de Pistões do Motor....: ")));
		vCarga.setVelocMax(Float.parseFloat(l.entDados("   Entre com a Velocidade Máxima..........: ")));
		
		} catch (VelocException ve) {
			ve.impSolucao();
			try {
				vCarga.setVelocMax(90F);
			} catch (VelocException vCargae) {
				System.out.println(vCargae.getCause());
			}
		}
		
		catch(NumberFormatException nfe) {
			System.out.println("O valor deve ser um número");
			return null;
		}
		
		l.entDados("\n Press<ENTER> to save... ");
		
		return vCarga;
	}
}
