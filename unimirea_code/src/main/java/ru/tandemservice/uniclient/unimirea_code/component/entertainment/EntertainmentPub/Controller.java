package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentPub;

import org.tandemframework.core.component.IBusinessComponent;
import org.tandemframework.core.component.impl.AbstractBusinessController;

/**
 * Created by ocean on 14.10.2015.
 */
public class Controller extends AbstractBusinessController<IDAO,Model>
{
    @Override
    public void onRefreshComponent(IBusinessComponent iBusinessComponent)
    {
        getDao().prepare(getModel(iBusinessComponent));
        //
    }

}
