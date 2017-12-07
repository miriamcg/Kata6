package kata6.model;

public class Mail {
    
    private final String mail;
    private final Integer id;

    public Mail(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }
    
    public String getMail() {
        return mail;
    }

    public Integer getId() {
        return id;
    }
}
