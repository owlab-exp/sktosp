package com.skt.opensocial.persistence;

import java.util.Date;

public class Person {
	private String personId;
	// Jun 23
	private Date updated;
	private String aboutMe;
	private int age;
	private Date birthday;
	private String bodyTypeBuild;
	private String bodyTypeEyeColor;
	private String bodyTypaHairColor;
	private Double bodyTypeHeight;
	private Double bodyTypeWeight;
	private String childern;
	private String currentLocationCountry;
	private Double currentLocationLatitude;
	private Double currentLocationLongitude;
	private String currentLocationLocality;
	private String currentLocationPostalcode;
	private String currentLocationRegion;
	private String currentLocationStreetAddress;
	private String currentLocationType;
	private String currentLocationFormatted;
	private boolean currentLocationPrimary;
	private String displayName;
	private String drinker;
	private String ethnicity;
	private String fashion;
	private String gender;
	private String happiestWhen;
	private boolean hasApp;
	private String humor;
	private String jobinterests;
	private String livingArrangement;
	private String nameAdditionalName;
	private String nameFamilyName;
	
	private String nameGivenName;
	private String nameHonorificPrefix;
	private String nameHonorificSurfix;
	private String nameFormatted;
	private String networkPresence;
	private String nickname;
	private String pets;
	private String politicalViews;
	private String preferredUserName;
	private String profileSongUrl;
	private String profilevideoUrl;
	private String relationshipsStatus;
	private String religion;
	private String romance;
	private String scaredOf;
	private String sexualOrientation;
	private String smoker;
	private String status;
	private Double utcOffset;
	private String profileUrl;
	private String thumbnailUrl;
	
