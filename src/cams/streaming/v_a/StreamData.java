package cams.streaming.v_a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StreamData
 */
@WebServlet("/sdata")
public class StreamData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
	    {
	        System.out.println("SSE Demo");
	        response.setContentType("text/event-stream, charset=UTF-8");
	        
	        PrintWriter pw = response.getWriter();
	        int i=0;
	        while(true)
	        {

	            i++;
	            pw.write("event: server-time\n\n");  //take note of the 2 \n 's, also on the next line.
	            pw.write("data: "+ i + "\n\n");
	            System.out.println("Data Sent!!!"+i);
	            if(i>10)
	            break;
	        }
	        pw.close();

	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
