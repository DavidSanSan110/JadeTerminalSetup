package behaviours;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class AgentBehaviour  extends Behaviour {
        
    private boolean finished = false;
    private Agent myAgent;
    private int counter = 0;
    
    public AgentBehaviour(Agent a) {
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
            this.counter++;
            if (this.counter == 3) {
                this.finished = true;
            }
        } else {
            block();
        }
    }
    
    public boolean done() {
        if (this.finished) {
            myAgent.doDelete();
        }
        return this.finished;
    }
    
}
