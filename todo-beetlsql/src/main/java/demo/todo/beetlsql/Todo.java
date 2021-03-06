package demo.todo.beetlsql;

import act.Act;
import org.osgl.http.H;
import org.osgl.mvc.annotation.*;

import javax.inject.Inject;

import static act.controller.Controller.Util.notFoundIfNull;

/**
 * A Simple Todo application controller
 */
@SuppressWarnings("unused")
public class Todo {

    @Inject
    private TodoItem.Mapper mapper;

    @GetAction
    public void home() {}

    @GetAction("/list")
    public Iterable<TodoItem> list(String q) {
    		// mapper.all();
        return mapper.all();
    }

    @PostAction("/list")
    public void post(String desc) {
        TodoItem item = new TodoItem();
        item.setDesc(desc);
        mapper.insert(item);
    }

    @DeleteAction("/list/{id}")
    public void delete(long id) {
        TodoItem item = mapper.single(id);
        mapper.deleteById(id);
    }

    @PutAction("/list/{id}")
    public void update(long id, String desc) {
        TodoItem item = mapper.single(id);
        notFoundIfNull(item);
        item.setDesc(desc);
        mapper.updateById(item);
    }

    @PostAction("/create")
    @ResponseContentType(H.MediaType.JSON)
    public TodoItem testCreate(TodoItem todo) {
        return todo;
    }

    @GetAction("/list/{id}")
    public TodoItem showItem(long id) {
        TodoItem item = mapper.single(id);
        notFoundIfNull(item);
        return item;
    }
    

    
    public static void main(String[] args) throws Exception {
        Act.start("TODO-BeetlSql");
    }


}
