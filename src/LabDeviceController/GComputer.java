package LabDeviceController;

public class GComputer {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了电脑";
		db.updateEquipment("on", "computer");
		return operation;
	}

	public String close() {
		// TODO 自动生成的方法存根
		operation="关闭了电脑";
		db.updateEquipment("off", "computer");
		return operation;
	}

}
