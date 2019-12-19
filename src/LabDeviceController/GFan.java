package LabDeviceController;

public class GFan {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了风扇";
		db.updateEquipment("on", "fan");
		return operation;
	}
	
	public String close() {
		// TODO 自动生成的方法存根
		operation="打开了风扇";
		db.updateEquipment("off", "fan");
		return operation;
	}
}
