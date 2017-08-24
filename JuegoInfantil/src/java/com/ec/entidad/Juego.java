/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
    @NamedQuery(name = "Juego.findByCodJuego", query = "SELECT j FROM Juego j WHERE j.codJuego = :codJuego"),
    @NamedQuery(name = "Juego.findByJuegoNombre", query = "SELECT j FROM Juego j WHERE j.juegoNombre = :juegoNombre"),
    @NamedQuery(name = "Juego.findByJueImagen", query = "SELECT j FROM Juego j WHERE j.jueImagen = :jueImagen"),
    @NamedQuery(name = "Juego.findByJueTipoJuego", query = "SELECT j FROM Juego j WHERE j.jueTipoJuego = :jueTipoJuego")})
public class Juego implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_juego")
    private Integer codJuego;
    @Size(max = 100)
    @Column(name = "juego_nombre")
    private String juegoNombre;
    @Size(max = 200)
    @Column(name = "jue_imagen")
    private String jueImagen;
    @Size(max = 20)
    @Column(name = "jue_tipo_juego")
    private String jueTipoJuego;
    @OneToMany(mappedBy = "codJuego")
    private Collection<Puntaje> puntajeCollection;

    public Juego() {
    }

    public Juego(Integer codJuego) {
        this.codJuego = codJuego;
    }

    public Integer getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(Integer codJuego) {
        this.codJuego = codJuego;
    }

    public String getJuegoNombre() {
        return juegoNombre;
    }

    public void setJuegoNombre(String juegoNombre) {
        this.juegoNombre = juegoNombre;
    }

    public String getJueImagen() {
        return jueImagen;
    }

    public void setJueImagen(String jueImagen) {
        this.jueImagen = jueImagen;
    }

    public String getJueTipoJuego() {
        return jueTipoJuego;
    }

    public void setJueTipoJuego(String jueTipoJuego) {
        this.jueTipoJuego = jueTipoJuego;
    }

    @XmlTransient
    public Collection<Puntaje> getPuntajeCollection() {
        return puntajeCollection;
    }

    public void setPuntajeCollection(Collection<Puntaje> puntajeCollection) {
        this.puntajeCollection = puntajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codJuego != null ? codJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.codJuego == null && other.codJuego != null) || (this.codJuego != null && !this.codJuego.equals(other.codJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Juego[ codJuego=" + codJuego + " ]";
    }
    
}
