package com.learn_jpa.myevent;

import java.util.EventObject;

/**
 * 事件对象,继承EventObject,需要引用事件源对象
 */
public class PersonEvent extends EventObject {

    private Person person;

    /**
     * Constructs a prototypical Event.
     *
     * @param person The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public PersonEvent(Person person) {
        super(person);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
