/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.UserDataType;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Column;
/*    */ import org.h2.table.Table;
/*    */ import org.h2.value.DataType;
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
/*    */ public class CreateUserDataType
/*    */   extends DefineCommand
/*    */ {
/*    */   private String typeName;
/*    */   private Column column;
/*    */   private boolean ifNotExists;
/*    */   
/*    */   public CreateUserDataType(Session paramSession) {
/* 29 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setTypeName(String paramString) {
/* 33 */     this.typeName = paramString;
/*    */   }
/*    */   
/*    */   public void setColumn(Column paramColumn) {
/* 37 */     this.column = paramColumn;
/*    */   }
/*    */   
/*    */   public void setIfNotExists(boolean paramBoolean) {
/* 41 */     this.ifNotExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 46 */     this.session.getUser().checkAdmin();
/* 47 */     this.session.commit(true);
/* 48 */     Database database = this.session.getDatabase();
/* 49 */     this.session.getUser().checkAdmin();
/* 50 */     if (database.findUserDataType(this.typeName) != null) {
/* 51 */       if (this.ifNotExists) {
/* 52 */         return 0;
/*    */       }
/* 54 */       throw DbException.get(90119, this.typeName);
/*    */     } 
/*    */ 
/*    */     
/* 58 */     DataType dataType = DataType.getTypeByName(this.typeName);
/* 59 */     if (dataType != null) {
/* 60 */       if (!dataType.hidden) {
/* 61 */         throw DbException.get(90119, this.typeName);
/*    */       }
/*    */ 
/*    */       
/* 65 */       Table table = this.session.getDatabase().getFirstUserTable();
/* 66 */       if (table != null) {
/* 67 */         throw DbException.get(90119, this.typeName + " (" + table.getSQL() + ")");
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 72 */     int i = getObjectId();
/* 73 */     UserDataType userDataType = new UserDataType(database, i, this.typeName);
/* 74 */     userDataType.setColumn(this.column);
/* 75 */     database.addDatabaseObject(this.session, (DbObject)userDataType);
/* 76 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 81 */     return 33;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateUserDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */