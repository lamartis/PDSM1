//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.29 at 01:13:15 PM CET 
//


package com.generatedClasses.integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.interfaces.M2iInterface;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="identifiant" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inserted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="idDocument" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nomDocument" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "savePPTResponse")
public class SavePPTResponse
    implements M2iInterface
{

    @XmlAttribute(name = "identifiant")
    protected String identifiant;
    @XmlAttribute(name = "inserted")
    protected Boolean inserted;
    @XmlAttribute(name = "idDocument")
    protected String idDocument;
    @XmlAttribute(name = "nomDocument")
    protected String nomDocument;

    /**
     * Gets the value of the identifiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the value of the identifiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifiant(String value) {
        this.identifiant = value;
    }

    /**
     * Gets the value of the inserted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInserted() {
        return inserted;
    }

    /**
     * Sets the value of the inserted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInserted(Boolean value) {
        this.inserted = value;
    }

    /**
     * Gets the value of the idDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocument() {
        return idDocument;
    }

    /**
     * Sets the value of the idDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocument(String value) {
        this.idDocument = value;
    }

    /**
     * Gets the value of the nomDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomDocument() {
        return nomDocument;
    }

    /**
     * Sets the value of the nomDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomDocument(String value) {
        this.nomDocument = value;
    }

}
