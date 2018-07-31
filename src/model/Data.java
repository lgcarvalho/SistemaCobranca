package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Data {

    private Date dataAtual;
    private Date dataSLA;
    private Date dataUltimaLog;
    private int totalMinutos;
    private int totalDiasUteis;
    private String totalTempoPassado = "00:00";
    private Calendar calDataSLA = Calendar.getInstance();
    private Calendar calDataAtual = Calendar.getInstance();
    private Calendar calDataCobranca = Calendar.getInstance();
    private Feriado feriado;
    private SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Data() {
        this.dataAtual = new Date();
    }

    public Date getDataAtual() {
        return this.dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Date getDataSLA() {
        return this.dataSLA;
    }

    public void setDataSLA(Date dataSLA) {
        this.dataSLA = dataSLA;
    }

    public String getTotalTempoPassado() {
        return this.totalTempoPassado;
    }

    public int getTotalMinutos() {
        return this.totalMinutos;
    }

    public boolean validaDataCobranca(String dataCobranca) {
        try {
            this.dataUltimaLog = this.formata.parse(dataCobranca);
        } catch (ParseException localParseException) {
        }
        this.calDataAtual.setTime(this.dataAtual);
        this.calDataCobranca.setTime(this.dataUltimaLog);
        if (this.calDataCobranca.after(this.calDataAtual)) {
            return false;
        }
        return true;
    }

    public boolean validarData(String data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        df.setLenient(false);
        try {
            df.parse(data);
            return true;
        } catch (ParseException ex) {
        }
        return false;
    }

    public boolean verificarDataSLA(String dataSLA) {
        try {
            this.dataSLA = this.formata.parse(dataSLA);
        } catch (Exception localException) {
        }
        if (this.dataAtual.before(this.dataSLA)) {
            return true;
        }
        return false;
    }

    public boolean verificarDataCobranca(String dataCobranca) {
        return false;
    }

    public boolean calcularDiasUteis(Date dataInicio, Date dataFinal) {
        int nuDiasExecutados = (int) (dataFinal.getTime() - dataInicio.getTime()) / 86400000;
        int totalDiasExecutadosUteis = 0;

        String dataComparacao = null;

        this.feriado = new Feriado();

        ArrayList<String> listaFeriado = this.feriado.getListaFeriados();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInicio);

        int diaColetado = cal.get(5);
        int mesColetado = cal.get(2) + 1;
        int anoColetado = cal.get(1);
        dataComparacao = diaColetado + "/" + mesColetado + "/" + anoColetado;
        if ((cal.get(7) == 7) || (cal.get(7) == 1) || (listaFeriado.contains(dataComparacao))) {
            return false;
        }
        for (int i = 1; i <= nuDiasExecutados; i++) {
            cal.add(5, 1);

            diaColetado = cal.get(5);
            mesColetado = cal.get(2) + 1;
            anoColetado = cal.get(1);
            dataComparacao = diaColetado + "/" + mesColetado + "/" + anoColetado;
            if ((cal.get(7) != 7) && (cal.get(7) != 1) && (!listaFeriado.contains(dataComparacao))) {
                totalDiasExecutadosUteis++;
            }
        }
        if ((cal.get(7) == 7) || (cal.get(7) == 1) || (listaFeriado.contains(dataComparacao))) {
            return false;
        }
        this.totalDiasUteis = totalDiasExecutadosUteis;
        return true;
    }

    public boolean calcularHorasPassadas(String dataUltimaLog) {
        DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date dtInicio = null;
        Date dtHoje = new Date();

        try {
            dtInicio = formataData.parse(dataUltimaLog);
        } catch (Exception localException) {
        }
        Calendar cldInicio = Calendar.getInstance();
        Calendar cldFim = Calendar.getInstance();

        cldInicio.setTime(dtInicio);
        cldFim.setTime(dtHoje);
        if (calcularDiasUteis(dtInicio, this.dataAtual) == true) {
            int diasUteis = this.totalDiasUteis;
            int quantMinutos = 0;
            try {
                dtInicio = formataHora.parse(dataUltimaLog);
            } catch (Exception localException1) {
            }
            cldInicio.setTime(dtInicio);
            cldFim.setTime(dtHoje);

            int horaDtInicio = cldInicio.get(11);
            int horaDtHoje = cldFim.get(11);

            int minutoDtInicio = cldInicio.get(12);
            int minutoDtHoje = cldFim.get(12);

            quantMinutos = diasUteis * 9 * 60;
            if ((horaDtInicio >= 9) && (horaDtInicio <= 18)) {
                quantMinutos += (9 - horaDtInicio) * 60;
                quantMinutos += -minutoDtInicio;
            } else if (horaDtInicio > 18) {
                quantMinutos -= 540;
            }
            if ((horaDtHoje >= 9) && (horaDtHoje <= 18)) {
                quantMinutos += (horaDtHoje - 9) * 60;
                quantMinutos += minutoDtHoje;
            } else if (horaDtHoje > 18) {
                quantMinutos += 540;
            }
            this.totalMinutos = quantMinutos;

            return true;
        }
        return false;
    }

    public boolean verificarHorasPassadas(String logComunicacao) {
        if ((!logComunicacao.equals("3ª Cobrança")) && (!logComunicacao.equals("4ª ou mais cobranças"))) {
            if (this.totalMinutos >= 360) {
                formataTotalHorasPassadas();
                return true;
            }
            return false;
        }
        if (this.totalMinutos >= 720) {
            formataTotalHorasPassadas();
            return true;
        }
        return false;
    }

    private void formataTotalHorasPassadas() {
        int horas = this.totalMinutos / 60;
        int minutos = this.totalMinutos % 60;
        if (horas < 10) {
            if (minutos < 10) {
                this.totalTempoPassado = ("0" + horas + ":0" + minutos);
            } else {
                this.totalTempoPassado = ("0" + horas + ":" + minutos);
            }
        } else if (minutos < 10) {
            this.totalTempoPassado = (horas + ":0" + minutos);
        } else {
            this.totalTempoPassado = (horas + ":" + minutos);
        }
    }
}
