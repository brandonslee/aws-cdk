package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class MyWidgetServiceApp {
    public static void main(final String[] args) {
        App app = new App();

        new MyWidgetServiceStack(app, "MyWidgetServiceStack");

        app.synth();
    }
}
