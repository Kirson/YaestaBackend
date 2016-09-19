
package com.yaesta.integration.sellercenter.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "username",
    "perfil",
    "sellerId",
    "email"
})
public class SellerUser {

    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("perfil")
    private String perfil;
    @JsonProperty("sellerId")
    private String sellerId;
    @JsonProperty("email")
    private String email;
    

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The perfil
     */
    @JsonProperty("perfil")
    public String getPerfil() {
        return perfil;
    }

    /**
     * 
     * @param perfil
     *     The perfil
     */
    @JsonProperty("perfil")
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * 
     * @return
     *     The sellerId
     */
    @JsonProperty("sellerId")
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 
     * @param sellerId
     *     The SellerId
     */
    @JsonProperty("sellerId")
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 
     * @return
     *     The eMail
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param eMail
     *     The e-mail
     */
    @JsonProperty("email")
    public void setEMail(String email) {
        this.email = email;
    }

   

}
