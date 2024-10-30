/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AlterUser
/*     */   extends DefineCommand
/*     */ {
/*     */   private int type;
/*     */   private User user;
/*     */   private String newName;
/*     */   private Expression password;
/*     */   private Expression salt;
/*     */   private Expression hash;
/*     */   private boolean admin;
/*     */   
/*     */   public AlterUser(Session paramSession) {
/*  33 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setType(int paramInt) {
/*  37 */     this.type = paramInt;
/*     */   }
/*     */   
/*     */   public void setNewName(String paramString) {
/*  41 */     this.newName = paramString;
/*     */   }
/*     */   
/*     */   public void setUser(User paramUser) {
/*  45 */     this.user = paramUser;
/*     */   }
/*     */   
/*     */   public void setAdmin(boolean paramBoolean) {
/*  49 */     this.admin = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSalt(Expression paramExpression) {
/*  53 */     this.salt = paramExpression;
/*     */   }
/*     */   
/*     */   public void setHash(Expression paramExpression) {
/*  57 */     this.hash = paramExpression;
/*     */   }
/*     */   
/*     */   public void setPassword(Expression paramExpression) {
/*  61 */     this.password = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  66 */     this.session.commit(true);
/*  67 */     Database database = this.session.getDatabase();
/*  68 */     switch (this.type)
/*     */     { case 19:
/*  70 */         if (this.user != this.session.getUser()) {
/*  71 */           this.session.getUser().checkAdmin();
/*     */         }
/*  73 */         if (this.hash != null && this.salt != null) {
/*  74 */           CreateUser.setSaltAndHash(this.user, this.session, this.salt, this.hash);
/*     */         } else {
/*  76 */           CreateUser.setPassword(this.user, this.session, this.password);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         database.updateMeta(this.session, (DbObject)this.user);
/*  97 */         return 0;case 18: this.session.getUser().checkAdmin(); if (database.findUser(this.newName) != null || this.newName.equals(this.user.getName())) throw DbException.get(90033, this.newName);  database.renameDatabaseObject(this.session, (DbObject)this.user, this.newName); database.updateMeta(this.session, (DbObject)this.user); return 0;case 17: this.session.getUser().checkAdmin(); if (!this.admin) this.user.checkOwnsNoSchemas();  this.user.setAdmin(this.admin); database.updateMeta(this.session, (DbObject)this.user); return 0; }  DbException.throwInternalError("type=" + this.type); database.updateMeta(this.session, (DbObject)this.user); return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 102 */     return this.type;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */