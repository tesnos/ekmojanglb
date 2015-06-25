package com.tesnos6921.ekmojangLB.main;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistry {
	
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@Instance
	public static MainRegistry modInstance;
	
	public static Block LuckyBlock;
	
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) throws IOException{
		LuckyBlock = new LuckyBlock(Material.ground).setUnlocalizedName("lucky_block").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(LuckyBlock, LuckyBlock.getUnlocalizedName());
		proxy.registerRenderInfo();
		MinecraftForge.EVENT_BUS.register(new BBEH());
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		if(event.getSide() == Side.CLIENT)
    	{
		System.out.println("Registering Texture");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(LuckyBlock), 0, new ModelResourceLocation(RefStrings.MODID + ":lucky_block", "inventory"));
    	System.out.println("Texture Registered");
    	}
		ModelResourceLocation jsonfile = new ModelResourceLocation(RefStrings.MODID + ":lucky_block", "inventory");
		System.out.println(jsonfile.getResourceDomain());
		
		GameRegistry.addShapedRecipe(new ItemStack(LuckyBlock, 1), new Object[] { "YXY", "XZX", "YXY", 'X', Items.gold_ingot, 'Y', Items.blaze_powder, 'Z', Blocks.dropper });
		
//		if(event.getSide() == Side.CLIENT)
//    	{
//		System.out.println("Registering Texture");
//    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(LuckyBlock), 0, new ModelResourceLocation(RefStrings.MODID + ":lucky_block", "inventory"));
//    	System.out.println("Texture Registered");
//    	}
	}
	
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		
	}

}
