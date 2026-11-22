package exceptions;

public class LimiteVagasAtingidoException extends Exception {
    @Override
    public String toString(){
        return "Limite máximo de vagas da turma atingido!";
    }

    @Override
    public String getMessage(){
        return "Limite máximo de vagas da turma atingido!";
    }
}