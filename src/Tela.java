import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tela extends JFrame {

    private Negocio n = new Negocio();

    private JLabel email = new JLabel("Email: ");
    private JLabel nome = new JLabel("Nome: ");
    private JLabel telefone = new JLabel("Telefone: ");

    private JTextField textoEmail = new JTextField();
    private JTextField textoNome = new JTextField();  
    private JTextField textoTelefone = new JTextField();

    private JButton botaoCadastro = new JButton("CADASTRAR"); 
    private JButton botaoEdicao = new JButton("EDITAR"); 
    private JButton botaoExcluir = new JButton("EXCLUIR");
    private JButton botaoVerTodos = new JButton("VER TODOS");

    private Font fonte1 = new Font("Arial", Font.PLAIN, 14);

    public Tela(){
        //Configurações da janela
        setSize(800, 500); 
        setTitle("Tela principal"); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); 

        email.setBounds(10, 30, 100, 20); 
        email.setFont(fonte1);
        add(email);

        textoEmail.setBounds(100, 30, 200, 20);
        textoEmail.setFont(fonte1);
        add(textoEmail);

        nome.setBounds(10, 60, 100, 20); 
        nome.setFont(fonte1);
        add(nome);

        textoNome.setBounds(100, 60, 200, 20);
        textoNome.setFont(fonte1);
        add(textoNome);

        telefone.setBounds(10, 90, 100, 20); 
        telefone.setFont(fonte1);
        add(telefone);

        textoTelefone.setBounds(100, 90, 200, 20);
        textoTelefone.setFont(fonte1);
        add(textoTelefone);

        botaoCadastro.setBounds(330, 90, 200, 20);
        botaoCadastro.setFont(fonte1);
        add(botaoCadastro);
        botaoCadastro.addActionListener(this::acao1); 

        botaoEdicao.setBounds(150, 150, 130, 20);
        botaoEdicao.setFont(fonte1);
        add(botaoEdicao);
        botaoEdicao.addActionListener(this::acao2);

        botaoExcluir.setBounds(290, 150, 130, 20);
        botaoExcluir.setFont(fonte1);
        add(botaoExcluir);
        botaoExcluir.addActionListener(this::acao3);

        botaoVerTodos.setBounds(10, 150, 130, 20);
        botaoVerTodos.setFont(fonte1);
        add(botaoVerTodos);
        botaoVerTodos.addActionListener(this::acao4);

        setVisible(true);
    }

    private void acao1 (ActionEvent actionEvent) {
        n.setEmail(textoEmail.getText());
        n.setNome(textoNome.getText());
        n.setTelefone(textoTelefone.getText());
        n.Cadastrar();
    }

    private void acao2 (ActionEvent actionEvent) {
        n.setEmail(textoEmail.getText());
        n.setNome(textoNome.getText());
        n.setTelefone(textoTelefone.getText());
        n.Editar();
    }

    private void acao3 (ActionEvent actionEvent) {
        n.setEmail(textoEmail.getText());
        n.setNome(textoNome.getText());
        n.setTelefone(textoTelefone.getText());
        n.Excluir();
    }

    private void acao4(ActionEvent actionEvent) {
    n.verTodos();
}
     
}
