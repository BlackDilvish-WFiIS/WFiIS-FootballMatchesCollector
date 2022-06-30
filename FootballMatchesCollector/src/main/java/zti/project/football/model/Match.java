package zti.project.football.model;

import javax.persistence.*;

@Entity
@Table(name = "match2")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private String date;
    @Column(name = "result")
    private String result;
    @Column(name = "homeClub")
    private String homeClub;
    @Column(name = "awayClub")
    private String awayClub;

    @Column(name = "awayGoalkeeper")
    private String awayGoalkeeper;
    @Column(name = "awayLeftBack")
    private String awayLeftBack;
    @Column(name = "awayLeftCenterBack")
    private String awayLeftCenterBack;
    @Column(name = "awayRightCenterBack")
    private String awayRightCenterBack;
    @Column(name = "awayRightBack")
    private String awayRightBack;
    @Column(name = "awayLeftMidfielder")
    private String awayLeftMidfielder;
    @Column(name = "awayLeftCenterMidfielder")
    private String awayLeftCenterMidfielder;
    @Column(name = "awayRightCenterMidfielder")
    private String awayRightCenterMidfielder;
    @Column(name = "awayRightMidfielder")
    private String awayRightMidfielder;
    @Column(name = "awayLeftStriker")
    private String awayLeftStriker;
    @Column(name = "awayRightStriker")
    private String awayRightStriker;

    @Column(name = "homeGoalkeeper")
    private String homeGoalkeeper;
    @Column(name = "homeLeftBack")
    private String homeLeftBack;
    @Column(name = "homeLeftCenterBack")
    private String homeLeftCenterBack;
    @Column(name = "homeRightCenterBack")
    private String homeRightCenterBack;
    @Column(name = "homeRightBack")
    private String homeRightBack;
    @Column(name = "homeLeftMidfielder")
    private String homeLeftMidfielder;
    @Column(name = "homeLeftCenterMidfielder")
    private String homeLeftCenterMidfielder;
    @Column(name = "homeRightCenterMidfielder")
    private String homeRightCenterMidfielder;
    @Column(name = "homeRightMidfielder")
    private String homeRightMidfielder;
    @Column(name = "homeLeftStriker")
    private String homeLeftStriker;
    @Column(name = "homeRightStriker")
    private String homeRightStriker;

    public Match()
    {
    }

    public Match(String date, String result, String homeClub, String awayClub,
                 String awayGoalkeeper, String awayLeftBack, String awayLeftCenterBack, String awayRightCenterBack,
                 String awayRightBack, String awayLeftMidfielder, String awayLeftCenterMidfielder, String awayRightCenterMidfielder,
                 String awayRightMidfielder, String awayLeftStriker, String awayRightStriker,
                 String homeGoalkeeper, String homeLeftBack, String homeLeftCenterBack, String homeRightCenterBack,
                 String homeRightBack, String homeLeftMidfielder, String homeLeftCenterMidfielder, String homeRightCenterMidfielder,
                 String homeRightMidfielder, String homeLeftStriker, String homeRightStriker)
    {
        this.date = date;
        this.result = result;
        this.homeClub = homeClub;
        this.awayClub = awayClub;
        this.setAwayGoalkeeper(awayGoalkeeper);
        this.setAwayLeftBack(awayLeftBack);
        this.setAwayLeftCenterBack(awayLeftCenterBack);
        this.setAwayRightCenterBack(awayRightCenterBack);
        this.setAwayRightBack(awayRightBack);
        this.setAwayLeftMidfielder(awayLeftMidfielder);
        this.setAwayLeftCenterMidfielder(awayLeftCenterMidfielder);
        this.setAwayRightCenterMidfielder(awayRightCenterMidfielder);
        this.setAwayRightMidfielder(awayRightMidfielder);
        this.setAwayLeftStriker(awayLeftStriker);
        this.setAwayRightStriker(awayRightStriker);
        this.setHomeGoalkeeper(homeGoalkeeper);
        this.setHomeLeftBack(homeLeftBack);
        this.setHomeLeftCenterBack(homeLeftCenterBack);
        this.setHomeRightCenterBack(homeRightCenterBack);
        this.setHomeRightBack(homeRightBack);
        this.setHomeLeftMidfielder(homeLeftMidfielder);
        this.setHomeLeftCenterMidfielder(homeLeftCenterMidfielder);
        this.setHomeRightCenterMidfielder(homeRightCenterMidfielder);
        this.setHomeRightMidfielder(homeRightMidfielder);
        this.setHomeLeftStriker(homeLeftStriker);
        this.setHomeRightStriker(homeRightStriker);
    }

    public long getId() {
        return id;
    }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getHomeClub() { return homeClub; }
    public void setHomeClub(String homeClub) { this.homeClub = homeClub; }
    public String getAwayClub() { return awayClub; }
    public void setAwayClub(String awayClub) { this.awayClub = awayClub; }


    public String getAwayGoalkeeper() {
        return awayGoalkeeper;
    }

    public void setAwayGoalkeeper(String awayGoalkeeper) {
        this.awayGoalkeeper = awayGoalkeeper;
    }

    public String getAwayLeftBack() {
        return awayLeftBack;
    }

    public void setAwayLeftBack(String awayLeftBack) {
        this.awayLeftBack = awayLeftBack;
    }

    public String getAwayLeftCenterBack() {
        return awayLeftCenterBack;
    }

    public void setAwayLeftCenterBack(String awayLeftCenterBack) {
        this.awayLeftCenterBack = awayLeftCenterBack;
    }

    public String getAwayRightCenterBack() {
        return awayRightCenterBack;
    }

    public void setAwayRightCenterBack(String awayRightCenterBack) {
        this.awayRightCenterBack = awayRightCenterBack;
    }

    public String getAwayRightBack() {
        return awayRightBack;
    }

    public void setAwayRightBack(String awayRightBack) {
        this.awayRightBack = awayRightBack;
    }

    public String getAwayLeftMidfielder() {
        return awayLeftMidfielder;
    }

    public void setAwayLeftMidfielder(String awayLeftMidfielder) {
        this.awayLeftMidfielder = awayLeftMidfielder;
    }

    public String getAwayLeftCenterMidfielder() {
        return awayLeftCenterMidfielder;
    }

    public void setAwayLeftCenterMidfielder(String awayLeftCenterMidfielder) {
        this.awayLeftCenterMidfielder = awayLeftCenterMidfielder;
    }

    public String getAwayRightCenterMidfielder() {
        return awayRightCenterMidfielder;
    }

    public void setAwayRightCenterMidfielder(String awayRightCenterMidfielder) {
        this.awayRightCenterMidfielder = awayRightCenterMidfielder;
    }

    public String getAwayRightMidfielder() {
        return awayRightMidfielder;
    }

    public void setAwayRightMidfielder(String awayRightMidfielder) {
        this.awayRightMidfielder = awayRightMidfielder;
    }

    public String getAwayLeftStriker() {
        return awayLeftStriker;
    }

    public void setAwayLeftStriker(String awayLeftStriker) {
        this.awayLeftStriker = awayLeftStriker;
    }

    public String getAwayRightStriker() {
        return awayRightStriker;
    }

    public void setAwayRightStriker(String awayRightStriker) {
        this.awayRightStriker = awayRightStriker;
    }

    public String getHomeGoalkeeper() {
        return homeGoalkeeper;
    }

    public void setHomeGoalkeeper(String homeGoalkeeper) {
        this.homeGoalkeeper = homeGoalkeeper;
    }

    public String getHomeLeftBack() {
        return homeLeftBack;
    }

    public void setHomeLeftBack(String homeLeftBack) {
        this.homeLeftBack = homeLeftBack;
    }

    public String getHomeLeftCenterBack() {
        return homeLeftCenterBack;
    }

    public void setHomeLeftCenterBack(String homeLeftCenterBack) {
        this.homeLeftCenterBack = homeLeftCenterBack;
    }

    public String getHomeRightCenterBack() {
        return homeRightCenterBack;
    }

    public void setHomeRightCenterBack(String homeRightCenterBack) {
        this.homeRightCenterBack = homeRightCenterBack;
    }

    public String getHomeRightBack() {
        return homeRightBack;
    }

    public void setHomeRightBack(String homeRightBack) {
        this.homeRightBack = homeRightBack;
    }

    public String getHomeLeftMidfielder() {
        return homeLeftMidfielder;
    }

    public void setHomeLeftMidfielder(String homeLeftMidfielder) {
        this.homeLeftMidfielder = homeLeftMidfielder;
    }

    public String getHomeLeftCenterMidfielder() {
        return homeLeftCenterMidfielder;
    }

    public void setHomeLeftCenterMidfielder(String homeLeftCenterMidfielder) {
        this.homeLeftCenterMidfielder = homeLeftCenterMidfielder;
    }

    public String getHomeRightCenterMidfielder() {
        return homeRightCenterMidfielder;
    }

    public void setHomeRightCenterMidfielder(String homeRightCenterMidfielder) {
        this.homeRightCenterMidfielder = homeRightCenterMidfielder;
    }

    public String getHomeRightMidfielder() {
        return homeRightMidfielder;
    }

    public void setHomeRightMidfielder(String homeRightMidfielder) {
        this.homeRightMidfielder = homeRightMidfielder;
    }

    public String getHomeLeftStriker() {
        return homeLeftStriker;
    }

    public void setHomeLeftStriker(String homeLeftStriker) {
        this.homeLeftStriker = homeLeftStriker;
    }

    public String getHomeRightStriker() {
        return homeRightStriker;
    }

    public void setHomeRightStriker(String homeRightStriker) {
        this.homeRightStriker = homeRightStriker;
    }
}
