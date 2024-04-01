package banco;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class BancoImpl {

    private Banco banco = new Banco();
    public void menu() throws NumberFormatException{
        int opcao = 0;
        boolean loop = true;
        String opcaoString = "";

        do {
            do{
                if (banco.getSaldo() >= 0) {
                    opcaoString = showInputDialog(null, "Bem-vindo\nSaldo atual R$" + banco.getSaldo() + "\nDIGITE A OPÇÃO DESEJADA\n1 - Depositar Saldo\n2 - sacar Saldo\n0 - Sair", "BANCO", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    opcaoString = showInputDialog(null, "Bem-vindo\nSaldo devedor R$" + banco.getSaldo() + "\nDIGITE A OPÇÃO DESEJADA\n1 - Depositar Saldo\n2 - sacar Saldo\n0 - Sair", "BANCO", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    opcao = Integer.parseInt(opcaoString);
                    loop = false;
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "VALOR DE ENTRADA INVALIDO", "ERRO", JOptionPane.ERROR_MESSAGE);
                    loop = true;
                }
            }while (loop);

            switch (opcao){
                case 1:
                    depositarValor();
                    break;
                case 2:
                    sacarValor();
                    break;
            }
        }while (opcao != 0);
    }

    private void depositarValor() throws NumberFormatException{
        boolean loopInfinito = true;
        do {
            String valorDeposito =  showInputDialog(null, "Saldo atual R$" + banco.getSaldo() + "\nDigite o valor que deseja depositar", "DEPOSITO", 3);
            try {
                banco.deposito(Double.parseDouble(valorDeposito));
                loopInfinito = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "VALOR DE ENTRADA INVALIDO", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (loopInfinito);
    }

    private void sacarValor() throws NumberFormatException{
        boolean loopInfinito = true;
        do {
            String valorSaque =  showInputDialog(null, "Saldo atual R$" + banco.getSaldo() + "\nDigite o valor que deseja sacar", "SAQUE", 3);
            try {
                double valorSaqueInt = Double.parseDouble(valorSaque);
                if (valorSaqueInt > banco.getSaldo()){
                    int confirm = JOptionPane.showConfirmDialog(null, "SEU SALDO IRA FICAR NEGATIVO\nCONFIRMA ESTA ACAO?", "CONFIRMACAO", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0){
                        banco.saque(valorSaqueInt);
                    }
                }else if (valorSaqueInt == banco.getSaldo()){
                    int confirm = JOptionPane.showConfirmDialog(null, "SEU SALDO IRA FICAR ZERADO\nCONFIRMA ESTA ACAO?", "CONFIRMACAO", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0){
                        banco.saque(valorSaqueInt);
                    }
                }else {
                    banco.saque(valorSaqueInt);
                }
                loopInfinito = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "VALOR DE ENTRADA INVALIDO", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (loopInfinito);
    }
}