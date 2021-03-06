package greymerk.roguelike.dungeon.rooms;

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.dungeon.base.DungeonBase;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.treasure.TreasureChest;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldGenPrimitive;
import greymerk.roguelike.worldgen.blocks.ColorBlock;

import java.util.Random;

import net.minecraft.block.BlockQuartz;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class DungeonsEnchant extends DungeonBase {

	@Override
	public boolean generate(World world, Random rand, LevelSettings settings, Cardinal[] entrances, Coord origin) {
		
		int x = origin.getX();
		int y = origin.getY();
		int z = origin.getZ();
		
		
		MetaBlock air = new MetaBlock(Blocks.air);
		MetaBlock chiselQuartz = new MetaBlock(Blocks.quartz_block);
		chiselQuartz.withProperty(BlockQuartz.VARIANT_PROP, BlockQuartz.EnumType.CHISELED);
		MetaBlock pillar = new MetaBlock(Blocks.quartz_block);
		pillar.withProperty(BlockQuartz.VARIANT_PROP, BlockQuartz.EnumType.LINES_Y);
		MetaBlock glowstone = new MetaBlock(Blocks.glowstone);
		
		// clear space
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z - 5, x + 5, y + 4, z + 5, air);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y + 5, z - 3, x + 3, y + 5, z + 3, air);
		
		
		// doors
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y - 1, z - 2, x - 6, y + 3, z - 2, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y - 1, z + 2, x - 6, y + 3, z + 2, chiselQuartz, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x + 6, y - 1, z - 2, x + 6, y + 3, z - 2, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 6, y - 1, z + 2, x + 6, y + 3, z + 2, chiselQuartz, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y - 1, z - 6, x - 2, y + 3, z - 6, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 2, y - 1, z - 6, x + 2, y + 3, z - 6, chiselQuartz, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y - 1, z + 6, x - 2, y + 3, z + 6, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 2, y - 1, z + 6, x + 2, y + 3, z + 6, chiselQuartz, true, true);
		
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 6, y - 1, z - 1, x - 6, y + 3, z + 1, pillar, false, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 6, y - 1, z - 1, x + 6, y + 3, z + 1, pillar, false, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y - 1, z - 6, x + 1, y + 3, z - 6, pillar, false, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y - 1, z + 6, x + 1, y + 3, z + 6, pillar, false, true);
		
		// pillars
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y, z - 4, x - 4, y + 4, z - 4, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y, z + 4, x - 4, y + 4, z + 4, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 4, y, z - 4, x + 4, y + 4, z - 4, chiselQuartz, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 4, y, z + 4, x + 4, y + 4, z + 4, chiselQuartz, true, true);
		
		MetaBlock decor = ColorBlock.get(Blocks.stained_hardened_clay, rand);
		MetaBlock lining = ColorBlock.get(Blocks.stained_hardened_clay, rand);
		
		//lapis shell
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z - 3, x - 5, y + 4, z - 3, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y, z + 3, x - 5, y + 4, z + 3, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x + 5, y, z - 3, x + 5, y + 4, z - 3, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 5, y, z + 3, x + 5, y + 4, z + 3, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y, z - 5, x - 3, y + 4, z - 5, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y, z - 5, x + 3, y + 4, z - 5, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y, z + 5, x - 3, y + 4, z + 5, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y, z + 5, x + 3, y + 4, z + 5, decor, true, true);
		
		// tops & bottoms
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z - 5, x - 3, y - 1, z - 3, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y + 4, z - 5, x - 3, y + 4, z - 3, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z + 3, x - 3, y - 1, z + 5, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y + 4, z + 3, x - 3, y + 4, z + 5, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y - 1, z + 3, x + 5, y - 1, z + 5, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y + 4, z + 3, x + 5, y + 4, z + 5, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y - 1, z - 5, x + 5, y - 1, z - 3, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y + 4, z - 5, x + 5, y + 4, z - 3, decor, true, true);
		
		// arch beams
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 4, y + 4, z - 2, x - 4, y + 4, z + 2, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y + 3, z - 2, x - 5, y + 3, z + 2, decor, true, true);

		WorldGenPrimitive.fillRectSolid(world, rand, x + 4, y + 4, z - 2, x + 4, y + 4, z + 2, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 5, y + 3, z - 2, x + 5, y + 3, z + 2, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 4, z - 4, x + 2, y + 4, z - 4, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 3, z - 5, x + 2, y + 3, z - 5, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 4, z + 4, x + 2, y + 4, z + 4, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 3, z + 5, x + 2, y + 3, z + 5, decor, true, true);
		
		// roof
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, y + 5, z - 3, x + 3, y + 5, z + 3, lining, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y + 5, z - 1, x + 2, y + 5, z + 1, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y + 5, z - 2, x + 1, y + 5, z - 2, decor, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y + 5, z + 2, x + 1, y + 5, z + 2, decor, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y + 5, z, x + 1, y + 5, z, glowstone);
		WorldGenPrimitive.setBlock(world, x, y + 5, z - 1, Blocks.glowstone);
		WorldGenPrimitive.setBlock(world, x, y + 5, z + 1, Blocks.glowstone);
		
		// enchanting floor
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z - 1, x - 3, y - 1, z + 1, lining, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y - 1, z - 1, x + 5, y - 1, z + 1, lining, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y - 1, z - 5, x + 1, y - 1, z - 3, lining, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 1, y - 1, z + 3, x + 1, y - 1, z + 5, lining, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z + 2, x - 3, y - 1, z + 2, pillar, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 5, y - 1, z - 2, x - 3, y - 1, z - 2, pillar, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y - 1, z + 2, x + 5, y - 1, z + 2, pillar, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 3, y - 1, z - 2, x + 5, y - 1, z - 2, pillar, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y - 1, z - 5, x - 2, y - 1, z - 3, pillar, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 2, y - 1, z - 5, x + 2, y - 1, z - 3, pillar, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y - 1, z + 3, x - 2, y - 1, z + 5, pillar, true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x + 2, y - 1, z + 3, x + 2, y - 1, z + 5, pillar, true, true);
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 2, y - 1, z - 2, x + 2, y - 1, z + 2, decor, true, true);
		
		WorldGenPrimitive.setBlock(world, x, y - 1, z, Blocks.glowstone);
		
		if(RogueConfig.getBoolean(RogueConfig.GENEROUS)){
			WorldGenPrimitive.setBlock(world, x, y, z, Blocks.enchanting_table);
		} else {
			TreasureChest.generate(world, rand, settings, new Coord(x, y, z), TreasureChest.ENCHANTING, 4, false);
		}
		return false;
	}	
	
	public int getSize(){
		return 8;
	}
}
