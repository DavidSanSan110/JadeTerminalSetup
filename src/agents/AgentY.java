package agents;

import behaviours.AgentCyclicBehaviour;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgentY extends Agent {

    protected void setup() {

        // Printout a welcome message
        System.out.println("Hello I am AgentY");

        // DFAgentDescription and ServiceDescription
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("AgentY");
        sd.setName("AgentY");
        dfd.addServices(sd);

        // Register the service
        try {
            DFService.register(this, dfd);
        } catch (Exception e) {
            System.out.println("AgentY: " + e);
        }

        // Add the generic behaviour
        addBehaviour(new AgentCyclicBehaviour(this));
    }

    protected void takeDown() {
        System.out.println("AgentY is terminating.");
    }
}