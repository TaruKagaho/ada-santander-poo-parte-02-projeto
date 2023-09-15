package ada.poo02.projeto.controllers.views;

import static ada.poo02.projeto.utils.InputHandler.getIntInput;

public class MenuView {
    private MenuView() {
    }

    public static int show() {
        System.out.println("Digite a opção desejada:");
        System.out.println(" 0 - Sair.");
        System.out.println(" 1 - Cadastrar cliente.");
        System.out.println(" 2 - Listar clientes.");
        System.out.println(" 3 - Atualizar cliente.");
        System.out.println(" 4 - Cadastrar veículo.");
        System.out.println(" 5 - Listar veículos.");
        System.out.println(" 6 - Atualizar veículo.");
        System.out.println(" 7 - Buscar veículo pelo modelo.");
        System.out.println(" 8 - Alugar um veículo.");
        System.out.println(" 9 - Listar aluguéis de veículos.");
        System.out.println("10 - Devolver um veículo.");

        return getIntInput("");
    }

    public static boolean tryAgain() {
        System.out.println("Opção inválida. Tente novamente.");

        return true;
    }
}
