package kferi.Futoverseny;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.concurrent.TimeUnit;

@Entity
public class Result {
    @ManyToOne
    private Runner runner;
    @ManyToOne
    private Competition competition;
    private long resultInMillisec;

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public long getResultInMillisec() {
        return resultInMillisec;
    }

    public void setResultInMillisec(long resultInMillisec) {
        this.resultInMillisec = resultInMillisec;
    }
    
    public long timeToMs (int hr, int min, int sec, int ms) {
        return ((((hr*60+min)*60+sec)*1000)+ms);
    }
    
    public String msToTime (long msTime) {
        long hr = TimeUnit.MILLISECONDS.toHours(msTime);
        long min = TimeUnit.MILLISECONDS.toMinutes(msTime) %60;
        long sec = TimeUnit.MILLISECONDS.toSeconds(msTime) %60;
        long ms = TimeUnit.MILLISECONDS.toMillis(msTime) %1000;
        return String.format("%02d:%02d:%02d.%03d", hr, min, sec, ms);
    }
}
