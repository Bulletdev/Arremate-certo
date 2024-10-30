/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.UserDataType;
/*    */ import org.h2.message.DbException;
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
/*    */ public class DropUserDataType
/*    */   extends DefineCommand
/*    */ {
/*    */   private String typeName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropUserDataType(Session paramSession) {
/* 25 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 29 */     this.ifExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 34 */     this.session.getUser().checkAdmin();
/* 35 */     this.session.commit(true);
/* 36 */     Database database = this.session.getDatabase();
/* 37 */     UserDataType userDataType = database.findUserDataType(this.typeName);
/* 38 */     if (userDataType == null) {
/* 39 */       if (!this.ifExists) {
/* 40 */         throw DbException.get(90120, this.typeName);
/*    */       }
/*    */     } else {
/* 43 */       database.removeDatabaseObject(this.session, (DbObject)userDataType);
/*    */     } 
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */   public void setTypeName(String paramString) {
/* 49 */     this.typeName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 54 */     return 47;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropUserDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */