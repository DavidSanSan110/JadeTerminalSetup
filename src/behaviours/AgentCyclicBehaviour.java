package behaviours;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class AgentCyclicBehaviour extends CyclicBehaviour {

    private Agent myAgent;

    public AgentCyclicBehaviour(Agent a) {
        super(a);
        myAgent = a;
    }

    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            System.out.println("Agent " + myAgent.getLocalName() + " receives from " + msg.getSender().getLocalName() + " the message: " + msg.getContent());
            ACLMessage reply = msg.createReply();
            reply.setPerformative(ACLMessage.INFORM);
            reply.setContent("Hello, I am " + myAgent.getLocalName());
            myAgent.send(reply);
            System.out.println("Agent " + myAgent.getLocalName() + " sends to " + msg.getSender().getLocalName() + " the message: " + reply.getContent());
        } else {
            block();
        }
    }
}
