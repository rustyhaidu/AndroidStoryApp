package com.example.claudiuhaidu.storyapp.model;

/**
 * Created by claudiuhaidu on 13/01/2018.
 * Choice contains the id to add the text on the buttons
 */

public class Choice {

    private int textId;
    private int nextPage;

    public Choice(int textId, int nextPage) {
        this.nextPage = nextPage;
        this.textId = textId;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }
}
