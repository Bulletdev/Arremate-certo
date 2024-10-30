/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableView;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
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
/*     */ public class User
/*     */   extends RightOwner
/*     */ {
/*     */   private final boolean systemUser;
/*     */   private byte[] salt;
/*     */   private byte[] passwordHash;
/*     */   private boolean admin;
/*     */   
/*     */   public User(Database paramDatabase, int paramInt, String paramString, boolean paramBoolean) {
/*  36 */     super(paramDatabase, paramInt, paramString, 13);
/*  37 */     this.systemUser = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setAdmin(boolean paramBoolean) {
/*  41 */     this.admin = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isAdmin() {
/*  45 */     return this.admin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaltAndHash(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  55 */     this.salt = paramArrayOfbyte1;
/*  56 */     this.passwordHash = paramArrayOfbyte2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserPasswordHash(byte[] paramArrayOfbyte) {
/*  66 */     if (paramArrayOfbyte != null) {
/*  67 */       if (paramArrayOfbyte.length == 0) {
/*  68 */         this.salt = this.passwordHash = paramArrayOfbyte;
/*     */       } else {
/*  70 */         this.salt = new byte[8];
/*  71 */         MathUtils.randomBytes(this.salt);
/*  72 */         this.passwordHash = SHA256.getHashWithSalt(paramArrayOfbyte, this.salt);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  79 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  84 */     return getCreateSQL(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRight(Table paramTable, int paramInt) {
/* 100 */     if (!hasRight(paramTable, paramInt)) {
/* 101 */       throw DbException.get(90096, paramTable.getSQL());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRight(Table paramTable, int paramInt) {
/* 113 */     if (paramInt != 1 && !this.systemUser && paramTable != null) {
/* 114 */       paramTable.checkWritingAllowed();
/*     */     }
/* 116 */     if (this.admin) {
/* 117 */       return true;
/*     */     }
/* 119 */     Role role = this.database.getPublicRole();
/* 120 */     if (role.isRightGrantedRecursive(paramTable, paramInt)) {
/* 121 */       return true;
/*     */     }
/* 123 */     if (paramTable instanceof org.h2.table.MetaTable || paramTable instanceof org.h2.table.RangeTable)
/*     */     {
/* 125 */       return true;
/*     */     }
/* 127 */     if (paramTable != null) {
/* 128 */       if (hasRight((Table)null, 16)) {
/* 129 */         return true;
/*     */       }
/* 131 */       String str = paramTable.getTableType();
/* 132 */       if ("VIEW".equals(str)) {
/* 133 */         TableView tableView = (TableView)paramTable;
/* 134 */         if (tableView.getOwner() == this)
/*     */         {
/*     */           
/* 137 */           return true;
/*     */         }
/* 139 */       } else if (str == null) {
/*     */         
/* 141 */         return true;
/*     */       } 
/* 143 */       if (paramTable.isTemporary() && !paramTable.isGlobalTemporary())
/*     */       {
/* 145 */         return true;
/*     */       }
/*     */     } 
/* 148 */     if (isRightGrantedRecursive(paramTable, paramInt)) {
/* 149 */       return true;
/*     */     }
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreateSQL(boolean paramBoolean) {
/* 162 */     StringBuilder stringBuilder = new StringBuilder("CREATE USER IF NOT EXISTS ");
/* 163 */     stringBuilder.append(getSQL());
/* 164 */     if (this.comment != null) {
/* 165 */       stringBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 167 */     if (paramBoolean) {
/* 168 */       stringBuilder.append(" SALT '").append(StringUtils.convertBytesToHex(this.salt)).append("' HASH '").append(StringUtils.convertBytesToHex(this.passwordHash)).append('\'');
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 174 */       stringBuilder.append(" PASSWORD ''");
/*     */     } 
/* 176 */     if (this.admin) {
/* 177 */       stringBuilder.append(" ADMIN");
/*     */     }
/* 179 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean validateUserPasswordHash(byte[] paramArrayOfbyte) {
/* 189 */     if (paramArrayOfbyte.length == 0 && this.passwordHash.length == 0) {
/* 190 */       return true;
/*     */     }
/* 192 */     if (paramArrayOfbyte.length == 0) {
/* 193 */       paramArrayOfbyte = SHA256.getKeyPasswordHash(getName(), new char[0]);
/*     */     }
/* 195 */     byte[] arrayOfByte = SHA256.getHashWithSalt(paramArrayOfbyte, this.salt);
/* 196 */     return Utils.compareSecure(arrayOfByte, this.passwordHash);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkAdmin() {
/* 206 */     if (!this.admin) {
/* 207 */       throw DbException.get(90040);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkSchemaAdmin() {
/* 218 */     if (!hasRight((Table)null, 16)) {
/* 219 */       throw DbException.get(90040);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 225 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<DbObject> getChildren() {
/* 230 */     ArrayList<Right> arrayList = New.arrayList();
/* 231 */     for (Right right : this.database.getAllRights()) {
/* 232 */       if (right.getGrantee() == this) {
/* 233 */         arrayList.add(right);
/*     */       }
/*     */     } 
/* 236 */     for (Schema schema : this.database.getAllSchemas()) {
/* 237 */       if (schema.getOwner() == this) {
/* 238 */         arrayList.add(schema);
/*     */       }
/*     */     } 
/* 241 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 246 */     for (Right right : this.database.getAllRights()) {
/* 247 */       if (right.getGrantee() == this) {
/* 248 */         this.database.removeDatabaseObject(paramSession, right);
/*     */       }
/*     */     } 
/* 251 */     this.database.removeMeta(paramSession, getId());
/* 252 */     this.salt = null;
/* 253 */     Arrays.fill(this.passwordHash, (byte)0);
/* 254 */     this.passwordHash = null;
/* 255 */     invalidate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkOwnsNoSchemas() {
/* 270 */     for (Schema schema : this.database.getAllSchemas()) {
/* 271 */       if (this == schema.getOwner())
/* 272 */         throw DbException.get(90107, new String[] { getName(), schema.getName() }); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */