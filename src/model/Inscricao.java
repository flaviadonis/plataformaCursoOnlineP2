package model;

import interfaces.Certificavel;
import java.time.LocalDate;

public abstract class Inscricao implements Comparable<Inscricao>, Certificavel {
    private int matricula;
    private String nomeAluno;
    private String curso;
    private LocalDate dataMatricula;
    private double notaFinal;
    private boolean concluido;

    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public String getNomeAluno(){
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno){
        this.nomeAluno = nomeAluno;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public LocalDate getDataMatricula(){
        return dataMatricula;
    }

    public double getNotaFinal(){
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal){
        this.notaFinal = notaFinal;
    }

    public boolean isConcluido(){
        return concluido;
    }

    public void setConcluido(boolean concluido){
        this.concluido = concluido;
    }

    public Inscricao(int matricula, String nomeAluno, String curso){
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.curso = curso;
        this.dataMatricula = LocalDate.now();
        this.notaFinal = 0.0;
        this.concluido = false;
    }

    public boolean lancarNota(double nota){
        if(nota >= 0.0 && nota <= 10.0){
            this.notaFinal = nota;
            if(Aprovado(nota)){
                this.concluido = true;
            }else{
                this.concluido = false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Inscricao o){
        if(this.matricula < o.matricula){
            return -1;
        }
        if(this.matricula > o.matricula){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o instanceof Inscricao){
            Inscricao i = (Inscricao) o;
            return this.matricula == i.matricula;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(matricula);
    }

    @Override
    public String toString(){
        return "Matrícula: " + matricula + "\n" +
                "Aluno: " + nomeAluno + "\n" +
                "Curso: " + curso + "\n" +
                "Data Matrícula: " + dataMatricula + "\n" +
                "Nota Final: " + notaFinal + "\n" +
                "Status: " + (concluido ? "Concluído" : "Em andamento") + "\n";
    }
}