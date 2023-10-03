package behaviours;

import jade.core.Agent;
import jade.core.behaviours.*;

public class AgentOneShotBehaviour extends OneShotBehaviour {

    private Agent myAgent;

    public AgentOneShotBehaviour(Agent a) {
        super(a);
        myAgent = a;
    }

    public void action() {
        System.out.println("Agent " + myAgent.getLocalName() + " prints this message as a one shot behaviour");
    }

    public int onEnd() {
        myAgent.doDelete();
        return super.onEnd();
    }
}
