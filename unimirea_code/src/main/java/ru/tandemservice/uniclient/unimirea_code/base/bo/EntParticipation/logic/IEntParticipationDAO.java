package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.tandemframework.shared.commonbase.dao.ISharedBaseDao;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uni.entity.education.StudentCustomState;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 09.11.2015.
 */
public interface IEntParticipationDAO extends ISharedBaseDao
{
    EntertainmentPrtcption saveOrUpdateEntParticipation(EntertainmentTypeUnit entUnit,EmployeePost employeePost  , boolean overseer );
}
