package bni.co.id.ujian1.service;

import bni.co.id.ujian1.entity.AbsBaseEntity;
import bni.co.id.ujian1.util.GeneralFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbsService {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected GeneralFacility generalFacility;

    public AbsService() {
    }
}
