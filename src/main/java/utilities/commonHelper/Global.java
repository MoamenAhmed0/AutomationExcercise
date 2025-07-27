package utilities.commonHelper;

public class Global {
    private static Global instance;
    private String password;
    private String name;
    private String mobileNumber;
    private String email;
    private String nid;

    // Private constructor to prevent new instances
    private Global() {}
    // Singleton pattern
    public static Global getInstance() {
        if (instance == null) {
            instance = new Global();
        }
        return instance;
    }
    public void setPassword() {
        this.password = RandomSource.generateRandomPassword();
    }
    public void setName() {
        this.name = RandomSource.generateRandomName();
    }
    public void setEmail() {
        this.email = RandomSource.generateRandomEmail();
    }

    public void setNID() {
        this.nid = RandomSource.generateRandomNID();
    }
    public void setMobileNumber() {
        this.mobileNumber = RandomSource.generateRandomMobileNumber();
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getNID() {
        return nid;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
}
