package agents;

import behaviours.AgentOneShotBehaviour;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgentZ extends Agent {

    protected void setup() {

        // Printout a welcome message
        System.out.println("Hello I am AgentZ");

        // DFAgentDescription and ServiceDescription
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("AgentZ");
        sd.setName("AgentZ");
        dfd.addServices(sd);

        // Register the service
        try {
            DFService.register(this, dfd);
        } catch (Exception e) {
            System.out.println("AgentZ: " + e);
        }

        // Add the generic behaviour
        addBehaviour(new AgentOneShotBehaviour(this));
    }

    protected void takeDown() {
        System.out.println("AgentZ is terminating.");
    }
}