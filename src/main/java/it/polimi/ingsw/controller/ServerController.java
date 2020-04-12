package it.polimi.ingsw.controller;

// necessary imports of Java SE
import java.util.Observable;
import java.util.Observer;

// other project's classes needed here
import it.polimi.ingsw.core.Game;
import it.polimi.ingsw.core.Worker;
import it.polimi.ingsw.core.Cell;
import it.polimi.ingsw.util.ObserverObject;
import it.polimi.ingsw.util.exceptions.WrongPhaseException;

public class ServerController implements ObserverObject {
	private Game observedModel;
	private Mover moveController;
	private Builder buildController;
	private DefeatManager defeatController;
	private VictoryManager victoryController;
	private SetupManager setupController;
	private boolean setupPhase;
	private boolean phaseMove;
	private boolean phaseBuild;

	// constructors and setters for this class
	public ServerController(Game g) throws NullPointerException {
		if (g == null) throw new NullPointerException();
		moveController = new Mover();
		buildController = new Builder();
		defeatController = new DefeatManager();
		victoryController = new VictoryManager();
		setupController = new SetupManager(g);
		observedModel = g;
		setupPhase = true;
		phaseMove = false;
		phaseBuild = false;
	}

	// actions called by the players or the server
	public void generateOrder() {
		setupController.generateOrder();
	}

	// this is the function which passes the turn
	private void passTurn() {}

	@Override
	public void updateColors(Object playerColors) throws IllegalArgumentException, WrongPhaseException {

	}
	@Override
	public void updateGods(Object playerGods) throws IllegalArgumentException, WrongPhaseException {

	}
	@Override
	public void updatePositions(Object netObject, boolean finished) throws WrongPhaseException {

	}
	@Override
	public void updateMove(Object netMap) throws NullPointerException, WrongPhaseException {

	}
	@Override
	public void updateBuild(Object netMap) throws NullPointerException, WrongPhaseException {

	}
}
