import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;
 
public class ScreenScraper {
	public static ArrayList<Player> PlayerScraper(String url) {
		ArrayList<Player> players = new ArrayList<Player>();
		String line;
        String name = "";
        String team = "";
        int W = 0;
        int L = 0;
        double MP = 0.0;
        double PTS = 0.0;
        double FG = 0.0;
        double RB = 0.0;
        double AST = 0.0;
        double STL = 0.0;
        double BLK = 0.0;
        double TOV = 0.0;
        try {
            URL link = new URL(url);
            Scanner linksc = new Scanner(link.openStream());
            Player p;
            while (linksc.hasNextLine()) {
                line = linksc.nextLine();
                if (line.contains("data-stat=\"player\" csk=\"")) {
                	name = line.substring(line.indexOf("data-stat=\"player\" csk=\"")+24, line.indexOf("\" ><a href=\"/players/"));
                	team = line.substring(line.indexOf("data-stat=\"team_id\" ><a href=\"/teams/")+37, line.indexOf("/2020.html\">"));
                	W = Integer.parseInt(line.substring(line.indexOf("data-stat=\"wins\" >")+18, line.indexOf("</td><td class=\"right \" data-stat=\"losses\"")));
                	L = Integer.parseInt(line.substring(line.indexOf("data-stat=\"losses\" >")+20, line.indexOf("</td><td class=\"right \" data-stat=\"win_loss_pct\"")));
                	MP = Double.parseDouble(line.substring(line.indexOf("data-stat=\"mp_per_g\" >")+22, line.indexOf("</td><td class=\"right \" data-stat=\"fg_per_g\"")));
                	PTS = Double.parseDouble(line.substring(line.indexOf("data-stat=\"pts_per_g\" >")+23, line.indexOf("</td><td class=\"right iz\" data-stat=\"xyz\"")));
                	FG = Double.parseDouble(line.substring(line.indexOf("data-stat=\"fg_pct\" >")+20, line.indexOf("</td><td class=\"right \" data-stat=\"fg3_per_g\"")));
                	RB = Double.parseDouble(line.substring(line.indexOf("data-stat=\"trb_per_g\" >")+23, line.indexOf("</td><td class=\"right \" data-stat=\"ast_per_g\"")));
                	AST = Double.parseDouble(line.substring(line.indexOf("data-stat=\"ast_per_g\" >")+23, line.indexOf("</td><td class=\"right \" data-stat=\"stl_per_g\"")));
                	STL = Double.parseDouble(line.substring(line.indexOf("data-stat=\"stl_per_g\" >")+23, line.indexOf("</td><td class=\"right \" data-stat=\"blk_per_g\"")));
                	BLK = Double.parseDouble(line.substring(line.indexOf("data-stat=\"blk_per_g\" >")+23, line.indexOf("</td><td class=\"right \" data-stat=\"tov_per_g\"")));
                	TOV = Double.parseDouble(line.substring(line.indexOf("data-stat=\"tov_per_g\" >")+23, line.indexOf("</td><td class=\"right \" data-stat=\"pf_per_g\"")));
                	p = new Player(name, team, W, L, MP, PTS, FG, RB, AST, STL, BLK, TOV);
                	players.add(p);
                }
            }
            linksc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Could not connect to the website.");
        }
        return players;
    }
}
        