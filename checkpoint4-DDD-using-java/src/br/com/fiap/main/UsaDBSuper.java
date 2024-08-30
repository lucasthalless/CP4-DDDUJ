package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.*;
import java.io.IOException;

// Lucas Thalles dos Santos
// RM 558886
public class UsaDBSuper {
    public static void main(String[] args) {
        String aux, nome, path;
        int ki, tecnicas, velocidade, transformacoes;
        DragonBallSuper dbSuper ;

        do {
            try {
                aux = JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                    "1 - Cadastrar Personagem\n" +
                    "2 - Consultar Personagem"
                );
                path = JOptionPane.showInputDialog("Digite o caminho da pasta");
                dbSuper = new DragonBallSuper();
                switch (Integer.parseInt(aux)) {
                    case 1:
                        nome = JOptionPane.showInputDialog("Nome do personagem:");
                        ki = Integer.parseInt(JOptionPane.showInputDialog("KI do personagem:"));
                        tecnicas = Integer.parseInt(JOptionPane.showInputDialog("Técnicas do personagem:"));
                        velocidade = Integer.parseInt(JOptionPane.showInputDialog("Velocidade do personagem:"));
                        transformacoes = Integer.parseInt(JOptionPane.showInputDialog("Transformações do personagem:"));
                        dbSuper.setNome(nome);
                        dbSuper.setKi(ki);
                        dbSuper.setTecnicas(tecnicas);
                        dbSuper.setVelocidade(velocidade);
                        dbSuper.setTransformacoes(transformacoes);
                        JOptionPane.showMessageDialog(null, dbSuper.gravar(path));
                        break;
                    case 2:
                        nome = JOptionPane.showInputDialog("Digite o nome do personagem");
                        dbSuper.setNome(nome);
                        dbSuper = dbSuper.ler(path);
                        if (dbSuper == null) {
                            JOptionPane.showMessageDialog(null,
                                    "Caminho e/ou personagem informado inexistente(s)");
                        } else {
                            JOptionPane.showMessageDialog(null, "Dados do personagem:" +
                                "\nNome: " + dbSuper.getNome() +
                                "\nKI: " + dbSuper.getKi() +
                                "\nTécnicas: " + dbSuper.getTecnicas() +
                                "\nVelocidade: " + dbSuper.getVelocidade() +
                                "\nTransformações: " + dbSuper.getTransformacoes()
                            );
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Erro de conversão!\n" + exception.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo!\n" + exception.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Erro: " + exception.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa");
    }
}
