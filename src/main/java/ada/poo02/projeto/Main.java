package ada.poo02.projeto;


import ada.poo02.projeto.controllers.MenuController;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();

        boolean keep = true;

        System.out.println("Bem vindo a plataforma de aluguel de carro!");

        while (keep) {
            keep = menuController.execute();
        }
    }
}