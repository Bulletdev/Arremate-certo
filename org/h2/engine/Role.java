/*    */ package org.h2.engine;
/*    */ 
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Role
/*    */   extends RightOwner
/*    */ {
/*    */   private final boolean system;
/*    */   
/*    */   public Role(Database paramDatabase, int paramInt, String paramString, boolean paramBoolean) {
/* 20 */     super(paramDatabase, paramInt, paramString, 13);
/* 21 */     this.system = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 26 */     throw DbException.throwInternalError();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDropSQL() {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCreateSQL(boolean paramBoolean) {
/* 41 */     if (this.system) {
/* 42 */       return null;
/*    */     }
/* 44 */     StringBuilder stringBuilder = new StringBuilder("CREATE ROLE ");
/* 45 */     if (paramBoolean) {
/* 46 */       stringBuilder.append("IF NOT EXISTS ");
/*    */     }
/* 48 */     stringBuilder.append(getSQL());
/* 49 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQL() {
/* 54 */     return getCreateSQL(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 59 */     return 7;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeChildrenAndResources(Session paramSession) {
/* 64 */     for (User user : this.database.getAllUsers()) {
/* 65 */       Right right = user.getRightForRole(this);
/* 66 */       if (right != null) {
/* 67 */         this.database.removeDatabaseObject(paramSession, right);
/*    */       }
/*    */     } 
/* 70 */     for (Role role : this.database.getAllRoles()) {
/* 71 */       Right right = role.getRightForRole(this);
/* 72 */       if (right != null) {
/* 73 */         this.database.removeDatabaseObject(paramSession, right);
/*    */       }
/*    */     } 
/* 76 */     for (Right right : this.database.getAllRights()) {
/* 77 */       if (right.getGrantee() == this) {
/* 78 */         this.database.removeDatabaseObject(paramSession, right);
/*    */       }
/*    */     } 
/* 81 */     this.database.removeMeta(paramSession, getId());
/* 82 */     invalidate();
/*    */   }
/*    */   
/*    */   public void checkRename() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Role.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */