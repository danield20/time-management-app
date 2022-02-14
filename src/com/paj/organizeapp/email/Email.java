package com.paj.organizeapp.email;

import com.paj.organizeapp.people.AbstractPeople;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Email implements Serializable {

	private static final long serialVersionUID = -3686472195559526951L;
	private AbstractPeople from;
    private List<AbstractPeople> to, copy;
    private String title, body;

    public AbstractPeople getFrom() {
        return from;
    }

    public Email setFrom(AbstractPeople from) {
        this.from = from;
        return this;
    }

    public List<AbstractPeople> getTo() {
        return to;
    }

    public Email setTo(List<AbstractPeople> to) {
        this.to = to;
        return this;
    }

    public Email setTo(AbstractPeople to) {
    	ArrayList<AbstractPeople> toList = new ArrayList<AbstractPeople>();
    	toList.add(to);
        setTo(toList);
        return this;
    }

    public List<AbstractPeople> getCopy() {
        return copy;
    }

    public Email setCopy(List<AbstractPeople> copy) {
        this.copy = copy;
        return this;
    }

    public Email setCopy(AbstractPeople copy) {
    	ArrayList<AbstractPeople> copyList = new ArrayList<AbstractPeople>();
    	copyList.add(copy);
        setCopy(copyList);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Email setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Email setBody(String body) {
        this.body = body;
        return this;
    }
    
    @Override
    public String toString() {
    	List<AbstractPeople> clients = getTo();
    	StringBuilder clientsTo = new StringBuilder();
    	for (AbstractPeople c: clients) {
    		clientsTo.append(c);
    	}
    	
    	clients = getCopy();
    	StringBuilder clientsCopy = new StringBuilder();
    	for (AbstractPeople c: clients) {
    		clientsCopy.append(c);
    	}
    	
    	return "SEND EMAIL:" + "\n" + 
    			"From: " + getFrom() +
    			"To: " + clientsTo +
    			"Copy: " + clientsCopy +
    			"Title: " + getTitle() + "\n" +
    			"Body: " + getBody() + "\n";
    }
}