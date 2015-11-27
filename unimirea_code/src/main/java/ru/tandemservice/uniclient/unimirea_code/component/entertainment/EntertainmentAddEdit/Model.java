package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit;

import org.tandemframework.core.component.Input;
import org.tandemframework.tapsupport.component.selection.ISelectModel;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 13.10.2015.
 */

@Input (keys = "entertainmentTypeId", bindings = "id")
public class Model
{
    private ISelectModel _entList;

    private EntertainmentTypeUnit _entTypeUnit;

    private Long _id;

    private Boolean _editForm;

    public ISelectModel getEntList()
    {
        return _entList;
    }

    public void setEntList(ISelectModel entList)
    {
        _entList = entList;
    }

    public EntertainmentTypeUnit getEntTypeUnit()
    {
        return _entTypeUnit;
    }

    public void setEntTypeUnit(EntertainmentTypeUnit entTypeUnit)
    {
        _entTypeUnit = entTypeUnit;
    }

    public Long getId()
    {
        return _id;
    }

    public void setId(Long id)
    {
        _id = id;
    }

    public Boolean getEditForm()
    {
        return _editForm;
    }

    public void setEditForm(Boolean editForm)
    {
        _editForm = editForm;
    }
}
