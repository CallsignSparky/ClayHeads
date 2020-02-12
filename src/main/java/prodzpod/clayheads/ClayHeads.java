package prodzpod.clayheads;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import prodzpod.clayheads.proxy.CommonProxy;

@Mod(modid = ClayHeads.MODID, name = ClayHeads.MODNAME, version = ClayHeads.MODVERSION)
@Mod.EventBusSubscriber(modid= ClayHeads.MODID)
public class ClayHeads {

    public static final String MODID = "clayheads";
    public static final String MODNAME = "ClayHeads";
    public static final String MODVERSION = "0.0.1";

    @SidedProxy(clientSide= "prodzpod.clayheads.proxy.ClientProxy", serverSide= "prodzpod.clayheads.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ClayHeads instance;
    
    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        logger.info("Thank you for downloading ClayHeads. Have fun building!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        if (!ModConfig.disableCraftingRecipe) {
            logger.info("Initializing Crafting Recipe");
            ResourceLocation group = new ResourceLocation(MODNAME);
            GameRegistry.addShapelessRecipe(new ResourceLocation(MODID, "Player Head Crafting"), group,
                    new ItemStack(Items.SKULL, 1, 3),
                    Ingredient.fromItems(Items.CLAY_BALL, Items.CLAY_BALL, Items.CLAY_BALL, Items.ROTTEN_FLESH));
        }
    }
}