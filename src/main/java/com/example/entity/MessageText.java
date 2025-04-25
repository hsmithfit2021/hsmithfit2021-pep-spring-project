package com.example.entity;

import javax.persistence.*;

/**
 * This is a class that models a Message.
 *
 * You should NOT make any modifications to this class.
 */
public class MessageText {

    private String messageText;

    public MessageText(){
    }
    /**
     * Only the message text is needed
     * @param messageText
     */
    public MessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    /**
     * Overriding the default equals() method adds functionality to tell when two objects are identical, allowing
     * Assert.assertEquals and List.contains to function.
     * @param o the other object.
     * @return true if o is equal to this object.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageText other = (MessageText) obj;
		if (messageText == null) {
			if (other.messageText != null)
				return false;
		} else if (!messageText.equals(other.messageText))
			return false;
		return true;
	}
	
    /**
     * Overriding the default toString() method allows for easy debugging.
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                '}';
    }


}
