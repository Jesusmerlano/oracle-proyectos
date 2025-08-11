package com.example.crud;

public class User {
    private Integer id;
    private String nombre;
    private String correo;

    public User() {}
    public User(Integer id, String nombre, String correo) {
        this.id = id; this.nombre = nombre; this.correo = correo;
    }
    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    @Override public String toString(){ return String.format("User{id=%s, nombre=%s, correo=%s}", id, nombre, correo);}
}
