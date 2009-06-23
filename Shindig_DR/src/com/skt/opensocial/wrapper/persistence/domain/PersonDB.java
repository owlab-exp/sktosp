/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.skt.opensocial.wrapper.persistence.domain;


import org.apache.shindig.social.opensocial.model.Account;
import org.apache.shindig.social.opensocial.model.Address;
import org.apache.shindig.social.opensocial.model.Drinker;
import org.apache.shindig.social.opensocial.model.ListField;
import org.apache.shindig.social.opensocial.model.LookingFor;
import org.apache.shindig.social.opensocial.model.Name;
import org.apache.shindig.social.opensocial.model.NetworkPresence;
import org.apache.shindig.social.opensocial.model.Smoker;
import org.apache.shindig.social.opensocial.model.Url;
import org.apache.shindig.social.opensocial.model.Organization;
import org.apache.shindig.social.opensocial.model.Person.Gender;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Default Implementation of the Person object in the model.
 */
public class PersonDB {
  private String aboutMe;
  
  //to be implemented in DB
  private List<Account> accounts;
  private List<String> activities;
  private List<Address> addresses;
  
  private Integer age;
  
  //to be implemented in DB
  private Map<String, ? extends Object> appData;
  
  private Date birthday;

  /* BodyType Details */
  private String bodyType_build;
  private String bodyType_eyeColor;
  private String bodyType_hairColor;
  private Float bodyType_height;
  private Float bodyType_weight;
  
  private List<String> books;
  private List<String> cars;
  private String children;
  
  /* CurrentLocation Details */
  private String currentLocation_country;
  private Float currentLocation_latitude;
  private Float currentLocation_longitude;
  private String currentLocation_locality;
  private String currentLocation_postalCode;
  private String currentLocation_region;
  private String currentLocation_streetAddress;
  private String currentLocation_type;
  private String currentLocation_formatted;
  private Boolean currentLocation_primary;
  
  private String displayName;
  private Drinker drinker;			//private Enum<Drinker> drinker;
  
  //to be implemented in DB
  private List<ListField> emails;
  
  private String ethnicity;
  private String fashion;
  private List<String> food;
  private Gender gender;			//private Gender gender;
  private String happiestWhen;
  private Boolean hasApp;
  private List<String> heroes;
  private String humor;
  private String id;
  
  // to be implemented in DB
  private List<ListField> ims;
  
  private List<String> interests;
  private String jobInterests;
  private List<String> languagesSpoken;
  private String livingArrangement;
  private List<LookingFor> lookingFor;		//private List<Enum<LookingFor>> lookingFor;
  private List<String> movies;
  private List<String> music;

  /* Name Details */
  private String name_additionalName;
  private String name_familyName;
  private String name_givenName;
  private String name_honorificPrefix;
  private String name_honorificSuffix;
  private String name_formatted;
  
  private NetworkPresence networkPresence;	//private Enum<NetworkPresence> networkPresence;
  private String nickName;
  private List<Organization> organizations;
  private String pets;
  
  // to be implemented in DB 
  private List<ListField> phoneNumbers;
  private List<ListField> photos;
  
  private String politicalViews;
  private String preferredUsername;
  private String profileSongUrl;	//private Url profileSong;
  private String profileVideoUrl;	//private Url profileVideo;
  private List<String> quotes;
  private String relationshipStatus;
  private String religion;
  private String romance;
  private String scaredOf;
  private String sexualOrientation;
  private Smoker smoker;			//private Enum<Smoker> smoker;
  private List<String> sports;
  private String status;
  private List<String> tags;
  private Long utcOffset;
  private List<String> turnOffs;
  private List<String> turnOns;
  private List<String> tvShows;
  private Date updated;
  private List<Url> urls;
  
  /* additional urls that are not parameters of Person but can be obtained from the parameters */
  private String profileUrl;
  private String thumbnailUrl;

  public PersonDB() {
  }

  /**
   * A constructor which contains all of the required fields on a person object
   * @param id The id of the person
   * @param displayName The displayName of the person
   * @param name The person's name broken down into components
   */
  public PersonDB(String id, String displayName, Name name) {
    this.id = id;
    this.displayName = displayName;
    this.name_additionalName = name.getAdditionalName();
    this.name_familyName = name.getFamilyName();
    this.name_givenName = name.getGivenName();
    this.name_honorificPrefix = name.getHonorificPrefix();
    this.name_honorificSuffix = name.getHonorificSuffix();
    this.name_formatted = name.getFormatted();
  }

  public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public List<String> getActivities() {
    return activities;
  }

