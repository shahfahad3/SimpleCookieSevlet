
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String un= request.getParameter("uname");
      String pw= request.getParameter("pass");
      
      PrintWriter out=response.getWriter();
	  
	  Cookie[] c=request.getCookies();
	  String id=null;
	  if(c!=null)
	  {
		  for(int i=0;i<c.length;i++){
			  if(c[i].getName().equals("auth"))
			  {id=c[i].getValue();
				
	  }
	  break;
		  }
	  }
	  //if(id==null){
       if(un.equals("shahfahad3")&pw.equals("fahad3"))
       {
		if(id==null){   
      Cookie ck=new Cookie("auth", un);
      ck.setMaxAge(6000);
          response.addCookie(ck);
		}
		  //out.println("You are Sucessfully Logged In:");
		 //out.println("<font color=greeen>You are Sucessfully Logged In:</font>");
		  
		  //out.println("\n" + "Click here to get LOg Out");
	     
          RequestDispatcher rd = request.getRequestDispatcher("logout.html");
					 
		//out.println("You are Sucessfully Logged In:");
		  rd.forward(request, response);
   
	   }
       else
       {
          RequestDispatcher rd1 = request.getRequestDispatcher("login.html");
           out.println("<font color=red>Either user name or password is wrong.</font>");
           rd1.include(request, response);
       }
	}

}
