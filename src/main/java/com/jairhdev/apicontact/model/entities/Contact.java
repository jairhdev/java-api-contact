package com.jairhdev.apicontact.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50)
    private String nickname;

    @Column(length = 250)
    private String notes;

    // *****************************

    public Contact() {
    }

    public Contact(String name, String nickname, String notes) {
        this.name = name;
        this.nickname = nickname;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (!getId().equals(contact.getId())) return false;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        return result;
    }
}
