package bni.co.id.ujian1.config;

import bni.co.id.ujian1.entity.MAccount;
import bni.co.id.ujian1.entity.MUser;
import bni.co.id.ujian1.service.AccountService;
import bni.co.id.ujian1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class DataInitializer {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("*** >> Initialize data << ***");
        this.createUser();
        this.createAccount();
        log.info("*** >> End of initialize data << ***");
    }

    private void createUser() {
        MUser user = new MUser();
        user.setFullName("Andi Kusnadi");
        this.userService.saveUser(user);

        user = new MUser();
        user.setFullName("Nikko Kusnadi");
        this.userService.saveUser(user);

        user = new MUser();
        user.setFullName("Kundil");
        this.userService.saveUser(user);
    }

    private void createAccount() {
        List<MUser> users = this.userService.getUsers();
        List<MAccount> accounts = new ArrayList<>();

        if (this.accountService.getAccounts().size() < 5) {
            users.forEach(userData -> {
                MAccount account = new MAccount();
                account.setBalance(12300d);
                account.setUserId(userData);
                accounts.add(account);
            });

            if (!accounts.isEmpty()) {
                this.accountService.saveAccount(accounts);
            }
        }
    }
}