  public void setActivities(List<String> activities) {
    this.activities = activities;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Map<String, ? extends Object> getAppData() {
    return this.appData;
  }
  
  public void setAppData(Map<String, ? extends Object> appData) {
    this.appData = appData;
  }

  public String getBodyType_build() {
    return bodyType_build;
  }

  public void setBodyType_build(String bodyType_build) {
    this.bodyType_build = bodyType_build;
  }
  
  public String getBodyType_eyeColor() {
    return bodyType_eyeColor;
  }

  public void setBodyType_eyeColor(String bodyType_eyeColor) {
    this.bodyType_eyeColor = bodyType_eyeColor;
  }
  
  public String getBodyType_hairColor() {
    return bodyType_hairColor;
  }

  public void setBodyType_hairColor(String bodyType_hairColor) {
  this.bodyType_hairColor = bodyType_hairColor;
}
  
  public float getBodyType_height() {
    return bodyType_height;
  }

  public void setBodyType_height(float bodyType_height) {
    this.bodyType_height = bodyType_height;
  }
  
  public float getBodyType_weight() {
	    return bodyType_weight;
	  }

  public void setBodyType_weight(float bodyType_weight) {
    this.bodyType_weight = bodyType_weight;
  }

  public List<String> getBooks() {
    return books;
  }

  public void setBooks(List<String> books) {
    this.books = books;
  }

  public List<String> getCars() {
    return cars;
  }

  public void setCars(List<String> cars) {
    this.cars = cars;
  }

  public String getChildren() {
    return children;
  }

  public void setChildren(String children) {
    this.children = children;
  }

  public String getCurrentLocation_country() {
    return currentLocation_country;
  }

  public void setCurrentLocation_country(String currentLocation_country) {
    this.currentLocation_country = currentLocation_country;
  }
  
  public float getCurrentLocation_latitude() {
    return currentLocation_latitude;
  }

  public void setCurrentLocation_latitude(float currentLocation_latitude) {
    this.currentLocation_latitude = currentLocation_latitude;
  }
  
  public float getCurrentLocation_longitude() {
    return currentLocation_longitude;
  }
  
  public void setCurrentLocation_longitude(float currentLocation_longitude) {
	this.currentLocation_longitude = currentLocation_longitude;
  }
  
  public String getCurrentLocation_locality() {
    return currentLocation_locality;
  }

  public void setCurrentLocation_locality(String currentLocation_locality) {
    this.currentLocation_locality = currentLocation_locality;
  }
  
  public String getCurrentLocation_postalCode() {
    return currentLocation_postalCode;
  }

  public void setCurrentLocation_postalCode(String currentLocation_postalCode) {
    this.currentLocation_postalCode = currentLocation_postalCode;
  }
  
  public String getCurrentLocation_region() {
    return currentLocation_region;
  }

  public void setCurrentLocation_region(String currentLocation_region) {
    this.currentLocation_region = currentLocation_region;
  }
  
  public String getCurrentLocation_streetAddress() {
    return currentLocation_streetAddress;
  }

  public void setCurrentLocation_streetAddress(String currentLocation_streetAddress) {
    this.currentLocation_streetAddress = currentLocation_streetAddress;
  }
  
  public String getCurrentLocation_type() {
    return currentLocation_type;
  }

  public void setCurrentLocation_type(String currentLocation_type) {
    this.currentLocation_type = currentLocation_type;
  }
  
  public String getCurrentLocation_formatted() {
    return currentLocation_formatted;
  }

  public void setCurrentLocation_formatted(String currentLocation_formatted) {
    this.currentLocation_formatted = currentLocation_formatted;
  }
  
  public Boolean getCurrentLocation_primary() {
    return currentLocation_primary;
  }

  public void setCurrentLocation_primary(Boolean currentLocation_primary) {
    this.currentLocation_primary = currentLocation_primary;
  }

  public Date getBirthday() {
    if (birthday == null) {
      return null;
    }
    return new Date(birthday.getTime());
  }

  public void setBirthday(Date birthday) {
    if (birthday == null) {
      this.birthday = null;
    } else {
      this.birthday = new Date(birthday.getTime());
    }
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Drinker getDrinker() {
    return this.drinker;
  }

  public void setDrinker(Drinker newDrinker) {
    this.drinker = newDrinker;
  }

  public List<ListField> getEmails() {
    return emails;
  }

  public void setEmails(List<ListField> emails) {
    this.emails = emails;
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

  public List<String> getFood() {
    return food;
  }

  public void setFood(List<String> food) {
    this.food = food;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender newGender) {
    this.gender = newGender;
  }

  public String getHappiestWhen() {
    return happiestWhen;
  }

  public void setHappiestWhen(String happiestWhen) {
    this.happiestWhen = happiestWhen;
  }

  public Boolean getHasApp() {
    return hasApp;
  }

  public void setHasApp(Boolean hasApp) {
    this.hasApp = hasApp;
  }

  public List<String> getHeroes() {
    return heroes;
  }

  public void setHeroes(List<String> heroes) {
    this.heroes = heroes;
  }

  public String getHumor() {
    return humor;
  }

  public void setHumor(String humor) {
    this.humor = humor;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<ListField> getIms() {
    return ims;
  }

  public void setIms(List<ListField> ims) {
    this.ims = ims;
  }

  public List<String> getInterests() {
    return interests;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  public String getJobInterests() {
    return jobInterests;
  }

  public void setJobInterests(String jobInterests) {
    this.jobInterests = jobInterests;
  }

  public List<String> getLanguagesSpoken() {
    return languagesSpoken;
  }

  public void setLanguagesSpoken(List<String> languagesSpoken) {
    this.languagesSpoken = languagesSpoken;
  }

  public Date getUpdated() {
    if (updated == null) {
      return null;
    }
    return new Date(updated.getTime());
  }

  public void setUpdated(Date updated) {
    if (updated == null) {
      this.updated = null;
    } else {
      this.updated = new Date(updated.getTime());
    }
  }

  public String getLivingArrangement() {
    return livingArrangement;
  }

  public void setLivingArrangement(String livingArrangement) {
    this.livingArrangement = livingArrangement;
  }

  public List<LookingFor> getLookingFor() {
    return lookingFor;
  }

  public void setLookingFor(List<LookingFor> lookingFor) {
    this.lookingFor = lookingFor;
  }

  public List<String> getMovies() {
    return movies;
  }

  public void setMovies(List<String> movies) {
    this.movies = movies;
  }

  public List<String> getMusic() {
    return music;
  }

  public void setMusic(List<String> music) {
    this.music = music;
  }

  public String getName_addtionalName() {
    return name_additionalName;
  }

  public void setName_additionalName(String name_additionalName) {
    this.name_additionalName = name_additionalName;
  }
  
  public String getName_familyName() {
    return name_familyName;
  }

  public void setName_familyName(String name_familyName) {
    this.name_familyName = name_familyName;
  }
  
  public String getName_givenName() {
    return name_givenName;
  }

  public void setName_givenName(String name_givenName) {
    this.name_givenName = name_givenName;
  }
  
  public String getName_honorificPrefix() {
    return name_honorificPrefix;
  }

  public void setName_honorificPrefix(String name_honorificPrefix) {
    this.name_honorificPrefix = name_honorificPrefix;
  }
  
  public String getName_honorificSuffix() {
    return name_honorificSuffix;
  }

  public void setName_honorificSuffix(String name_honorificSuffix) {
    this.name_honorificSuffix = name_honorificSuffix;
  }
  
  public String getName_formatted() {
    return name_formatted;
  }

  public void setName_formatted(String name_formatted) {
    this.name_formatted = name_formatted;
  }

  public NetworkPresence getNetworkPresence() {
    return networkPresence;
  }

  public void setNetworkPresence(NetworkPresence networkPresence) {
    this.networkPresence = networkPresence;
  }

  public String getNickname() {
    return nickName;
  }

  public void setNickname(String nickname) {
    this.nickName = nickname;
  }

  public List<Organization> getOrganizations() {
    return organizations;
  }

  public void setOrganizations(List<Organization> organizations) {
    this.organizations = organizations;
  }

  public String getPets() {
    return pets;
  }

  public void setPets(String pets) {
    this.pets = pets;
  }

  public List<ListField> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<ListField> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public List<ListField> getPhotos() {
    return photos;
  }

  public void setPhotos(List<ListField> photos) {
    this.photos = photos;
  }

  public String getPoliticalViews() {
    return politicalViews;
  }

  public void setPoliticalViews(String politicalViews) {
    this.politicalViews = politicalViews;
  }
  
  public String getPreferredUsername() {
    return preferredUsername;
  }

  public void setPreferredUsername(String preferredUsername) {
    this.preferredUsername = preferredUsername;
  }

  public String getProfileSongUrl() {
    return profileSongUrl;
  }

  public void setProfileSongUrl(String profileSongUrl) {
    this.profileSongUrl = profileSongUrl;
  }

  public String getProfileVideoUrl() {
    return profileVideoUrl;
  }

  public void setProfileVideoUrl(String profileVideoUrl) {
    this.profileVideoUrl = profileVideoUrl;
  }

  public List<String> getQuotes() {
    return quotes;
  }

  public void setQuotes(List<String> quotes) {
    this.quotes = quotes;
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

  public Smoker getSmoker() {
    return this.smoker;
  }

  public void setSmoker(Smoker newSmoker) {
    this.smoker = newSmoker;
  }

  public List<String> getSports() {
    return sports;
  }

  public void setSports(List<String> sports) {
    this.sports = sports;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Long getUtcOffset() {
    return utcOffset;
  }

  public void setUtcOffset(Long utcOffset) {
    this.utcOffset = utcOffset;
  }

  public List<String> getTurnOffs() {
    return turnOffs;
  }

  public void setTurnOffs(List<String> turnOffs) {
    this.turnOffs = turnOffs;
  }

  public List<String> getTurnOns() {
    return turnOns;
  }

  public void setTurnOns(List<String> turnOns) {
    this.turnOns = turnOns;
  }
  public List<String> getTvShows() {
    return tvShows;
  }

  public void setTvShows(List<String> tvShows) {
    this.tvShows = tvShows;
  }

  public List<Url> getUrls() {
    return urls;
  }

  public void setUrls(List<Url> urls) {
    this.urls = urls;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

}
