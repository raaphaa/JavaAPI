
package tech.jaya.project.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.jaya.project.data.UserDetailData;
import tech.jaya.project.domain.User;
import tech.jaya.project.dto.UserAuthenticatedDTO;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {
	
	
	private String token;

	public static final int TOKEN_EXPIRATION = 180000_000;

	public static final String TOKEN_PASSWORD = "4f4c74ef-7284-4ef2-97b9-905dcf64d09d";

	private final AuthenticationManager authenticationManager;

	public JWTAuthFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException("User not found", e);
		}

	}

	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserDetailData userData = (UserDetailData) authResult.getPrincipal();

		token = JWT.create().withSubject(userData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
				.sign(Algorithm.HMAC512(TOKEN_PASSWORD));
		
		
		UserAuthenticatedDTO user = new UserAuthenticatedDTO();
		user.setName(userData.getName());
		user.setEmail(userData.getEmail());
		user.setId(userData.getId());
		user.setToken(token);
		
		/*
		 * response.getWriter().println(user.getId());
		 * response.getWriter().write(token); response.getWriter().flush();
		 */
		
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper= new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(user);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonString);
		out.flush();
		
	}

	public String getToken() {
		return token;
	}


}
