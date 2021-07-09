package com.kha.model;

public class Simulation {
	public static void main(String[] args) {
		FlyingVehicle fv = new FlyingVehicle((short)4, new Engine());
		fv.setName("A New Flying Vehicle");
		System.out.println(fv.getName());
		fv.getEngine().on();
		
		Airplane boeing = new Airplane((short)4, (short)5);
		boeing.setName("ADC");
		boeing.move(15);
	}
}
