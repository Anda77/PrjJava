/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserobots;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.newBufferedWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class SEOReport {

    List<VerificareSEO> l = null;

    private static RobotsTxt bots;

    String fisierConfigurari = "";

    String browser = "";

    String sessionId = "";

    String typeTest = "";

    // Reusable buffer
    private final StringBuilder buffer = new StringBuilder();

    private String fileName = "emailable-report_SEO.html";

    private static final String JVM_ARG = "emailable.report2.name";

    protected PrintWriter writer;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    private static RobotsTxt fetchRobot(String url) {
        InputStream robotsTxtStream = null;
        RobotsTxt robotsTxt = null;
        try {
            robotsTxtStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            robotsTxt = RobotsTxt.read(robotsTxtStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return robotsTxt;
    }




    public void generateReport(List<VerificareSEO> xmlSuites, String outputDirectory) {
        try {
            writer = createWriter(outputDirectory);
        } catch (IOException e) {

            return;
        }

        writeDocumentStart();
        writeHead();
        writeBody("SEOReport", xmlSuites);
        writeDocumentEnd();

        writer.close();
    }

    protected PrintWriter createWriter(String outdir) throws IOException {
        new File(outdir).mkdirs();
        String jvmArg = System.getProperty(JVM_ARG);
        if (jvmArg != null && !jvmArg.trim().isEmpty()) {
            fileName = jvmArg;
        }
        return new PrintWriter(newBufferedWriter(new File(outdir, fileName).toPath(), UTF_8));
    }

    protected void writeDocumentStart() {
        writer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
        writer.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    }

    protected void writeHead() {
        writer.println("<head>");
        writer.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"/>");
        writer.println("<title>Raport SEO ContentSpeed</title>");
        writeStylesheet();
        writer.println("</head>");
    }

    //<td class="num attn">1</td>
    protected void writeStylesheet() {
        writer.print("<style type=\"text/css\">");
        writer.print("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
        writer.print("th,td {border:1px solid #009;padding:.25em .5em}");
        writer.print("th {vertical-align:bottom}");
        writer.print("td {vertical-align:top}");
        writer.print("table a {font-weight:bold}");
        writer.print(".stripe td {background-color: #E6EBF9}");
        writer.print(".num {text-align:right}");
        writer.print(".passedodd td {background-color: #3F3}");
        writer.print(".passedeven td {background-color: #0A0}");
        writer.print(".skippedodd td {background-color: #DDD}");
        writer.print(".skippedeven td {background-color: #CCC}");
        writer.print(".failedodd td,.attn {background-color: #F33}");
        writer.print(".failedeven td,.stripe .attn {background-color: #D00}");
        writer.print(".stacktrace {white-space:pre;font-family:monospace}");
        writer.print(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
        writer.print(".invisible {display:none}");
        writer.println("</style>");
    }

    public String getsdfdateByZone() {

        Date date1 = new Date();

        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        sdfdate.setTimeZone(TimeZone.getTimeZone("Europe/Bucharest"));

        return sdfdate.format(date1).toString();
    }

    protected void writeReportTitle(String title) {
        writer.print("<center><h1>" + title + " - " + getsdfdateByZone() + "</h1></center>");
    }

    protected void writeBody(String title, List<VerificareSEO> xmlSuites) {
        writer.println("<body>");
        writeReportTitle(title);
        writeSuiteSummary(xmlSuites);

        writer.println("</body>");
    }

    protected void writeDocumentEnd() {
        writer.println("</html>");
    }

    protected void writeSuiteSummary(List<VerificareSEO> xmlSuites) {
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormat decimalFormat = NumberFormat.getNumberInstance();

        int count = 1;

        writer.println("<table>");

        writer.print("<tr><th>");
        writer.print("Nr crt.</th>");

        writer.print("<th>");
        writer.print("URL</th>");
        writer.print("<th>Robots</th>");
        writer.println("</tr>");

        int testIndex = 0;

      

        for (VerificareSEO suiteResult : xmlSuites) {

            writer.print("<tr");
            if ((testIndex % 2) == 1) {
                writer.print(" class=\"stripe\"");
            }
            writer.print(">");

            buffer.setLength(0);

            String conditie1 = Integer.toString(count++);

            writeTableData(conditie1, "num");

            String URLSite = "";
            writeTableData(buffer.append("<a href=").append(suiteResult.getURLClient())
                    .append(">")
                    .append(suiteResult.getURLClient())
                    .append("</a>").toString());

            String conditie = (suiteResult.isReadRobots()) ? "True" : "False";
            if (conditie.equals("True")) {
                writeTableData(conditie, "num");
            } else {
                writeTableData(conditie, "num attn");

            }

            writer.println("</tr>");

            testIndex++;

            //writer.println("index este: " + testIndex);

        }

        writer.println("</table>");
    }

    /**
     * Writes the scenario summary for the results of a given state for a single
     * test.
     */
    /**
     * Writes the details for all test scenarios.
     */
    protected void writeTableHeader(String html, String cssClasses) {
        writeTag("th", html, cssClasses);
    }

    /**
     * Writes a TD element with the specified contents.
     *
     * @param html the HTML contents
     */
    protected void writeTableData(String html) {
        writeTableData(html, null);
    }

    /**
     * Writes a TD element with the specified contents and CSS class names.
     *
     * @param html the HTML contents
     * @param cssClasses the space-delimited CSS classes or null if there are no
     * classes to apply
     */
    protected void writeTableData(String html, String cssClasses) {
        writeTag("td", html, cssClasses);
    }

    /**
     * Writes an arbitrary HTML element with the specified contents and CSS
     * class names.
     *
     * @param tag the tag name
     * @param html the HTML contents
     * @param cssClasses the space-delimited CSS classes or null if there are no
     * classes to apply
     */
    protected void writeTag(String tag, String html, String cssClasses) {
        writer.print("<");
        writer.print(tag);
        if (cssClasses != null) {
            writer.print(" class=\"");
            writer.print(cssClasses);
            writer.print("\"");
        }
        writer.print(">");
        writer.print(html);
        writer.print("</");
        writer.print(tag);
        writer.print(">");
    }

}
