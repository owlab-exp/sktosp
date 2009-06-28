package com.skt.opensocial.persistence;

// Generated Jun 25, 2009 4:34:44 PM by Hibernate Tools 3.2.4.GA

/**
 * UserVisibility generated by hbm2java
 */
public class UserVisibility implements java.io.Serializable {

	private String userId;
	private String name;
	private String addresses;
	private String age;
	private String botytype;
	private String books;
	private String cars;
	private String children;
	private String currentlocation;
	private String dateofbirth;
	private String drinker;
	private String emails;
	private String ethnicity;
	private String fashion;
	private String food;
	private String gender;
	private String happiestwhen;
	private String hasapp;
	private String heroes;
	private String humor;
	private String interests;
	private String jobinterests;
	private String jobs;
	private String languagesspoken;
	private String livingarrangement;
	private String lookingfor;
	private String movies;
	private String music;
	private String networkpresence;
	private String nickname;
	private String pets;
	private String phonenumbers;
	private String politicalviews;
	private String profilesong;
	private String profileurl;
	private String profilevideo;
	private String quotes;
	private String relationshipstatus;
	private String religion;
	private String romance;
	private String scaredof;
	private String schools;
	private String sexualorientation;
	private String smoker;
	private String sports;
	private String status;
	private String tags;
	private String thumbnailurl;
	private String timezone;
	private String turnoffs;
	private String turnons;
	private String tvshows;
	private String urls;
	private String ethinicity;
	private String happieswhen;
	private User user;

