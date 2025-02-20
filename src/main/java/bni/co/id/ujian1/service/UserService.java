package bni.co.id.ujian1.service;

import bni.co.id.ujian1.constanta.FrameworkConstanta;
import bni.co.id.ujian1.entity.MUser;
import bni.co.id.ujian1.repository.MAccountRepository;
import bni.co.id.ujian1.repository.MUserRepository;
import bni.co.id.ujian1.vo.ResponseVO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService extends AbsService {
    @Autowired
    private MUserRepository userRepository;

    /**
     * Validate user berdasarkan fullName, jika sudah ada akan di lewatin.
     *
     * @param pValue
     * @return
     */
    @Transactional
    public ResponseVO saveUser(MUser pValue) {
        ResponseVO responseVO = new ResponseVO();

        responseVO.setStatusCode(FrameworkConstanta.SUCCESS);
        //make sure user tidak ada.
        MUser user = this.userRepository.getUserByName(pValue.getFullName());
        if (user == null) {
            log.info("Ready to insert user");
            try {
                this.userRepository.save(pValue);
            } catch (Exception ex) {
                ex.printStackTrace();
                responseVO.setStatusCode(FrameworkConstanta.ERROR);
                responseVO.setStatusMessage(ex.getMessage());
                log.error("error insert ", ex);
                return responseVO;
            }
            log.info("Success Insertuser");
        } else {
            responseVO.setStatusCode(FrameworkConstanta.ERROR);
            responseVO.setStatusMessage("Data Already Exists");
            log.info("Failure insert to user");
        }
        return responseVO;
    }

    public List<MUser> getUsers() {
        return this.userRepository.findAll();
    }

}
