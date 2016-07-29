
package com.yaesta.integration.vitex.json.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "from",
    "to",
    "subject",
    "firstWords",
    "body",
    "hasAttachment",
    "attachmentNames",
    "date",
    "customerEmail"
})
public class OrderConversation {

    @JsonProperty("id")
    private String id;
    @JsonProperty("from")
    private From from;
    @JsonProperty("to")
    private List<To> to = new ArrayList<To>();
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("firstWords")
    private String firstWords;
    @JsonProperty("body")
    private String body;
    @JsonProperty("hasAttachment")
    private Boolean hasAttachment;
    @JsonProperty("attachmentNames")
    private List<Object> attachmentNames = new ArrayList<Object>();
    @JsonProperty("date")
    private String date;
    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public OrderConversation(){}
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
     *     The from
     */
    @JsonProperty("from")
    public From getFrom() {
        return from;
    }

    /**
     * 
     * @param from
     *     The from
     */
    @JsonProperty("from")
    public void setFrom(From from) {
        this.from = from;
    }

    /**
     * 
     * @return
     *     The to
     */
    @JsonProperty("to")
    public List<To> getTo() {
        return to;
    }

    /**
     * 
     * @param to
     *     The to
     */
    @JsonProperty("to")
    public void setTo(List<To> to) {
        this.to = to;
    }

    /**
     * 
     * @return
     *     The subject
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 
     * @return
     *     The firstWords
     */
    @JsonProperty("firstWords")
    public String getFirstWords() {
        return firstWords;
    }

    /**
     * 
     * @param firstWords
     *     The firstWords
     */
    @JsonProperty("firstWords")
    public void setFirstWords(String firstWords) {
        this.firstWords = firstWords;
    }

    /**
     * 
     * @return
     *     The body
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The hasAttachment
     */
    @JsonProperty("hasAttachment")
    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    /**
     * 
     * @param hasAttachment
     *     The hasAttachment
     */
    @JsonProperty("hasAttachment")
    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    /**
     * 
     * @return
     *     The attachmentNames
     */
    @JsonProperty("attachmentNames")
    public List<Object> getAttachmentNames() {
        return attachmentNames;
    }

    /**
     * 
     * @param attachmentNames
     *     The attachmentNames
     */
    @JsonProperty("attachmentNames")
    public void setAttachmentNames(List<Object> attachmentNames) {
        this.attachmentNames = attachmentNames;
    }

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
    
    
    @JsonProperty("customerEmail")
    public String getCustomerEmail() {
		return customerEmail;
	}

    @JsonProperty("customerEmail")
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
