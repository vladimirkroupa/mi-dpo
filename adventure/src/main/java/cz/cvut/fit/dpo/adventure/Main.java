package cz.cvut.fit.dpo.adventure;

import java.io.IOException;

import cz.cvut.fit.dpo.adventure.controller.GameController;
import cz.cvut.fit.dpo.adventure.model.facade.GameFacadePojo;
import cz.cvut.fit.dpo.adventure.view.ConsoleView;
import cz.cvut.fit.dpo.adventure.world1.World1Definition;

public class Main {

	public static void main (String[] args) {
		GameFacadePojo model = new GameFacadePojo(World1Definition.getInstance());
		GameController controller = new GameController(model, model); 
		ConsoleView view = new ConsoleView(model, controller);
		
		model.registerObserver(view);
		controller.setView(view);
		
		try {
			view.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
