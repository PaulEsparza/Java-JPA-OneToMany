/*

*/
package jpa_onetomany;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.Table1;
import model.Table2;

public class JPA_OneToMany {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU"); //Gestor de entidades
    
    public void createData(){
        EntityManager em = emf.createEntityManager(); //Instancia para trabajar con las entidades
        EntityTransaction tx = em.getTransaction(); // Permite hacer transacciones
        
        //tx.begin(); //Abrir la transaccion
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            
            Table1 t1 = new Table1(1, "Example1 T1 C1", "Example1 T1 C2");
            Table1 t2 = new Table1(2, "Example2 T1 C1", "Example2 T1 C2");
            Table1 t3 = new Table1(3, "Example3 T1 C1", "Example3 T1 C2");
            em.persist(t1); // Grabe registro en la base de datos
            em.persist(t2); // Grabe registro en la base de datos
            em.persist(t3); // Grabe registro en la base de datos
            
            em.persist(new Table2(1, "Example1 T2 C1", "Example1 T2 C2", t1));
            em.persist(new Table2(2, "Example2 T2 C1", "Example2 T2 C2", t2));
            em.persist(new Table2(3, "Example3 T2 C1", "Example3 T2 C2", t3));
            em.persist(new Table2(4, "Example4 T2 C1", "Example3 T2 C2", t1));
            em.persist(new Table2(5, "Example5 T2 C1", "Example3 T2 C2", t2));
            em.persist(new Table2(6, "Example6 T2 C1", "Example3 T2 C2", t3));
            
            /*Table2 t21 = new Table2(7, "Example1 T2 C1", "Example1 T2 C2");
            Table2 t22 = new Table2(2, "Example2 T2 C1", "Example2 T2 C2");
            Table2 t23 = new Table2(3, "Example3 T2 C1", "Example3 T2 C2");
            
            t21.setTable1(t1);
            
            em.persist(t21);*/
            
            em.getTransaction().commit(); // Termine la transaccion
            
            JOptionPane.showMessageDialog(null, "Los registros fueron"
                    + " satisfactorios");
            
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(t1); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            System.out.println("ERROR: " + e.toString());
            em.getTransaction().rollback();
            em.close();
            
        }
    }
    
    public void showData(){
        EntityManager em = emf.createEntityManager(); //Instancia para trabajar con las entidades
        try {
            Table1 t1 = em.find(Table1.class, 1);
            //System.out.println(t1);
            
            List<Table2> lt2 = t1.getTable2();
            
            for(Table2 t2 : lt2){
                System.out.println("* " + t2.toString());
            }
            
            
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(t1); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            em.getTransaction().rollback();
            em.close();
            System.out.println("ERROR: " + e.toString());
        }
    }

    public static void main(String[] args) {
        JPA_OneToMany app = new JPA_OneToMany();
        
        app.createData();
        app.showData();
    }
    
    
    
}
