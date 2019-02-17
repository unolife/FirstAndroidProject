package com.project.coding101.my.studentBoard;

import android.content.Intent;

public class Choice {

    public final String title;
    public final String description;
    public final Intent launchIntent;

    public Choice(String title, String description, Intent launchIntent) {
        this.title = title;
        this.description = description;
        this.launchIntent = launchIntent;
    }

}
