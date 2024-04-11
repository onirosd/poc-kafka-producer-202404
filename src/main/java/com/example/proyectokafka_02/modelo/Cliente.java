package com.example.proyectokafka_02.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Date;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "Clientes") 
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private int edad;
    private String sexo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_insercion")
    private Date fechaInsercion;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    public Cliente() {
    }

    public Cliente(String id, String nombre, String apellidop, String apellidom, int edad, String sexo, Date fechaInsercion, Date fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaInsercion = fechaInsercion;
        this.fechaModificacion = fechaModificacion;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return this.apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return this.apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaInsercion() {
        return this.fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Cliente id(String id) {
        setId(id);
        return this;
    }

    public Cliente nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Cliente apellidop(String apellidop) {
        setApellidop(apellidop);
        return this;
    }

    public Cliente apellidom(String apellidom) {
        setApellidom(apellidom);
        return this;
    }

    public Cliente edad(int edad) {
        setEdad(edad);
        return this;
    }

    public Cliente sexo(String sexo) {
        setSexo(sexo);
        return this;
    }

    public Cliente fechaInsercion(Date fechaInsercion) {
        setFechaInsercion(fechaInsercion);
        return this;
    }

    public Cliente fechaModificacion(Date fechaModificacion) {
        setFechaModificacion(fechaModificacion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellidop, cliente.apellidop) && Objects.equals(apellidom, cliente.apellidom) && edad == cliente.edad && Objects.equals(sexo, cliente.sexo) && Objects.equals(fechaInsercion, cliente.fechaInsercion) && Objects.equals(fechaModificacion, cliente.fechaModificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidop, apellidom, edad, sexo, fechaInsercion, fechaModificacion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidop='" + getApellidop() + "'" +
            ", apellidom='" + getApellidom() + "'" +
            ", edad='" + getEdad() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", fechaInsercion='" + getFechaInsercion() + "'" +
            ", fechaModificacion='" + getFechaModificacion() + "'" +
            "}";
    }


    // Método para convertir el objeto a JSON
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    
}
