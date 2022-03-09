package mod.hitlerhax.setting.settings;

import mod.hitlerhax.Main;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.Setting;

public class StringSetting extends Setting {
	public String value;

	public StringSetting(String name, Module parent, String value) {
		this.name = name;
		this.parent = parent;
		if (value == null)
			this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;

		if (Main.config != null) {
			Main.config.Save();
		}
	}
}