package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic;

import org.tandemframework.caf.command.io.DSInput;
import org.tandemframework.caf.command.io.DSOutput;
import org.tandemframework.caf.logic.ExecutionContext;
import org.tandemframework.caf.logic.datasource.output.DQLSelectOutputBuilder;
import org.tandemframework.caf.logic.handler.AbstractSearchDataSourceHandler;
import org.tandemframework.caf.logic.handler.DefaultSearchDataSourceHandler;
import org.tandemframework.core.entity.OrderDirection;
import org.tandemframework.hibsupport.dql.*;
import ru.tandemservice.uni.util.FilterUtils;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 15.10.2015.
 */
public class EntParticipationDSHandler extends DefaultSearchDataSourceHandler
{
    public static final String TITLE = "title";
    public static final String PARTICIPANT = "employeePost";
    public static final String OVERSEER = "overseer";
    public static final String TYPEUNIT = "entertainmentTypeUnit";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String MID_NAME = "midName";
    public static final String SELECTENTDS = "selectEntDS";


    public EntParticipationDSHandler(String ownerId){
        super(ownerId);
    }

    // Это хэндлер для списка
    //TODO handler для searchList, для списка внеучебных мероприятий(KOMBO-VOMBO Select)
    //TODO в конфигурации зарегистрировать DS в extPoint builder (done)
    //TODO Прописать зависимости в html template (done)
    //TODO Прописать ссылку в меню (done)

    protected DSOutput execute(DSInput input, ExecutionContext context) {

        EntertainmentTypeUnit entTypeUnit = context.get(TYPEUNIT);

        String lastName = context.get(LAST_NAME);
        String firstName = context.get(FIRST_NAME);
        String midName = context.get(MID_NAME);

        DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EntertainmentPrtcption.class, "e");
        dql.column(DQLExpressions.property("e"));

        FilterUtils.applySelectFilter(dql, "e", EntertainmentPrtcption.unit() , entTypeUnit);

        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().firstName() , firstName );
        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().middleName() , midName  );
        FilterUtils.applySimpleLikeFilter(dql, "e", EntertainmentPrtcption.type().employee().person().identityCard().lastName() , lastName );

        dql.order(DQLExpressions.property("e", input.getEntityOrder().getKeyString()), OrderDirection.valueOf(input.getEntityOrder().getDirection().name()));

        //DQLSelectBuilder крутится, данные мутятся
        DSOutput output = DQLSelectOutputBuilder.get(input, dql, this.getSession()).pageable(true).build();


        return output;
    }
}
