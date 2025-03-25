package it.epicode.Main;

import it.epicode.Classi.Evento;
import it.epicode.Classi.EventoDAO;
import it.epicode.Classi.tipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento1 = new Evento("Evento 1", LocalDate.now(), "Descrizione evento 1", tipoEvento.PUBBLICO, 100);
        Evento evento2 = new Evento("Evento 2", LocalDate.now().plusDays(1), "Descrizione evento 2", tipoEvento.PRIVATO, 50);
        Evento evento3 = new Evento("Evento 3", LocalDate.now().plusDays(2), "Descrizione evento 3", tipoEvento.PUBBLICO, 200);
        Evento evento4 = new Evento("Evento 4", LocalDate.now().plusDays(3), "Descrizione evento 4", tipoEvento.PRIVATO, 75);

        eventoDAO.save(evento1);
        eventoDAO.save(evento2);
        eventoDAO.save(evento3);
        eventoDAO.save(evento4);
        eventoDAO.getById(1L);
        eventoDAO.delete(evento1);

        em.close();
        emf.close();


    }
}
