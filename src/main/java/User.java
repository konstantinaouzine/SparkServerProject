public class User {
    private int id;
    private String firstname;
    private String lastname;

    User(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object otherUser){
        if (otherUser instanceof User) {
            User myOtherUser = (User) otherUser;
            if (this.hashCode() != myOtherUser.hashCode())
                return false;
            if (this.getId() != myOtherUser.getId())
                return false;
            return true;
        }else
            return false;
    }

    @Override
    public int hashCode(){
        return (this.getFirstname().hashCode() + this.getLastname().hashCode())/2;
    }

}
