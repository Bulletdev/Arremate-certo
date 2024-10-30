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
/*    */ 
/*    */ public class DropRole
/*    */   extends DefineCommand
/*    */ {
/*    */   private String roleName;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropRole(Session paramSession) {
/* 26 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setRoleName(String paramString) {
/* 30 */     this.roleName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 35 */     this.session.getUser().checkAdmin();
/* 36 */     this.session.commit(true);
/* 37 */     Database database = this.session.getDatabase();
/* 38 */     if (this.roleName.equals("PUBLIC")) {
/* 39 */       throw DbException.get(90091, this.roleName);
/*    */     }
/* 41 */     Role role = database.findRole(this.roleName);
/* 42 */     if (role == null) {
/* 43 */       if (!this.ifExists) {
/* 44 */         throw DbException.get(90070, this.roleName);
/*    */       }
/*    */     } else {
/* 47 */       database.removeDatabaseObject(this.session, (DbObject)role);
/*    */     } 
/* 49 */     return 0;
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 53 */     this.ifExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 58 */     return 41;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropRole.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */