// Contact.java
package com.project.bluebellsschool.data;

public class Contact {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String message;

    public Contact(int id, String name, String mobile, String email, String message) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.message = message;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getMessage() { return message; }

    // Setters (Optional - you might not need these)
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setEmail(String email) { this.email = email; }
    public void setMessage(String message) { this.message = message; }
}