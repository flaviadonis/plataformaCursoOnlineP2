package interfaces;

public interface Certificavel {
    String gerarCertificadoConclusao();

    default boolean Aprovado(double notaFinal){
        return notaFinal >= 6.0;
    }
}