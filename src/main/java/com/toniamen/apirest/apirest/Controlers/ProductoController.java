package com.toniamen.apirest.apirest.Controlers;

import java.util.List;

import com.toniamen.apirest.apirest.Entities.Producto;
import com.toniamen.apirest.apirest.Repositories.ProductorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/productos")
public class ProductoController {

    //Inyectar una instancia en el repositorio.
    @Autowired
    private ProductorRepository productorRepository;

    @GetMapping   
    public List<Producto> obtenerTodosLosProductos(){

        return productorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obteneProductoPorId(@PathVariable Long id){
        
        return productorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
    }
    
    

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){

        return  productorRepository.save(producto);
    }
    
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
        
        Producto producto = productorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productorRepository.save(producto);
    }
    
    @DeleteMapping("/{id}")
    public String borrarProductoPorId(@PathVariable Long id){

        Producto producto = productorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
        productorRepository.delete(producto);

        return "El producto con el id:" + id + "fue eliminado correctamente";
    }
}
