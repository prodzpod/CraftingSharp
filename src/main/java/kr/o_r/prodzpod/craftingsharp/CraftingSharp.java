package kr.o_r.prodzpod.craftingsharp;

import org.apache.logging.log4j.Logger;

import kr.o_r.prodzpod.craftingsharp.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CraftingSharp.MODID, name = CraftingSharp.MODNAME, version = CraftingSharp.MODVERSION, 
	 dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)

public class CraftingSharp {

    public static final String MODID = "craftingsharp";
    public static final String MODNAME = "Crafting#";
    public static final String MODVERSION = "0.0.1";
    

    @SidedProxy(clientSide = "kr.o_r.prodzpod.craftingsharp.proxy.ClientProxy", serverSide = "kr.o_r.prodzpod.craftingsharp.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static CraftingSharp instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
