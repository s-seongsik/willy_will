package com.willy.will.search.model;

public class Distance {

    private String text = null;
    private boolean use = false;

    public Distance(String text, boolean use) {
        this.text = text;
        this.use = use;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }
}
