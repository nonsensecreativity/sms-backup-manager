//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.01.17 at 02:48:31 PM NZDT
//

package de.leonhardt.sbm.smsbr.xml.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Message collection from SMS backup & Restore</p>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	    "smsOrMms"
	})
@XmlRootElement(name = "smses")
public class Smses {

    @XmlElements({
        @XmlElement(name = "sms", type = Sms.class),
        @XmlElement(name = "mms", type = Mms.class)
    })
    protected List<Message> smsOrMms;

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer count;

    public Smses(Collection<Sms> sms) {
    	this.smsOrMms = new ArrayList<Message>(sms);
    	this.count = sms.size();
    }

    public Smses() {
    	// default constructor
    }

    /**
     * Gets the value of the smsOrMms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sms property.
     * </p>
     */
    public List<Message> getSmsOrMms() {
        if (smsOrMms == null) {
            smsOrMms = new ArrayList<Message>();
        }
        return this.smsOrMms;
    }

    @Deprecated
    public List<Sms> getSms() {
        if (smsOrMms == null) {
            smsOrMms = new ArrayList<Message>();
        }

        return this.smsOrMms
        		.stream()
        		.filter(message -> message instanceof Sms)
        		.map(sms -> (Sms) sms)
        		.collect(Collectors.toList());
    }

    /**
     * Gets the value of the count property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setCount(Integer value) {
        this.count = value;
    }

	@Override
	public String toString() {
		return "Smses [smsOrMms.size()=" + (smsOrMms==null?"null":smsOrMms.size()) + ", count=" + count + "]";
	}

}
