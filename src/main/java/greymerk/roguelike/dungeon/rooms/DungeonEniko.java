package greymerk.roguelike.dungeon.rooms;

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.dungeon.base.DungeonBase;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.treasure.ITreasureChest;
import greymerk.roguelike.treasure.TreasureChestEmpty;
import greymerk.roguelike.treasure.loot.provider.ItemNovelty;
import greymerk.roguelike.worldgen.BlockFactoryCheckers;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldGenPrimitive;
import greymerk.roguelike.worldgen.blocks.ColorBlock;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;

public class DungeonEniko extends DungeonBase {

	@Override
	public boolean generate(World world, Random rand, LevelSettings settings, Cardinal[] entrances, Coord origin) {
		
		int x = origin.getX();
		int y = origin.getY();
		int z = origin.getZ();
		
		MetaBlock air = new MetaBlock(Blocks.air);
		MetaBlock coal = new MetaBlock(Blocks.coal_block);
		MetaBlock netherBrick = new MetaBlock(Blocks.nether_brick);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z - 5, x + 5, y + 4, z + 5, air);
		
		pillar(world, rand, x - 5, y, z - 5);
		pillar(world, rand, x - 5, y, z - 2);
		pillar(world, rand, x - 5, y, z + 2);
		pillar(world, rand, x - 5, y, z + 5);
		
		pillar(world, rand, x - 2, y, z - 5);
		pillar(world, rand, x - 2, y, z + 5);
		
		pillar(world, rand, x + 2, y, z - 5);
		pillar(world, rand, x + 2, y, z + 5);
		
		pillar(world, rand, x + 5, y, z - 5);
		pillar(world, rand, x + 5, y, z - 2);
		pillar(world, rand, x + 5, y, z + 2);
		pillar(world, rand, x + 5, y, z + 5);

		MetaBlock shelf = new MetaBlock(Blocks.stone_brick_stairs);
		WorldGenPrimitive.blockOrientation(shelf, Cardinal.EAST, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y + 1, z - 4, x - 6, y + 3, z - 3, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z - 4, x - 5, y, z - 3, shelf, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y + 1, z + 3, x - 6, y + 3, z + 4, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z + 3, x - 5, y, z + 4, shelf, true, true);
		
		WorldGenPrimitive.blockOrientation(shelf, Cardinal.WEST, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 6, y + 1, z - 4, x + 6, y + 3, z - 3, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 5, y, z - 4, x + 5, y, z - 3, shelf, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 6, y + 1, z + 3, x + 6, y + 3, z + 4, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 5, y, z + 3, x + 5, y, z + 4, shelf, true, true);
		
		WorldGenPrimitive.blockOrientation(shelf, Cardinal.SOUTH, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y + 1, z - 6, x - 3, y + 3, z - 6, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y, z - 5, x - 3, y, z - 5, shelf, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y + 1, z - 6, x + 4, y + 3, z - 6, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y, z - 5, x + 4, y, z - 5, shelf, true, true);
		
