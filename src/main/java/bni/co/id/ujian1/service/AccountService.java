package bni.co.id.ujian1.service;

import bni.co.id.ujian1.constanta.FrameworkConstanta;
import bni.co.id.ujian1.entity.MAccount;
import bni.co.id.ujian1.entity.MUser;
import bni.co.id.ujian1.repository.MAccountRepository;
import bni.co.id.ujian1.repository.MUserRepository;
import bni.co.id.ujian1.vo.AccountUserVO;
import bni.co.id.ujian1.vo.ResponseVO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AccountService extends AbsService {
    @Autowired
    private MAccountRepository acountRepository;

    @Autowired
    private MUserRepository userRepository;

    @Transactional
    public ResponseVO saveAccount(List<MAccount> pValue) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatusCode(FrameworkConstanta.SUCCESS);
        try {
            this.acountRepository.saveAll(pValue);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseVO.setStatusCode(FrameworkConstanta.ERROR);
            responseVO.setStatusMessage(ex.getMessage());
            log.error("Error ", ex);
            return responseVO;
        }
        return responseVO;
    }

    public ResponseVO<List<AccountUserVO>> calculate() {
        List<MUser> users = this.userRepository.findAll();
        List<AccountUserVO> accountUsers = new ArrayList<>();
        ResponseVO<List<AccountUserVO>> response = new ResponseVO<>();
        response.setStatusCode(FrameworkConstanta.SUCCESS);

        users.stream().forEach(userData -> {
            AccountUserVO accountUserVO = new AccountUserVO();
            accountUserVO.setFullName(userData.getFullName());

            Double balance = this.jdbcTemplate.queryForObject("select sum(balance) as jumlah from master_account_andi where user_id = :userId", new AccountBalance(), userData.getId());
            accountUserVO.setTotalAmount(balance);
            accountUsers.add(accountUserVO);
        });

        response.setData(accountUsers);
        return response;
    }

    private static class AccountBalance implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
            Double result = 0d;
            result = rs.getDouble("jumlah");
            return result;
        }
    }

    public List<MAccount> getAccounts() {
        return this.acountRepository.findAll();
    }

}
