
package com.skt.opensocial.wrapper.persistence.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.shindig.protocol.model.Enum;
import org.apache.shindig.protocol.model.EnumImpl;
import org.apache.shindig.social.core.model.AddressImpl;
import org.apache.shindig.social.core.model.BodyTypeImpl;
import org.apache.shindig.social.core.model.NameImpl;
import org.apache.shindig.social.core.model.OrganizationImpl;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.opensocial.model.NetworkPresence;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.model.LookingFor;
import org.apache.shindig.social.opensocial.model.Smoker;
import org.apache.shindig.social.opensocial.model.Organization;

import com.google.common.collect.Lists;
import com.skt.opensocial.wrapper.persistence.domain.PersonDB;
import com.skt.opensocial.wrapper.persistence.domain.OrganizationDB;

import org.apache.shindig.social.opensocial.model.Drinker;
import org.apache.shindig.social.opensocial.model.Person.Gender;

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
		personDB.setDrinker( String.valueOf(person.getDrinker().getValue()) );
		personDB.setEmails(person.getEmails());
		personDB.setEthnicity(person.getEthnicity());
		personDB.setFashion(person.getFashion());
		personDB.setFood( person.getFood() );	
		personDB.setGender( String.valueOf(person.getGender()) );
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
		List<String> lookingFor = new ArrayList<String>();
		for (Enum<LookingFor> lf : lookingForList) {
			lookingFor.add( String.valueOf(lf.getValue()) );
		}
		personDB.setLookingFor( lookingFor);
		
		personDB.setMovies(person.getMovies());
		personDB.setMovies(person.getMovies());
		
		// get Name Details
		personDB.setName_additionalName(person.getName().getAdditionalName());
		personDB.setName_familyName(person.getName().getFamilyName());
		personDB.setName_formatted(person.getName().getFormatted());
		personDB.setName_givenName(person.getName().getGivenName());
		personDB.setName_honorificPrefix(person.getName().getHonorificPrefix());
		personDB.setName_honorificSuffix(person.getName().getHonorificSuffix());
		
		personDB.setNetworkPresence( String.valueOf(person.getNetworkPresence().getValue()) ); 
		personDB.setNickname(person.getNickname());
		personDB.setOrganizations(person.getOrganizations());
		personDB.setPets(person.getPets());
		personDB.setPhoneNumbers(person.getPhoneNumbers());
		personDB.setPhotos(person.getPhotos());
		personDB.setPoliticalViews(person.getPoliticalViews());
		personDB.setPreferredUsername(person.getPreferredUsername());
		personDB.setQuotes(person.getQuotes());
		personDB.setRelationshipStatus(person.getRelationshipStatus());
		personDB.setReligion(person.getReligion());
		personDB.setRomance(person.getRomance());
		personDB.setScaredOf(person.getScaredOf());
		personDB.setSexualOrientation(person.getSexualOrientation());
		personDB.setSmoker( String.valueOf(person.getSmoker().getValue()) );
		personDB.setSports(person.getSports());	
		personDB.setStatus(person.getStatus());
		personDB.setTags(person.getTags());
		personDB.setTurnOffs(person.getTurnOffs());
		personDB.setTurnOns(person.getTurnOns());
		personDB.setTvShows(person.getTvShows());
		personDB.setUpdated(person.getUpdated());
		personDB.setUrls(person.getUrls());
		
		personDB.setUtcOffset(person.getUtcOffset());
		
		personDB.setProfileSongUrl_linkText( person.getProfileSong().getLinkText() );
		personDB.setProfileSongUrl_primary( person.getProfileSong().getPrimary() );
		personDB.setProfileSongUrl_type( person.getProfileSong().getType() );
		personDB.setProfileSongUrl_value( person.getProfileSong().getValue() );
		
		personDB.setProfileVideoUrl_linkText( person.getProfileVideo().getLinkText() );
		personDB.setProfileVideoUrl_primary( person.getProfileVideo().getPrimary() );
		personDB.setProfileVideoUrl_type( person.getProfileVideo().getType() );
		personDB.setProfileVideoUrl_value( person.getProfileVideo().getValue() );
		
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
		
		// find ENUM value comparing the word and set it as a Drinker
		if (personDB.getDrinker() != null) {
			if ( personDB.getDrinker().equals("HEAVILY") || personDB.getDrinker().equals("Heavil")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.HEAVILY ) );
			} else if ( personDB.getDrinker().equals("NO") || personDB.getDrinker().equals("No")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.NO ) );
			} else if ( personDB.getDrinker().equals("OCCASIONALLY") || personDB.getDrinker().equals("Occasionally")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.OCCASIONALLY ) );
			} else if ( personDB.getDrinker().equals("QUIT") || personDB.getDrinker().equals("Quit")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.QUIT ) );
			} else if ( personDB.getDrinker().equals("QUITTING") || personDB.getDrinker().equals("Quitting")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.QUITTING ) );
			} else if ( personDB.getDrinker().equals("REGULARLY") || personDB.getDrinker().equals("Regularly")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.REGULARLY ) );
			} else if ( personDB.getDrinker().equals("SOCIALLY") || personDB.getDrinker().equals("Socially")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.SOCIALLY ) );
			} else if ( personDB.getDrinker().equals("YES") || personDB.getDrinker().equals("Yes")) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.YES ) );
			}
		}
		
		
		person.setEmails(personDB.getEmails());
		person.setEthnicity(personDB.getEthnicity());
		person.setFashion(personDB.getFashion());
		person.setFood( person.getFood() );	
		
		// find ENUM value comparing the word and set it as a Gender
		if (personDB.getGender() != null) {
			if ( personDB.getGender().equals("female") ) {
				person.setGender(Gender.female);
			} else if ( personDB.getGender().equals("male") ) {
				person.setGender(Gender.male);
			} 
		}
		
		person.setHappiestWhen(personDB.getHappiestWhen());
		person.setHasApp(personDB.getHasApp());
		person.setHeroes(personDB.getHeroes());
		
		person.setHumor(personDB.getHumor());
		person.setId(personDB.getId());
		person.setIms(personDB.getIms());
		person.setInterests(personDB.getInterests());	
		person.setJobInterests(personDB.getJobInterests());
		person.setLanguagesSpoken(personDB.getLanguagesSpoken());
		
		person.setLivingArrangement(personDB.getLivingArrangement());
		
		// get the list of lookingFor
		List<String> lookingForList = personDB.getLookingFor();
		List<Enum<LookingFor>> lookingFor = Lists.newArrayList();;
		for (String lf : lookingForList) {
			Enum<LookingFor> lookingForOne = null;
			
			// find ENUM value comparing the word and set it as a LookingFor
			if ( lf.equals("DATING") || lf.equals("Dating")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.DATING );
			} else if ( lf.equals("FRIENDS") || lf.equals("Friends")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.FRIENDS );
			} else if ( lf.equals("RELATIONSHIP") || lf.equals("Relationship")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.RELATIONSHIP );
			} else if ( lf.equals("NETWORKING") || lf.equals("Networking")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.NETWORKING );
			} else if ( lf.equals("ACTIVITY_PARTNERS") || lf.equals("Activity partners")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.ACTIVITY_PARTNERS );
			} else if ( lf.equals("RANDOM") || lf.equals("Random")) {
				lookingForOne = new EnumImpl<LookingFor>( LookingFor.RANDOM );
			}
	
			lookingFor.add( lookingForOne );
		}
		person.setLookingFor(lookingFor);
		
		person.setMovies(personDB.getMovies());
		person.setMusic(personDB.getMusic());
		
		// get Name Details
		NameImpl name = new NameImpl();
		name.setAdditionalName(personDB.getName_addtionalName());
		name.setFamilyName(personDB.getName_familyName());
		name.setFormatted(personDB.getName_formatted());
		name.setGivenName(personDB.getName_givenName());
		name.setHonorificPrefix(personDB.getName_honorificPrefix());
		name.setHonorificSuffix(personDB.getName_honorificSuffix());
		person.setName(name);
		
		// find ENUM value comparing the word and set it as a NetworkPresence
		if (personDB.getNetworkPresence() != null) {
			if ( personDB.getNetworkPresence().equals("ONLINE") || personDB.getNetworkPresence().equals("Online")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.ONLINE ) );
			} else if ( personDB.getNetworkPresence().equals("OFFLINE") || personDB.getNetworkPresence().equals("Offline")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.OFFLINE ) );
			} else if ( personDB.getNetworkPresence().equals("AWAY") || personDB.getNetworkPresence().equals("Away")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.AWAY ) );
			} else if ( personDB.getNetworkPresence().equals("CHAT") || personDB.getNetworkPresence().equals("Chat")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.CHAT ) );
			} else if ( personDB.getNetworkPresence().equals("DND") || personDB.getNetworkPresence().equals("Do Not Disturb")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.DND ) );
			} else if ( personDB.getNetworkPresence().equals("XA") || personDB.getNetworkPresence().equals("Extended Away")) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.XA ) );
			} 
		}
		
		person.setNickname(personDB.getNickname());
		
		person.setOrganizations(personDB.getOrganizations());	
		person.setPets(personDB.getPets());
		person.setPhoneNumbers( personDB.getPhoneNumbers() );
		person.setPhotos( personDB.getPhotos() );
		person.setPoliticalViews(personDB.getPoliticalViews());
		person.setPreferredUsername(personDB.getPreferredUsername());
	
		person.setQuotes(personDB.getQuotes());
		person.setRelationshipStatus(personDB.getRelationshipStatus());
		person.setReligion(personDB.getReligion());
		person.setRomance(personDB.getRomance());
		person.setScaredOf(personDB.getScaredOf());
		person.setSexualOrientation(personDB.getSexualOrientation());
		
		// find ENUM value comparing the word and set it as a Smoker
		if (personDB.getSmoker() != null) {
			if ( personDB.getSmoker().equals("HEAVILY") || personDB.getSmoker().equals("Heavil")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.HEAVILY ) );
			} else if ( personDB.getSmoker().equals("NO") || personDB.getSmoker().equals("No")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.NO ) );
			} else if ( personDB.getSmoker().equals("OCCASIONALLY") || personDB.getSmoker().equals("Occasionally")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.OCCASIONALLY ) );
			} else if ( personDB.getSmoker().equals("QUIT") || personDB.getSmoker().equals("Quit")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.QUIT ) );
			} else if ( personDB.getSmoker().equals("QUITTING") || personDB.getSmoker().equals("Quitting")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.QUITTING ) );
			} else if ( personDB.getSmoker().equals("REGULARLY") || personDB.getSmoker().equals("Regularly")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.REGULARLY ) );
			} else if ( personDB.getSmoker().equals("SOCIALLY") || personDB.getSmoker().equals("Socially")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.SOCIALLY ) );
			} else if ( personDB.getSmoker().equals("YES") || personDB.getSmoker().equals("Yes")) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.YES ) );
			}
		}
		
		person.setSports(personDB.getSports());	
		person.setStatus(personDB.getStatus());
		person.setTags(personDB.getTags());
		person.setTurnOffs(personDB.getTurnOffs());
		person.setTurnOns(personDB.getTurnOns());
		person.setTvShows(personDB.getTvShows());
		person.setUpdated(personDB.getUpdated());
		person.setUrls(personDB.getUrls());
		
		person.setUtcOffset(personDB.getUtcOffset());
		
		
		return person;
	}
	
	public static List<Organization> getOrganizationsFromOrganizationDBList(List<OrganizationDB> organizationDBList) {
		List<Organization> organizationList = Lists.newArrayList();
		
		for(OrganizationDB organizationDB : organizationDBList) {
			OrganizationImpl organization = new OrganizationImpl();
			
			organization.setDescription( organizationDB.getDescription() );
			organization.setEndDate( organizationDB.getEndDate() );
			organization.setField( organizationDB.getfield() );
			organization.setName( organizationDB.getName() );
			organization.setPrimary( organizationDB.getPrimary() );
			organization.setSalary( organizationDB.getSalary() );
			organization.setStartDate( organizationDB.getStartDate() );
			organization.setSubField( organizationDB.getSubField() );
			organization.setTitle( organizationDB.getTitle() );
			organization.setType( organizationDB.getTitle() );
			organization.setWebpage( organizationDB.getWebpage() );
			
			// get Address details of the organization
			AddressImpl address = new AddressImpl();
			address.setCountry( organizationDB.getAddress_country() );
			address.setFormatted( organizationDB.getAddress_formatted() );
			address.setLatitude( organizationDB.getAddress_latitude() ); 
			address.setLocality( organizationDB.getAddress_locality() );
			address.setLongitude( organizationDB.getAddress_longitude() );
			address.setPostalCode( organizationDB.getAddress_postalCode() );
			address.setPrimary( organizationDB.getAddress_primary() );
			address.setRegion( organizationDB.getAddress_region() );
			address.setStreetAddress( organizationDB.getAddress_streetAddress() );
			address.setType( organizationDB.getAddress_type() );
			organization.setAddress(address);
			
			organizationList.add(organization);
		}
		
		return organizationList;
	}
}