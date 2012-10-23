package cz.cvut.fit.dpo.adventure;

import org.junit.Test;

import cz.cvut.fit.dpo.adventure.controller.GameController;
import cz.cvut.fit.dpo.adventure.model.facade.GameFacadePojo;
import cz.cvut.fit.dpo.adventure.view.ConsoleView;
import cz.cvut.fit.dpo.adventure.world1.World1Definition;

public class IntegrationTest {

	@Test
	public void test() {
		GameFacadePojo model = new GameFacadePojo(World1Definition.getInstance());
		GameController controller = new GameController(model, model); 
		ConsoleView view = new ConsoleView(model, controller);
		
		model.registerObserver(view);
		controller.setView(view);

	}
	
}