		WorldGenPrimitive.blockOrientation(shelf, Cardinal.NORTH, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y + 1, z + 6, x - 3, y + 3, z + 6, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y, z + 5, x - 3, y, z + 5, shelf, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y + 1, z + 6, x + 4, y + 3, z + 6, coal);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y, z + 5, x + 4, y, z + 5, shelf, true, true);
		
		ITreasureChest eniChest = new TreasureChestEmpty().generate(world, rand, settings.getLoot(), new Coord(x + 3, y + 1, z + 5), 0, false);
		if(rand.nextBoolean()){
			eniChest.setInventorySlot(ItemNovelty.getItem(ItemNovelty.ENIKOBOW), eniChest.getInventorySize() / 2);
		} else {
			eniChest.setInventorySlot(ItemNovelty.getItem(ItemNovelty.ENIKOSWORD), eniChest.getInventorySize() / 2);
		}
		
		// floor
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z - 5, x + 5, y - 1, z + 5, new MetaBlock(Blocks.stonebrick));
		MetaBlock blockOne = RogueConfig.getBoolean(RogueConfig.PRECIOUSBLOCKS) ? new MetaBlock(Blocks.lapis_block) : ColorBlock.get(Blocks.stained_hardened_clay, EnumDyeColor.BLUE);
		MetaBlock blockTwo = new MetaBlock(Blocks.quartz_block);
		BlockFactoryCheckers checkers = new BlockFactoryCheckers(blockOne, blockTwo);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y - 1, z - 3, x + 3, y - 1, z + 3, checkers);
		
		MetaBlock lamp = new MetaBlock(Blocks.lit_redstone_lamp);
		
		WorldGenPrimitive.setBlock(world, x - 2, y - 1, z - 2, lamp);
		WorldGenPrimitive.setBlock(world, x - 2, y - 2, z - 2, Blocks.redstone_block);
		
		WorldGenPrimitive.setBlock(world, x - 2, y - 1, z + 2, lamp);
		WorldGenPrimitive.setBlock(world, x - 2, y - 2, z + 2, Blocks.redstone_block);
		
		WorldGenPrimitive.setBlock(world, x + 2, y - 1, z - 2, lamp);
		WorldGenPrimitive.setBlock(world, x + 2, y - 2, z - 2, Blocks.redstone_block);
		
		WorldGenPrimitive.setBlock(world, x + 2, y - 1, z + 2, lamp);
		WorldGenPrimitive.setBlock(world, x + 2, y - 2, z + 2, Blocks.redstone_block);
		
		// roof
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y + 4, z - 6, x - 4, y + 4, z + 6, netherBrick);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y + 4, z - 6, x + 4, y + 4, z - 4, netherBrick);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y + 4, z + 4, x + 4, y + 4, z + 6, netherBrick);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 4, y + 4, z - 6, x + 6, y + 4, z + 6, netherBrick);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y + 5, z - 4, x + 4, y + 5, z + 4, netherBrick);
		
		MetaBlock upsideDownNetherSlab = new MetaBlock(Blocks.stone_slab);
		upsideDownNetherSlab.withProperty(BlockSlab.HALF_PROP, BlockSlab.EnumBlockHalf.TOP);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y + 4, z - 3, x - 3, y + 4, z + 3, upsideDownNetherSlab, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y + 4, z - 3, x + 3, y + 4, z + 3, upsideDownNetherSlab, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 4, z - 3, x + 2, y + 4, z - 3, upsideDownNetherSlab, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 4, z + 3, x + 2, y + 4, z + 3, upsideDownNetherSlab, true, true);
		
		return true;
	}

	
	private static void pillar(World world, Random rand, int x, int y, int z){
		
		MetaBlock stair = new MetaBlock(Blocks.stone_brick_stairs);
		WorldGenPrimitive.fillRectSolid(world, rand, x, y, z, x, y + 3, z, new MetaBlock(Blocks.stonebrick));
		WorldGenPrimitive.setBlock(world, rand, x + 1, y + 3, z, WorldGenPrimitive.blockOrientation(stair, Cardinal.EAST, true), true, false);
		WorldGenPrimitive.setBlock(world, rand, x - 1, y + 3, z, WorldGenPrimitive.blockOrientation(stair, Cardinal.WEST, true), true, false);
		WorldGenPrimitive.setBlock(world, rand, x, y + 3, z + 1, WorldGenPrimitive.blockOrientation(stair, Cardinal.SOUTH, true), true, false);
		WorldGenPrimitive.setBlock(world, rand, x, y + 3, z - 1, WorldGenPrimitive.blockOrientation(stair, Cardinal.NORTH, true), true, false);
		
	}
	
	public int getSize(){
		return 7;
	}
	
	@Override
	public boolean validLocation(World world, Cardinal dir, int x, int y, int z){
		
		int size = getSize();
		List<Coord> box = WorldGenPrimitive.getRectHollow(x - size, y - 2, z - size, x + size, y + 5, z + size);
		
		for(Coord pos : box){
			Block b = WorldGenPrimitive.getBlock(world, pos).getBlock();
			if(!b.getMaterial().isSolid()) return false;
		}
		
		return true;
	}
	
}
