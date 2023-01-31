package com.training.rest.Controller;

import com.training.rest.Model.test;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping ("/users")
 //Request Mapping - Global url for all method in class which is added before the method url.

public class UserController {
      //Path Param- For Searching particular Data
     //http://localhost:8080/users/user/Divya/22/uttrakhand
@GetMapping("/user/{name}/{age}/{location}")
public String printUserInfo(@PathVariable String name,
                            @PathVariable Long age,
                            @PathVariable String location) {
    return "My name is "+name+". I am "+age+" years old. I am living in "+location;
}
// ************************Request param***********************
      //QueryPAram- Its used to sort out data in particular Data
    // without creating a class
    //http://localhost:8080/users?page=1&limit=50
    @GetMapping
    public String getUsers (@RequestParam(value = "page") int page, @RequestParam (value = "limit") int limit)
    {
        return "page = " +page + " and limit = " +limit;
    }
    // http://localhost:8080/users/ex?userName= Divya
    @GetMapping("/ex")
    public String getName(@RequestParam(name = "userName") String name) {
        return "My name is "+name;
    }
    // for default value
     // http://localhost:8080/users/ex1
    @GetMapping("/ex1")
    public String getStudentName(@RequestParam(defaultValue = "ptaa nhi ") String name) {
        return "My name is "+name;
    }

    //creating a class with post method
     @PostMapping ("/test")
    public  String printUser(@RequestBody test tst)
     {
         System.out.println("printing the test object:"+tst);
         return ("success");

     }

    //@RequestParam  @QueryParam  @PathVariable  @PathParam @Request body
            // xxxxxxxxxxxxxx
    @GetMapping (path="/{UserId}")
    public String getUser (@PathVariable String UserId)
    {
        return "userid=" +UserId;
    }

    // // http://localhost:8080/users/ex2
    @GetMapping("/ex2")
    public String getstudentFirstName(@RequestParam(required = false) String name) {
        return "My name is "+name;
    }

}