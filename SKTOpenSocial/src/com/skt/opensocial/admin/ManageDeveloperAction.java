package com.skt.opensocial.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.classic.Session;

import com.skt.opensocial.common.GadgetRegisterTypeMap;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.developer.RegisterGadgetAction;
import com.skt.opensocial.persistence.Activity;
import com.skt.opensocial.persistence.Address;
import com.skt.opensocial.persistence.DrinkerEnum;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.GenderEnum;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.NetworkpresenceEnum;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAccount;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.PersonAppData;
import com.skt.opensocial.persistence.PersonOrganization;
import com.skt.opensocial.persistence.PersonUrl;
import com.skt.opensocial.persistence.SmokerEnum;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.persistence.UserVisibility;

public class ManageDeveloperAction extends DeveloperBaseAction implements RequestAware {
	private Logger logger = Logger.getLogger(ManageDeveloperAction.class);
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	private String user_id;
	private boolean isDeveloper;
	private boolean isAdministrator;
	private String password;
	private Date registeredDate;
	private Person person;
	private UserVisibility userVisibility;
	private Set<GadgetReview> reviews;
	private Set<Gadget> gadgets = new HashSet<Gadget>();
	private Set<Gadget> favoriteGadgets = new HashSet<Gadget>();
	//private Set<User> friends = new HashSet<User>();
	private Set<User> friendsByMe = new HashSet<User>();
	private Set<User> friendsByOther = new HashSet<User>();

	private String person_id;
	private User user;
	private Date updated;
	private String aboutme;
	private Integer age;
	private Date birthday;
	private String bodytypeBuild;
	private String bodytypeEyecolor;
	private String bodytypeHaircolor;
	private Double bodytypeHeight;
	private Double bodytypeWeight;
	private String children;
	private String currentlocationCountry;
	private Double currentlocationLatitude;
	private Double currentlocationLongitude;
	private String currentlocationLocality;
	private String currentlocationPostalcode;
	private String currentlocationRegion;
	private String currentlocationStreetaddress;
	private String currentlocationType;
	private String currentlocationFormatted;
	private Boolean currentlocationPrimary;
	private String displayname;
	//private String drinker;
	private DrinkerEnum drinker;
	private String ethnicity;
	private String fashion;
	//private String gender;
	private GenderEnum gender;
	private String happiestwhen;
	private Boolean hasapp;
	private String humor;
	private String jobinterests;
	private String livingarrangement;
	private String nameAdditionalname;
	private String nameFamilyname;
	private String nameGivenname;
	private String nameHonorificprefix;
	private String nameHonorificsuffix;
	private String nameFormatted;
	//private String networkpresence;
	private NetworkpresenceEnum networkpresence;
	private String nickname;
	private String pets;
	private String politicalviews;
	private String preferredusername;
	private String relationshipstatus;
	private String religion;
	private String romance;
	private String scaredof;
	private String sexualorientation;
	//private String smoker;
	private SmokerEnum smoker;
	private String status;
	private Double utcoffset;
	private String profilesongurlValue;
	private String profilesongurlLinkText;
	private String profilesongurlType;
	private String profilesongurlPrimary;
	private String profilevideourlValue;
	private String profilevideourlLinkText;
	private String profilevideourlType;
	private String profilevideourlPrimary;
	private String profilesongurl;
	private String profilevideourl;
	private String profileurl;
	private String thumbnailurl;
	private Set<PersonAdditionalInfo1> additionalInfo1s;
	private Set<PersonAdditionalInfo2> additionalInfo2s;
	private Set<PersonAccount> accounts;
	private Set<Address> addresses;
	private Set<PersonOrganization> organizations;
	private Set<Activity> activities = new HashSet<Activity>();
	private Set<PersonAppData> appData;
	private Set<PersonUrl> urls;
	
