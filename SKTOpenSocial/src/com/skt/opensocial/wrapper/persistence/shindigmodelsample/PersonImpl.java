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
package com.skt.opensocial.wrapper.persistence.shindigmodelsample;




import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Default Implementation of the Person object in the model.
 */
public class PersonImpl {
  private String aboutMe;
  private String name;
  private List<String> activities;
  
  private Integer age;
  private Map<String, ? extends Object> appData;
  private Date birthday;
  
  private List<String> books;
  private List<String> cars;
  private String children;
  
  private String displayName;
  
  
  private String ethnicity;
  private String fashion;
  private List<String> food;
  
  private String happiestWhen;
  private Boolean hasApp;
  private List<String> heroes;
  private String humor;
  private String id;
   
  private List<String> interests;
  private String jobInterests;
  private List<String> languagesSpoken;
  private String livingArrangement;
  
  private List<String> movies;
  private List<String> music;
  
  
  private String nickname;
  
  private String pets;

  
  private String politicalViews;
  private String preferredUsername;

  
  private List<String> quotes;
  private String relationshipStatus;
  private String religion;
  private String romance;
  private String scaredOf;
  private String sexualOrientation;

  private List<String> sports;
  private String status;
  private List<String> tags;
  private Long utcOffset;
  private List<String> turnOffs;
  private List<String> turnOns;
  private List<String> tvShows;
  private Date updated;


  // Note: Not in the opensocial js person object directly
  private boolean isOwner = false;
  private boolean isViewer = false;

  public PersonImpl() {
  }

  /**
   * A constructor which contains all of the required fields on a person object
   * @param id The id of the person
   * @param displayName The displayName of the person
   * @param name The person's name broken down into components
   */
  public PersonImpl(String id, String displayName) {
    this.id = id;
    this.displayName = displayName;
    
  }
  
  public String getName() {
	  return name;
  }
  
  public void setName(String name) {
	  this.name = name;
  }

  public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

 
  
  
  

  public List<String> getActivities() {
    return activities;
  }

  public void setActivities(List<String> activities) {
    this.activities = activities;
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
  
  public String getPreferredUsername() {
    return preferredUsername;
  }

  public void setPreferredUsername(String preferredUsername) {
    this.preferredUsername = preferredUsername;
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

  
  
  

  public boolean getIsOwner() {
    return isOwner;
  }

  public void setIsOwner(boolean isOwner) {
    this.isOwner = isOwner;
  }

  public boolean getIsViewer() {
    return isViewer;
  }

  public void setIsViewer(boolean isViewer) {
    this.isViewer = isViewer;
  }
  
  // Proxied fields

  
}
  
  
  

