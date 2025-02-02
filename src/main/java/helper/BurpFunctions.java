package helper;

import burp.IBurpExtenderCallbacks;

import java.io.PrintWriter;

public class BurpFunctions {
	public static Object loadExtensionSettingHelper(String name, String type, Object defaultValue, IBurpExtenderCallbacks callbacks, PrintWriter stderr) {
		Object value = null;
		try {
			String temp_value = callbacks.loadExtensionSetting(name);
			if(temp_value!=null && !temp_value.equals("")) {
				switch(type.toLowerCase()){
				case "int":
				case "integer":
					value = Integer.valueOf(temp_value);
					break;
				case "bool":
				case "boolean":
					value = Boolean.valueOf(temp_value);
					break;
				default:
					value = temp_value;
					break;
				}
			}
		}catch(Exception e) {
			stderr.println(e.getMessage());
		}

		if(value==null) {
			value = defaultValue;
		}
		return value;
	}
}
