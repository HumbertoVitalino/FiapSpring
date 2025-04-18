package br.com.fiap.contacts.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_contact_types")
public class TypeContact {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_CONTACTS_TYPE_SEQ")
    @SequenceGenerator(
            name = "TBL_CONTACTS_TYPE_SEQ",
            sequenceName = "TBL_CONTACTS_TYPE_SEQ",
            allocationSize = 1)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "type")
    private List<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeContact{" +
                "id=" + id +
                ", tipo='" + type + '\'' +
                '}';
    }
}
