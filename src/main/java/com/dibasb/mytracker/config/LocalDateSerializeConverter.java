package com.dibasb.mytracker.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateSerializeConverter implements Converter<String, LocalDate> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public LocalDate convert(String date) {
		return LocalDate.parse(date, formatter);
	}

}
