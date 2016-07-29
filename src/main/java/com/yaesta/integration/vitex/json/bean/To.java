
package com.yaesta.integration.vitex.json.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "conversationRelatedTo",
    "conversationSubject",
    "emailAlias",
    "aliasMaskType",
    "email",
    "name",
    "role"
})
public class To {

    @JsonProperty("conversationRelatedTo")
    private String conversationRelatedTo;
    @JsonProperty("conversationSubject")
    private String conversationSubject;
    @JsonProperty("emailAlias")
    private String emailAlias;
    @JsonProperty("aliasMaskType")
    private Integer aliasMaskType;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The conversationRelatedTo
     */
    @JsonProperty("conversationRelatedTo")
    public String getConversationRelatedTo() {
        return conversationRelatedTo;
    }

    /**
     * 
     * @param conversationRelatedTo
     *     The conversationRelatedTo
     */
    @JsonProperty("conversationRelatedTo")
    public void setConversationRelatedTo(String conversationRelatedTo) {
        this.conversationRelatedTo = conversationRelatedTo;
    }

    /**
     * 
     * @return
     *     The conversationSubject
     */
    @JsonProperty("conversationSubject")
    public String getConversationSubject() {
        return conversationSubject;
    }

    /**
     * 
     * @param conversationSubject
     *     The conversationSubject
     */
    @JsonProperty("conversationSubject")
    public void setConversationSubject(String conversationSubject) {
        this.conversationSubject = conversationSubject;
    }

    /**
     * 
     * @return
     *     The emailAlias
     */
    @JsonProperty("emailAlias")
    public String getEmailAlias() {
        return emailAlias;
    }

    /**
     * 
     * @param emailAlias
     *     The emailAlias
     */
    @JsonProperty("emailAlias")
    public void setEmailAlias(String emailAlias) {
        this.emailAlias = emailAlias;
    }

    /**
     * 
     * @return
     *     The aliasMaskType
     */
    @JsonProperty("aliasMaskType")
    public Integer getAliasMaskType() {
        return aliasMaskType;
    }

    /**
     * 
     * @param aliasMaskType
     *     The aliasMaskType
     */
    @JsonProperty("aliasMaskType")
    public void setAliasMaskType(Integer aliasMaskType) {
        this.aliasMaskType = aliasMaskType;
    }

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

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
     *     The role
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * 
     * @param role
     *     The role
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
