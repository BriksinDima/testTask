package com.java.managedbeans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * Represents parent bean class with common methods
 */
public class BasicBean {
    /**
     * Method which  reload a web-page
     */
    public void reload(){
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
