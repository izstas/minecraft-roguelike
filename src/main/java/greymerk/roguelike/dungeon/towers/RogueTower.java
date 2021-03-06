package greymerk.roguelike.dungeon.towers;

import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldGenPrimitive;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class RogueTower implements ITower{

	public RogueTower(){
	}


	
	public void generate(World world, Random rand, ITheme theme, int x, int y, int z){
		
		MetaBlock air = new MetaBlock(Blocks.air);
		
		IBlockFactory blocks = theme.getPrimaryWall();
		
		MetaBlock stair = theme.getPrimaryStair();
		
		Coord floor = Tower.getBaseCoord(world, x, y, z);
		int ground = floor.getY() - 1;
		int main = floor.getY() + 4;
		int roof = floor.getY() + 9;
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, ground, z - 3, x + 3, floor.getY() + 12, z + 3, air);

		Coord start;
		Coord end;
		Coord cursor;
		
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, main, z - 3, x + 3, main, z + 3, theme.getSecondaryWall(), true, true);
		WorldGenPrimitive.fillRectSolid(world, rand, x - 3, roof, z - 3, x + 3, roof, z + 3, blocks, true, true);
		
		for(Cardinal dir : Cardinal.directions){
			for (Cardinal orth : Cardinal.getOrthogonal(dir)){
				// ground floor
				start = new Coord(floor);
				start.add(Cardinal.DOWN, 1);
				start.add(dir, 2);
				end = new Coord(start);
				end.add(dir, 3);
				end.add(orth, 1);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				start.add(orth, 2);
				end.add(Cardinal.reverse(dir), 2);
				end.add(orth, 2);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 5);
				cursor.add(orth, 1);
				start = new Coord(cursor);
				end = new Coord(cursor);
				end.add(Cardinal.reverse(dir), 1);
				end.add(Cardinal.UP, 2);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				start = new Coord(end);
				start.add(dir, 1);
				start.add(Cardinal.reverse(orth), 1);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				cursor.add(Cardinal.UP, 2);
				WorldGenPrimitive.blockOrientation(stair, orth, false);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				end = new Coord(start);
				end.add(Cardinal.UP, 9);
				end.add(orth, 2);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 3);
				start.add(orth, 3);
				end = new Coord(start);
				end.add(Cardinal.UP, 9);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				end = new Coord(start);
				end.add(dir, 1);
				end.add(Cardinal.UP, 1);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, air, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 3);
				cursor.add(orth, 2);
				cursor.add(Cardinal.UP, 3);
				WorldGenPrimitive.blockOrientation(stair, Cardinal.reverse(orth), true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				cursor.add(Cardinal.UP, 5);
				WorldGenPrimitive.blockOrientation(stair, Cardinal.reverse(orth), true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				start = new Coord(floor);
				start.add(dir, 4);
				start.add(orth, 3);
				start.add(Cardinal.UP, 4);
				WorldGenPrimitive.blockOrientation(stair, orth, true);
				WorldGenPrimitive.setBlock(world, rand, start, stair, true, true);
				
				start.add(Cardinal.UP, 1);
				end = new Coord(start);
				end.add(Cardinal.UP, 4);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
				start = new Coord(floor);
				start.add(dir, 5);
				start.add(Cardinal.UP, 4);
				WorldGenPrimitive.blockOrientation(stair, dir, true);
				WorldGenPrimitive.setBlock(world, rand, start, stair, true, true);
				
				cursor = new Coord(start);
				cursor.add(orth, 1);
				WorldGenPrimitive.blockOrientation(stair, orth, true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				start.add(Cardinal.UP, 3);
				WorldGenPrimitive.blockOrientation(stair, dir, true);
				WorldGenPrimitive.setBlock(world, rand, start, stair, true, true);
				
				cursor = new Coord(start);
				cursor.add(orth, 1);
				WorldGenPrimitive.blockOrientation(stair, orth, true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				start.add(Cardinal.UP, 1);
				end = new Coord(start);
				end.add(orth, 1);
				end.add(Cardinal.UP, 1);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
				cursor = new Coord(end);
				cursor.add(orth, 1);
				cursor.add(Cardinal.DOWN, 1);
				WorldGenPrimitive.blockOrientation(stair, orth, true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				cursor.add(Cardinal.UP, 1);
				cursor.add(orth, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				cursor.add(Cardinal.reverse(orth), 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(orth, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				this.addCrenellation(world, rand, cursor, blocks);
				
				cursor.add(Cardinal.DOWN, 2);
				cursor.add(Cardinal.reverse(dir), 1);
				cursor.add(orth, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(Cardinal.DOWN, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				
				cursor = new Coord(floor);
				cursor.add(dir, 6);
				cursor.add(Cardinal.UP, 9);
				
				WorldGenPrimitive.blockOrientation(stair, dir, true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				cursor.add(orth, 1);
				WorldGenPrimitive.blockOrientation(stair, orth, true);
				WorldGenPrimitive.setBlock(world, rand, cursor, stair, true, true);
				
				cursor.add(Cardinal.reverse(orth), 1);
				cursor.add(Cardinal.UP, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(orth, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
				cursor.add(Cardinal.UP, 1);
				this.addCrenellation(world, rand, cursor, blocks);
				
				cursor = new Coord(floor);
				cursor.add(dir, 4);
				cursor.add(Cardinal.UP, 5);
				WorldGenPrimitive.setBlock(world, rand, cursor, air, true, true);
				cursor.add(Cardinal.UP, 1);
				WorldGenPrimitive.setBlock(world, rand, cursor, air, true, true);
				cursor.add(orth, 2);
				WorldGenPrimitive.setBlock(world, rand, cursor, new MetaBlock(Blocks.iron_bars), true, true);
			}
		}
		
		for(Cardinal dir : Cardinal.directions){
			for (Cardinal orth : Cardinal.getOrthogonal(dir)){
				start = new Coord(x, ground, z);
				start.add(dir, 4);
				end = new Coord(x, 60, z);
				end.add(dir, 4);
				start.add(Cardinal.reverse(orth), 2);
				end.add(orth, 2);
				
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				start = new Coord(x, ground, z);
				start.add(dir, 3);
				start.add(orth, 3);
				end = new Coord(x, 60, z);
				end.add(dir, 3);
				end.add(orth, 3);
				WorldGenPrimitive.fillRectSolid(world, rand, start, end, blocks, true, true);
				
			}
		}
		
		for(int i = main; i >= y; --i){
			WorldGenPrimitive.spiralStairStep(world, rand, new Coord(x, i, z), stair, theme.getPrimaryPillar());
		}
	}
	
	
	private void addCrenellation(World world, Random rand, Coord cursor, IBlockFactory blocks){
		
		WorldGenPrimitive.setBlock(world, rand, cursor, blocks, true, true);
		
		if(world.isAirBlock(cursor.getBlockPos())) return;

		cursor.add(Cardinal.UP, 1);
		WorldGenPrimitive.setBlock(world, rand, cursor, new MetaBlock(Blocks.torch), true, true);
	}
}
