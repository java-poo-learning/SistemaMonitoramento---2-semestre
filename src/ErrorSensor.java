public class ErrorSensor {
    private String idSensor;
    private String MensagemErro;

    public ErrorSensor(String idSensor, String mensagemErro) {
        this.idSensor = idSensor;
        MensagemErro = mensagemErro;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public String getMensagemErro() {
        return MensagemErro;
    }
}
