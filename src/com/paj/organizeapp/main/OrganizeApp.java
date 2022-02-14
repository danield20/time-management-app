package com.paj.organizeapp.main;

import com.paj.organizeapp.activities.*;
import com.paj.organizeapp.email.EmailService;
import com.paj.organizeapp.exceptions.ActivityOverlayException;
import com.paj.organizeapp.exceptions.DateNotCorrectException;
import com.paj.organizeapp.exceptions.InsufficientFundsException;
import com.paj.organizeapp.people.AppUser;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class OrganizeApp {
    private AppUser user;
    private int balance;
    private TreeSet<AbstractActivity> activities;
    private LinkedList<Goal> goals;
    private TreeSet<Project> projects;
    private LinkedList<FinancialOperation> financials;
    private EmailService emailService;


    public OrganizeApp() {
        user = AppUser.getInstance();

        activities = new TreeSet<>(new Comparator<AbstractActivity>() {
            @Override
            public int compare(AbstractActivity o1, AbstractActivity o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
        goals = new LinkedList<>();
        projects = new TreeSet<>(
                (Project project1, Project project2) -> project1.getDeadline().compareTo(project2.getDeadline()));
        financials = new LinkedList<>();
        emailService = new EmailService();
    }

    public AppUser getUser() {
        return user;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public TreeSet<AbstractActivity> getActivities() {
        return activities;
    }

    public LinkedList<Goal> getGoals() {
        return goals;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public LinkedList<FinancialOperation> getFinancials() {
        return financials;
    }

    public void addActivity(AbstractActivity activity) throws Exception {
        if (activity.getStartTime().isAfter(activity.getEndTime()))
            throw new DateNotCorrectException("Data este in trecut");

        for (AbstractActivity act : activities) {
            if (activity.getStartTime().isBefore(act.getStartTime()) && activity.getEndTime().isAfter(act.getStartTime())) {
                throw new ActivityOverlayException("Activitatile se suprapun");
            }

            if (activity.getStartTime().isBefore(act.getEndTime()) && activity.getEndTime().isAfter(act.getEndTime())) {
                throw new ActivityOverlayException("Activitatile se suprapun");
            }

            if (activity.getStartTime().isAfter(act.getStartTime()) && activity.getEndTime().isBefore(act.getEndTime())) {
                throw new ActivityOverlayException("Activitatile se suprapun");
            }
        }
        activities.add(activity);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public void addProject(Project project) throws Exception {
        if (project.getDeadline().compareTo(LocalDateTime.now()) < 0)
            throw new DateNotCorrectException("Data este in trecut");
        projects.add(project);
    }

    public void addFinancial(FinancialOperation financial) throws Exception {
        if (financial.getClass().getName() == "com.paj.organizeapp.activities.Spending") {
            if (balance < financial.getAmount())
                throw new InsufficientFundsException("Fonduri insuficiente");
            balance -= financial.getAmount();
        } else {
            balance += financial.getAmount();
        }
        financials.add(financial);
    }

    public int getBalance() {
        int amount  = 0;

        for (FinancialOperation financial : financials) {
            if (financial.getClass().getName() == "com.paj.organizeapp.activities.Spending") {
                amount -= financial.getAmount();
            } else {
                amount += financial.getAmount();
            }
        }

        return amount;
    }

    public List<Goal> getAchievedGoals() {
        return goals.
                stream().
                filter((Goal milestone) -> {
                                    return  milestone.isAchieved();
                                    }).
                collect(Collectors.toList());
    }

    public List<Goal> getUnachievedGoals() {
        return goals.
                stream().
                filter( milestone -> !milestone.isAchieved()).
                collect(Collectors.toList());
    }

    public boolean setGoalByName(String name) {
        for (Goal goal : goals) {
            if (goal.getName().equals(name)) {
                goal.setAchieved();
                return true;
            }
        }

        return false;
    }

    public Goal getGoalByName(String name) {
        for (Goal goal : goals) {
            if (goal.getName().equals(name)) {
                return goal;
            }
        }

        return null;
    }

    public Integer getLargestSpending() {
        return financials.
                stream().
                filter( financial -> financial.getClass().getName() == "com.paj.organizeapp.activities.Spending").
                mapToInt(financial -> financial.getAmount())
                .max().getAsInt();
    }

    public Integer getLargetIncome() {
        return financials.
                stream().
                filter( financial -> financial.getClass().getName() != "com.paj.organizeapp.activities.Spending").
                mapToInt(financial -> financial.getAmount())
                .max().getAsInt();
    }

    public List<Project> getProjectsDescending() {
        TreeSet<Project> ret = new TreeSet<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.getDeadline().compareTo(o1.getDeadline());
            }
        });

        ret.addAll(projects);

        return new LinkedList<>(ret);
    }

    public List<AbstractActivity> getActivitiesDescending() {
        TreeSet<AbstractActivity> ret = new TreeSet<>(new Comparator<AbstractActivity>() {
            @Override
            public int compare(AbstractActivity o1, AbstractActivity o2) {
                return o2.getStartTime().compareTo(o1.getStartTime());
            }
        });

        ret.addAll(activities);

        return new LinkedList<>(ret);
    }

    public List<Project> getProjectsByMonth(Month month) {
        return projects.stream().filter(project -> project.getDeadline().getMonth().equals(month)).collect(Collectors.toList());
    }


    public List<AbstractActivity> getActivitiesByMonth(Month month) {
        return activities.stream().filter(project -> project.getStartTime().getMonth().equals(month)).collect(Collectors.toList());
    }

    public Project getProjectWithMostParticipants() {
        Project to_return = null;
        int max = -1;

        for (Project p : projects) {
            if (p.getParticipants().size() > max) {
                max = p.getParticipants().size();
                to_return = p;
            }
        }

        return to_return;
    }

    public List<AbstractActivity> getWorkActivities() {
        return activities.stream().filter(act -> act instanceof WorkActivity).collect(Collectors.toList());
    }

    public List<AbstractActivity> getPersonalActivities() {
        return activities.stream().filter(act -> act instanceof PersonalActivity).collect(Collectors.toList());
    }

    public List<Project> getProjectByType(ProjectType type) {
        return projects.stream().filter(project -> project.getType().equals(type)).collect(Collectors.toList());
    }
}
