package ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.ui.Print;

import org.tandemframework.caf.ui.UIPresenter;
import org.tandemframework.caf.ui.datasource.IUIDataSource;
import org.tandemframework.core.component.BusinessComponentUtils;
import org.tandemframework.shared.commonbase.base.util.CommonBaseRenderer;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationManager;
import ru.tandemservice.uniclient.unimirea_code.base.bo.EntParticipation.EntParticipationRtfReport;

/**
 * Created by ocean on 12.11.2015.
 */
public class EntParticipationPrintUI extends UIPresenter
{


    @Override
    public void onComponentRefresh()
    {
        EntParticipationRtfReport report = EntParticipationManager.instance()._entParticipationRtfReport();
           BusinessComponentUtils.downloadDocument(new CommonBaseRenderer().rtf().fileName("EntParticipationList.rtf").document(report.initRtfDocument()), true);
        super.onComponentRefresh();
    }

    @Override
    public void onBeforeDataSourceFetch(IUIDataSource dataSource)
    {

    }
}
