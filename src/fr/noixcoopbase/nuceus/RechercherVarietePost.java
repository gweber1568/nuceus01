package fr.noixcoopbase.nuceus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.noixcoop.nuceus.MetierVarietes;
import fr.noixcoop.nuceus.Variete;

/**
 * Servlet implementation class RechercherVarietePost
 */
@WebServlet("/RechercherVarietePost")
public class RechercherVarietePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherVarietePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MetierVarietes metier = new MetierVarietes() ;
		
		try{
			Variete variete = metier.consulter(request.getParameter("variete")) ;
			
			if (variete != null){
				response.setContentType("text/html");
				PrintWriter sortie = response.getWriter();
				sortie.println("<html><body><table><tr><th>Libellé</th><th>AOC</th></tr><tr><th>"+variete.getLibelle()+"</th><th>"+variete.isAoc()+"</th></tr></table></body></html>");
			}
			else if(variete == null){
				response.setContentType("text/html");
				PrintWriter sortie = response.getWriter();
				sortie.println("<html><body><table><tr><th>Libellé</th><th>AOC</th></tr><tr><th>Variété inconnue.</th><th>Faux</th></tr></table></body></html>");
			}
		}
		catch(Exception e ){
			e.getMessage() ;
		}
	}

}
