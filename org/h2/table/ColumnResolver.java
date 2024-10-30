package org.h2.table;

import org.h2.command.dml.Select;
import org.h2.expression.Expression;
import org.h2.expression.ExpressionColumn;
import org.h2.value.Value;

public interface ColumnResolver {
  String getTableAlias();
  
  Column[] getColumns();
  
  Column[] getSystemColumns();
  
  Column getRowIdColumn();
  
  String getSchemaName();
  
  Value getValue(Column paramColumn);
  
  TableFilter getTableFilter();
  
  Select getSelect();
  
  Expression optimize(ExpressionColumn paramExpressionColumn, Column paramColumn);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\ColumnResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */