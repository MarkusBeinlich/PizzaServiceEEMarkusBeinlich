/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.OrderHeader;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Markus Beinlich
 */
@Remote
public interface OrderEjbRemote {
    public List<OrderHeader> getAllOrderHeader();
    public void saveOrder(OrderHeader order);
}
