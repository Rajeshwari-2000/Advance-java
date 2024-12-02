package com.demo.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CalculateTagHandler extends TagSupport{
private int num1,num2;

public int getNum1() {
	return num1;
}

public void setNum1(int num1) {
	this.num1 = num1;
}

public int getNum2() {
	return num2;
}

public void setNum2(int num2) {
	this.num2 = num2;
}
public int doStartTag() {
	return EVAL_BODY_INCLUDE;
}

public int doEndTag() {
	JspWriter out=pageContext.getOut();
	try {
		out.println("This is calculate tag");
		out.println("attributes are: num1 -->"+num1+"  Num2 : "+num2);
		out.println("Addition : "+(num1+num2));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return EVAL_PAGE;
}


}
