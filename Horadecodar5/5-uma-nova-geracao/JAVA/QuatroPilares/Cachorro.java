package QuatroPilares;

public class Cachorro extends Bicho {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Au au!";
    }

    @Override
    public void habilidadeEspecial() {
        alterarFelicidade(20);
        alterarCansaco(10);
        System.out.println(getNome() + " correu para buscar a bolinha no parque!");
    }
}