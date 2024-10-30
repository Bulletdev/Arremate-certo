/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.message.Trace;
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
/*     */ public abstract class DbObjectBase
/*     */   implements DbObject
/*     */ {
/*     */   protected Database database;
/*     */   protected Trace trace;
/*     */   protected String comment;
/*     */   private int id;
/*     */   private String objectName;
/*     */   private long modificationId;
/*     */   private boolean temporary;
/*     */   
/*     */   protected void initDbObjectBase(Database paramDatabase, int paramInt1, String paramString, int paramInt2) {
/*  47 */     this.database = paramDatabase;
/*  48 */     this.trace = paramDatabase.getTrace(paramInt2);
/*  49 */     this.id = paramInt1;
/*  50 */     this.objectName = paramString;
/*  51 */     this.modificationId = paramDatabase.getModificationMetaId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getCreateSQL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getDropSQL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void removeChildrenAndResources(Session paramSession);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void checkRename();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModified() {
/*  89 */     this.modificationId = (this.database == null) ? -1L : this.database.getNextModificationMetaId();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getModificationId() {
/*  94 */     return this.modificationId;
/*     */   }
/*     */   
/*     */   protected void setObjectName(String paramString) {
/*  98 */     this.objectName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 103 */     return Parser.quoteIdentifier(this.objectName);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<DbObject> getChildren() {
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Database getDatabase() {
/* 113 */     return this.database;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getId() {
/* 118 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 123 */     return this.objectName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void invalidate() {
/* 131 */     setModified();
/* 132 */     this.id = -1;
/* 133 */     this.database = null;
/* 134 */     this.trace = null;
/* 135 */     this.objectName = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rename(String paramString) {
/* 140 */     checkRename();
/* 141 */     this.objectName = paramString;
/* 142 */     setModified();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTemporary() {
/* 147 */     return this.temporary;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTemporary(boolean paramBoolean) {
/* 152 */     this.temporary = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setComment(String paramString) {
/* 157 */     this.comment = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 162 */     return this.comment;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     return this.objectName + ":" + this.id + ":" + super.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\DbObjectBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */