package com.study.springbootydy.web.controller;

import com.study.springbootydy.web.dto.RequestStudyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerStudy {

    @GetMapping("/study/page")
    public String 페이지응답(){
        return "page_study";
    }

    @ResponseBody
    @GetMapping("/study/text/1")
    public String 문자열데이터응답(){
        return "문자열 응답";
    }

    @ResponseBody
    @GetMapping("/study/text/2")
    public String 요청데이터params(String data1, int data2){
        return "문자열 : "+data1+ ", 숫자 : "+data2;
    }
////// 여기까지는 기본
    @ResponseBody
    @PostMapping("/study/student/1")
    public String getJsonAjax(@RequestBody RequestStudyDto requestStudyDto){
        return requestStudyDto.toString(); // requestBody로 script를 통해 json 형태로 가져온다.
    }

//    @ResponseBody
//    @GetMapping("/study/student/1")
//    public Object getJsonAjax2(){ // object로 해서
//        RequestStudyDto requestStudyDto = new RequestStudyDto();
//        requestStudyDto.setName("ehdud");
//        requestStudyDto.setPhonenumber("01011111111");
//        requestStudyDto.setEmail("ehdud05264@naver.com");
//        requestStudyDto.setAddress("김해 율하");
//
//        return requestStudyDto;
//    } 또 다른 방법 Object 활용

    @ResponseBody
    @GetMapping("/study/student/2")
    public ResponseEntity<?> getJsonAjax2(){
        RequestStudyDto requestStudyDto = new RequestStudyDto();
        requestStudyDto.setName("ehdud");
        requestStudyDto.setPhonenumber("01011111111");
        requestStudyDto.setEmail("ehdud05264@naver.com");
        requestStudyDto.setAddress("김해 율하");

        return new ResponseEntity<>(requestStudyDto, HttpStatus.OK);
    }

}
