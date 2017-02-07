package models;

public class Contact{
    private int id;
    private String fullNameField;
    private String addressField;
    private String phoneNumber;
    private String createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullNameField() {
        return fullNameField;
    }

    public void setFullNameField(String fullNameField) {
        this.fullNameField = fullNameField;
    }

    public String getAddressField() {
        return addressField;
    }

    public void setAddressField(String addressField) {
        this.addressField = addressField;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

/*
* Nombre completo
- Direccion
- Telefono
- Fecha de creación
* */