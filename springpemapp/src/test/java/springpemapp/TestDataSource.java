package springpemapp;



import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.springpemapp.configuration.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		
		ApplicationContext actx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = actx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "insert into users(name,phone,email,loginName,password) values (?,?,?,?,?)";
		Object[] params = new Object[] {"Minerva Shrivastava", "0980989080", "m@gmail.com", "minerva", "123"};
		jt.update(sql, params);
		System.out.println("------------SQL updated --------------");
		
	}
}
