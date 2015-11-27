package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentList;

import org.tandemframework.core.view.list.source.DynamicListDataSource;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 13.10.2015.
 */
public class Model
{
    public DynamicListDataSource<EntertainmentTypeUnit> _dataSource;

    public DynamicListDataSource<EntertainmentTypeUnit> getDataSource()
    {
        return _dataSource;
    }

    public void setDataSource(DynamicListDataSource<EntertainmentTypeUnit> dataSource)
    {
        _dataSource = dataSource;
    }
}
