package LabDeviceController;

public class GSmokeAlarm {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了烟雾警报器";
		db.updateEquipment("on", "smokealarm");
		return operation;
	}

	public String close() {
		// TODO 自动生成的方法存根
		operation="关闭了烟雾警报器";
		db.updateEquipment("off", "smokealarm");
		return operation;
	}

}
