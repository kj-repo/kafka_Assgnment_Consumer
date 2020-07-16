package com.pk.assignment_consumer.domain;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2020-07-02T20:19:21.104Z")

public class Address {
    @JsonProperty("addressLine1")
    private String addressLine1 = null;

    @JsonProperty("addressLine2")
    private String addressLine2 = null;

    @JsonProperty("street")
    private String street = null;

    @JsonProperty("postalCode")
    private String postalCode = null;

    public Address addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Get addressLine1
     * 
     * @return addressLine1
     **/
    @ApiModelProperty(example = "ACME Corporation", required = true, value = "")
    @NotNull

    @Size(max = 50)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Address addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Get addressLine2
     * 
     * @return addressLine2
     **/
    @ApiModelProperty(example = "ACME Corporation", value = "")


    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    /**
     * Get street
     * 
     * @return street
     **/
    @ApiModelProperty(example = "MG street", value = "")


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Get postalCode
     * 
     * @return postalCode
     **/
    @ApiModelProperty(example = "532322", required = true, value = "")
    @NotNull

    @Size(max = 5)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.addressLine1, address.addressLine1)
                && Objects.equals(this.addressLine2, address.addressLine2)
                && Objects.equals(this.street, address.street)
                && Objects.equals(this.postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, street, postalCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {\n");

        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    street: ").append(toIndentedString(street)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

