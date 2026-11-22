package view;

import exceptions.LimiteVagasAtingidoException;
import interfaces.Certificavel;
import model.Inscricao;
import model.InscricaoBolsa;
import model.InscricaoRegular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TelaPlataforma extends JFrame implements WindowListener, ActionListener {
    private static final int LIMITE_VAGAS = 3;
    private List<Inscricao> inscricoes = new ArrayList<>();

    protected Dimension dFrame, dLabel, dTextField, dButton, dTextArea;
    protected JLabel lblMatricula, lblNome, lblCurso, lblTipo, lblValorExtra, lblNota;
    protected JTextField txtMatricula, txtNome, txtCurso, txtTipo, txtValorExtra, txtNota;
    protected JButton cmdCadastrar, cmdPesquisar, cmdLancarNota, cmdOrdenar, cmdSair;
    protected JTextArea txtMsg;
    protected JScrollPane scrollMsg;

    public TelaPlataforma(){
        // Dimensão dos componentes
        dFrame = new Dimension(520, 560);
        dLabel = new Dimension(160, 22);
        dTextField = new Dimension(280, 22);
        dButton = new Dimension(135, 26);
        dTextArea = new Dimension(455, 220);

        // Definição das propriedades da Janela Principal
        setTitle("Plataforma de Cursos Online");
        setResizable(false);
        setSize(dFrame);
        setLocation(200, 150);
        setLayout(null);

        // Labels e TextFields
        lblMatricula = new JLabel("Matrícula (Número): ");
        lblMatricula.setSize(dLabel);
        lblMatricula.setLocation(25, 25);
        add(lblMatricula);

        txtMatricula = new JTextField(null);
        txtMatricula.setSize(dTextField);
        txtMatricula.setLocation(195, 25);
        add(txtMatricula);

        lblNome = new JLabel("Nome do Aluno: ");
        lblNome.setSize(dLabel);
        lblNome.setLocation(25, 55);
        add(lblNome);

        txtNome = new JTextField(null);
        txtNome.setSize(dTextField);
        txtNome.setLocation(195, 55);
        add(txtNome);

        lblCurso = new JLabel("Nome do Curso: ");
        lblCurso.setSize(dLabel);
        lblCurso.setLocation(25, 85);
        add(lblCurso);

        txtCurso = new JTextField(null);
        txtCurso.setSize(dTextField);
        txtCurso.setLocation(195, 85);
        add(txtCurso);

        lblTipo = new JLabel("Tipo (1-Reg / 2-Bolsa): ");
        lblTipo.setSize(dLabel);
        lblTipo.setLocation(25, 115);
        add(lblTipo);

        txtTipo = new JTextField(null);
        txtTipo.setSize(dTextField);
        txtTipo.setLocation(195, 115);
        add(txtTipo);

        lblValorExtra = new JLabel("Mensalidade / Desconto: ");
        lblValorExtra.setSize(dLabel);
        lblValorExtra.setLocation(25, 145);
        add(lblValorExtra);

        txtValorExtra = new JTextField(null);
        txtValorExtra.setSize(dTextField);
        txtValorExtra.setLocation(195, 145);
        add(txtValorExtra);

        lblNota = new JLabel("Nota Final (0 a 10): ");
        lblNota.setSize(dLabel);
        lblNota.setLocation(25, 175);
        add(lblNota);

        txtNota = new JTextField(null);
        txtNota.setSize(dTextField);
        txtNota.setLocation(195, 175);
        add(txtNota);

        // Botões
        cmdCadastrar = new JButton("Matricular");
        cmdCadastrar.setSize(dButton);
        cmdCadastrar.setLocation(25, 215);
        cmdCadastrar.addActionListener(this);
        add(cmdCadastrar);

        cmdPesquisar = new JButton("Pesquisar");
        cmdPesquisar.setSize(dButton);
        cmdPesquisar.setLocation(185, 215);
        cmdPesquisar.addActionListener(this);
        add(cmdPesquisar);

        cmdLancarNota = new JButton("Lançar Nota");
        cmdLancarNota.setSize(dButton);
        cmdLancarNota.setLocation(345, 215);
        cmdLancarNota.addActionListener(this);
        add(cmdLancarNota);

        cmdOrdenar = new JButton("Relatório Ordenado");
        cmdOrdenar.setSize(new Dimension(215, 26));
        cmdOrdenar.setLocation(25, 250);
        cmdOrdenar.addActionListener(this);
        add(cmdOrdenar);

        cmdSair = new JButton("Sair");
        cmdSair.setSize(new Dimension(215, 26));
        cmdSair.setLocation(265, 250);
        cmdSair.addActionListener(this);
        add(cmdSair);

        // Área de Texto com Scroll
        txtMsg = new JTextArea();
        txtMsg.setEditable(false);
        scrollMsg = new JScrollPane(txtMsg);
        scrollMsg.setSize(dTextArea);
        scrollMsg.setLocation(25, 290);
        add(scrollMsg);

        addWindowListener(this);
    }

    private void limparCampos(){
        txtMatricula.setText(null);
        txtNome.setText(null);
        txtCurso.setText(null);
        txtTipo.setText(null);
        txtValorExtra.setText(null);
        txtNota.setText(null);
    }

    private Inscricao buscarInscricaoPorMatricula(int matricula){
        for(Inscricao i : inscricoes){
            if(i.getMatricula() == matricula){
                return i;
            }
        }
        return null;
    }

    private void execCadastrar(){
        try {
            if(inscricoes.size() >= LIMITE_VAGAS){
                throw new LimiteVagasAtingidoException();
            }

            int matricula = Integer.parseInt(txtMatricula.getText().trim());
            String nome = txtNome.getText().trim();
            String curso = txtCurso.getText().trim();
            int tipo = Integer.parseInt(txtTipo.getText().trim());
            double valorExtra = Double.parseDouble(txtValorExtra.getText().trim());

            if(nome.isEmpty() || curso.isEmpty()){
                throw new IllegalArgumentException("Nome do aluno e curso são obrigatórios.");
            }

            if(buscarInscricaoPorMatricula(matricula) != null){
                throw new IllegalArgumentException("Já existe um aluno com a matrícula " + matricula + ".");
            }

            Inscricao inscricao;
            if(tipo == 1){
                inscricao = new InscricaoRegular(matricula, nome, curso, valorExtra);
            }else if(tipo == 2){
                inscricao = new InscricaoBolsa(matricula, nome, curso, valorExtra);
            }else{
                throw new IllegalArgumentException("Tipo inválido! Digite 1 para Regular ou 2 para Bolsa.");
            }

            inscricoes.add(inscricao);
            txtMsg.setText("Matrícula realizada com sucesso! Vagas ocupadas: " + inscricoes.size() + "/" + LIMITE_VAGAS + "\n\n");
            txtMsg.append(inscricao.toString());
            limparCampos();

        } catch (LimiteVagasAtingidoException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Turma Lotada", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Verifique os campos numéricos (Matrícula, Tipo e Mensalidade/Desconto).", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Dados Inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void execPesquisar(){
        try {
            int matricula = Integer.parseInt(txtMatricula.getText().trim());
            Inscricao inscricao = buscarInscricaoPorMatricula(matricula);

            if(inscricao == null){
                JOptionPane.showMessageDialog(null, "Matrícula não encontrada.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            txtNome.setText(inscricao.getNomeAluno());
            txtCurso.setText(inscricao.getCurso());
            txtNota.setText(Double.toString(inscricao.getNotaFinal()));
            txtMsg.setText("--- DADOS DO INSCRITO ---\n" + inscricao.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um número de matrícula válido para pesquisar.", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void execLancarNota(){
        try {
            int matricula = Integer.parseInt(txtMatricula.getText().trim());
            double nota = Double.parseDouble(txtNota.getText().trim());
            Inscricao inscricao = buscarInscricaoPorMatricula(matricula);

            if(inscricao == null){
                JOptionPane.showMessageDialog(null, "Matrícula não encontrada.", "Lançar Nota", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if(inscricao.lancarNota(nota)){
                Certificavel cert = inscricao;
                txtMsg.setText("Nota atualizada com sucesso!\n\n");
                txtMsg.append(cert.gerarCertificadoConclusao());
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(null, "A nota deve estar entre 0.0 e 10.0.", "Nota Inválida", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe valores numéricos válidos para Matrícula e Nota.", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void execOrdenar(){
        if(inscricoes.isEmpty()){
            txtMsg.setText("Nenhum aluno matriculado até o momento.\n");
            return;
        }

        Collections.sort(inscricoes);
        txtMsg.setText("=== RELATÓRIO DE INSCRITOS (ORDENADO POR MATRÍCULA) ===\n\n");
        for(Inscricao i : inscricoes){
            txtMsg.append(i.toString());
            txtMsg.append("--------------------------------------------------\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cmdSair){
            JOptionPane.showMessageDialog(null, "Finalizado o Programa", "Fim", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if(e.getSource() == cmdCadastrar){
            execCadastrar();
        }
        if(e.getSource() == cmdPesquisar){
            execPesquisar();
        }
        if(e.getSource() == cmdLancarNota){
            execLancarNota();
        }
        if(e.getSource() == cmdOrdenar){
            execOrdenar();
        }
    }

    @Override
    public void windowOpened(WindowEvent e){}

    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowIconified(WindowEvent e){}

    @Override
    public void windowDeiconified(WindowEvent e){}

    @Override
    public void windowActivated(WindowEvent e){}

    @Override
    public void windowDeactivated(WindowEvent e){}
}