	private AdditionalInfo1 additionalInfo1;
	private AdditionalInfo2 additionalInfo2;

	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getName() {
		return getNameFormatted();
	}
	public void setName(String name) {
		setNameFormatted(name);
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBodyTypeBuild() {
		return bodyTypeBuild;
	}
	public void setBodyTypeBuild(String bodyTypeBuild) {
		this.bodyTypeBuild = bodyTypeBuild;
	}
	public String getBodyTypeEyeColor() {
		return bodyTypeEyeColor;
	}
	public void setBodyTypeEyeColor(String bodyTypeEyeColor) {
		this.bodyTypeEyeColor = bodyTypeEyeColor;
	}
	public String getBodyTypaHairColor() {
		return bodyTypaHairColor;
	}
	public void setBodyTypaHairColor(String bodyTypaHairColor) {
		this.bodyTypaHairColor = bodyTypaHairColor;
	}
	public Double getBodyTypeHeight() {
		return bodyTypeHeight;
	}
	public void setBodyTypeHeight(Double bodyTypeHeight) {
		this.bodyTypeHeight = bodyTypeHeight;
	}
	public Double getBodyTypeWeight() {
		return bodyTypeWeight;
	}
	public void setBodyTypeWeight(Double bodyTypeWeight) {
		this.bodyTypeWeight = bodyTypeWeight;
	}
	
	public String getCurrentLocationCountry() {
		return currentLocationCountry;
	}
	public void setCurrentLocationCountry(String currentLocationCountry) {
		this.currentLocationCountry = currentLocationCountry;
	}
	public Double getCurrentLocationLatitude() {
		return currentLocationLatitude;
	}
	public void setCurrentLocationLatitude(Double currentLocationLatitude) {
		this.currentLocationLatitude = currentLocationLatitude;
	}
	public Double getCurrentLocationLongitude() {
		return currentLocationLongitude;
	}
	public void setCurrentLocationLongitude(Double currentLocationLongitude) {
		this.currentLocationLongitude = currentLocationLongitude;
	}
	public String getCurrentLocationLocality() {
		return currentLocationLocality;
	}
	public void setCurrentLocationLocality(String currentLocationLocality) {
		this.currentLocationLocality = currentLocationLocality;
	}
	public String getCurrentLocationPostalcode() {
		return currentLocationPostalcode;
	}
	public void setCurrentLocationPostalcode(String currentLocationPostalcode) {
		this.currentLocationPostalcode = currentLocationPostalcode;
	}
	public String getCurrentLocationRegion() {
		return currentLocationRegion;
	}
	public void setCurrentLocationRegion(String currentLocationRegion) {
		this.currentLocationRegion = currentLocationRegion;
	}
	public String getCurrentLocationStreetAddress() {
		return currentLocationStreetAddress;
	}
	public void setCurrentLocationStreetAddress(String currentLocationStreetAddress) {
		this.currentLocationStreetAddress = currentLocationStreetAddress;
	}
	public String getCurrentLocationType() {
		return currentLocationType;
	}
	public void setCurrentLocationType(String currentLocationType) {
		this.currentLocationType = currentLocationType;
	}
	public String getCurrentLocationFormatted() {
		return currentLocationFormatted;
	}
	public void setCurrentLocationFormatted(String currentLocationFormatted) {
		this.currentLocationFormatted = currentLocationFormatted;
	}
	public boolean isCurrentLocationPrimary() {
		return currentLocationPrimary;
	}
	public void setCurrentLocationPrimary(boolean currentLocationPrimary) {
		this.currentLocationPrimary = currentLocationPrimary;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDrinker() {
		return drinker;
	}
	public void setDrinker(String drinker) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHappiestWhen() {
		return happiestWhen;
	}
	public void setHappiestWhen(String happiestWhen) {
		this.happiestWhen = happiestWhen;
	}
	public boolean isHasApp() {
		return hasApp;
	}
	public void setHasApp(boolean hasApp) {
		this.hasApp = hasApp;
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
	public String getLivingArrangement() {
		return livingArrangement;
	}
	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}
	public String getNameAdditionalName() {
		return nameAdditionalName;
	}
	public void setNameAdditionalName(String nameAdditionalName) {
		this.nameAdditionalName = nameAdditionalName;
	}
	public String getNameGivenName() {
		return nameGivenName;
	}
	public void setNameGivenName(String nameGivenName) {
		this.nameGivenName = nameGivenName;
	}
	public String getNameHonorificPrefix() {
		return nameHonorificPrefix;
	}
	public void setNameHonorificPrefix(String nameHonorificPrefix) {
		this.nameHonorificPrefix = nameHonorificPrefix;
	}
	public String getNameHonorificSurfix() {
		return nameHonorificSurfix;
	}
	public void setNameHonorificSurfix(String nameHonorificSurfix) {
		this.nameHonorificSurfix = nameHonorificSurfix;
	}
	public String getNameFormatted() {
		return nameFormatted;
	}
	public void setNameFormatted(String nameFormatted) {
		this.nameFormatted = nameFormatted;
	}
	public String getNetworkPresence() {
		return networkPresence;
	}
	public void setNetworkPresence(String networkPresence) {
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
	public String getPreferredUserName() {
		return preferredUserName;
	}
	public void setPreferredUserName(String preferredUserName) {
		this.preferredUserName = preferredUserName;
	}
	public String getProfileSongUrl() {
		return profileSongUrl;
	}
	public void setProfileSongUrl(String profileSongUrl) {
		this.profileSongUrl = profileSongUrl;
	}
	public String getProfilevideoUrl() {
		return profilevideoUrl;
	}
	public void setProfilevideoUrl(String profilevideoUrl) {
		this.profilevideoUrl = profilevideoUrl;
	}
	public String getRelationshipsStatus() {
		return relationshipsStatus;
	}
	public void setRelationshipsStatus(String relationshipsStatus) {
		this.relationshipsStatus = relationshipsStatus;
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
	public String getSmoker() {
		return smoker;
	}
	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(Double utcOffset) {
		this.utcOffset = utcOffset;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getChildern() {
		return childern;
	}
	public void setChildern(String childern) {
		this.childern = childern;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}	
	public String getNameFamilyName() {
		return nameFamilyName;
	}
	public void setNameFamilyName(String nameFamilyName) {
		this.nameFamilyName = nameFamilyName;
	}
}
