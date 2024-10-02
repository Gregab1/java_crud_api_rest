package com.gabyrest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabyrest.apirest.Entities.Producto;
import com.gabyrest.apirest.Repositories.IproductoRepositorie;

@RestController
@RequestMapping("/producto")
public class ProductoController {
@Autowired
private IproductoRepositorie productoRepositorie;
@GetMapping
public List<Producto>getAllProductos(){
    return productoRepositorie.findAll();  
}
@GetMapping("/{id}")
public Producto obetenerProductBi(@PathVariable Long id){
return productoRepositorie.findById(id)
.orElseThrow(()-> new RuntimeException("no se encontro el producto "+id));
}

@PostMapping
public Producto crateProducto(@RequestBody Producto producto){
    return productoRepositorie.save(producto);

}
@PutMapping("/{id}")
public Producto updateProdcto(@PathVariable Long id,@RequestBody Producto detalle){
Producto producto= productoRepositorie.findById(id)
.orElseThrow(()-> new RuntimeException("no se encontro el producto "+id));
producto.setNombre(detalle.getNombre());
producto.setPrecio(detalle.getPrecio());
return productoRepositorie.save(producto);
}
@DeleteMapping("/{id}")
public String deleteproduc(@PathVariable Long id){
    Producto producto= productoRepositorie.findById(id)
    .orElseThrow(()-> new RuntimeException("no se encontro el producto "+id));
    productoRepositorie.delete(producto);
    return "el producot con el id; "+id+" a sido elimando";
}
}
