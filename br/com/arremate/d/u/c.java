/*     */ package br.com.arremate.d.u;
/*     */ 
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.l.e.f;
/*     */ import br.com.arremate.l.j;
/*     */ import java.util.concurrent.Future;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*  21 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   private final f a;
/*     */   
/*     */   private String am;
/*     */   private String an;
/*     */   private d a;
/*     */   
/*     */   public c(f paramf) {
/*  30 */     this.a = (d)paramf;
/*     */     
/*     */     try {
/*  33 */       Future<d> future = br.com.arremate.k.c.c.a((j)paramf);
/*  34 */       this.a = future.get();
/*  35 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  38 */     this.am = "";
/*  39 */     this.an = "";
/*     */   }
/*     */   
/*     */   public String F() {
/*  43 */     if (!this.a.isRunning()) {
/*  44 */       this.a.z();
/*  45 */       this.am = "";
/*     */     } 
/*     */     
/*  48 */     if (this.am.isEmpty()) {
/*  49 */       bt();
/*  50 */       this.an = "";
/*     */     } 
/*     */     
/*  53 */     if (this.an.isEmpty()) {
/*  54 */       bs();
/*     */     }
/*     */     
/*  57 */     return this.an;
/*     */   }
/*     */   
/*     */   protected void bs() {
/*     */     try {
/*  62 */       e e = a().c(this.a
/*  63 */           .v(), this.am, "A");
/*     */ 
/*     */ 
/*     */       
/*  67 */       String str = e.getData();
/*     */       
/*  69 */       if (!str.isEmpty()) {
/*  70 */         int i = str.indexOf("form.ticket.value = ") + 20;
/*  71 */         int j = str.indexOf(";", i);
/*     */         
/*  73 */         if (i > -1 && j > -1) {
/*  74 */           this.an = str.substring(i, j).trim();
/*     */           return;
/*     */         } 
/*     */       } 
/*  78 */     } catch (Exception exception) {
/*  79 */       a.warn("#024 - Failed to load ticket", exception);
/*     */     } 
/*     */     
/*  82 */     this.am = "";
/*  83 */     this.an = "";
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
/*     */   protected void bt() {
/*     */     try {
/*  97 */       String str = a().d(this.a
/*  98 */           .v(), this.a
/*  99 */           .bo());
/*     */       
/* 101 */       Document document = Jsoup.parse(str);
/* 102 */       Element element = document.select("frame[name=main_lance]").first();
/*     */       
/* 104 */       if (element != null) {
/* 105 */         String str1 = a().aR() + element.attr("src");
/*     */         
/* 107 */         if (!str1.isEmpty()) {
/* 108 */           this.am = str1.substring(str1.indexOf("sequence=") + 9);
/*     */           return;
/*     */         } 
/*     */       } 
/* 112 */     } catch (Exception exception) {
/* 113 */       a.error("#008 - Failed to load sequence");
/*     */     } 
/*     */     
/* 116 */     this.am = "";
/*     */   }
/*     */   
/*     */   public String G() {
/* 120 */     return this.am;
/*     */   }
/*     */   
/*     */   protected String H() {
/* 124 */     return this.an;
/*     */   }
/*     */   
/*     */   public void bu() {
/* 128 */     this.an = "";
/*     */   }
/*     */   
/*     */   protected d a() {
/* 132 */     return this.a;
/*     */   }
/*     */   
/*     */   protected f a() {
/* 136 */     return (f)this.a;
/*     */   }
/*     */   
/*     */   protected void x(String paramString) {
/* 140 */     this.am = paramString;
/*     */   }
/*     */   
/*     */   protected void y(String paramString) {
/* 144 */     this.an = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */