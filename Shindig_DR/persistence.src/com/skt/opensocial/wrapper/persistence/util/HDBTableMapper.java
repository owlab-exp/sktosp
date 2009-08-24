
package com.skt.opensocial.wrapper.persistence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shindig.protocol.model.Enum;
import org.apache.shindig.protocol.model.EnumImpl;
import org.apache.shindig.social.core.model.AccountImpl;
import org.apache.shindig.social.core.model.ActivityImpl;
import org.apache.shindig.social.core.model.AddressImpl;
import org.apache.shindig.social.core.model.BodyTypeImpl;
import org.apache.shindig.social.core.model.ListFieldImpl;
import org.apache.shindig.social.core.model.MediaItemImpl;
import org.apache.shindig.social.core.model.NameImpl;
import org.apache.shindig.social.core.model.OrganizationImpl;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.core.model.UrlImpl;
import org.apache.shindig.social.opensocial.model.Account;
import org.apache.shindig.social.opensocial.model.Activity;
import org.apache.shindig.social.opensocial.model.Address;
import org.apache.shindig.social.opensocial.model.BodyType;
import org.apache.shindig.social.opensocial.model.ListField;
import org.apache.shindig.social.opensocial.model.MediaItem;
import org.apache.shindig.social.opensocial.model.NetworkPresence;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.model.LookingFor;
import org.apache.shindig.social.opensocial.model.Smoker;
import org.apache.shindig.social.opensocial.model.Organization;
import org.apache.shindig.social.opensocial.model.Url;

import com.google.common.collect.Lists;
import com.skt.opensocial.persistence.ActivityMediaItem;
import com.skt.opensocial.persistence.ActivityTemplateParam;
import com.skt.opensocial.persistence.DrinkerEnum;
import com.skt.opensocial.persistence.GenderEnum;
import com.skt.opensocial.persistence.Info1AttributeEnum;
import com.skt.opensocial.persistence.Info2AttributeEnum;
import com.skt.opensocial.persistence.NetworkpresenceEnum;
import com.skt.opensocial.persistence.PersonAccount;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.PersonAppData;
import com.skt.opensocial.persistence.PersonOrganization;
import com.skt.opensocial.persistence.PersonUrl;
import com.skt.opensocial.persistence.SmokerEnum;

import org.apache.shindig.social.opensocial.model.Drinker;
import org.apache.shindig.social.opensocial.model.Person.Gender;

public class HDBTableMapper {
	
