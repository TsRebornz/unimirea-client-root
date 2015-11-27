package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentList;

import org.tandemframework.core.component.ComponentActivator;
import org.tandemframework.core.component.IBusinessComponent;
import org.tandemframework.core.component.impl.AbstractBusinessController;
import org.tandemframework.core.util.ParametersMap;
import org.tandemframework.core.view.list.column.ActionColumn;
import org.tandemframework.core.view.list.column.SimpleColumn;
import org.tandemframework.core.view.list.source.DynamicListDataSource;
import org.tandemframework.core.view.list.source.IListDataSourceDelegate;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.dql.util.DQLSelectColumnNumerator;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;
import ru.tandemservice.uniplaces.UniplacesComponents;

import java.util.List;

/**
 * Created by ocean on 13.10.2015.
 */
public class Controller extends AbstractBusinessController<IDAO, Model>
{
    public void onClickAddEntertainment(IBusinessComponent component){
        component.createDefaultChildRegion(new ComponentActivator(ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit.Controller.class.getPackage().getName(), new ParametersMap().add("entertainmentTypeId", null)));
    }

    public void onClickDeleteEntertainment(IBusinessComponent component){
        getDao().delete((Long)component.getListenerParameter());
    }

    public void onClickEditEntertainment(IBusinessComponent component){
        component.createDefaultChildRegion(new ComponentActivator(ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentAddEdit.Controller.class.getPackage().getName(), new ParametersMap().add("entertainmentTypeId", component.getListenerParameter())));
    }

    @Override
    public void onRefreshComponent(IBusinessComponent iBusinessComponent)
    {
        getDao().prepare(getModel(iBusinessComponent));
        prepareDataSource(iBusinessComponent);
    }
    public void prepareDataSource(IBusinessComponent component){

        //Student.entranceYear()
        Integer year = 2015;

//        DQLSelectColumnNumerator studentDQL = new DQLSelectColumnNumerator( new DQLSelectBuilder().fromEntity(Student.class, "st").column(DQLExpressions.property("st")).where(DQLExpressions.eq(DQLExpressions.property(Student.entranceYear().fromAlias("st")), DQLExpressions.value(2015)) )) ;
//
//        List<Student> list = DataAccessServices.dao().getList(studentDQL.getDql());
//
//        System.out.println(list.get(0));


        final Model model = getModel(component);
        if (model.getDataSource() != null)
        {
            return;
        }

        DynamicListDataSource<EntertainmentTypeUnit> dataSource = new DynamicListDataSource<EntertainmentTypeUnit>(component, new IListDataSourceDelegate()
        {
            @Override
            public void updateListDataSource(IBusinessComponent component)
            {
                getDao().prepareListDataSource(model);
            }
        }, 30);

        dataSource.addColumn(new SimpleColumn("Наименование", EntertainmentTypeUnit.titile().s()));
        dataSource.addColumn(new SimpleColumn("Тип", EntertainmentTypeUnit.type().title().s()).setClickable(false).setOrderable(false));
        dataSource.addColumn(new SimpleColumn("Дата проведения", EntertainmentTypeUnit.period().s()).setClickable(false));
        dataSource.addColumn(new SimpleColumn("Описание", EntertainmentTypeUnit.description().s()).setClickable(false));
        dataSource.addColumn(new ActionColumn("Редактировать", ActionColumn.EDIT, "onClickEditEntertainment").setPermissionKey("entertainmentEdit"));
        dataSource.addColumn(new ActionColumn("Удалить", ActionColumn.DELETE, "onClickDeleteEntertainment", "Удалить мероприятие?").setPermissionKey("entertainmentDelete"));
        model.setDataSource(dataSource);
    }
}
