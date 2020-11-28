package com.example.proyectofinalandroid.Dtos;

import java.io.Serializable;

public class Usuario implements Serializable {

int id_usu;
String nombre;
String apellido;
String correo;
String usuario;
String clave;
int tipo;
int estado_us;
String pregunta;
String respuesta;

    public Usuario() {
    }

    public Usuario(int id_usu, String nombre, String apellido, String correo, String usuario, String clave, int tipo, int estado_us, String pregunta, String respuesta) {
        this.id_usu = id_usu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado_us = estado_us;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado_us() {
        return estado_us;
    }

    public void setEstado_us(int estado_us) {
        this.estado_us = estado_us;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
