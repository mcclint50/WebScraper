/** this class will contain the methods that allow us to write the 
table that we create to a JSON and text file
@author Robert Oliver Jr
*/

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
public static boolean writeToJSON(String fn, ArrayList<PulledData> data )
{
	try
	{
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(new File(fn))));
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		for (PulledData d : data)
		{
			//object = new JSONObject();
			object.put("Name: ", d.getName());
			object.put("Team: ", d.getTeam());
			object.put("Wins: ", d.getWins());
			object.put("Losses: " , d.getLosses());
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

		JSONObject players = new JSONObject();
		players.put ("players" , array);
		p.println(players.toJSONString());
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
public static boolean writeToTextFile(String fn, ArrayList<player> players)
{
	try 
	{
		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(new File(fn))));
		for(player p:players) 
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

public static writePlayersToScreen()
{
	System.out.println("Here are all the Players and their respective data: ")

}
public static void main(String[] args)
	{

	}



}
