package org.h2.api;

import org.h2.command.ddl.CreateTableData;
import org.h2.table.Table;

public interface TableEngine {
  Table createTable(CreateTableData paramCreateTableData);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\TableEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */