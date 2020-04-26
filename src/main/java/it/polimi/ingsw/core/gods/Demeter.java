package it.polimi.ingsw.core.gods;
import it.polimi.ingsw.core.*;
import it.polimi.ingsw.core.state.GamePhase;
import it.polimi.ingsw.core.state.Turn;
import it.polimi.ingsw.util.exceptions.NoBuildException;
import it.polimi.ingsw.util.exceptions.NoMoveException;

import java.util.List;
import java.util.ArrayList;

public class Demeter implements GodCard {

	//CODICE DEMETER
	private Player owner;
	public final TypeGod typeGod = TypeGod.SIMPLE_GOD;
	public final List<Integer> numPlayer = List.of(2,3,4);
	public final String name = "Demeter";
	public final String description = "Your Build: Your Worker may build one additional time, but not on the same space.";

	public Demeter(Player player){
		this.owner = player;
	}

	public Demeter(){
		this.owner = null;
	}

	//GETTERS
	public Player getOwner(){
		return owner;
	}


	//CARD-SPECIFIC IMPLEMENTATION OF CHECKBUILD AND CHECKMOVE
	/**
	 * @param m represents the map
	 * @param w represents the worker moved by the player during this turn
	 * @return the cells where the Player's Worker may build according to general game rules and his GodCard power
	 */
	public List<Build> checkBuild(Map m, Worker w, Turn turn) throws NoBuildException {
		// if it isn't during the building phase this god has no power and throws an exception
		if (turn.getGamePhase() != GamePhase.BUILD) {
			throw new NoBuildException();
		}

		int y = m.getY(w.getPos());
		int x = m.getX(w.getPos());
		List<Build> tempBuilds = new ArrayList<>();
		List<Build> builds = new ArrayList<>();
		for(int i = -1; i <= 1; i++) {   //i->x   j->y     x1, y1 all the cells where I MAY build
			int x1 = x + i;
			for (int j = -1; j <= 1; j++) {
				int y1 = y + j;

				if (x != x1 || y != y1) { //I shall not build where I am
					if (0 <= x1 && x1 <= 4 && 0 <= y1 && y1 <= 4) {   //Check that I am inside the map
						if (-1 <= (x1 - x) && (x1 - x) <= 1 && -1 <= (y1 - y) && (y1 - y) <= 1) {  //Check that distance from original cell is <= 1
							if (m.getCell(x1, y1).getWorker() == null) {   //Check there isn't any worker on the cell
								if (!m.getCell(x1, y1).getBuilding().getDome()) {   //Check there is NO dome
									if(m.getCell(x1, y1).getBuilding().getLevel() <= 2) {
										builds.add(new Build(w, m.getCell(x1, y1), false, TypeBuild.SIMPLE_BUILD));        //adds possible build: only one block
										tempBuilds.add(new Build(w, m.getCell(x1, y1), false, TypeBuild.SIMPLE_BUILD));
									}
									else if(m.getCell(x1, y1).getBuilding().getLevel() == 3) {
										builds.add(new Build(w, m.getCell(x1, y1), true, TypeBuild.SIMPLE_BUILD));    //adds possible build: only dome
										tempBuilds.add(new Build(w, m.getCell(x1, y1), true, TypeBuild.SIMPLE_BUILD));
									}
								}
							}
						}
					}
				}
			}
		}
		//adds every single allowed permutation of build construction to "builds" arraylist;
		//tempBuilds is just a temporary list in order to cycle through the elements of the original arraylist
		for(Build b : tempBuilds){
			for(Build b1 : tempBuilds) {
				if(b.getCell() != b1.getCell()) {
					Build secondBuild = b.copy();
					secondBuild.setCondition(b1.copy());
					secondBuild.setTypeBuild(TypeBuild.CONDITIONED_BUILD);
					builds.add(secondBuild);
				}
			}
		}

		return builds;
	}

	/**
	 * @throws NoMoveException so that controller knows it must use the default action
	 */
	public List<Move> checkMove(Map m, Worker w, Turn turn) throws NoMoveException {
		throw new NoMoveException();
	}
}