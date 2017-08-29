/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Puntaje;
import com.ec.entidad.Puntaje;
import com.ec.entidad.Puntaje;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioPuntaje {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Puntaje puntaje) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(puntaje);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar puntaje");
        } finally {
            em.close();
        }

    }

    public void eliminar(Puntaje puntaje) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(puntaje));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error en eliminar  puntaje" + e);
        } finally {
            em.close();
        }

    }

    public void modificar(Puntaje puntaje) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(puntaje);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar puntaje");
        } finally {
            em.close();
        }

    }

    public List<Puntaje> findAll() {

        List<Puntaje> listaPuntaje = new ArrayList<Puntaje>();
//        Puntaje puntajeObtenido = new Puntaje();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Puntaje.findAll", Puntaje.class);
//            query.setParameter("usuLogin", nombre);
            listaPuntaje = (List<Puntaje>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta puntaje    " + e);
        } finally {
            em.close();
        }

        return listaPuntaje;
    }

}
