/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.OrderHeader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Markus Beinlich
 */
@Stateless(mappedName = "ejb/orderEjb")
public class OrderEjb implements OrderEjbRemote {

    @PersistenceUnit(unitName = "pizzajpa")
    private EntityManagerFactory emf;

    @Resource
    private UserTransaction ut;

    @Override
    public void saveOrder(OrderHeader order) {
        try {
            ut.begin();
            EntityManager em
                    = emf.createEntityManager();
            em.persist(order.getCustomer());
            em.persist(order);
            ut.commit();
        } catch (NotSupportedException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(OrderEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OrderHeader> getAllOrderHeader() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<OrderHeader> query = em.createNamedQuery(OrderHeader.findAll, OrderHeader.class);
        List<OrderHeader> orders = query.getResultList();
        System.out.println("getAllOrderHeader1:" + orders.size() + "-" + orders.hashCode() + "-" + orders.get(0).getOrderEntries().toString());
        return orders;

    }
}
