
package com.skt.opensocial.wrapper.persistence.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.shindig.protocol.model.Enum;
import org.apache.shindig.protocol.model.EnumImpl;
import org.apache.shindig.social.core.model.AddressImpl;
import org.apache.shindig.social.core.model.BodyTypeImpl;
import org.apache.shindig.social.core.model.NameImpl;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.opensocial.model.NetworkPresence;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.model.LookingFor;
import org.apache.shindig.social.opensocial.model.Smoker;

import com.skt.opensocial.wrapper.persistence.domain.PersonDB;

import org.apache.shindig.social.opensocial.model.Drinker;

public class DBTableMapper {

	
	public static PersonDB getPersonDBFromPerson(Person person) {
		PersonDB personDB = new PersonDB();
		
		/* store all the data of Person into PersonDB matching the format of data */
		personDB.setAboutMe(person.getAboutMe());
		personDB.setAccounts(person.getAccounts());
		personDB.setActivities(person.getActivities());
		personDB.setAddresses(person.getAddresses());
		personDB.setAge(person.getAge());
		personDB.setAppData(person.getAppData());
		
		// get BodyType Details 
		personDB.setBirthday(person.getBirthday());
		personDB.setBodyType_build(person.getBodyType().getBuild());
		personDB.setBodyType_eyeColor(person.getBodyType().getEyeColor());
		personDB.setBodyType_hairColor(person.getBodyType().getHairColor());
		personDB.setBodyType_height(person.getBodyType().getHeight());
		personDB.setBodyType_weight(person.getBodyType().getWeight());
		personDB.setBooks(person.getBooks());
		personDB.setCars(person.getCars());	
		personDB.setChildren(person.getChildren());
		
		// get CurrentLocation Details
		personDB.setCurrentLocation_country(person.getCurrentLocation().getCountry());
		personDB.setCurrentLocation_formatted(person.getCurrentLocation().getFormatted());
		personDB.setCurrentLocation_latitude(person.getCurrentLocation().getLatitude());
		personDB.setCurrentLocation_locality(person.getCurrentLocation().getLocality());
		personDB.setCurrentLocation_longitude(person.getCurrentLocation().getLongitude());
		personDB.setCurrentLocation_postalCode(person.getCurrentLocation().getPostalCode());
		personDB.setCurrentLocation_primary(person.getCurrentLocation().getPrimary());
		personDB.setCurrentLocation_region(person.getCurrentLocation().getRegion());
		personDB.setCurrentLocation_streetAddress(person.getCurrentLocation().getStreetAddress());
		personDB.setCurrentLocation_type(person.getCurrentLocation().getType());
	
		personDB.setDisplayName(person.getDisplayName());
		personDB.setDrinker( person.getDrinker().getValue() );
		personDB.setEmails(person.getEmails());
		personDB.setEthnicity(person.getEthnicity());
		personDB.setFashion(person.getFashion());
		personDB.setFood( person.getFood() );	
		personDB.setGender( person.getGender() );
		personDB.setHappiestWhen(person.getHappiestWhen());
		personDB.setHasApp(person.getHasApp());
		personDB.setHeroes(person.getHeroes());
		
		personDB.setHumor(person.getHumor());
		personDB.setId(person.getId());
		personDB.setIms(person.getIms());
		personDB.setInterests(person.getInterests());	
		personDB.setJobInterests(person.getJobInterests());
		personDB.setLanguagesSpoken(person.getLanguagesSpoken());
		
		personDB.setLivingArrangement(person.getLivingArrangement());
		
		// get the list of lookingFor
		List<Enum<LookingFor>> lookingForList = person.getLookingFor();
		List<LookingFor> lookingFor = new ArrayList<LookingFor>();
		for (Enum<LookingFor> lf : lookingForList) {
			lookingFor.add( lf.getValue() );
		}
		personDB.setLookingFor(lookingFor);
		
		personDB.setMovies(person.getMovies());
		personDB.setMovies(person.getMovies());
		
		// get Name Details
		personDB.setName_additionalName(person.getName().getAdditionalName());
		personDB.setName_familyName(person.getName().getFamilyName());
		personDB.setName_formatted(person.getName().getFormatted());
		personDB.setName_givenName(person.getName().getGivenName());
		personDB.setName_honorificPrefix(person.getName().getHonorificPrefix());
		personDB.setName_honorificSuffix(person.getName().getHonorificSuffix());
		
		personDB.setNetworkPresence( person.getNetworkPresence().getValue() ); 
		personDB.setNickname(person.getNickname());
		personDB.setOrganizations(person.getOrganizations());
		personDB.setPets(person.getPets());
		personDB.setPhoneNumbers(person.getPhoneNumbers());
		personDB.setPhotos(person.getPhotos());
		personDB.setPoliticalViews(person.getPoliticalViews());
		personDB.setPreferredUsername(person.getPreferredUsername());
		personDB.setProfileSongUrl(person.getProfileSong().getValue());
		personDB.setProfileVideoUrl(person.getProfileVideo().getValue());
		personDB.setProfileUrl(person.getProfileUrl());
		personDB.setQuotes(person.getQuotes());
		personDB.setRelationshipStatus(person.getRelationshipStatus());
		personDB.setReligion(person.getReligion());
		personDB.setRomance(person.getRomance());
		personDB.setScaredOf(person.getScaredOf());
		personDB.setSexualOrientation(person.getSexualOrientation());
		personDB.setSmoker( person.getSmoker().getValue() );
		personDB.setSports(person.getSports());	
		personDB.setStatus(person.getStatus());
		personDB.setTags(person.getTags());
		personDB.setThumbnailUrl(person.getThumbnailUrl());
		personDB.setTurnOffs(person.getTurnOffs());
		personDB.setTurnOns(person.getTurnOns());
		personDB.setTvShows(person.getTvShows());
		personDB.setUpdated(person.getUpdated());
		personDB.setUrls(person.getUrls());
		
		personDB.setUtcOffset(person.getUtcOffset());
		
		
		return personDB;
	}
/*	
	public static Map<String, String> getPersonAdditionalInfoMap(Person person) {
		Map<String, String> additionalInfoMap = new HashMap<String, String>();
		
		List<String> books = person.getBooks();
		
		
		return additionalInfoMap;
	}
	*/
	
