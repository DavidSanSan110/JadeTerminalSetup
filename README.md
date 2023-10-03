# JadeTerminalSetup

## Requirements

- [Jade]  Library in project lib folder
- [java]  openjdk 17.0.1
- [javac] javac 17.0.1
- [jade]  Add to CLASSPATH variable the path to jade.jar (java jade.Boot -gui should work if jade.jar is in CLASSPATH)

## How to run

- Open terminal in project folder
- Run `cd src`
- This command will open 2 additional powershell windows to run the client and the agents
- Run `Start-Process Powershell; Start-Process Powershell;`
- How to compile:
- Run `javac agents/*.java`
- How to run gui:
- Run `java jade.Boot -gui`
- How to run client:
- Run `java jade.Boot -container Client:agents.Client
- How to run agents:
- Run `java jade.Boot -container AgentX:agents.AgentX
- Run `java jade.Boot -container AgentY:agents.AgentY
- Run `java jade.Boot -container AgentZ:agents.AgentZ
- How to kill all agents:
- Control + C in the terminal where the gui is running

## How to use

- After running java jade.Boot -gui, the jade gui should open
- Client agent is used to send messages to AgentX and AgentY
- AgentX has a Behaviour that will answer the Client 3 times and then terminate
- AgentY has a CyclicalBehaviour that will answer the Client forever
- AgentZ has a OneShotBehaviour that will print a message when created and then terminate
- WIP => deploy agents on real time based on user input
