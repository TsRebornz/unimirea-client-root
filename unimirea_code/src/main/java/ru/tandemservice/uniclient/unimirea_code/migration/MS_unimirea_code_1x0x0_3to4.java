package ru.tandemservice.uniclient.unimirea_code.migration;

import org.tandemframework.core.common.DBType;
import org.tandemframework.core.meta.application.ModuleMeta;
import org.tandemframework.core.runtime.ApplicationRuntime;
import org.tandemframework.dbsupport.ddl.DBTool;
import org.tandemframework.dbsupport.ddl.schema.DBTable;
import org.tandemframework.dbsupport.ddl.schema.columns.DBColumn;
import org.tandemframework.dbsupport.migration.IndependentMigrationScript;
import org.tandemframework.dbsupport.migration.ScriptDependency;

/**
 * Автоматически сгенерированная миграция
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public class MS_unimirea_code_1x0x0_3to4 extends IndependentMigrationScript
{
    @Override
    public ScriptDependency[] getBoundaryDependencies()
    {
        return new ScriptDependency[]
		{
				 new ScriptDependency("org.tandemframework", "1.6.17"),
				 new ScriptDependency("org.tandemframework.shared", "1.8.2"),
				 new ScriptDependency("ru.tandemservice.uni.product", "2.8.2"),
				 new ScriptDependency("ru.tandemservice.uni.project", "2.8.2")
		};
    }

    @Override
    public void run(DBTool tool) throws Exception
    {
		////////////////////////////////////////////////////////////////////////////////
		// сущность entertainmentPrtcption

		//  свойство unit стало обязательным
		{

			if(true){
				return;
			}

			// задать значение по умолчанию
			java.lang.Long defaultUnit = null;
			tool.executeUpdate("update entertainmentprtcption_t set unit_id=? where unit_id is null", defaultUnit);

			// сделать колонку NOT NULL
			tool.setColumnNullable("entertainmentprtcption_t", "unit_id", false);

		}

		//  свойство type стало обязательным
		{
			if(true){
				return;
			}

			// задать значение по умолчанию
			java.lang.Long defaultType = null;
			tool.executeUpdate("update entertainmentprtcption_t set type_id=? where type_id is null", defaultType);

			// сделать колонку NOT NULL
			tool.setColumnNullable("entertainmentprtcption_t", "type_id", false);

		}

		//  свойство overseer стало обязательным
		{
			if(true){
				return;
			}
			if( true )
				throw new UnsupportedOperationException("Confirm me: set default value for required property");

			// задать значение по умолчанию
			java.lang.Boolean defaultOverseer = null;
			tool.executeUpdate("update entertainmentprtcption_t set overseer_p=? where overseer_p is null", defaultOverseer);

			// сделать колонку NOT NULL
			tool.setColumnNullable("entertainmentprtcption_t", "overseer_p", false);
		}
    }
}