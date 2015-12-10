package ru.tandemservice.uniclient.unimirea_code.entity;

import org.tandemframework.core.entity.dsl.EntityDSLSupport;
import ru.tandemservice.uniclient.unimirea_code.entity.gen.EntertainmentPrtcptionGen;

/** @see ru.tandemservice.uniclient.unimirea_code.entity.gen.EntertainmentPrtcptionGen */
public class EntertainmentPrtcption extends EntertainmentPrtcptionGen
{
    public static final String P_FULL_ENTERTAINMENT_NAME = "fullEntertainmentName";
    @EntityDSLSupport
    public String getFullEntertainmentName(){
        EntertainmentTypeUnit unit = this.getUnit();
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(unit.getTitile()).append(" (").append(unit.getType().getTitle()).append(") ").append(unit.getPeriod());
        return strBuilder.toString();
    }

    @EntityDSLSupport
    public String getOverseerAsString(){
        String yes = "Да";
        String no = "Нет";
        return this.isOverseer() ? yes : no;
    }
}