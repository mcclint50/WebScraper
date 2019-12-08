/** this class will contain the methods that allow us to write the 
table that we create to a JSON and text file
@author Robert Oliver Jr
*/
//import neccessary files
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.uio.ObjectOutputStream;
import org.json.simple.*;
import java.util.ArrayList;

public class PlayerWriter
{


/**
This method writes the data to a JSON File
@param fn is just a string containing the file
@param data is an array list containing all of the stats from a player
@return true if there is data to be written to the file, and false otherwise
*/
public static boolean writePlayersToJSON(String fn, ArrayList<Player> players)
{
	try
	{
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(new File(fn))));
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		for (Player player : players)
		{
			//object = new JSONObject();
			object.put("Name: ", d.getName());
			object.put("Team: ", d.getTeam());
			object.put("Wins: ", d.getW());
			object.put("Losses: " , d.getL());
			object.put("Minutes Per Game: " , d.getMP());
			object.put("Points Per Game: " , d.getPTS());
			object.put("Feild Goal Attempts Per Game: " , d.getFG());
			object.put("Rebounds Per Game: " , d.getRB());
			object.put("Assists Per Game : ",d.getAST());
			object.put("Steals Per Game: " , d.getSTL());
			object.put("Blocks Per Game: " , d.getBLK());
			object.put("Turnovers Per Game: " , d.getTOV());
			array.add(object);
		}

		JSONObject allPlayers = new JSONObject();
		allPlayers.put ("players" , array);
		p.println(allPlayers.toJSONString());
		p.close();
		return true;

	} catch (Exception e)
	{
		return false;
	}
}
/**
@author Robert Oliver Jr
@param fn is a string containing our file
@param player is an array list that contains the players and their respective data/ stats
@return a boolean stating true if there is data that needs to be written to the text file
*/
public static boolean writePlayersToTextFile(String fn, ArrayList<Player> players)
{
	try 
	{
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(new File(fn))));
		for(Player player:players) 
		{
			p.println(p);
		}
		p.close();
		return true;
	} catch (Exception e )
	{
		return false;
	}
}
/**
@author Robert Oliver Jr
This method simply prints the Players data to the screen
@param ArrayList<Player> p is an ArrayList filled with the players' data/stats
	@return just prints the data to the screen.
*/
public static writePlayersToScreen(ArrayList<Player> p)
{
	System.out.println("Here are all the Players and their respective data: ")
	System.out.println("Name: ", Player.getName());
	System.out.println("Team: ", Player.getTeam());
	System.out.println("Wins: ", Player.getW());
	System.out.println("Losses: " , Player.getL());
	System.out.println("Minutes Per Game: " , Player.getMP());
	System.out.println("Points Per Game: " , Player.getPTS());
	System.out.println("Feild Goal Attempts Per Game: " , Player.getFG());
	System.out.println("Rebounds Per Game: " , Player.getRB());
	System.out.println("Assists Per Game : ",Player.getAST());
	System.out.println("Steals Per Game: " , Player.getSTL());
	System.out.println("Blocks Per Game: " , Player.getBLK());
	System.out.println("Turnovers Per Game: " , Player.getTOV());
}

//empty main just for looks
public static void main(String[] args)
	{

	}

}
