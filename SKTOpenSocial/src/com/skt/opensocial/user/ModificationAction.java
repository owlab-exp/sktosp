package com.skt.opensocial.user;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;


import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Address;
import com.skt.opensocial.persistence.DrinkerEnum;

import com.skt.opensocial.persistence.GenderEnum;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Info1AttributeEnum;
import com.skt.opensocial.persistence.Info2AttributeEnum;
import com.skt.opensocial.persistence.NetworkpresenceEnum;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.PersonOrganization;
import com.skt.opensocial.persistence.PersonUrl;
import com.skt.opensocial.persistence.SmokerEnum;
import com.skt.opensocial.persistence.User;

/**	사용자가 자신의 정보를 수정하기 위해 조회하는 액션 클래스
 * @author 	Seong Yong Lim based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
public class ModificationAction extends ActionSupport implements SessionAware {

	
//	@Override
//	public void setSession(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**	수정을 위해 출력되는 사용자 정보
	 *  
	 */	
	private User user;
	private String userId;
	private String password;
	private String hashedPassword;
	
	private boolean isDeveloper;
	private boolean isAdministrator;

	private Date registeredDate;
	
	Set<PersonAdditionalInfo2> personAdditionalInfo2;
	Set<PersonAdditionalInfo1> personAdditionalInfo1;
	
	Set<PersonOrganization> personOrganizations;
	Set<PersonUrl> personUrls;
	
	private Person person;
	
	private String userName;
	private int age;
	private GenderEnum gender;
	private Date birthday;
	
	private Set<Address> addresses;
	
	private String email; 
	private String email2; 
	private String address; 
	private String address2; 
	private String school; // need for check
	private String school2; // need for check
	private String job; // need for check
	private String job2; // need for check
	
	private String aboutMe;
	private String bodytypeBuild;
	private String bodytypeEyecolor;
	private String bodytypeHaircolor;
	private double bodytypeHeight;
	private double bodytypeWeight;
	
	private String book; 
	private String book2; 
	
	private String car; 
	private String car2; 
	
	private String children;
	
	private String currentLocation;
	
	private DrinkerEnum drinker;
	private String ethnicity;
	private String fashion;
	
	private String food;
	private String food2;
	
	private String happiestWhen;
	
	private String hero;
	private String hero2;
	
	private String humor;
	
	private String interest;
	private String interest2;
	
	private String jobInterest;
	
	private String languageSpoken;
	private String languageSpoken2;
	
	private String livingArrangement;
	
	private String lookingFor;
	
	private String movie;
	private String movie2;
	private String music;
	private String music2;
	
	private String additionalName;
	private String familyName;
	private String givenName;
	private String honorificPrefix;
	private String honorificSuffix;
	
	private NetworkpresenceEnum networkPresence;
	private String nickname;
	
	private String pets;
	
	private String phoneNumber;
	private String phoneType;
	private String phoneNumber2;
	private String phoneType2;
	
	private String politicalViews;
	
	private String profilesongUrlAddress;
	private String profilesongUrlLinktext;
	private String profilesongUrlType;
	
	private String profilevideoUrlAddress;
	private String profilevideoUrlLinktext;
	private String profilevideoUrlType;
	
	private String profileUrlAddress;
	private String profileUrlLinktext;
	private String profileUrlType;
	
	private String quote;
	private String quote2;
	
	private String relationshipStatus;
	private String religion;
	private String romance;
	private String scaredOf;
	private String sexualOrientation;
	private SmokerEnum smoker;
	
	private String sport;
	private String sport2;
	
	private String status;
	
	private String tag;
	private String tag2;
	
	private String thumbnailUrlAddress;
	private String thumbnailUrlLinktext;
	private String thumbnailUrlType;
	
	private String turnOff;
	private String turnOff2;
	private String turnOn;
	private String turnOn2;
	private String tvShow;
	private String tvShow2;
	
	private String personalInfoOpen;
	private String favoriteGadgetListOpen;
	//private UserVisibility userVisibility;
	//private Set<GadgetReview> reviews;
	
	/** execute 메소드 에서는 사용자정보를 가져와 출력한다.
	 * 
	 */
	public String execute() {
		//User user = new User();
		user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		userId = user.getId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		
		user = (User)hs.get(User.class, userId);
		
		registeredDate = user.getRegisteredDate();
		
		//PasswordEncryptor pe = PasswordEncryptor.getInstance();
		//hashedPassword = pe.encrypt(password);
		
		person = user.getPerson();
		
		userName = person.getNameFormatted();
		age = person.getAge();
		gender = person.getGender();
		birthday = person.getBirthday();
		
		aboutMe = person.getAboutme();
		bodytypeBuild = person.getBodytypeBuild();
		bodytypeEyecolor = person.getBodytypeEyecolor();
		bodytypeHaircolor = person.getBodytypeHaircolor();
		bodytypeHeight = person.getBodytypeHeight();
		bodytypeWeight = person.getBodytypeWeight();
		
		children = person.getChildren();
		currentLocation = person.getCurrentlocationFormatted();
		drinker = person.getDrinker();
		ethnicity = person.getEthnicity();
		fashion = person.getFashion();
		happiestWhen = person.getHappiestwhen();
		humor = person.getHumor();
		jobInterest = person.getJobinterests();
		
		livingArrangement = person.getLivingarrangement();
		
		additionalName = person.getNameAdditionalname();
		familyName = person.getNameFamilyname();
		givenName = person.getNameGivenname();
		honorificPrefix = person.getNameHonorificprefix();
		honorificSuffix = person.getNameHonorificsuffix();
		
		networkPresence = person.getNetworkpresence();
		nickname = person.getNickname();
		
		pets = person.getPets();
		
		politicalViews = person.getPoliticalviews();
		profilesongUrlAddress = person.getProfilesongurlValue();
		profilesongUrlLinktext = person.getProfilesongurlLinkText();
		profilesongUrlType = person.getProfilesongurlType();
		
		profilevideoUrlAddress = person.getProfilevideourlValue();
		profilevideoUrlLinktext = person.getProfilevideourlLinkText();
		profilevideoUrlType = person.getProfilevideourlType();
		
		relationshipStatus = person.getRelationshipstatus();
		religion = person.getReligion();
		romance = person.getRomance();
		scaredOf = person.getScaredof();
		sexualOrientation = person.getSexualorientation();
		smoker = person.getSmoker();
				
		status = person.getStatus();
		
		personalInfoOpen = person.getProfileurl();
		favoriteGadgetListOpen = person.getThumbnailurl();
		
		//thumbnailUrlAddress = person.getThumbnailurl();
		//thumbnailUrlLinktext 
		//thumbnailUrlType;
		//profileUrlAddress = person.getProfileurl();
		//profileUrlLinktext = person.
		//profileUrlType = person.
		
		personOrganizations = person.getOrganizations();
		personUrls = person.getUrls();
		
		for (PersonOrganization p: personOrganizations)
		{
			if (p.getType().equals("job") && p.getPrimary())
				job = p.getName();
			else if (p.getType().equals("job") && !p.getPrimary())
				job2 = p.getName();
			else if (p.getType().equals("school") && p.getPrimary())
				school = p.getName();
			else if (p.getType().equals("school") && !p.getPrimary())
				school2 = p.getName();
		}
		
		for (PersonUrl p: personUrls)
		{
			if (p.getType().equals("profile"))
			{
				profileUrlLinktext = p.getLinkText();
				profileUrlAddress = p.getValue();
			}
			else if (p.getType().equals("thumbnail"))
			{
				thumbnailUrlLinktext = p.getLinkText();
				thumbnailUrlAddress = p.getValue();
			}
				
		}
		
		personAdditionalInfo2 = person.getAdditionalInfo2s();
		personAdditionalInfo1 = person.getAdditionalInfo1s();
		
		for (PersonAdditionalInfo2 p:personAdditionalInfo2)
		{
			if (p.getAttribute().equals(Info2AttributeEnum.emails) && p.getPrimary())
				email = p.getValue();
			else if (p.getAttribute().equals(Info2AttributeEnum.emails) && !p.getPrimary())
				email2 = p.getValue();
			else if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers) && p.getPrimary())
			{
				phoneNumber = p.getValue();
				phoneType = p.getType();
			}
			else if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers) && !p.getPrimary())
			{
				phoneNumber2 = p.getValue();
				phoneType2 = p.getType();
			}
		}
		
		addresses = person.getAddresses();
		
		for (Address a: addresses)
		{
			if (a.getPrimary())
				address = a.getFormatted();
			else if (!a.getPrimary())
				address2 = a.getFormatted();
		}
		
		boolean flagPrimaryBook = false;
		boolean flagPrimaryCar = false;
		boolean flagPrimaryFood = false;
		boolean flagPrimaryHero = false;
		boolean flagPrimaryInterest = false;
		boolean flagPrimaryLanguageSpoken = false;
		boolean flagPrimaryMovie = false;
		boolean flagPrimaryMusic = false;
		boolean flagPrimaryQuote = false;
		boolean flagPrimarySport = false;
		boolean flagPrimaryTag = false;
		boolean flagPrimaryTurnOff = false;
		boolean flagPrimaryTurnOn = false;
		boolean flagPrimaryTvShow = false;
		
		for (PersonAdditionalInfo1 p:personAdditionalInfo1)
		{
			if (p.getAttribute().equals(Info1AttributeEnum.books))
			{
				if (!flagPrimaryBook)
				{
					book = p.getValue();
					flagPrimaryBook = true;
				}
				else
					book2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.cars))
			{
				if (!flagPrimaryCar)
				{
					car = p.getValue();
					flagPrimaryCar = true;
				}
				else
					car2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.food))
			{
				if (!flagPrimaryFood)
				{
					food = p.getValue();
					flagPrimaryFood = true;
				}
				else
					food2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.heroes))
			{
				if (!flagPrimaryHero)
				{
					hero = p.getValue();
					flagPrimaryHero = true;
				}
				else
					hero2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.interests))
			{
				if (!flagPrimaryInterest)
				{
					interest = p.getValue();
					flagPrimaryInterest = true;
				}
				else
					interest2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.languagesSpoken))
			{
				if (!flagPrimaryLanguageSpoken)
				{
					languageSpoken = p.getValue();
					flagPrimaryLanguageSpoken = true;
				}
				else
					languageSpoken2 = p.getValue();
			}
			
			if (p.getAttribute().equals(Info1AttributeEnum.lookingFor))
			{
				lookingFor = p.getValue();
			}
			
			if (p.getAttribute().equals(Info1AttributeEnum.movies))
			{
				if (!flagPrimaryMovie)
				{
					movie = p.getValue();
					flagPrimaryMovie = true;
				}
				else
					movie2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.music))
			{
				if (!flagPrimaryMusic)
				{
					music = p.getValue();
					flagPrimaryMusic = true;
				}
				else
					music2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.quotes))
			{
				if (!flagPrimaryQuote)
				{
					quote = p.getValue();
					flagPrimaryQuote = true;
				}
				else
					quote2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.sports))
			{
				if (!flagPrimarySport)
				{
					sport = p.getValue();
					flagPrimarySport = true;
				}
				else
					sport2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.tags))
			{
				if (!flagPrimaryTag)
				{
					tag = p.getValue();
					flagPrimaryTag = true;
				}
				else
					tag2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.turnOffs))
			{
				if (!flagPrimaryTurnOff)
				{
					turnOff = p.getValue();
					flagPrimaryTurnOff = true;
				}
				else
					turnOff2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.turnOns))
			{
				if (!flagPrimaryTurnOn)
				{
					turnOn = p.getValue();
					flagPrimaryTurnOn = true;
				}
				else
					turnOn2 = p.getValue();
			}
			if (p.getAttribute().equals(Info1AttributeEnum.tvShows))
			{
				if (!flagPrimaryTvShow)
				{
					tvShow = p.getValue();
					flagPrimaryTvShow = true;
				}
				else
					tvShow2 = p.getValue();
			}
			
		}
		
			/*
			
			private UserVisibility userVisibility;
			private Set<GadgetReview> reviews;
			
			*/
		/*
		
		private String school; // need for check
		private String school2; // need for check
		private String job; // need for check
		private String job2; // need for check
				
		private String jobInterest;
		private String jobInterest2;
					 
		 * 
		 */
		
		return "success";
	}
	// Properties to receive login request parameters

	private Map<String, Object> session;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public boolean isDeveloper() {
		return isDeveloper;
	}

	public void setDeveloper(boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}

	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getBodytypeBuild() {
		return bodytypeBuild;
	}

	public void setBodytypeBuild(String bodytypeBuild) {
		this.bodytypeBuild = bodytypeBuild;
	}

	public String getBodytypeEyecolor() {
		return bodytypeEyecolor;
	}

	public void setBodytypeEyecolor(String bodytypeEyecolor) {
		this.bodytypeEyecolor = bodytypeEyecolor;
	}

	public String getBodytypeHaircolor() {
		return bodytypeHaircolor;
	}

	public void setBodytypeHaircolor(String bodytypeHaircolor) {
		this.bodytypeHaircolor = bodytypeHaircolor;
	}

	public double getBodytypeHeight() {
		return bodytypeHeight;
	}

	public void setBodytypeHeight(double bodytypeHeight) {
		this.bodytypeHeight = bodytypeHeight;
	}

	public double getBodytypeWeight() {
		return bodytypeWeight;
	}

	public void setBodytypeWeight(double bodytypeWeight) {
		this.bodytypeWeight = bodytypeWeight;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public DrinkerEnum getDrinker() {
		return drinker;
	}

	public void setDrinker(DrinkerEnum drinker) {
		this.drinker = drinker;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getFashion() {
		return fashion;
	}

	public void setFashion(String fashion) {
		this.fashion = fashion;
	}

	public String getHappiestWhen() {
		return happiestWhen;
	}

	public void setHappiestWhen(String happiestWhen) {
		this.happiestWhen = happiestWhen;
	}

	public String getHumor() {
		return humor;
	}

	public void setHumor(String humor) {
		this.humor = humor;
	}

	public String getLivingArrangement() {
		return livingArrangement;
	}

	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}

	public String getAdditionalName() {
		return additionalName;
	}

	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getHonorificPrefix() {
		return honorificPrefix;
	}

	public void setHonorificPrefix(String honorificPrefix) {
		this.honorificPrefix = honorificPrefix;
	}

	public String getHonorificSuffix() {
		return honorificSuffix;
	}

	public void setHonorificSuffix(String honorificSuffix) {
		this.honorificSuffix = honorificSuffix;
	}

	public NetworkpresenceEnum getNetworkPresence() {
		return networkPresence;
	}

	public void setNetworkPresence(NetworkpresenceEnum networkPresence) {
		this.networkPresence = networkPresence;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}

	public String getPoliticalViews() {
		return politicalViews;
	}

	public void setPoliticalViews(String politicalViews) {
		this.politicalViews = politicalViews;
	}

	public String getProfilesongUrlAddress() {
		return profilesongUrlAddress;
	}

	public void setProfilesongUrlAddress(String profilesongUrlAddress) {
		this.profilesongUrlAddress = profilesongUrlAddress;
	}

	public String getProfilesongUrlLinktext() {
		return profilesongUrlLinktext;
	}

	public void setProfilesongUrlLinktext(String profilesongUrlLinktext) {
		this.profilesongUrlLinktext = profilesongUrlLinktext;
	}

	public String getProfilesongUrlType() {
		return profilesongUrlType;
	}

	public void setProfilesongUrlType(String profilesongUrlType) {
		this.profilesongUrlType = profilesongUrlType;
	}

	public String getProfilevideoUrlAddress() {
		return profilevideoUrlAddress;
	}

	public void setProfilevideoUrlAddress(String profilevideoUrlAddress) {
		this.profilevideoUrlAddress = profilevideoUrlAddress;
	}

	public String getProfilevideoUrlLinktext() {
		return profilevideoUrlLinktext;
	}

	public void setProfilevideoUrlLinktext(String profilevideoUrlLinktext) {
		this.profilevideoUrlLinktext = profilevideoUrlLinktext;
	}

	public String getProfilevideoUrlType() {
		return profilevideoUrlType;
	}

	public void setProfilevideoUrlType(String profilevideoUrlType) {
		this.profilevideoUrlType = profilevideoUrlType;
	}

	public String getProfileUrlAddress() {
		return profileUrlAddress;
	}

	public void setProfileUrlAddress(String profileUrlAddress) {
		this.profileUrlAddress = profileUrlAddress;
	}

	public String getProfileUrlLinktext() {
		return profileUrlLinktext;
	}

	public void setProfileUrlLinktext(String profileUrlLinktext) {
		this.profileUrlLinktext = profileUrlLinktext;
	}

	public String getProfileUrlType() {
		return profileUrlType;
	}

	public void setProfileUrlType(String profileUrlType) {
		this.profileUrlType = profileUrlType;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRomance() {
		return romance;
	}

	public void setRomance(String romance) {
		this.romance = romance;
	}

	public String getScaredOf() {
		return scaredOf;
	}

	public void setScaredOf(String scaredOf) {
		this.scaredOf = scaredOf;
	}

	public String getSexualOrientation() {
		return sexualOrientation;
	}

	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}

	public SmokerEnum getSmoker() {
		return smoker;
	}

	public void setSmoker(SmokerEnum smoker) {
		this.smoker = smoker;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getThumbnailUrlAddress() {
		return thumbnailUrlAddress;
	}

	public void setThumbnailUrlAddress(String thumbnailUrlAddress) {
		this.thumbnailUrlAddress = thumbnailUrlAddress;
	}

	public String getThumbnailUrlLinktext() {
		return thumbnailUrlLinktext;
	}

	public void setThumbnailUrlLinktext(String thumbnailUrlLinktext) {
		this.thumbnailUrlLinktext = thumbnailUrlLinktext;
	}

	public String getThumbnailUrlType() {
		return thumbnailUrlType;
	}

	public void setThumbnailUrlType(String thumbnailUrlType) {
		this.thumbnailUrlType = thumbnailUrlType;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool2() {
		return school2;
	}

	public void setSchool2(String school2) {
		this.school2 = school2;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob2() {
		return job2;
	}

	public void setJob2(String job2) {
		this.job2 = job2;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getBook2() {
		return book2;
	}

	public void setBook2(String book2) {
		this.book2 = book2;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getCar2() {
		return car2;
	}

	public void setCar2(String car2) {
		this.car2 = car2;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHero2() {
		return hero2;
	}

	public void setHero2(String hero2) {
		this.hero2 = hero2;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getInterest2() {
		return interest2;
	}

	public void setInterest2(String interest2) {
		this.interest2 = interest2;
	}

	public String getJobInterest() {
		return jobInterest;
	}

	public void setJobInterest(String jobInterest) {
		this.jobInterest = jobInterest;
	}

	public String getLanguageSpoken() {
		return languageSpoken;
	}

	public void setLanguageSpoken(String languageSpoken) {
		this.languageSpoken = languageSpoken;
	}

	public String getLanguageSpoken2() {
		return languageSpoken2;
	}

	public void setLanguageSpoken2(String languageSpoken2) {
		this.languageSpoken2 = languageSpoken2;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getMovie2() {
		return movie2;
	}

	public void setMovie2(String movie2) {
		this.movie2 = movie2;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getMusic2() {
		return music2;
	}

	public void setMusic2(String music2) {
		this.music2 = music2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneType2() {
		return phoneType2;
	}

	public void setPhoneType2(String phoneType2) {
		this.phoneType2 = phoneType2;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuote2() {
		return quote2;
	}

	public void setQuote2(String quote2) {
		this.quote2 = quote2;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getSport2() {
		return sport2;
	}

	public void setSport2(String sport2) {
		this.sport2 = sport2;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTurnOff() {
		return turnOff;
	}

	public void setTurnOff(String turnOff) {
		this.turnOff = turnOff;
	}

	public String getTurnOff2() {
		return turnOff2;
	}

	public void setTurnOff2(String turnOff2) {
		this.turnOff2 = turnOff2;
	}

	public String getTurnOn() {
		return turnOn;
	}

	public void setTurnOn(String turnOn) {
		this.turnOn = turnOn;
	}

	public String getTurnOn2() {
		return turnOn2;
	}

	public void setTurnOn2(String turnOn2) {
		this.turnOn2 = turnOn2;
	}

	public String getTvShow() {
		return tvShow;
	}

	public void setTvShow(String tvShow) {
		this.tvShow = tvShow;
	}

	public String getTvShow2() {
		return tvShow2;
	}

	public void setTvShow2(String tvShow2) {
		this.tvShow2 = tvShow2;
	}

	public String getPersonalInfoOpen() {
		return personalInfoOpen;
	}

	public void setPersonalInfoOpen(String personalInfoOpen) {
		this.personalInfoOpen = personalInfoOpen;
	}

	public String getFavoriteGadgetListOpen() {
		return favoriteGadgetListOpen;
	}

	public void setFavoriteGadgetListOpen(String favoriteGadgetListOpen) {
		this.favoriteGadgetListOpen = favoriteGadgetListOpen;
	}
	
	
}
