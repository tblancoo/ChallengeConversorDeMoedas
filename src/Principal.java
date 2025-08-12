import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String apiKey = "e997f3f0b0be08a12a7f8ccc";
        ConversorDeMoedas conversor = new ConversorDeMoedas(apiKey);
        Scanner sc = new Scanner(System.in);

        while (true) {
            // BLOCO DO MENU (igual à foto)
            System.out.println("************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println();
            System.out.println("1) Dólar  >>  Peso argentino");
            System.out.println("2) Peso argentino  >>  Dólar");
            System.out.println("3) Dólar  >>  Real brasileiro");
            System.out.println("4) Real brasileiro  >>  Dólar");
            System.out.println("5) Dólar  >>  Peso colombiano");
            System.out.println("6) Peso colombiano  >>  Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("************************************************");

            String entrada = sc.nextLine().trim();

            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.\n");
                continue;
            }

            if (opcao == 7) {
                System.out.println("Encerrando... Obrigado por usar o Conversor de Moedas!");
                break;
            }

            String base = "";
            String destino = "";
            if (opcao == 1) { base = "USD"; destino = "ARS"; }
            else if (opcao == 2) { base = "ARS"; destino = "USD"; }
            else if (opcao == 3) { base = "USD"; destino = "BRL"; }
            else if (opcao == 4) { base = "BRL"; destino = "USD"; }
            else if (opcao == 5) { base = "USD"; destino = "COP"; }
            else if (opcao == 6) { base = "COP"; destino = "USD"; }
            else {
                System.out.println("Opção inválida.\n");
                continue;
            }

            // Mostra o número escolhido (linha verde na sua captura)
            System.out.println();
            System.out.println(entrada);
            System.out.println();

            // Prompt exatamente como na imagem
            System.out.println("Digite o valor que deseja converter:");
            String valorStr = sc.nextLine().trim().replace(",", ".");
            double valor;
            try {
                valor = Double.parseDouble(valorStr);
                if (valor < 0) {
                    System.out.println("Valor inválido.\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.\n");
                continue;
            }

            try {
                double convertido = conversor.converter(valor, base, destino);

                // Linha do resultado no formato da foto (com >>>)
                System.out.println();
                System.out.println("Valor " + valor + " [" + base + "] corresponde ao valor final de >>> "
                        + convertido + " [" + destino + "]");
                System.out.println("************************************************");
                System.out.println();

            } catch (Exception e) {
                System.out.println("Erro na conversão: " + e.getMessage() + "\n");
                if (e instanceof InterruptedException) Thread.currentThread().interrupt();
            }
        }
    }
}









