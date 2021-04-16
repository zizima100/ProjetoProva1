public class App {
    public static void main(String[] args) {
        FilaDeChamadas fila = new FilaDeChamadas();

        try {
            fila.inserir("19997713109");
            fila.inserir("99914568771");
            
            System.out.println(fila);
            
            fila.remover();
            System.out.println(fila);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}