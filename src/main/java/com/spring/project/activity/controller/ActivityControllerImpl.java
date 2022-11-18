package com.spring.project.activity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.activity.service.ActivityService;
import com.spring.project.food.dto.FoodDTO;


@Controller("activityController")
@RequestMapping("/activity")
public class ActivityControllerImpl implements ActivityController{
	@Autowired
	ActivityService activityService;


	@Override
	@RequestMapping("/main")
	public String activity(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 테스트 하실때 공유드라이브에 api 받아오기 텍스트 파일안 내용을 요기다 넣고 한번 돌리시면
		// api 내용이 db에 저장이 될 겁니다 db에서 테이블 이랑 시퀀스 만들고 돌려주세요
		// api 정보를 url 을 통해서 가져오기
			// c1 : 관광, c2 : 쇼핑, c3 : 숙박, c4 : 음식점, c5 : 축제/행사/액티비티, c6 : 테마여행
		
		
		
		
		int ActivityCnt = activityService.allActivityCnt();

		int postNum = 12;

		int pageNum = (int)Math.ceil((double)ActivityCnt/postNum);

		int start = page * postNum;

		int end = start + (postNum-1);

		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);

		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)ActivityCnt / (double)pageNum_cnt));

		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= ActivityCnt ? false : true;

		List<ActivityDTO> activityList = activityService.activityList(start, end);
		request.setAttribute("activityList", activityList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		return "/activity/activitymain";
	}

	@Override
	@RequestMapping("/crs")
	public String crs(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int crsCnt = activityService.allCrsCnt();

		int postNum = 12;

		int pageNum = (int)Math.ceil((double)crsCnt/postNum);
		int start = page * postNum;

		int end = start + (postNum-1);

		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);

		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)crsCnt / (double)pageNum_cnt));

		if(endPageNum > endPageNum_tmp) {
			 endPageNum = endPageNum_tmp;
			}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= crsCnt ? false : true;

		List<ActivityDTO> crsList = activityService.crsList(start, end);
		request.setAttribute("crsList", crsList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/activity/crs";
	}

}
