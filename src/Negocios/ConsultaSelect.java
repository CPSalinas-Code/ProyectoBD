/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author Christian
 */
public class ConsultaSelect {
    public String campos;
    public String nombreTabla;
    public String where;
    public String order;

    public ConsultaSelect() {
    }

    public ConsultaSelect(String campos, String nombreTabla, String where, String order) {
        this.campos = campos;
        this.nombreTabla = nombreTabla;
        this.where = where;
        this.order = order;
    }

    public String getCampos() {
        return campos;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public String getWhere() {
        return where;
    }

    public String getOrder() {
        return order;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setOrder(String order) {
        this.order = order;
    }
            
      
    
}
