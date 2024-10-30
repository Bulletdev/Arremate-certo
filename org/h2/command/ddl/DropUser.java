/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.User;
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
/*    */ public class DropUser
/*    */   extends DefineCommand
/*    */ {
/*    */   private boolean ifExists;
/*    */   private String userName;
/*    */   
/*    */   public DropUser(Session paramSession) {
/* 25 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 29 */     this.ifExists = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setUserName(String paramString) {
/* 33 */     this.userName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 38 */     this.session.getUser().checkAdmin();
/* 39 */     this.session.commit(true);
/* 40 */     Database database = this.session.getDatabase();
/* 41 */     User user = database.findUser(this.userName);
/* 42 */     if (user == null) {
/* 43 */       if (!this.ifExists) {
/* 44 */         throw DbException.get(90032, this.userName);
/*    */       }
/*    */     } else {
/* 47 */       if (user == this.session.getUser()) {
/* 48 */         byte b = 0;
/* 49 */         for (User user1 : database.getAllUsers()) {
/* 50 */           if (user1.isAdmin()) {
/* 51 */             b++;
/*    */           }
/*    */         } 
/* 54 */         if (b == 1) {
/* 55 */           throw DbException.get(90019);
/*    */         }
/*    */       } 
/* 58 */       user.checkOwnsNoSchemas();
/* 59 */       database.removeDatabaseObject(this.session, (DbObject)user);
/*    */     } 
/* 61 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 71 */     return 46;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */