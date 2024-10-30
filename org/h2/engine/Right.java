/*     */ package org.h2.engine;
/*     */ 
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Table;
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
/*     */ public class Right
/*     */   extends DbObjectBase
/*     */ {
/*     */   public static final int SELECT = 1;
/*     */   public static final int DELETE = 2;
/*     */   public static final int INSERT = 4;
/*     */   public static final int UPDATE = 8;
/*     */   public static final int ALTER_ANY_SCHEMA = 16;
/*     */   public static final int ALL = 15;
/*     */   private RightOwner grantee;
/*     */   private Role grantedRole;
/*     */   private int grantedRight;
/*     */   private DbObject grantedObject;
/*     */   
/*     */   public Right(Database paramDatabase, int paramInt, RightOwner paramRightOwner, Role paramRole) {
/*  71 */     initDbObjectBase(paramDatabase, paramInt, "RIGHT_" + paramInt, 13);
/*  72 */     this.grantee = paramRightOwner;
/*  73 */     this.grantedRole = paramRole;
/*     */   }
/*     */ 
/*     */   
/*     */   public Right(Database paramDatabase, int paramInt1, RightOwner paramRightOwner, int paramInt2, DbObject paramDbObject) {
/*  78 */     initDbObjectBase(paramDatabase, paramInt1, "" + paramInt1, 13);
/*  79 */     this.grantee = paramRightOwner;
/*  80 */     this.grantedRight = paramInt2;
/*  81 */     this.grantedObject = paramDbObject;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean appendRight(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {
/*  86 */     if ((paramInt1 & paramInt2) != 0) {
/*  87 */       if (paramBoolean) {
/*  88 */         paramStringBuilder.append(", ");
/*     */       }
/*  90 */       paramStringBuilder.append(paramString);
/*  91 */       return true;
/*     */     } 
/*  93 */     return paramBoolean;
/*     */   }
/*     */   
/*     */   public String getRights() {
/*  97 */     StringBuilder stringBuilder = new StringBuilder();
/*  98 */     if (this.grantedRight == 15) {
/*  99 */       stringBuilder.append("ALL");
/*     */     } else {
/* 101 */       boolean bool = false;
/* 102 */       bool = appendRight(stringBuilder, this.grantedRight, 1, "SELECT", bool);
/* 103 */       bool = appendRight(stringBuilder, this.grantedRight, 2, "DELETE", bool);
/* 104 */       bool = appendRight(stringBuilder, this.grantedRight, 4, "INSERT", bool);
/* 105 */       bool = appendRight(stringBuilder, this.grantedRight, 16, "ALTER ANY SCHEMA", bool);
/*     */       
/* 107 */       appendRight(stringBuilder, this.grantedRight, 8, "UPDATE", bool);
/*     */     } 
/* 109 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Role getGrantedRole() {
/* 113 */     return this.grantedRole;
/*     */   }
/*     */   
/*     */   public DbObject getGrantedObject() {
/* 117 */     return this.grantedObject;
/*     */   }
/*     */   
/*     */   public DbObject getGrantee() {
/* 121 */     return this.grantee;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 131 */     return getCreateSQLForCopy((DbObject)paramTable);
/*     */   }
/*     */   
/*     */   private String getCreateSQLForCopy(DbObject paramDbObject) {
/* 135 */     StringBuilder stringBuilder = new StringBuilder();
/* 136 */     stringBuilder.append("GRANT ");
/* 137 */     if (this.grantedRole != null) {
/* 138 */       stringBuilder.append(this.grantedRole.getSQL());
/*     */     } else {
/* 140 */       stringBuilder.append(getRights());
/* 141 */       if (paramDbObject != null) {
/* 142 */         if (paramDbObject instanceof org.h2.schema.Schema) {
/* 143 */           stringBuilder.append(" ON SCHEMA ").append(paramDbObject.getSQL());
/* 144 */         } else if (paramDbObject instanceof Table) {
/* 145 */           stringBuilder.append(" ON ").append(paramDbObject.getSQL());
/*     */         } 
/*     */       }
/*     */     } 
/* 149 */     stringBuilder.append(" TO ").append(this.grantee.getSQL());
/* 150 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 155 */     return getCreateSQLForCopy(this.grantedObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 160 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 165 */     if (this.grantedRole != null) {
/* 166 */       this.grantee.revokeRole(this.grantedRole);
/*     */     } else {
/* 168 */       this.grantee.revokeRight(this.grantedObject);
/*     */     } 
/* 170 */     this.database.removeMeta(paramSession, getId());
/* 171 */     this.grantedRole = null;
/* 172 */     this.grantedObject = null;
/* 173 */     this.grantee = null;
/* 174 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 179 */     DbException.throwInternalError();
/*     */   }
/*     */   
/*     */   public void setRightMask(int paramInt) {
/* 183 */     this.grantedRight = paramInt;
/*     */   }
/*     */   
/*     */   public int getRightMask() {
/* 187 */     return this.grantedRight;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Right.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */