import java.io.IOException;

public class ChessEngine implements ChessReceiver, ChessSender {
	private ChessStatus status;

	public ChessEngine(ChessStatus status) {

		this.status = ChessStatus.STARTE_SPIEL;
	}

	@Override
	public void receiveDice(int number) throws IOException, StatusException {
		if (this.status != ChessStatus.STARTE_SPIEL) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveChoosenColor(boolean white) throws IOException, StatusException {
		if (this.status != ChessStatus.FARBE_WAEHLEN) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveMove(int from, int to) throws IOException, StatusException {
		if (this.status != ChessStatus.PASSIV) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveMovePawnRule(int from, int figureType) throws IOException, StatusException {
		if (this.status != ChessStatus.PASSIV) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveRochade(int from) throws IOException, StatusException {
		if (this.status != ChessStatus.PASSIV) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveEndGame(int reason) throws IOException, StatusException {
		if (this.status != ChessStatus.PASSIV) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveProposalEnd(int reason) throws IOException, StatusException {
		if (this.status != ChessStatus.PASSIV) {
			throw new StatusException();
		}

	}

	@Override
	public void receiveProposalAnswer(boolean accept) throws IOException, StatusException {
		if (this.status != ChessStatus.WARTEND) {
			throw new StatusException();
		}

	}

	@Override
	public void sendDice(int number) throws IOException, StatusException {
		if (this.status != ChessStatus.STARTE_SPIEL) {
			throw new StatusException();
		}

	}

	@Override
	public void sendChoosenColor(boolean white) throws IOException, StatusException {
		if (this.status != ChessStatus.FARBE_WAEHLEN) {
			throw new StatusException();
		}

	}

	@Override
	public void sendMove(int from, int to) throws IOException, StatusException {
		if (this.status != ChessStatus.AKTIV) {
			throw new StatusException();
		}

	}

	@Override
	public void sendMovePawnRule(int from, int figureType) throws IOException, StatusException {
		if (this.status != ChessStatus.AKTIV) {
			throw new StatusException();
		}

	}

	@Override
	public void sendRochade(int from) throws IOException, StatusException {
		if (this.status != ChessStatus.AKTIV) {
			throw new StatusException();
		}

	}

	@Override
	public void sendEndGame(int reason) throws IOException, StatusException {
		if (this.status != ChessStatus.AKTIV) {
			throw new StatusException();
		}

	}

	@Override
	public void sendProposalEnd(int reason) throws IOException, StatusException {
		if (this.status != ChessStatus.AKTIV) {
			throw new StatusException();
		}

	}

	@Override
	public void sendProposalAnswer(boolean accept) throws IOException, StatusException {
		if (this.status != ChessStatus.ANTWORTEND) {
			throw new StatusException();
		}

	}

}
