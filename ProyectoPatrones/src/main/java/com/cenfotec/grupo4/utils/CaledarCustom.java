package com.cenfotec.grupo4.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaledarCustom {
	Date date = new Date();
	DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String convertido = fechaHora.format(date);

}
