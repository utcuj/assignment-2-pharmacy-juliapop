package model;



/**
 * Created by julia on 4/21/2018.
 */

public class User {

    private int idUser;
    private String name;
    private String username;
    private String password;
    private String type;

    public User(int idUser, String name, String username, String password, String type) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getType() {
		return type.toString();
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
    
}