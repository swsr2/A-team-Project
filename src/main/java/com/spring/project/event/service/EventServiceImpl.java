package com.spring.project.event.service;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.spring.project.event.dao.EventDAO;
import com.spring.project.event.dto.AirplaneDTO;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventDAO eventDAO;

	@Override
	public List<AirplaneDTO> departList(AirplaneDTO air) throws Exception {
		// TODO Auto-generated method stub\
		List<AirplaneDTO> airplaneList = new ArrayList<AirplaneDTO>();
		String date = air.getAir_date();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/FlightScheduleList/getDflightScheduleList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("AwmMLhe4jxnpCn5X58peOTwfXl8d1+ezHnHWmPU60OjNkFpph/bx8tyV1b1TNxpyhCtLvqmm2QKUXFIoyl4tsQ==","UTF-8")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("schDate","UTF-8") + "=" + URLEncoder.encode(air.getAir_date(), "UTF-8")); /*검색일자*/
        urlBuilder.append("&" + URLEncoder.encode("schDeptCityCode","UTF-8") + "=" + URLEncoder.encode(air.getAir_arrivalPlace(), "UTF-8")); /*출발 도시 코드*/
        urlBuilder.append("&" + URLEncoder.encode("schArrvCityCode","UTF-8") + "=" + URLEncoder.encode(air.getAir_departPlace(), "UTF-8")); /*도착 도시 코드*/
        URL url = new URL(urlBuilder.toString());
        
        Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
        documentInfo.getDocumentElement().normalize();
        
        NodeList nList = documentInfo.getElementsByTagName("item");
        
        for(int i=0;i<nList.getLength();i++) {
        	Node nNode = nList.item(i);
        	if(nNode.getNodeType() == Node.ELEMENT_NODE) {
        		air = new AirplaneDTO();
        		Element eElement = (Element) nNode;
        		air.setAir_no(201+i);
        		air.setAir_airline(getTagValue("airlineKorean",eElement));
        		air.setAir_date(date);
        		air.setAir_departPlace(getTagValue("startcity",eElement));
        		air.setAir_arrivalPlace(getTagValue("arrivalcity",eElement));
        		air.setAir_departTime(getTagValue("domesticStartTime",eElement));
        		air.setAir_arrivalTime(getTagValue("domesticArrivalTime",eElement));
        		air.setAir_price(55000);
        		eventDAO.addAirplane(air);
        		airplaneList.add(air);
        	}
        }
		return airplaneList;
	}
	
	@Override
	public List<AirplaneDTO> arrivalList(AirplaneDTO air) throws Exception {
		// TODO Auto-generated method stub
		List<AirplaneDTO> airplaneList = new ArrayList<AirplaneDTO>();
		String date = air.getAir_date();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/FlightScheduleList/getDflightScheduleList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("AwmMLhe4jxnpCn5X58peOTwfXl8d1+ezHnHWmPU60OjNkFpph/bx8tyV1b1TNxpyhCtLvqmm2QKUXFIoyl4tsQ==","UTF-8")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("schDate","UTF-8") + "=" + URLEncoder.encode(air.getAir_date(), "UTF-8")); /*검색일자*/
        urlBuilder.append("&" + URLEncoder.encode("schDeptCityCode","UTF-8") + "=" + URLEncoder.encode(air.getAir_departPlace(), "UTF-8")); /*출발 도시 코드*/
        urlBuilder.append("&" + URLEncoder.encode("schArrvCityCode","UTF-8") + "=" + URLEncoder.encode(air.getAir_arrivalPlace(), "UTF-8")); /*도착 도시 코드*/
        URL url = new URL(urlBuilder.toString());
        
        Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
        documentInfo.getDocumentElement().normalize();
        
        NodeList nList = documentInfo.getElementsByTagName("item");
        
        for(int i=0;i<nList.getLength();i++) {
        	Node nNode = nList.item(i);
        	if(nNode.getNodeType() == Node.ELEMENT_NODE) {
        		air = new AirplaneDTO();
        		Element eElement = (Element) nNode;
        		air.setAir_no(101+i);
        		air.setAir_airline(getTagValue("airlineKorean",eElement));
        		air.setAir_date(date);
        		air.setAir_departPlace(getTagValue("startcity",eElement));
        		air.setAir_arrivalPlace(getTagValue("arrivalcity",eElement));
        		air.setAir_departTime(getTagValue("domesticStartTime",eElement));
        		air.setAir_arrivalTime(getTagValue("domesticArrivalTime",eElement));
        		air.setAir_price(55000);
        		eventDAO.addAirplane(air);
        		airplaneList.add(air);
        	}	
        }
		
		return airplaneList;
	}

	
	private static String getTagValue(String tag, Element eElement) {
		// TODO Auto-generated method stub
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if(nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}


	@Override
	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to) {
		// TODO Auto-generated method stub
		AirplaneDTO airplane_from = eventDAO.selectAir_no_from(air_no_from);
		AirplaneDTO airplane_to = eventDAO.selectAir_no_to(air_no_to);
		
		List<AirplaneDTO> airplaneList = new ArrayList<AirplaneDTO>();
		airplaneList.add(airplane_from);
		airplaneList.add(airplane_to);
		
		return airplaneList;
	}

	@Override
	public void resetAir() {
		// TODO Auto-generated method stub
		eventDAO.resetAir();
	}



	
	/*
	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return eventDAO.addReview(review);
	}
	*/
}
