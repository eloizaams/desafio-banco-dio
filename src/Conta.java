import java.util.Objects;

public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	private Cliente cliente;
	private int agencia;
	private int numero;
	private double saldo;

	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0.0;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("\nCliente: %s\nAgência: %d\nNúmero:%d\nSaldo: R$ %,.2f", getCliente().getNome(), getAgencia(), getNumero(), getSaldo()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Conta))
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && numero == other.numero;
	}
	
	
}
