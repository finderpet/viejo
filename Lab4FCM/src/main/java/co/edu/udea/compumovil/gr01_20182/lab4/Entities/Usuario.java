package co.edu.udea.compumovil.gr01_20182.lab4.Entities;

public class Usuario {

    private String email;
    private String name;
    private String password;
    private String image;

    public Usuario(){

    }

    public Usuario(String email, String name, String password, String image) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
