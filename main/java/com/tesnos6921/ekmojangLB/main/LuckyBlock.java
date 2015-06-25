package com.tesnos6921.ekmojangLB.main;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class LuckyBlock extends Block{

	protected LuckyBlock(Material material) {
		super(material);
		this.setHardness(0.5F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return null;
	}

}
