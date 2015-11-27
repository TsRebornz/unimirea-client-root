package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentPub;

import org.tandemframework.core.component.PublisherActivator;
import org.tandemframework.core.component.State;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 14.10.2015.
 */
@State (keys = PublisherActivator.PUBLISHER_ID_KEY, bindings = "id")
public class Model
{
    private EntertainmentTypeUnit _unit;
    private Long _id;

    public EntertainmentTypeUnit getUnit()
    {
        return _unit;
    }

    public void setUnit(EntertainmentTypeUnit unit)
    {
        _unit = unit;
    }

    public Long getId()
    {
        return _id;
    }

    public void setId(Long id)
    {
        _id = id;
    }
}
