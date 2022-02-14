package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.geotools.kml.KMLConfiguration;
import org.geotools.xsd.Parser;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.backend.dto.ActivityData;
import com.backend.dto.activityMap;
import com.backend.dto.subActivityMap;
import com.backend.model.activities;
import com.backend.model.guestUser;
import com.backend.model.kmlFile;
import com.backend.model.subActivities;

import com.backend.repository.postgis.KMLUploadRepository;
import com.backend.repository.postgres.ActivityRepository;
import com.backend.repository.postgres.GuestUserRepository;
import com.backend.repository.postgres.SubActivityRepository;
import com.backend.service.RequestServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.util.Json;

@RestController
@RequestMapping("/kya/")
@CrossOrigin(origins = "http://localhost:8080")
public class ActivitiesController {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	SubActivityRepository subActivityRepository;
	
	@Autowired
	KMLUploadRepository kmlUploadRepository;
	
	@Autowired
	GuestUserRepository guestUserRepository;

	//Service to fetch IP Address
	@Autowired
	RequestServiceImpl requestServiceImpl;

	@RequestMapping("/test")
	public String hello() {
		return "Test Link";
	}


	@RequestMapping(value = "/newactivity", method = RequestMethod.POST)
	public String newActivity(@RequestBody activities newactivity) {
		activityRepository.save(newactivity);
		return "SUCCESS";
	}

	@RequestMapping(value = "/newsubactivity", method = RequestMethod.POST)
	public String newSubActivity(@RequestBody subActivities newactivity) {
		subActivityRepository.save(newactivity);
		return "SUCCESS";
	}

	
	//Getting all the activities from the activity schema
	@RequestMapping(value = "/getactivities", method = RequestMethod.GET)
	public List<activityMap> registerUser() {
		return (getMappedActivity(activityRepository.findAll()));

	}
	
	
	@RequestMapping(value="/getKmlFile",method=RequestMethod.GET)
	public List<kmlFile> getKMLFile() {
		return kmlUploadRepository.findAll();
	}
	
	
	/*
	@RequestMapping(value = "/userActivity", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public boolean userActivityInput(@RequestPart("json") String json, @RequestPart("file") MultipartFile file,HttpServletRequest request) {
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		ActivityData data = new ActivityData();
		try {
			data = mapper.readValue(json, ActivityData.class);
			System.out.println(data.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(file.getContentType());
		Parser parser = new Parser(new KMLConfiguration());
		SimpleFeature f;
		try {
			kmlFile kmlfile= new kmlFile();
			System.out.println("--------------------------------"+data.getActivityId());
			
			
			//File path of kml file
			System.out.println("--------------------------------Start of file ");
			
			byte[] bytes=file.getBytes();
			 System.out.print(bytes);
			
			kmlfile.setFile_kml(bytes);
			 
			
			System.out.println("--------------------------------End of file ");
			kmlfile.setActivity_id(data.getActivityId());
			System.out.println("--------------------------------"+kmlfile.getActivity_id());
			kmlfile.setSub_activity_name(data.getSubActivityId());
			kmlfile.setKmlfile_name(file.getOriginalFilename());
			
			
			f = (SimpleFeature) parser.parse( file.getInputStream() );
			Collection<SimpleFeature> placemarks =  (Collection<SimpleFeature>) f.getAttribute("Feature");
			placemarks.forEach(feature -> {
				kmlfile.setGeom((org.locationtech.jts.geom.Geometry) feature.getAttribute("Geometry"));
			});
			kmlUploadRepository.save(kmlfile);
			System.out.println("///////////////////////////////////////////////");
			System.out.println("Id of KML IS      "+kmlfile.getGid_kml());
			
			
			//Updating the guest_User table
			registerGuestUser(request,kmlfile.getGid_kml());
			
		} catch (IOException | SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	*/
	
	//Updating the table for guestUser
	public void registerGuestUser(HttpServletRequest request,Long gid_kml) {
		guestUser ob1=new guestUser();
		String ipaddress=requestServiceImpl.getClientIp(request);
		String UserAgent=request.getHeader("USER-AGENT");	
		ob1.setRemoteIP(ipaddress);
		ob1.setRemoteUserAgent(UserAgent);
		ob1.setGidKml(gid_kml);
		ob1.setUsername("Anonymous");
		guestUserRepository.save(ob1);
		System.out.println("  Guest User Table updated...");
	}
	
	//Getting mapped activity
	public List<activityMap> getMappedActivity(List<activities> activitiesList) {
		List<activityMap> responseList = new ArrayList<>();
		List<subActivities> subActivity_list = subActivityRepository.findAll();
		for (activities a : activitiesList) {
			activityMap ob1 = new activityMap();
			ob1.setActivityId(a.getId());
			ob1.setActivity_name(a.getActivity_name());
			ob1.setthreshold_parameter(a.getThreshold_parameter());
			ob1.setThreshold_unit(a.getThreshold_unit());
			ob1.setthreshold_value(a.getThreshold_value());
			for (subActivities t : subActivity_list) {
				if (a.getId() == t.getActivityId()) {
					subActivityMap obj2 = new subActivityMap();
					obj2.setSubactivityId(t.getId());
					
					//if(t.getSub_activity_name()=="NA"||t.getSub_activity_name()=="") {}
					obj2.setSub_activity_name(t.getSub_activity_name());
					
					
					obj2.setThreshold_value(t.getThreshold_value());
					obj2.setThreshold_unit(t.getThreshold_unit());
					ob1.setSubactivityMap(obj2);
				}
			}
			ob1.getSubactivityMap().sort((s1,s2) -> s1.getSub_activity_name().compareTo(s2.getSub_activity_name()));
			responseList.add(ob1);
		}
		responseList.sort((s1,s2) -> s1.getActivity_name().compareTo(s2.getActivity_name()));
		return responseList;

	}

}
