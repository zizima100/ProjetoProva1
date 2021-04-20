import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        String telefone = "";

        FilaDeChamadas fila = new FilaDeChamadas();

        try {
            Scanner ler = new Scanner(System.in);
            boolean loop = true;
            clear();

            do {
                System.out.println("Seja bem-vindo ao atendimento ao cliente! :)\n");
                System.out.println("Opções:");
                System.out.println("[0] - Sair");
                System.out.println("[1] - Inserir novo número");

                switch (Integer.parseInt(ler.nextLine())) {
                case 0:
                    System.out.println("Saindo do programa. . .");
                    System.exit(1);
                case 1:
                    clear();
                    System.out.printf("Telefone: ");
                    telefone = ler.nextLine();

                    while (!fila.validacaoTelefone(telefone)) {
                        clear();
                        System.out.println("Por favor, digite um número válido :)\n");
                        System.out.printf("Telefone: ");
                        telefone = ler.nextLine();
                    }
                    loop = false;
                default:
                    break;
                }
                if (loop) {
                    clear();
                    System.out.println("Digite uma opção válida. . .");
                }
            } while (loop);

            // Insere nove números + o digitado
            fila.inserir("19997713109");
            fila.inserir("99914568771");
            fila.inserir("95998654758");
            fila.inserir("35996853214");
            fila.inserir("11998547123");
            fila.inserir("24998652347");
            fila.inserir("47997456245");
            fila.inserir("19996325477");
            fila.inserir("99996325787");
            fila.inserir(telefone);

            clear();
            while (!fila.isVazia()) {
                System.out.println("---------------------------------------------------------------------------------");
                if (fila.inFila(telefone)) {
                    if (fila.getPosicao(telefone).charAt(0) == '1') {
                        System.out.println("O seu número está sendo atendido!!");
                        TimeUnit.SECONDS.sleep(2);
                        fila.remover();
                        continue;
                    } else {
                        System.out.println(
                                "Seu número {" + telefone + "} está na posição " + fila.getPosicao(telefone) + "\n");
                    }
                }
                System.out.println("Número sendo atendido: " + fila);
                TimeUnit.SECONDS.sleep(2);
                fila.remover();
            }
            System.out.println("Todos os números já foram atendidos.");
            ler.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}