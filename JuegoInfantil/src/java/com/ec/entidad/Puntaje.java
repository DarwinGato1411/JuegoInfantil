/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "puntaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntaje.findAll", query = "SELECT p FROM Puntaje p"),
    @NamedQuery(name = "Puntaje.findByCodPuntaje", query = "SELECT p FROM Puntaje p WHERE p.codPuntaje = :codPuntaje"),
    @NamedQuery(name = "Puntaje.findByJugador", query = "SELECT p FROM Puntaje p WHERE p.jugador = :jugador"),
    @NamedQuery(name = "Puntaje.findByPuntos", query = "SELECT p FROM Puntaje p WHERE p.puntos = :puntos"),
    @NamedQuery(name = "Puntaje.findByPuntosDos", query = "SELECT p FROM Puntaje p WHERE p.puntosDos = :puntosDos")})
public class Puntaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_puntaje")
    private Integer codPuntaje;
    @Size(max = 100)
    @Column(name = "jugador")
    private String jugador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntos")
    private BigDecimal puntos;
    @Column(name = "puntos_dos")
    private BigDecimal puntosDos;
    @JoinColumn(name = "cod_juego", referencedColumnName = "cod_juego")
    @ManyToOne
    private Juego codJuego;

    public Puntaje() {
    }

    public Puntaje(Integer codPuntaje) {
        this.codPuntaje = codPuntaje;
    }

    public Integer getCodPuntaje() {
        return codPuntaje;
    }

    public void setCodPuntaje(Integer codPuntaje) {
        this.codPuntaje = codPuntaje;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public BigDecimal getPuntos() {
        return puntos;
    }

    public void setPuntos(BigDecimal puntos) {
        this.puntos = puntos;
    }

    public BigDecimal getPuntosDos() {
        return puntosDos;
    }

    public void setPuntosDos(BigDecimal puntosDos) {
        this.puntosDos = puntosDos;
    }

    public Juego getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(Juego codJuego) {
        this.codJuego = codJuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPuntaje != null ? codPuntaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntaje)) {
            return false;
        }
        Puntaje other = (Puntaje) object;
        if ((this.codPuntaje == null && other.codPuntaje != null) || (this.codPuntaje != null && !this.codPuntaje.equals(other.codPuntaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Puntaje[ codPuntaje=" + codPuntaje + " ]";
    }
    
}
