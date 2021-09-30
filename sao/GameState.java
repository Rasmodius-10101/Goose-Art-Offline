package dev.matthew.sao;

import dev.matthew.sao.entites.Creature.player.Player;
import dev.matthew.sao.entites.statics.Tree;
import dev.matthew.sao.worlds.World;
import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();

    }

    @Override
    public void render(Graphics g) {

        world.render(g);

    }

}
