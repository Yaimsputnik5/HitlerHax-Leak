package mod.hitlerhax.setting.settings;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import mod.hitlerhax.Main;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.Setting;

public class SearchBlockSelectorSetting extends Setting {

	public final boolean colorSettings;
	public ArrayList<Block> blocks = new ArrayList<>();
	public HashMap<Block, Integer> colors = new HashMap<>();

	public SearchBlockSelectorSetting(String name, Module parent, boolean colorSettings, ArrayList<Block> blocks,
			HashMap<Block, Integer> colors) {
		this.name = name;
		this.parent = parent;
		this.colorSettings = colorSettings;
		if (!Main.configLoaded) {
			this.blocks = blocks;
			this.colors = colors;
		}
		for (Block b : GameRegistry.findRegistry(Block.class).getValuesCollection()) {
			colors.put(b, new Color(255, 255, 255).getRGB());
		}
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public HashMap<Block, Integer> getColors() {
		return colors;
	}

	public void setColors(HashMap<Block, Integer> colors) {
		this.colors = colors;
	}

	public int getColor(Block b) {
		for (Entry<Block, Integer> e : colors.entrySet()) {
			if (e.getKey() == b) {
				return e.getValue();
			}
		}
		return 0;
	}

	public void setColor(Block b, Integer c) {
		for (Entry<Block, Integer> e : colors.entrySet()) {
			if (e.getKey() == b) {
				e.setValue(c);
			}
		}
	}

	/*
	 * blocks are found at
	 * GameRegistry.findRegistry(Block.class).getValuesCollection()
	 */
}
