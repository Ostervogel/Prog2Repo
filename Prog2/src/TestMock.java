
public class TestMock implements SensorDataStorage {

	@Override
	public void saveData(long time, float[] values) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDataSet(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearData() throws NoDataRetrievedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDataSet(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDataSet(int index) throws IndexOutOfBoundsException, IllegalArgumentException, ClassCastException,
			NullPointerException, UnsupportedOperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsDataSet(float value) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsDataSet(long time) throws ClassCastException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDataSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
