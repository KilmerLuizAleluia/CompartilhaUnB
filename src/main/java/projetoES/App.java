package projetoES;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.ServletContextAware;

@SpringBootApplication
@EnableJpaRepositories
public class App implements ServletContextAware {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

  @Bean
  public ServletRegistrationBean getFacesServlet() {
    return new ServletRegistrationBean(new FacesServlet(), "*.jsf");
  }

  @Override
  public void setServletContext(ServletContext arg0) {
    arg0.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
  }

}
