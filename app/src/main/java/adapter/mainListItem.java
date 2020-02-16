package adapter;


import android.graphics.drawable.Drawable;
import android.widget.CheckBox;

public class mainListItem {
    private String rank;
    private String name;
    private String time;
    private String routine;
    private boolean done; //checkbox용

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String date) {
        this.time = date;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String date) {
        this.routine = routine;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean getDone() { return done;}

    public void setDone() {this.done = done;}
}

