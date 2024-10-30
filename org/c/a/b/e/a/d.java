/*     */ package org.c.a.b.e.a;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.h.e;
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
/*     */ public abstract class d<D extends b>
/*     */ {
/*     */   protected final org.c.a.b.h.d a;
/*     */   protected final D a;
/*     */   protected final String name;
/*     */   
/*     */   public d(org.c.a.b.h.d paramd, D paramD, String paramString) {
/*  54 */     this.a = (D)paramd;
/*  55 */     this.a = paramD;
/*  56 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  63 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*     */     try {
/*  73 */       return fB();
/*  74 */     } catch (SQLException sQLException) {
/*  75 */       throw new b("Unable to check whether schema " + this + " exists", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean fB() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean empty() {
/*     */     try {
/*  94 */       return fC();
/*  95 */     } catch (SQLException sQLException) {
/*  96 */       throw new b("Unable to check whether schema " + this + " is empty", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean fC() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hS() {
/*     */     try {
/* 113 */       hY();
/* 114 */     } catch (SQLException sQLException) {
/* 115 */       throw new b("Unable to create schema " + this, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void hY() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drop() {
/*     */     try {
/* 131 */       hZ();
/* 132 */     } catch (SQLException sQLException) {
/* 133 */       throw new b("Unable to drop schema " + this, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void hZ() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clean() {
/*     */     try {
/* 149 */       ia();
/* 150 */     } catch (SQLException sQLException) {
/* 151 */       throw new b("Unable to clean schema " + this, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void ia() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f[] a() {
/*     */     try {
/* 169 */       return b();
/* 170 */     } catch (SQLException sQLException) {
/* 171 */       throw new b("Unable to retrieve all tables in schema " + this, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract f[] b() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final g[] a() {
/* 189 */     ResultSet resultSet = null;
/*     */     try {
/* 191 */       resultSet = ((b)this.a).a.getUDTs(null, this.name, null, null);
/*     */       
/* 193 */       ArrayList<g> arrayList = new ArrayList();
/* 194 */       while (resultSet.next()) {
/* 195 */         arrayList.add(a(resultSet.getString("TYPE_NAME")));
/*     */       }
/*     */       
/* 198 */       return arrayList.<g>toArray(new g[0]);
/* 199 */     } catch (SQLException sQLException) {
/* 200 */       throw new b("Unable to retrieve all types in schema " + this, sQLException);
/*     */     } finally {
/* 202 */       e.a(resultSet);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected g a(String paramString) {
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract f a(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c a(String paramString, String... paramVarArgs) {
/* 231 */     throw new UnsupportedOperationException("getFunction()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final c[] a() {
/*     */     try {
/* 241 */       return b();
/* 242 */     } catch (SQLException sQLException) {
/* 243 */       throw new b("Unable to retrieve all functions in schema " + this, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected c[] b() throws SQLException {
/* 254 */     return new c[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     return this.a.d(new String[] { this.name });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 267 */     if (this == paramObject) return true; 
/* 268 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 270 */     d d1 = (d)paramObject;
/* 271 */     return this.name.equals(d1.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 276 */     return this.name.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */