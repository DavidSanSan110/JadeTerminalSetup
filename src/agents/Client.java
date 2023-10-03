package agents;

import behaviours.ClientBehaviour;

import jade.core.Agent;

public class Client extends Agent {

    protected void setup() {

        // Printout a welcome message
        System.out.println("Hello I am Client");

        // Add the generic behaviour
        addBehaviour(new ClientBehaviour(this));
    }

    protected void takeDown() {
        System.out.println("Client is terminating.");
    }
}
