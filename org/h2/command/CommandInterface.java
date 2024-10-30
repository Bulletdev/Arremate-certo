package org.h2.command;

import java.util.ArrayList;
import org.h2.expression.ParameterInterface;
import org.h2.result.ResultInterface;

public interface CommandInterface {
  public static final int UNKNOWN = 0;
  
  public static final int ALTER_INDEX_RENAME = 1;
  
  public static final int ALTER_SCHEMA_RENAME = 2;
  
  public static final int ALTER_TABLE_ADD_CONSTRAINT_CHECK = 3;
  
  public static final int ALTER_TABLE_ADD_CONSTRAINT_UNIQUE = 4;
  
  public static final int ALTER_TABLE_ADD_CONSTRAINT_REFERENTIAL = 5;
  
  public static final int ALTER_TABLE_ADD_CONSTRAINT_PRIMARY_KEY = 6;
  
  public static final int ALTER_TABLE_ADD_COLUMN = 7;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_NOT_NULL = 8;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_NULL = 9;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_DEFAULT = 10;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_CHANGE_TYPE = 11;
  
  public static final int ALTER_TABLE_DROP_COLUMN = 12;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_SELECTIVITY = 13;
  
  public static final int ALTER_TABLE_DROP_CONSTRAINT = 14;
  
  public static final int ALTER_TABLE_RENAME = 15;
  
  public static final int ALTER_TABLE_ALTER_COLUMN_RENAME = 16;
  
  public static final int ALTER_USER_ADMIN = 17;
  
  public static final int ALTER_USER_RENAME = 18;
  
  public static final int ALTER_USER_SET_PASSWORD = 19;
  
  public static final int ALTER_VIEW = 20;
  
  public static final int ANALYZE = 21;
  
  public static final int CREATE_AGGREGATE = 22;
  
  public static final int CREATE_CONSTANT = 23;
  
  public static final int CREATE_ALIAS = 24;
  
  public static final int CREATE_INDEX = 25;
  
  public static final int CREATE_LINKED_TABLE = 26;
  
  public static final int CREATE_ROLE = 27;
  
  public static final int CREATE_SCHEMA = 28;
  
  public static final int CREATE_SEQUENCE = 29;
  
  public static final int CREATE_TABLE = 30;
  
  public static final int CREATE_TRIGGER = 31;
  
  public static final int CREATE_USER = 32;
  
  public static final int CREATE_DOMAIN = 33;
  
  public static final int CREATE_VIEW = 34;
  
  public static final int DEALLOCATE = 35;
  
  public static final int DROP_AGGREGATE = 36;
  
  public static final int DROP_CONSTANT = 37;
  
  public static final int DROP_ALL_OBJECTS = 38;
  
  public static final int DROP_ALIAS = 39;
  
  public static final int DROP_INDEX = 40;
  
  public static final int DROP_ROLE = 41;
  
  public static final int DROP_SCHEMA = 42;
  
  public static final int DROP_SEQUENCE = 43;
  
  public static final int DROP_TABLE = 44;
  
  public static final int DROP_TRIGGER = 45;
  
  public static final int DROP_USER = 46;
  
  public static final int DROP_DOMAIN = 47;
  
  public static final int DROP_VIEW = 48;
  
  public static final int GRANT = 49;
  
  public static final int REVOKE = 50;
  
  public static final int PREPARE = 51;
  
  public static final int COMMENT = 52;
  
  public static final int TRUNCATE_TABLE = 53;
  
  public static final int ALTER_SEQUENCE = 54;
  
  public static final int ALTER_TABLE_SET_REFERENTIAL_INTEGRITY = 55;
  
  public static final int BACKUP = 56;
  
  public static final int CALL = 57;
  
  public static final int DELETE = 58;
  
  public static final int EXECUTE = 59;
  
  public static final int EXPLAIN = 60;
  
  public static final int INSERT = 61;
  
  public static final int MERGE = 62;
  
  public static final int REPLACE = 63;
  
  public static final int NO_OPERATION = 63;
  
  public static final int RUNSCRIPT = 64;
  
  public static final int SCRIPT = 65;
  
  public static final int SELECT = 66;
  
  public static final int SET = 67;
  
  public static final int UPDATE = 68;
  
  public static final int SET_AUTOCOMMIT_TRUE = 69;
  
  public static final int SET_AUTOCOMMIT_FALSE = 70;
  
  public static final int COMMIT = 71;
  
  public static final int ROLLBACK = 72;
  
  public static final int CHECKPOINT = 73;
  
  public static final int SAVEPOINT = 74;
  
  public static final int ROLLBACK_TO_SAVEPOINT = 75;
  
  public static final int CHECKPOINT_SYNC = 76;
  
  public static final int PREPARE_COMMIT = 77;
  
  public static final int COMMIT_TRANSACTION = 78;
  
  public static final int ROLLBACK_TRANSACTION = 79;
  
  public static final int SHUTDOWN = 80;
  
  public static final int SHUTDOWN_IMMEDIATELY = 81;
  
  public static final int SHUTDOWN_COMPACT = 82;
  
  public static final int BEGIN = 83;
  
  public static final int SHUTDOWN_DEFRAG = 84;
  
  public static final int ALTER_TABLE_RENAME_CONSTRAINT = 85;
  
  int getCommandType();
  
  boolean isQuery();
  
  ArrayList<? extends ParameterInterface> getParameters();
  
  ResultInterface executeQuery(int paramInt, boolean paramBoolean);
  
  int executeUpdate();
  
  void close();
  
  void cancel();
  
  ResultInterface getMetaData();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\CommandInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */