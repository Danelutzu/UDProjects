package Model;

public class Client {
    private int id;
    private String name;
    private String email;
    private int age;
    /**
     * Constructorul clasei client
     * @param id id-ul
     * @param name numele
     * @param email email-ul
     * @param age varsta
     */
    public Client(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    /**
     * Constructorul clasei client
     * @param name numele
     * @param email email-ul
     * @param age varsta
     */
    public Client(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Client(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age
                + "]";
    }

}
