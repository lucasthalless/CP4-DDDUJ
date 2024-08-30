package br.com.fiap.bean;

import java.io.*;

/**
 * Classe para manipulação de dados de um personagem de Dragon Ball Super.
 *
 * @author Lucas Thalles dos Santos
 */
public class DragonBallSuper implements IDBSuper{
    private String nome;
    private int ki, tecnicas, velocidade, transformacoes;

    public DragonBallSuper() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public int getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacoes() {
        return transformacoes;
    }

    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    /**
     * Lê os dados de um personagem a partir de um arquivo.
     *
     * @param path Caminho do arquivo.
     * @return Objeto da classe DragonBallSuper com os dados lidos (um personagem).
     * @throws IOException Caso ocorra algum erro durante a leitura.
     *
     * @author Lucas Thalles dos Santos
     */
    @Override
    public DragonBallSuper ler(String path) throws IOException {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(path + "/" + nome + ".txt")
            );
            nome = br.readLine();
            ki = Integer.parseInt(br.readLine());
            tecnicas = Integer.parseInt(br.readLine());
            velocidade = Integer.parseInt(br.readLine());
            transformacoes = Integer.parseInt(br.readLine());
            br.close();
            return this;
        } catch (IOException exception) {
            throw new IOException(exception);
        }
    }

    /**
     * Grava os dados de um personagem em um arquivo.
     *
     * @param path Caminho do arquivo.
     * @return Mensagem de sucesso ou erro.
     * @throws IOException Caso ocorra algum erro durante a gravação.
     *
     * @author Lucas Thalles dos Santos
     */
    @Override
    public String gravar(String path) {
        try {
            File dir = new File(path);
            if(!dir.exists()) {
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(ki);
            pw.println(tecnicas);
            pw.println(velocidade);
            pw.println(transformacoes);
            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso!";
        } catch (IOException exception) {
            return "Falha ao gravar arquivo" + exception.getMessage();
        }
    }
}
