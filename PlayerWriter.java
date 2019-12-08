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
			object.put("Name: ", player.getName());
			object.put("Team: ", player.getTeam());
			object.put("Wins: ", player.getW());
			object.put("Losses: " , player.getL());
			object.put("Minutes Per Game: " , player.getMP());
			object.put("Points Per Game: " , player.getPTS());
			object.put("Feild Goal Attempts Per Game: " , player.getFG());
			object.put("Rebounds Per Game: " , player.getRB());
			object.put("Assists Per Game : ",player.getAST());
			object.put("Steals Per Game: " , player.getSTL());
			object.put("Blocks Per Game: " , player.getBLK());
			object.put("Turnovers Per Game: " , player.getTOV());
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
public static void writePlayersToScreen(ArrayList<Player> players)
{
	for (Player p :players)
	{
	System.out.println("Here are all the Players and their respective data: ")
	System.out.println("Name: ", p.getName());
	System.out.println("Team: ", p.getTeam());
	System.out.println("Wins: ", p.getW());
	System.out.println("Losses: " , p.getL());
	System.out.println("Minutes Per Game: " , p.getMP());
	System.out.println("Points Per Game: " , p.getPTS());
	System.out.println("Feild Goal Attempts Per Game: " , p.getFG());
	System.out.println("Rebounds Per Game: " , p.getRB());
	System.out.println("Assists Per Game : ",p.getAST());
	System.out.println("Steals Per Game: " , p.getSTL());
	System.out.println("Blocks Per Game: " , p.getBLK());
	System.out.println("Turnovers Per Game: " , p.getTOV());
}	
}

//empty main just for looks
public static void main(String[] args)
	{

	}

}
