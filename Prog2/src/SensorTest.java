import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class SensorTest {

	@Test
	public void createDataTestGood() {
		WriteAndReadDataSet.createData();

	}

	@Test
	public void writeDataTestGood() throws FileNotFoundException, IOException {
		String filename = "DataSets.txt";
		WriteAndReadDataSet.writeData(filename);

	}

	@Test(expected = FileNotFoundException.class)
	public void writeDataTestBad() throws FileNotFoundException, IOException {
		String filename = "InvalidFileName.txt";
		WriteAndReadDataSet.writeData(filename);

	}

	@Test(expected = IOException.class)
	public void writeDataTestBad2() throws FileNotFoundException, IOException {
		String filename = "DataSets.txt";
		WriteAndReadDataSet.writeData(filename);
		throw new IOException();

	}

	@Test
	public void readDataTestGood() throws FileNotFoundException, IOException {
		String filename = "DataSets.txt";
		WriteAndReadDataSet.readData(filename);
		;

	}

	@Test(expected = FileNotFoundException.class)
	public void readDataTestBad() throws FileNotFoundException, IOException {
		String filename = "InvalidFileName.txt";
		WriteAndReadDataSet.readData(filename);
		;

	}

	@Test
	public void readDataTestBad2() throws FileNotFoundException, IOException {
		String filename = "DataSets.txt";
		WriteAndReadDataSet.readData(filename);
		throw new IOException();

	}

	@Test
	public void saveDataTestGood() throws PersistenceException {
		fail("Not yet implemented");
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.saveData(234897, new float[] { 1.5F });

	}

	@Test(expected = PersistenceException.class)
	public void saveDataTestBad() throws PersistenceException {
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.saveData(234897, new float[] { 1.5F });
		throw new PersistenceException();
	}

	@Test
	public void removeDataSetTestGood() throws IndexOutOfBoundsException {
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.removeDataSet(2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeDataSetTestBad() throws IndexOutOfBoundsException {
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.removeDataSet(2);
		throw new IndexOutOfBoundsException();
	}

	@Test
	public void clearDataGood() throws NoDataRetrievedException {
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.clearData();
	}

	@Test(expected = NoDataRetrievedException.class)
	public void clearDataBad() throws NoDataRetrievedException {
		SensorDataStorage dataStorage = new TestMock();
		dataStorage.clearData();
		throw new NoDataRetrievedException();
	}

}
