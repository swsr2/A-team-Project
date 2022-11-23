package com.spring.project.event.service;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.spring.project.event.dao.EventDAO;
import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ResAirplaneDTO;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.event.dto.RoomInfoDTO;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventDAO eventDAO;

	@Override
	public List<AirplaneDTO> departList(AirplaneDTO air) throws Exception {
		// TODO Auto-generated method stub\
		
		int num = 500;
		String date = air.getAir_date();
		String arrival  = air.getAir_arrivalPlace();
		String depart = air.getAir_departPlace();
		for(int page=1;page<15;page++) {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/FlightScheduleList/getDflightScheduleList"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("AwmMLhe4jxnpCn5X58peOTwfXl8d1+ezHnHWmPU60OjNkFpph/bx8tyV1b1TNxpyhCtLvqmm2QKUXFIoyl4tsQ==","UTF-8")); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("schDate","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*검색일자*/
			urlBuilder.append("&" + URLEncoder.encode("schDeptCityCode","UTF-8") + "=" + URLEncoder.encode(arrival, "UTF-8")); /*출발 도시 코드*/
			urlBuilder.append("&" + URLEncoder.encode("schArrvCityCode","UTF-8") + "=" + URLEncoder.encode(depart, "UTF-8")); /*도착 도시 코드*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page+"","UTF-8"));
			URL url = new URL(urlBuilder.toString());
			Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
			documentInfo.getDocumentElement().normalize();

			NodeList nList = documentInfo.getElementsByTagName("item");

			for(int i=0;i<nList.getLength();i++) {
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					air = new AirplaneDTO();
					Element eElement = (Element) nNode;
					air.setAir_no(num++);
					air.setAir_airline(getTagValue("airlineKorean",eElement));
					air.setAir_date(date);
					air.setAir_departPlace(getTagValue("startcity",eElement));
					air.setAir_arrivalPlace(getTagValue("arrivalcity",eElement));
					air.setAir_departTime(getTagValue("domesticStartTime",eElement));
					air.setAir_arrivalTime(getTagValue("domesticArrivalTime",eElement));
					air.setAir_price(55000);
					eventDAO.addAirplane(air);
				}
			}
		}
		List<AirplaneDTO> airplaneList = eventDAO.airListTo();
		return airplaneList;
	}

	@Override
	public List<AirplaneDTO> arrivalList(AirplaneDTO air) throws Exception {
		// TODO Auto-generated method stub
		int num = 100;
		String date = air.getAir_date();
		String arrival  = air.getAir_departPlace();
		String depart = air.getAir_arrivalPlace();
		for(int page=1;page<15;page++) {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/FlightScheduleList/getDflightScheduleList"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("AwmMLhe4jxnpCn5X58peOTwfXl8d1+ezHnHWmPU60OjNkFpph/bx8tyV1b1TNxpyhCtLvqmm2QKUXFIoyl4tsQ==","UTF-8")); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("schDate","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*검색일자*/
			urlBuilder.append("&" + URLEncoder.encode("schDeptCityCode","UTF-8") + "=" + URLEncoder.encode(arrival, "UTF-8")); /*출발 도시 코드*/
			urlBuilder.append("&" + URLEncoder.encode("schArrvCityCode","UTF-8") + "=" + URLEncoder.encode(depart, "UTF-8")); /*도착 도시 코드*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page+"","UTF-8"));
			URL url = new URL(urlBuilder.toString());

			Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
			documentInfo.getDocumentElement().normalize();

			NodeList nList = documentInfo.getElementsByTagName("item");

			for(int i=0;i<nList.getLength();i++) {
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					air = new AirplaneDTO();
					Element eElement = (Element) nNode;
					air.setAir_no(num++);
					air.setAir_airline(getTagValue("airlineKorean",eElement));
					air.setAir_date(date);
					air.setAir_departPlace(getTagValue("startcity",eElement));
					air.setAir_arrivalPlace(getTagValue("arrivalcity",eElement));
					air.setAir_departTime(getTagValue("domesticStartTime",eElement));
					air.setAir_arrivalTime(getTagValue("domesticArrivalTime",eElement));
					air.setAir_price(55000);
					eventDAO.addAirplane(air);
				}	
			}
		}
		List<AirplaneDTO> airplaneList = eventDAO.airListFrom();
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

	@Override
	public int allLodCnt() {
		// TODO Auto-generated method stub
		return eventDAO.allLodCnt();
	}

	@Override
	public List<LodgingDTO> lodList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return eventDAO.lodList(page);
	}

	@Override
	public LodgingDTO lodDatail(int lod_id) {
		// TODO Auto-generated method stub
		return eventDAO.lodDatail(lod_id);
	}

	@Override
	public List<RoomInfoDTO> roomList(int lod_id) {
		// TODO Auto-generated method stub
		return eventDAO.roomList(lod_id);
	}

	@Override
	public RoomInfoDTO roomInfo(RoomInfoDTO room) {
		// TODO Auto-generated method stub
		return eventDAO.roomInfo(room);
	}

	@Override
	public int addLodRes(LodgingResDTO res) {
		// TODO Auto-generated method stub
		return eventDAO.addLodRes(res);
	}

	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		eventDAO.myPick(pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		eventDAO.delPick(pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// TODO Auto-generated method stub
		return eventDAO.checkPcik(pickMap);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return eventDAO.addReview(review);
	}

	@Override
	public List<ReviewDTO> reviewList(int lod_id) {
		// TODO Auto-generated method stub
		return eventDAO.reviewList(lod_id);
	}

	@Override
	public ResAirplaneDTO selectAir(int air_no) {
		// TODO Auto-generated method stub
		return eventDAO.selectAir(air_no);
	}

	@Override
	public void resAirplane(ResAirplaneDTO resAir) {
		// TODO Auto-generated method stub
		eventDAO.resAirplane(resAir);
	}
}
