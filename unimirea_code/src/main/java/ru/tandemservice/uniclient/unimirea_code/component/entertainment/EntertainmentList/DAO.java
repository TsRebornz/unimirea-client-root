package ru.tandemservice.uniclient.unimirea_code.component.entertainment.EntertainmentList;


import org.tandemframework.core.view.list.source.DynamicListDataSource;
import org.tandemframework.hibsupport.DataAccessServices;
import org.tandemframework.hibsupport.dql.DQLExpressions;
import org.tandemframework.hibsupport.dql.DQLSelectBuilder;
import org.tandemframework.hibsupport.dql.util.DQLSelectColumnNumerator;
import org.tandemframework.shared.commonbase.base.util.CommonBaseSearchListUtil;
import ru.tandemservice.uni.dao.UniDao;
import ru.tandemservice.uni.entity.employee.Student;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import java.util.List;

/**
 * Created by ocean on 13.10.2015.
 */
public class DAO extends UniDao<Model> implements IDAO
{

    @Override
    public void prepareListDataSource(Model model)
    {
//        DQLSelectColumnNumerator studentDQL = new DQLSelectColumnNumerator(new DQLSelectBuilder().fromEntity(Student.class, "st").where(DQLExpressions.eqValue(DQLExpressions.property("st.entranceYear()"), 2015) ) ) ;
//
//        System.out.println(studentDQL.getDql().toString()) ;
//        List<Student> list = DataAccessServices.dao().getList(studentDQL.getDql());
//        System.out.println(list.get(0).getFullTitle());

        DynamicListDataSource<EntertainmentTypeUnit> dataSource = model.getDataSource();
        DQLSelectBuilder builder = new DQLSelectBuilder().fromEntity(EntertainmentTypeUnit.class,"e").column(DQLExpressions.property("e"));
        CommonBaseSearchListUtil.createPage(dataSource, builder);
    }

}