	protected Map<String, Object> requestMap;
	
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public UserVisibility getUserVisibility() {
		return userVisibility;
	}
	public void setUserVisibility(UserVisibility userVisibility) {
		this.userVisibility = userVisibility;
	}
	public Set<GadgetReview> getReviews() {
		return reviews;
	}
	public void setReviews(Set<GadgetReview> reviews) {
		this.reviews = reviews;
	}
	public Set<Gadget> getGadgets() {
		return gadgets;
	}
	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}
	public Set<Gadget> getFavoriteGadgets() {
		return favoriteGadgets;
	}
	public void setFavoriteGadgets(Set<Gadget> favoriteGadgets) {
		this.favoriteGadgets = favoriteGadgets;
	}
	public Set<User> getFriendsByMe() {
		return friendsByMe;
	}
	public void setFriendsByMe(Set<User> friendsByMe) {
		this.friendsByMe = friendsByMe;
	}
	public Set<User> getFriendsByOther() {
		return friendsByOther;
	}
	public void setFriendsByOther(Set<User> friendsByOther) {
		this.friendsByOther = friendsByOther;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public Double getBodytypeHeight() {
		return bodytypeHeight;
	}
	public void setBodytypeHeight(Double bodytypeHeight) {
		this.bodytypeHeight = bodytypeHeight;
	}
	public Double getBodytypeWeight() {
		return bodytypeWeight;
	}
	public void setBodytypeWeight(Double bodytypeWeight) {
		this.bodytypeWeight = bodytypeWeight;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getCurrentlocationCountry() {
		return currentlocationCountry;
	}
	public void setCurrentlocationCountry(String currentlocationCountry) {
		this.currentlocationCountry = currentlocationCountry;
	}
	public Double getCurrentlocationLatitude() {
		return currentlocationLatitude;
	}
	public void setCurrentlocationLatitude(Double currentlocationLatitude) {
		this.currentlocationLatitude = currentlocationLatitude;
	}
	public Double getCurrentlocationLongitude() {
		return currentlocationLongitude;
	}
	public void setCurrentlocationLongitude(Double currentlocationLongitude) {
		this.currentlocationLongitude = currentlocationLongitude;
	}
	public String getCurrentlocationLocality() {
		return currentlocationLocality;
	}
	public void setCurrentlocationLocality(String currentlocationLocality) {
		this.currentlocationLocality = currentlocationLocality;
	}
	public String getCurrentlocationPostalcode() {
		return currentlocationPostalcode;
	}
	public void setCurrentlocationPostalcode(String currentlocationPostalcode) {
		this.currentlocationPostalcode = currentlocationPostalcode;
	}
	public String getCurrentlocationRegion() {
		return currentlocationRegion;
	}
	public void setCurrentlocationRegion(String currentlocationRegion) {
		this.currentlocationRegion = currentlocationRegion;
	}
	public String getCurrentlocationStreetaddress() {
		return currentlocationStreetaddress;
	}
	public void setCurrentlocationStreetaddress(String currentlocationStreetaddress) {
		this.currentlocationStreetaddress = currentlocationStreetaddress;
	}
	public String getCurrentlocationType() {
		return currentlocationType;
	}
	public void setCurrentlocationType(String currentlocationType) {
		this.currentlocationType = currentlocationType;
	}
	public String getCurrentlocationFormatted() {
		return currentlocationFormatted;
	}
	public void setCurrentlocationFormatted(String currentlocationFormatted) {
		this.currentlocationFormatted = currentlocationFormatted;
	}
	public Boolean getCurrentlocationPrimary() {
		return currentlocationPrimary;
	}
	public void setCurrentlocationPrimary(Boolean currentlocationPrimary) {
		this.currentlocationPrimary = currentlocationPrimary;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
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
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public String getHappiestwhen() {
		return happiestwhen;
	}
	public void setHappiestwhen(String happiestwhen) {
		this.happiestwhen = happiestwhen;
	}
	public Boolean getHasapp() {
		return hasapp;
	}
	public void setHasapp(Boolean hasapp) {
		this.hasapp = hasapp;
	}
	public String getHumor() {
		return humor;
	}
	public void setHumor(String humor) {
		this.humor = humor;
	}
	public String getJobinterests() {
		return jobinterests;
	}
	public void setJobinterests(String jobinterests) {
		this.jobinterests = jobinterests;
	}
	public String getLivingarrangement() {
		return livingarrangement;
	}
	public void setLivingarrangement(String livingarrangement) {
		this.livingarrangement = livingarrangement;
	}
	public String getNameAdditionalname() {
		return nameAdditionalname;
	}
	public void setNameAdditionalname(String nameAdditionalname) {
		this.nameAdditionalname = nameAdditionalname;
	}
	public String getNameFamilyname() {
		return nameFamilyname;
	}
	public void setNameFamilyname(String nameFamilyname) {
		this.nameFamilyname = nameFamilyname;
	}
	public String getNameGivenname() {
		return nameGivenname;
	}
	public void setNameGivenname(String nameGivenname) {
		this.nameGivenname = nameGivenname;
	}
	public String getNameHonorificprefix() {
		return nameHonorificprefix;
	}
	public void setNameHonorificprefix(String nameHonorificprefix) {
		this.nameHonorificprefix = nameHonorificprefix;
	}
	public String getNameHonorificsuffix() {
		return nameHonorificsuffix;
	}
	public void setNameHonorificsuffix(String nameHonorificsuffix) {
		this.nameHonorificsuffix = nameHonorificsuffix;
	}
	public String getNameFormatted() {
		return nameFormatted;
	}
	public void setNameFormatted(String nameFormatted) {
		this.nameFormatted = nameFormatted;
	}
	public NetworkpresenceEnum getNetworkpresence() {
		return networkpresence;
	}
	public void setNetworkpresence(NetworkpresenceEnum networkpresence) {
		this.networkpresence = networkpresence;
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
	public String getPoliticalviews() {
		return politicalviews;
	}
	public void setPoliticalviews(String politicalviews) {
		this.politicalviews = politicalviews;
	}
	public String getPreferredusername() {
		return preferredusername;
	}
	public void setPreferredusername(String preferredusername) {
		this.preferredusername = preferredusername;
	}
	public String getRelationshipstatus() {
		return relationshipstatus;
	}
	public void setRelationshipstatus(String relationshipstatus) {
		this.relationshipstatus = relationshipstatus;
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
	public String getScaredof() {
		return scaredof;
	}
	public void setScaredof(String scaredof) {
		this.scaredof = scaredof;
	}
	public String getSexualorientation() {
		return sexualorientation;
	}
	public void setSexualorientation(String sexualorientation) {
		this.sexualorientation = sexualorientation;
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
	public Double getUtcoffset() {
		return utcoffset;
	}
	public void setUtcoffset(Double utcoffset) {
		this.utcoffset = utcoffset;
	}
	public String getProfilesongurlValue() {
		return profilesongurlValue;
	}
	public void setProfilesongurlValue(String profilesongurlValue) {
		this.profilesongurlValue = profilesongurlValue;
	}
	public String getProfilesongurlLinkText() {
		return profilesongurlLinkText;
	}
	public void setProfilesongurlLinkText(String profilesongurlLinkText) {
		this.profilesongurlLinkText = profilesongurlLinkText;
	}
	public String getProfilesongurlType() {
		return profilesongurlType;
	}
	public void setProfilesongurlType(String profilesongurlType) {
		this.profilesongurlType = profilesongurlType;
	}
	public String getProfilesongurlPrimary() {
		return profilesongurlPrimary;
	}
	public void setProfilesongurlPrimary(String profilesongurlPrimary) {
		this.profilesongurlPrimary = profilesongurlPrimary;
	}
	public String getProfilevideourlValue() {
		return profilevideourlValue;
	}
	public void setProfilevideourlValue(String profilevideourlValue) {
		this.profilevideourlValue = profilevideourlValue;
	}
	public String getProfilevideourlLinkText() {
		return profilevideourlLinkText;
	}
	public void setProfilevideourlLinkText(String profilevideourlLinkText) {
		this.profilevideourlLinkText = profilevideourlLinkText;
	}
	public String getProfilevideourlType() {
		return profilevideourlType;
	}
	public void setProfilevideourlType(String profilevideourlType) {
		this.profilevideourlType = profilevideourlType;
	}
	public String getProfilevideourlPrimary() {
		return profilevideourlPrimary;
	}
	public void setProfilevideourlPrimary(String profilevideourlPrimary) {
		this.profilevideourlPrimary = profilevideourlPrimary;
	}
	public String getProfilesongurl() {
		return profilesongurl;
	}
	public void setProfilesongurl(String profilesongurl) {
		this.profilesongurl = profilesongurl;
	}
	public String getProfilevideourl() {
		return profilevideourl;
	}
	public void setProfilevideourl(String profilevideourl) {
		this.profilevideourl = profilevideourl;
	}
	public String getProfileurl() {
		return profileurl;
	}
	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}
	public String getThumbnailurl() {
		return thumbnailurl;
	}
	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}
	public Set<PersonAdditionalInfo1> getAdditionalInfo1s() {
		return additionalInfo1s;
	}
	public void setAdditionalInfo1s(Set<PersonAdditionalInfo1> additionalInfo1s) {
		this.additionalInfo1s = additionalInfo1s;
	}
	public Set<PersonAdditionalInfo2> getAdditionalInfo2s() {
		return additionalInfo2s;
	}
	public void setAdditionalInfo2s(Set<PersonAdditionalInfo2> additionalInfo2s) {
		this.additionalInfo2s = additionalInfo2s;
	}
	public Set<PersonAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<PersonAccount> accounts) {
		this.accounts = accounts;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<PersonOrganization> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(Set<PersonOrganization> organizations) {
		this.organizations = organizations;
	}
	public Set<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	public Set<PersonAppData> getAppData() {
		return appData;
	}
	public void setAppData(Set<PersonAppData> appData) {
		this.appData = appData;
	}
	public Set<PersonUrl> getUrls() {
		return urls;
	}
	public void setUrls(Set<PersonUrl> urls) {
		this.urls = urls;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		this.requestMap = requestMap;
	}
}
