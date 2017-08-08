/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.Customer;
import javax.ejb.Remote;

/**
 *
 * @author Markus Beinlich
 */
@Remote
public interface CustomerEjbRemote {

    public Customer getCustomerByEmail(String email);

    public void addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);
}
