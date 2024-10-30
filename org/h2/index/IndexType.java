/*     */ package org.h2.index;
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
/*     */ public class IndexType
/*     */ {
/*     */   private boolean primaryKey;
/*     */   private boolean persistent;
/*     */   private boolean unique;
/*     */   private boolean hash;
/*     */   private boolean scan;
/*     */   private boolean spatial;
/*     */   private boolean belongsToConstraint;
/*     */   
/*     */   public static IndexType createPrimaryKey(boolean paramBoolean1, boolean paramBoolean2) {
/*  24 */     IndexType indexType = new IndexType();
/*  25 */     indexType.primaryKey = true;
/*  26 */     indexType.persistent = paramBoolean1;
/*  27 */     indexType.hash = paramBoolean2;
/*  28 */     indexType.unique = true;
/*  29 */     return indexType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IndexType createUnique(boolean paramBoolean1, boolean paramBoolean2) {
/*  40 */     IndexType indexType = new IndexType();
/*  41 */     indexType.unique = true;
/*  42 */     indexType.persistent = paramBoolean1;
/*  43 */     indexType.hash = paramBoolean2;
/*  44 */     return indexType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IndexType createNonUnique(boolean paramBoolean) {
/*  54 */     return createNonUnique(paramBoolean, false, false);
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
/*     */   
/*     */   public static IndexType createNonUnique(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  67 */     IndexType indexType = new IndexType();
/*  68 */     indexType.persistent = paramBoolean1;
/*  69 */     indexType.hash = paramBoolean2;
/*  70 */     indexType.spatial = paramBoolean3;
/*  71 */     return indexType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IndexType createScan(boolean paramBoolean) {
/*  81 */     IndexType indexType = new IndexType();
/*  82 */     indexType.persistent = paramBoolean;
/*  83 */     indexType.scan = true;
/*  84 */     return indexType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBelongsToConstraint(boolean paramBoolean) {
/*  93 */     this.belongsToConstraint = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBelongsToConstraint() {
/* 103 */     return this.belongsToConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHash() {
/* 112 */     return this.hash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSpatial() {
/* 121 */     return this.spatial;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPersistent() {
/* 130 */     return this.persistent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrimaryKey() {
/* 139 */     return this.primaryKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnique() {
/* 148 */     return this.unique;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 157 */     StringBuilder stringBuilder = new StringBuilder();
/* 158 */     if (this.primaryKey) {
/* 159 */       stringBuilder.append("PRIMARY KEY");
/* 160 */       if (this.hash) {
/* 161 */         stringBuilder.append(" HASH");
/*     */       }
/*     */     } else {
/* 164 */       if (this.unique) {
/* 165 */         stringBuilder.append("UNIQUE ");
/*     */       }
/* 167 */       if (this.hash) {
/* 168 */         stringBuilder.append("HASH ");
/*     */       }
/* 170 */       if (this.spatial) {
/* 171 */         stringBuilder.append("SPATIAL ");
/*     */       }
/* 173 */       stringBuilder.append("INDEX");
/*     */     } 
/* 175 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isScan() {
/* 184 */     return this.scan;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\IndexType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */