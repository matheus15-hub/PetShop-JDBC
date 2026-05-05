package Menu;

import Servicos.Animalser;
import Servicos.Clienteser;
import Servicos.Consultaser;
import Servicos.Medicoser;
import entidades.Animal;
import entidades.Cliente;
import entidades.Consulta;
import entidades.Medico;

public class MenuExibir {

    public void animalMs(Animal animal){ new Animalser().listarAnimais(animal); }
    
    public void clienteMs(Cliente cliente){new Clienteser().listarClientes(); }
    
    public void consultaMs(Consulta consulta){new Consultaser().listarConsultas(); }
    
    public void medicoMs(Medico medico){new Medicoser().listarMedico();}
}
