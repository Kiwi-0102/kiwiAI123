package chapter2.agent_AB;

import java.util.Random;

import chapter2.agent_AB.Environment.LocationState;

public class AgentProgram {
	
	 public Action execute(Percept p) {
	        if (p.getLocationState() == LocationState.DIRTY) {
	            return Environment.SUCK_DIRT;
	        } else {
	            Random rand = new Random();
	            Action randomAction;
	            
	            switch(p.getAgentLocation()) {
	                case Environment.LOCATION_A:
	                    randomAction = new Action[]{Environment.MOVE_RIGHT, Environment.MOVE_DOWN}[rand.nextInt(2)];
	                    break;
	                case Environment.LOCATION_B:
	                    randomAction = new Action[]{Environment.MOVE_LEFT, Environment.MOVE_DOWN}[rand.nextInt(2)];
	                    break;
	                case Environment.LOCATION_C:
	                    randomAction = new Action[]{Environment.MOVE_RIGHT, Environment.MOVE_UP}[rand.nextInt(2)];
	                    break;
	                case Environment.LOCATION_D:
	                    randomAction = new Action[]{Environment.MOVE_LEFT, Environment.MOVE_UP}[rand.nextInt(2)];
	                    break;
	                default:
	                    randomAction = NoOpAction.NO_OP;
	                    break;
	            }

	            return randomAction;
	        }
	    }
}