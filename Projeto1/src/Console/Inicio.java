package Console;

import java.util.Scanner;
import Maquina.Maquina;
import Maquina.Produtos;

public class Inicio {

	public static void main(String[] args) {

		int menu = 0;
		int menuMoedas = 0;
		int menuCompras = 0;
		int quantidade = 0;
		int quantidadeTroco25 = 0;
		int quantidadeTroco50 = 0;
		int quantidadeTroco1 = 0;
		int soma;
		double trocoTotal;
		double valorUsuario25 = 0;
		double valorUsuario50 = 0;
		double valorUsuario1 = 0;
		double valorUsuario = 0;

		Scanner sc = new Scanner(System.in);
		Maquina maquina = new Maquina();
		Produtos produtos = new Produtos();

		while (menu <= 8) {

			System.out.println(maquina.LigarMaquina());
			System.out.println("________________________________________");
			System.out.println("Incluir valores........................1");
			System.out.println("Ver valores das moedas.................2");
			System.out.println("Comprar................................3");
			System.out.println("Sair...................................9");
			System.out.println("________________________________________");
			System.out.println("");
			System.out.print("Digite a opção: ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Você entrou no menu de inclusão de moedas");
				System.out.println("Quantidade de Moedas de 25 Centavos.....................1");
				System.out.println("Quantidade de Moedas de 50 Centavos.....................2");
				System.out.println("Quantidade de Moedas de 1 Real..........................3");
				System.out.println("Sair....................................................9");
				System.out.print("Digite a opção: ");
				menuMoedas = sc.nextInt();
				switch (menuMoedas) {
				case 1:
					quantidade = 0;
					System.out.print("Qual a quantidade de moedas?: ");
					quantidade = sc.nextInt();
					maquina.set_25centavos(quantidade);
					break;
				case 2:
					quantidade = 0;
					System.out.print("Qual a quantidade de moedas?: ");
					quantidade = sc.nextInt();
					maquina.set_50centavos(quantidade);
					break;
				case 3:
					quantidade = 0;
					System.out.print("Qual a quantidade de moedas?: ");
					quantidade = sc.nextInt();
					maquina.set_1real(quantidade);
					break;
				}
				break;
			case 2:
				System.out.println("Quantidade 25 Centavos: " + maquina.get_25centavos());
				System.out.println("Valor: " + maquina.get_25centavos() * 0.25);

				System.out.println("Quantidade 50 Centavos: " + maquina.get_50centavos());
				System.out.println("Valor: " + maquina.get_50centavos() * 0.50);

				System.out.println("Quantidade 1 Real: " + maquina.get_1real());
				System.out.println("Valor: " + maquina.get_1real());

				break;
			case 3:
				System.out.println("Compra de produtos");
				System.out.println("Coca-Cola (R$ " + produtos.getCoca_cola() + ").....................1");
				System.out.println("Guaraná (R$ " + produtos.getGuarana() + ")......................2");
				System.out.println("Gengibirra (R$ " + produtos.getGengibirra() + ")....................3");
				System.out.println("Sair...................................9");
				System.out.print("Digite a opção: ");
				menuCompras = sc.nextInt();

				switch (menuCompras) {
				case 1:
					System.out.println("Valor do produto R$" + produtos.getCoca_cola());
					valorUsuario = 0.0;

					while (valorUsuario < produtos.getCoca_cola()) {

						System.out.print("Quantidade de Moedas de 0,25: ");
						valorUsuario25 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 0,50: ");
						valorUsuario50 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 1,00: ");
						valorUsuario1 = sc.nextDouble();

						valorUsuario = maquina.SomaMoedas(valorUsuario25, valorUsuario50, valorUsuario1);

					}

					soma = (int) (maquina.get_25centavos() + valorUsuario25);
					maquina.set_25centavos(soma);

					soma = (int) (maquina.get_50centavos() + valorUsuario50);
					maquina.set_50centavos(soma);

					soma = (int) (maquina.get_1real() + valorUsuario1);
					maquina.set_1real(soma);

					System.out.println("Precisa Devolver: ");
					trocoTotal = maquina.CalculoCompra(valorUsuario, produtos.getCoca_cola());
					System.out.println(trocoTotal);

					if (maquina.CalculoCompra(valorUsuario, produtos.getCoca_cola()) > 0) {
						if (trocoTotal >= 1) {
							if (maquina.get_1real() >= trocoTotal) {
								while (trocoTotal >= 1) {

									quantidadeTroco1 = quantidadeTroco1 + 1;
									trocoTotal = trocoTotal - 1;
								}
							}

						} else if (trocoTotal >= 0.50) {

							if (maquina.ConvetMoeda50((double) maquina.get_50centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco50 = quantidadeTroco50 + 1;
									trocoTotal = trocoTotal - 0.50;
								}
							}

						} else if (trocoTotal >= 0.25) {

							if (maquina.ConvetMoeda25((double) maquina.get_25centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco25 = quantidadeTroco25 + 1;
									trocoTotal = trocoTotal - 0.25;
								}
							}
						}

						soma = 0;
						soma = (int) (maquina.get_25centavos() - quantidadeTroco25);
						maquina.set_25centavos(soma);

						soma = (int) (maquina.get_50centavos() - quantidadeTroco50);
						maquina.set_50centavos(soma);

						soma = (int) (maquina.get_1real() - quantidadeTroco1);
						maquina.set_1real(soma);

						System.out.println("A Maquina devolveu");
						System.out.println("Moedas R$ 1,00 :" + quantidadeTroco1);
						System.out.println("Moedas R$ 0,50 :" + quantidadeTroco50);
						System.out.println("Moedas R$ 0,25 :" + quantidadeTroco25);

					} else {
						System.out.println("Não tem necessidade de troco");
					}

					break;

				case 2:
					System.out.println("Valor do produto R$" + produtos.getGuarana());
					valorUsuario = 0.0;

					while (valorUsuario < produtos.getGuarana()) {

						System.out.print("Quantidade de Moedas de 0,25: ");
						valorUsuario25 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 0,50: ");
						valorUsuario50 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 1,00: ");
						valorUsuario1 = sc.nextDouble();

						valorUsuario = maquina.SomaMoedas(valorUsuario25, valorUsuario50, valorUsuario1);

					}

					soma = (int) (maquina.get_25centavos() + valorUsuario25);
					maquina.set_25centavos(soma);

					soma = (int) (maquina.get_50centavos() + valorUsuario50);
					maquina.set_50centavos(soma);

					soma = (int) (maquina.get_1real() + valorUsuario1);
					maquina.set_1real(soma);

					System.out.println("Precisa Devolver: ");
					trocoTotal = maquina.CalculoCompra(valorUsuario, produtos.getGuarana());
					System.out.println(trocoTotal);

					if (maquina.CalculoCompra(valorUsuario, produtos.getGuarana()) > 0) {
						if (trocoTotal >= 1) {
							if (maquina.get_1real() >= trocoTotal) {
								while (trocoTotal >= 1) {

									quantidadeTroco1 = quantidadeTroco1 + 1;
									trocoTotal = trocoTotal - 1;
								}
							}

						} else if (trocoTotal >= 0.50) {

							if (maquina.ConvetMoeda50((double) maquina.get_50centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco50 = quantidadeTroco50 + 1;
									trocoTotal = trocoTotal - 0.50;
								}
							}

						} else if (trocoTotal >= 0.25) {

							if (maquina.ConvetMoeda25((double) maquina.get_25centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco25 = quantidadeTroco25 + 1;
									trocoTotal = trocoTotal - 0.25;
								}
							}
						}

						soma = 0;
						soma = (int) (maquina.get_25centavos() - quantidadeTroco25);
						maquina.set_25centavos(soma);

						soma = (int) (maquina.get_50centavos() - quantidadeTroco50);
						maquina.set_50centavos(soma);

						soma = (int) (maquina.get_1real() - quantidadeTroco1);
						maquina.set_1real(soma);

						System.out.println("A Maquina devolveu");
						System.out.println("Moedas R$ 1,00 :" + quantidadeTroco1);
						System.out.println("Moedas R$ 0,50 :" + quantidadeTroco50);
						System.out.println("Moedas R$ 0,25 :" + quantidadeTroco25);

					} else {
						System.out.println("Não tem necessidade de troco");
					}

					break;
				case 3:
					System.out.println("Valor do produto R$" + produtos.getGengibirra());
					valorUsuario = 0.0;

					while (valorUsuario < produtos.getGengibirra()) {

						System.out.print("Quantidade de Moedas de 0,25: ");
						valorUsuario25 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 0,50: ");
						valorUsuario50 = sc.nextDouble();
						System.out.print("Quantidade de Moedas de 1,00: ");
						valorUsuario1 = sc.nextDouble();

						valorUsuario = maquina.SomaMoedas(valorUsuario25, valorUsuario50, valorUsuario1);

					}

					soma = (int) (maquina.get_25centavos() + valorUsuario25);
					maquina.set_25centavos(soma);

					soma = (int) (maquina.get_50centavos() + valorUsuario50);
					maquina.set_50centavos(soma);

					soma = (int) (maquina.get_1real() + valorUsuario1);
					maquina.set_1real(soma);

					System.out.println("Precisa Devolver: ");
					trocoTotal = maquina.CalculoCompra(valorUsuario, produtos.getGengibirra());
					System.out.println(trocoTotal);

					if (maquina.CalculoCompra(valorUsuario, produtos.getGengibirra()) > 0) {
						if (trocoTotal >= 1) {
							if (maquina.get_1real() >= trocoTotal) {
								while (trocoTotal >= 1) {

									quantidadeTroco1 = quantidadeTroco1 + 1;
									trocoTotal = trocoTotal - 1;
								}
							}

						} else if (trocoTotal >= 0.50) {

							if (maquina.ConvetMoeda50((double) maquina.get_50centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco50 = quantidadeTroco50 + 1;
									trocoTotal = trocoTotal - 0.50;
								}
							}

						} else if (trocoTotal >= 0.25) {

							if (maquina.ConvetMoeda25((double) maquina.get_25centavos()) > trocoTotal) {
								while (trocoTotal >= 0.50) {

									quantidadeTroco25 = quantidadeTroco25 + 1;
									trocoTotal = trocoTotal - 0.25;
								}
							}
						}

						soma = 0;
						soma = (int) (maquina.get_25centavos() - quantidadeTroco25);
						maquina.set_25centavos(soma);

						soma = (int) (maquina.get_50centavos() - quantidadeTroco50);
						maquina.set_50centavos(soma);

						soma = (int) (maquina.get_1real() - quantidadeTroco1);
						maquina.set_1real(soma);

						System.out.println("A Maquina devolveu");
						System.out.println("Moedas R$ 1,00 :" + quantidadeTroco1);
						System.out.println("Moedas R$ 0,50 :" + quantidadeTroco50);
						System.out.println("Moedas R$ 0,25 :" + quantidadeTroco25);

					} else {
						System.out.println("Não tem necessidade de troco");
					}
					break;
				}
				break;
			}
			if (menu == 9) {
				System.out.println("Maquina Desligada");
			}
		}
	}
}
