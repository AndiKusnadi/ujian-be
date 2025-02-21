package bni.co.id.ujian1.controller;

import bni.co.id.ujian1.service.AccountService;
import bni.co.id.ujian1.vo.AccountUserVO;
import bni.co.id.ujian1.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("calculate")
    public ResponseEntity<ResponseVO<List<AccountUserVO>>> calculateBalance() {
        ResponseVO<List<AccountUserVO>> result = new ResponseVO<>();
        result = this.accountService.calculate();

        return ResponseEntity.ok(result);
    }

    @GetMapping("sum/{pUser}")
    public ResponseEntity<ResponseVO<AccountUserVO>> sumBalance(@PathVariable() String pUser) {
        ResponseVO<AccountUserVO> result = new ResponseVO<>();
        result = this.accountService.sumUser(pUser);
        return ResponseEntity.ok(result);
    }
}
