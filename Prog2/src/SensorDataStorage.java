
/**
 * We assume: Each sensor gets its own storage engine. There wont be a parameter
 * sensor name.
 */
public interface SensorDataStorage {

	/**
	 * This method can be called by a sensor to save a data set.
	 * 
	 * @param time   UNIX time when measurement took place
	 * @param values sensor data
	 * @throws PersistenceException if something unexpected happened. Insufficient
	 *                              right, medium broken, offline..
	 */

	void saveData(long time, float[] values) throws PersistenceException;

	/**
	 * 
	 * @param index of the data set to be removed
	 */

	void removeDataSet(int index) throws IndexOutOfBoundsException;

	/**
	 * Clears all data entries
	 */
	void clearData() throws NoDataRetrievedException;

	/**
	 * 
	 * @param index of the data set to be retrieved
	 */

	void getDataSet(int index) throws IndexOutOfBoundsException;

	/**
	 * 
	 * @return the amount of data collected
	 */

	void setDataSet(int index) throws IndexOutOfBoundsException, IllegalArgumentException, ClassCastException,
			NullPointerException, UnsupportedOperationException;

	/**
	 * 
	 * @param value
	 * @return true when data set with this Data exists
	 * @throws ClassCastException
	 * @throws NullPointerException
	 */
	boolean containsDataSet(float value) throws ClassCastException, NullPointerException;

	/**
	 * 
	 * @param time
	 * @return true when dataset with this timestamp exists
	 * @throws ClassCastException
	 * @throws NullPointerException
	 */
	boolean containsDataSet(long time) throws ClassCastException, NullPointerException;

	/**
	 * 
	 * @return the amount of data collected
	 */
	int getDataSize();

	/**
	 * 
	 * @return true when no data was collected so far
	 */
	boolean isEmpty();

	// what else could we need? Get inspired by e.g. this:
	// https://docs.oracle.com/javase/7/docs/api/java/util/List.html

	// size() is usually a good idea
	// get at data set at a position as well.
	// what can go wrong.... Declare methods. Don't forget exceptions. Write
	// comments!
}