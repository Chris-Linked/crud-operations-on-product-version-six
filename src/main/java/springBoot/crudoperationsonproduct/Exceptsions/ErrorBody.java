package springBoot.crudoperationsonproduct.Exceptsions;

import java.util.Date;

/**
 * @author KChatzisotiriou
 * @since 9/7/2020
 */

public class ErrorBody {
    
    private Date timestamp;
    private String details;
    private String message;
    
    public ErrorBody(Date timestamp, String details, String message) {
        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
