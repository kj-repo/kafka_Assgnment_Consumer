package com.pk.assignment_consumer.domain;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * SuccessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2020-07-02T20:19:21.104Z")

public class SuccessResponse {
    @JsonProperty("status")
    private String status = "Success";

    @JsonProperty("message")
    private String message = null;

    public SuccessResponse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * success
     * 
     * @return status
     **/
    @ApiModelProperty(required = true, value = "success")
    @NotNull


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuccessResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * success message
     * 
     * @return message
     **/
    @ApiModelProperty(required = true, value = "success message")
    @NotNull


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SuccessResponse successResponse = (SuccessResponse) o;
        return Objects.equals(this.status, successResponse.status)
                && Objects.equals(this.message, successResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SuccessResponse {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

