package QuatroPilares;

public class Gato extends Bicho {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Miau!";
    }

    @Override
    public void habilidadeEspecial() {
        alterarFelicidade(18);
        alterarCansaco(5);
        System.out.println(getNome() + " subiu no arranhador com elegância.");
    }
}