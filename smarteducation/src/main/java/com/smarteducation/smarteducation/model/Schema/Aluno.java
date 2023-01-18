package com.smarteducation.smarteducation.model.Schema;

public class Aluno extends Usuario {
    private String curso;
    private int semestre;

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public Aluno(String curso, int semestre) {
        this.curso = curso;
        this.semestre = semestre;
    }
    public Aluno(String nome, long matricula, String cpf, String email, String senha, String dataNascimento,
            String curso, int semestre) {
        super(nome, matricula, cpf, email, senha, dataNascimento);
        this.curso = curso;
        this.semestre = semestre;
    }
    public Aluno(String id, String nome, long matricula, String cpf, String email, String senha, String dataNascimento,
            String curso, int semestre) {
        super(id, nome, matricula, cpf, email, senha, dataNascimento);
        this.curso = curso;
        this.semestre = semestre;
    }

    
    
    
}
