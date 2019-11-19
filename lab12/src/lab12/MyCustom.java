package lab12;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class MyCustom extends SimpleTagSupport{
	private String color;
	private String size;
	@Override
	public void doTag() throws JspException, IOException{
		LocalDate dNow = LocalDate.now();	
		DateTimeFormatter ft=DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
		if(color != null && size != null) {
			JspWriter out = getJspContext().getOut();
			out.write(String.format("<span style = 'color:%s; font-size:%s'>%s</span>", color, size, ft.format(dNow)));
		}
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
