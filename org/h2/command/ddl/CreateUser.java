/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class CreateUser
/*     */   extends DefineCommand
/*     */ {
/*     */   private String userName;
/*     */   private boolean admin;
/*     */   private Expression password;
/*     */   private Expression salt;
/*     */   private Expression hash;
/*     */   private boolean ifNotExists;
/*     */   private String comment;
/*     */   
/*     */   public CreateUser(Session paramSession) {
/*  33 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  37 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setUserName(String paramString) {
/*  41 */     this.userName = paramString;
/*     */   }
/*     */   
/*     */   public void setPassword(Expression paramExpression) {
/*  45 */     this.password = paramExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void setSaltAndHash(User paramUser, Session paramSession, Expression paramExpression1, Expression paramExpression2) {
/*  57 */     paramUser.setSaltAndHash(getByteArray(paramSession, paramExpression1), getByteArray(paramSession, paramExpression2));
/*     */   }
/*     */   
/*     */   private static byte[] getByteArray(Session paramSession, Expression paramExpression) {
/*  61 */     String str = paramExpression.optimize(paramSession).getValue(paramSession).getString();
/*  62 */     return (str == null) ? new byte[0] : StringUtils.convertHexToBytes(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void setPassword(User paramUser, Session paramSession, Expression paramExpression) {
/*     */     byte[] arrayOfByte;
/*  73 */     String str1 = paramExpression.optimize(paramSession).getValue(paramSession).getString();
/*  74 */     char[] arrayOfChar = (str1 == null) ? new char[0] : str1.toCharArray();
/*     */     
/*  76 */     String str2 = paramUser.getName();
/*  77 */     if (str2.length() == 0 && arrayOfChar.length == 0) {
/*  78 */       arrayOfByte = new byte[0];
/*     */     } else {
/*  80 */       arrayOfByte = SHA256.getKeyPasswordHash(str2, arrayOfChar);
/*     */     } 
/*  82 */     paramUser.setUserPasswordHash(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  87 */     this.session.getUser().checkAdmin();
/*  88 */     this.session.commit(true);
/*  89 */     Database database = this.session.getDatabase();
/*  90 */     if (database.findRole(this.userName) != null) {
/*  91 */       throw DbException.get(90069, this.userName);
/*     */     }
/*  93 */     if (database.findUser(this.userName) != null) {
/*  94 */       if (this.ifNotExists) {
/*  95 */         return 0;
/*     */       }
/*  97 */       throw DbException.get(90033, this.userName);
/*     */     } 
/*  99 */     int i = getObjectId();
/* 100 */     User user = new User(database, i, this.userName, false);
/* 101 */     user.setAdmin(this.admin);
/* 102 */     user.setComment(this.comment);
/* 103 */     if (this.hash != null && this.salt != null) {
/* 104 */       setSaltAndHash(user, this.session, this.salt, this.hash);
/* 105 */     } else if (this.password != null) {
/* 106 */       setPassword(user, this.session, this.password);
/*     */     } else {
/* 108 */       throw DbException.throwInternalError();
/*     */     } 
/* 110 */     database.addDatabaseObject(this.session, (DbObject)user);
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */   public void setSalt(Expression paramExpression) {
/* 115 */     this.salt = paramExpression;
/*     */   }
/*     */   
/*     */   public void setHash(Expression paramExpression) {
/* 119 */     this.hash = paramExpression;
/*     */   }
/*     */   
/*     */   public void setAdmin(boolean paramBoolean) {
/* 123 */     this.admin = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/* 127 */     this.comment = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 132 */     return 32;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */