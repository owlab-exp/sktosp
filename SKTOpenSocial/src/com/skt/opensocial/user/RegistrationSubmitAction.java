package com.skt.opensocial.user;

import java.util.Date;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import com.skt.opensocial.persistence.Address;
import com.skt.opensocial.persistence.DrinkerEnum;

import com.skt.opensocial.persistence.GadgetReview;
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
import com.skt.opensocial.persistence.UserVisibility;
import com.skt.opensocial.security.PasswordEncryptor;

public class RegistrationSubmitAction extends ActionSupport implements SessionAware {

	
//	@Override
//	public void setSession(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private String userIdWant;
	private String passwordWant;
	private String passwordConfirm;
	
	private boolean isDeveloper;
	private boolean isAdministrator;

	private Date registeredDate;
	
	Set<PersonAdditionalInfo2> personAdditionalInfo2;
	Set<PersonAdditionalInfo1> personAdditionalInfo1;
		
	private String userName;
	private String age;
	private String gender;
	private String birthday;
	
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
	
	private String drinker;
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
	
	private String jobInterest; // need for check
	private String jobInterest2;// need for check
	
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
	
	private String networkPresence;
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
	private String smoker;
	
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
	
	private UserVisibility userVisibility;
	private Set<GadgetReview> reviews;
	
	private String personalInfoOpen;
	private String favoriteGadgetListOpen;
	
	Session hsession;
	Transaction tran;

