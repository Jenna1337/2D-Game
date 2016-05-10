package game.games.TicTacToe;



class TicTacToe
{
	public ComputerPlayer getAI(byte lvl, byte pid)
	{
		switch(lvl)
		{
			case 1:
			case 2:
			case 3:
				return new StupidComputerPlayer(pid);
			case 4:
			case 5:
			case 6:
				return new SmartComputerPlayer(pid);
			case 7:
			case 8:
			case 9:
				return new GeniusComputerPlayer(pid);
			default:
				new IllegalArgumentException("Invalid level for computer player: level "+(int)lvl);
				return null;
		}
	}
	enum Location
	{
		TOP_LEFT, TOP_MID, TOP_RIGHT,
		MID_LEFT,  CENTER, MID_RIGHT,
		BOT_LEFT, BOT_MID, BOT_RIGHT;
		private boolean pset=false;
		private byte player=0;
		public byte getPlayer()
		{
			return player;
		}
		/**@return true only if was empty and is now taken.**/
		public boolean setIfNotTaken(byte newplayer)
		{
			//System.out.println(name());
			if(this.pset)
				return false;
			this.player = newplayer;
			pset=true;
			return true;
		}
		private void reset()
		{
			this.pset=false;
			this.player=0;
		}
		public static void clear()
		{
			for(Location l : Location.class.getEnumConstants())
				l.reset();
		}
		/**
		 * 1, 2, 3, 
		 * 4, 5, 6, 
		 * 7, 8, 9
		 **/
		public static byte[] asPlayers()
		{
			byte[] list = new byte[9];
			byte i=(byte)0;
			for(Location l : Location.class.getEnumConstants())
				list[i++]=l.getPlayer();
			return list;
		}
	}
	private Player p1, p2;
	public TicTacToe(byte players, byte compdiff)
	{
		switch(players)
		{
			case 0:
				p1 = getAI(compdiff,(byte)1);
				p2 = getAI(compdiff,(byte)2);
				break;
			case 1:
				p1 = new HumanPlayer((byte)1);
				p2 = getAI(compdiff,(byte)2);
				break;
			case 2:
				p1 = new HumanPlayer((byte)1);
				p2 = new HumanPlayer((byte)2);
				break;
			default:
				new IllegalArgumentException("Invalid number of players: "+(int)players);
		}
	}
	private int turncount=0;
	private byte winner=(byte)-1;
	/**@return false if game is over and turn could not be made**/
	public boolean nextTurn()
	{
		winner=getWinnerNumber();
		if(winner>=0)
			return false;
		byte nextplayer = (byte)(turncount%2+1);
		boolean playerwent=false;
		Player p=null;
		if(nextplayer==(byte)1)
			p = p1;
		else if(nextplayer==(byte)2)
			p = p2;
		else new Exception("Invalid player "+nextplayer);
		while(!playerwent)
		{
			playerwent = p.getChoice().setIfNotTaken(nextplayer);
		}
		turncount+=1;
		return true;
	}
	/**
	 * @return -1 if game not over
	 *         0 if no winner
	 */
	private byte getWinnerNumber()
	{
		byte[] spots = Location.asPlayers();
		for(byte playercheck=(byte)1; playercheck<=(byte)2; ++playercheck)
		{
			for(byte var=0; var<=2; ++var)
				if(/*rows*/((playercheck==spots[var*3]) && (playercheck==spots[var*3+1]) && (playercheck==spots[var*3+2])) ||
					(/*columns*/(playercheck==spots[var]) && (playercheck==spots[var+3]) && (playercheck==spots[var+6])) ||
					(/*diagonals*/(var%2!=1) && (playercheck==spots[var]) && (playercheck==spots[4]) && (playercheck==spots[8-var]))
					)
					return playercheck;
		}
		byte taken=(byte)0;
		for(Location l : Location.class.getEnumConstants())
			if(l.getPlayer()!=(byte)0)
				taken+=1;
		if(taken>=9)
			return 0;//game is a tie
		
		//no winner and can still play
		return -1;
	}
	public byte getWinner()
	{
		return this.winner;
	}
	public void reset()
	{
		Location.clear();
		turncount=0;
	}
	@Override
	public String toString()
	{
		return (""
			+(int)Location.TOP_LEFT.getPlayer()+"|"
			+(int)Location.TOP_MID.getPlayer()+"|"
			+(int)Location.TOP_RIGHT.getPlayer()+"\n-+-+-\n"
			+(int)Location.MID_LEFT.getPlayer()+"|"
			+(int)Location.CENTER.getPlayer()+"|"
			+(int)Location.MID_RIGHT.getPlayer()+"\n-+-+-\n"
			+(int)Location.BOT_LEFT.getPlayer()+"|"
			+(int)Location.BOT_MID.getPlayer()+"|"
			+(int)Location.BOT_RIGHT.getPlayer()+"\n"
			).replace("0", " ").replace("1", "X").replace("2", "O"); 
	}
}