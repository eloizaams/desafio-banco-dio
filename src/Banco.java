import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private List<Conta> lc;

	
	
	public Banco(String nome) {
		this.nome = nome;
		this.lc = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getLc() {
		return lc;
	}

	public void criarContaCorrente(Cliente cliente) {
		Conta conta = new ContaCorrente(cliente);
		lc.add((Conta) conta);
	}
	
	public void criarContaPoupanca(Cliente cliente) {
		Conta conta = new ContaPoupanca(cliente);
		lc.add((Conta) conta);
	}
	
	public Conta obterConta(int agencia, int numero) {
		return lc.stream()
		.filter(n -> n.getAgencia() == agencia && n.getNumero() == numero)
		.findFirst()
		.orElseGet(null);
		
	}
}
