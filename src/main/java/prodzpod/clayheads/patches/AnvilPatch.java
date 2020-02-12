package prodzpod.clayheads.patches;

import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class AnvilPatch {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void anvilUpdate(AnvilRepairEvent event) {
		ItemStack output = event.getItemResult();
		if (output.getItem() instanceof ItemSkull && // detect for skull item
			output.getItemDamage() == 3 && // detect for player skull
			!output.getDisplayName().equals(event.getItemInput().getDisplayName()) // check for repair or enchantment
		) {
			NBTTagCompound nbt = output.getTagCompound();
			assert nbt != null;
			nbt.setString("SkullOwner", output.getDisplayName());
			output.setTagCompound(nbt);
		}
	}
}
