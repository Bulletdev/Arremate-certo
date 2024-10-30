/*     */ package org.c.a.b.e.h;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
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
/*     */ public class d
/*     */   extends d<b>
/*     */ {
/*     */   d(org.c.a.b.h.d paramd, b paramb, String paramString) {
/*  39 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  44 */     return (this.a.b("SELECT (SELECT 1 FROM information_schema.schemata WHERE schema_name=? LIMIT 1)", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  49 */     return (this.a.b("SELECT SUM(found) FROM ((SELECT 1 as found FROM information_schema.tables WHERE table_schema=?) UNION ALL (SELECT 1 as found FROM information_schema.views WHERE table_schema=? LIMIT 1) UNION ALL (SELECT 1 as found FROM information_schema.table_constraints WHERE table_schema=? LIMIT 1) UNION ALL (SELECT 1 as found FROM information_schema.events WHERE event_schema=? LIMIT 1) UNION ALL (SELECT 1 as found FROM information_schema.triggers WHERE trigger_schema=? LIMIT 1) UNION ALL (SELECT 1 as found FROM information_schema.routines WHERE routine_schema=? LIMIT 1)) as all_found", new String[] { this.name, this.name, this.name, this.name, this.name, this.name }) == 0);
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
/*     */   protected void hY() throws SQLException {
/*  63 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  68 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  73 */     for (String str : aO()) {
/*  74 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  77 */     for (String str : aP()) {
/*  78 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  81 */     for (String str : aQ()) {
/*  82 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  85 */     this.a.a("SET FOREIGN_KEY_CHECKS = 0", new Object[0]);
/*  86 */     for (f f : a()) {
/*  87 */       f.drop();
/*     */     }
/*  89 */     this.a.a("SET FOREIGN_KEY_CHECKS = 1", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aO() throws SQLException {
/* 100 */     List list = this.a.a("SELECT event_name FROM information_schema.events WHERE event_schema=?", new String[] { this.name });
/*     */ 
/*     */ 
/*     */     
/* 104 */     ArrayList<String> arrayList = new ArrayList();
/* 105 */     for (String str : list) {
/* 106 */       arrayList.add("DROP EVENT " + ((b)this.a).d(new String[] { this.name, str }));
/*     */     } 
/* 108 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aP() throws SQLException {
/* 119 */     List list = this.a.a("SELECT routine_name as 'N', routine_type as 'T' FROM information_schema.routines WHERE routine_schema=?", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */     
/* 123 */     ArrayList<String> arrayList = new ArrayList();
/* 124 */     for (Map map : list) {
/* 125 */       String str1 = (String)map.get("N");
/* 126 */       String str2 = (String)map.get("T");
/* 127 */       arrayList.add("DROP " + str2 + " " + ((b)this.a).d(new String[] { this.name, str1 }));
/*     */     } 
/* 129 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aQ() throws SQLException {
/* 140 */     List list = this.a.a("SELECT table_name FROM information_schema.views WHERE table_schema=?", new String[] { this.name });
/*     */ 
/*     */     
/* 143 */     ArrayList<String> arrayList = new ArrayList();
/* 144 */     for (String str : list) {
/* 145 */       arrayList.add("DROP VIEW " + ((b)this.a).d(new String[] { this.name, str }));
/*     */     } 
/* 147 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 152 */     List<String> list = this.a.a("SELECT table_name FROM information_schema.tables WHERE table_schema=? AND table_type='BASE TABLE'", new String[] { this.name });
/*     */ 
/*     */     
/* 155 */     f[] arrayOfF = new f[list.size()];
/* 156 */     for (byte b = 0; b < list.size(); b++) {
/* 157 */       arrayOfF[b] = new g(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 159 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 164 */     return new g(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\h\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */