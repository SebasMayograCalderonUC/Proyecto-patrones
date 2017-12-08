package com.cenfotec.grupo4.dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class NormaISO8601 implements com.cenfotec.grupo4.dateformat.DateFormat{

	@Override
	public String getFormattedDate() {
		Date date = new Date();
		DateFormat fechaHora = new SimpleDateFormat("YYYY-MM-dd");
		String dateFormat = fechaHora.format(date);
		return dateFormat;
	}
}
