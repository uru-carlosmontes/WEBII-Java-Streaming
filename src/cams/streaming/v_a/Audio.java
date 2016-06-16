package cams.streaming.v_a;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Audio
 */
@WebServlet("/audio")
public class Audio extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Audio() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream ("c:/test/audio.mp3");
		String mimeType = "audio/mp3";
		byte[] bytes = new byte[1024];
		int bytesRead;

		response.setContentType(mimeType);

		while ((bytesRead = in.read(bytes)) != -1) {
		    out.write(bytes, 0, bytesRead);
		}

		// do the following in a finally block:
		in.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
