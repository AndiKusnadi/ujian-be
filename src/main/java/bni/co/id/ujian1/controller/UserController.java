package bni.co.id.ujian1.controller;


import bni.co.id.ujian1.entity.MUser;
import bni.co.id.ujian1.service.UserService;
import bni.co.id.ujian1.vo.ResponseVO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public ResponseEntity<ResponseVO<List<MUser>>> getUsers(){
        List<MUser> users = this.userService.getUsers();
        ResponseVO<List<MUser>> response = new ResponseVO<>();
        response.setData(users);
        return ResponseEntity.ok(response);
    }

    @GetMapping("add/{pUser}")
    public ResponseEntity<ResponseVO> addUser(@PathVariable() String pUser){
        MUser user = new MUser();
        user.setFullName(pUser);
        return ResponseEntity.ok(this.userService.saveUser(user));

    }

}
