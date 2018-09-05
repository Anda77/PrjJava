/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserobots;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anda.cristea
 */
public class ParseRobots_2 {

    /**
     * @param args the command line arguments
     */
    private static RobotsTxt bots;

    private static RobotsTxt fetchRobot(String url) {
        InputStream robotsTxtStream = null;
        RobotsTxt robotsTxt = null;
        try {
            robotsTxtStream = new URL(url).openStream();
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(url + " begin read robots.txt");
            robotsTxt = RobotsTxt.read(robotsTxtStream);
            System.out.println(url + " end read robots.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return robotsTxt;
    }

    private static VerificareSEO saveVerificariSEO(String URLClient) throws Exception {
        VerificareSEO seo = new VerificareSEO();
        seo.setURLClient(URLClient);

        String urlRobots = URLClient + "robots.txt";

        bots = fetchRobot(urlRobots);
        String user_agent = "*";

        //  System.out.println(bots.toString());
        List<String> disallowList = bots.getDisallowList(user_agent);

        System.out.println("marime colectie: " + disallowList.size() + ":" + URLClient);

        for (String s : disallowList) {
            //System.out.println(s);
            if (s.equals("/cs-admin")) {
                seo.setReadRobots(true);
                System.out.println(URLClient + " este indexat");
                break;
            }
        }

        return seo;

    }



    //creez o clasa VerificareSEO cu 3 proprietati : SearchGoogle si ReadRobots si URLClient
    public static void main(String[] args) throws Exception {

        String urlSite5 = "https://cofetarulistet.ro/";

        String urlSite6 = "https://empirefilm.ro/";

        String urlSite7 = "https://www.damila.ro/";

//        VerificareSEO seo = saveVerificariSEO(url);
//
//        VerificareSEO seo1 = saveVerificariSEO(url1);
//
//        VerificareSEO seo11 = saveVerificariSEO(url2);
//
//        VerificareSEO seo2 = saveVerificariSEO(urlSite8);
//
//        VerificareSEO seo3 = saveVerificariSEO(urlSite3);
//
//        VerificareSEO seo4 = saveVerificariSEO(urlSite4);
        VerificareSEO seo5 = saveVerificariSEO(urlSite5);

        VerificareSEO seo6 = saveVerificariSEO(urlSite6);

//        VerificareSEO seo7 = saveVerificariSEO(urlSite7);
//
//        VerificareSEO seo8 = saveVerificariSEO(urlSite9);
        List<VerificareSEO> l = new ArrayList<VerificareSEO>();

//        l.add(seo);
//        l.add(seo1);
//        l.add(seo2);
//        l.add(seo3);
//        l.add(seo4);
//        l.add(seo11);
        l.add(seo5);
        l.add(seo6);
//        l.add(seo7);
//        l.add(seo8);

        SEOReport report = new SEOReport();

        report.generateReport(l, "D:\\test-output");

       
    }

}