	public UserVisibility() {
	}

//	public UserVisibility(String userId, String name, String addresses,
//			String age, String botytype, String books, String cars,
//			String children, String currentlocation, String dateofbirth,
//			String drinker, String emails, String ethnicity, String fashion,
//			String food, String gender, String happiestwhen, String hasapp,
//			String heroes, String humor, String interests, String jobinterests,
//			String jobs, String languagesspoken, String livingarrangement,
//			String lookingfor, String movies, String music,
//			String networkpresence, String nickname, String pets,
//			String phonenumbers, String politicalviews, String profilesong,
//			String profileurl, String profilevideo, String quotes,
//			String relationshipstatus, String religion, String romance,
//			String scaredof, String schools, String sexualorientation,
//			String smoker, String sports, String status, String tags,
//			String thumbnailurl, String timezone, String turnoffs,
//			String turnons, String tvshows, String urls) {
//		this.userId = userId;
//		this.name = name;
//		this.addresses = addresses;
//		this.age = age;
//		this.botytype = botytype;
//		this.books = books;
//		this.cars = cars;
//		this.children = children;
//		this.currentlocation = currentlocation;
//		this.dateofbirth = dateofbirth;
//		this.drinker = drinker;
//		this.emails = emails;
//		this.ethnicity = ethnicity;
//		this.fashion = fashion;
//		this.food = food;
//		this.gender = gender;
//		this.happiestwhen = happiestwhen;
//		this.hasapp = hasapp;
//		this.heroes = heroes;
//		this.humor = humor;
//		this.interests = interests;
//		this.jobinterests = jobinterests;
//		this.jobs = jobs;
//		this.languagesspoken = languagesspoken;
//		this.livingarrangement = livingarrangement;
//		this.lookingfor = lookingfor;
//		this.movies = movies;
//		this.music = music;
//		this.networkpresence = networkpresence;
//		this.nickname = nickname;
//		this.pets = pets;
//		this.phonenumbers = phonenumbers;
//		this.politicalviews = politicalviews;
//		this.profilesong = profilesong;
//		this.profileurl = profileurl;
//		this.profilevideo = profilevideo;
//		this.quotes = quotes;
//		this.relationshipstatus = relationshipstatus;
//		this.religion = religion;
//		this.romance = romance;
//		this.scaredof = scaredof;
//		this.schools = schools;
//		this.sexualorientation = sexualorientation;
//		this.smoker = smoker;
//		this.sports = sports;
//		this.status = status;
//		this.tags = tags;
//		this.thumbnailurl = thumbnailurl;
//		this.timezone = timezone;
//		this.turnoffs = turnoffs;
//		this.turnons = turnons;
//		this.tvshows = tvshows;
//		this.urls = urls;
//	}
//
//	public UserVisibility(String userId, String name, String addresses,
//			String age, String botytype, String books, String cars,
//			String children, String currentlocation, String dateofbirth,
//			String drinker, String emails, String ethnicity, String fashion,
//			String food, String gender, String happiestwhen, String hasapp,
//			String heroes, String humor, String interests, String jobinterests,
//			String jobs, String languagesspoken, String livingarrangement,
//			String lookingfor, String movies, String music,
//			String networkpresence, String nickname, String pets,
//			String phonenumbers, String politicalviews, String profilesong,
//			String profileurl, String profilevideo, String quotes,
//			String relationshipstatus, String religion, String romance,
//			String scaredof, String schools, String sexualorientation,
//			String smoker, String sports, String status, String tags,
//			String thumbnailurl, String timezone, String turnoffs,
//			String turnons, String tvshows, String urls, String ethinicity,
//			String happieswhen) {
//		this.userId = userId;
//		this.name = name;
//		this.addresses = addresses;
//		this.age = age;
//		this.botytype = botytype;
//		this.books = books;
//		this.cars = cars;
//		this.children = children;
//		this.currentlocation = currentlocation;
//		this.dateofbirth = dateofbirth;
//		this.drinker = drinker;
//		this.emails = emails;
//		this.ethnicity = ethnicity;
//		this.fashion = fashion;
//		this.food = food;
//		this.gender = gender;
//		this.happiestwhen = happiestwhen;
//		this.hasapp = hasapp;
//		this.heroes = heroes;
//		this.humor = humor;
//		this.interests = interests;
//		this.jobinterests = jobinterests;
//		this.jobs = jobs;
//		this.languagesspoken = languagesspoken;
//		this.livingarrangement = livingarrangement;
//		this.lookingfor = lookingfor;
//		this.movies = movies;
//		this.music = music;
//		this.networkpresence = networkpresence;
//		this.nickname = nickname;
//		this.pets = pets;
//		this.phonenumbers = phonenumbers;
//		this.politicalviews = politicalviews;
//		this.profilesong = profilesong;
//		this.profileurl = profileurl;
//		this.profilevideo = profilevideo;
//		this.quotes = quotes;
//		this.relationshipstatus = relationshipstatus;
//		this.religion = religion;
//		this.romance = romance;
//		this.scaredof = scaredof;
//		this.schools = schools;
//		this.sexualorientation = sexualorientation;
//		this.smoker = smoker;
//		this.sports = sports;
//		this.status = status;
//		this.tags = tags;
//		this.thumbnailurl = thumbnailurl;
//		this.timezone = timezone;
//		this.turnoffs = turnoffs;
//		this.turnons = turnons;
//		this.tvshows = tvshows;
//		this.urls = urls;
//		this.ethinicity = ethinicity;
//		this.happieswhen = happieswhen;
//	}

