package beans;

public class User {

	public String EmailID;
	public String Password;
	public String FullName;
	public String Gender;
	public String Age;
	public String Mobile;
	public String City;
	public String State;
	public String Security_question;
	public String Security_answer;
	
	public User(String EmailID,String Password,String FullName,String Gender,String Age,String Mobile,String City,String State,String Security_question,String Security_answer)
	{
		    this.EmailID = EmailID;
			this.Password = Password;
			this.FullName = FullName;
			this.Gender= Gender;
			this.Age= Age;
			this.Mobile= Mobile;
			this.City= City;
			this.State=State;
			this.Security_question=Security_question;
			this.Security_answer=Security_answer;		
	}
	 public String getEmailID() {
			return EmailID;
		   }
		  public void setEmailID(String EmailID) {
			this.EmailID = EmailID;
		  }
		  
    public String getPassword() {
				return Password;
			   }
    public void setPassword(String Password) {
				this.Password = Password;
			  }	  
	
    public String getFullName() {
		return FullName;
	   }
    public void setFullName(String FullName) {
		this.FullName = FullName;
	  }	
    
    public String getGender() {
		return Gender;
	   }
    public void setGender(String Gender) {
		this.Gender = Gender;
	  }
    
    public String getAge() {
		return Age;
	   }
    public void setAge(String Age) {
		this.Age = Age;
	  }
    
    public String getMobile() {
		return Mobile;
	   }
    public void setMobile(String Mobile) {
		this.Mobile = Mobile;
	  }	  
	
    public String getCity() {
		return City;
	   }
    public void setCity(String City) {
		this.City = City;
	  }	
    
    public String getState() {
		return State;
	   }
    public void setState(String State) {
		this.State = State;
	  }	

    public String getSecurity_question() {
		return Security_question;
	   }
    public void setSecurity_question(String Security_question) {
		this.Security_question = Security_question;
	  }	
    
    public String getSecurity_answer() {
		return Security_answer;
	   }
    public void setSecurity_answer(String Security_answer) {
		this.Security_answer = Security_answer;
	  }


}
