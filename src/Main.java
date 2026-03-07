import com.cauahmachado.petadoptionsystem.service.FormularioService;
import com.cauahmachado.petadoptionsystem.ui.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FormularioService formularioService = new FormularioService();
        Menu menu = new Menu();
       // formularioService.exibirFormulario();
        menu.exibirMenu();
    }
}