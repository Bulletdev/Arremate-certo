/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.schema.Schema;
/*    */ import org.h2.table.Column;
/*    */ import org.h2.util.New;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CreateTableData
/*    */ {
/*    */   public Schema schema;
/*    */   public String tableName;
/*    */   public int id;
/* 37 */   public ArrayList<Column> columns = New.arrayList();
/*    */   public boolean temporary;
/*    */   public boolean globalTemporary;
/*    */   public boolean persistIndexes;
/*    */   public boolean persistData;
/*    */   public boolean create;
/*    */   public Session session;
/*    */   public String tableEngine;
/*    */   public ArrayList<String> tableEngineParams;
/*    */   public boolean isHidden;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateTableData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */