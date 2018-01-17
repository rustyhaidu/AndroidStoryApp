package com.example.claudiuhaidu.storyapp.model;

/**
 * Created by claudiuhaidu on 13/01/2018.
 * Page contains the View elements
 */

public class Page {

    private int imageId;
    private int textId;

    private Choice choice1;
    private Choice choice2;

    private boolean isFinalPage = false;

    public Page(int imageId, int textId, Choice choice1, Choice choice2) {
        this.textId = textId;
        this.imageId = imageId;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Page(int imageId, int textId) {
        this.imageId = imageId;
        this.textId = textId;
        this.isFinalPage = true;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
