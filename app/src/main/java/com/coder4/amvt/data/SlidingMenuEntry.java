package com.coder4.amvt.data;

/**
 * Created by coder4 on 2017/5/10.
 */

public class SlidingMenuEntry {
    private String text;
    private int iconId;

    public SlidingMenuEntry(String text, int iconId) {
        this.text = text;
        this.iconId = iconId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
