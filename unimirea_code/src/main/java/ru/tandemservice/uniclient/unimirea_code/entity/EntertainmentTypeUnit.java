package ru.tandemservice.uniclient.unimirea_code.entity;

import org.tandemframework.core.entity.dsl.EntityDSLSupport;
import org.tandemframework.core.view.formatter.DateFormatter;
import ru.tandemservice.uniclient.unimirea_code.entity.gen.*;

/** @see ru.tandemservice.uniclient.unimirea_code.entity.gen.EntertainmentTypeUnitGen */
public class EntertainmentTypeUnit extends EntertainmentTypeUnitGen
{
    public static final String P_PERIOD = "period";
    @EntityDSLSupport
    public String getPeriod(){
        return DateFormatter.DEFAULT_DATE_FORMATTER.format(this.getDateBegin()) + (null != DateFormatter.DEFAULT_DATE_FORMATTER.format(getDateEnd()) ? (" - " + DateFormatter.DEFAULT_DATE_FORMATTER.format(getDateEnd())) : "" ) ;
    }
}