/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserobots;

/**
 *
 * @author andad
 */
public class VerificareSEO {

    private String URLClient;

    private boolean SearchGoogle;

    private boolean ReadRobots;

    public String getURLClient() {
        return URLClient;
    }

    public void setURLClient(String URLClient) {
        this.URLClient = URLClient;
    }

    public boolean isSearchGoogle() {
        return SearchGoogle;
    }

    public void setSearchGoogle(boolean SearchGoogle) {
        this.SearchGoogle = SearchGoogle;
    }

    public boolean isReadRobots() {
        return ReadRobots;
    }

    public void setReadRobots(boolean ReadRobots) {
        this.ReadRobots = ReadRobots;
    }

    @Override
    public String toString() {
        return " Clientul are : " + URLClient + " :robots.txt " + ReadRobots;
    }

}
