package edu.utdallas.davisbase.db.frontend.domain.commands;

import edu.utdallas.davisbase.db.storage_engine.a_io.data.TableSchema;

/**
 * Data for the SQL <i>create table</i> statement.
 * @author Edward Sciore
 */
public class CreateTableData {
   private String tblname;
   private TableSchema sch;
   
   /**
    * Saves the table name and schema.
    */
   public CreateTableData(String tblname, TableSchema sch) {
      this.tblname = tblname;
      this.sch = sch;
   }
   
   /**
    * Returns the name of the new table.
    * @return the name of the new table
    */
   public String tableName() {
      return tblname;
   }
   
   /**
    * Returns the schema of the new table.
    * @return the schema of the new table
    */
   public TableSchema newSchema() {
      return sch;
   }
}