	private String getUserId() {
		return this.userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddresses() {
		return this.addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBotytype() {
		return this.botytype;
	}

	public void setBotytype(String botytype) {
		this.botytype = botytype;
	}

	public String getBooks() {
		return this.books;
	}

	public void setBooks(String books) {
		this.books = books;
	}

	public String getCars() {
		return this.cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	public String getChildren() {
		return this.children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getCurrentlocation() {
		return this.currentlocation;
	}

	public void setCurrentlocation(String currentlocation) {
		this.currentlocation = currentlocation;
	}

	public String getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDrinker() {
		return this.drinker;
	}

	public void setDrinker(String drinker) {
		this.drinker = drinker;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getEthnicity() {
		return this.ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getFashion() {
		return this.fashion;
	}

	public void setFashion(String fashion) {
		this.fashion = fashion;
	}

	public String getFood() {
		return this.food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHappiestwhen() {
		return this.happiestwhen;
	}

	public void setHappiestwhen(String happiestwhen) {
		this.happiestwhen = happiestwhen;
	}

	public String getHasapp() {
		return this.hasapp;
	}

	public void setHasapp(String hasapp) {
		this.hasapp = hasapp;
	}

	public String getHeroes() {
		return this.heroes;
	}

	public void setHeroes(String heroes) {
		this.heroes = heroes;
	}

	public String getHumor() {
		return this.humor;
	}

	public void setHumor(String humor) {
		this.humor = humor;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getJobinterests() {
		return this.jobinterests;
	}

	public void setJobinterests(String jobinterests) {
		this.jobinterests = jobinterests;
	}

	public String getJobs() {
		return this.jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public String getLanguagesspoken() {
		return this.languagesspoken;
	}

	public void setLanguagesspoken(String languagesspoken) {
		this.languagesspoken = languagesspoken;
	}

	public String getLivingarrangement() {
		return this.livingarrangement;
	}

	public void setLivingarrangement(String livingarrangement) {
		this.livingarrangement = livingarrangement;
	}

	public String getLookingfor() {
		return this.lookingfor;
	}

	public void setLookingfor(String lookingfor) {
		this.lookingfor = lookingfor;
	}

	public String getMovies() {
		return this.movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	public String getMusic() {
		return this.music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getNetworkpresence() {
		return this.networkpresence;
	}

	public void setNetworkpresence(String networkpresence) {
		this.networkpresence = networkpresence;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPets() {
		return this.pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}

	public String getPhonenumbers() {
		return this.phonenumbers;
	}

	public void setPhonenumbers(String phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public String getPoliticalviews() {
		return this.politicalviews;
	}

	public void setPoliticalviews(String politicalviews) {
		this.politicalviews = politicalviews;
	}

	public String getProfilesong() {
		return this.profilesong;
	}

	public void setProfilesong(String profilesong) {
		this.profilesong = profilesong;
	}

	public String getProfileurl() {
		return this.profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getProfilevideo() {
		return this.profilevideo;
	}

	public void setProfilevideo(String profilevideo) {
		this.profilevideo = profilevideo;
	}

	public String getQuotes() {
		return this.quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	public String getRelationshipstatus() {
		return this.relationshipstatus;
	}

	public void setRelationshipstatus(String relationshipstatus) {
		this.relationshipstatus = relationshipstatus;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRomance() {
		return this.romance;
	}

	public void setRomance(String romance) {
		this.romance = romance;
	}

	public String getScaredof() {
		return this.scaredof;
	}

	public void setScaredof(String scaredof) {
		this.scaredof = scaredof;
	}

	public String getSchools() {
		return this.schools;
	}

	public void setSchools(String schools) {
		this.schools = schools;
	}

	public String getSexualorientation() {
		return this.sexualorientation;
	}

	public void setSexualorientation(String sexualorientation) {
		this.sexualorientation = sexualorientation;
	}

	public String getSmoker() {
		return this.smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public String getSports() {
		return this.sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getThumbnailurl() {
		return this.thumbnailurl;
	}

	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTurnoffs() {
		return this.turnoffs;
	}

	public void setTurnoffs(String turnoffs) {
		this.turnoffs = turnoffs;
	}

	public String getTurnons() {
		return this.turnons;
	}

	public void setTurnons(String turnons) {
		this.turnons = turnons;
	}

	public String getTvshows() {
		return this.tvshows;
	}

	public void setTvshows(String tvshows) {
		this.tvshows = tvshows;
	}

	public String getUrls() {
		return this.urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getEthinicity() {
		return this.ethinicity;
	}

	public void setEthinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}

	public String getHappieswhen() {
		return this.happieswhen;
	}

	public void setHappieswhen(String happieswhen) {
		this.happieswhen = happieswhen;
	}

}
