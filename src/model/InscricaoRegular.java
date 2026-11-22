package model;

public class InscricaoRegular extends Inscricao {
    private double valorMensalidade;

    public double getValorMensalidade(){
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade){
        this.valorMensalidade = valorMensalidade;
    }

    public InscricaoRegular(int matricula, String nomeAluno, String curso, double valorMensalidade){
        super(matricula, nomeAluno, curso);
        this.valorMensalidade = valorMensalidade;
    }

    @Override
    public String gerarCertificadoConclusao(){
        if(isConcluido()){
            return "=== CERTIFICADO DE CONCLUSÃO (REGULAR) ===\n" +
                    "Certificamos que " + getNomeAluno() + " (Matrícula: " + getMatricula() + ")\n" +
                    "concluiu o curso " + getCurso() + " com nota final " + getNotaFinal() + ".\n";
        }
        return "Aluno " + getNomeAluno() + " ainda não atingiu a nota mínima (6.0) para certificação.\n";
    }

    @Override
    public String toString(){
        return super.toString() +
                "Modalidade: Regular | Mensalidade R$ " + valorMensalidade + "\n";
    }
}