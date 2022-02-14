package com.paj.organizeapp.activities;

import com.paj.organizeapp.email.Email;
import com.paj.organizeapp.email.EmailService;
import com.paj.organizeapp.people.AbstractPeople;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public abstract class Social {
    LinkedList<AbstractPeople> participants;

    public Social() {
        this.participants = new LinkedList<>();
    }

    public LinkedList<AbstractPeople> getParticipants() {
        return participants;
    }

    public void setParticipants(LinkedList<AbstractPeople> participants) {
        this.participants = participants;
    }

    public void addParticipant(AbstractPeople person) {
        participants.add(person);
    }

    public boolean removeParticipantByName(String person, int occurrence) {
        int occ = occurrence;

        if (occ < 0)
            return false;

        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getName().equals(person)) {
                occ--;
                if (occ == 0) {
                    participants.remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    public void sendEmailToParticipants(AbstractPeople sender, String title, String message, EmailService emailService) throws Exception {
        for (AbstractPeople p : participants) {
            Email to_send = new Email().setFrom(sender).setTitle(title).setBody(message).setTo(p).setCopy(p);
            try {
                emailService.sendNotificationEmail(to_send);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }

    public List<AbstractPeople> getFemales() {
        return participants.stream().filter(person -> person.getGender().equals("female")).collect(Collectors.toList());
    }

    public List<AbstractPeople> getMales() {
        return participants.stream().filter(person -> person.getGender().equals("male")).collect(Collectors.toList());
    }

    public List<AbstractPeople> getBiggerThanAge(int age) {
        return participants.stream().filter(person -> person.getAge() >= age).collect(Collectors.toList());
    }


    public AbstractPeople getYoungest() {
        TreeSet<AbstractPeople> aux = new TreeSet<>(
                (AbstractPeople person1, AbstractPeople person2) -> person1.getAge() - person2.getAge());

        aux.addAll(participants);

        return aux.first();
    }

    public AbstractPeople getOldest() {
        TreeSet<AbstractPeople> aux = new TreeSet<>(
                (AbstractPeople person1, AbstractPeople person2) -> person2.getAge() - person1.getAge());

        aux.addAll(participants);

        return aux.first();
    }
}
