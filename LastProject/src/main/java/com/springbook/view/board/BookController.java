package com.springbook.view.board;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BookVO;
import com.springbook.biz.common.ListComparator;


@Controller
@SessionAttributes("book")
public class BookController {
	
	@RequestMapping("/books")
	public String getBookList(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		//System.out.println("getBookList 들어는 왔어!");
		try {
			URL url = new URL("https://ij4l1qqfwi.execute-api.us-east-1.amazonaws.com/2020-06-20/books");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
			String jsonStr=br.readLine();
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
			JSONArray Items = (JSONArray)jsonObj.get("Items");
			List<BookVO> books = new ArrayList<BookVO>();
			//System.out.println(Items);
			//String code = (String) jsonObj.get("code");
			for (int i = 0; i < Items.size(); i++) {
				BookVO booklist = new BookVO();
				JSONObject object = (JSONObject) Items.get(i);
				booklist.setCode(object.get("code").toString());
				booklist.setTitle(object.get("title").toString());
				booklist.setAuthor(object.get("author").toString());
				String exit;
				if(object.get("exits").toString().equals("true")) exit="대여자있음";
				else exit="대여자없음";
				booklist.setExits(exit);
				booklist.setUserid(object.get("userid").toString());
				books.add(booklist);
			}
			Collections.sort(books,new ListComparator());
			model.addAttribute("books", books);
			con.disconnect(); //disconnect() 메서드는 특정 호스트와의 대화가 끝난 시점에 클라이언트가 서버와의 연결을 끊을 수 있도록 한다
			br.close(); //buffer 끝내기
		} catch (Exception e) {
			System.out.println("에러가 났어요 났어요잉~");
			System.out.println(e);
		}
		
		//model.addAttribute("boardList", boardDAO.getBoardList(vo));
		if(session.getAttribute("role").equals("admin"))
			return "getBookList.jsp";
		else
			return "getBookList.jsp";
	}
	
	@RequestMapping("/books/{code}")
	public String getBook(@PathVariable String code, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		
		try {
			URL url = new URL("https://ij4l1qqfwi.execute-api.us-east-1.amazonaws.com/2020-06-20/books/"+code);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
			String jsonStr=br.readLine();
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
			JSONObject Items = (JSONObject)jsonObj.get("Item");
			
			BookVO book = new BookVO();
			
			book.setCode(Items.get("code").toString());
			book.setTitle(Items.get("title").toString());
			book.setAuthor(Items.get("author").toString());
			String exit;
			if(Items.get("exits").toString().equals("true")) exit="대여자있음";
			else exit="대여자없음";
			book.setExits(exit);
			book.setUserid(Items.get("userid").toString());
			
			//System.out.println(book);
			model.addAttribute("book", book);
			con.disconnect(); //disconnect() 메서드는 특정 호스트와의 대화가 끝난 시점에 클라이언트가 서버와의 연결을 끊을 수 있도록 한다
			br.close(); //buffer 끝내기
		} catch (Exception e) {
			System.out.println("에러가 났어요 났어요잉~");
			System.out.println(e);
		}
		
		//model.addAttribute("boardList", boardDAO.getBoardList(vo));
		if(session.getAttribute("role").equals("admin"))
			return "../getBook.jsp";
		else
			return "../getBook.jsp";
	}
	
	@RequestMapping("/books/{code}/borrow")
	public String bookBorrow(@PathVariable String code, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		
		try {
			String jsonMessage = "{\"id\":\""+session.getAttribute("id")+"\"}";
			URL url = new URL("https://ij4l1qqfwi.execute-api.us-east-1.amazonaws.com/2020-06-20/books/"+code+"/borrow");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
            //json으로 message를 전달하고자 할 때 
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정 
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(jsonMessage); //json 형식의 message 전달 
			//스트림의 버퍼를 비워준다.
			writer.flush();
			writer.close();

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
//			String jsonStr=br.readLine();
//			
//			JSONParser parser = new JSONParser();
//			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
//			JSONObject Items = (JSONObject)jsonObj.get("Item");
//			
			con.disconnect(); //disconnect() 메서드는 특정 호스트와의 대화가 끝난 시점에 클라이언트가 서버와의 연결을 끊을 수 있도록 한다
			br.close(); //buffer 끝내기
		} catch (Exception e) {
			System.out.println("에러가 났어요 났어요잉~");
			System.out.println(e);
		}
		
		//model.addAttribute("boardList", boardDAO.getBoardList(vo));
		if(session.getAttribute("role").equals("admin"))
			return "../{code}";
		else
			return "../{code}";
	}
	
	@RequestMapping("/books/{code}/return")
	public String bookReturn(@PathVariable String code, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		
		try {
			String jsonMessage = "{\"id\":\""+session.getAttribute("id")+"\"}";
			URL url = new URL("https://ij4l1qqfwi.execute-api.us-east-1.amazonaws.com/2020-06-20/books/"+code+"/return");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
            //json으로 message를 전달하고자 할 때 
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정 
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(jsonMessage); //json 형식의 message 전달 
			//스트림의 버퍼를 비워준다.
			writer.flush();
			writer.close();

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
//			String jsonStr=br.readLine();
//			
//			JSONParser parser = new JSONParser();
//			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
//			JSONObject Items = (JSONObject)jsonObj.get("Item");
			
			con.disconnect(); //disconnect() 메서드는 특정 호스트와의 대화가 끝난 시점에 클라이언트가 서버와의 연결을 끊을 수 있도록 한다
			br.close(); //buffer 끝내기
		} catch (Exception e) {
			System.out.println("에러가 났어요 났어요잉~");
			System.out.println(e);
		}
		
		//model.addAttribute("boardList", boardDAO.getBoardList(vo));
		if(session.getAttribute("role").equals("admin"))
			return "../{code}";
		else
			return "../{code}";
	}
}
