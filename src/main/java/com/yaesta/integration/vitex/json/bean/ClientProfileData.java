
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
    "id",
    "email",
    "firstName",
    "lastName",
    "documentType",
    "document",
    "phone",
    "corporateName",
    "tradeName",
    "corporateDocument",
    "stateInscription",
    "corporatePhone",
    "isCorporate",
    "userProfileId"
})
public class ClientProfileData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("documentType")
    private String documentType;
    @JsonProperty("document")
    private String document;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("corporateName")
    private Object corporateName;
    @JsonProperty("tradeName")
    private Object tradeName;
    @JsonProperty("corporateDocument")
    private Object corporateDocument;
    @JsonProperty("stateInscription")
    private Object stateInscription;
    @JsonProperty("corporatePhone")
    private Object corporatePhone;
    @JsonProperty("isCorporate")
    private Boolean isCorporate;
    @JsonProperty("userProfileId")
    private String userProfileId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
     *     The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The documentType
     */
    @JsonProperty("documentType")
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 
     * @param documentType
     *     The documentType
     */
    @JsonProperty("documentType")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * 
     * @return
     *     The document
     */
    @JsonProperty("document")
    public String getDocument() {
        return document;
    }

    /**
     * 
     * @param document
     *     The document
     */
    @JsonProperty("document")
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * 
     * @return
     *     The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The corporateName
     */
    @JsonProperty("corporateName")
    public Object getCorporateName() {
        return corporateName;
    }

    /**
     * 
     * @param corporateName
     *     The corporateName
     */
    @JsonProperty("corporateName")
    public void setCorporateName(Object corporateName) {
        this.corporateName = corporateName;
    }

    /**
     * 
     * @return
     *     The tradeName
     */
    @JsonProperty("tradeName")
    public Object getTradeName() {
        return tradeName;
    }

    /**
     * 
     * @param tradeName
     *     The tradeName
     */
    @JsonProperty("tradeName")
    public void setTradeName(Object tradeName) {
        this.tradeName = tradeName;
    }

    /**
     * 
     * @return
     *     The corporateDocument
     */
    @JsonProperty("corporateDocument")
    public Object getCorporateDocument() {
        return corporateDocument;
    }

    /**
     * 
     * @param corporateDocument
     *     The corporateDocument
     */
    @JsonProperty("corporateDocument")
    public void setCorporateDocument(Object corporateDocument) {
        this.corporateDocument = corporateDocument;
    }

    /**
     * 
     * @return
     *     The stateInscription
     */
    @JsonProperty("stateInscription")
    public Object getStateInscription() {
        return stateInscription;
    }

    /**
     * 
     * @param stateInscription
     *     The stateInscription
     */
    @JsonProperty("stateInscription")
    public void setStateInscription(Object stateInscription) {
        this.stateInscription = stateInscription;
    }

    /**
     * 
     * @return
     *     The corporatePhone
     */
    @JsonProperty("corporatePhone")
    public Object getCorporatePhone() {
        return corporatePhone;
    }

    /**
     * 
     * @param corporatePhone
     *     The corporatePhone
     */
    @JsonProperty("corporatePhone")
    public void setCorporatePhone(Object corporatePhone) {
        this.corporatePhone = corporatePhone;
    }

    /**
     * 
     * @return
     *     The isCorporate
     */
    @JsonProperty("isCorporate")
    public Boolean getIsCorporate() {
        return isCorporate;
    }

    /**
     * 
     * @param isCorporate
     *     The isCorporate
     */
    @JsonProperty("isCorporate")
    public void setIsCorporate(Boolean isCorporate) {
        this.isCorporate = isCorporate;
    }

    /**
     * 
     * @return
     *     The userProfileId
     */
    @JsonProperty("userProfileId")
    public String getUserProfileId() {
        return userProfileId;
    }

    /**
     * 
     * @param userProfileId
     *     The userProfileId
     */
    @JsonProperty("userProfileId")
    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
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
