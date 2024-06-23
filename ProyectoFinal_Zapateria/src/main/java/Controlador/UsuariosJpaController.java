/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
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
 * @author Rubén Delgado C
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
            return "Usuario agregado!";
        } catch (Exception ex) {
            if (findUsuarios(usuarios.getId()) != null) {
                return "El usuario " + usuarios + " ya existe";
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public String edit(Usuarios usuarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarios = em.merge(usuarios);
            em.getTransaction().commit();
            return "Usuario modificado correctamente";
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getId();
                if (findUsuarios(id) == null) {
                    return "No se pudo modificar el usuario" +usuarios.getUsuario();
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public String destroy(Integer id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getId();
            } catch (EntityNotFoundException enfe) {
                return "No se puede eliminar el usuario.";
            }
            em.remove(usuarios);
            em.getTransaction().commit();
            return "Usuario eliminado correctamente";
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
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
    }
     
    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }
}//Fin CLASS
