package agents;

import behaviours.AgentBehaviour;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgentX extends Agent {

    protected void setup() {

        // Printout a welcome message
        System.out.println("Hello I am AgentX");

        // DFAgentDescription and ServiceDescription
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("AgentX");
        sd.setName("AgentX");
        dfd.addServices(sd);

        // Register the service
        try {
            DFService.register(this, dfd);
        } catch (Exception e) {
            System.out.println("AgentX: " + e);
        }

        // Add the generic behaviour
        addBehaviour(new AgentBehaviour(this));
    }

    protected void takeDown() {
        System.out.println("AgentX is terminating.");
    }
}