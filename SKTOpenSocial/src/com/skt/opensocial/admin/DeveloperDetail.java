package com.skt.opensocial.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**	관리자가 개발자의 상세 정보를 확인하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
public class DeveloperDetail extends ManageDeveloperAction{
	
	/** jsp페이지 로부터 넘겨 받은 개발자 ID
	 * 
	 */
	private String developerId;
	private User developer;
	/** 출력되는 개발자의 상세 정보
	 * 
	 */
	public List displayList;
	
	/** 개발자의 ID를 받아 개발자의 상세 정보를 가져옴
	 * 
	 */
	public String execute() throws Exception{
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
			developer = (User)hs.load(User.class, developerId);
	
			setUser_id(developer.getId());
			setDeveloper(developer.isIsDeveloper());
			setAdministrator(developer.isIsAdministrator());
			setPassword(developer.getPassword());
			setRegisteredDate(developer.getRegisteredDate());
			setPerson(developer.getPerson());
			setUserVisibility(developer.getUserVisibility());
	//System.out.println("aboutnme" + this.developer.getPerson().getAboutme());
			setPerson_id(developer.getPerson().getId());
			setUser(developer.getPerson().getUser());
			setUpdated(developer.getPerson().getUpdated());
			setAboutme(developer.getPerson().getAboutme());
			setAge(developer.getPerson().getAge());
			setBirthday(developer.getPerson().getBirthday());
			setBodytypeBuild(developer.getPerson().getBodytypeBuild());
			setBodytypeEyecolor(developer.getPerson().getBodytypeEyecolor());
			setBodytypeHaircolor(developer.getPerson().getBodytypeHaircolor());
			setBodytypeHeight(developer.getPerson().getBodytypeHeight());
			setBodytypeWeight(developer.getPerson().getBodytypeWeight());
			setChildren(developer.getPerson().getChildren());
			setCurrentlocationCountry(developer.getPerson().getCurrentlocationCountry());
			setCurrentlocationLatitude(developer.getPerson().getCurrentlocationLatitude());
			setCurrentlocationLongitude(developer.getPerson().getCurrentlocationLongitude());
			setCurrentlocationLocality(developer.getPerson().getCurrentlocationLocality());
			setCurrentlocationPostalcode(developer.getPerson().getCurrentlocationPostalcode());
			setCurrentlocationRegion(developer.getPerson().getCurrentlocationRegion());
			setCurrentlocationStreetaddress(developer.getPerson().getCurrentlocationStreetaddress());
			setCurrentlocationType(developer.getPerson().getCurrentlocationType());
			setCurrentlocationFormatted(developer.getPerson().getCurrentlocationFormatted());
			setCurrentlocationPrimary(developer.getPerson().getCurrentlocationPrimary());
			setDisplayname(developer.getPerson().getDisplayname());
			setDrinker(developer.getPerson().getDrinker());
			setEthnicity(developer.getPerson().getEthnicity());
			setFashion(developer.getPerson().getFashion());
			setGender(developer.getPerson().getGender());
			setHappiestwhen(developer.getPerson().getHappiestwhen());
			setHasapp(developer.getPerson().getHasapp());
			setHumor(developer.getPerson().getHumor());
			setJobinterests(developer.getPerson().getJobinterests());
			setLivingarrangement(developer.getPerson().getLivingarrangement());
			setNameAdditionalname(developer.getPerson().getNameAdditionalname());
			setNameFamilyname(developer.getPerson().getNameFamilyname());
			setNameGivenname(developer.getPerson().getNameGivenname());
			setNameHonorificprefix(developer.getPerson().getNameHonorificprefix());
			setNameHonorificsuffix(developer.getPerson().getNameHonorificsuffix());
			setNameFormatted(developer.getPerson().getNameFormatted());
			setNetworkpresence(developer.getPerson().getNetworkpresence());
			setNickname(developer.getPerson().getNickname());
			setPets(developer.getPerson().getPets());
			setPoliticalviews(developer.getPerson().getPoliticalviews());
			setPreferredusername(developer.getPerson().getPreferredusername());
			setRelationshipstatus(developer.getPerson().getRelationshipstatus());
			setReligion(developer.getPerson().getReligion());
			setRomance(developer.getPerson().getRomance());
			setScaredof(developer.getPerson().getScaredof());
			setSexualorientation(developer.getPerson().getSexualorientation());
			setSmoker(developer.getPerson().getSmoker());
			setStatus(developer.getPerson().getStatus());
			setUtcoffset(developer.getPerson().getUtcoffset());
			setProfilesongurlValue(developer.getPerson().getProfilesongurlValue());
			setProfilesongurlLinkText(developer.getPerson().getProfilesongurlLinkText());
			setProfilesongurlType(developer.getPerson().getProfilesongurlType());
			setProfilesongurlPrimary(developer.getPerson().getProfilesongurlPrimary());
			setProfilevideourlValue(developer.getPerson().getProfilevideourlValue());
			setProfilevideourlLinkText(developer.getPerson().getProfilevideourlLinkText());
			setProfilevideourlType(developer.getPerson().getProfilevideourlType());
			setProfilevideourlPrimary(developer.getPerson().getProfilevideourlPrimary());
			setProfilesongurl(developer.getPerson().getProfilesongurl());
			setProfilevideourl(developer.getPerson().getProfilevideourl());
			setProfileurl(developer.getPerson().getProfileurl());
			setThumbnailurl(developer.getPerson().getThumbnailurl());
	
			hs.getTransaction().commit();
	
			return "SUCCESS";
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public List getDisplayList() {
		String[] temp	= {
				"person_id",
				"updated",
				"aboutme",
				"age",
				"birthday",
				"bodytypebuild",
				"bodytypeeyecolor",
				"bodytypehaircolor",
				"bodytypeheight",
				"bodytypeweight",
				"children",
				"currentlocationcountry",
				"currentlocationlatitude",
				"currentlocationlongitude",
				"currentlocationlocality",
				"currentlocationpostalcode",
				"currentlocationregion",
				"currentlocationstreetaddress",
				"currentlocationtype",
				"currentlocationformatted",
				"currentlocationprimary",
				"displayname",
				"drinker",
				"ethnicity",
				"fashion",
				"gender",
				"happiestwhen",
				"hasapp",
				"humor",
				"jobinterests",
				"livingarrangement",
				"nameadditionalname",
				"namefamilyname",
				"namegivenname",
				"namehonorificprefix",
				"namehonorificsuffix",
				"nameformatted",
				"networkpresence",
				"nickname",
				"pets",
				"politicalviews",
				"preferredusername",
				"relationshipstatus",
				"religion",
				"romance",
				"scaredof",
				"sexualorientation",
				"smoker",
				"status",
				"utcoffset",
				"profilesongurlvalue",
				"profilesongurllinktext",
				"profilesongurltype",
				"profilesongurlprimary",
				"profilevideourlvalue",
				"profilevideourllinktext",
				"profilevideourltype",
				"profilevideourlprimary",
				"profilesongurl",
				"profilevideourl",
				"profileurl",
				"thumbnailurl"
		};
		displayList	= Arrays.asList(temp);
		return displayList;
	}

	public void setDisplayList(List displayList) {
		this.displayList = displayList;
	}
	

}
