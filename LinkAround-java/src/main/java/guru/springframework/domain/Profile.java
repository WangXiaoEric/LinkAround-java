package guru.springframework.domain;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class Profile {

    /**
     * 用戶ID
     */
    private Long id;

    /**
     * 省份编号
     */
    private String userName;

    /**
     * 專業
     */
    private String profession;
    
    
    
    private String profile;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getProfession() {
		return profession;
	}



	public void setProfession(String profession) {
		this.profession = profession;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}
    
    
    
}
