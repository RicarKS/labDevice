package LabDeviceController;

public class GAirConditioner {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了空调";
		db.updateEquipment("on", "airconditioner");
		return operation;
	}

	public String close() {
		// TODO 自动生成的方法存根
		operation="关闭了空调";
		db.updateEquipment("off", "airconditioner");
		return operation;
	}
}
