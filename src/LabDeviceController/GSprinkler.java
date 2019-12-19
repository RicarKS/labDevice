package LabDeviceController;

public class GSprinkler {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了洒水器";
		db.updateEquipment("on", "sprinkler");
		return operation;
	}

	public String close() {
		// TODO 自动生成的方法存根
		operation="关闭了洒水器";
		db.updateEquipment("off", "sprinkler");
		return operation;
	}
}
