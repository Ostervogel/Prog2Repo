import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteAndReadDataSet {
	static String sensorName = "MyGoodOldSensor";
	static OutputStream os = null;
	static DataOutputStream dos = null;
	static InputStream is = null;
	static DataInputStream dis = null;
	static String filename = "DataSets.txt";
	static long timeStamps[] = new long[3];
	static float[][] values = new float[3][];
	static float[] valueSet = new float[1];

	public static void main(String[] args) throws FileNotFoundException, IOException {

		createData();
		writeData(filename);
		readData(filename);

	}

	public static void createData() {
		// three example data sets
		// does not change

		timeStamps[0] = System.currentTimeMillis();
		timeStamps[1] = timeStamps[0] + 1; // milli sec later
		timeStamps[2] = timeStamps[1] + 1000; // second later

		// 1st measure .. just one value

		valueSet[0] = (float) 1.5; // example value 1.5 degrees
		values[0] = valueSet;

		// 2nd measure .. just three values
		valueSet = new float[3];
		values[1] = valueSet;
		valueSet[0] = (float) 0.7;
		valueSet[1] = (float) 1.2;
		valueSet[2] = (float) 2.1;

		// 3rd measure .. two values
		valueSet = new float[2];
		values[2] = valueSet;
		valueSet[0] = (float) 0.7;
		valueSet[1] = (float) 1.2;

	}

	/**
	 * 
	 * @param filename textfile to write to
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void writeData(String filename) throws IOException, FileNotFoundException {
		try {
			
			/**
			 * Preparing to write values to the file
			 */
			os = new FileOutputStream(filename);
			dos = new DataOutputStream(os);

			/**
			 * Fill the DataOutputStream with the data sets values.
			 */
			for (int i = 0; i < values.length; i++) {
				for (int k = 0; k < values[i].length; k++) {
					dos.writeUTF(sensorName);
					dos.writeLong(timeStamps[0]);
					dos.writeFloat(values[i][k]);

				}
			}

		}

		/**
		 * If the file path is wrong or the file doesn't exist.
		 */
		catch (FileNotFoundException ex) {
			System.err.println("couldn’t open file - fatal");
			System.exit(0); // brutal exception handling
		} /**
			 * If data can't be retrieved.
			 */

		catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("couldn’t write data (fatal)");
			System.exit(0);
		}
	}

	public static void readData(String filename) throws IOException, FileNotFoundException {
		/**
		 * Preparing to read values from the file
		 */

		try {
			is = new FileInputStream(filename);
			dis = new DataInputStream(is);

			/**
			 * While there are still values in the DataInputStream...
			 */
			String s;
			float f;
			long l = 0;
			int counter = 0;

			while (dis.available() > 0) {
				/**
				 * Print out the values from the DataInputStream depending on DataType
				 */

				if (counter == 0) {
					s = dis.readUTF();
					System.out.println(s);
					counter++;
				}

				if (counter == 1) {
					l = dis.readLong();
					System.out.println(l);
					counter++;

				} else {
					f = dis.readFloat();
					System.out.println(f + System.lineSeparator());
					counter = 0;
				}

			}
			/**
			 * If the file path is wrong or the file doesn't exist.
			 */
		} catch (FileNotFoundException ex) {
			System.err.println("couldn’t open file - fatal");
			System.exit(0); // brutal exception handling
		} /**
			 * If data can't be retrieved.
			 */

		catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("couldn’t write data (fatal)");
			System.exit(0);
		}

		/**
		 * Close the streams
		 */
		finally {
			if (os != null) {
				os.close();
			}
			if (dos != null) {
				dos.close();
			}

			if (is != null) {
				is.close();
			}

			if (dis != null) {
				dis.close();
			}
		}
	}
}
