package com.fleetmanagement.backend.dto;

public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String role;

    public UserResponse() {
    }

    public UserResponse(Long id, String firstName, String lastName,
                        String email, String contactNumber, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
    }


        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public String getRole() {
            return role;
        }
}
