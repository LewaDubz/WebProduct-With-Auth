import com.sun.security.auth.UserPrincipal;

import javax.management.relation.Role;
import javax.management.relation.RoleInfo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Servlet extends javax.servlet.http.HttpServlet {
    private String userstring ="";
    public ArrayList<User> userList = new ArrayList<User>();
    public boolean adminlogin = false;
    User administrator = new User("admin","admin");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
        RequestDispatcher rd2 = request.getRequestDispatcher("./admin.jsp");
        String button_param = request.getParameter("button");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        boolean login = false;

        if (button_param.equalsIgnoreCase("buy")){
            request.setAttribute("PurchaseThanks", "Thank you for your purchase");
            rd.forward(request, response);
        }
        if (button_param.equalsIgnoreCase("login")) {

            for (User user : userList) {
                userstring += "<br>" + user.getEmail() + "</br>";
            }
                    if (email.equalsIgnoreCase("admin@admin.com") && password.equalsIgnoreCase("admin")) {
                        adminlogin = true;
                        administrator.setRole(User.Role.admin);
                        session.setAttribute("role-name",administrator.getRole());


                    }

                System.out.println(adminlogin);
            }
                if (adminlogin == true){
                    request.setAttribute("Users",userstring);
                    rd2.forward(request,response);
                    response.sendRedirect("./admin.jsp");
                    }


            if (button_param.equalsIgnoreCase("register")) {
                if(userList.size()!=0) {
                    for (User user : userList) {
                        if (email.equalsIgnoreCase(user.getEmail())) {
                            request.setAttribute("RegisterDetails", "Sorry this email is already registered");
                            rd.forward(request, response);
                        } else {
                            userList.add(new User(email, password));
                            request.setAttribute("RegisterDetails", "Thank you for registering");
                            rd.forward(request, response);
                            System.out.println(email + " " + password);
                        }
                    }
                }
                else
                {
                    userList.add(new User(email, password));
                    request.setAttribute("RegisterDetails", "Thank you for registering");
                    rd.forward(request, response);
                    System.out.println(email + " " + password);
                }

            }
        }



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher servletRequest = request.getRequestDispatcher("./index.jsp");
        String url = request.getRequestURL().toString();
        System.out.println(url);
        System.out.println(adminlogin);
        if( adminlogin!=true){
            response.sendError(403);
            servletRequest.forward(request,response);

        }
        if(adminlogin == true && administrator.getRole().equals(User.Role.admin)){
            response.sendRedirect("/admin.jsp");
        }
        }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }
}
