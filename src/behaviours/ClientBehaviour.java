package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import utils.Utils;

public class ClientBehaviour extends CyclicBehaviour {

    private int step = 0;

    public ClientBehaviour(Agent a) {
        super(a);
    }

    public void action() {

        switch(this.step) {
            case 0:
                this.sendMsg();
                break;
            case 1:
                this.receiveMsg();
                break;
        }
    }

    // Send a message to an agent
    public void sendMsg() {

        System.out.println("Introduce el agente al que quieres enviar el mensaje: ");
        String agent = System.console().readLine();

        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        AID[] receivers = Utils.searchAgents(myAgent, agent);
        if (receivers != null && receivers.length > 0) {
            for (int i = 0; i < receivers.length; ++i) {
                msg.addReceiver(receivers[i]);
            }
            msg.setContent("Hello, I am " + myAgent.getLocalName());
            myAgent.send(msg);
            //Agent (me) send to agent (receiver) a message (msg)
            System.out.println("Agent " + myAgent.getLocalName() + " sends to " + agent + " the message: " + msg.getContent());
            this.step = 1;
        } else {
            System.out.println(" - " + myAgent.getLocalName() + " -> No hay agentes disponibles");
            this.step = 0;
        }
    }

    // Receive a message from an agent
    public void receiveMsg() {

        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            System.out.println("Agent " + myAgent.getLocalName() + " receives from " + msg.getSender().getLocalName() + " the message: " + msg.getContent());
            this.step = 0;
        } else {
            block();
        }
    }
}
