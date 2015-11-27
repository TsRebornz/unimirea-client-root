package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.hibernate.Session;
import org.tandemframework.core.debug.Debug;
import org.tandemframework.shared.commonbase.dao.SharedBaseDao;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uni.util.UniStringUtils;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ocean on 09.11.2015.
 */
public class EntParticipationDAO extends SharedBaseDao implements IEntParticipationDAO
{
    @Override
    public EntertainmentPrtcption saveOrUpdateEntParticipation(EntertainmentTypeUnit entUnit, EmployeePost employeePost, boolean overseer)
    {
        //doGetEduLvl4Asp(EduProgramSubject subject, EduProgramSpecialization specialization, boolean create)
            Session session = this.lock("eduLvl.sync." + entUnit.getId());
            EntertainmentPrtcption result = null;
                result = new EntertainmentPrtcption();
                result.setUnit(entUnit);
                result.setType(employeePost);
                result.setOverseer(overseer);

                session.saveOrUpdate(result);
                Debug.end();
                return result;
    }
}
