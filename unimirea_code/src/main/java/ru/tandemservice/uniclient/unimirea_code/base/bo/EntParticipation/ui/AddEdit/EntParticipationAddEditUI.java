package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.core.component.Bind;
import org.tandemframework.core.component.Input;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.entity.EntityHolder;
import org.tandemframework.shared.commonbase.base.util.DQLFullCheckSelectModel;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import org.tandemframework.tapsupport.component.selection.ISelectModel;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import static org.tandemframework.hibsupport.dql.DQLExpressions.or;
import static org.tandemframework.hibsupport.dql.DQLExpressions.property;

/**
 * Created by ocean on 05.11.2015.
 */

@Input({
        @Bind(key = "programId", binding = "programHolder.id")
})
public class EntParticipationAddEditUI extends UIPresenter
{

    private EntityHolder<EntertainmentPrtcption> programHolder = new EntityHolder<>();
    private EntertainmentTypeUnit entTypeUnit;
    private EntertainmentPrtcption _entertainmentPrtcption;
    private EmployeePost participant;
    private boolean overseer;


    @Override
    public void onComponentRefresh()
    {
        getProgramHolder().refresh();

        if (getProgramHolder().getValue() instanceof EntertainmentPrtcption) {
            EntertainmentPrtcption entPart = (EntertainmentPrtcption) getProgramHolder().getValue();
            setEntertainmentPrtcption(entPart);
//            setSubject(prof.getProgramSubject());
//            getEduHs().setOrgUnit(prof.getOwnerOrgUnit().getOrgUnit());
//            getEduHs().setTitle(prof.getProgramSubject().getTitle());

        }
    }

    public void onClickApply()
    {
        EntertainmentTypeUnit entUnit = this.getEntTypeUnit();
        EmployeePost participant = this.getParticipant();
        boolean overseer = this.isOverseer();

        EntParticipationManager.instance()._entParticipationDAO().saveOrUpdateEntParticipation(entUnit,participant,overseer);
        deactivate();
    }

    private final ISelectModel entTypeUnitModel = new DQLFullCheckSelectModel(EntertainmentTypeUnit.titile())
    {
        @Override
        protected DQLSelectBuilder query(String alias, String filter)
        {
            DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EntertainmentTypeUnit.class, alias);
            if (null != filter)
            {
                dql.where(or(
                        like(EntertainmentTypeUnit.titile().fromAlias(alias), filter)
                ));
            }

            dql.order(property(EntertainmentTypeUnit.titile().fromAlias(alias)));
            return dql;
        }
    };

    private final ISelectModel participantModel = new DQLFullCheckSelectModel(EmployeePost.person().identityCard().fullFio())
    {
        @Override
        protected DQLSelectBuilder query(String alias, String filter)
        {
            DQLSelectBuilder dql = new DQLSelectBuilder().fromEntity(EmployeePost.class, alias);
            if (null != filter)
            {
                dql.where(or(
                        like(EmployeePost.person().identityCard().fullFio().fromAlias(alias), filter)
                ));
            }

            dql.order(property(EmployeePost.person().identityCard().fullFio().fromAlias(alias)));
            return dql;
        }
    };

    //geter and seters


    public boolean isOverseer()
    {
        return overseer;
    }

    public void setOverseer(boolean overseer)
    {
        this.overseer = overseer;
    }

    public EntertainmentPrtcption getEntertainmentPrtcption()
    {
        return _entertainmentPrtcption;
    }

    public void setEntertainmentPrtcption(EntertainmentPrtcption entertainmentPrtcption)
    {
        _entertainmentPrtcption = entertainmentPrtcption;
    }

    public EntityHolder<EntertainmentPrtcption> getProgramHolder()
    {
        return programHolder;
    }

    public EntertainmentTypeUnit getEntTypeUnit()
    {
        return entTypeUnit;
    }

    public void setEntTypeUnit(EntertainmentTypeUnit entTypeUnit)
    {
        this.entTypeUnit = entTypeUnit;
    }

    public ISelectModel getEntTypeUnitModel()
    {
        return this.entTypeUnitModel;
    }

    public EmployeePost getParticipant()
    {
        return participant;
    }

    public void setParticipant(EmployeePost participant)
    {
        this.participant = participant;
    }

    public ISelectModel getParticipantModel()
    {
        return participantModel;
    }

    // select models


}
