package com.cenfotec.grupo4.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cenfotec.grupo4.dateformat.NormaISO8601;

public class CaledarCustom implements com.cenfotec.grupo4.dateformat.DateFormat{
	@Override
	public String getFormattedDate() {
		
		return new NormaISO8601().getFormattedDate();
	}
}
