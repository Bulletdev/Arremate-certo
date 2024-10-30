/*      */ package org.c.a;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.OutputStream;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import javax.sql.DataSource;
/*      */ import org.c.a.a.a;
/*      */ import org.c.a.a.b;
/*      */ import org.c.a.a.b.b;
/*      */ import org.c.a.a.b.f;
/*      */ import org.c.a.a.c.a;
/*      */ import org.c.a.a.c.b;
/*      */ import org.c.a.a.c.d;
/*      */ import org.c.a.a.c.e;
/*      */ import org.c.a.a.d;
/*      */ import org.c.a.a.d.c;
/*      */ import org.c.a.a.f.a;
/*      */ import org.c.a.a.f.c;
/*      */ import org.c.a.a.g;
/*      */ import org.c.a.a.h.c;
/*      */ import org.c.a.b.a.a;
/*      */ import org.c.a.b.a.b;
/*      */ import org.c.a.b.a.c;
/*      */ import org.c.a.b.a.g;
/*      */ import org.c.a.b.b.a;
/*      */ import org.c.a.b.b.b;
/*      */ import org.c.a.b.c.a;
/*      */ import org.c.a.b.c.b;
/*      */ import org.c.a.b.c.c;
/*      */ import org.c.a.b.c.d;
/*      */ import org.c.a.b.c.e;
/*      */ import org.c.a.b.c.f;
/*      */ import org.c.a.b.c.g;
/*      */ import org.c.a.b.d.a;
/*      */ import org.c.a.b.e.a;
/*      */ import org.c.a.b.e.a.b;
/*      */ import org.c.a.b.e.a.d;
/*      */ import org.c.a.b.i.c;
/*      */ import org.c.a.b.i.d;
/*      */ import org.c.a.b.m.b;
/*      */ import org.c.a.b.n.c;
/*      */ import org.c.a.b.n.e;
/*      */ import org.c.a.b.o.a;
/*      */ import org.c.a.b.p.c;
/*      */ import org.c.a.b.p.d;
/*      */ import org.c.a.b.q.k;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */   implements b
/*      */ {
/*   86 */   private static final a a = c.b(a.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final a a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean cd;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static d a() {
/*  106 */     return new d();
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
/*      */   public static d a(ClassLoader paramClassLoader) {
/*  121 */     return new d(paramClassLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public a() {
/*  131 */     this.a = new a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public a(ClassLoader paramClassLoader) {
/*  142 */     this.a = new a(paramClassLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public a(e parame) {
/*  153 */     a.warn("The Flyway(FlywayConfiguration) constructor has been deprecated and will be removed in Flyway 6.0. Use Flyway(Configuration) instead.");
/*  154 */     this.a = new a((b)parame);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a(b paramb) {
/*  164 */     this.a = new a(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b a() {
/*  171 */     return (b)new a((b)this.a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public b[] a() {
/*  180 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  181 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Charset a() {
/*  190 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  191 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String[] l() {
/*  200 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  201 */     return this.a.l();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String ef() {
/*  210 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  211 */     return this.a.ef();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public g a() {
/*  220 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  221 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean eY() {
/*  230 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  231 */     return this.a.eY();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Map<String, String> P() {
/*  240 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  241 */     return this.a.P();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String eg() {
/*  250 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  251 */     return this.a.eg();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String eh() {
/*  260 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  261 */     return this.a.eh();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String ei() {
/*  270 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  271 */     return this.a.ei();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String ej() {
/*  280 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  281 */     return this.a.ej();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String ek() {
/*  290 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  291 */     return this.a.ek();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String el() {
/*  299 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  300 */     return this.a.m()[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String[] m() {
/*  309 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  310 */     return this.a.m();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean eZ() {
/*  319 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  320 */     return this.a.eZ();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fa() {
/*  329 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  330 */     return this.a.fa();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fb() {
/*  339 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  340 */     return this.a.fb();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fc() {
/*  349 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  350 */     return this.a.fc();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fd() {
/*  359 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  360 */     return this.a.fd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fe() {
/*  369 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  370 */     return this.a.fe();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean ff() {
/*  379 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  380 */     return this.a.ff();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public g b() {
/*  389 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  390 */     return this.a.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String em() {
/*  399 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  400 */     return this.a.em();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fg() {
/*  409 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  410 */     return this.a.fg();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fh() {
/*  419 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  420 */     return this.a.fh();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public c[] a() {
/*  429 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  430 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fi() {
/*  439 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  440 */     return this.a.fi();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public DataSource a() {
/*  449 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  450 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int bK() {
/*  459 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  460 */     return this.a.bK();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String en() {
/*  469 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  470 */     return this.a.en();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassLoader getClassLoader() {
/*  479 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  480 */     return this.a.getClassLoader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fj() {
/*  489 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  490 */     return this.a.fj();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String eo() {
/*  499 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  500 */     return this.a.eo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fk() {
/*  509 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  510 */     return this.a.fk();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public c[] a() {
/*  519 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  520 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String[] n() {
/*  529 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  530 */     return this.a.n();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public OutputStream d() {
/*  539 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  540 */     return this.a.d();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean isStream() {
/*  549 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  550 */     return this.a.isStream();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fl() {
/*  559 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  560 */     return this.a.fl();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fm() {
/*  569 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  570 */     return this.a.fm();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String ep() {
/*  579 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  580 */     return this.a.ep();
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
/*      */   @Deprecated
/*      */   public void a(OutputStream paramOutputStream) {
/*  593 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  594 */     this.a.a(paramOutputStream);
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
/*      */   @Deprecated
/*      */   public void c(File paramFile) {
/*  608 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  609 */     this.a.c(paramFile);
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
/*      */   public void bl(String paramString) {
/*  624 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  625 */     this.a.bl(paramString);
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
/*      */   public void a(c... paramVarArgs) {
/*  640 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  641 */     this.a.a(paramVarArgs);
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
/*      */   @Deprecated
/*      */   public void a(String... paramVarArgs) {
/*  657 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  658 */     this.a.a(paramVarArgs);
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
/*      */   @Deprecated
/*      */   public void b(String... paramVarArgs) {
/*  689 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  690 */     this.a.b(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void au(boolean paramBoolean) {
/*  701 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  702 */     this.a.au(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void bm(String paramString) {
/*  713 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  714 */     this.a.bm(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setMixed(boolean paramBoolean) {
/*  725 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  726 */     this.a.setMixed(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void av(boolean paramBoolean) {
/*  745 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  746 */     this.a.av(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void aw(boolean paramBoolean) {
/*  765 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  766 */     this.a.aw(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void ax(boolean paramBoolean) {
/*  783 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  784 */     this.a.ax(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void ay(boolean paramBoolean) {
/*  795 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  796 */     this.a.ay(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void az(boolean paramBoolean) {
/*  812 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  813 */     this.a.az(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void aA(boolean paramBoolean) {
/*  825 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  826 */     this.a.aA(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void c(String... paramVarArgs) {
/*  842 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  843 */     this.a.h(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setEncoding(String paramString) {
/*  854 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  855 */     this.a.bz(paramString);
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
/*      */   @Deprecated
/*      */   public void d(String... paramVarArgs) {
/*  874 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  875 */     this.a.d(paramVarArgs);
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
/*      */   @Deprecated
/*      */   public void bn(String paramString) {
/*  889 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  890 */     this.a.bn(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(g paramg) {
/*  902 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  903 */     this.a.a(paramg);
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
/*      */   @Deprecated
/*      */   public void bo(String paramString) {
/*  917 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  918 */     this.a.bo(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void aB(boolean paramBoolean) {
/*  929 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  930 */     this.a.aB(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void h(Map<String, String> paramMap) {
/*  941 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  942 */     this.a.h(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void bp(String paramString) {
/*  953 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  954 */     this.a.bp(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void bq(String paramString) {
/*  965 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  966 */     this.a.bq(paramString);
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
/*      */   @Deprecated
/*      */   public void br(String paramString) {
/*  979 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/*  980 */     this.a.br(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String eq() {
/*  989 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/*  990 */     return this.a.eq();
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
/*      */   public void bs(String paramString) {
/* 1005 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1006 */     this.a.bs(paramString);
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
/*      */   @Deprecated
/*      */   public void bt(String paramString) {
/* 1019 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1020 */     this.a.bt(paramString);
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
/*      */   @Deprecated
/*      */   public void bu(String paramString) {
/* 1033 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1034 */     this.a.bu(paramString);
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
/*      */   @Deprecated
/*      */   public void bv(String paramString) {
/* 1047 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1048 */     this.a.e(new String[] { paramString });
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
/*      */   public void e(String... paramVarArgs) {
/* 1063 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1064 */     this.a.e(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(DataSource paramDataSource) {
/* 1075 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1076 */     this.a.a(paramDataSource);
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
/* 1091 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1092 */     this.a.a(paramString1, paramString2, paramString3, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void b(ClassLoader paramClassLoader) {
/* 1103 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure(ClassLoader) instead.");
/* 1104 */     this.a.b(paramClassLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void b(g paramg) {
/* 1115 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1116 */     this.a.b(paramg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void bw(String paramString) {
/* 1127 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1128 */     this.a.bw(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void bx(String paramString) {
/* 1139 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1140 */     this.a.bx(paramString);
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
/*      */   public void aC(boolean paramBoolean) {
/* 1162 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1163 */     this.a.aC(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void aD(boolean paramBoolean) {
/* 1176 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1177 */     this.a.aD(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public b[] a() {
/* 1186 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/* 1187 */     return this.a.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean fn() {
/* 1196 */     a.warn("Direct configuration retrieval from the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.getConfiguration() instead.");
/* 1197 */     return this.a.fn();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(b... paramVarArgs) {
/* 1208 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1209 */     this.a.a(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(f... paramVarArgs) {
/* 1220 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1221 */     ArrayList<c> arrayList = new ArrayList();
/* 1222 */     for (f f1 : paramVarArgs) {
/* 1223 */       arrayList.add(new c(f1));
/*      */     }
/* 1225 */     this.a.a(arrayList.<b>toArray(new b[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void f(String... paramVarArgs) {
/* 1236 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1237 */     this.a.f(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void aE(boolean paramBoolean) {
/* 1248 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1249 */     this.a.aE(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void a(c... paramVarArgs) {
/* 1260 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1261 */     this.a.a(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void g(String... paramVarArgs) {
/* 1272 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1273 */     this.a.g(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void aF(boolean paramBoolean) {
/* 1284 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1285 */     this.a.aF(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void aG(boolean paramBoolean) {
/* 1299 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1300 */     this.a.aG(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void aH(boolean paramBoolean) {
/* 1316 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1317 */     this.a.aH(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void aI(boolean paramBoolean) {
/* 1329 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1330 */     this.a.aI(paramBoolean);
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
/*      */   @Deprecated
/*      */   public void by(String paramString) {
/* 1343 */     a.warn("Direct configuration of the Flyway object has been deprecated and will be removed in Flyway 6.0. Use Flyway.configure() instead.");
/* 1344 */     this.a.by(paramString);
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
/*      */   public int bL() throws a {
/* 1356 */     return ((Integer)a(new a<Integer>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public Integer a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1363 */             if (a.a(this.a).fd()) {
/* 1364 */               a.a(this.a, param1b, param1c, param1c1, param1ArrayOfd, param1a, true);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/* 1369 */             (new f(param1b, param1ArrayOfd, param1c1)).hS();
/*      */             
/* 1371 */             if (!param1c1.exists()) {
/* 1372 */               ArrayList<d> arrayList = new ArrayList();
/* 1373 */               for (d d1 : param1ArrayOfd) {
/* 1374 */                 if (!d1.empty()) {
/* 1375 */                   arrayList.add(d1);
/*      */                 }
/*      */               } 
/*      */               
/* 1379 */               if (!arrayList.isEmpty()) {
/* 1380 */                 if (a.a(this.a).fg()) {
/* 1381 */                   a.a(this.a, param1c1, param1b, param1ArrayOfd, param1a);
/*      */                 
/*      */                 }
/* 1384 */                 else if (!param1c1.exists()) {
/* 1385 */                   throw new a("Found non-empty schema(s) " + 
/* 1386 */                       n.b(arrayList) + " without schema history table! Use baseline() or set baselineOnMigrate to true to initialize the schema history table.");
/*      */                 } 
/*      */               }
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1394 */             return Integer.valueOf((new d(param1b, param1c1, param1ArrayOfd[0], param1c, (b)a.a(this.a), param1a))
/* 1395 */                 .bL());
/*      */           }
/*      */         }true)).intValue();
/*      */   }
/*      */   
/*      */   private void a(c paramc, b paramb, d[] paramArrayOfd, a parama) {
/* 1401 */     (new a(paramb, paramc, paramArrayOfd[0], this.a
/* 1402 */         .b(), this.a.em(), parama))
/* 1403 */       .hO();
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
/*      */   public int bM() throws a {
/* 1418 */     throw new c("undo");
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
/*      */   public void validate() throws a {
/* 1448 */     a(new a<Void>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public Void a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1455 */             a.a(this.a, param1b, param1c, param1c1, param1ArrayOfd, param1a, 
/* 1456 */                 a.a(this.a).fb());
/* 1457 */             return null;
/*      */           }
/*      */         }true);
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
/*      */   private void a(b paramb, c paramc, c paramc1, d[] paramArrayOfd, a parama, boolean paramBoolean) {
/* 1476 */     String str = (new g(paramb, paramc1, paramArrayOfd[0], paramc, (b)this.a, paramBoolean, parama)).ex();
/*      */     
/* 1478 */     if (str != null) {
/* 1479 */       if (this.a.fe()) {
/* 1480 */         a(paramb, paramc1, paramArrayOfd, parama);
/*      */       } else {
/* 1482 */         throw new a("Validate failed: " + str);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(b paramb, c paramc, d[] paramArrayOfd, a parama) {
/* 1488 */     (new b(paramb, paramc, paramArrayOfd, parama, this.a.ff())).clean();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clean() {
/* 1499 */     a(new a<Void>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public Void a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1506 */             a.a(this.a, param1b, param1c1, param1ArrayOfd, param1a);
/* 1507 */             return null;
/*      */           }
/*      */         }false);
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
/*      */   public d a() {
/* 1521 */     return a(new a<d>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public d a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1528 */             return (new c(param1c, param1c1, (b)a.a(this.a), param1a)).a();
/*      */           }
/*      */         }true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void hO() throws a {
/* 1541 */     a(new a<Void>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public Void a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1548 */             (new f(param1b, param1ArrayOfd, param1c1)).hS();
/* 1549 */             a.a(this.a, param1c1, param1b, param1ArrayOfd, param1a);
/* 1550 */             return null;
/*      */           }
/*      */         }false);
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
/*      */   public void hP() throws a {
/* 1566 */     a(new a<Void>(this)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public Void a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a)
/*      */           {
/* 1573 */             (new e(param1b, param1c, param1c1, param1a, (b)a.a(this.a))).hP();
/* 1574 */             return null;
/*      */           }
/*      */         }true);
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
/*      */   private c a(b paramb, e parame, a parama, k paramk) {
/* 1596 */     for (c c : this.a.a()) {
/* 1597 */       a.a(c, (b)this.a);
/*      */     }
/*      */     
/* 1600 */     return (c)new b(paramb, parame, parama, (b)this.a, paramk, this.a
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1606 */         .a());
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
/*      */   @Deprecated
/*      */   public void b(Properties paramProperties) {
/* 1620 */     i(a.a(paramProperties));
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
/*      */   @Deprecated
/*      */   public void i(Map<String, String> paramMap) {
/* 1634 */     this.a.i(paramMap);
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
/*      */   <T> T a(a<T> parama, boolean paramBoolean) {
/*      */     T t;
/* 1647 */     d.printVersion();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1653 */     if (this.a.a() == null) {
/* 1654 */       throw new a("Unable to connect to the database. Configure the url, user and password!");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1668 */     b b1 = null; try {
/*      */       a a1, a2;
/* 1670 */       b1 = a.a((b)this.a, !this.cd);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1675 */       this.cd = true;
/* 1676 */       a.debug("DDL Transactions Supported: " + b1.fx());
/*      */       
/* 1678 */       d[] arrayOfD = a(b1);
/*      */ 
/*      */ 
/*      */       
/* 1682 */       if (!paramBoolean && this.a.fi() && this.a.fn()) {
/* 1683 */         c c = c.a;
/* 1684 */         b b3 = b.a;
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1689 */         a a3 = new a(Arrays.asList(this.a.a()), this.a.getClassLoader(), this.a.a());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1694 */         a1 = a3;
/* 1695 */         a2 = a3;
/*      */       } 
/*      */       
/* 1698 */       k k = b1.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1705 */       b b2 = new b((b)this.a, b1, arrayOfD[0], a(b1, (e)a1, k));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1711 */       t = parama.a(
/* 1712 */           a(b1, (e)a1, (a)a2, k), 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1717 */           d.a((b)this.a, b1, arrayOfD[0]), b1, arrayOfD, (a)b2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     finally {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1730 */       if (b1 != null) {
/* 1731 */         b1.close();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1738 */       hQ();
/*      */     } 
/* 1740 */     return t;
/*      */   }
/*      */   
/*      */   private void hQ() {
/* 1744 */     Runtime runtime = Runtime.getRuntime();
/* 1745 */     long l1 = runtime.freeMemory();
/* 1746 */     long l2 = runtime.totalMemory();
/* 1747 */     long l3 = l2 - l1;
/*      */     
/* 1749 */     long l4 = l2 / 1048576L;
/* 1750 */     long l5 = l3 / 1048576L;
/* 1751 */     a.debug("Memory usage: " + l5 + " of " + l4 + "M");
/*      */   }
/*      */   
/*      */   private d[] a(b paramb) {
/* 1755 */     String[] arrayOfString = this.a.l();
/* 1756 */     if (arrayOfString.length == 0) {
/* 1757 */       d d = paramb.a().a();
/* 1758 */       if (d == null) {
/* 1759 */         throw new a("Unable to determine schema for the schema history table. Set a default schema for the connection or specify one using the schemas property!");
/*      */       }
/*      */       
/* 1762 */       arrayOfString = new String[] { d.getName() };
/*      */     } 
/*      */     
/* 1765 */     if (arrayOfString.length == 1) {
/* 1766 */       a.debug("Schema: " + arrayOfString[0]);
/*      */     } else {
/* 1768 */       a.debug("Schemas: " + n.a((Object[])arrayOfString));
/*      */     } 
/*      */     
/* 1771 */     d[] arrayOfD = new d[arrayOfString.length];
/* 1772 */     for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/* 1773 */       arrayOfD[b1] = paramb.a().a(arrayOfString[b1]);
/*      */     }
/* 1775 */     return arrayOfD;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<b> a(b paramb, e parame, k paramk) {
/* 1786 */     ArrayList<b> arrayList = new ArrayList();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1805 */     arrayList.addAll(Arrays.asList(this.a.a()));
/*      */     
/* 1807 */     if (!this.a.fn()) {
/* 1808 */       arrayList.addAll((new g(paramb, parame, paramk, (b)this.a))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1817 */           .aH());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1827 */     for (b b1 : arrayList) {
/* 1828 */       if (b1 instanceof c) {
/* 1829 */         a.a(b1, (b)this.a);
/*      */       }
/*      */     } 
/* 1832 */     return arrayList;
/*      */   }
/*      */   
/*      */   static interface a<T> {
/*      */     T a(c param1c, c param1c1, b param1b, d[] param1ArrayOfd, a param1a);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */