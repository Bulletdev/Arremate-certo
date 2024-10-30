/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Right;
/*     */ import org.h2.engine.RightOwner;
/*     */ import org.h2.engine.Role;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
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
/*     */ public class GrantRevoke
/*     */   extends DefineCommand
/*     */ {
/*     */   private ArrayList<String> roleNames;
/*     */   private int operationType;
/*     */   private int rightMask;
/*  35 */   private final ArrayList<Table> tables = New.arrayList();
/*     */   private Schema schema;
/*     */   private RightOwner grantee;
/*     */   
/*     */   public GrantRevoke(Session paramSession) {
/*  40 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setOperationType(int paramInt) {
/*  44 */     this.operationType = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRight(int paramInt) {
/*  53 */     this.rightMask |= paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRoleName(String paramString) {
/*  62 */     if (this.roleNames == null) {
/*  63 */       this.roleNames = New.arrayList();
/*     */     }
/*  65 */     this.roleNames.add(paramString);
/*     */   }
/*     */   
/*     */   public void setGranteeName(String paramString) {
/*  69 */     Database database = this.session.getDatabase();
/*  70 */     this.grantee = (RightOwner)database.findUser(paramString);
/*  71 */     if (this.grantee == null) {
/*  72 */       this.grantee = (RightOwner)database.findRole(paramString);
/*  73 */       if (this.grantee == null) {
/*  74 */         throw DbException.get(90071, paramString);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  81 */     this.session.getUser().checkAdmin();
/*  82 */     this.session.commit(true);
/*  83 */     Database database = this.session.getDatabase();
/*  84 */     if (this.roleNames != null) {
/*  85 */       for (String str : this.roleNames) {
/*  86 */         Role role = database.findRole(str);
/*  87 */         if (role == null) {
/*  88 */           throw DbException.get(90070, str);
/*     */         }
/*  90 */         if (this.operationType == 49) {
/*  91 */           grantRole(role); continue;
/*  92 */         }  if (this.operationType == 50) {
/*  93 */           revokeRole(role); continue;
/*     */         } 
/*  95 */         DbException.throwInternalError("type=" + this.operationType);
/*     */       }
/*     */     
/*     */     }
/*  99 */     else if (this.operationType == 49) {
/* 100 */       grantRight();
/* 101 */     } else if (this.operationType == 50) {
/* 102 */       revokeRight();
/*     */     } else {
/* 104 */       DbException.throwInternalError("type=" + this.operationType);
/*     */     } 
/*     */     
/* 107 */     return 0;
/*     */   }
/*     */   
/*     */   private void grantRight() {
/* 111 */     if (this.schema != null) {
/* 112 */       grantRight((DbObject)this.schema);
/*     */     }
/* 114 */     for (Table table : this.tables) {
/* 115 */       grantRight((DbObject)table);
/*     */     }
/*     */   }
/*     */   
/*     */   private void grantRight(DbObject paramDbObject) {
/* 120 */     Database database = this.session.getDatabase();
/* 121 */     Right right = this.grantee.getRightForObject(paramDbObject);
/* 122 */     if (right == null) {
/* 123 */       int i = getObjectId();
/* 124 */       right = new Right(database, i, this.grantee, this.rightMask, paramDbObject);
/* 125 */       this.grantee.grantRight(paramDbObject, right);
/* 126 */       database.addDatabaseObject(this.session, (DbObject)right);
/*     */     } else {
/* 128 */       right.setRightMask(right.getRightMask() | this.rightMask);
/* 129 */       database.updateMeta(this.session, (DbObject)right);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void grantRole(Role paramRole) {
/* 134 */     if (paramRole != this.grantee && this.grantee.isRoleGranted(paramRole)) {
/*     */       return;
/*     */     }
/* 137 */     if (this.grantee instanceof Role) {
/* 138 */       Role role = (Role)this.grantee;
/* 139 */       if (paramRole.isRoleGranted(role))
/*     */       {
/* 141 */         throw DbException.get(90074, paramRole.getSQL());
/*     */       }
/*     */     } 
/* 144 */     Database database = this.session.getDatabase();
/* 145 */     int i = getObjectId();
/* 146 */     Right right = new Right(database, i, this.grantee, paramRole);
/* 147 */     database.addDatabaseObject(this.session, (DbObject)right);
/* 148 */     this.grantee.grantRole(paramRole, right);
/*     */   }
/*     */   
/*     */   private void revokeRight() {
/* 152 */     if (this.schema != null) {
/* 153 */       revokeRight((DbObject)this.schema);
/*     */     }
/* 155 */     for (Table table : this.tables) {
/* 156 */       revokeRight((DbObject)table);
/*     */     }
/*     */   }
/*     */   
/*     */   private void revokeRight(DbObject paramDbObject) {
/* 161 */     Right right = this.grantee.getRightForObject(paramDbObject);
/* 162 */     if (right == null) {
/*     */       return;
/*     */     }
/* 165 */     int i = right.getRightMask();
/* 166 */     int j = i & (this.rightMask ^ 0xFFFFFFFF);
/* 167 */     Database database = this.session.getDatabase();
/* 168 */     if (j == 0) {
/* 169 */       database.removeDatabaseObject(this.session, (DbObject)right);
/*     */     } else {
/* 171 */       right.setRightMask(j);
/* 172 */       database.updateMeta(this.session, (DbObject)right);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void revokeRole(Role paramRole) {
/* 178 */     Right right = this.grantee.getRightForRole(paramRole);
/* 179 */     if (right == null) {
/*     */       return;
/*     */     }
/* 182 */     Database database = this.session.getDatabase();
/* 183 */     database.removeDatabaseObject(this.session, (DbObject)right);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTable(Table paramTable) {
/* 197 */     this.tables.add(paramTable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchema(Schema paramSchema) {
/* 206 */     this.schema = paramSchema;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 211 */     return this.operationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRoleMode() {
/* 218 */     return (this.roleNames != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRightMode() {
/* 225 */     return (this.rightMask != 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\GrantRevoke.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */