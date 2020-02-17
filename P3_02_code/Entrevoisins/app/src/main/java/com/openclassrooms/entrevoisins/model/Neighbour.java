package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Address */
    private String address;

    /** phone number */
    private String phoneNumber;

    /** Facebook */
    private String profilFacebook;

    /** About */
    private String about;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param address
     * @param phoneNumber
     * @param profilFacebook
     * @param about
     */

    public Neighbour(Integer id, String name, String avatarUrl, String address, String phoneNumber, String profilFacebook, String about) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.profilFacebook = profilFacebook;
        this.about = about;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfilFacebook() {
        return profilFacebook;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public boolean equals(Object o) {

        if(o != null && (o.getClass().equals(this.getClass()))){
            Neighbour neighbourToCompare = (Neighbour) o;
            if(neighbourToCompare.getId().equals(this.getId()) &&
                    neighbourToCompare.getName().equals(this.getName()) &&
                    neighbourToCompare.getAbout().equals(this.getAbout()) &&
                    neighbourToCompare.getAddress().equals(this.getAddress()) &&
                    neighbourToCompare.getAvatarUrl().equals(this.getAvatarUrl()) &&
                    neighbourToCompare.getPhoneNumber().equals(this.getPhoneNumber()) &&
                    neighbourToCompare.getProfilFacebook().equals(this.getProfilFacebook())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
