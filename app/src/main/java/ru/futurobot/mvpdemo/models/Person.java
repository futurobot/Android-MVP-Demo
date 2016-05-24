package ru.futurobot.mvpdemo.models;

import com.google.auto.value.AutoValue;

import java.net.URI;

/**
 * Created by Alexey on 24.05.16.
 */

@AutoValue
public abstract class Person {

    public static Person create(String firstName, String secondName, URI avatarUri) {
        return new AutoValue_Person(firstName, secondName, avatarUri);
    }

    public abstract String firstName();

    public abstract String secondName();

    public abstract URI avatarUri();
}
