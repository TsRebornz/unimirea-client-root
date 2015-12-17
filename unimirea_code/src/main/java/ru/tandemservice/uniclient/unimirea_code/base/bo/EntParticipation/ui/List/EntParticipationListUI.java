package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.List;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.logic.EntParticipationDSHandler;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.AddEdit.EntParticipationAddEdit;

/**
 * Created by ocean on 14.10.2015.
 */
public class EntParticipationListUI extends UIPresenter
{
    public static final String ENT_UNIT = "entUnit";
    public static final String WITH_SUCCESS_DS = "withSuccessDS";
    public static final String ORG_UNIT_DS = "orgUnitDS";
    public static final String PROGRAM_SUBJECT_DS = "programSubjectDS";


//    EntertainmentTypeUnit entTypeUnit = context.get(TYPEUNIT);
//
//    String lastName = context.get(LAST_NAME);
//    String firstName = context.get(FIRST_NAME);
//    String midName = context.get(MID_NAME);
//    LAST_NAME, FIRST_NAME, MID_NAME,TYPEUNIT

    @Override
    public void onComponentRefresh()
    {
        super.onComponentRefresh();
    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource)
    {
        if(dataSource.getName().equals(EntParticipationList.SELECT_ENT_DS)){
            super.onBeforeDataSourceFetch(dataSource);
            dataSource.putAll(getSettings().getAsMap(EntParticipationDSHandler.LAST_NAME, EntParticipationDSHandler.FIRST_NAME, EntParticipationDSHandler.MID_NAME, EntParticipationDSHandler.TYPEUNIT));
        }
    }

    public void onClickAddEntParticipation() throws Throwable {
        _uiActivation.asDialog(EntParticipationAddEdit.class).activate();
    }
}
