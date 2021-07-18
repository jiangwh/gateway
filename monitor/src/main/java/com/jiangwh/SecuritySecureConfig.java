//package com.jiangwh;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().
//				anyRequest().permitAll().
////				antMatchers("/assets/**").permitAll().
////				antMatchers("/login").permitAll().
////				anyRequest().authenticated().
//				and().csrf().disable();
//	}
//
//	//	private final String adminContextPath;
////
////	public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
////		this.adminContextPath = adminServerProperties.getContextPath();
////	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		// @formatter:off
////		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
////		successHandler.setTargetUrlParameter("redirectTo");
////		successHandler.setDefaultTargetUrl(adminContextPath + "/");
////
////		http.authorizeRequests()
////				.antMatchers(adminContextPath + "/assets/**").permitAll()
////				.antMatchers(adminContextPath + "/login").permitAll()
////				.anyRequest().authenticated()
////				.and()
////				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
////				.logout().logoutUrl(adminContextPath + "/logout").and()
////				.httpBasic().and()
////				.csrf()
////				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
////				.ignoringAntMatchers(
////						"/instances",
////						"/actuator/**"
////				);
////		// @formatter:on
////	}
//}