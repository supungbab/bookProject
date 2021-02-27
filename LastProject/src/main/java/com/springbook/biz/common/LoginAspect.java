package com.springbook.biz.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {
	
	@Before(("PointcutCommon.allPointcut()"))
	public void logincheck(JoinPoint jp) throws Throwable{
		System.out.println("컨트롤러 시전하기 전!" + jp.getSignature().getName());
		HttpServletRequest request = null;
		HttpServletResponse response = null;
        //String method = pjp.getSignature().getName();
        
        for(Object o:jp.getArgs()){ //파라미터 목록을 구함  그중 Request를 찾음, 세션얻기 위함과 URL 얻기위함
            if(o instanceof HttpServletRequest){
                request = (HttpServletRequest) o;
            }
        }
        for(Object o2:jp.getArgs()){ //파라미터 목록을 구함  그중 Response 를 찾음 sendRedirect 하기위함
            if(o2 instanceof HttpServletResponse){
                response = (HttpServletResponse) o2;
            }
        }
        if(response==null) {
        	System.out.println("리스폰스에 아무것도 없다!!");
        }
		if(request!=null) {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			String URL=request.getRequestURL().toString();
			if(!(URL.endsWith("/login.do")||URL.endsWith("/join.do"))) {
				//System.out.println("여기는 로그인이 아니야!");
				//System.out.println("id"+id+"id");
				if(id==null||id.equals("")) {
					System.out.println("나는 누구 여긴어디");
					session.setAttribute("userName", "");
					session.setAttribute("id", "");
					session.setAttribute("role", "");
					response.sendRedirect("login.do");
					return ;
				}
			}
		}
		//return "login.do"; 리턴 값으로 넘겨도 페이지가 안넘어감. 타입이랑 전현 상관없었음
		//System.out.println(jp.getArgs()[2]);
		
		//System.out.println("메서드 파라메터" + session.getAttribute("id"));
	} 
}
