/*     */ package org.c.a.b.e.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.r.n;
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
/*     */ public class a
/*     */   extends a<b>
/*     */ {
/*  35 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */ 
/*     */   
/*     */   private static final String kX = "information_schema.user_variables";
/*     */ 
/*     */   
/*     */   private static final String kY = "performance_schema.user_variables_by_thread";
/*     */   
/*     */   private final String kZ;
/*     */   
/*     */   private final boolean cF;
/*     */ 
/*     */   
/*     */   a(b paramb, b paramb1, Connection paramConnection, boolean paramBoolean) {
/*  49 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     this
/*  56 */       .kZ = "SELECT variable_name FROM " + (paramb1.fF() ? "information_schema.user_variables" : "performance_schema.user_variables_by_thread") + " WHERE variable_value IS NOT NULL";
/*     */     
/*  58 */     this.cF = fE();
/*     */   }
/*     */   
/*     */   private boolean fE() {
/*  62 */     if (((b)this.a).fF() && !((b)this.a).c().H("10.2")) {
/*  63 */       a.debug("Disabled user variable reset as it is only available from MariaDB 10.2 onwards");
/*  64 */       return false;
/*     */     } 
/*  66 */     if (!((b)this.a).fF() && !((b)this.a).c().H("5.7")) {
/*  67 */       a.debug("Disabled user variable reset as it is only available from MySQL 5.7 onwards");
/*  68 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/*  72 */       this.a.a(this.kZ, new String[0]);
/*  73 */       return true;
/*  74 */     } catch (SQLException sQLException) {
/*  75 */       a.debug("Disabled user variable reset as " + (
/*  76 */           ((b)this.a).fF() ? "information_schema.user_variables" : "performance_schema.user_variables_by_thread") + "cannot be queried (SQL State: " + sQLException
/*  77 */           .getSQLState() + ", Error Code: " + sQLException.getErrorCode() + ")");
/*  78 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hW() throws SQLException {
/*  84 */     ic();
/*     */   }
/*     */ 
/*     */   
/*     */   private void ic() throws SQLException {
/*  89 */     if (this.cF) {
/*  90 */       List list = this.a.a(this.kZ, new String[0]);
/*  91 */       if (!list.isEmpty()) {
/*  92 */         boolean bool = true;
/*  93 */         StringBuilder stringBuilder = new StringBuilder("SET ");
/*  94 */         for (String str : list) {
/*  95 */           if (bool) {
/*  96 */             bool = false;
/*     */           } else {
/*  98 */             stringBuilder.append(",");
/*     */           } 
/* 100 */           stringBuilder.append("@").append(str).append("=NULL");
/*     */         } 
/* 102 */         this.a.a(stringBuilder.toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ey() throws SQLException {
/* 109 */     return this.a.b("SELECT DATABASE()", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bB(String paramString) throws SQLException {
/* 114 */     if (n.W(paramString)) {
/* 115 */       this.a.getConnection().setCatalog(paramString);
/*     */     } else {
/*     */       
/*     */       try {
/* 119 */         String str = ((b)this.a).d(new String[] { UUID.randomUUID().toString() });
/* 120 */         this.a.a("CREATE SCHEMA " + str, new Object[0]);
/* 121 */         this.a.a("USE " + str, new Object[0]);
/* 122 */         this.a.a("DROP SCHEMA " + str, new Object[0]);
/* 123 */       } catch (Exception exception) {
/* 124 */         a.warn("Unable to restore connection to having no default schema: " + exception.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected d b() throws SQLException {
/* 131 */     String str = ey();
/*     */ 
/*     */     
/* 134 */     return (str == null) ? null : a(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public d a(String paramString) {
/* 139 */     return new d((d)this.a, (b)this.a, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T a(f paramf, Callable<T> paramCallable) {
/* 144 */     if (((b)this.a).fG()) {
/* 145 */       return (T)super.a(paramf, paramCallable);
/*     */     }
/* 147 */     return (new c((d)this.a, paramf.toString().hashCode())).execute(paramCallable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */