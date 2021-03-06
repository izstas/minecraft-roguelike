package greymerk.roguelike.dungeon.base;

import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;

import java.util.Random;

import net.minecraft.world.World;

public interface ISecretRoom {
	
	public boolean genRoom(World world, Random rand, LevelSettings settings, Cardinal dir, Coord pos);
	
}
