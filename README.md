# JadeTerminalSetup

## Requirements

- [**Jade**]  Library in project lib folder
- [**java**]  openjdk 17.0.1
- [**javac**] javac 17.0.1
- [**jade**]  Add to CLASSPATH variable the path to jade.jar (java jade.Boot -gui should work if jade.jar is in CLASSPATH)

## How to run
 
Open Powershell in the project folder and run the following commands:
- `cd src` Enter src folder
- `Start-Process Powershell; Start-Process Powershell;` Open 2 new Powershell windows
- `javac agents/*.java` to compile the agents (Terminal 1)
- `java jade.Boot -gui` to run the jade gui (Terminal 1)
- `java jade.Boot -container Client:agents.Client` to run the client agent (Terminal 2)
- `java jade.Boot -container AgentZ:agents.AgentZ` to run the agent Z (Terminal 3) (See how it terminates after printing a message, then CTRL + C)
- `java jade.Boot -container AgentX:agents.AgentX` to run the agent X (Terminal 3) (See how it terminates after answering 3 times, then CTRL + C)
- `java jade.Boot -container AgentY:agents.AgentY` to run the agent Y (Terminal 3) (See how it keeps answering the client forever, then CTRL + C)

For terminating the agents press CTRL + C in the terminal where they gui is running (Terminal 1)

## How to use

- After running java jade.Boot -gui, the jade gui should open
- Client agent is used to send messages to AgentX and AgentY
- AgentX has a Behaviour that will answer the Client 3 times and then terminate
- AgentY has a CyclicalBehaviour that will answer the Client forever
- AgentZ has a OneShotBehaviour that will print a message when created and then terminate
- WIP => deploy agents on real time based on user input
