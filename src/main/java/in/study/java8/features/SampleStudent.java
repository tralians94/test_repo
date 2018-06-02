package in.study.java8.features;

import java.util.Arrays;

public class SampleStudent {
private String name;
private Integer rollno;
private String std;
private int[] marks;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "SampleStudent [name=" + name + ", rollno=" + rollno + ", std=" + std + ", marks=" + Arrays.toString(marks)
			+ ", tot=" + tot + ", avg=" + avg + "]";
}
public Integer getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getStd() {
	return std;
}
public void setStd(String std) {
	this.std = std;
}
public int[] getMarks() {
	return marks;
}
public void setMarks(int[] marks) {
	this.marks = marks;
}
public Long getTot() {
	return tot;
}
public void setTot(Long tot) {
	this.tot = tot;
}
public Double getAvg() {
	return avg;
}
public void setAvg(Double avg) {
	this.avg = avg;
}
private Long tot;
private Double avg;

}
