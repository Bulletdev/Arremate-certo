/*     */ package org.h2.engine;
/*     */ 
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Table;
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
/*     */ public class Comment
/*     */   extends DbObjectBase
/*     */ {
/*     */   private final int objectType;
/*     */   private final String objectName;
/*     */   private String commentText;
/*     */   
/*     */   public Comment(Database paramDatabase, int paramInt, DbObject paramDbObject) {
/*  23 */     initDbObjectBase(paramDatabase, paramInt, getKey(paramDbObject), 2);
/*  24 */     this.objectType = paramDbObject.getType();
/*  25 */     this.objectName = paramDbObject.getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  30 */     throw DbException.throwInternalError();
/*     */   }
/*     */   
/*     */   private static String getTypeName(int paramInt) {
/*  34 */     switch (paramInt) {
/*     */       case 11:
/*  36 */         return "CONSTANT";
/*     */       case 5:
/*  38 */         return "CONSTRAINT";
/*     */       case 9:
/*  40 */         return "ALIAS";
/*     */       case 1:
/*  42 */         return "INDEX";
/*     */       case 7:
/*  44 */         return "ROLE";
/*     */       case 10:
/*  46 */         return "SCHEMA";
/*     */       case 3:
/*  48 */         return "SEQUENCE";
/*     */       case 0:
/*  50 */         return "TABLE";
/*     */       case 4:
/*  52 */         return "TRIGGER";
/*     */       case 2:
/*  54 */         return "USER";
/*     */       case 12:
/*  56 */         return "DOMAIN";
/*     */     } 
/*     */ 
/*     */     
/*  60 */     return "type" + paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  71 */     StringBuilder stringBuilder = new StringBuilder("COMMENT ON ");
/*  72 */     stringBuilder.append(getTypeName(this.objectType)).append(' ').append(this.objectName).append(" IS ");
/*     */     
/*  74 */     if (this.commentText == null) {
/*  75 */       stringBuilder.append("NULL");
/*     */     } else {
/*  77 */       stringBuilder.append(StringUtils.quoteStringSQL(this.commentText));
/*     */     } 
/*  79 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  84 */     return 13;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/*  89 */     this.database.removeMeta(paramSession, getId());
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/*  94 */     DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getKey(DbObject paramDbObject) {
/* 105 */     return getTypeName(paramDbObject.getType()) + " " + paramDbObject.getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommentText(String paramString) {
/* 114 */     this.commentText = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Comment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */