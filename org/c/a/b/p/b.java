/*     */ package org.c.a.b.p;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.h;
/*     */ import org.c.a.b.h.i;
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
/*     */ class b
/*     */   extends c
/*     */ {
/*  44 */   private static final a a = c.b(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.e.a.b a;
/*     */ 
/*     */ 
/*     */   
/*     */   private final a<?> b;
/*     */ 
/*     */ 
/*     */   
/*     */   private final d a;
/*     */ 
/*     */ 
/*     */   
/*  61 */   private final LinkedList<a> b = new LinkedList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String jT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b(org.c.a.b.e.a.b paramb, f paramf, String paramString) {
/*  76 */     this.b = (LinkedList<a>)a(paramf);
/*  77 */     this.a = (d)paramb;
/*  78 */     this.b = (LinkedList<a>)paramb.a();
/*  79 */     this.a = this.b.a();
/*  80 */     this.jT = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private f a(f paramf) {
/*  91 */     if (paramf.getName().equals("flyway_schema_history") && !paramf.exists()) {
/*  92 */       f f1 = paramf.c().a("schema_version");
/*  93 */       if (f1.exists()) {
/*  94 */         a.warn("Could not find schema history table " + paramf + ", but found " + f1 + " instead. You are seeing this message because Flyway changed its default for flyway.table in version 5.0.0 to flyway_schema_history and you are still relying on the old default (schema_version). Set flyway.table=schema_version in your configuration to fix this. This fallback mechanism will be removed in Flyway 6.0.0.");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  99 */         paramf = f1;
/*     */       } 
/*     */     } 
/* 102 */     return paramf;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearCache() {
/* 107 */     this.b.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists() {
/* 112 */     this.b.hU();
/*     */     
/* 114 */     return this.b.exists();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hS() {
/* 119 */     byte b1 = 0;
/* 120 */     while (!exists()) {
/* 121 */       if (!b1) {
/* 122 */         a.info("Creating Schema History table: " + this.b);
/*     */       }
/*     */       try {
/* 125 */         (new i(this.b.c(), true)).execute(new Callable(this)
/*     */             {
/*     */               public Object call() {
/* 128 */                 b.a(this.a).a(b.a(this.a))
/*     */ 
/*     */ 
/*     */                   
/* 132 */                   .a(b.a(this.a).a((f)this.a.b));
/* 133 */                 b.d().debug("Created Schema History table: " + this.a.b);
/* 134 */                 return null;
/*     */               }
/*     */             });
/* 137 */       } catch (a a1) {
/* 138 */         if (++b1 >= 10) {
/* 139 */           throw a1;
/*     */         }
/*     */         try {
/* 142 */           a.debug("Schema History table creation failed. Retrying in 1 sec ...");
/* 143 */           Thread.sleep(1000L);
/* 144 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T a(Callable<T> paramCallable) {
/* 153 */     this.b.hU();
/*     */     
/* 155 */     return (T)this.b.a((f)this.b, paramCallable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(int paramInt1, g paramg, String paramString1, f paramf, String paramString2, Integer paramInteger, int paramInt2, boolean paramBoolean) {
/* 162 */     this.b.hU();
/*     */ 
/*     */ 
/*     */     
/* 166 */     if (!this.a.fx()) {
/* 167 */       this.b.lock();
/*     */     }
/*     */     
/*     */     try {
/* 171 */       String str = (paramg == null) ? null : paramg.toString();
/*     */       
/* 173 */       this.a.b(this.a.a((f)this.b), new Object[] {
/* 174 */             Integer.valueOf(paramInt1), str, paramString1, paramf.name(), paramString2, paramInteger, this.jT, 
/* 175 */             Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean)
/*     */           });
/* 177 */       a.debug("Schema History table " + this.b + " successfully updated to reflect changes");
/* 178 */     } catch (SQLException sQLException) {
/* 179 */       throw new org.c.a.b.f.b("Unable to insert row for version '" + paramg + "' in Schema History table " + this.b, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<a> ba() {
/* 185 */     if (!exists()) {
/* 186 */       return new ArrayList<>();
/*     */     }
/*     */     
/* 189 */     ii();
/* 190 */     return this.b;
/*     */   }
/*     */   
/*     */   private void ii() {
/* 194 */     boolean bool = this.b.isEmpty() ? true : ((a)this.b.getLast()).bQ();
/*     */     
/* 196 */     String str = this.a.a((f)this.b, bool);
/*     */     
/*     */     try {
/* 199 */       this.b.addAll(this.a.a(str, new h<a>(this) {
/*     */               public a a(ResultSet param1ResultSet) throws SQLException {
/* 201 */                 Integer integer = Integer.valueOf(param1ResultSet.getInt("checksum"));
/* 202 */                 if (param1ResultSet.wasNull()) {
/* 203 */                   integer = null;
/*     */                 }
/*     */                 
/* 206 */                 return new a(param1ResultSet
/* 207 */                     .getInt("installed_rank"), 
/* 208 */                     (param1ResultSet.getString("version") != null) ? g.a(param1ResultSet.getString("version")) : null, param1ResultSet
/* 209 */                     .getString("description"), 
/* 210 */                     f.valueOf(param1ResultSet.getString("type")), param1ResultSet
/* 211 */                     .getString("script"), integer, param1ResultSet
/*     */                     
/* 213 */                     .getTimestamp("installed_on"), param1ResultSet
/* 214 */                     .getString("installed_by"), param1ResultSet
/* 215 */                     .getInt("execution_time"), param1ResultSet
/* 216 */                     .getBoolean("success"));
/*     */               }
/*     */             }));
/*     */     }
/* 220 */     catch (SQLException sQLException) {
/* 221 */       throw new org.c.a.b.f.b("Error while retrieving the list of applied migrations from Schema History table " + this.b, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ij() {
/* 228 */     if (!exists()) {
/* 229 */       a.info("Repair of failed migration in Schema History table " + this.b + " not necessary as table doesn't exist.");
/*     */       
/*     */       return;
/*     */     } 
/* 233 */     boolean bool = false;
/* 234 */     List<a> list = ba();
/* 235 */     for (a a1 : list) {
/* 236 */       if (!a1.g()) {
/* 237 */         bool = true;
/*     */       }
/*     */     } 
/* 240 */     if (!bool) {
/* 241 */       a.info("Repair of failed migration in Schema History table " + this.b + " not necessary. No failed migration detected.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/* 246 */       clearCache();
/* 247 */       this.a.a("DELETE FROM " + this.b + " WHERE " + this.a
/* 248 */           .d(new String[] { "success" }, ) + " = " + this.a.eD(), new Object[0]);
/* 249 */     } catch (SQLException sQLException) {
/* 250 */       throw new org.c.a.b.f.b("Unable to repair Schema History table " + this.b, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(a parama, d paramd) {
/* 256 */     this.b.hU();
/*     */     
/* 258 */     clearCache();
/*     */     
/* 260 */     g g = parama.c();
/*     */     
/* 262 */     String str = paramd.getDescription();
/* 263 */     Integer integer = paramd.d();
/*     */ 
/*     */     
/* 266 */     f f = parama.a().isSynthetic() ? parama.a() : paramd.a();
/*     */     
/* 268 */     a.info("Repairing Schema History table for version " + g + " (Description: " + str + ", Type: " + f + ", Checksum: " + integer + ")  ...");
/*     */ 
/*     */     
/*     */     try {
/* 272 */       this.a.b("UPDATE " + this.b + " SET " + this.a
/*     */           
/* 274 */           .d(new String[] { "description" }, ) + "=? , " + this.a
/* 275 */           .d(new String[] { "type" }, ) + "=? , " + this.a
/* 276 */           .d(new String[] { "checksum" }, ) + "=? WHERE " + this.a
/* 277 */           .d(new String[] { "version" }, ) + "=?", new Object[] { str, f, integer, g });
/*     */     }
/* 279 */     catch (SQLException sQLException) {
/* 280 */       throw new org.c.a.b.f.b("Unable to repair Schema History table " + this.b + " for version " + g, sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\p\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */