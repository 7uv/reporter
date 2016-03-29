// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DisplaySourceServlet.java

package org.displaytag.sample;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DisplaySourceServlet extends HttpServlet
{

    public DisplaySourceServlet()
    {
    }

    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String jspFile = request.getRequestURI();
        jspFile = jspFile.substring(0, jspFile.lastIndexOf("."));
        if(jspFile.lastIndexOf("/") != -1)
            jspFile = jspFile.substring(jspFile.lastIndexOf("/") + 1);
        if(!jspFile.startsWith("example-"))
            throw new ServletException("Invalid file selected: " + jspFile);
        String fullName = "/" + jspFile;
        InputStream inputStream = getServletContext().getResourceAsStream(fullName);
        if(inputStream == null)
            throw new ServletException("Unable to find JSP file: " + jspFile);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
        out.println("<head>");
        out.println("<title>");
        out.println("source for " + jspFile);
        out.println("</title>");
        out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\" />");
        out.println("</head>");
        out.println("<body>");
        out.println("<pre>");
        for(int currentChar = inputStream.read(); currentChar != -1; currentChar = inputStream.read())
            if(currentChar == 60)
                out.print("&lt;");
            else
                out.print((char)currentChar);

        out.println("</pre>");
        out.println("</body>");
        out.println("</html>");
    }

    private static final long serialVersionUID = 0xd1597a17a6L;
    private static final String EXAMPLE_FOLDER = "/";
}