	public void updatePersonAdditionalInfo1() throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
				
		
			System.out.println("updatePersonAdditionalInfo1 start -----" );
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}
			
			personAdditionalInfo1 = person.getAdditionalInfo1s();
			
			if (personAdditionalInfo1 == null)
			{
				personAdditionalInfo1 = new HashSet<PersonAdditionalInfo1>();
				person.setAdditionalInfo1s(personAdditionalInfo1);
			}
			
			boolean flagSameBook = false;
			PersonAdditionalInfo1 bookAdditionalInfo1 = null;
			PersonAdditionalInfo1 book2AdditionalInfo1 = null;
			
			boolean flagSameCar = false;
			PersonAdditionalInfo1 carAdditionalInfo1 = null;
			PersonAdditionalInfo1 car2AdditionalInfo1 = null;
			
			boolean flagSameFood = false;
			PersonAdditionalInfo1 foodAdditionalInfo1 = null;
			PersonAdditionalInfo1 food2AdditionalInfo1 = null;
			
			boolean flagSameHero = false;
			PersonAdditionalInfo1 heroAdditionalInfo1 = null;
			PersonAdditionalInfo1 hero2AdditionalInfo1 = null;
			
			boolean flagSameInterest = false;
			PersonAdditionalInfo1 interestAdditionalInfo1 = null;
			PersonAdditionalInfo1 interest2AdditionalInfo1 = null;
			
			boolean flagSameLanguageSpoken = false;
			PersonAdditionalInfo1 languageSpokenAdditionalInfo1 = null;
			PersonAdditionalInfo1 languageSpoken2AdditionalInfo1 = null;
			PersonAdditionalInfo1 lookingForAdditionalInfo1 = null;
			
			boolean flagSameMovie = false;
			PersonAdditionalInfo1 movieAdditionalInfo1 = null;
			PersonAdditionalInfo1 movie2AdditionalInfo1 = null;
			
			boolean flagSameMusic = false;
			PersonAdditionalInfo1 musicAdditionalInfo1 = null;
			PersonAdditionalInfo1 music2AdditionalInfo1 = null;
			
			boolean flagSameQuote = false;
			PersonAdditionalInfo1 quoteAdditionalInfo1 = null;
			PersonAdditionalInfo1 quote2AdditionalInfo1 = null;
			
			boolean flagSameSport= false;
			PersonAdditionalInfo1 sportAdditionalInfo1 = null;
			PersonAdditionalInfo1 sport2AdditionalInfo1 = null;
			
			boolean flagSameTag= false;
			PersonAdditionalInfo1 tagAdditionalInfo1 = null;
			PersonAdditionalInfo1 tag2AdditionalInfo1 = null;
			
			boolean flagSameTurnOff= false;
			PersonAdditionalInfo1 turnOffAdditionalInfo1 = null;
			PersonAdditionalInfo1 turnOff2AdditionalInfo1 = null;
			
			boolean flagSameTurnOn= false;
			PersonAdditionalInfo1 turnOnAdditionalInfo1 = null;
			PersonAdditionalInfo1 turnOn2AdditionalInfo1 = null;
			
			boolean flagSameTvShow= false;
			PersonAdditionalInfo1 tvShowAdditionalInfo1 = null;
			PersonAdditionalInfo1 tvShow2AdditionalInfo1 = null;
			/*
			if (school != null)
				person.setSchool(school);
			else
				person.setSchool("");
			*/
			
			/*
			if (job != null)
				person.setJob(job);
			else
				person.setJob("");
			*/
			
			if (lookingFor.equals("1"))
			{
				this.setLookingFor("없음");
			}
			for (PersonAdditionalInfo1 p : personAdditionalInfo1)
			{
				if (p.getAttribute().equals(Info1AttributeEnum.books))
				{
					if (!flagSameBook)
					{
						bookAdditionalInfo1 = p;
						flagSameBook = true;
					}
					else
						book2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.cars))
				{
					if (!flagSameCar)
					{
						carAdditionalInfo1 = p;
						flagSameCar = true;
					}
					else
						car2AdditionalInfo1 = p;
				}			
				if (p.getAttribute().equals(Info1AttributeEnum.food))
				{
					if (!flagSameFood)
					{
						foodAdditionalInfo1 = p;
						flagSameFood = true;
					}
					else
						food2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.heroes))
				{
					if (!flagSameHero)
					{
						heroAdditionalInfo1 = p;
						flagSameHero = true;
					}
					else
						hero2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.interests))
				{
					if (!flagSameInterest)
					{
						interestAdditionalInfo1 = p;
						flagSameInterest = true;
					}
					else
						interest2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.languagesSpoken))
				{
					if (!flagSameLanguageSpoken)
					{
						languageSpokenAdditionalInfo1 = p;
						flagSameLanguageSpoken = true;
					}
					else
						languageSpoken2AdditionalInfo1 = p;
				}
				
				if (p.getAttribute().equals(Info1AttributeEnum.lookingFor))
				{
					lookingForAdditionalInfo1 = p;
					
				}
				if (p.getAttribute().equals(Info1AttributeEnum.movies))
				{
					if (!flagSameMovie)
					{
						movieAdditionalInfo1 = p;
						flagSameMovie = true;
					}
					else
						movie2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.music))
				{
					if (!flagSameMusic)
					{
						musicAdditionalInfo1 = p;
						flagSameMusic = true;
					}
					else
						music2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.quotes))
				{
					if (!flagSameQuote)
					{
						quoteAdditionalInfo1 = p;
						flagSameQuote = true;
					}
					else
						quote2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.sports))
				{
					if (!flagSameSport)
					{
						sportAdditionalInfo1 = p;
						flagSameSport = true;
					}
					else
						sport2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.tags))
				{
					if (!flagSameTag)
					{
						tagAdditionalInfo1 = p;
						flagSameTag = true;
					}
					else
						tag2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.turnOffs))
				{
					if (!flagSameTurnOff)
					{
						turnOffAdditionalInfo1 = p;
						flagSameTurnOff = true;
					}
					else
						turnOff2AdditionalInfo1 = p;
				}
				
				if (p.getAttribute().equals(Info1AttributeEnum.turnOns))
				{
					if (!flagSameTurnOn)
					{
						turnOnAdditionalInfo1 = p;
						flagSameTurnOn = true;
					}
					else
						turnOn2AdditionalInfo1 = p;
				}
				if (p.getAttribute().equals(Info1AttributeEnum.tvShows))
				{
					if (!flagSameTvShow)
					{
						tvShowAdditionalInfo1 = p;
						flagSameTvShow = true;
					}
					else
						tvShow2AdditionalInfo1 = p;
				}
	
			}
			
			if (bookAdditionalInfo1 == null)
				bookAdditionalInfo1 = new PersonAdditionalInfo1();
			
				bookAdditionalInfo1.setAttribute(Info1AttributeEnum.books);
				bookAdditionalInfo1.setPerson(person);
				bookAdditionalInfo1.setValue(book);
					
				personAdditionalInfo1.add(bookAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(bookAdditionalInfo1);
			
			if (book2AdditionalInfo1 == null) 
				book2AdditionalInfo1 = new PersonAdditionalInfo1();
			
				book2AdditionalInfo1.setAttribute(Info1AttributeEnum.books);
				book2AdditionalInfo1.setPerson(person);
				book2AdditionalInfo1.setValue(book2);
					
				personAdditionalInfo1.add(book2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(book2AdditionalInfo1);
			
			if (carAdditionalInfo1 == null )
				carAdditionalInfo1 = new PersonAdditionalInfo1();
				
				carAdditionalInfo1.setAttribute(Info1AttributeEnum.cars);
				carAdditionalInfo1.setPerson(person);
				carAdditionalInfo1.setValue(car);
				
				personAdditionalInfo1.add(carAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(carAdditionalInfo1);
			
			if (car2AdditionalInfo1 == null )
				car2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				car2AdditionalInfo1.setAttribute(Info1AttributeEnum.cars);
				car2AdditionalInfo1.setPerson(person);
				car2AdditionalInfo1.setValue(car2);
					
				personAdditionalInfo1.add(car2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(car2AdditionalInfo1);
			
			if (foodAdditionalInfo1 == null )
				foodAdditionalInfo1 = new PersonAdditionalInfo1();
				
				foodAdditionalInfo1.setAttribute(Info1AttributeEnum.food);
				foodAdditionalInfo1.setPerson(person);
				foodAdditionalInfo1.setValue(food);
				
				personAdditionalInfo1.add(foodAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(foodAdditionalInfo1);
				
			if (food2AdditionalInfo1 == null )
				food2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				food2AdditionalInfo1.setAttribute(Info1AttributeEnum.food);
				food2AdditionalInfo1.setPerson(person);
				food2AdditionalInfo1.setValue(food2);
				
				personAdditionalInfo1.add(food2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(food2AdditionalInfo1);
			
			if (heroAdditionalInfo1 == null )
				heroAdditionalInfo1 = new PersonAdditionalInfo1();
				
				heroAdditionalInfo1.setAttribute(Info1AttributeEnum.heroes);
				heroAdditionalInfo1.setPerson(person);
				heroAdditionalInfo1.setValue(hero);
				
				personAdditionalInfo1.add(heroAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(heroAdditionalInfo1);
			
			if (hero2AdditionalInfo1 == null )
				hero2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				hero2AdditionalInfo1.setAttribute(Info1AttributeEnum.heroes);
				hero2AdditionalInfo1.setPerson(person);
				hero2AdditionalInfo1.setValue(hero2);
				
				personAdditionalInfo1.add(hero2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(hero2AdditionalInfo1);
			
			if (interestAdditionalInfo1 == null )
				interestAdditionalInfo1 = new PersonAdditionalInfo1();
				
				interestAdditionalInfo1.setAttribute(Info1AttributeEnum.interests);
				interestAdditionalInfo1.setPerson(person);
				interestAdditionalInfo1.setValue(interest);
				
				personAdditionalInfo1.add(interestAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(interestAdditionalInfo1);
			
			if (interest2AdditionalInfo1 == null )
				interest2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				interest2AdditionalInfo1.setAttribute(Info1AttributeEnum.interests);
				interest2AdditionalInfo1.setPerson(person);
				interest2AdditionalInfo1.setValue(interest2);
				
				personAdditionalInfo1.add(interest2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(interest2AdditionalInfo1);
			
			if (languageSpokenAdditionalInfo1 == null )
				languageSpokenAdditionalInfo1 = new PersonAdditionalInfo1();
				
				languageSpokenAdditionalInfo1.setAttribute(Info1AttributeEnum.languagesSpoken);
				languageSpokenAdditionalInfo1.setPerson(person);
				languageSpokenAdditionalInfo1.setValue(languageSpoken);
				
				personAdditionalInfo1.add(languageSpokenAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(languageSpokenAdditionalInfo1);
			
			if (languageSpoken2AdditionalInfo1 == null )
				languageSpoken2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				languageSpoken2AdditionalInfo1.setAttribute(Info1AttributeEnum.languagesSpoken);
				languageSpoken2AdditionalInfo1.setPerson(person);
				languageSpoken2AdditionalInfo1.setValue(languageSpoken2);
				
				personAdditionalInfo1.add(languageSpoken2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(languageSpoken2AdditionalInfo1);
			
			if (lookingForAdditionalInfo1 == null )
				lookingForAdditionalInfo1 = new PersonAdditionalInfo1();
				
				lookingForAdditionalInfo1.setAttribute(Info1AttributeEnum.lookingFor);
				lookingForAdditionalInfo1.setPerson(person);
				lookingForAdditionalInfo1.setValue(lookingFor);
				
				personAdditionalInfo1.add(lookingForAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(lookingForAdditionalInfo1);
			
			
			
			// job interests
			/*
			if (jobInterest != null)
			{
				PersonAdditionalInfo1 jobInterestAdditionalInfo1 = new PersonAdditionalInfo1();
				
				jobInterestAdditionalInfo1.setAttribute(Info1AttributeEnum.jobinterests);
				jobInterestAdditionalInfo1.setPerson(person);
	
				jobInterestAdditionalInfo1.setValue(jobInterest);
				personAdditionalInfo1.add(jobInterestAdditionalInfo1);
				
				person.setAdditionalInfo1s(personAdditionalInfo1);
			}
			if (jobInterest2 != null)
			{
				PersonAdditionalInfo1 jobInterest2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				jobInterest2AdditionalInfo1.setAttribute(Info1AttributeEnum.jobinterests);
				jobInterest2AdditionalInfo1.setPerson(person);
				jobInterest2AdditionalInfo1.setValue(jobInterest2);
	
				personAdditionalInfo1.add(jobInterest2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
			}
			*/
			
			if (movieAdditionalInfo1 == null) 
				movieAdditionalInfo1 = new PersonAdditionalInfo1();
				
				movieAdditionalInfo1.setAttribute(Info1AttributeEnum.movies);
				movieAdditionalInfo1.setPerson(person);
				movieAdditionalInfo1.setValue(movie);
				
				personAdditionalInfo1.add(movieAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(movieAdditionalInfo1);
			
			if (movie2AdditionalInfo1 == null )
				movie2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				movie2AdditionalInfo1.setAttribute(Info1AttributeEnum.movies);
				movie2AdditionalInfo1.setPerson(person);
				movie2AdditionalInfo1.setValue(movie2);
				
				personAdditionalInfo1.add(movie2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(movie2AdditionalInfo1);
			
			if (musicAdditionalInfo1 == null )
				musicAdditionalInfo1 = new PersonAdditionalInfo1();
				
				musicAdditionalInfo1.setAttribute(Info1AttributeEnum.music);
				musicAdditionalInfo1.setPerson(person);
				musicAdditionalInfo1.setValue(music);
				
				personAdditionalInfo1.add(musicAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(musicAdditionalInfo1);
			
			if (music2AdditionalInfo1 == null )
				music2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				music2AdditionalInfo1.setAttribute(Info1AttributeEnum.music);
				music2AdditionalInfo1.setPerson(person);
				music2AdditionalInfo1.setValue(music2);
				
				personAdditionalInfo1.add(music2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(music2AdditionalInfo1);
			
			if (quoteAdditionalInfo1 == null )
				quoteAdditionalInfo1 = new PersonAdditionalInfo1();
				
				quoteAdditionalInfo1.setAttribute(Info1AttributeEnum.quotes);
				quoteAdditionalInfo1.setPerson(person);
				quoteAdditionalInfo1.setValue(quote);
				
				personAdditionalInfo1.add(quoteAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(quoteAdditionalInfo1);
			
			if (quote2AdditionalInfo1 == null )
				quote2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				quote2AdditionalInfo1.setAttribute(Info1AttributeEnum.quotes);
				quote2AdditionalInfo1.setPerson(person);
				quote2AdditionalInfo1.setValue(quote2);
				
				personAdditionalInfo1.add(quote2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(quote2AdditionalInfo1);
			
			if (sportAdditionalInfo1 == null )
				sportAdditionalInfo1 = new PersonAdditionalInfo1();
				
				sportAdditionalInfo1.setAttribute(Info1AttributeEnum.sports);
				sportAdditionalInfo1.setPerson(person);
				sportAdditionalInfo1.setValue(sport);
				
				personAdditionalInfo1.add(sportAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(sportAdditionalInfo1);
			
			if (sport2AdditionalInfo1 == null )
				sport2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				sport2AdditionalInfo1.setAttribute(Info1AttributeEnum.sports);
				sport2AdditionalInfo1.setPerson(person);
				sport2AdditionalInfo1.setValue(sport2);
				
				personAdditionalInfo1.add(sport2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(sport2AdditionalInfo1);
			
			if (tagAdditionalInfo1 == null) 
				tagAdditionalInfo1 = new PersonAdditionalInfo1();
				
				tagAdditionalInfo1.setAttribute(Info1AttributeEnum.tags);
				tagAdditionalInfo1.setPerson(person);
				tagAdditionalInfo1.setValue(tag);
				
				personAdditionalInfo1.add(tagAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(tagAdditionalInfo1);
			
			if (tag2AdditionalInfo1 == null )
				tag2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				tag2AdditionalInfo1.setAttribute(Info1AttributeEnum.tags);
				tag2AdditionalInfo1.setPerson(person);
				tag2AdditionalInfo1.setValue(tag2);
				
				personAdditionalInfo1.add(tag2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(tag2AdditionalInfo1);
						
			if (turnOffAdditionalInfo1 == null) 
				turnOffAdditionalInfo1 = new PersonAdditionalInfo1();
				
				turnOffAdditionalInfo1.setAttribute(Info1AttributeEnum.turnOffs);
				turnOffAdditionalInfo1.setPerson(person);
				turnOffAdditionalInfo1.setValue(turnOff);
				
				personAdditionalInfo1.add(turnOffAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(turnOffAdditionalInfo1);
			
			if (turnOff2AdditionalInfo1 == null )
				turnOff2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				turnOff2AdditionalInfo1.setAttribute(Info1AttributeEnum.turnOffs);
				turnOff2AdditionalInfo1.setPerson(person);
				turnOff2AdditionalInfo1.setValue(turnOff2);
				
				personAdditionalInfo1.add(turnOff2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(turnOff2AdditionalInfo1);
			
			if (turnOnAdditionalInfo1 == null )
				turnOnAdditionalInfo1 = new PersonAdditionalInfo1();
				
				turnOnAdditionalInfo1.setAttribute(Info1AttributeEnum.turnOns);
				turnOnAdditionalInfo1.setPerson(person);
				turnOnAdditionalInfo1.setValue(turnOn);
				
				personAdditionalInfo1.add(turnOnAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(turnOnAdditionalInfo1);
			
			if (turnOn2AdditionalInfo1 == null )
				turnOn2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				turnOn2AdditionalInfo1.setAttribute(Info1AttributeEnum.turnOns);
				turnOn2AdditionalInfo1.setPerson(person);
				turnOn2AdditionalInfo1.setValue(turnOn2);
				
				personAdditionalInfo1.add(turnOn2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(turnOn2AdditionalInfo1);
			
			
			if (tvShowAdditionalInfo1 == null )
				tvShowAdditionalInfo1 = new PersonAdditionalInfo1();
				
				tvShowAdditionalInfo1.setAttribute(Info1AttributeEnum.tvShows);
				tvShowAdditionalInfo1.setPerson(person);
				tvShowAdditionalInfo1.setValue(tvShow);
				
				personAdditionalInfo1.add(tvShowAdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(tvShowAdditionalInfo1);
			
			if (tvShow2AdditionalInfo1 == null )
				tvShow2AdditionalInfo1 = new PersonAdditionalInfo1();
				
				tvShow2AdditionalInfo1.setAttribute(Info1AttributeEnum.tvShows);
				tvShow2AdditionalInfo1.setPerson(person);
				tvShow2AdditionalInfo1.setValue(tvShow2);
				
				personAdditionalInfo1.add(tvShow2AdditionalInfo1);
				person.setAdditionalInfo1s(personAdditionalInfo1);
				hsession.saveOrUpdate(tvShow2AdditionalInfo1);
				
			hsession.saveOrUpdate(person);
			tran.commit();
		} 
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	
	public void updatePersonURL () throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}

			Set<PersonUrl> personUrls = person.getUrls();
			
			if (personUrls == null )
			{
				personUrls = new HashSet<PersonUrl>();
				person.setUrls(personUrls);
				
			}
			//System.out.println("updatePersonAddress, num of addresses -----" + addresses.size());
			
			boolean flagSameProfile = false;
			PersonUrl profilePersonUrl = null;
			
			boolean flagSameThumbnail = false;
			PersonUrl thumbnailPersonUrl = null;
						
			for (PersonUrl p : personUrls)
			{
				if (profileUrlAddress != null && !profileUrlAddress.isEmpty())
				{
					if (p.getType().equals("profile")
							&& p.getPrimary())
					{
						profilePersonUrl = p;
						flagSameProfile = true;
					}
				}
				if (thumbnailUrlAddress != null && !thumbnailUrlAddress.isEmpty())
				{
					if (p.getType().equals("thumbnail")
							&& p.getPrimary())
					{
						thumbnailPersonUrl = p;
						flagSameThumbnail = true;
					}
				}
			
			}
			if (profileUrlAddress != null && !profileUrlAddress.isEmpty())
			{
				if (flagSameProfile == false && profilePersonUrl == null)
					profilePersonUrl = new PersonUrl();
				
				profilePersonUrl.setLinkText(profileUrlLinktext);
				profilePersonUrl.setPerson(person);
				profilePersonUrl.setPrimary(true);
				profilePersonUrl.setType("profile");
				profilePersonUrl.setValue(profileUrlAddress);
													
				personUrls.add(profilePersonUrl);
				person.setUrls(personUrls);
				hsession.saveOrUpdate(profilePersonUrl);
			}
			if (thumbnailUrlAddress != null && !thumbnailUrlAddress.isEmpty())
			{
				if (flagSameThumbnail == false && thumbnailPersonUrl == null)
					thumbnailPersonUrl = new PersonUrl();
				
				thumbnailPersonUrl.setLinkText(thumbnailUrlLinktext);
				thumbnailPersonUrl.setPerson(person);
				thumbnailPersonUrl.setPrimary(true);
				thumbnailPersonUrl.setType("thumbnail");
				thumbnailPersonUrl.setValue(thumbnailUrlAddress);
													
				personUrls.add(thumbnailPersonUrl);
				person.setUrls(personUrls);
				hsession.saveOrUpdate(thumbnailPersonUrl);
			}
				
			hsession.saveOrUpdate(person);
			tran.commit();
			
		}
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	public void updatePersonOrganization () throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			Person person = (Person) hsession.get(Person.class, userIdWant);
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}

			Set<PersonOrganization> personOrganizations = person.getOrganizations();
			
			if (personOrganizations == null )
			{
				personOrganizations = new HashSet<PersonOrganization>();
				person.setOrganizations(personOrganizations);
				
			}
			//System.out.println("updatePersonAddress, num of addresses -----" + addresses.size());
			
			boolean flagSameJob = false;
			PersonOrganization jobPersonOrganization = null;
			
			boolean flagSameJob2 = false;
			PersonOrganization job2PersonOrganization = null;
			
			boolean flagSameSchool = false;
			PersonOrganization schoolPersonOrganization = null;
			
			boolean flagSameSchool2 = false;
			PersonOrganization school2PersonOrganization = null;
			
			for (PersonOrganization p : personOrganizations)
			{
				if (job != null && !job.isEmpty())
				{
					if (p.getType().equals("job")
							&& p.getPrimary())
					{
						jobPersonOrganization = p;
						flagSameJob = true;
					}
				}
				if (job2 != null && !job2.isEmpty())
				{
					if (p.getType().equals("job")
							&& !p.getPrimary())
					{
						job2PersonOrganization = p;
						flagSameJob2 = true;
					}
				}
				if (school != null && !school.isEmpty())
				{
					if (p.getType().equals("school")
							&& p.getPrimary())
					{
						schoolPersonOrganization = p;
						flagSameSchool = true;
					}
				}
				if (school2 != null && !school2.isEmpty())
				{
					if (p.getType().equals("school")
							&& !p.getPrimary())
					{
						school2PersonOrganization = p;
						flagSameSchool2 = true;
					}
				}
				
			}
			if (job != null && !job.isEmpty())
			{
				if (flagSameJob == false && jobPersonOrganization == null)
					jobPersonOrganization = new PersonOrganization();
				
				jobPersonOrganization.setName(job);
				jobPersonOrganization.setPerson(person);
				jobPersonOrganization.setType("job");
				jobPersonOrganization.setPrimary(true);
				
				jobPersonOrganization.setAddressLatitude(Double.valueOf(1));	
				jobPersonOrganization.setAddressLongitude(Double.valueOf(1));
				jobPersonOrganization.setAddressPrimary(true);
				
				personOrganizations.add(jobPersonOrganization);
				person.setOrganizations(personOrganizations);
				hsession.saveOrUpdate(jobPersonOrganization);
			}
			if (job2 != null && !job2.isEmpty())
			{
				if (flagSameJob2 == false && job2PersonOrganization == null)
					job2PersonOrganization = new PersonOrganization();
				
				job2PersonOrganization.setName(job2);
				job2PersonOrganization.setPerson(person);
				job2PersonOrganization.setType("job");
				job2PersonOrganization.setPrimary(false);
				
				job2PersonOrganization.setAddressLatitude(Double.valueOf(1));	
				job2PersonOrganization.setAddressLongitude(Double.valueOf(1));
				job2PersonOrganization.setAddressPrimary(true);
				
				personOrganizations.add(job2PersonOrganization);
				person.setOrganizations(personOrganizations);
				hsession.saveOrUpdate(job2PersonOrganization);
			}
			if (school != null && !school.isEmpty())
			{
				if (flagSameSchool == false && schoolPersonOrganization == null)
					schoolPersonOrganization = new PersonOrganization();
				
				schoolPersonOrganization.setName(school);
				schoolPersonOrganization.setPerson(person);
				schoolPersonOrganization.setType("school");
				schoolPersonOrganization.setPrimary(true);
					
				schoolPersonOrganization.setAddressLatitude(Double.valueOf(1));	
				schoolPersonOrganization.setAddressLongitude(Double.valueOf(1));
				schoolPersonOrganization.setAddressPrimary(true);
				
				
				personOrganizations.add(schoolPersonOrganization);
				person.setOrganizations(personOrganizations);
				hsession.saveOrUpdate(schoolPersonOrganization);
			}
			if (school2 != null && !school2.isEmpty())
			{
				if (flagSameSchool2 == false && school2PersonOrganization == null)
					school2PersonOrganization = new PersonOrganization();
				
				school2PersonOrganization.setName(school2);
				school2PersonOrganization.setPerson(person);
				school2PersonOrganization.setType("school");
				school2PersonOrganization.setPrimary(false);
				
				school2PersonOrganization.setAddressLatitude(Double.valueOf(1));	
				school2PersonOrganization.setAddressLongitude(Double.valueOf(1));
				school2PersonOrganization.setAddressPrimary(true);
				
				personOrganizations.add(school2PersonOrganization);
				person.setOrganizations(personOrganizations);
				hsession.saveOrUpdate(school2PersonOrganization);
			}		
			hsession.saveOrUpdate(person);
			tran.commit();
			
		}
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	public void updatePersonAddress () throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			//System.out.println("updatePersonAddress starts -----" + address);
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}
					
			// address
			Set<Address> addresses = person.getAddresses();
			
			if (addresses == null )
				addresses = new HashSet<Address>();
			
			//System.out.println("updatePersonAddress, num of addresses -----" + addresses.size());
			
			
				boolean flagSameAddress = false;
				Address tmpAddress = null;
							
				for (Address a : addresses)
				{
					if (a.getPrimary())
					{
						tmpAddress = a;
						flagSameAddress = true;
					}
				}
				if (flagSameAddress == false && tmpAddress == null)
					tmpAddress = new Address(); 
					
				tmpAddress.setFormatted(address);
				tmpAddress.setPerson(person);
				tmpAddress.setType("first");
				tmpAddress.setPrimary(true);
				tmpAddress.setLatitude(Double.valueOf(1));
				tmpAddress.setLongitude(Double.valueOf(1));
				
				addresses.add(tmpAddress);
				person.setAddresses(addresses);
				hsession.saveOrUpdate(tmpAddress);
			//System.out.println("updatePersonAddress, num of addresses -----" + address2);
			
			
				boolean flagSameAddress2 = false;
				Address tmpAddress2 = null;
				
				for (Address a : addresses)
				{
					if (!a.getPrimary())
					{
						tmpAddress2 = a;
						flagSameAddress2 = true;
					}
				}
				if (flagSameAddress2 == false && tmpAddress2 == null)
					tmpAddress2 = new Address(); 
				
				tmpAddress2.setFormatted(address2);
				tmpAddress2.setPerson(person);
				tmpAddress2.setType("second");
				tmpAddress2.setPrimary(false);
				tmpAddress2.setLatitude(Double.valueOf(1));
				tmpAddress2.setLongitude(Double.valueOf(1));
				
				addresses.add(tmpAddress2);
				person.setAddresses(addresses);
				hsession.saveOrUpdate(tmpAddress2);
					
			
			hsession.saveOrUpdate(person);
			tran.commit();
		} 
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	
	public void updatePersonAdditionalInfo2() throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			
			System.out.println("updatePersonAdditionalInfo2 start -----" );
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}
			
			personAdditionalInfo2 = person.getAdditionalInfo2s();
			
			if (personAdditionalInfo2 == null)
			{
				personAdditionalInfo2 = new HashSet<PersonAdditionalInfo2>();
				person.setAdditionalInfo2s(personAdditionalInfo2);
			}
			
			// email
			//PersonAdditionalInfo2 emailAdditionalInfo2 = (PersonAdditionalInfo2) session.get(PersonAdditionalInfo2.class, 0);
			
			boolean flagSameEmail = false;
			PersonAdditionalInfo2 emailAdditionalInfo2 = null;
			
			boolean flagSameEmail2 = false;
			PersonAdditionalInfo2 email2AdditionalInfo2 = null;
			
			boolean flagSamePhoneNumber = false;
			PersonAdditionalInfo2 phoneNumberAdditionalInfo2 = null;
			
			boolean flagSamePhoneNumber2 = false;
			PersonAdditionalInfo2 phoneNumber2AdditionalInfo2 = null;
			
			for (PersonAdditionalInfo2 p : personAdditionalInfo2)
			{
				
					if (p.getAttribute().equals(Info2AttributeEnum.emails)
							&& p.getPrimary())
					{
						emailAdditionalInfo2 = p;
						flagSameEmail = true;
					}
				
				
					if (p.getAttribute().equals(Info2AttributeEnum.emails)
							&& !p.getPrimary())
					{
						email2AdditionalInfo2 = p;
						flagSameEmail2 = true;
					}
				
				
					if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers)
							&& p.getPrimary())
					{
						phoneNumberAdditionalInfo2 = p;
						flagSamePhoneNumber = true;
					}
				
				
					if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers)
							&& !p.getPrimary())
					{
						phoneNumber2AdditionalInfo2 = p;
						flagSamePhoneNumber2 = true;
					}
				
			}
			
				if (flagSameEmail == false && emailAdditionalInfo2 == null)
					emailAdditionalInfo2 = new PersonAdditionalInfo2();
				
				emailAdditionalInfo2.setAttribute(Info2AttributeEnum.emails);
				emailAdditionalInfo2.setPerson(person);
				emailAdditionalInfo2.setValue(email);
				emailAdditionalInfo2.setType("first");
				emailAdditionalInfo2.setPrimary(true);
					
				personAdditionalInfo2.add(emailAdditionalInfo2);
				person.setAdditionalInfo2s(personAdditionalInfo2);
				hsession.saveOrUpdate(emailAdditionalInfo2);
			
				if (flagSameEmail2 == false && email2AdditionalInfo2 == null)
					email2AdditionalInfo2 = new PersonAdditionalInfo2();
						
				email2AdditionalInfo2.setAttribute(Info2AttributeEnum.emails);
				email2AdditionalInfo2.setPerson(person);
				email2AdditionalInfo2.setValue(email2);
				email2AdditionalInfo2.setType("second");
				email2AdditionalInfo2.setPrimary(false);
					
				personAdditionalInfo2.add(email2AdditionalInfo2);
				person.setAdditionalInfo2s(personAdditionalInfo2);
				hsession.saveOrUpdate(email2AdditionalInfo2);
			
				if (flagSamePhoneNumber == false && phoneNumberAdditionalInfo2 == null)
					phoneNumberAdditionalInfo2 = new PersonAdditionalInfo2();
						
				phoneNumberAdditionalInfo2.setAttribute(Info2AttributeEnum.phoneNumbers);
				phoneNumberAdditionalInfo2.setPerson(person);
				phoneNumberAdditionalInfo2.setValue(phoneNumber);
				phoneNumberAdditionalInfo2.setType(phoneType);
				phoneNumberAdditionalInfo2.setPrimary(true);
				
				personAdditionalInfo2.add(phoneNumberAdditionalInfo2);
				person.setAdditionalInfo2s(personAdditionalInfo2);
				hsession.saveOrUpdate(phoneNumberAdditionalInfo2);
			
				if (flagSamePhoneNumber2 == false && phoneNumber2AdditionalInfo2 == null)
					phoneNumber2AdditionalInfo2 = new PersonAdditionalInfo2();
				
				phoneNumber2AdditionalInfo2.setAttribute(Info2AttributeEnum.phoneNumbers);
				phoneNumber2AdditionalInfo2.setPerson(person);
				phoneNumber2AdditionalInfo2.setValue(phoneNumber2);
				phoneNumber2AdditionalInfo2.setType(phoneType2);
				phoneNumber2AdditionalInfo2.setPrimary(false);	
				
				personAdditionalInfo2.add(phoneNumber2AdditionalInfo2);
				person.setAdditionalInfo2s(personAdditionalInfo2);
				hsession.saveOrUpdate(phoneNumber2AdditionalInfo2);
			
					
			hsession.saveOrUpdate(person);
			tran.commit();
		} 
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	
	public void updatePersonBasic() throws Exception
	{
		Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			
			//User user = (User) hsession.get(User.class, userIdWant);
			
			System.out.println("updatePersonBasic start -----" );
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			//user = (User) hsession.get(User.class, userIdWant);
			
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}
			person.setNameFormatted(userName);
			person.setDisplayname(userName);
			
			// visibility
			if (personalInfoOpen != null && !personalInfoOpen.isEmpty())
				person.setProfileurl(personalInfoOpen);
			else
				person.setProfileurl(InfoOpenEnum.ALL);
			
			if (favoriteGadgetListOpen != null && !favoriteGadgetListOpen.isEmpty())
				person.setThumbnailurl(favoriteGadgetListOpen);
			else
				person.setThumbnailurl(InfoOpenEnum.ALL);
									
			// age
			if (age != null && !age.isEmpty())
				person.setAge(Integer.parseInt(age));
			else
				person.setAge(1);
			
			// gender
			if (gender.equals("male"))
				person.setGender(GenderEnum.male);
			else if (gender.equals("female"))
				person.setGender(GenderEnum.female);
			
	
			// date-of-birth
			try
			{
				java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
				
				java.util.Date date = format.parse(birthday);
				
				person.setBirthday(date);
					
			}
			catch (java.text.ParseException ex)
			{
				ex.printStackTrace();
				person.setBirthday(null);
			}
	
			
			System.out.println("user date of birth completed -----" );
			
			person.setUpdated(new Date());
			
			// aboutMe
			if (aboutMe != null && !aboutMe.isEmpty())
				person.setAboutme(aboutMe);
			else
				person.setAboutme("");
			
			// bodytype
			if (bodytypeBuild != null && !bodytypeBuild.isEmpty())
				person.setBodytypeBuild(bodytypeBuild);
			else
				person.setBodytypeBuild("");
			
			if (bodytypeEyecolor != null && !bodytypeEyecolor.isEmpty())
				person.setBodytypeEyecolor(bodytypeEyecolor);
			else
				person.setBodytypeEyecolor("");
			
			if (bodytypeHaircolor != null && !bodytypeHaircolor.isEmpty())
				person.setBodytypeHaircolor(bodytypeHaircolor);
			else
				person.setBodytypeHaircolor("");
			
			if (bodytypeHeight > 0)
				person.setBodytypeHeight(bodytypeHeight);
			else
				person.setBodytypeHeight(Double.valueOf("1"));
			if (bodytypeWeight > 0)
				person.setBodytypeWeight(bodytypeWeight);
			else
				person.setBodytypeWeight(Double.valueOf("1"));
					
					
			// children
			if (children != null && !children.isEmpty())
				person.setChildren(children);
			else
				person.setChildren("");
			
			// currentLocation
			if (currentLocation != null && !currentLocation.isEmpty())
				person.setCurrentlocationFormatted(currentLocation);
			else
				person.setCurrentlocationFormatted("");
					
			// drinker
			if (!drinker.equals("1"))
				person.setDrinker(DrinkerEnum.valueOf(drinker));
	
			// ethnicity
			if (ethnicity != null && !ethnicity.isEmpty())
				person.setEthnicity(ethnicity);
			else
				person.setEthnicity("");
			
			// fashion
			if (fashion != null && !fashion.isEmpty())
				person.setFashion(fashion);
			else
				person.setFashion("");
									
			// happiesWhen
			if (happiestWhen != null && !happiestWhen.isEmpty())
				person.setHappiestwhen(happiestWhen);
			else
				person.setHappiestwhen("");
			
					
			// humor
			if (humor != null && !humor.isEmpty())
				person.setHumor(humor);
			else
				person.setHumor("");
					
			// livingArrangement
			if (livingArrangement != null && !livingArrangement.isEmpty())
				person.setLivingarrangement(livingArrangement);
			else
				person.setLivingarrangement("");
					
			// additionalName
			if (additionalName != null && !additionalName.isEmpty())
				person.setNameAdditionalname(additionalName);
			else
				person.setNameAdditionalname("");
			
			// familyName
			if (familyName != null && !familyName.isEmpty())
				person.setNameFamilyname(familyName);
			else
				person.setNameFamilyname("");
			
			// givenName
			if (givenName != null && !givenName.isEmpty())
				person.setNameGivenname(givenName);
			else
				person.setNameGivenname("");
			
			// honorificPrefix
			if (honorificPrefix != null && !honorificPrefix.isEmpty() )
				person.setNameHonorificprefix(honorificPrefix);
			else
				person.setNameHonorificprefix("");
			
			// honorificSuffix
			if (honorificSuffix != null && !honorificSuffix.isEmpty())
				person.setNameHonorificsuffix(honorificSuffix);
			else
				person.setNameHonorificsuffix("");
			
			// jobInterest
			if (jobInterest != null && !jobInterest.isEmpty())
				person.setJobinterests(jobInterest);
			else
				person.setJobinterests("");
			
			// networkPresence
			if (!networkPresence.equals("1"))
				person.setNetworkpresence(NetworkpresenceEnum.valueOf(networkPresence));
	
			// nickname
			if (nickname != null && !nickname.isEmpty())
				person.setNickname(nickname);
			else
				person.setNickname("");
			
			// pets
			if (pets != null && !pets.isEmpty())
				person.setPets(pets);
			else
				person.setPets("");
					
			// politicalViews
			if (politicalViews != null && !politicalViews.isEmpty())
				person.setPoliticalviews(politicalViews);
			else
				person.setPoliticalviews("");
			
			// profilesongUrlAddress
			if (profilesongUrlAddress != null && !profilesongUrlAddress.isEmpty())
				person.setProfilesongurlValue(profilesongUrlAddress);
			else
				person.setProfilesongurlValue("");
			
			//profilesongUrlLinktext
			if (profilesongUrlLinktext != null && !profilesongUrlLinktext.isEmpty())
				person.setProfilesongurlLinkText(profilesongUrlLinktext);
			else
				person.setProfilesongurlLinkText("");
			
			// profilesongUrlType
			if (profilesongUrlType != null && !profilesongUrlType.isEmpty())
				person.setProfilesongurlType(profilesongUrlType);
			else
				person.setProfilesongurlType("");
			
			// profilevideoUrlAddress
			if (profilevideoUrlAddress != null && !profilevideoUrlAddress.isEmpty())
				person.setProfilevideourlValue(profilevideoUrlAddress);
			else
				person.setProfilevideourlValue("");
			
			//profilevideoUrlLinktext
			if (profilevideoUrlLinktext != null && !profilevideoUrlLinktext.isEmpty())
				person.setProfilevideourlLinkText(profilevideoUrlLinktext);
			else
				person.setProfilevideourlLinkText("");
			
			// profilevideoUrlType
			//System.out.println("user updatePersonBasic start profilevideoUrlType -----" + profilevideoUrlType);
			if (profilevideoUrlType != null && !profilevideoUrlType.isEmpty())
				person.setProfilevideourlType(profilevideoUrlType);
			else
				person.setProfilevideourlType("");
					
			// relationshipStatus
			if (relationshipStatus != null && !relationshipStatus.isEmpty())
				person.setRelationshipstatus(relationshipStatus);
			else
				person.setRelationshipstatus("");
			
			// religion
			if (religion != null && !religion.isEmpty())
				person.setReligion(religion);
			else
				person.setReligion("");
			
			// romance
			if (romance != null && !romance.isEmpty())
				person.setRomance(romance);
			else
				person.setRomance("");
			
			// scaredOf
			if (scaredOf != null && !scaredOf.isEmpty())
				person.setScaredof(scaredOf);
			else
				person.setScaredof("");
			
			// sexualOrientation
			if (sexualOrientation != null && !sexualOrientation.isEmpty())
				person.setSexualorientation(sexualOrientation);
			else
				person.setSexualorientation("");
			
			// smoker
			if (!smoker.equals("1"))
				person.setSmoker(SmokerEnum.valueOf(smoker));
					
			// status
			if (status != null && !status.isEmpty())
				person.setStatus(status);
			else
				person.setStatus("");
						
			//user.setPerson(person);
			//hsession.saveOrUpdate(user);
			hsession.saveOrUpdate(person);
			tran.commit();
		} 
		catch (Exception e) 
		{
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	
	public void updateDefaults() throws Exception
	{
		hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = null;
		
		try
		{
			tran = hsession.beginTransaction();
			Person person = (Person) hsession.get(Person.class, userIdWant);
			//user = (User) hsession.get(User.class, userIdWant);
			
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}
			person.setCurrentlocationLatitude(Double.valueOf("1"));
			person.setCurrentlocationLongitude(Double.valueOf("1"));
			person.setCurrentlocationPrimary(true);
			person.setHasapp(false);
			person.setUtcoffset(Double.valueOf("1"));
			
			hsession.saveOrUpdate(person);
			
			tran.commit();
			
		} catch (Exception e) {
			if (tran != null)
				tran.rollback();
			throw e;
		}
	}
	
	public String execute() throws Exception{
		hsession = HibernateUtil.getSessionFactory().getCurrentSession();
		tran = null;
		
//		try
//		{
			tran = hsession.beginTransaction();
		
			System.out.println("user registration start -----" );
			
			User user = (User) hsession.get(User.class, userIdWant);
			if(user == null) {
				user = new User();
				user.setId(userIdWant);
			}
			else
			{
				addFieldError("userIdWant", "use other userId");
				tran.rollback();
				return "fail";
			}
			
			Person person = (Person) hsession.get(Person.class, userIdWant);
			//user = (User) hsession.get(User.class, userIdWant);
			
			if(person == null) {
				person = new Person();
				person.setUser(user);
			}					
			
			
			if (passwordWant.isEmpty() || !passwordWant.equals(passwordConfirm))
			{
				addFieldError("passwordWant", "password error");
				tran.rollback();
				return "fail";
			}
			
			if (userName.isEmpty())
			{
				addFieldError("userName", "userName error");
				tran.rollback();
				return "fail";
			}
			if (email.isEmpty())
			{
				addFieldError("email", "email error");
				tran.rollback();
				return "fail";
				
			}
			
			
			PasswordEncryptor pe = PasswordEncryptor.getInstance();
			String hashedPassword = pe.encrypt(passwordWant);
			
			userVisibility = new UserVisibility();
//			
//			// visibility
//			if (personalInfoOpen != null && !personalInfoOpen.isEmpty())
//				userVisibility.setAddresses(personalInfoOpen);
//			else
//				userVisibility.setAddresses(InfoOpenEnum.ALL);
//			
//			if (favoriteGadgetListOpen != null && !favoriteGadgetListOpen.isEmpty())
//				userVisibility.setAge(favoriteGadgetListOpen);
//			else
//				userVisibility.setAge(InfoOpenEnum.ALL);
//						
//			userVisibility.setUser(user);
//			//userVisibility.setUserId(userIdWant);
//			
//			user.setUserVisibility(userVisibility);
			
			//
			user.setPassword(hashedPassword);
			user.setIsAdministrator(false);
			user.setIsDeveloper(false);
			user.setRegisteredDate(new Date());
			
			hsession.saveOrUpdate(user);
			//hsession.saveOrUpdate(userVisibility);
			hsession.saveOrUpdate(person);
			
			//hsession.saveOrUpdate(userVisibility);
			tran.commit();
			
			
			this.updatePersonBasic();
			this.updateDefaults();
			this.updatePersonAddress();
			this.updatePersonAdditionalInfo1();
			this.updatePersonAdditionalInfo2();
			this.updatePersonOrganization();
			this.updatePersonURL();
			
			return Action.SUCCESS;
//		} catch (Exception e) {
//			if (tran != null)
//				tran.rollback();
//			throw e;
//		}
	}
	
	
	// Properties to receive login request parameters
	
	private Map<String, Object> session;
	public String getUserIdWant() {
		return userIdWant;
	}

	public void setUserIdWant(String userIdWant) {
		this.userIdWant = userIdWant;
	}

	public String getPasswordWant() {
		return passwordWant;
	}

	public void setPasswordWant(String passwordWant) {
		this.passwordWant = passwordWant;
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


	public String getPasswordConfirm() {
		return passwordConfirm;
	}


	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
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


	public String getHappiestWhen() {
		return happiestWhen;
	}


	public void setHappiestWhen(String happiestWhen) {
		this.happiestWhen = happiestWhen;
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


	public String getHumor() {
		return humor;
	}


	public void setHumor(String humor) {
		this.humor = humor;
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


	public String getJobInterest2() {
		return jobInterest2;
	}


	public void setJobInterest2(String jobInterest2) {
		this.jobInterest2 = jobInterest2;
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


	public String getLivingArrangement() {
		return livingArrangement;
	}


	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
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


	public String getSmoker() {
		return smoker;
	}


	public void setSmoker(String smoker) {
		this.smoker = smoker;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public Set<PersonAdditionalInfo2> getPersonAdditionalInfo2() {
		return personAdditionalInfo2;
	}


	public void setPersonAdditionalInfo2(
			Set<PersonAdditionalInfo2> personAdditionalInfo2) {
		this.personAdditionalInfo2 = personAdditionalInfo2;
	}


	public Set<PersonAdditionalInfo1> getPersonAdditionalInfo1() {
		return personAdditionalInfo1;
	}


	public void setPersonAdditionalInfo1(
			Set<PersonAdditionalInfo1> personAdditionalInfo1) {
		this.personAdditionalInfo1 = personAdditionalInfo1;
	}

	public Session getHsession() {
		return hsession;
	}

	public void setHsession(Session hsession) {
		this.hsession = hsession;
	}

	public Transaction getTran() {
		return tran;
	}

	public void setTran(Transaction tran) {
		this.tran = tran;
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
