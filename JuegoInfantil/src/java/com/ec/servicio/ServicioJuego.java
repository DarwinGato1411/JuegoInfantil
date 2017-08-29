/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Juego;
import com.ec.entidad.Juego;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioJuego {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Juego juego) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(juego);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar juego");
        } finally {
            em.close();
        }

    }

    public void eliminar(Juego juego) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(juego));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  juego" + e);
        } finally {
            em.close();
        }

    }

    public void modificar(Juego juego) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(juego);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar juego");
        } finally {
            em.close();
        }

    }

    public List<Juego> findAll() {

        List<Juego> listaJuego = new ArrayList<Juego>();
//        Juego juegoObtenido = new Juego();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Juego.findAll", Juego.class);
//            query.setParameter("usuLogin", nombre);
            listaJuego = (List<Juego>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta juego    " + e);
        } finally {
            em.close();
        }

        return listaJuego;
    }
    public List<Juego> findByJueTipoJuego(String jueTipoJuego) {

        List<Juego> listaJuego = new ArrayList<Juego>();
//        Juego juegoObtenido = new Juego();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Juego.findByJueTipoJuego", Juego.class);
            query.setParameter("jueTipoJuego", jueTipoJuego);
            listaJuego = (List<Juego>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta jueTipoJuego    " + e);
        } finally {
            em.close();
        }

        return listaJuego;
    }

}
