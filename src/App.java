import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import os;

public class App {
    public static void main(String[] args) {
        String nome, telefone;
        boolean numero_validado;

        FilaDeChamadas fila = new FilaDeChamadas();

        try {
            Scanner ler = new Scanner(System.in);

            System.out.println("Seja bem-vindo ao atendimento ao cliente! :)\n");
            System.out.printf("Nome: ");
            nome = ler.nextLine();
            System.out.printf("Telefone: ");
            telefone = ler.nextLine();

            if (!fila.validacaoTelefone(telefone)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Seja bem-vindo ao atendimento ao cliente! :)\n");
                System.out.printf("Nome: ");
                nome = ler.nextLine();
                System.out.printf("Telefone: ");
                telefone = ler.nextLine();
            }

            fila.inserir("19997713109");
            fila.inserir("99914568771");
            
            System.out.println(fila);
            TimeUnit.SECONDS.sleep(5);
            
            fila.remover();
            System.out.println(fila);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}