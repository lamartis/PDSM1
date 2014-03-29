//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.29 at 11:59:17 AM CET 
//


package com.generatedClasses.presentation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.interfaces.P2mInterface;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="response">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="inserted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="idDocument" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="nomDocument" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Error" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *       &lt;attribute name="identifiant" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response",
    "error"
})
@XmlRootElement(name = "createOrUpdatePPTResponse")
public class CreateOrUpdatePPTResponse
    implements P2mInterface
{

    protected CreateOrUpdatePPTResponse.Response response;
    @XmlElement(name = "Error")
    protected String error;
    @XmlAttribute(name = "identifiant")
    protected String identifiant;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link CreateOrUpdatePPTResponse.Response }
     *     
     */
    public CreateOrUpdatePPTResponse.Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOrUpdatePPTResponse.Response }
     *     
     */
    public void setResponse(CreateOrUpdatePPTResponse.Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
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
    public static class Response
        implements P2mInterface
    {

        @XmlAttribute(name = "inserted")
        protected Boolean inserted;
        @XmlAttribute(name = "idDocument")
        protected String idDocument;
        @XmlAttribute(name = "nomDocument")
        protected String nomDocument;

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

}