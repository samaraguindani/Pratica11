import java.util.ArrayList;

public class Persistencia {

    public ArrayList<Negocio> leituraArquivo(){

        ArrayList<Negocio> listaDeContato = new ArrayList<Negocio>();
        Arquivo arq = new Arquivo("agenda.txt");

        if(arq.abrirLeitura()){
            String linha = arq.lerLinha();
            while (linha != null){
                String[] campos = linha.split(";");
                String nome = campos[0];
                String email = campos[1];
                String telefone = campos[2];
                Negocio n = new Negocio(nome, email, telefone);
                listaDeContato.add(n);
                linha = arq.lerLinha();
            }
            arq.fecharArquivo();
        }
        return listaDeContato;
    }

    public void salvarArquivo(ArrayList<Negocio> listaDeContato){
        Arquivo a = new Arquivo("agenda.txt");

        if(a.abrirEscrita()){
            for(Negocio n : listaDeContato){
                a.escreverLinha(n.getNome()+";"+n.getEmail()+";"+n.getTelefone());
            }
            a.fecharArquivo();
        }
    }
}

/*persistência com um uma classe responsável por salvar um novo contato no arquivo de contatos (junto com os demais contatos); 
ler e retornar um determinado contado do banco de dados de contatos; 
deletar um determinado contato e salvar novamente só os contatos que ficaram; */