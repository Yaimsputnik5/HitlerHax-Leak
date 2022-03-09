package mod.hitlerhax.module.modules.player;

import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.settings.BooleanSetting;
import mod.hitlerhax.util.InventoryUtil;
import net.minecraft.block.Block;
import net.minecraft.init.Items;

public class FastPlace extends Module {
    public FastPlace() {
        super("FastPlace", "Allows you to place blocks & crystals faster", Category.PLAYER);
        
        addSetting(blocks);
        addSetting(crystal);
        addSetting(fireworks);
        addSetting(spawnEggs);
    }

    BooleanSetting blocks = new BooleanSetting("Blocks", this, false);
    BooleanSetting crystal = new BooleanSetting("Crystals", this, true);
    BooleanSetting fireworks = new BooleanSetting("Fireworks", this, false);
    BooleanSetting spawnEggs = new BooleanSetting("Spawn Eggs", this, false);

     
    

    @Override
    public void onUpdate() {
        if (InventoryUtil.getHeldItem(Items.END_CRYSTAL) && crystal.isEnabled() || InventoryUtil.getHeldItem(Items.FIREWORKS) && fireworks.isEnabled() || InventoryUtil.getHeldItem(Items.SPAWN_EGG) && spawnEggs.isEnabled())
            mc.rightClickDelayTimer = 0;

        if (Block.getBlockFromItem(mc.player.getHeldItemMainhand().getItem()).getDefaultState().isFullBlock() && blocks.isEnabled())
            mc.rightClickDelayTimer = 0;
    }
}