/*     */ package org.c.a.b.e.i;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.q.h;
/*     */ import org.c.a.b.q.k;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   private static final String la = "oracle.net.tns_admin";
/*     */   
/*     */   public static void id() {
/*  51 */     String str1 = System.getenv("TNS_ADMIN");
/*  52 */     String str2 = System.getProperty("oracle.net.tns_admin");
/*  53 */     if (n.W(str1) && str2 == null) {
/*  54 */       System.setProperty("oracle.net.tns_admin", str1);
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
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  76 */     super(paramb, paramConnection, paramBoolean);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private String eE() throws SQLException {
/*  94 */     String str = a().getURL();
/*  95 */     if (str == null) {
/*  96 */       return "";
/*     */     }
/*  98 */     return str.substring(str.indexOf("//") + 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected a a(Connection paramConnection) {
/* 107 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/* 116 */     l("Oracle", "10");
/*     */     
/* 118 */     d("Oracle", "Oracle", "12.2");
/*     */     
/* 120 */     m("Oracle", "18.0");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/* 130 */     return (k)new g(paramc);
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
/*     */   public h a(d paramd) {
/* 144 */     return (h)new e(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected c a(boolean paramBoolean, Map<String, String> paramMap, String paramString1, String paramString2) {
/* 155 */     return super.a(paramBoolean, paramMap, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ez() {
/* 166 */     return "oracle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 171 */     return ((a)a()).a().b("SELECT USER FROM DUAL", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 186 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 191 */     return "0";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 196 */     return "\"" + paramString + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 201 */     return false;
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
/*     */   boolean a(String paramString, String... paramVarArgs) throws SQLException {
/* 216 */     return ((a)a()).a().b("SELECT CASE WHEN EXISTS(" + paramString + ") THEN 1 ELSE 0 END FROM DUAL", paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean O(String paramString) throws SQLException {
/* 226 */     return a("SELECT 1 FROM SESSION_PRIVS WHERE PRIVILEGE = ? UNION ALL SELECT 1 FROM SESSION_ROLES WHERE ROLE = ?", new String[] { paramString, paramString });
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
/*     */   private boolean h(String paramString1, String paramString2) throws SQLException {
/* 240 */     return a("SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ? AND PRIVILEGE = 'SELECT'", new String[] { paramString1, paramString2 });
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
/*     */   boolean P(String paramString) throws SQLException {
/* 252 */     return h("SYS", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String aR(String paramString) throws SQLException {
/* 263 */     return (O("SELECT ANY DICTIONARY") || P("DBA_" + paramString)) ? (
/* 264 */       "DBA_" + paramString) : (
/* 265 */       "ALL_" + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> I() throws SQLException {
/* 275 */     return new HashSet<>(((a)a()).a()
/* 276 */         .a("SELECT PARAMETER FROM V$OPTION WHERE VALUE = 'TRUE'", new String[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fH() throws SQLException {
/* 286 */     return I().contains("Flashback Data Archive");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fI() throws SQLException {
/* 296 */     return P("ALL_XML_TABLES");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fJ() throws SQLException {
/* 306 */     return I().contains("Data Mining");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fK() throws SQLException {
/* 316 */     return h("MDSYS", "ALL_SDO_GEOM_METADATA");
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
/*     */   Set<String> J() throws SQLException {
/* 330 */     HashSet<String> hashSet = new HashSet(Arrays.asList((Object[])new String[] { "SYS", "SYSTEM", "SYSBACKUP", "SYSDG", "SYSKM", "SYSRAC", "SYS$UMF", "DBSNMP", "MGMT_VIEW", "SYSMAN", "OUTLN", "AUDSYS", "ORACLE_OCM", "APPQOSSYS", "OJVMSYS", "DVF", "DVSYS", "DBSFWUSER", "REMOTE_SCHEDULER_AGENT", "DIP", "APEX_PUBLIC_USER", "FLOWS_FILES", "ANONYMOUS", "XDB", "XS$NULL", "CTXSYS", "LBACSYS", "EXFSYS", "MDDATA", "MDSYS", "SPATIAL_CSW_ADMIN_USR", "SPATIAL_WFS_ADMIN_USR", "ORDDATA", "ORDPLUGINS", "ORDSYS", "SI_INFORMTN_SCHEMA", "WMSYS", "OLAPSYS", "OWBSYS", "OWBSYS_AUDIT", "GSMADMIN_INTERNAL", "GSMCATUSER", "GSMUSER", "GGSYS", "WK_TEST", "WKSYS", "WKPROXY", "ODM", "ODM_MTR", "DMSYS", "TSMSYS" }));
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
/* 365 */     hashSet.addAll(((a)a()).a().a("SELECT USERNAME FROM ALL_USERS WHERE REGEXP_LIKE(USERNAME, '^(APEX|FLOWS)_\\d+$') OR ORACLE_MAINTAINED = 'Y'", new String[0]));
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
/* 399 */     return hashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */