import org.apache.commons.cli.*;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import java.io.IOException;
import java.util.Set;
public class MainJarAndCommandLineTEST {
    public static void main (String[] args) throws ParseException{
        DataImporter importer = new DataImporter();
        Raport raport = null;
        DataRaportPrinter printer = null;
        Options options = new Options();
        options.addOption("path", true, "put path of location");
        options.addOption("report1", false, "put report needed");
        options.addOption("report2", false, "put printer type");
        options.addOption("report3", false, "put printer type");
        options.addOption("console", false, "printing result on console");
        options.addOption("CSV", false, "printing result as CSV into project directory");
        options.addOption("XLS", false, "printing result as XLS into project directory");
        options.addOption("PDF", false, "printing result as PDF into project directory");
        options.addOption("info", false, "operations manual");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse( options, args );
            String path = line.getOptionValue("path");
            if(line.hasOption("path")) {
                System.out.println("running......path" + " " + path);
            }
            if(line.hasOption("report1")) {
                Set<Project> set = importer.importDataFromFiles(path);
                raport = new Raport1();
                raport.generateRaport(set);
            }
            if(line.hasOption("report2")) {
                Set<Project> set = importer.importDataFromFiles(path);
                raport = new Raport2();
                raport.generateRaport(set);
            }
            if(line.hasOption("report3")) {
                Set<Project> set = importer.importDataFromFiles(path);
                raport = new Raport3();
                raport.generateRaport(set);
            }
            if(line.hasOption("report4")) {
                System.out.println("running......");
            }
            if(line.hasOption("report5")) {
                System.out.println("running......");
            }
            if(line.hasOption("console")) {
                System.out.println("running......on console below");
                printer = new ConsoleDataRaportPrinter();
                try {
                    printer.printRaport(raport);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(line.hasOption("CSV")) {
                System.out.println("saving......as CSV into project directory");
                printer = new CSVDataRaportPrinter();
                try {
                    printer.printRaport(raport);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(line.hasOption("XLS")) {
                System.out.println("saving......as XLS into project directory");
                printer = new ExcelDataRaportPrinter();
                try {
                    printer.printRaport(raport);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(line.hasOption("PDF")) {
                System.out.println("saving......as PDF into project directory");
                printer = new PDFDataRaportPrinter();
                try {
                    printer.printRaport(raport);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(line.hasOption("info")) {
                System.out.println("operations manual.....");
            }
            if(line.hasOption("failures")) {
                System.out.println("running......");
            }
            if(line.hasOption("range_from")) {
                System.out.println("running......");
            }
            if(line.hasOption("range_to")) {
                System.out.println("running......");
            }
        }
        catch( ParseException exp ) {
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
        }
    }
}
