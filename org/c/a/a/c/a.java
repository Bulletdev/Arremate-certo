/*      */ package org.c.a.a.c;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.OutputStream;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import javax.sql.DataSource;
/*      */ import org.c.a.a.b;
/*      */ import org.c.a.a.b.b;
/*      */ import org.c.a.a.b.f;
/*      */ import org.c.a.a.d.c;
/*      */ import org.c.a.a.f.c;
/*      */ import org.c.a.a.g;
/*      */ import org.c.a.a.h.c;
/*      */ import org.c.a.b.a.c;
/*      */ import org.c.a.b.h.b;
/*      */ import org.c.a.b.i.c;
/*      */ import org.c.a.b.r.d;
/*      */ import org.c.a.b.r.j;
/*      */ import org.c.a.b.r.n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */   implements b
/*      */ {
/*   57 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   85 */   private ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   97 */   private c[] a = (c[])new j(new String[] { "db/migration" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  102 */   private Charset encoding = Charset.forName("UTF-8");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  115 */   private String[] j = new String[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  123 */   private String table = "flyway_schema_history";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean cj = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  139 */   private Map<String, String> aq = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  144 */   private String jN = "${";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  149 */   private String jO = "}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  157 */   private String jP = "V";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  176 */   private String jQ = "R";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  184 */   private String jR = "__";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  193 */   private String[] k = new String[] { ".sql" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean cn = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean co = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  271 */   private g e = g.a("1");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  276 */   private String jS = "<< Flyway Baseline >>";
/*      */ 
/*      */   
/*      */   private String driver;
/*      */ 
/*      */   
/*      */   private String url;
/*      */ 
/*      */   
/*      */   private String user;
/*      */ 
/*      */   
/*      */   private String password;
/*      */ 
/*      */   
/*      */   private DataSource a;
/*      */ 
/*      */   
/*      */   private int iC;
/*      */   
/*      */   private String jM;
/*      */   
/*      */   private j a;
/*      */   
/*      */   private g d;
/*      */   
/*      */   private boolean ck;
/*      */   
/*      */   private boolean cl;
/*      */   
/*  306 */   private final List<b> ai = new ArrayList<>(); private boolean cm;
/*      */   private boolean cp;
/*      */   private boolean cq;
/*      */   private boolean cr;
/*      */   private boolean cs;
/*      */   private boolean ct;
/*      */   private boolean cu;
/*      */   private boolean cv;
/*      */   private boolean cw;
/*      */   private String jT;
/*      */   
/*      */   public a() {
/*  318 */     this.a = new c[0]; } public a(ClassLoader paramClassLoader) { this.a = new c[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  436 */     if (paramClassLoader != null) {
/*  437 */       this.classLoader = paramClassLoader;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a(b paramb) {
/*  447 */     this(paramb.getClassLoader());
/*  448 */     a(paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   public b[] a() {
/*  453 */     return (b[])this.a.bc().toArray((Object[])new b[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public Charset a() {
/*  458 */     return this.encoding;
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] l() {
/*  463 */     return this.j;
/*      */   }
/*      */ 
/*      */   
/*      */   public String ef() {
/*  468 */     return this.table;
/*      */   }
/*      */ 
/*      */   
/*      */   public g a() {
/*  473 */     return this.d;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean eY() {
/*  478 */     return this.cj;
/*      */   }
/*      */ 
/*      */   
/*      */   public Map<String, String> P() {
/*  483 */     return this.aq;
/*      */   }
/*      */ 
/*      */   
/*      */   public String eg() {
/*  488 */     return this.jN;
/*      */   }
/*      */ 
/*      */   
/*      */   public String eh() {
/*  493 */     return this.jO;
/*      */   }
/*      */ 
/*      */   
/*      */   public String ei() {
/*  498 */     return this.jP;
/*      */   }
/*      */ 
/*      */   
/*      */   public String ej() {
/*  503 */     return this.jQ;
/*      */   }
/*      */ 
/*      */   
/*      */   public String ek() {
/*  508 */     return this.jR;
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] m() {
/*  513 */     return this.k;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean eZ() {
/*  518 */     return this.ck;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fa() {
/*  523 */     return this.cl;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fb() {
/*  528 */     return this.cm;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fc() {
/*  533 */     return this.cn;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fd() {
/*  538 */     return this.co;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fe() {
/*  543 */     return this.cp;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean ff() {
/*  548 */     return this.cq;
/*      */   }
/*      */ 
/*      */   
/*      */   public g b() {
/*  553 */     return this.e;
/*      */   }
/*      */ 
/*      */   
/*      */   public String em() {
/*  558 */     return this.jS;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fg() {
/*  563 */     return this.cr;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fh() {
/*  568 */     return this.cs;
/*      */   }
/*      */ 
/*      */   
/*      */   public c[] a() {
/*  573 */     return this.a;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fi() {
/*  578 */     return this.cu;
/*      */   }
/*      */ 
/*      */   
/*      */   public DataSource a() {
/*  583 */     if (this.a == null && (
/*  584 */       n.W(this.driver) || n.W(this.user) || n.W(this.password))) {
/*  585 */       a.warn("Discarding INCOMPLETE dataSource configuration! flyway.url must be set.");
/*      */     }
/*  587 */     return (DataSource)this.a;
/*      */   }
/*      */ 
/*      */   
/*      */   public int bK() {
/*  592 */     return this.iC;
/*      */   }
/*      */ 
/*      */   
/*      */   public String en() {
/*  597 */     return this.jM;
/*      */   }
/*      */ 
/*      */   
/*      */   public ClassLoader getClassLoader() {
/*  602 */     return this.classLoader;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fj() {
/*  607 */     return this.cv;
/*      */   }
/*      */ 
/*      */   
/*      */   public String eo() {
/*  612 */     return this.jT;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fk() {
/*  617 */     return this.cw;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public c[] a() {
/*  623 */     throw new c("errorHandlers");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] n() {
/*  633 */     throw new c("errorOverrides");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStream d() {
/*  643 */     throw new c("dryRunOutput");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String ep() {
/*  653 */     throw new c("licenseKey");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void b(ClassLoader paramClassLoader) {
/*  668 */     a.warn("setClassLoader() is deprecated and will be removed in Flyway 6.0. Use new ClassicConfiguration(ClassLoader) instead.");
/*  669 */     this.classLoader = paramClassLoader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(OutputStream paramOutputStream) {
/*  681 */     throw new c("dryRunOutput");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(File paramFile) {
/*  698 */     throw new c("dryRunOutput");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bl(String paramString) {
/*  750 */     throw new c("dryRunOutput");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(c... paramVarArgs) {
/*  770 */     throw new c("errorHandlers");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(String... paramVarArgs) {
/*  792 */     throw new c("errorHandlers");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(String... paramVarArgs) {
/*  827 */     throw new c("errorOverrides");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void au(boolean paramBoolean) {
/*  840 */     this.cw = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bm(String paramString) {
/*  849 */     if ("".equals(paramString)) {
/*  850 */       paramString = null;
/*      */     }
/*  852 */     this.jT = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMixed(boolean paramBoolean) {
/*  861 */     this.cv = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void av(boolean paramBoolean) {
/*  878 */     this.ck = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aw(boolean paramBoolean) {
/*  895 */     this.cl = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aL(boolean paramBoolean) {
/*  908 */     this.cm = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ax(boolean paramBoolean) {
/*  923 */     this.cn = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ay(boolean paramBoolean) {
/*  932 */     this.co = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void az(boolean paramBoolean) {
/*  946 */     this.cp = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aA(boolean paramBoolean) {
/*  956 */     this.cq = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void h(String... paramVarArgs) {
/*  970 */     this.a = (c[])new j(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(b... paramVarArgs) {
/*  984 */     this.a = (c[])new j(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(Charset paramCharset) {
/*  993 */     this.encoding = paramCharset;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bz(String paramString) {
/* 1002 */     this.encoding = Charset.forName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void d(String... paramVarArgs) {
/* 1019 */     this.j = paramVarArgs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bn(String paramString) {
/* 1031 */     this.table = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(g paramg) {
/* 1041 */     this.d = paramg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bo(String paramString) {
/* 1053 */     this.d = g.a(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aB(boolean paramBoolean) {
/* 1062 */     this.cj = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void h(Map<String, String> paramMap) {
/* 1071 */     this.aq = paramMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bp(String paramString) {
/* 1080 */     if (!n.W(paramString)) {
/* 1081 */       throw new org.c.a.a.a("placeholderPrefix cannot be empty!");
/*      */     }
/* 1083 */     this.jN = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bq(String paramString) {
/* 1092 */     if (!n.W(paramString)) {
/* 1093 */       throw new org.c.a.a.a("placeholderSuffix cannot be empty!");
/*      */     }
/* 1095 */     this.jO = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void br(String paramString) {
/* 1106 */     this.jP = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String eq() {
/* 1112 */     throw new c("undoSqlMigrationPrefix");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bs(String paramString) {
/* 1130 */     throw new c("undoSqlMigrationPrefix");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStream() {
/* 1140 */     throw new c("stream");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aG(boolean paramBoolean) {
/* 1157 */     throw new c("stream");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean fl() {
/* 1167 */     throw new c("batch");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aH(boolean paramBoolean) {
/* 1186 */     throw new c("batch");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bt(String paramString) {
/* 1201 */     this.jQ = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bu(String paramString) {
/* 1212 */     if (!n.W(paramString)) {
/* 1213 */       throw new org.c.a.a.a("sqlMigrationSeparator cannot be empty!");
/*      */     }
/*      */     
/* 1216 */     this.jR = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void e(String... paramVarArgs) {
/* 1229 */     this.k = paramVarArgs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(DataSource paramDataSource) {
/* 1238 */     this.driver = null;
/* 1239 */     this.url = null;
/* 1240 */     this.user = null;
/* 1241 */     this.password = null;
/* 1242 */     this.a = (c[])paramDataSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(String paramString1, String paramString2, String paramString3) {
/* 1254 */     this.a = (c[])new b(this.classLoader, null, paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(String paramString1, String paramString2, String paramString3, String... paramVarArgs) {
/* 1269 */     this.a = (c[])new b(this.classLoader, null, paramString1, paramString2, paramString3);
/* 1270 */     bA((paramVarArgs == null) ? null : n.a(Arrays.asList(paramVarArgs), "\n"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void br(int paramInt) {
/* 1280 */     if (paramInt < 0) {
/* 1281 */       throw new org.c.a.a.a("Invalid number of connectRetries (must be 0 or greater): " + paramInt);
/*      */     }
/* 1283 */     this.iC = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bA(String paramString) {
/* 1292 */     this.jM = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(g paramg) {
/* 1301 */     this.e = paramg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bw(String paramString) {
/* 1310 */     this.e = g.a(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bx(String paramString) {
/* 1319 */     this.jS = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aC(boolean paramBoolean) {
/* 1339 */     this.cr = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aD(boolean paramBoolean) {
/* 1350 */     this.cs = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b[] a() {
/* 1360 */     return this.ai.<b>toArray(new b[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean fn() {
/* 1365 */     return this.ct;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(b... paramVarArgs) {
/* 1374 */     this.ai.clear();
/* 1375 */     this.ai.addAll(Arrays.asList(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void f(String... paramVarArgs) {
/* 1384 */     this.ai.clear();
/* 1385 */     for (String str : paramVarArgs) {
/* 1386 */       Object object = d.a(str, this.classLoader);
/* 1387 */       if (object instanceof b) {
/* 1388 */         this.ai.add((b)object);
/* 1389 */       } else if (object instanceof f) {
/* 1390 */         this.ai.add(new c((f)object));
/*      */       } else {
/* 1392 */         throw new org.c.a.a.a("Invalid callback: " + str + " (" + object.getClass().getName() + ")");
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aE(boolean paramBoolean) {
/* 1403 */     this.ct = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(c... paramVarArgs) {
/* 1412 */     this.a = paramVarArgs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void g(String... paramVarArgs) {
/* 1421 */     List list = d.a(paramVarArgs, this.classLoader);
/* 1422 */     a((c[])list.toArray((Object[])new c[paramVarArgs.length]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aF(boolean paramBoolean) {
/* 1431 */     this.cu = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean fm() {
/* 1446 */     throw new c("oracle.sqlplus");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aI(boolean paramBoolean) {
/* 1461 */     throw new c("oracle.sqlplus");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void by(String paramString) {
/* 1477 */     throw new c("licenseKey");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(b paramb) {
/* 1490 */     bx(paramb.em());
/* 1491 */     aC(paramb.fg());
/* 1492 */     b(paramb.b());
/* 1493 */     a(paramb.a());
/* 1494 */     aA(paramb.ff());
/* 1495 */     az(paramb.fe());
/* 1496 */     a(paramb.a());
/* 1497 */     br(paramb.bK());
/* 1498 */     bA(paramb.en());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1514 */     b(paramb.a());
/* 1515 */     au(paramb.fk());
/* 1516 */     ax(paramb.fc());
/* 1517 */     av(paramb.eZ());
/* 1518 */     aw(paramb.fa());
/* 1519 */     aL(paramb.fb());
/* 1520 */     bm(paramb.eo());
/* 1521 */     a(paramb.a());
/* 1522 */     setMixed(paramb.fj());
/* 1523 */     aD(paramb.fh());
/* 1524 */     bp(paramb.eg());
/* 1525 */     aB(paramb.eY());
/* 1526 */     h(paramb.P());
/* 1527 */     bq(paramb.eh());
/* 1528 */     bt(paramb.ej());
/* 1529 */     a(paramb.a());
/* 1530 */     d(paramb.l());
/* 1531 */     aE(paramb.fn());
/* 1532 */     aF(paramb.fi());
/* 1533 */     br(paramb.ei());
/* 1534 */     bu(paramb.ek());
/* 1535 */     e(paramb.m());
/* 1536 */     bn(paramb.ef());
/* 1537 */     a(paramb.a());
/* 1538 */     ay(paramb.fd());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(Properties paramProperties) {
/* 1551 */     i(org.c.a.b.d.a.a(paramProperties));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void i(Map<String, String> paramMap) {
/* 1564 */     paramMap = new HashMap<>(paramMap);
/*      */     
/* 1566 */     String str1 = paramMap.remove("flyway.driver");
/* 1567 */     if (str1 != null) {
/* 1568 */       this.a = null;
/* 1569 */       this.driver = str1;
/*      */     } 
/* 1571 */     String str2 = paramMap.remove("flyway.url");
/* 1572 */     if (str2 != null) {
/* 1573 */       this.a = null;
/* 1574 */       this.url = str2;
/*      */     } 
/* 1576 */     String str3 = paramMap.remove("flyway.user");
/* 1577 */     if (str3 != null) {
/* 1578 */       this.a = null;
/* 1579 */       this.user = str3;
/*      */     } 
/* 1581 */     String str4 = paramMap.remove("flyway.password");
/* 1582 */     if (str4 != null) {
/* 1583 */       this.a = null;
/* 1584 */       this.password = str4;
/*      */     } 
/* 1586 */     if (n.X(this.url) && (n.X(str2) || 
/* 1587 */       n.X(str1) || n.X(str3) || n.X(str4))) {
/* 1588 */       a((DataSource)new b(this.classLoader, this.driver, this.url, this.user, this.password));
/*      */     }
/* 1590 */     Integer integer = a(paramMap, "flyway.connectRetries");
/* 1591 */     if (integer != null) {
/* 1592 */       br(integer.intValue());
/*      */     }
/* 1594 */     String str5 = paramMap.remove("flyway.initSql");
/* 1595 */     if (str5 != null) {
/* 1596 */       bA(str5);
/*      */     }
/* 1598 */     String str6 = paramMap.remove("flyway.locations");
/* 1599 */     if (str6 != null) {
/* 1600 */       h(n.a(str6, ","));
/*      */     }
/* 1602 */     Boolean bool1 = a(paramMap, "flyway.placeholderReplacement");
/* 1603 */     if (bool1 != null) {
/* 1604 */       aB(bool1.booleanValue());
/*      */     }
/* 1606 */     String str7 = paramMap.remove("flyway.placeholderPrefix");
/* 1607 */     if (str7 != null) {
/* 1608 */       bp(str7);
/*      */     }
/* 1610 */     String str8 = paramMap.remove("flyway.placeholderSuffix");
/* 1611 */     if (str8 != null) {
/* 1612 */       bq(str8);
/*      */     }
/* 1614 */     String str9 = paramMap.remove("flyway.sqlMigrationPrefix");
/* 1615 */     if (str9 != null) {
/* 1616 */       br(str9);
/*      */     }
/* 1618 */     String str10 = paramMap.remove("flyway.undoSqlMigrationPrefix");
/* 1619 */     if (str10 != null) {
/* 1620 */       bs(str10);
/*      */     }
/* 1622 */     String str11 = paramMap.remove("flyway.repeatableSqlMigrationPrefix");
/* 1623 */     if (str11 != null) {
/* 1624 */       bt(str11);
/*      */     }
/* 1626 */     String str12 = paramMap.remove("flyway.sqlMigrationSeparator");
/* 1627 */     if (str12 != null) {
/* 1628 */       bu(str12);
/*      */     }
/* 1630 */     String str13 = paramMap.remove("flyway.sqlMigrationSuffix");
/* 1631 */     if (str13 != null) {
/* 1632 */       e(new String[] { str13 });
/*      */     }
/* 1634 */     String str14 = paramMap.remove("flyway.sqlMigrationSuffixes");
/* 1635 */     if (str14 != null) {
/* 1636 */       e(n.a(str14, ","));
/*      */     }
/* 1638 */     String str15 = paramMap.remove("flyway.encoding");
/* 1639 */     if (str15 != null) {
/* 1640 */       bz(str15);
/*      */     }
/* 1642 */     String str16 = paramMap.remove("flyway.schemas");
/* 1643 */     if (str16 != null) {
/* 1644 */       d(n.a(str16, ","));
/*      */     }
/* 1646 */     String str17 = paramMap.remove("flyway.table");
/* 1647 */     if (str17 != null) {
/* 1648 */       bn(str17);
/*      */     }
/* 1650 */     Boolean bool2 = a(paramMap, "flyway.cleanOnValidationError");
/* 1651 */     if (bool2 != null) {
/* 1652 */       az(bool2.booleanValue());
/*      */     }
/* 1654 */     Boolean bool3 = a(paramMap, "flyway.cleanDisabled");
/* 1655 */     if (bool3 != null) {
/* 1656 */       aA(bool3.booleanValue());
/*      */     }
/* 1658 */     Boolean bool4 = a(paramMap, "flyway.validateOnMigrate");
/* 1659 */     if (bool4 != null) {
/* 1660 */       ay(bool4.booleanValue());
/*      */     }
/* 1662 */     String str18 = paramMap.remove("flyway.baselineVersion");
/* 1663 */     if (str18 != null) {
/* 1664 */       b(g.a(str18));
/*      */     }
/* 1666 */     String str19 = paramMap.remove("flyway.baselineDescription");
/* 1667 */     if (str19 != null) {
/* 1668 */       bx(str19);
/*      */     }
/* 1670 */     Boolean bool5 = a(paramMap, "flyway.baselineOnMigrate");
/* 1671 */     if (bool5 != null) {
/* 1672 */       aC(bool5.booleanValue());
/*      */     }
/* 1674 */     Boolean bool6 = a(paramMap, "flyway.ignoreMissingMigrations");
/* 1675 */     if (bool6 != null) {
/* 1676 */       av(bool6.booleanValue());
/*      */     }
/* 1678 */     Boolean bool7 = a(paramMap, "flyway.ignoreIgnoredMigrations");
/* 1679 */     if (bool7 != null) {
/* 1680 */       aw(bool7.booleanValue());
/*      */     }
/* 1682 */     Boolean bool8 = a(paramMap, "flyway.ignorePendingMigrations");
/* 1683 */     if (bool8 != null) {
/* 1684 */       aL(bool8.booleanValue());
/*      */     }
/* 1686 */     Boolean bool9 = a(paramMap, "flyway.ignoreFutureMigrations");
/* 1687 */     if (bool9 != null) {
/* 1688 */       ax(bool9.booleanValue());
/*      */     }
/* 1690 */     String str20 = paramMap.remove("flyway.target");
/* 1691 */     if (str20 != null) {
/* 1692 */       a(g.a(str20));
/*      */     }
/* 1694 */     Boolean bool10 = a(paramMap, "flyway.outOfOrder");
/* 1695 */     if (bool10 != null) {
/* 1696 */       aD(bool10.booleanValue());
/*      */     }
/* 1698 */     String str21 = paramMap.remove("flyway.resolvers");
/* 1699 */     if (n.W(str21)) {
/* 1700 */       g(n.a(str21, ","));
/*      */     }
/* 1702 */     Boolean bool11 = a(paramMap, "flyway.skipDefaultResolvers");
/* 1703 */     if (bool11 != null) {
/* 1704 */       aF(bool11.booleanValue());
/*      */     }
/* 1706 */     String str22 = paramMap.remove("flyway.callbacks");
/* 1707 */     if (n.W(str22)) {
/* 1708 */       f(n.a(str22, ","));
/*      */     }
/* 1710 */     Boolean bool12 = a(paramMap, "flyway.skipDefaultCallbacks");
/* 1711 */     if (bool12 != null) {
/* 1712 */       aE(bool12.booleanValue());
/*      */     }
/*      */     
/* 1715 */     HashMap<String, String> hashMap = new HashMap<>(P());
/* 1716 */     Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
/* 1717 */     while (iterator.hasNext()) {
/* 1718 */       Map.Entry entry = iterator.next();
/* 1719 */       String str = (String)entry.getKey();
/*      */       
/* 1721 */       if (str.startsWith("flyway.placeholders.") && str
/* 1722 */         .length() > "flyway.placeholders.".length()) {
/* 1723 */         String str28 = str.substring("flyway.placeholders.".length());
/* 1724 */         String str29 = (String)entry.getValue();
/* 1725 */         hashMap.put(str28, str29);
/* 1726 */         iterator.remove();
/*      */       } 
/*      */     } 
/* 1729 */     h(hashMap);
/*      */     
/* 1731 */     Boolean bool13 = a(paramMap, "flyway.mixed");
/* 1732 */     if (bool13 != null) {
/* 1733 */       setMixed(bool13.booleanValue());
/*      */     }
/*      */     
/* 1736 */     Boolean bool14 = a(paramMap, "flyway.group");
/* 1737 */     if (bool14 != null) {
/* 1738 */       au(bool14.booleanValue());
/*      */     }
/*      */     
/* 1741 */     String str23 = paramMap.remove("flyway.installedBy");
/* 1742 */     if (str23 != null) {
/* 1743 */       bm(str23);
/*      */     }
/*      */     
/* 1746 */     String str24 = paramMap.remove("flyway.dryRunOutput");
/* 1747 */     if (str24 != null) {
/* 1748 */       bl(str24);
/*      */     }
/*      */     
/* 1751 */     String str25 = paramMap.remove("flyway.errorHandlers");
/* 1752 */     if (str25 != null) {
/* 1753 */       a(n.a(str25, ","));
/*      */     }
/*      */     
/* 1756 */     String str26 = paramMap.remove("flyway.errorOverrides");
/* 1757 */     if (str26 != null) {
/* 1758 */       b(n.a(str26, ","));
/*      */     }
/*      */     
/* 1761 */     Boolean bool15 = a(paramMap, "flyway.stream");
/* 1762 */     if (bool15 != null) {
/* 1763 */       aG(bool15.booleanValue());
/*      */     }
/*      */     
/* 1766 */     Boolean bool16 = a(paramMap, "flyway.batch");
/* 1767 */     if (bool16 != null) {
/* 1768 */       aH(bool16.booleanValue());
/*      */     }
/*      */     
/* 1771 */     Boolean bool17 = a(paramMap, "flyway.oracle.sqlplus");
/* 1772 */     if (bool17 != null) {
/* 1773 */       aI(bool17.booleanValue());
/*      */     }
/*      */     
/* 1776 */     String str27 = paramMap.remove("flyway.licenseKey");
/* 1777 */     if (str27 != null) {
/* 1778 */       by(str27);
/*      */     }
/*      */     
/* 1781 */     for (String str : paramMap.keySet()) {
/* 1782 */       if (str.startsWith("flyway.")) {
/* 1783 */         throw new org.c.a.a.a("Unknown configuration property: " + str);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private Boolean a(Map<String, String> paramMap, String paramString) {
/* 1789 */     String str = paramMap.remove(paramString);
/* 1790 */     if (str != null && !"true".equals(str) && !"false".equals(str)) {
/* 1791 */       throw new org.c.a.a.a("Invalid value for " + paramString + " (should be either true or false): " + str);
/*      */     }
/* 1793 */     return (str == null) ? null : Boolean.valueOf(str);
/*      */   }
/*      */   
/*      */   private Integer a(Map<String, String> paramMap, String paramString) {
/* 1797 */     String str = paramMap.remove(paramString);
/* 1798 */     if (str == null) {
/* 1799 */       return null;
/*      */     }
/*      */     try {
/* 1802 */       return Integer.valueOf(str);
/* 1803 */     } catch (NumberFormatException numberFormatException) {
/* 1804 */       throw new org.c.a.a.a("Invalid value for " + paramString + " (should be a positive integer): " + str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void hR() {
/* 1812 */     i(org.c.a.b.d.a.Q());
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */