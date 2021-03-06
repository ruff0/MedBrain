package com.medbrain.fuzzy.medbrain;

/**
 * Clase Contact que guarda toda la informacion relevante a un contacto
 * @author Yonan Cano
 */
public class Contact {
    private int ID;
    private String name;
    private String phone1;
    private String phone2;
    private String email;
    private String especialidad;
    public int userID;


    /**
     * Constructor de Contacto
     * @param name nombre del contacto
     */
    public Contact(String name){ this.name = name;}

    /**
     * Constructor alternativo incializacion vacia, se costruye el contatcto por medio de sets
     */
    public Contact(){}

    /**
     * Especifica el ID del contacto
     * @param id por especificar
     */
    public void setID(int id) {
        ID = id;
    }

    /**
     * Especifica el nombre del contacto
     * @param name nombre por especificar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el nombre del contacto
     * @return String nombre del contacto
     */
    public String getName(){
        return name;
    }

    /**
     * Especifica el telefono del contacto
     * @param phone1 numero de telefono del contacto
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * Obtiene el numero de telefono del contacto
     * @return numero de telefono del contacto
     */
    public String getPhone1(){
        return phone1;
    }

    /**
     * Especifica el telefono del contacto
     * @param phone2 numero de telefono del contacto
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * Obtiene el numero de telefono del contacto
     * @return numero de telefono del contacto
     */
    public String getPhone2(){
        return phone2;
    }

    /**
     * Especifica el email del contacto
     * @param email email del contacto
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el email del contacto
     * @return el email del contacto
     */
    public String getEmail(){
        return email;
    }

    /**
     * Especifica la especialidad del contacto
     * @param esp String especialidad del contacto
     */
    public void setEspecialidad(String esp) {
        this.especialidad = esp;
    }

    /**
     * Obtiene la especialidad del contacto
     * @return la especialidad del contacto
     */
    public String getEspecialidad(){
        return especialidad;
    }

    /**
     * Especifica el ID del usuario dueño de los contactos
     * @param id del usuario
     */
    public void setUserID(int id){
        userID = id;
    }
}