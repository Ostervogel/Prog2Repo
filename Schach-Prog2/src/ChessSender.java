import java.io.IOException;

public interface ChessSender {

	/**
	 * Erlaubt im Zustand starte Spiel. Führt zu : größere Zahl -> Farbe wählen
	 * kleinere Zahl -> warte auf Farbe
	 * 
	 * Sendet eine zufällige Zahl. Spieler mit der höheren Zahl beginnt das Spiel.
	 * Zahl von 1-100. Bei gleicher Zahl wird wiederholt.
	 * 
	 * @param number
	 * @throws IOException
	 * @throws StatusException
	 */
	void sendDice(int number) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand Farbe Wählen. Führt zu: true -> aktiv false -> passiv
	 * Wählt die Farbe und somit die Seite des Spielfeldes und wer beginnt. true =
	 * white false = black
	 * 
	 * @param white
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendChoosenColor(boolean white) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand aktiv. Führt zu passiv. Setzt die Figur von der
	 * Ausgangsposition auf die Zielposition.
	 * 
	 * @param from
	 * @param to
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendMove(int from, int to) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand aktiv. Führt zu passiv. Setzt den Bauer von der
	 * Ausgangsposition auf die Zielposition und gibt den gewünschten Figurentyp für
	 * die Umwandlung an. 1 = Dame 2 = Turm 3 = Springer 4 = Läufer
	 * 
	 * @param from
	 * @param figureType
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendMovePawnRule(int from, int figureType) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand aktiv. Führt zu passiv. Führt eine Rochade mit dem Turm
	 * auf der angegebenen Position durch.
	 * 
	 * @param from
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendRochade(int from) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand aktiv. Führt zu zum Zustand beendet. Beendet das Spiel und
	 * schickt sendet den Grund dafür. 0 = checkmate 1 = stalemate 2 = abandon
	 * 
	 * @param reason
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendEndGame(int reason) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand aktiv. Führt zu zum Zustand wartend. Spieler schlägt vor
	 * das Spiel zu beenden. 0 = draw 1 = end game
	 * 
	 * @param reason
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendProposalEnd(int reason) throws IOException, StatusException;

	/**
	 * Erlaubt im Zustand wartend. Führt zu zum Zustand true -> beendet false ->
	 * passiv. Spieler antwortet auf die Anfrage das Spiel zu beenden.
	 * 
	 * @param accept
	 * @throws IOException
	 * @throws StatusException
	 */

	void sendProposalAnswer(boolean accept) throws IOException, StatusException;
}
