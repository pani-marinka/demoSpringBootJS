package com.demo.demoSpringBootJS.controller;

import com.demo.demoSpringBootJS.model.ScriptInfo;
import com.demo.demoSpringBootJS.service.ServiceMapJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
