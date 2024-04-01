import banco.BancoImpl;

import javax.swing.JOptionPane;

public class DialogApp {
    static BancoImpl bancoImpl = new BancoImpl();
    public static void main(String[] args) throws Exception {
        bancoImpl.menu();
    }
}