	public static Person getPersonFromPersonDB(com.skt.opensocial.persistence.Person personDB) {
		PersonImpl person = new PersonImpl();
		
		/* store all the data of Person into PersonDB matching the format of data */
		person.setAboutMe(personDB.getAboutme());
		
		// set the array of accounts
		Set<PersonAccount> personAccounts = new HashSet<PersonAccount>();
		personAccounts = personDB.getAccounts();
		List<Account> accounts = new ArrayList<Account>();

		for(PersonAccount personAccount: personAccounts) {
			Account account = new AccountImpl();
			account.setDomain(personAccount.getDomain());
			//account.setUserId(personAccount.get)
			account.setUsername(personAccount.getUserName());
			accounts.add(account);
		}
		
		person.setAccounts( accounts );
		
		// set the additional information 1 of the person
		Set<PersonAdditionalInfo1> personAddInfo1s = personDB.getAdditionalInfo1s();
		
		List<String> activities = new ArrayList<String>();
		List<String> books = new ArrayList<String>();
		List<String> cars = new ArrayList<String>();
		List<String> food = new ArrayList<String>();
		List<String> heroes = new ArrayList<String>();
		List<String> interests = new ArrayList<String>();
		List<String> languagesSpoken = new ArrayList<String>();
		List<Enum<LookingFor>> lookingFor = new ArrayList<Enum<LookingFor>>();
		List<String> movies = new ArrayList<String>();
		List<String> music = new ArrayList<String>();
		List<String> quotes = new ArrayList<String>();
		List<String> sports = new ArrayList<String>();
		List<String> tags = new ArrayList<String>();
		List<String> turnOffs = new ArrayList<String>();
		List<String> turnOns = new ArrayList<String>();
		List<String> tvShows = new ArrayList<String>();
		
		for (PersonAdditionalInfo1 personAddInfo1 : personAddInfo1s) {
			
			Info1AttributeEnum attribute = personAddInfo1.getAttribute();
			
			if ( attribute.equals(Info1AttributeEnum.activities) ) {
				activities.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.books) ) {
				books.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.cars) ) {
				cars.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.food) ) {
				food.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.heroes) ) {
				heroes.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.interests) ) {
				interests.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.languagesSpoken) ) {
				languagesSpoken.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.lookingFor) ) {
				Enum<LookingFor> lookingForOne = null;
				String lf = personAddInfo1.getValue();
				
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
			} else if ( attribute.equals(Info1AttributeEnum.movies) ) {
				movies.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.music) ) {
				music.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.quotes) ) {
				quotes.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.sports) ) {
				sports.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.tags) ) {
				tags.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.turnOffs) ) {
				turnOffs.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.turnOns) ) {
				turnOns.add(personAddInfo1.getValue());
			} else if ( attribute.equals(Info1AttributeEnum.tvShows) ) {
				tvShows.add(personAddInfo1.getValue());
			}
		}
		
		person.setActivities( activities );
		person.setBooks( books );
		person.setCars( cars );
		person.setFood(food);
		person.setHeroes(heroes);
		person.setInterests(interests);
		person.setLanguagesSpoken(languagesSpoken);
		person.setLookingFor(lookingFor);
		person.setMovies(movies);
		person.setMusic(music);
		person.setQuotes(quotes);
		person.setSports(sports);
		person.setTags(tags);
		person.setTurnOffs(turnOffs);
		person.setTurnOns(turnOns);
		person.setTvShows(tvShows);
		
		
		// set the additional information 2 of the person
		Set<PersonAdditionalInfo2> personAddInfo2s = personDB.getAdditionalInfo2s();
		
		List<ListField> emails = new ArrayList<ListField>();
		List<ListField> ims = new ArrayList<ListField>();
		List<ListField> phoneNumbers = new ArrayList<ListField>();
		List<ListField> photos = new ArrayList<ListField>();
		
		
		for (PersonAdditionalInfo2 personAddInfo2 : personAddInfo2s) {
			
			Info2AttributeEnum attribute = personAddInfo2.getAttribute();
			
			if ( attribute.equals(Info2AttributeEnum.emails) ) {
				ListField email = new ListFieldImpl();
				email.setPrimary(personAddInfo2.getPrimary());
				email.setType(personAddInfo2.getType());
				email.setValue(personAddInfo2.getValue());
				
				emails.add(email);
			} else if ( attribute.equals(Info2AttributeEnum.ims) ) {
				ListField im = new ListFieldImpl();
				im.setPrimary(personAddInfo2.getPrimary());
				im.setType(personAddInfo2.getType());
				im.setValue(personAddInfo2.getValue());
				
				ims.add(im);
			} else if ( attribute.equals(Info2AttributeEnum.phoneNumbers) ) {
				ListField phoneNumber = new ListFieldImpl();
				phoneNumber.setPrimary(personAddInfo2.getPrimary());
				phoneNumber.setType(personAddInfo2.getType());
				phoneNumber.setValue(personAddInfo2.getValue());
				
				phoneNumbers.add(phoneNumber);
			} else if ( attribute.equals(Info2AttributeEnum.photos) ) {
				ListField photo = new ListFieldImpl();
				photo.setPrimary(personAddInfo2.getPrimary());
				photo.setType(personAddInfo2.getType());
				photo.setValue(personAddInfo2.getValue());
				
				photos.add(photo);
			}
		}
		
		person.setEmails(emails);
		person.setIms(ims);
		person.setPhoneNumbers(phoneNumbers);
		person.setPhotos(photos);
		
		person.setAddresses( getAddressesFromAddressDBSet( personDB.getAddresses() ) );
		person.setAge(personDB.getAge());
		person.setAppData( getAppDataMapFromAppDataDBSet( personDB.getAppData()) );
		
		person.setBirthday(personDB.getBirthday());
		
		// get BodyType Details 
		BodyType bodyType = new BodyTypeImpl();
		bodyType.setBuild(personDB.getBodytypeBuild());
		bodyType.setEyeColor(personDB.getBodytypeEyecolor());
		bodyType.setHairColor(personDB.getBodytypeHaircolor());
		
		if ( personDB.getBodytypeHeight() != null )
			bodyType.setHeight( new Float(personDB.getBodytypeHeight()) );
		else
			bodyType.setHeight( new Float(0) );
		
		if ( personDB.getBodytypeWeight() != null )
			bodyType.setWeight( new Float(personDB.getBodytypeWeight()) );
		else
			bodyType.setWeight( new Float(0) );
		
		person.setBodyType(bodyType);
		
		person.setChildren(personDB.getChildren());
		
		// get CurrentLocation Details
		AddressImpl currentLocation = new AddressImpl();
		currentLocation.setCountry(personDB.getCurrentlocationCountry());
		currentLocation.setFormatted(personDB.getCurrentlocationFormatted());
		
		if ( personDB.getCurrentlocationLatitude() != null )
			currentLocation.setLatitude( new Float(personDB.getCurrentlocationLatitude()) );
		else 
			currentLocation.setLatitude( new Float(0) );
		
		currentLocation.setLocality(personDB.getCurrentlocationLocality());
		
		if ( personDB.getCurrentlocationLongitude() != null )
			currentLocation.setLongitude( new Float(personDB.getCurrentlocationLongitude()) );
		else
			currentLocation.setLongitude( new Float(0) );
		
		currentLocation.setPostalCode(personDB.getCurrentlocationPostalcode());
		currentLocation.setPrimary(personDB.getCurrentlocationPrimary());
		currentLocation.setRegion(personDB.getCurrentlocationRegion());
		currentLocation.setStreetAddress(personDB.getCurrentlocationStreetaddress());
		currentLocation.setType(personDB.getCurrentlocationType());
		person.setCurrentLocation(currentLocation);
	
		person.setDisplayName(personDB.getDisplayname());
		
		// find ENUM value comparing the word and set it as a Drinker
		if (personDB.getDrinker() != null) {
			DrinkerEnum drinker = personDB.getDrinker();
			
			if ( drinker.equals(DrinkerEnum.HEAVILY) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.HEAVILY ) );
			} else if ( drinker.equals(DrinkerEnum.NO) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.NO ) );
			} else if ( drinker.equals(DrinkerEnum.OCCASIONALLY) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.OCCASIONALLY ) );
			} else if ( drinker.equals(DrinkerEnum.QUIT) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.QUIT ) );
			} else if ( drinker.equals(DrinkerEnum.QUITTING)) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.QUITTING ) );
			} else if ( drinker.equals(DrinkerEnum.REGULARLY) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.REGULARLY ) );
			} else if ( drinker.equals(DrinkerEnum.SOCIALLY) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.SOCIALLY ) );
			} else if ( drinker.equals(DrinkerEnum.YES) ) {
				person.setDrinker( new EnumImpl<Drinker>( Drinker.YES ) );
			}
		}
		
		
		person.setEthnicity(personDB.getEthnicity());
		person.setFashion(personDB.getFashion());
		
		// find ENUM value comparing the word and set it as a Gender
		if (personDB.getGender() != null) {
			GenderEnum gender = personDB.getGender();
			if ( gender.equals(GenderEnum.female) ) {
				person.setGender(Gender.female);
			} else if ( gender.equals(GenderEnum.male) ) {
				person.setGender(Gender.male);
			} 
		}
		
		person.setHappiestWhen(personDB.getHappiestwhen());
		person.setHasApp(personDB.getHasapp());
		
		person.setHumor(personDB.getHumor());
		person.setId(personDB.getId());
		person.setJobInterests(personDB.getJobinterests());

		person.setLivingArrangement(personDB.getLivingarrangement());

		
		// get Name Details
		NameImpl name = new NameImpl();
		name.setAdditionalName(personDB.getNameAdditionalname());
		name.setFamilyName(personDB.getNameFamilyname());
		name.setFormatted(personDB.getNameFormatted());
		name.setGivenName(personDB.getNameGivenname());
		name.setHonorificPrefix(personDB.getNameHonorificprefix());
		name.setHonorificSuffix(personDB.getNameHonorificsuffix());
		person.setName(name);
		
		// find ENUM value comparing the word and set it as a NetworkPresence
		if (personDB.getNetworkpresence() != null) {
			NetworkpresenceEnum networkPresence = personDB.getNetworkpresence();
			
			if ( networkPresence.equals(NetworkpresenceEnum.ONLINE) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.ONLINE ) );
			} else if (  networkPresence.equals(NetworkpresenceEnum.OFFLINE) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.OFFLINE ) );
			} else if (  networkPresence.equals(NetworkpresenceEnum.AWAY) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.AWAY ) );
			} else if (  networkPresence.equals(NetworkpresenceEnum.CHAT) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.CHAT ) );
			} else if (  networkPresence.equals(NetworkpresenceEnum.DND) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.DND ) );
			} else if (  networkPresence.equals(NetworkpresenceEnum.XA) ) {
				person.setNetworkPresence( new EnumImpl<NetworkPresence>( NetworkPresence.XA ) );
			} 
		}
		
		// get profileSongUrl Details
		UrlImpl profileSongUrl = new UrlImpl();
		profileSongUrl.setLinkText( personDB.getProfilesongurlLinkText() );
		profileSongUrl.setPrimary( personDB.getProfilesongurlPrimary() );
		profileSongUrl.setType( personDB.getProfilesongurlType() );
		profileSongUrl.setValue( personDB.getProfilesongurlValue() );
		person.setProfileSong(profileSongUrl);
		
		// get profileVideoUrl Details
		UrlImpl profileVideoUrl = new UrlImpl();
		profileVideoUrl.setLinkText( personDB.getProfilevideourlLinkText() );
		profileVideoUrl.setPrimary( personDB.getProfilevideourlPrimary() );
		profileVideoUrl.setType( personDB.getProfilevideourlType() );
		profileVideoUrl.setValue( personDB.getProfilevideourlValue() );
		person.setProfileVideo(profileVideoUrl);
		
		person.setNickname(personDB.getNickname());
		
		person.setOrganizations( getOrganizationListFromOrganizationDBSet(personDB.getOrganizations()) );	
		person.setPets(personDB.getPets());
		person.setPoliticalViews(personDB.getPoliticalviews());
		person.setPreferredUsername(personDB.getPreferredusername());

		person.setRelationshipStatus(personDB.getRelationshipstatus());
		person.setReligion(personDB.getReligion());
		person.setRomance(personDB.getRomance());
		person.setScaredOf(personDB.getScaredof());
		person.setSexualOrientation(personDB.getSexualorientation());
		
		// find ENUM value comparing the word and set it as a Smoker
		if (personDB.getSmoker() != null) {
			SmokerEnum smoker = personDB.getSmoker();
			
			if ( smoker.equals(SmokerEnum.HEAVILY) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.HEAVILY ) );
			} else if ( smoker.equals(SmokerEnum.NO) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.NO ) );
			} else if ( smoker.equals(SmokerEnum.OCCASIONALLY) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.OCCASIONALLY ) );
			} else if ( smoker.equals(SmokerEnum.QUIT) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.QUIT ) );
			} else if ( smoker.equals(SmokerEnum.QUITTING) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.QUITTING ) );
			} else if ( smoker.equals(SmokerEnum.REGULARLY) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.REGULARLY ) );
			} else if ( smoker.equals(SmokerEnum.SOCIALLY) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.SOCIALLY ) );
			} else if ( smoker.equals(SmokerEnum.YES) ) {
				person.setSmoker( new EnumImpl<Smoker>( Smoker.YES ) );
			}
		}
		
		person.setStatus(personDB.getStatus());
		person.setUpdated(personDB.getUpdated());
		person.setUrls( getUrlListFromUrlDBSet(personDB.getUrls()) );
		
		person.setUtcOffset( Double.doubleToLongBits(personDB.getUtcoffset()) );
		
		
		return person;
	}
	
	public static List<Url> getUrlListFromUrlDBSet(Set<PersonUrl> urlDBSet) {
		List<Url> urlList = new ArrayList<Url>();
		
		for (PersonUrl urlDB : urlDBSet) {
			Url url = new UrlImpl();
			url.setLinkText( urlDB.getLinkText() );
			url.setPrimary( urlDB.getPrimary() );
			url.setType( urlDB.getType() );
			url.setValue( urlDB.getValue() );
			
			urlList.add(url);
		}
		
		return urlList;
	}
	
	
	public static Map<String, String> getAppDataMapFromAppDataDBSet(Set<PersonAppData> appDataDBSet) {
		Map<String, String> appDataMap = new HashMap<String, String>();
		
		for (PersonAppData appDataDB : appDataDBSet) {
			appDataMap.put(appDataDB.getField(), appDataDB.getData());
		}
		
		return appDataMap;
	}
	
	
	public static List<Address> getAddressesFromAddressDBSet(Set<com.skt.opensocial.persistence.Address> addressDBSet) {
		List<Address> addressList = new ArrayList<Address>();
		
		for (com.skt.opensocial.persistence.Address addressDB : addressDBSet) {
			Address address = new AddressImpl();
			
			address.setCountry( addressDB.getCountry() );
			address.setFormatted( addressDB.getFormatted() );
			
			if ( addressDB.getLatitude() != null )
				address.setLatitude( new Float( addressDB.getLatitude() ) );
			else 
				address.setLatitude( new Float(0) );
			
			address.setLocality( addressDB.getLocality() );
			
			if ( addressDB.getLongitude() != null)
				address.setLongitude( new Float( addressDB.getLongitude() ) );
			else
				address.setLongitude( new Float(0) );
			
			address.setPostalCode( addressDB.getPostalCode() );
			address.setPrimary( addressDB.getPrimary() );
			address.setRegion( addressDB.getRegion() );
			address.setStreetAddress( addressDB.getStreetAddress() );
			address.setType( addressDB.getType() );
			
			addressList.add(address);
		}
		
		return addressList;
	}
	
	public static List<Organization> getOrganizationListFromOrganizationDBSet(Set<PersonOrganization> organizationDBSet) {
		List<Organization> organizationList = Lists.newArrayList();
		
		for(PersonOrganization organizationDB : organizationDBSet) {
			OrganizationImpl organization = new OrganizationImpl();
			
			organization.setDescription( organizationDB.getDescription() );
			organization.setEndDate( organizationDB.getEndDate() );
			organization.setField( organizationDB.getField() );
			organization.setName( organizationDB.getName() );
			organization.setPrimary( organizationDB.getPrimary() );
			organization.setSalary( organizationDB.getSalary() );
			organization.setStartDate( organizationDB.getStartDate() );
			organization.setSubField( organizationDB.getSubField() );
			organization.setTitle( organizationDB.getTitle() );
			organization.setType( organizationDB.getType() );
			organization.setWebpage( organizationDB.getWebpage() );
			
			// get Address details of the organization
			AddressImpl address = new AddressImpl();
			address.setCountry( organizationDB.getAddressCountry() );
			address.setFormatted( organizationDB.getAddressFormatted() );
			
			if ( organizationDB.getAddressLatitude() != null )
				address.setLatitude( new Float(organizationDB.getAddressLatitude()) );
			else
				address.setLatitude( new Float(0) );
			
			address.setLocality( organizationDB.getAddressLocality() );
			
			if ( organizationDB.getAddressLongitude() != null )
				address.setLongitude( new Float(organizationDB.getAddressLongitude()) );
			else
				address.setLongitude( new Float(0) );
			
			address.setPostalCode( organizationDB.getAddressPostalCode() );
			address.setPrimary( organizationDB.getAddressPrimary() );
			address.setRegion( organizationDB.getAddressRegion() );
			address.setStreetAddress( organizationDB.getAddressStreetAddress() );
			address.setType( organizationDB.getAddressType() );
			organization.setAddress(address);
			
			organizationList.add(organization);
		}
		
		return organizationList;
	}
	
	public static List<MediaItem> getMediaItemListFromMediaItemDBList(List<ActivityMediaItem> mediaItemDBList) {
		List<MediaItem> mediaItemList = new ArrayList<MediaItem>();
		
		for (ActivityMediaItem mediaItemDB : mediaItemDBList) {
			MediaItem mediaItem = new MediaItemImpl();
			mediaItem.setMimeType( mediaItemDB.getMimeType() );
			mediaItem.setThumbnailUrl( mediaItem.getThumbnailUrl() );
			mediaItem.setType( mediaItem.getType() );
			mediaItem.setUrl( mediaItem.getUrl() );
			
			mediaItemList.add(mediaItem);
		}
		
		return mediaItemList;
	}
	
	public static Map<String, String> getTemplateParamMapFromTemplateParamDBList(List<ActivityTemplateParam> templateParamDBList) {
		Map<String, String> templateParamMap = new HashMap<String, String>();
		
		for (ActivityTemplateParam templateParamDB : templateParamDBList) {
			templateParamMap.put(templateParamDB.getParamKey(), templateParamDB.getParamValue());
		}
		
		return templateParamMap;
	}
	
	public static Activity getActivityFromActivityDB(com.skt.opensocial.persistence.Activity activityDB) {
		Activity activity = new ActivityImpl();
		
		activity.setAppId( activityDB.getActivityId() );
		activity.setBody( activityDB.getBody() );
		activity.setBodyId( activityDB.getBodyId() );
		activity.setExternalId( activityDB.getExternalId() );
		activity.setId( activityDB.getActivityId() );
		activity.setPostedTime( activity.getPostedTime() );
		
		if (activityDB.getPriority() != null)
			activity.setPriority( new Float(activityDB.getPriority()) );
		else 
			activity.setPriority( new Float(0) );
		
		activity.setStreamFaviconUrl( activityDB.getStreamFaviconUrl() );
		activity.setStreamSourceUrl( activityDB.getStreamSourceUrl() );
		activity.setStreamTitle( activityDB.getStreamTitle() );
		activity.setStreamUrl( activityDB.getStreamUrl() );
		activity.setTitle( activityDB.getTitle() );
		activity.setTitleId( activityDB.getTitleId() );
		activity.setUpdated( activityDB.getUpdated() );
		activity.setUrl( activityDB.getUrl() );
		activity.setUserId( activityDB.getUserId() );
		
		return activity;
	}
	
	
	
}