package greymerk.roguelike.citadel;

import greymerk.roguelike.dungeon.towers.ITower;
import greymerk.roguelike.dungeon.towers.Tower;
import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.theme.Theme;
import greymerk.roguelike.util.mst.Edge;
import greymerk.roguelike.util.mst.MinimumSpanningTree;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.WorldGenPrimitive;

import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CityGrounds {

	public static void generate(World world, Random rand, MinimumSpanningTree mst, ITheme theme, Coord pos){
		
		Coord start;
		Coord end;
		
		start = new Coord(pos);
		start.add(new Coord(Citadel.EDGE_LENGTH * -3, 10, Citadel.EDGE_LENGTH * -3));
		end = new Coord(pos);
		end.add(new Coord(Citadel.EDGE_LENGTH * 3, 40, Citadel.EDGE_LENGTH * 3));
		WorldGenPrimitive.fillRectSolid(world, rand, start, end, new MetaBlock(Blocks.air), true, true);
		
		start = new Coord(pos);
		start.add(new Coord(Citadel.EDGE_LENGTH * -3, 10, Citadel.EDGE_LENGTH * -3));
		end = new Coord(pos);
		end.add(new Coord(Citadel.EDGE_LENGTH * 3, 20, Citadel.EDGE_LENGTH * 3));
		WorldGenPrimitive.fillRectSolid(world, rand, start, end, theme.getPrimaryWall(), true, true);
		
		start = new Coord(pos);
		start.add(new Coord(Citadel.EDGE_LENGTH * -2, 20, Citadel.EDGE_LENGTH * -2));
		end = new Coord(pos);
		end.add(new Coord(Citadel.EDGE_LENGTH * 2, 30, Citadel.EDGE_LENGTH * 2));
		WorldGenPrimitive.fillRectSolid(world, rand, start, end, theme.getPrimaryWall(), true, true);
		
		start = new Coord(pos);
		start.add(new Coord(Citadel.EDGE_LENGTH * -1, 30, Citadel.EDGE_LENGTH * -1));
		end = new Coord(pos);
		end.add(new Coord(Citadel.EDGE_LENGTH, 40, Citadel.EDGE_LENGTH));
		WorldGenPrimitive.fillRectSolid(world, rand, start, end, theme.getPrimaryWall(), true, true);
		
		Coord cursor = new Coord(pos);
		cursor.add(Cardinal.UP, 20);
		
		for(Edge e : mst.getEdges()){
			start = e.getPoints()[0].getPosition();
			start.add(cursor);
			end = e.getPoints()[1].getPosition();
			end.add(cursor);
			end.add(Cardinal.DOWN, 20);
			WorldGenPrimitive.fillRectSolid(world, rand, start, end, theme.getPrimaryWall(), true, true);
		}
		
		
		List<Coord> towers = mst.getPointPositions();
		for(Coord c : towers){
			c.add(pos);
			rand = Citadel.getRandom(world, c.getX(), c.getZ());
			ITower tower = Tower.get(Tower.values()[rand.nextInt(Tower.values().length)]);
			tower.generate(world, rand, Theme.getTheme(Theme.values()[rand.nextInt(Theme.values().length)]), c.getX(), 50, c.getZ());
		}
		
	}
	
	
}
