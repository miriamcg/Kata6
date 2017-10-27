package kata4.model;

public class Mail {
    
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    public String getDomain(){
        String[] parts = mail.split("@");
        String domain = parts[1];
        return domain;
    }
}
