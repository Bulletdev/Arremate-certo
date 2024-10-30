/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.engine.DbObject;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.UserAggregate;
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
/*    */ public class DropAggregate
/*    */   extends DefineCommand
/*    */ {
/*    */   private String name;
/*    */   private boolean ifExists;
/*    */   
/*    */   public DropAggregate(Session paramSession) {
/* 25 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 30 */     this.session.getUser().checkAdmin();
/* 31 */     this.session.commit(true);
/* 32 */     Database database = this.session.getDatabase();
/* 33 */     UserAggregate userAggregate = database.findAggregate(this.name);
/* 34 */     if (userAggregate == null) {
/* 35 */       if (!this.ifExists) {
/* 36 */         throw DbException.get(90132, this.name);
/*    */       }
/*    */     } else {
/* 39 */       database.removeDatabaseObject(this.session, (DbObject)userAggregate);
/*    */     } 
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */   public void setName(String paramString) {
/* 45 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public void setIfExists(boolean paramBoolean) {
/* 49 */     this.ifExists = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 54 */     return 36;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropAggregate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */