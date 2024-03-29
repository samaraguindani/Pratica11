import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Negocio {
    String nome;
    String email;
    String telefone;

    private Persistencia p = new Persistencia();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Negocio() {
    }

    public Negocio(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void Cadastrar(){
        boolean aux = true;
        ArrayList<Negocio> listaDeContato = p.leituraArquivo();
        for(Negocio n : listaDeContato){
            if(n.getEmail().equals(this.email)){
                JOptionPane.showMessageDialog(null, "E-mail já cadastrado!", "Cadastrar contato", JOptionPane.ERROR_MESSAGE);
                aux = false;
            }
        }
        if(aux){
            listaDeContato.add(new Negocio(nome, email, telefone));
            p.salvarArquivo(listaDeContato);
            JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!", "Cadastrar contato", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Editar() {
        ArrayList<Negocio> listaDeContato = p.leituraArquivo();
        boolean encontrado = false;

        for (int i = 0; i < listaDeContato.size(); i++) {
            Negocio n = listaDeContato.get(i);
            if (n.getEmail().equals(this.email)) {
                n.setNome(this.nome);
                n.setTelefone(this.telefone);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            p.salvarArquivo(listaDeContato);
            JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!", "Editar contato", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Contato não encontrado!", "Editar contato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Excluir() {
        ArrayList<Negocio> listaDeContato = p.leituraArquivo();
        boolean encontrado = false;
        int aux = 0;

        for (int i = 0; i < listaDeContato.size(); i++) {
            Negocio n = listaDeContato.get(i);
            if (n.getEmail().equals(email)) {
                aux = i;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            listaDeContato.remove(aux);
            p.salvarArquivo(listaDeContato);
            JOptionPane.showMessageDialog(null, "Contato excluído com sucesso!", "Excluir contato", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Contato não encontrado!", "Excluir contato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verTodos(){
        ArrayList<Negocio> listaDeContato = p.leituraArquivo();

        if (listaDeContato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum contato cadastrado.", "Contatos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensagem = new StringBuilder("Contatos cadastrados:\n");
            for (Negocio n : listaDeContato) {
                mensagem.append("Nome: ").append(n.getNome()).append("\n");
                mensagem.append("Email: ").append(n.getEmail()).append("\n");
                mensagem.append("Telefone: ").append(n.getTelefone()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, mensagem.toString(), "Contatos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

/*negócios (classe contato)*/