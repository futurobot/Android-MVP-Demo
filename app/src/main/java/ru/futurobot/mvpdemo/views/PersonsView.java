package ru.futurobot.mvpdemo.views;

import java.util.List;

import ru.futurobot.mvpdemo.models.Person;

/**
 * Created by Alexey on 24.05.16.
 */

public interface PersonsView {
    void showLoading();
    void showMessage(String message);
    void publishPersons(List<Person> persons);
}
