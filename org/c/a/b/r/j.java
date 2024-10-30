/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
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
/*     */ public class j
/*     */ {
/*  31 */   private static final a a = c.b(j.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private final List<b> au = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(String... paramVarArgs) {
/*  44 */     ArrayList<b> arrayList = new ArrayList();
/*  45 */     for (String str : paramVarArgs) {
/*  46 */       arrayList.add(new b(str));
/*     */     }
/*  48 */     s(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(List<b> paramList) {
/*  57 */     s(paramList);
/*     */   }
/*     */   
/*     */   private void s(List<b> paramList) {
/*  61 */     ArrayList<b> arrayList = new ArrayList<>(paramList);
/*  62 */     Collections.sort(arrayList);
/*     */     
/*  64 */     for (b b1 : arrayList) {
/*  65 */       if (this.au.contains(b1)) {
/*  66 */         a.warn("Discarding duplicate location '" + b1 + "'");
/*     */         
/*     */         continue;
/*     */       } 
/*  70 */       b b2 = a(b1, this.au);
/*  71 */       if (b2 != null) {
/*  72 */         a.warn("Discarding location '" + b1 + "' as it is a sublocation of '" + b2 + "'");
/*     */         
/*     */         continue;
/*     */       } 
/*  76 */       this.au.add(b1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<b> bc() {
/*  84 */     return this.au;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a(b paramb, List<b> paramList) {
/*  95 */     for (b b1 : paramList) {
/*  96 */       if (b1.a(paramb)) {
/*  97 */         return b1;
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */