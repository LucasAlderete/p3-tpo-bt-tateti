package tpo;

public interface TatetiTDA {
	public void Inicializar();
	public TurnoJugador Turno(TurnoJugador turno);
	public boolean Jugar(int posicionJugada);
	public void setCont();
	public int getCont();
}
