package bni.co.id.ujian1.repository;

import bni.co.id.ujian1.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MUserRepository extends JpaRepository<MUser, Long> {
    @Query("select data from MUser data where data.fullName = :pName")
    public MUser getUserByName(String pName);
}
