/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
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
/*     */ public abstract class RightOwner
/*     */   extends DbObjectBase
/*     */ {
/*     */   private HashMap<Role, Right> grantedRoles;
/*     */   private HashMap<DbObject, Right> grantedRights;
/*     */   
/*     */   protected RightOwner(Database paramDatabase, int paramInt1, String paramString, int paramInt2) {
/*  30 */     initDbObjectBase(paramDatabase, paramInt1, paramString, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRoleGranted(Role paramRole) {
/*  40 */     if (paramRole == this) {
/*  41 */       return true;
/*     */     }
/*  43 */     if (this.grantedRoles != null) {
/*  44 */       for (Role role : this.grantedRoles.keySet()) {
/*  45 */         if (role == paramRole) {
/*  46 */           return true;
/*     */         }
/*  48 */         if (role.isRoleGranted(paramRole)) {
/*  49 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*  53 */     return false;
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
/*     */ 
/*     */   
/*     */   boolean isRightGrantedRecursive(Table paramTable, int paramInt) {
/*  68 */     if (this.grantedRights != null) {
/*  69 */       if (paramTable != null) {
/*  70 */         Right right1 = this.grantedRights.get(paramTable.getSchema());
/*  71 */         if (right1 != null && (
/*  72 */           right1.getRightMask() & paramInt) == paramInt) {
/*  73 */           return true;
/*     */         }
/*     */       } 
/*     */       
/*  77 */       Right right = this.grantedRights.get(paramTable);
/*  78 */       if (right != null && (
/*  79 */         right.getRightMask() & paramInt) == paramInt) {
/*  80 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  84 */     if (this.grantedRoles != null) {
/*  85 */       for (RightOwner rightOwner : this.grantedRoles.keySet()) {
/*  86 */         if (rightOwner.isRightGrantedRecursive(paramTable, paramInt)) {
/*  87 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void grantRight(DbObject paramDbObject, Right paramRight) {
/* 102 */     if (this.grantedRights == null) {
/* 103 */       this.grantedRights = New.hashMap();
/*     */     }
/* 105 */     this.grantedRights.put(paramDbObject, paramRight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void revokeRight(DbObject paramDbObject) {
/* 114 */     if (this.grantedRights == null) {
/*     */       return;
/*     */     }
/* 117 */     this.grantedRights.remove(paramDbObject);
/* 118 */     if (this.grantedRights.size() == 0) {
/* 119 */       this.grantedRights = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void grantRole(Role paramRole, Right paramRight) {
/* 130 */     if (this.grantedRoles == null) {
/* 131 */       this.grantedRoles = New.hashMap();
/*     */     }
/* 133 */     this.grantedRoles.put(paramRole, paramRight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void revokeRole(Role paramRole) {
/* 142 */     if (this.grantedRoles == null) {
/*     */       return;
/*     */     }
/* 145 */     Right right = this.grantedRoles.get(paramRole);
/* 146 */     if (right == null) {
/*     */       return;
/*     */     }
/* 149 */     this.grantedRoles.remove(paramRole);
/* 150 */     if (this.grantedRoles.size() == 0) {
/* 151 */       this.grantedRoles = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Right getRightForObject(DbObject paramDbObject) {
/* 162 */     if (this.grantedRights == null) {
/* 163 */       return null;
/*     */     }
/* 165 */     return this.grantedRights.get(paramDbObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Right getRightForRole(Role paramRole) {
/* 175 */     if (this.grantedRoles == null) {
/* 176 */       return null;
/*     */     }
/* 178 */     return this.grantedRoles.get(paramRole);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\RightOwner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */