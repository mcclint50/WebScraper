/**
 * 
 * This is the object class for each player that is taken from the website.
 * 
 * @author Colin
 *
 * 
 * 
 */

public class Player {

	private String name;

	private String team;

	private int W;

	private int L;

	private double MP;

	private double PTS;

	private double FG;

	private double RB;

	private double AST;

	private double STL;

	private double BLK;

	private double TOV;

	/**
	 * 
	 * The following are all the get and set functions that can be used for this
	 * object
	 * 
	 * @author Colin
	 * 
	 */

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getTeam() {

		return team;

	}

	public void setTeam(String team) {

		this.team = team;

	}

	public int getW() {

		return W;

	}

	public void setW(int W) {

		this.W = W;

	}

	public int getL() {

		return L;

	}

	public void setL(int L) {

		this.L = L;

	}

	public double getMP() {

		return MP;

	}

	public void setMP(double MP) {

		this.MP = MP;

	}

	public double getPTS() {

		return PTS;

	}

	public void setPTS(double PTS) {

		this.PTS = PTS;

	}

	public double getFG() {

		return FG;

	}

	public void setFG(double FG) {

		this.FG = FG;

	}

	public double getRB() {

		return RB;

	}

	public void setRB(double RB) {

		this.RB = RB;

	}

	public double getAST() {

		return AST;

	}

	public void setAST(double AST) {

		this.AST = AST;

	}

	public double getSTL() {

		return STL;

	}

	public void setSTL(double STL) {

		this.STL = STL;

	}

	public double getBLK() {

		return BLK;

	}

	public void setBLK(double BLK) {

		this.BLK = BLK;

	}

	public double getTOV() {

		return TOV;

	}

	public void setTOV(double TOV) {

		this.TOV = TOV;

	}

	/**
	 * 
	 * This is the default constructor class for the players.
	 * 
	 * @author
	 * 
	 */

	public Player() {

		name = "";

		team = "";

		W = 0;

		L = 0;

		MP = 0.0;

		PTS = 0.0;

		FG = 0.0;

		RB = 0.0;

		AST = 0.0;

		STL = 0.0;

		BLK = 0.0;

		TOV = 0.0;

	}

	/**
	 * 
	 * This is the constructor class that has parameters to set the values for each
	 * player.
	 * 
	 * @author Colin
	 * 
	 * @param name
	 * 
	 * @param team
	 * 
	 * @param W
	 * 
	 * @param L
	 * 
	 * @param MP
	 * 
	 * @param PTS
	 * 
	 * @param FG
	 * 
	 * @param RB
	 * 
	 * @param AST
	 * 
	 * @param STL
	 * 
	 * @param BLK
	 * 
	 * @param TOV
	 * 
	 */

	public Player(String name, String team, int W, int L, double MP, double PTS, double FG, double RB, double AST,
			double STL, double BLK, double TOV) {

		setName(name);

		setTeam(team);

		setW(W);

		setL(L);

		setMP(MP);

		setPTS(PTS);

		setFG(FG);

		setRB(RB);

		setAST(AST);

		setSTL(STL);

		setBLK(BLK);

		setTOV(TOV);

	}

	/**
	 * 
	 * This overrides the toString() function so every time a player is printed, it
	 * will print like this.
	 * 
	 * @author Colin
	 * 
	 */

	@Override

	public String toString() {
		return String.format("%25s	%s	%d	%d	%.1f	%.1f	%.3f	%.1f	%.1f	%.1f	%.1f	%.1f", name, team, W, L, MP, PTS, FG, RB, AST, STL, BLK, TOV);
	}

}
