package prodzpod.clayheads;

import net.minecraftforge.common.config.Config;

@Config(modid= ClayHeads.MODID)
public class ModConfig {
	@Config.Comment({"Set it to true if you have Botania, Headcrumbs or other mods."})
    @Config.Name("Crafting Recipe Type")
    public static boolean disableCraftingRecipe = false;
}
