package com.tesnos6921.ekmojangLB.main;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class BBEH {
	
	@SubscribeEvent
	public void onBreakBlock(BreakEvent event) {
		if(event.world.getBlockState(event.pos).getBlock() == MainRegistry.LuckyBlock){
			Random random = new Random();
			int gob = random.nextInt(8);
			if(gob == 0 || gob == 1 || gob == 2 || gob == 3){
				int result = random.nextInt(17);
				System.out.println(result);
				if(result == 0){
					event.getPlayer().heal(20F);
					event.getPlayer().getFoodStats().setFoodLevel(20);
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.message1.txt"));
				}else if(result == 1){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.wheat, random.nextInt(50))));
				}else if(result == 2){
					event.world.spawnEntityInWorld(new EntityFallingBlock(event.world, event.pos.getX(), event.pos.getY() + 50, event.pos.getZ(), Blocks.diamond_block.getDefaultState()));
					event.world.spawnEntityInWorld(new EntityLightningBolt(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ()));
				}else if(result == 3){
					event.world.setBlockToAir(new BlockPos(event.pos.getX(), event.pos.getY(), event.pos.getZ()));
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 5; j++){
							event.world.setBlockState(new BlockPos(event.pos.getX() + i, event.pos.getY(), event.pos.getZ() + j), Blocks.sandstone.getDefaultState());
							event.world.setBlockState(new BlockPos(event.pos.getX(), event.pos.getY() + 1, event.pos.getZ() + j), Blocks.sandstone.getDefaultState());
							event.world.setBlockState(new BlockPos(event.pos.getX() + 4, event.pos.getY() + 1, event.pos.getZ() + j), Blocks.sandstone.getDefaultState());
						}
						event.world.setBlockState(new BlockPos(event.pos.getX() + i, event.pos.getY() + 1, event.pos.getZ()), Blocks.sandstone.getDefaultState());
						event.world.setBlockState(new BlockPos(event.pos.getX() + i, event.pos.getY() + 1, event.pos.getZ() + 4), Blocks.sandstone.getDefaultState());
					}
					event.world.setBlockState(new BlockPos(event.pos.getX() + 1, event.pos.getY() + 1, event.pos.getZ() + 1), MainRegistry.LuckyBlock.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX() + 1, event.pos.getY() + 1, event.pos.getZ() + 3), MainRegistry.LuckyBlock.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX() + 3, event.pos.getY() + 1, event.pos.getZ() + 1), MainRegistry.LuckyBlock.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX() + 3, event.pos.getY() + 1, event.pos.getZ() + 3), MainRegistry.LuckyBlock.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX(), event.pos.getY() + 2, event.pos.getZ()), Blocks.sandstone.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX(), event.pos.getY() + 2, event.pos.getZ() + 4), Blocks.sandstone.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX() + 4, event.pos.getY() + 2, event.pos.getZ()), Blocks.sandstone.getDefaultState());
					event.world.setBlockState(new BlockPos(event.pos.getX() + 4, event.pos.getY() + 2, event.pos.getZ() + 4), Blocks.sandstone.getDefaultState());
				}else if(result == 4){
					ItemStack lc = new ItemStack(Items.diamond_chestplate);
					lc.addEnchantment(Enchantment.fireProtection, 10);
					lc.addEnchantment(Enchantment.projectileProtection, 10);
					lc.addEnchantment(Enchantment.blastProtection, 10);
					lc.addEnchantment(Enchantment.protection, 10);
					lc.addEnchantment(Enchantment.unbreaking, 10);
					lc.addEnchantment(Enchantment.thorns, 10);
					lc.setStackDisplayName("Worlds Luckiest Chestplate");
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), lc));
				}else if(result == 5){
					ItemStack ll = new ItemStack(Items.diamond_leggings);
					ll.addEnchantment(Enchantment.fireProtection, 10);
					ll.addEnchantment(Enchantment.projectileProtection, 10);
					ll.addEnchantment(Enchantment.blastProtection, 10);
					ll.addEnchantment(Enchantment.protection, 10);
					ll.addEnchantment(Enchantment.unbreaking, 10);
					ll.addEnchantment(Enchantment.thorns, 10);
					ll.setStackDisplayName("Worlds Luckiest Leggings");
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), ll));
				}else if(result == 6){
					ItemStack lb = new ItemStack(Items.diamond_boots);
					lb.addEnchantment(Enchantment.unbreaking, 20);
					lb.addEnchantment(Enchantment.featherFalling, 100);
					lb.setStackDisplayName("Unbreakable Boots");
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), lb));				
				}else if(result == 7){
					ItemStack lh = new ItemStack(Items.diamond_helmet);
					lh.addEnchantment(Enchantment.unbreaking, 10);
					lh.addEnchantment(Enchantment.aquaAffinity, 50);
					lh.addEnchantment(Enchantment.respiration, 50);
					lh.setStackDisplayName("Diving Helmet");
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), lh));		
				}else if(result == 90){
	//				EntityVillager villager = new EntityVillager(event.world);
	//				villager.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	//				MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Items.diamond, 5), new ItemStack(Items.emerald, 5), new ItemStack(Items.nether_star));
	//				villager.setAlwaysRenderNameTag(true);
	//				villager.setCustomNameTag("Luckiest Villager Ever");
	//				MerchantRecipeList recipeList = new MerchantRecipeList();
	//				recipeList.addToListWithCheck(recipe);
	//				VillagerRegistry.instance().registerVillagerId(0);
	//				
	//				VillagerRegistry.manageVillagerTrades(recipeList, villager, 1, random);
	//				event.world.spawnEntityInWorld(villager);
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.troll.txt"));
					event.setCanceled(true);
					
				}else if(result == 8){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.nether_star)));
					
				}else if(result == 9){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Item.getItemFromBlock(Blocks.dragon_egg))));
					
				}else if(result == 10){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.ender_pearl, random.nextInt(15))));
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.ender_eye, random.nextInt(15))));
				}else if(result == 11){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Item.getItemFromBlock(Blocks.tnt), random.nextInt(25))));
					
				}else if(result == 12){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.diamond, random.nextInt(10))));
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.emerald, random.nextInt(7))));
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.gold_ingot, random.nextInt(15))));
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.iron_ingot, random.nextInt(20))));
					
				}else if(result == 13){
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.stick, random.nextInt(250))));
					
				}else if(result == 14){
					EntityFireworkRocket firework = new EntityFireworkRocket(event.world);
					firework.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(firework);
					EntityFireworkRocket firework2 = new EntityFireworkRocket(event.world);
					firework2.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(firework2);
					EntityFireworkRocket firework3 = new EntityFireworkRocket(event.world);
					firework3.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(firework3);
					EntityFireworkRocket firework4 = new EntityFireworkRocket(event.world);
					firework4.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(firework4);
					EntityFireworkRocket firework5 = new EntityFireworkRocket(event.world);
					firework5.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(firework5);
					
				}else if(result == 15){
					for(int i = 0; i < 100; i++){
						event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX() + random.nextInt(20) - 10, event.pos.getY() + 50, event.pos.getZ() + random.nextInt(20) - 10, new ItemStack(Items.gold_nugget)));
					}
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.nuggetrain.txt"));
					
				}else if(result == 16){
					ItemStack luckysword = new ItemStack(Items.diamond_sword);
					luckysword.addEnchantment(Enchantment.fireAspect, 3);
					luckysword.addEnchantment(Enchantment.looting, 7);
					luckysword.addEnchantment(Enchantment.unbreaking, 10);
					luckysword.addEnchantment(Enchantment.sharpness, 20);
					luckysword.addEnchantment(Enchantment.smite, 4);
					luckysword.addEnchantment(Enchantment.baneOfArthropods, 4);
					luckysword.addEnchantment(Enchantment.knockback, 10);
					event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), luckysword));
					
				}else{
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.troll.txt"));
					event.setCanceled(true);
				}
			}else{
				int result = random.nextInt(8);
				System.out.println(result);
				if(result == 0){
					EntitySilverfish silverfish = new EntitySilverfish(event.world);
					silverfish.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(silverfish);
					EntitySilverfish silverfish2 = new EntitySilverfish(event.world);
					silverfish2.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(silverfish2);
					EntitySilverfish silverfish3 = new EntitySilverfish(event.world);
					silverfish3.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(silverfish3);
					EntitySilverfish silverfish4 = new EntitySilverfish(event.world);
					silverfish4.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(silverfish4);
					EntitySilverfish silverfish5 = new EntitySilverfish(event.world);
					silverfish5.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(silverfish5);
				}else if(result == 1){
					EntityGiantZombie giant = new EntityGiantZombie(event.world);
					giant.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					event.world.spawnEntityInWorld(giant);
				}else if(result == 2){
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.boom3.txt"));
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.boom2.txt"));
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.boom1.txt"));
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.boom.txt"));
					event.world.createExplosion(event.getPlayer(), event.pos.getX(), event.pos.getY(), event.pos.getZ(), 35, true);
				}else if(result == 3){
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 5, (int)event.getPlayer().posZ), Blocks.flowing_lava.getDefaultState());
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.look.txt"));
				}else if(result == 4){
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ + 1), Blocks.stonebrick.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY - 1, (int)event.getPlayer().posZ - 1), Blocks.stonebrick.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 1, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX + 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX - 1, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ + 1), Blocks.iron_bars.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 2, (int)event.getPlayer().posZ - 1), Blocks.iron_bars.getDefaultState());
					
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 50, (int)event.getPlayer().posZ), Blocks.anvil.getDefaultState());
					event.world.setBlockState(new BlockPos((int)event.getPlayer().posX, (int)event.getPlayer().posY + 51, (int)event.getPlayer().posZ), Blocks.anvil.getDefaultState());
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.look.txt"));
				}else if(result == 5){
					EntityWither witha = new EntityWither(event.world);
					witha.setLocationAndAngles((double)event.pos.getX() + 0.5D, (double)event.pos.getY(), (double)event.pos.getZ() + 0.5D, 0.0F, 0.0F);
					witha.setHealth(200F);
					witha.setCustomNameTag("DIE PUNY MORTAL");
					witha.setAlwaysRenderNameTag(true);
					event.world.spawnEntityInWorld(witha);
				}else if(result == 6){
					EntityEnderman sally = new EntityEnderman(event.world);
					sally.setHealth(100F);
					sally.setAlwaysRenderNameTag(true);
					sally.setCustomNameTag("Sally The EnderWoman");
					event.world.spawnEntityInWorld(sally);
				}else if(result == 7){
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.troll.txt"));
					event.setCanceled(true);
				}else{
					event.getPlayer().addChatMessage(new ChatComponentTranslation("msg.troll.txt"));
					event.setCanceled(true);
				}
			}
		}
	}

}
