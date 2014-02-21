package api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
 
public final class TokensChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player eventPlayer;
    private Integer prevBal;
    private Integer change;
    private Integer newBal;
    private Boolean isNegChange;
 
	@SuppressWarnings("unused")
	public TokensChangeEvent(Player p, Integer prevBalance, Integer changeAmnt, Integer newBalance, Boolean isNegativeChange) {
        Player eventPlayer = p;
        Integer prevBal = prevBalance;
        Integer change = changeAmnt;
        Integer newBal = newBalance;
        Boolean isNegChange = isNegativeChange;
    }
 
    public Player getPlayer() {
    	return eventPlayer;
    }
    public Integer getPreviousBalance() {
    	return prevBal;
    }
    public Integer getChangeAmnt() {
    	return change;
    }
    public Integer getNewBalance() {
    	return newBal;
    }
    public Boolean isNegativeChange() {
    	return isNegChange;
    }
	public HandlerList getHandlers() {
		return handlers;
	}
    
}