package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit;

import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.shared.commonbase.base.util.LazySimpleSelectModel;
import ru.tandemservice.uni.dao.UniBaseDao;
import ru.tandemservice.uni.dao.UniDao;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType;



/**
 * Created by ocean on 13.10.2015.
 */
public class DAO extends UniDao<Model> implements IDAO
{
    @Override
    public void prepare(Model model)
    {
        model.setEntList(new LazySimpleSelectModel<>(EntertainmentType.class, EntertainmentType.P_TITLE).setSortProperty(EntertainmentType.P_TITLE));
        if (model.getId() != null) {
            model.setEntTypeUnit(get(EntertainmentTypeUnit.class, model.getId() ));
        }
        else {
            model.setEntTypeUnit(new EntertainmentTypeUnit());
        }
        DQLSelectBuilder builder = new DQLSelectBuilder();
    }

    @Override
    public void update(Model model)
    {
        getSession().saveOrUpdate(model.getEntTypeUnit());
    }
}
