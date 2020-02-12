package prodzpod.clayheads.patches;

import net.minecraft.block.BlockAnvil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class TooltipPatch {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void tooltipUpdate(ItemTooltipEvent event) {
		if (Minecraft.getMinecraft().currentScreen instanceof GuiRepair) { // first off, check if we're viewing anvils
			ItemStack output = event.getItemStack();
			if (output.getItem() instanceof ItemSkull && output.getItemDamage() == 3) // check for player head
				event.getToolTip().add("\u00A7c" + I18n.format("tooltip.clayheads.anvilwarning"));
		}
	}
}
