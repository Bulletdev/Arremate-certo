package org.h2.engine;

import java.util.ArrayList;
import org.h2.table.Table;

public interface DbObject {
  public static final int TABLE_OR_VIEW = 0;
  
  public static final int INDEX = 1;
  
  public static final int USER = 2;
  
  public static final int SEQUENCE = 3;
  
  public static final int TRIGGER = 4;
  
  public static final int CONSTRAINT = 5;
  
  public static final int SETTING = 6;
  
  public static final int ROLE = 7;
  
  public static final int RIGHT = 8;
  
  public static final int FUNCTION_ALIAS = 9;
  
  public static final int SCHEMA = 10;
  
  public static final int CONSTANT = 11;
  
  public static final int USER_DATATYPE = 12;
  
  public static final int COMMENT = 13;
  
  public static final int AGGREGATE = 14;
  
  String getSQL();
  
  ArrayList<DbObject> getChildren();
  
  Database getDatabase();
  
  int getId();
  
  String getName();
  
  String getCreateSQLForCopy(Table paramTable, String paramString);
  
  String getCreateSQL();
  
  String getDropSQL();
  
  int getType();
  
  void removeChildrenAndResources(Session paramSession);
  
  void checkRename();
  
  void rename(String paramString);
  
  boolean isTemporary();
  
  void setTemporary(boolean paramBoolean);
  
  void setComment(String paramString);
  
  String getComment();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\DbObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */