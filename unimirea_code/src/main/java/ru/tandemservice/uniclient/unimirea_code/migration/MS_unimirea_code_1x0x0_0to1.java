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
public class MS_unimirea_code_1x0x0_0to1 extends IndependentMigrationScript
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
		if(true){
			return;
		}
		////////////////////////////////////////////////////////////////////////////////
		// сущность entertainmentType

		// создана новая сущность
		{
			// создать таблицу
			DBTable dbt = new DBTable("entertainmenttype_t",
				new DBColumn("id", DBType.LONG).setNullable(false).setPrimaryKey("pk_entertainmenttype"), 
				new DBColumn("discriminator", DBType.SHORT).setNullable(false), 
				new DBColumn("code_p", DBType.createVarchar(255)).setNullable(false), 
				new DBColumn("shorttitle_p", DBType.createVarchar(255)).setNullable(false), 
				new DBColumn("title_p", DBType.createVarchar(1200))
			);
			tool.createTable(dbt);

			// гарантировать наличие кода сущности
			short entityCode = tool.entityCodes().ensure("entertainmentType");

		}


    }
}