/*     */ package org.c.a.b.e.d;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.c.a.b.e.a.b;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends d<b>
/*     */ {
/*     */   public c(d paramd, b paramb, String paramString) {
/*  40 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  45 */     return (this.a.b("SELECT COUNT (*) FROM sys.sysschemas WHERE schemaname=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  50 */     return ((a()).length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  55 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  60 */     clean();
/*  61 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " RESTRICT", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  66 */     List<String> list1 = e("TRIGGER", "");
/*  67 */     for (String str : a("TRIGGER", list1, "")) {
/*  68 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  71 */     for (String str : aN()) {
/*  72 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  75 */     List<String> list2 = e("TABLE", "TABLETYPE='V'");
/*  76 */     for (String str : a("VIEW", list2, "")) {
/*  77 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  80 */     for (f f : a()) {
/*  81 */       f.drop();
/*     */     }
/*     */     
/*  84 */     List<String> list3 = e("SEQUENCE", "");
/*  85 */     for (String str : a("SEQUENCE", list3, "RESTRICT")) {
/*  86 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aN() throws SQLException {
/*  97 */     List list = this.a.a("SELECT c.constraintname, t.tablename FROM sys.sysconstraints c INNER JOIN sys.systables t ON c.tableid = t.tableid INNER JOIN sys.sysschemas s ON c.schemaid = s.schemaid WHERE c.type = 'F' AND s.schemaname = ?", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     ArrayList<String> arrayList = new ArrayList();
/* 103 */     for (Map map : list) {
/*     */       
/* 105 */       String str = "ALTER TABLE " + ((b)this.a).d(new String[] { this.name, (String)map.get("TABLENAME") }) + " DROP CONSTRAINT " + ((b)this.a).d(new String[] { (String)map.get("CONSTRAINTNAME") });
/*     */       
/* 107 */       arrayList.add(str);
/*     */     } 
/* 109 */     return arrayList;
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
/*     */   private List<String> a(String paramString1, List<String> paramList, String paramString2) {
/* 121 */     ArrayList<String> arrayList = new ArrayList();
/* 122 */     for (String str1 : paramList) {
/*     */       
/* 124 */       String str2 = "DROP " + paramString1 + " " + ((b)this.a).d(new String[] { this.name, str1 }) + " " + paramString2;
/*     */       
/* 126 */       arrayList.add(str2);
/*     */     } 
/* 128 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 133 */     List<String> list = e("TABLE", "TABLETYPE='T'");
/*     */     
/* 135 */     f[] arrayOfF = new f[list.size()];
/* 136 */     for (byte b = 0; b < list.size(); b++) {
/* 137 */       arrayOfF[b] = new e(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 139 */     return arrayOfF;
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
/*     */   private List<String> e(String paramString1, String paramString2) throws SQLException {
/* 151 */     String str = "SELECT " + paramString1 + "name FROM sys.sys" + paramString1 + "s WHERE schemaid in (SELECT schemaid FROM sys.sysschemas where schemaname = ?)";
/* 152 */     if (n.W(paramString2)) {
/* 153 */       str = str + " AND " + paramString2;
/*     */     }
/*     */     
/* 156 */     return this.a.a(str, new String[] { this.name });
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 161 */     return new e(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */