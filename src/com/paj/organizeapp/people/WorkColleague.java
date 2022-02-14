package com.paj.organizeapp.people;

public class WorkColleague extends AbstractPeople {
    private String team;
    private String email;
    private boolean superior;

    public WorkColleague(String name, int age, String gender, String team, String email, boolean is_superior) {
        super(name, age, gender);
        this.team = team;
        this.email = email;
        this.superior = is_superior;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSuperior() {
        return superior;
    }

    public void setSuperior(boolean is_superior) {
        this.superior = is_superior;
    }

    @Override
    public String toString() {
        return "WorkColleague{" +
                "team='" + team + '\'' +
                ", email='" + email + '\'' +
                ", superior=" + superior +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
