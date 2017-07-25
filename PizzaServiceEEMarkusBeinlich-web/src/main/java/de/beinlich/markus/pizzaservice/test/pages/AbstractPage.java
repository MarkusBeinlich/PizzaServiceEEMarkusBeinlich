/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.Locale;
import java.util.ResourceBundle;
import static junit.framework.Assert.assertEquals;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Markus
 */
public abstract class AbstractPage {
    @Drone
    private WebDriver browser;
    
    @FindBy(xpath = "//h1")
    private WebElement title;
    
    private String getString(String key){
        return ResourceBundle.getBundle("messages", Locale.GERMANY).getString(key);
    }
    
    protected void assertTitle(String key) {
        assertEquals(getString(key), title.getText());
    }
}
