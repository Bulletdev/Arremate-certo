/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.mutable.MutableInt;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ public class c
/*     */   extends b {
/*  15 */   private int cq = 16;
/*     */   private String et;
/*     */   
/*     */   protected c(k paramk, g paramg, String paramString) {
/*  19 */     super(paramk, paramg);
/*  20 */     this.et = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFWorkbook paramXSSFWorkbook, XSSFSheet paramXSSFSheet) {
/*  25 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(0);
/*  26 */     MutableInt mutableInt = new MutableInt(0);
/*     */     
/*  28 */     a((XSSFCellStyle)null, xSSFRow, mutableInt, new String[] { "ITEM", "DESCRIÇÃO", "QTDE", "U.M.", "CNPJ 1", "VENCEDOR 1", "MARCA 1", "FINAL", "CNPJ 2", "VENCEDOR 2", "MARCA 2", "FINAL", "CNPJ 3", "VENCEDOR 3", "MARCA 3", "FINAL", "MINHA POSIÇÂO" });
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
/*  50 */     paramXSSFSheet.setColumnWidth(0, 1000);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(f paramf, int paramInt, XSSFSheet paramXSSFSheet) {
/*  55 */     e e = paramf.b();
/*     */     
/*  57 */     int i = paramInt + 1;
/*  58 */     MutableInt mutableInt = new MutableInt(0);
/*  59 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(i);
/*     */     
/*  61 */     a((XSSFCellStyle)null, xSSFRow, mutableInt, new String[] { e.bo(), e.K() });
/*  62 */     a((XSSFCellStyle)null, xSSFRow, mutableInt, new Double[] { Double.valueOf(e.i()) });
/*  63 */     a((XSSFCellStyle)null, xSSFRow, mutableInt, new String[] { (e instanceof br.com.arremate.l.q.b.f) ? " " : e.a().bF() });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet, k paramk) {
/*  68 */     byte b1 = 0;
/*  69 */     MutableInt mutableInt = new MutableInt(4);
/*  70 */     byte b2 = b1;
/*  71 */     boolean bool = false;
/*     */     
/*  73 */     List<j> list = a(paramk);
/*     */     
/*  75 */     for (j j : list) {
/*  76 */       if (j instanceof i) {
/*  77 */         a(j, b1++, paramXSSFSheet); continue;
/*     */       } 
/*  79 */       g g = (g)j;
/*  80 */       h h = g.g();
/*     */       
/*  82 */       if (h.bb()) {
/*  83 */         MutableInt mutableInt1 = new MutableInt(this.cq);
/*  84 */         a((XSSFCellStyle)null, paramXSSFSheet.getRow(b1), mutableInt1, new String[] { h.j() + " " });
/*  85 */         if (h.j() > 3 && mutableInt.getValue().intValue() == this.cq) {
/*  86 */           if (!bool) {
/*  87 */             bool = a(paramXSSFSheet, mutableInt1);
/*     */           }
/*  89 */           mutableInt1.setValue(this.cq + 1);
/*  90 */           a(h, b1, mutableInt1, paramXSSFSheet);
/*     */         } 
/*     */       } 
/*  93 */       if (b2 != b1) {
/*  94 */         b2 = b1;
/*  95 */         mutableInt.setValue(4);
/*     */       } 
/*  97 */       if (mutableInt.getValue().intValue() <= this.cq - 1) {
/*  98 */         a(h, b1, mutableInt, paramXSSFSheet);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(XSSFSheet paramXSSFSheet, MutableInt paramMutableInt) {
/* 105 */     a((XSSFCellStyle)null, paramXSSFSheet.getRow(0), paramMutableInt, new String[] { "MEU CPNJ", "MINHA EMPRESA", "MINHA MARCA", "FINAL" });
/* 106 */     return true;
/*     */   }
/*     */   
/*     */   protected void a(h paramh, int paramInt, MutableInt paramMutableInt, XSSFSheet paramXSSFSheet) {
/* 110 */     XSSFRow xSSFRow = paramXSSFSheet.getRow(paramInt);
/*     */     
/* 112 */     a((XSSFCellStyle)null, xSSFRow, paramMutableInt, new String[] { paramh.av(), paramh.ay(), paramh.bH() });
/* 113 */     a(a(paramXSSFSheet.getWorkbook()), xSSFRow, paramMutableInt, new Double[] { Double.valueOf(paramh.m()) });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet) {
/* 118 */     for (byte b1 = 0; b1 <= this.cq + 4; b1++) {
/* 119 */       paramXSSFSheet.autoSizeColumn(b1);
/*     */     }
/* 121 */     paramXSSFSheet.setColumnWidth(1, 20000);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String cs() {
/* 126 */     return this.et;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */