package model;

public class InscricaoBolsa extends Inscricao {
    private double percentualDesconto;

    public double getPercentualDesconto(){
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto){
        this.percentualDesconto = percentualDesconto;
    }

    public InscricaoBolsa(int matricula, String nomeAluno, String curso, double percentualDesconto){
        super(matricula, nomeAluno, curso);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public String gerarCertificadoConclusao(){
        if(isConcluido()){
            return "=== CERTIFICADO DE CONCLUSÃO (BOLSISTA) ===\n" +
                    "Certificamos que " + getNomeAluno() + " (Matrícula: " + getMatricula() + ")\n" +
                    "concluiu o curso " + getCurso() + " como bolsista (" + percentualDesconto + "%) com nota " + getNotaFinal() + ".\n";
        }
        return "Aluno bolsista " + getNomeAluno() + " ainda não atingiu a nota mínima (6.0) para certificação.\n";
    }

    @Override
    public String toString(){
        return super.toString() +
                "Modalidade: Bolsista | Desconto: " + percentualDesconto + "%\n";
    }
}