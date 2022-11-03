package oodp;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Holiday {
	
	
	LocalDateTime start;
	LocalDateTime end;
	double modifier;
	
	public Holiday() {
		start=LocalDateTime.parse("",_DateTimeFormatter.formatter);
		end=LocalDateTime.parse("",_DateTimeFormatter.formatter);
		modifier=1;
	}
	
	public Holiday(LocalDateTime start,LocalDateTime end,double modifier) {
		this.start= start;
		this.end=end;
		this.modifier=modifier;
	}
}
