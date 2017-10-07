
package com.bottomup.demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="creditCardInfo" type="{http://demo.bottomup.com/}CCInfo"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRequest", propOrder = {
    "creditCardInfo",
    "amount"
})
public class PaymentRequest {

    @XmlElement(required = true)
    protected CCInfo creditCardInfo;
    protected double amount;

    /**
     * Gets the value of the creditCardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CCInfo }
     *     
     */
    public CCInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    /**
     * Sets the value of the creditCardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CCInfo }
     *     
     */
    public void setCreditCardInfo(CCInfo value) {
        this.creditCardInfo = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

}
