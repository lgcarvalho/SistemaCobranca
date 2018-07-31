package model;

import java.util.ArrayList;

public class Feriado
{
  private final ArrayList<String> listaFeriados;
  
  public Feriado()
  {
    this.listaFeriados = new ArrayList();
    
    this.listaFeriados.add("14/4/2017");
    this.listaFeriados.add("21/4/2017");
    this.listaFeriados.add("1/5/2017");
    this.listaFeriados.add("15/6/2017");
    this.listaFeriados.add("7/9/2017");
    this.listaFeriados.add("12/10/2017");
    this.listaFeriados.add("2/11/2017");
    this.listaFeriados.add("15/11/2017");
    this.listaFeriados.add("25/12/2017");
    this.listaFeriados.add("1/1/2018");
    this.listaFeriados.add("25/1/2018");
    this.listaFeriados.add("13/2/2018");
    this.listaFeriados.add("30/3/2018");
    this.listaFeriados.add("1/4/2018");
    this.listaFeriados.add("21/4/2018");
    this.listaFeriados.add("1/5/2018");
    this.listaFeriados.add("31/5/2018");
    this.listaFeriados.add("7/9/2018");
    this.listaFeriados.add("12/10/2018");
    this.listaFeriados.add("2/11/2018");
    this.listaFeriados.add("15/11/2018");
    this.listaFeriados.add("20/11/2018");
    this.listaFeriados.add("25/12/2018");
    this.listaFeriados.add("1/1/2019");
  }
  
  public ArrayList<String> getListaFeriados()
  {
    return this.listaFeriados;
  }
}