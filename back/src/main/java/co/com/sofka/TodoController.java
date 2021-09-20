package co.com.sofka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "localhost:3030")
public class TodoController {

    @Autowired
    private TodoService service;


    public Iterable <Todo> list (){
        return service.list();
    }

    @PostMapping (value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping (value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if (todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el ID para actualizar");

    }

    @DeleteMapping
    public void delete(@PathVariable ("id") Long id){
        service.delete(id);
    }

    @GetMapping (value = "api/todo")
    public Todo get (@PathVariable ("id") Long id){
        return service.get(id);
    }
}