	public static Person getPersonFromPersonDB(PersonDB personDB) {
		PersonImpl person = new PersonImpl();
		
		/* store all the data of Person into PersonDB matching the format of data */
		person.setAboutMe(personDB.getAboutMe());
		person.setAccounts(personDB.getAccounts());
		person.setActivities(personDB.getActivities());
		person.setAddresses(personDB.getAddresses());
		person.setAge(personDB.getAge());
		person.setAppData(personDB.getAppData());
		
		person.setBirthday(personDB.getBirthday());
		
		// get BodyType Details 
		BodyTypeImpl bodyType = new BodyTypeImpl();
		bodyType.setBuild(personDB.getBodyType_build());
		bodyType.setEyeColor(personDB.getBodyType_eyeColor());
		bodyType.setHairColor(personDB.getBodyType_hairColor());
		bodyType.setHeight(personDB.getBodyType_height());
		bodyType.setWeight(personDB.getBodyType_weight());
		person.setBodyType(bodyType);
		
		person.setBooks(personDB.getBooks());
		person.setCars(personDB.getCars());	
		person.setChildren(personDB.getChildren());
		
		// get CurrentLocation Details
		AddressImpl currentLocation = new AddressImpl();
		currentLocation.setCountry(personDB.getCurrentLocation_country());
		currentLocation.setFormatted(personDB.getCurrentLocation_formatted());
		currentLocation.setLatitude(personDB.getCurrentLocation_latitude());
		currentLocation.setLocality(personDB.getCurrentLocation_locality());
		currentLocation.setLongitude(personDB.getCurrentLocation_longitude());
		currentLocation.setPostalCode(personDB.getCurrentLocation_postalCode());
		currentLocation.setPrimary(personDB.getCurrentLocation_primary());
		currentLocation.setRegion(personDB.getCurrentLocation_region());
		currentLocation.setStreetAddress(personDB.getCurrentLocation_streetAddress());
		currentLocation.setType(personDB.getCurrentLocation_type());
		person.setCurrentLocation(currentLocation);
	
		person.setDisplayName(personDB.getDisplayName());
		
		if (personDB.getDrinker() != null) 
			person.setDrinker( new EnumImpl<Drinker>(personDB.getDrinker()) );
		//person.setEmails(personDB.getEmails());
		person.setEthnicity(personDB.getEthnicity());
		person.setFashion(personDB.getFashion());
		person.setFood( person.getFood() );	
		
		if (personDB.getGender() != null)
			person.setGender( personDB.getGender() );
		person.setHappiestWhen(personDB.getHappiestWhen());
		person.setHasApp(personDB.getHasApp());
		person.setHeroes(personDB.getHeroes());
		
		person.setHumor(personDB.getHumor());
		person.setId(personDB.getId());
		//person.setIms(personDB.getIms());
		person.setInterests(personDB.getInterests());	
		person.setJobInterests(personDB.getJobInterests());
		person.setLanguagesSpoken(personDB.getLanguagesSpoken());
		
		person.setLivingArrangement(personDB.getLivingArrangement());
/*		
		// get the list of lookingFor
		List<LookingFor> lookingForList = personDB.getLookingFor();
		List<Enum<LookingFor>> lookingFor = Lists.newArrayList();;
		for (LookingFor lf : lookingForList) {
			Enum<LookingFor> lookingForOne = new EnumImpl<LookingFor>(lf);
			lookingFor.add( lookingForOne );
		}
		person.setLookingFor(lookingFor);
*/		
		person.setMovies(personDB.getMovies());
		person.setMovies(personDB.getMovies());
		
		// get Name Details
		NameImpl name = new NameImpl();
		name.setAdditionalName(personDB.getName_addtionalName());
		name.setFamilyName(personDB.getName_familyName());
		name.setFormatted(personDB.getName_formatted());
		name.setGivenName(personDB.getName_givenName());
		name.setHonorificPrefix(personDB.getName_honorificPrefix());
		name.setHonorificSuffix(personDB.getName_honorificSuffix());
		person.setName(name);
		
		if (personDB.getNetworkPresence() != null) 
			person.setNetworkPresence( new EnumImpl<NetworkPresence>(personDB.getNetworkPresence()) ); 
		person.setNickname(personDB.getNickname());
		person.setOrganizations(personDB.getOrganizations());
		person.setPets(personDB.getPets());
//		person.setPhoneNumbers(personDB.getPhoneNumbers());
//		person.setPhotos(personDB.getPhotos());
		person.setPoliticalViews(personDB.getPoliticalViews());
		person.setPreferredUsername(personDB.getPreferredUsername());
		//person.setProfileSong()(personDB.getProfileSongUrl());
		//person.setProfileVideo(personDB.getProfileVideoUrl());
		person.setProfileUrl(personDB.getProfileUrl());
		person.setQuotes(personDB.getQuotes());
		person.setRelationshipStatus(personDB.getRelationshipStatus());
		person.setReligion(personDB.getReligion());
		person.setRomance(personDB.getRomance());
		person.setScaredOf(personDB.getScaredOf());
		person.setSexualOrientation(personDB.getSexualOrientation());
		
		if(personDB.getSmoker() != null) 
			person.setSmoker( new EnumImpl<Smoker>(personDB.getSmoker()) );
		person.setSports(personDB.getSports());	
		person.setStatus(personDB.getStatus());
		person.setTags(personDB.getTags());
		person.setThumbnailUrl(personDB.getThumbnailUrl());
		person.setTurnOffs(personDB.getTurnOffs());
		person.setTurnOns(personDB.getTurnOns());
		person.setTvShows(personDB.getTvShows());
		person.setUpdated(personDB.getUpdated());
		person.setUrls(personDB.getUrls());
		
		person.setUtcOffset(personDB.getUtcOffset());
		
		
		return person;
	}
}