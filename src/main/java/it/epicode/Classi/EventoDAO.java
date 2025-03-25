package it.epicode.Classi;

import jakarta.persistence.EntityManager;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        System.out.println("Evento salvato correttamente");
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
        System.out.println("Evento eliminato correttamente");
    }
}
