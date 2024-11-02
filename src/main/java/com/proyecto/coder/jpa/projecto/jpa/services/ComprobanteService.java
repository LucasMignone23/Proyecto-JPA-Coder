package com.proyecto.coder.jpa.projecto.jpa.services;

import com.proyecto.coder.jpa.projecto.jpa.dto.ComprobanteRequestDTO;
import com.proyecto.coder.jpa.projecto.jpa.dto.ComprobanteResponseDTO;
import com.proyecto.coder.jpa.projecto.jpa.exception.ProductoNoEncontradoException;
import com.proyecto.coder.jpa.projecto.jpa.model.Cliente;
import com.proyecto.coder.jpa.projecto.jpa.model.Comprobante;
import com.proyecto.coder.jpa.projecto.jpa.model.Producto;
import com.proyecto.coder.jpa.projecto.jpa.repository.ClienteRepository;
import com.proyecto.coder.jpa.projecto.jpa.repository.ComprobanteRepository;
import com.proyecto.coder.jpa.projecto.jpa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComprobanteService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public ComprobanteResponseDTO crearComprobante(ComprobanteRequestDTO request) {
        ComprobanteResponseDTO response = new ComprobanteResponseDTO();
        double totalVenta = 0;
        int cantidadTotalProductos = 0;

        try {
            // Buscar el cliente y verificar su existencia
            Cliente cliente = clienteRepository.findById(request.getCliente().getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + request.getCliente().getClienteId()));

            // Validar y procesar cada línea del comprobante
            for (var linea : request.getLineas()) {
                Producto producto = productoRepository.findById(linea.getProducto().getProductoId())
                        .orElseThrow(() -> new ProductoNoEncontradoException(linea.getProducto().getProductoId()));

                if (producto.getCantidad() < linea.getCantidad()) {
                    response.setMensajeError("Stock insuficiente para el producto: " + producto.getNombre());
                    return response;
                }

                producto.setCantidad(producto.getCantidad() - linea.getCantidad());
                productoRepository.save(producto);

                totalVenta += producto.getPrecio() * linea.getCantidad();
                cantidadTotalProductos += linea.getCantidad();
            }

            // Crear y guardar el comprobante
            Comprobante comprobante = new Comprobante();
            comprobante.setCliente(cliente);
            comprobante.setTotalVenta(totalVenta);
            comprobante.setFecha(obtenerFechaActual()); // Cambiado a Date
            comprobanteRepository.save(comprobante);

            // Configurar la respuesta
            response.setTotalVenta(totalVenta);
            response.setCantidadProductos(cantidadTotalProductos);
            response.setFecha(obtenerFechaActual()); // Cambiado a Date

        } catch (Exception e) {
            response.setMensajeError("Error en la creación del comprobante: " + e.getMessage());
        }
        return response;
    }

    public List<ComprobanteResponseDTO> obtenerTodosLosComprobantes() {
        return comprobanteRepository.findAll().stream()
                .map(comprobante -> {
                    ComprobanteResponseDTO responseDTO = new ComprobanteResponseDTO();
                    responseDTO.setTotalVenta(comprobante.getTotalVenta());
                    responseDTO.setCantidadProductos(comprobante.getCantidadTotalProductos());
                    responseDTO.setFecha(comprobante.getFecha());
                    // Si tienes un mensaje de error, lo puedes establecer aquí si es necesario
                    return responseDTO;
                })
                .collect(Collectors.toList());
    }

    private Date obtenerFechaActual() {
        Date fecha;
        try {
            var respuesta = restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", String.class);
            fecha = extraerFechaDeRespuesta(respuesta);
        } catch (Exception e) {
            fecha = new Date(); // Si hay un error, usar la fecha actual.
        }
        return fecha;
    }

    private Date extraerFechaDeRespuesta(String respuesta) {
        // Aquí se asume que la respuesta JSON contiene un campo "currentDateTime"
        String dateTimeString = ""; // Aquí deberías extraer el string de la respuesta JSON
        // Ejemplo simple, necesitarás parsear el JSON para obtener el campo correcto
        // Por simplicidad, se deja un valor fijo. Debes implementar la lógica correcta.
        
        // Para ilustrar, suponemos que dateTimeString es la fecha en formato ISO 8601
        dateTimeString = "2024-11-02T12:00:00Z"; // Reemplaza esto con la lógica de extracción

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Ajusta según sea necesario
        try {
            return formatter.parse(dateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(); // Retornar la fecha actual si hay un error
        }
    }
}
