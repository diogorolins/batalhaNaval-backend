package com.diogorolins.battleShip.model.enu;

public enum StatusPosition {
	CLEAN(1), HITED(2);

	private final int status;

	StatusPosition(int status){
        this.status = status;
    }

	public int getStatusPosition() {
		return status;
	}
}
