package com.gumtreeuk.addressbook.reader;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.gumtreeuk.addressbook.domain.Person;

public class AddressBookReader
{

	private static final Logger LOG = Logger.getLogger(AddressBookReader.class.getName());

	private String csvFilePath;

	private Reader reader;

	public AddressBookReader(String csvFilePath) {

		this.csvFilePath = csvFilePath;

	}

	public List<Person> getPersons() throws Exception   {

		LOG.info("Start reading " + csvFilePath + " address-book file.");

		try {
			reader = new FileReader(csvFilePath);
		
			ValueProcessorProvider provider = new ValueProcessorProvider();

      CSVEntryParser<Person> entryParser = new AnnotationEntryParser<Person>(Person.class);

			CSVReader<Person> csvPersonReader = new CSVReaderBuilder<Person>(reader).strategy(CSVStrategy.UK_DEFAULT).entryParser(entryParser).build();

			List<Person> persons = csvPersonReader.readAll();

			LOG.info("End reading " + csvFilePath + " address-book file.");

			return persons;
			
		} catch(ArrayIndexOutOfBoundsException exc) {
		  
      throw new Exception("Address book file is empty.");

		}
		catch (Exception e) {
			
			throw new Exception("Error reading address book file.");
		} 



	}

}
