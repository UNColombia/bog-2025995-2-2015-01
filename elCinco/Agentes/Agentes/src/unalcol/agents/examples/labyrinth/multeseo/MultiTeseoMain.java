/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.agents.examples.labyrinth.multeseo;

import unalcol.agents.Agent;
import unalcol.agents.AgentProgram;
import unalcol.agents.examples.labyrinth.Labyrinth;
import unalcol.agents.examples.labyrinth.LabyrinthDrawer;
import unalcol.agents.examples.labyrinth.multeseo.elCinco.Jorge.ElCincoJorge;
import unalcol.agents.examples.labyrinth.multeseo.elCinco.Jose.ElCincoJose;
import unalcol.agents.examples.labyrinth.multeseo.elCinco.Oscar.ElCincoOscar;
import unalcol.agents.simulate.util.SimpleLanguage;
import unalcol.types.collection.vector.Vector;


public class MultiTeseoMain {
  private static SimpleLanguage getLanguage(){
    return  new SimpleLanguage( new String[]{"front", "right", "back", "left", "exit",
        "afront", "aright", "aback", "aleft"},
                                   new String[]{"no_op", "die", "advance", "rotate"}
                                   );
  }

  public static void main( String[] argv ){
     AgentProgram[] teseo = new AgentProgram[12];
     teseo[0] = new ElCincoJorge(getLanguage());
     teseo[1] = new ElCincoJose();
     ((ElCincoJose) teseo[1]).setLanguage(getLanguage());
      teseo[2] = new ElCincoOscar();
      ((ElCincoOscar) teseo[2]).setLanguage(getLanguage());

     /*
     teseo[2] = new MultiAgentAprendiz();
     ((MultiAgentAprendiz) teseo[2]).setLanguage(getLanguage());
     
     teseo[3] = new TeseoTest();
     ((TeseoTest) teseo[3]).setLanguage(getLanguage());
     
     teseo[4] = new AgentsBoss();
     ((AgentsBoss) teseo[4]).setLanguage(getLanguage());
            
     teseo[5] = new SecondAgentGrupo7();
     ((SecondAgentGrupo7) teseo[5]).setLanguage(getLanguage());
     
     teseo[6] = new GraphTeseo();
     ((GraphTeseo) teseo[6]).setLanguage(getLanguage());
     
     teseo[7] = new JODAgent();
     ((JODAgent) teseo[7]).setLanguage(getLanguage());
     
     teseo[8] = new TeseoSimple();
     ((TeseoSimple) teseo[8]).setLanguage(getLanguage());
     
     teseo[9] = new TeseoMultiQuantalGraph();
     ((TeseoMultiQuantalGraph) teseo[9]).setLanguage(getLanguage());
     
     teseo[10] = new Pino();
     ((Pino) teseo[10]).setLanguage(getLanguage());
     
     teseo[11] = new UNGrupoAgent();
     ((UNGrupoAgent) teseo[11]).setLanguage(getLanguage());
     
     /* Equipo: Perceptron * /
     teseo[0] = new SimpleTeseoAgentProgramPerceptron();
     ((SimpleTeseoAgentProgramPerceptron)teseo[0]).setLanguage(getLanguage());
     /* Equipo: SinGrupo * /
     teseo[1] = new ProgAgenteSinGrupo(getLanguage());     
     /* Equipo: Los Resucitados * /
     teseo[2] = new MyTeseo();
     ((MyTeseo)teseo[2]).setLanguage(getLanguage());
     /* Equipo: TargetTeam * /
    
     teseo[3] = new AgentTarget();
     ((AgentTarget)teseo[3]).setLanguage(getLanguage());
     /* Equipo: Piratas del Caribe * /
     teseo[4] = new TeseoPerlaNegra();
     ((TeseoPerlaNegra)teseo[4]).setLanguage(getLanguage());
     /* Equipo: Brutalidad * /
     teseo[5] = new TeseoCompetitor(getLanguage());        
     /* Equipo: Rocket * /
     teseo[6] = new TournamentAgent();
     ((TournamentAgent)teseo[6]).setLanguage(getLanguage()); 
     /* Equipo: Sinergia * /
     teseo[7] = new ChampionshipAgent(getLanguage());
     /* Equipo: UNgrupo * /
     teseo[8] = new TeseoUNgrupo(getLanguage());        
     /* Equipo: Los Rolos * /
     teseo[9] = new TheAgentLosRolos(getLanguage());
     /* Equipo: TeseoCai * /
     teseo[10] = new TesoCai();
     ((TesoCai)teseo[10]).setLanguage(getLanguage());                              
    */  
    int index1 = 0;
    int index2 = 1;
    int index3 = 2;

    /*
    agente0 negro oscar
    agente1 azul jose
    agente2 rojo teseo simple
    agente3 amarillo
    agente4 azul marino
    agente5 verde jorge
      */

    LabyrinthDrawer.DRAW_AREA_SIZE = 600;
    LabyrinthDrawer.CELL_SIZE = 40;
    Labyrinth.DEFAULT_SIZE = 15;
    
    Agent agent1 = new Agent(teseo[index1]);    
    Agent agent2 = new Agent(teseo[index2]);
    Agent agent3 = new Agent(teseo[index3]);
    
    //Agent agent3 = new Agent(p3);
    Vector<Agent> agent = new Vector();
    agent.add(agent1);
    agent.add(agent2);
    agent.add(agent3);
//    Agent agent = new Agent( new RandomReflexTeseoAgentProgram( getLanguage() ) );
    MultiAgentLabyrinthMainFrame frame = new MultiAgentLabyrinthMainFrame( agent, getLanguage() );
    frame.setVisible(true); 
  }
}
