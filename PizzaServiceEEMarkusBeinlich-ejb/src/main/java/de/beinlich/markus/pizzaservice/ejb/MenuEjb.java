/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.Menu;
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
@Stateless(mappedName = "ejb/menuEjb")
public class MenuEjb implements MenuEjbRemote {

    @PersistenceUnit(unitName = "pizzajpa")
    private EntityManagerFactory emf;

    @Resource
    private UserTransaction ut;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Menu getMenu(Menu menu) {
        if (menu.getMenuItems().isEmpty()) {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Menu> query = em.createNamedQuery(Menu.findAll, Menu.class);
            List<Menu> menus = query.getResultList();
            System.out.println("getMenu1:" + menus.size() + "-" + menu.hashCode() + "-" + menus.get(0).getMenuItems().toString());
            menu = menus.get(0);
            return menu;
        }
        System.out.println("getMenu2:" + menu.toString());
        return menu;
    }

    @Override
    public void addMenu(Menu menu) {
        try {
            ut.begin();
            EntityManager em = emf.createEntityManager();
            em.persist(menu);
            ut.commit();
        } catch (NotSupportedException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(MenuEjb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}