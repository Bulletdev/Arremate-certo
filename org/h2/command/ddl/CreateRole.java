/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Role;
/*    */ import org.h2.engine.Session;
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
/*    */ public class CreateRole
/*    */   extends DefineCommand
/*    */ {
/*    */   private String roleName;
/*    */   private boolean ifNotExists;
/*    */   
/*    */   public CreateRole(Session paramSession) {
/* 25 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfNotExists(boolean paramBoolean) {
/* 29 */     this.ifNotExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setRoleName(String paramString) {
/* 33 */     this.roleName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 38 */     this.session.getUser().checkAdmin();
/* 39 */     this.session.commit(true);
/* 40 */     Database database = this.session.getDatabase();
/* 41 */     if (database.findUser(this.roleName) != null) {
/* 42 */       throw DbException.get(90033, this.roleName);
/*    */     }
/* 44 */     if (database.findRole(this.roleName) != null) {
/* 45 */       if (this.ifNotExists) {
/* 46 */         return 0;
/*    */       }
/* 48 */       throw DbException.get(90069, this.roleName);
/*    */     } 
/* 50 */     int i = getObjectId();
/* 51 */     Role role = new Role(database, i, this.roleName, false);
/* 52 */     database.addDatabaseObject(this.session, (DbObject)role);
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 58 */     return 27;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateRole.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */