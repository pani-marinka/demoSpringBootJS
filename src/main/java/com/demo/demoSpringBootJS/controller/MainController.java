package com.demo.demoSpringBootJS.controller;

import com.demo.demoSpringBootJS.model.ScriptInfo;
import com.demo.demoSpringBootJS.service.ServiceMapJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scripts/")
public class MainController {

/*
fetch('/api/order/1', {method:'DELETE'}).then(result=>console.log(result))
for Scratch:
DELETE http://localhost:8080/api/order/1
 */

    @Autowired
    private ServiceMapJS serviceMapJS;


    /*
    Метод возвращает ResponseEntity<?>. ResponseEntity — специальный класс для возврата ответов.
    С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
    После чего возвращаем статус 201 Created, создав новый объект ResponseEntity
    и передав в него нужное значение енума HttpStatus.
     */
    @PostMapping
    public ResponseEntity<?> createScript(@RequestBody ScriptInfo scriptInfo) {
        if (scriptInfo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        serviceMapJS.create(scriptInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity runScriptStatus(@PathVariable int id) { //Get script status - finished or still running or other...
        if (id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.serviceMapJS.readStatus(id), HttpStatus.OK);

    }

    @DeleteMapping(value="{id}")
    public ResponseEntity deleteScript(@PathVariable("id") Integer id) { //Remove script run information
        if (id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (this.serviceMapJS.delete(id)) {
            return new ResponseEntity<>( "DELETE",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    /*
    runScriptStatus - если это GET - то у него нет body - надо PathVariable:
     @GetMapping("/{id}")
     @ResponseBody
     public ResponseEntity runScriptStatus(@PathVariable int id)

2. public ResponseEntity<?> createScript(@RequestBody ScriptInfo scriptInfo)
     Тебе будет приходить не JSON - а просто текст скрипта. Этот объект тебе самой надо создать.
     */

    /*
    POST http://localhost:8080/api/scripts/run_async
Accept: application/json
Content-Type: text/plain

console.log("Hello World");
---------
Response (JSON):
{
   id:1,
   status: 'scheduled'
}


Начинать надо с простого - тебе надо сделать простой RestService с несколькими методами:
1. Run Script
   1.1 accepts the POST request with script text and parameter (sync/async)
   1.2 runs the script or schedules it's run
2. Get script status - finished or still running
3. Get script result if finished
4. Remove script run information
     */


}
