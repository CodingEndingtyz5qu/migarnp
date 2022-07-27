import java.io.IOException;

public class ChartDataRaportPrinter extends DataRaportPrinter {

    ChartType chartType;

    public ChartDataRaportPrinter(Raport raport) {
        super(raport);
        // TODO Auto-generated constructor stub
    }

        
    @Override
    public void printRaport() throws IOException {
        String raportType = this.getRaportObject().getClass().getName();
        if (this.getTimeRange().equals("brak danych")) {
            System.out.println("Brak danych, dla ktorych mozna utworzyc wykres!");
        }
        else if (raportType.equals("Raport1") || raportType.equals("Raport2")) {
            chartType = new ChartTypeXStringsYNumbers();
            chartType.printChart(this.getRaportObject());
        }
        else {
            System.out.println("Wykres dla " + raportType + " jest aktualnie nieobslugiwany. Pracujemy nad tym.");
        }
    }
}