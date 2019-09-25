package com.everest.cricket.game;

import com.everest.cricket.player.Player;

/** 
 * @author msainath
 *  Description : This is the Crease class which reflects the crease in real cricket,which will have striker and non-striker of player type 
 */
public class Crease {
	private Player striker;
	private Player nonStriker;

	public Crease(Player striker, Player nonStriker) {
		this.striker = striker;
		this.nonStriker = nonStriker;
	}

	public Player getStriker() {
		return striker;
	}

	public void setStriker(Player striker) {
		this.striker = striker;
	}

	public Player getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(Player nonStriker) {
		this.nonStriker = nonStriker;
	}

}
