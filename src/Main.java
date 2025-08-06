import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// finally sempre será executado!
public class Main {
    public static void main(String[] args) {

        List<Sensor> listaSensor = new ArrayList<>();
        List<List<Double>> listaLeitura = new ArrayList<>();

        for (int i = 1 ; i <= 3; i++) {
            listaSensor.add(new Sensor (String.valueOf(i)));
            listaLeitura.add(gerarLeitura(i));
    }
        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processarSensores(listaSensor, listaLeitura);
        sistema.exibirRelatorio();

    }

    private static List<Double> gerarLeitura(int i) {
        Random rd = new Random();
        List<Double> aux = new ArrayList<>();
        int total = 100;
        double limite = 60;
        switch (i) {
            case 2 -> total = total/2;
            case 3 -> limite = limite + 2;
        }
        for (int k = 0; k < total; k++) {
            aux.add(rd.nextDouble(-limite , limite));
        }
        return aux;


    }
}
