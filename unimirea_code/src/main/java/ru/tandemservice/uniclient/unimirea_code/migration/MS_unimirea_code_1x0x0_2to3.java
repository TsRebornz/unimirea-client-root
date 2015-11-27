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
public class MS_unimirea_code_1x0x0_2to3 extends IndependentMigrationScript
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

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("entertainmentprtcption_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_entertainmentprtcption"), 
				new DBColumn("discriminator", DBType.SHORT).setNullable(false), 
				new DBColumn("unit_id", DBType.LONG), 
				new DBColumn("type_id", DBType.LONG), 
				new DBColumn("overseer_p", DBType.BOOLEAN)
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("entertainmentPrtcption");

		}


    }
}