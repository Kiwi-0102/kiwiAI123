package Lab1_1b_agent; 

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;
	 private int performance = 0;  // To measure agent's performance

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState, LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	//update enviroment state and performance
	public EnvironmentState executeAction(Action action) {
		    String agentLocation = envState.getAgentLocation();
		    String nextLocation = agentLocation;
		    switch(agentLocation) {
		    case LOCATION_A: 
		    	if(action == MOVE_RIGHT) nextLocation = LOCATION_B;
		    	else if(action == MOVE_DOWN) nextLocation = LOCATION_C;
		    	break;
		    case LOCATION_B: 
		    	if(action == MOVE_LEFT) nextLocation = LOCATION_A;
		    	else if(action == MOVE_DOWN) nextLocation = LOCATION_D;
		    	break;
		    case LOCATION_C: 
		    	if(action == MOVE_UP) nextLocation = LOCATION_A;
		    	else if(action == MOVE_RIGHT) nextLocation = LOCATION_D;
		    	break;
		    case LOCATION_D: 
		    	if(action == MOVE_UP) nextLocation = LOCATION_B;
		    	else if(action == MOVE_LEFT) nextLocation = LOCATION_C;
		    	break;
		    }
		    if(action == SUCK_DIRT) {
		    	performance += 500;
		    	envState.setLocationState(agentLocation, LocationState.CLEAN);
		    }else if(agentLocation.equals(nextLocation)) {
		    	performance -=100;
		    }else {
		    	performance-=10;
		    	envState.setAgentLocation(nextLocation);
		    }
		return envState;
	}
	
	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		String agentLocation = envState.getAgentLocation();
	    LocationState locationState = envState.getLocationState(agentLocation);
	    return new Percept(agentLocation, locationState);
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
