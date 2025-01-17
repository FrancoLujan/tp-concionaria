package com.example.pruebas.services.implementations;

import com.example.pruebas.dtos.EmpleadoDTO;
import com.example.pruebas.dtos.PruebaDTO;
import com.example.pruebas.dtos.detallesDto.DetalleEmpleadoDTO;
import com.example.pruebas.dtos.gestorDTOS.GestorDTOS;
import com.example.pruebas.models.Empleado;
import com.example.pruebas.services.interfaces.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpleadoServiceImpl extends ServiceImpl<Empleado, Integer> implements EmpleadoService {

    private final GestorDTOS gestorDTOS;

    public EmpleadoServiceImpl(GestorDTOS gestorDTOS) {
        this.gestorDTOS = gestorDTOS;
    }

    @Override
    public void add(Empleado empleado) {
        this.gestorDTOS.getEmpleadoRepository().save(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        gestorDTOS.getEmpleadoRepository().save(empleado);
    }

    @Override
    public void delete(Integer id) {
        gestorDTOS.getEmpleadoRepository().deleteById(id);
    }

    @Override
    public Empleado findById(Integer id) {

        return gestorDTOS.getEmpleadoRepository().findById(id).orElseThrow();
    }

    @Override
    public List<Empleado> findAll()
    {
        return gestorDTOS.getEmpleadoRepository().findAll();
    }

  public List<DetalleEmpleadoDTO> empleadosAll(){
        log.info("Listando detalles de todos los empleados");
        List<Empleado> empleados = this.findAll();
        return empleados.stream().map(e -> {
            DetalleEmpleadoDTO detalleEmpleadoDTO = new DetalleEmpleadoDTO();
            List<PruebaDTO> pruebaDTOS = gestorDTOS.listarPruebas(e);

            detalleEmpleadoDTO.setEmpleado(gestorDTOS.empleadoDTO(e));
            detalleEmpleadoDTO.setPruebas(pruebaDTOS);
            return detalleEmpleadoDTO;
        }).toList();
  }
  public DetalleEmpleadoDTO obtenerDetalleEmpleado(int id) {
        log.info("Obteniendo detalles del empleado");
      Empleado empleado = findById(id);
      DetalleEmpleadoDTO detalleEmpleadoDTO = new DetalleEmpleadoDTO();
      EmpleadoDTO empleadoDTO = new EmpleadoDTO();
      List<PruebaDTO> pruebas = gestorDTOS.listarPruebas(empleado);

      empleadoDTO.setLegajo(empleado.getLegajo());
      empleadoDTO.setNombre(empleado.getNombre());
      empleadoDTO.setApellido(empleado.getApellido());
      empleadoDTO.setEmail(empleado.getEmail());

      detalleEmpleadoDTO.setEmpleado(empleadoDTO);
      detalleEmpleadoDTO.setPruebas(pruebas);

      return detalleEmpleadoDTO;
  }

  public void nuevoEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();

        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellido(empleadoDTO.getApellido());
        empleado.setEmail(empleadoDTO.getEmail());

        add(empleado);
  }
  public void eliminarEmpleado(int legajo){
        delete(legajo);
  }

  public void modificarEmpleado(int legajo, EmpleadoDTO empleadoDTO){
        Empleado empleado = findById(legajo);
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellido(empleadoDTO.getApellido());
        empleado.setEmail(empleadoDTO.getEmail());
        update(empleado);
  }
}
