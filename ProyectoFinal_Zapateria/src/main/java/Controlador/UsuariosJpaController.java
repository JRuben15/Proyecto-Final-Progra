/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Modelo.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author
 */
public class UsuariosJpaController implements Serializable {
    private EntityManagerFactory emf = null;

    public UsuariosJpaController( ) {
        this.emf = Persistence.createEntityManagerFactory("PersistenciaUsuarios");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String create(Usuarios usuarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarios);
            em.getTransaction().commit();
            return "Usuario agregado correctamente!";
        } catch (Exception ex) {
            if (findUsuarios(usuarios.getUsuario()) != null) {
                 return "El usuario " + usuarios + " ya existe";
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }//Fin CREATE
    
    public String edit(Usuarios usuarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarios = em.merge(usuarios);
            em.getTransaction().commit();
            return "El usuario fue modificado correctamente";
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuarios.getUsuario();
                if (findUsuarios(usuarios.getUsuario()) == null) {
                    return "No se puede modifcar, no se encontró ese Usuario";
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }//Fin EDIT
    
    public String destroy(String usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, usuario);
                usuarios.getUsuario();
            } catch (EntityNotFoundException enfe) {
                return "No se pudo eliminar ese Usuario.";
            }
            em.remove(usuarios);
            em.getTransaction().commit();
            return "El Usuario se ha eliminado correctamente";
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }//Fin DESTROY
    
     private ArrayList<Usuarios> devolverLista() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
            Query q = em.createQuery(cq);
            return (ArrayList<Usuarios>) q.getResultList();
        } finally {
            em.close();
        }
    }//Fin ARRAYLIst

    public Usuarios findUsuarios(String usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, usuario);
        } finally {
            em.close();
        }
    }
}//Fin CLASS
