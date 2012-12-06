//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.03 at 04:44:41 PM MEZ 
//


package de.leonhardt.sbm.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.leonhardt.sbm.xml.NullLongAdapter;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="address" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="body" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="contact_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="date_sent" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="locked" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="protocol" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="read" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="readable_date" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="sc_toa" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="service_center" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="subject" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="toa" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "sms")
public class Sms {

	/**
	 * Internal id of message, not part of XML
	 */
	@XmlTransient
	protected long id;
	
	/**
	 * The contact associated to this message
	 */
	@XmlTransient
	protected Contact contact;
	
	/**
	 * The phone number of the sender/recipient.
	 */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String address;
    
    /**
     * The content of the message.
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "string")
    protected String body;
    
    /**
     * Optional field that has the name of the contact.
     */
    @XmlAttribute(name = "contact_name", required = true)
    @XmlSchemaType(name = "string")
    protected String contactName;
    
    /**
     * The Java date representation (including millisecond) of the time when the message was sent/received.
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "integer")
    @XmlJavaTypeAdapter(NullLongAdapter.class)
    protected Long date;
    
    @XmlAttribute(name = "date_sent", required = true)
    @XmlSchemaType(name = "integer")
    @XmlJavaTypeAdapter(NullLongAdapter.class)
    protected Long dateSent;
    
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "integer")
    protected Integer locked;
    
    /**
     * Protocol used by the message, its mostly 0 in case of SMS messages.
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "integer")
    protected Integer protocol;
    
    /**
     * Read Message = 1, Unread Message = 0.
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "integer")
    protected Integer read;
    
    /**
     * Optional field that has the date in a human readable format.
     */
    @XmlAttribute(name = "readable_date", required = true)
    @XmlSchemaType(name = "string")
    protected String readableDate;
    
    /**
     * n/a, default to null.
     */
    @XmlAttribute(name = "sc_toa", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String scToa;
    
    /**
     * The service center for the received message, null in case of sent messages.
     */
    @XmlAttribute(name = "service_center", required = true)
    @XmlSchemaType(name = "string")
    protected String serviceCenter;
    
    /**
     * None = -1, Complete = 0, Pending = 32, Failed = 64.
     */
    @XmlAttribute(required = true)
    protected Integer status;
    
    /**
     *  Subject of the message, its always null in case of SMS messages.
     */
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String subject;
    
    /**
     *  n/a, default to null.
     */
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String toa;
    
    /**
     * 1 = Received, 2 = Sent, 3 = Draft, 4 = Outbox, 5 = Failed, 6 = Queued
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "integer")
    protected Integer type;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Long getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDate(Long value) {
        this.date = value;
    }

    /**
     * Gets the value of the dateSent property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Long getDateSent() {
        return dateSent;
    }

    /**
     * Sets the value of the dateSent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDateSent(Long value) {
        this.dateSent = value;
    }

    /**
     * Gets the value of the locked property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLocked(Integer value) {
        this.locked = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProtocol(Integer value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the read property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRead() {
        return read;
    }

    /**
     * Sets the value of the read property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRead(Integer value) {
        this.read = value;
    }

    /**
     * Gets the value of the readableDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadableDate() {
        return readableDate;
    }

    /**
     * Sets the value of the readableDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadableDate(String value) {
        this.readableDate = value;
    }

    /**
     * Gets the value of the scToa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScToa() {
        return scToa;
    }

    /**
     * Sets the value of the scToa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScToa(String value) {
        this.scToa = value;
    }

    /**
     * Gets the value of the serviceCenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCenter() {
        return serviceCenter;
    }

    /**
     * Sets the value of the serviceCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCenter(String value) {
        this.serviceCenter = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the toa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToa() {
        return toa;
    }

    /**
     * Sets the value of the toa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToa(String value) {
        this.toa = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }
    
    public long getId() {
    	return this.id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
//    public Contact getContact() {
//    	return this.contact;
//    }
//    
//    public void setContact(Contact contact) {
//    	this.contact = contact;
//    }
    

	@Override
	public String toString() {
		return "Sms [id=" + id + ", address=" + address + ", body=" + body + ", contactName="
				+ contactName + ", date=" + date + ", dateSent=" + dateSent
				+ ", locked=" + locked + ", protocol=" + protocol + ", read="
				+ read + ", readableDate=" + readableDate + ", scToa=" + scToa
				+ ", serviceCenter=" + serviceCenter + ", status=" + status
				+ ", subject=" + subject + ", toa=" + toa + ", type=" + type
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/**
	 * To determine the equality, we only compare
	 * - address
	 * - body
	 * - date
	 * - protocol
	 * - read
	 * - status
	 * - subject
	 * - type
	 * 
	 * Other attributes are not relevant, or might even differ for equal objects, e.g.:
	 * - date_sent can be "0" or "null"
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sms other = (Sms) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
