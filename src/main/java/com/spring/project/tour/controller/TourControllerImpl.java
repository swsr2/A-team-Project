package com.spring.project.tour.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.tour.dto.TourDTO;
import com.spring.project.tour.service.TourService;

@Controller("tourController")
@RequestMapping("/tour")
public class TourControllerImpl implements TourController {
	@Autowired
	TourService tourService;
	
	@Override
	@RequestMapping("/main")
	public String tourmain(@RequestParam("page") int page,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 테스트 하실때 공유드라이브에 api 받아오기 텍스트 파일안 내용을 요기다 넣고 한번 돌리시면
		// api 내용이 db에 저장이 될 겁니다 db에서 테이블 이랑 시퀀스 만들고 돌려주세요
		
		String API_KEY = "txwoaa25joo8ac4y";

		String result = "";
		try{
			// api 정보를 url 을 통해서 가져오기
			URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?"
					+ "apiKey="+API_KEY+"&locale=kr&category=c1&page=19");
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			result = bf.readLine();
			
			
			JSONParser par = new JSONParser();
			// 받아온 api result 를 JSONObject에 저장
			JSONObject obj = (JSONObject) par.parse(result);
			// 저장된 object 의 값이 여러개 이기때문에 JSONArray 를 이용해서 list형식 로 분할
			// items는 api 에서의 칼럼명 같은 거
			JSONArray items = (JSONArray) obj.get("items");
			
			// 데이터를 가져와서 일반적으로 저장할 리스트
			List<TourDTO> tourList = new ArrayList<TourDTO>();
			
			// items 에 있는 필요한 데이터들을 하나씩 가져와서 FoodDTO 에 저장 후 db에 보내서 insert하는 과정
			for(int i=0;i<items.size();i++) {
				JSONObject item = (JSONObject) items.get(i);
				JSONObject repPhoto = (JSONObject) item.get("repPhoto");
				JSONObject photoid = (JSONObject) repPhoto.get("photoid");
				TourDTO tour = new TourDTO();
				tour.setTr_title((String)item.get("title"));
				tour.setTr_info((String)item.get("introduction"));
				if(item.get("address") == null){
					tour.setTr_address("없음");
				}else {
					tour.setTr_address((String)item.get("address"));
				}
				if(item.get("roadaddress") == null){
					tour.setTr_roadAddress("없음");
				}else {
					tour.setTr_roadAddress((String)item.get("roadaddress"));
				}
				if(item.get("phoneno") == null){
					tour.setTr_phoneNo("없음");
				}else {
					tour.setTr_phoneNo((String)item.get("phoneno"));
				}	
				tour.setTr_imgPath((String)photoid.get("imgpath"));
				tour.setTr_thumbnailPath((String)photoid.get("thumbnailpath"));
				tour.setTr_category((String)item.get("tag"));
				tourService.dbInsert(tour);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
		int FoodCnt = tourService.allTourCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)FoodCnt/postNum);
		
		int start = page * postNum;
		
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)FoodCnt / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= FoodCnt ? false : true;

		List<TourDTO> tourList = tourService.tourList(start, end);
		request.setAttribute("tourList", tourList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/tourmain";
	}
	
	@Override
	@RequestMapping("/orumm")
	public String orumm(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int cafeCnt = tourService.allOrummCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)cafeCnt/postNum);
		int start = page * postNum;
		
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)cafeCnt / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= cafeCnt ? false : true;

		List<TourDTO> orummList = tourService.orummList(start, end);
		request.setAttribute("orummList", orummList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/orumm";
	}
	
	@Override
	@RequestMapping("/beach")
	public String beach(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int cafeCnt = tourService.allBeachCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)cafeCnt/postNum);
		int start = page * postNum;
		
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)cafeCnt / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= cafeCnt ? false : true;

		List<TourDTO> beachList = tourService.beachList(start, end);
		request.setAttribute("beachList", beachList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/beach";
	}


	
}
