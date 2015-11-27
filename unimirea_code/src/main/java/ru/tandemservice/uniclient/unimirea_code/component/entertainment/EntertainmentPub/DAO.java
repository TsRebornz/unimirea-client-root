package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentPub;

import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import ru.tandemservice.uni.dao.UniDao;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

/**
 * Created by ocean on 14.10.2015.
 */
public class DAO extends UniDao<Model> implements IDAO
{
    @Override
    public void prepare(Model model)
    {
        model.setUnit(getNotNull(EntertainmentTypeUnit.class, model.getId() ));
    }
}
