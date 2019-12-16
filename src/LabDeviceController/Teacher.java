package LabDeviceController;


public class Teacher implements User{
	private String course;
	private String time;
	private String classRoom;
	private String teacher;
	public Teacher(String tn, String dateStr, String cr) {
		teacher=tn;
		time=dateStr;
		classRoom=cr;
	}
	@Override
	public String judge() {
		// TODO 自动生成的方法存根
		return classRoom;
	}

}
