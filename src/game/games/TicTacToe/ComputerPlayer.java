package game.games.TicTacToe;

import java.util.ArrayList;
import game.games.TicTacToe.TicTacToe.Location;

public abstract class ComputerPlayer extends Player
{
	public ComputerPlayer(byte pid)
	{
		super(pid);
	}
	public abstract byte getDifficulty();
}

class StupidComputerPlayer extends ComputerPlayer
{
	public StupidComputerPlayer(byte pid)
	{
		super(pid);
	}
	public Location getChoice()
	{
		ArrayList<Location> untaken = new ArrayList<Location>();
		for(Location l : Location.class.getEnumConstants())
			if(l.getPlayer()==0)
				untaken.add(l);
		return untaken.get((int)(Math.random()*untaken.size()));
	}
	public byte getDifficulty()
	{
		return 3;
	}
}

class SmartComputerPlayer extends StupidComputerPlayer
{
	public SmartComputerPlayer(byte pid)
	{
		super(pid);
	}
	public Location getChoice()
	{
		//Priority: center, corners, sides
		//check if the center is taken yet
		{
			if(Location.CENTER.getPlayer()==0)
				return Location.CENTER;
		}
		ArrayList<Location> untaken = new ArrayList<Location>();
		//check for open corner spots
		{
			untaken.clear();
			Location[] corn = {Location.TOP_LEFT, Location.TOP_RIGHT, Location.BOT_LEFT, Location.BOT_RIGHT};
			for(Location l : corn)
				if(l.getPlayer()==0)
					untaken.add(l);
			if(untaken.size()>0)
				return untaken.get((int)(Math.random()*untaken.size()));
		}
		//check for open side spots
		{
			untaken.clear();
			Location[] sides = {Location.TOP_MID, Location.MID_LEFT, Location.MID_RIGHT, Location.BOT_MID};
			for(Location l : sides)
				if(l.getPlayer()==0)
					untaken.add(l);
			if(untaken.size()>0)
				return untaken.get((int)(Math.random()*untaken.size()));
		}
		//pick random empty spot
		return super.getChoice();
	}
	public byte getDifficulty()
	{
		return 6;
	}
}

class GeniusComputerPlayer extends SmartComputerPlayer
{
	public GeniusComputerPlayer(byte pid)
	{
		super(pid);
	}
	public Location getChoice()
	{
		//Priority: win, counter, center, corners, sides
		//check if we have played yet
		byte em=0;
		for(byte b : Location.asPlayers())
			if(b==pid)
				em+=1;
		if(em<1)
			return super.getChoice();
		//check if we can win, choose spot
		Location ol=getTargetArea(pid);
		if(ol!=null)
			return ol;
		//check if opponent can win, counter
		Location kl=getTargetArea((byte)(pid==1?2:1));
		if(kl!=null)
			return kl;
		//check center, corners, sides
		return super.getChoice();
	}
	private Location getTargetArea(byte plr)
	{
		byte[] spots = Location.asPlayers();
		//Priority: win, counter, center, corners, sides
		for(byte sp=0; sp<=2; ++sp)
		{
			for(byte var=0; var<=2; ++var)
			{
				//System.out.println(plr+" sp:"+sp+" var:"+var);
				if(/*rows*/(spots[var*3]==((sp==0)?0:plr)) && (spots[var*3+1]==((sp==1)?0:plr)) && (spots[var*3+2]==((sp==2)?0:plr)))
					return Location.class.getEnumConstants()[var*3+sp];
				if(/*columns*/(spots[var]==((sp==0)?0:plr)) && (spots[var+3]==((sp==1)?0:plr)) && (spots[var+6]==((sp==2)?0:plr)))
					return Location.class.getEnumConstants()[var+3*sp];
				if(/*diagonals*/(var%2!=1) && (spots[var]==((sp==0)?0:plr)) && (spots[4]==((sp==1)?0:plr)) && (spots[8-var]==((sp==2)?0:plr)))
					//0, ,2,
					// ,4, ,
					//6, ,8
					//000,104,208,022,124,226
					return Location.class.getEnumConstants()[(4-var)*(var/2+sp)];
			}
		}
		//System.out.println("nope");
		return null;
	}
	public byte getDifficulty()
	{
		return 9;
	}
}	


