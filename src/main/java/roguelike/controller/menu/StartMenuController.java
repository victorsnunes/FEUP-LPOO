package roguelike.controller.menu;

import roguelike.Game;
import roguelike.controller.Controller;
import roguelike.gui.GUI;
import roguelike.model.game.arena.RandomArenaBuilder;
import roguelike.model.menu.Menu;
import roguelike.states.GameState;
import roguelike.states.LevelMenuState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StartMenuController extends Controller<Menu> {
    public StartMenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                //if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                //if (getModel().isSelected(0)) game.setState(new GameState(new RandomArenaBuilder(18, 18, 3, 2).createArena()));
                //Start Game
                if (getModel().isSelected(0)) game.setState(new LevelMenuState(new Menu("Choose the Level", Arrays.asList("Level 1", "Level 2", "Level 3", "Random Map"))));
                //Instructions
                if (getModel().isSelected(1)) game.setState(null);
                //Exit
                if (getModel().isSelected(2)) game.setState(null);
                break;
        }
    }
}
