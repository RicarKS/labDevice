package LabDeviceController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Teacher implements User {
	private String course;
	private String time;
	private String classRoom;
	private String teacher;

	public Teacher(String tn, String dateStr, String cr) {
		teacher = tn;
		time = dateStr;
		classRoom = cr;
	}

	@Override
	public boolean judge() {
		// TODO 自动生成的方法存根
		LinkMySQL db = new LinkMySQL();
		ResultSet rs = db.selectTeacher();
		Calendar c = new GregorianCalendar();
		Calendar c1 = new GregorianCalendar();
		Calendar c2 = new GregorianCalendar();
		boolean t = false;
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		c.setTime(date);
		Timestamp timestamp = null;
		try {
			while (rs.next()) {
				timestamp = rs.getTimestamp("time");
				Date date1 = new Date(timestamp.getTime());
				c1.setTime(date1);
				c1.add(Calendar.MINUTE, 90);
				c2.setTime(date1);
				c2.add(Calendar.MINUTE, -15);
				if (teacher.equalsIgnoreCase(rs.getString("teacher"))
						&& classRoom.equalsIgnoreCase(rs.getString("classRoom")) && c.after(c2) && c.before(c1)) {
					t = true;
					break;
				} else {
					t = false;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return t;
	}

}
