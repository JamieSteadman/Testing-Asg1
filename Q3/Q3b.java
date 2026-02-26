package Q3;
import java.util.*;

public class Q3b implements CatanAgent {

    private int playerIdThing;
    private List<Move> moveListThing = new ArrayList<>();
    private int idxThing = 0;

    public void SimpleScriptedAgent(List<Move> movesThing) {
        
        for (int i = 0; i < movesThing.size(); i++) {
            moveListThing.add(movesThing.get(i));
        }
    }

    
    public void init(int playerId) {
        this.playerIdThing = playerId;
        idxThing = 0;
    }

    
    public Move chooseMove(GameState stateThing) {
        if (idxThing >= moveListThing.size()) {
            throw new IllegalStateException("ran out of moves for player " + playerIdThing);
        }
        Move tempMoveThing = moveListThing.get(idxThing);
        idxThing++;
        return tempMoveThing;
    }

     
    public Move chooseInitialSettlement(GameState state) { return chooseMove(state); }
    public Move chooseInitialRoad(GameState state) { return chooseMove(state); }

    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) { return new HashMap<>(); }
    public ResourceType chooseResource(GameState state) { return ResourceType.WOOD; }

    
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        if (possibleTargets == null || possibleTargets.size() == 0) return -1;
        return possibleTargets.get(0);
    }

    public DevelopmentCard chooseDevelopmentCard(GameState state) { return new DevelopmentCard(); }
}