public class FilaDeChamadas {
    Nodo prim = null;
    int tamanho = 0;

    public void inserir(String telefone) throws Exception {
        Nodo novo = new Nodo();
        Nodo ant = null;

        for (Nodo i = prim; i != null && getPrioridade(i.getInfo()) < getPrioridade(telefone); i = i.getProx()) {
            ant = i;
        }

        novo.setInfo(telefone);

        if (ant == null) {
            novo.setProx(prim);
            prim = novo;
        } else {
            novo.setProx(ant.getProx());
            ant.setProx(novo);
        }
        tamanho++;
    }

    public String remover() {
        String telefone = prim.getInfo();
        prim = prim.getProx();
        tamanho--;
        return telefone;
    }

    public boolean validarTelefone(String telefone) {
        char carac;
        for (int i = 0; i < telefone.length(); i++) {
            carac = telefone.charAt(i);
            if (!Character.isDigit(carac)) {
                return false;
            }
        }
        return true;
    }

    public String getPosicao(String telefone) {
        int posicao = 1;

        for (Nodo i = prim; i != null && !i.getInfo().equals(telefone); i = i.getProx()) {
            posicao++;
        }
        return posicao + "/" + this.tamanho;
    }

    public boolean inFila(String telefone) {
        for (Nodo i = prim; i != null; i = i.getProx()) {
            if (i.getInfo().equals(telefone))
                return true;
        }
        return false;
    }

    public boolean isVazia() {
        if (prim == null)
            return true;
        return false;
    }

    // Quanto mais longe a chamada, menor o valor (Quanto menor, mais prioridade);
    public int getPrioridade(String telefone) throws Exception {

        switch (getDDD(telefone)) {
        case 95:
            return 1;
        case 96:
            return 2;
        case 68:
            return 3;
        case 97:
            return 4;
        case 92:
            return 5;
        case 91:
            return 6;
        case 98:
            return 7;
        case 85:
            return 8;
        case 84:
            return 9;
        case 83:
            return 10;
        case 81:
            return 11;
        case 88:
            return 12;
        case 86:
            return 13;
        case 69:
            return 14;
        case 93:
            return 15;
        case 94:
            return 16;
        case 99:
            return 17;
        case 82:
            return 18;
        case 87:
            return 19;
        case 89:
            return 20;
        case 79:
            return 21;
        case 71:
            return 22;
        case 75:
            return 23;
        case 74:
            return 24;
        case 63:
            return 25;
        case 65:
            return 26;
        case 66:
            return 27;
        case 62:
            return 28;
        case 77:
            return 29;
        case 73:
            return 30;
        case 53:
            return 31;
        case 55:
            return 32;
        case 51:
            return 33;
        case 54:
            return 34;
        case 61:
            return 35;
        case 64:
            return 36;
        case 67:
            return 37;
        case 33:
            return 38;
        case 38:
            return 39;
        case 49:
            return 40;
        case 46:
            return 41;
        case 48:
            return 42;
        case 47:
            return 43;
        case 42:
            return 44;
        case 45:
            return 45;
        case 27:
            return 46;
        case 28:
            return 47;
        case 41:
            return 48;
        case 43:
            return 49;
        case 44:
            return 50;
        case 34:
            return 51;
        case 37:
            return 52;
        case 31:
            return 53;
        case 32:
            return 54;
        case 22:
            return 55;
        case 21:
            return 56;
        case 24:
            return 57;
        case 17:
            return 58;
        case 18:
            return 59;
        case 13:
            return 60;
        case 12:
            return 61;
        case 35:
            return 62;
        case 16:
            return 63;
        case 14:
            return 64;
        case 15:
            return 65;
        case 11:
            return 66;
        case 19:
            return 67;
        default:
            throw new Exception("DDD inválido.");
        }
    }

    private int getDDD(String telefone) {
        return Integer.parseInt(telefone.substring(0, 2));
    }

    @Override
    public String toString() {
        if (isVazia())
            return "{}";
        return "{" + this.prim.getInfo() + "}";
    }

    private class Nodo {
        private String info;
        private Nodo prox;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public Nodo getProx() {
            return prox;
        }

        public void setProx(Nodo prox) {
            this.prox = prox;
        }
    }
}