package LabDeviceController;

public class GProjector {
	String operation;
	LinkMySQL db = new LinkMySQL();
	public String open() {
		// TODO 自动生成的方法存根
		operation="打开了投影仪";
		db.updateEquipment("on", "projector");
		return operation;
	}

	public String close() {
		// TODO 自动生成的方法存根
		operation="关闭了了投影仪";
		db.updateEquipment("off", "projector");
		return operation;
	}
}
