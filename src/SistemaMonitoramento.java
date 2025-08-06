import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErrorSensor> sensoresComErro;

    // inicializar as variáveis
    public SistemaMonitoramento() {
        this.sensoresValidos = new ArrayList<>();
        this.sensoresComErro = new ArrayList<>();
    }

    // lista dentro da lista
    public void processarSensores(List<Sensor> listaSensor, List<List<Double>> listaLeitura) {

        for(int i = 0; i < listaSensor.size(); i++) {
            Sensor sensor = listaSensor.get(i);
            List<Double> leituras = listaLeitura.get(i);
            try {
            sensor.registrarLeituras(leituras);
            sensoresValidos.add(sensor);
        }
            // | representa junção, || representa ou
            catch (IllegalArgumentException | LeituraInvalidaException e) {
                sensoresComErro.add(new ErrorSensor(sensor.getId(), e.getMessage()));
            }

        }
    }

    public void exibirRelatorio() {
        System.out.println("===== Sensores Validos =====");
        for (Sensor sensor : sensoresValidos) {
            System.out.println("Sensor: " + sensor.getId());

        }
        System.out.println("\n===== Sensores com Erro =====");
        for(ErrorSensor errorSensor : sensoresComErro) {
            System.out.println("Sensor: " + errorSensor.getIdSensor() + " --> " + errorSensor.getMensagemErro());

        }
    }

}
