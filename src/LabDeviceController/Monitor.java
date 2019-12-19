package LabDeviceController;

import java.util.HashMap;

//监视器
public class Monitor {
	HashMap<String,String> status;
	StringBuilder op = new StringBuilder();
	
	public Monitor(HashMap<String, String> status) {
		super();
		this.status = status;
	}

	public String monitor() {
		if (!status.isEmpty()) {
			if (status.containsKey("投影仪")) {
				String s = status.get("投影仪");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GProjector projector=new GProjector();
					op.append("\n"+projector.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GProjector projector=new GProjector();
					op.append("\n"+projector.close() + "\n");
				}	
			}
			if (status.containsKey("烟雾警报器")) {
				String s = status.get("烟雾警报器");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GSmokeAlarm smokealarm=new GSmokeAlarm();
					op.append(smokealarm.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GSmokeAlarm smokealarm=new GSmokeAlarm();
					op.append(smokealarm.close() + "\n");
				}	
			}
			if (status.containsKey("洒水器")) {
				String s = status.get("洒水器");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GSprinkler sprinkler=new GSprinkler();
					op.append(sprinkler.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GSprinkler sprinkler=new GSprinkler();
					op.append(sprinkler.close() + "\n");
				}	
			}
			if (status.containsKey("电脑")) {
				String s = status.get("电脑");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GComputer computer=new GComputer();
					op.append(computer.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GComputer computer=new GComputer();
					op.append(computer.close() + "\n");
				}	
			}
			if (status.containsKey("风扇")) {
				String s = status.get("风扇");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GFan fan=new GFan();
					op.append(fan.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GFan fan=new GFan();
					op.append(fan.close() + "\n");
				}	
			}
			if (status.containsKey("空调")) {
				String s = status.get("空调");
				if ("Open".equalsIgnoreCase(s)) {
					//TODO 打开
					GAirConditioner airconditioner=new GAirConditioner();
					op.append(airconditioner.open() + "\n");
				} else if("Close".equalsIgnoreCase(s)) {
					//TODO 关闭
					GAirConditioner airconditioner=new GAirConditioner();
					op.append(airconditioner.close() + "\n");
				}	
			}
		}
		return op.toString();
	}
	
}
