public class UserBuilder {
    private int id;
    private String firstname;
    private String lastname;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public User createUser() {
        return new User(id, firstname, lastname);
        
    }

}