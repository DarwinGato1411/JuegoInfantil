/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Juego;
import com.ec.servicio.ServicioJuego;
import com.ec.servicio.ServicioPuntaje;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author gato
 */
public class Administrar {

    //servicios
    ServicioJuego servicioJuego = new ServicioJuego();
    ServicioPuntaje servicioPuntaje = new ServicioPuntaje();
    //variables y entidades
    private List<Juego> listaJuegoColor = new ArrayList<Juego>();
    private List<Juego> listaJuegoFamilia = new ArrayList<Juego>();
    private List<Juego> listaJuegoAmbiente = new ArrayList<Juego>();
    private String jueTipoJuego = "";

    private Juego juego = new Juego();

    public Administrar() {
        juegoFindAllColor();
        juegoFindAllFamilia();
        juegoFindAllAmbiente();

    }

    private void juegoFindAllColor() {
        jueTipoJuego = "COLOR";
        listaJuegoColor = servicioJuego.findByJueTipoJuego(jueTipoJuego);
    }

    private void juegoFindAllFamilia() {
        jueTipoJuego = "FAMILIA";
        listaJuegoFamilia = servicioJuego.findByJueTipoJuego(jueTipoJuego);
    }

    private void juegoFindAllAmbiente() {
        jueTipoJuego = "AMBIENTE";
        listaJuegoAmbiente = servicioJuego.findByJueTipoJuego(jueTipoJuego);
    }

    private String filePath = "C:\\xampp\\htdocs\\img\\";
    byte[] buffer = new byte[1024 * 1024];

    @Command
    @NotifyChange({"listaJuegoColor", "listaJuegoFamilia", "listaJuegoAmbiente", "juego"})
    public void subirArchivo() throws InterruptedException, IOException {
        if (juego.getJuegoNombre() != null && juego.getJueTipoJuego() != null) {
            org.zkoss.util.media.Media media = Fileupload.get();
            if (media instanceof org.zkoss.image.Image) {
//                if (media.getByteData().length > 300 * 1024) {
//                    Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 300KB.\n Por favor seleccione un archivo más pequeño.");
//                    return;
//                }
                File baseDir = new File(filePath);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePath + media.getName()),
                        media.getStreamData());

                juego.setJueImagen(filePath + media.getName());
                servicioJuego.crear(juego);
                juego = new Juego();
                juegoFindAllColor();
                juegoFindAllFamilia();
                juegoFindAllAmbiente();
                Messagebox.show("Registrado con correctamento.");
            } else {
                Messagebox.show("El arhivo seleccionado no es una imagen.\n Selecione un archivo con extensión .jpg, png o gif.");
            }
        } else {
            Messagebox.show("Verifique la informacion a registrar");
        }

    }

    @Command
    @NotifyChange({"listaJuegoColor", "listaJuegoFamilia", "listaJuegoAmbiente"})
    public void eliminar(@BindingParam("valor") Juego valor) {
        try {
            servicioJuego.eliminar(valor);
            juegoFindAllColor();
            juegoFindAllFamilia();
            juegoFindAllAmbiente();
            Clients.showNotification("Eliminado exitosa",
                    "Info", null, "end_center", 1000, true);
        } catch (Exception e) {

            Messagebox.show("Ocurrio un error al eliminar", "Atención", Messagebox.OK, Messagebox.ERROR);
        }

    }

    public List<Juego> getListaJuegoColor() {
        return listaJuegoColor;
    }

    public void setListaJuegoColor(List<Juego> listaJuegoColor) {
        this.listaJuegoColor = listaJuegoColor;
    }

    public List<Juego> getListaJuegoFamilia() {
        return listaJuegoFamilia;
    }

    public void setListaJuegoFamilia(List<Juego> listaJuegoFamilia) {
        this.listaJuegoFamilia = listaJuegoFamilia;
    }

    public List<Juego> getListaJuegoAmbiente() {
        return listaJuegoAmbiente;
    }

    public void setListaJuegoAmbiente(List<Juego> listaJuegoAmbiente) {
        this.listaJuegoAmbiente = listaJuegoAmbiente;
    }

    public String getJueTipoJuego() {
        return jueTipoJuego;
    }

    public void setJueTipoJuego(String jueTipoJuego) {
        this.jueTipoJuego = jueTipoJuego;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

}
