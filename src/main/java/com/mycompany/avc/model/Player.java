package com.mycompany.avc.model;

public class Player {

   private int id;

   private String nome;

   private int skillPoints;

   private int metaVida;
   private int metaDano;
   private int metaSorte;

   // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getMetaVida() {
        return metaVida;
    }

    public void setMetaVida(int metaVida) {
        this.metaVida = metaVida;
    }

    public int getMetaDano() {
        return metaDano;
    }

    public void setMetaDano(int metaDano) {
        this.metaDano = metaDano;
    }

    public int getMetaSorte() {
        return metaSorte;
    }

    public void setMetaSorte(int metaSorte) {
        this.metaSorte = metaSorte;
    }

}
