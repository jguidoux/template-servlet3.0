package com.codetutr;


import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jguidoux on 27/10/15.
 */
public class MappingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain");
		Map<String, ? extends ServletRegistration> servletRegistrations = req.getSession().getServletContext()
		                                                                     .getServletRegistrations();

		Set<Mapping> mappings = new HashSet<>();
		Gson gson = new Gson();
		for (Map.Entry<String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {
			mappings.add(new Mapping(entry.getValue().getClassName(), entry.getValue().getMappings()));
		}

		String json = gson.toJson(mappings);
		resp.getWriter().write(json);
	}
}
