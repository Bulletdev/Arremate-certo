/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.mutable.MutableInt;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ public class d
/*     */   extends b {
/*     */   private boolean ak = true;
/*     */   
/*     */   protected d(k paramk, g paramg) {
/*  18 */     super(paramk, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFWorkbook paramXSSFWorkbook, XSSFSheet paramXSSFSheet) {
/*  23 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(0);
/*  24 */     XSSFCellStyle xSSFCellStyle = a(paramXSSFWorkbook, true);
/*  25 */     MutableInt mutableInt = new MutableInt(0);
/*  26 */     a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Situação", "Posição", "Item", "Descrição", "CNPJ", "Nome Empresa", "Porte", "Modelo", "Marca", "Fabricante", "Quantidade", "Unidade de medida", "Valor Unitário", "Valor Total" });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet, k paramk) {
/*  31 */     byte b1 = 0;
/*  32 */     boolean bool = true;
/*  33 */     i i = null;
/*     */     
/*  35 */     List<j> list = a(paramk);
/*     */     
/*  37 */     for (j j : list) {
/*  38 */       if (j instanceof i) {
/*  39 */         i = (i)j;
/*  40 */         bool = !bool ? true : false;
/*  41 */         this.ak = true;
/*  42 */         if (i.b().f().m() == 0.0D) {
/*  43 */           a(i, b1, paramXSSFSheet, bool);
/*  44 */           b1++;
/*     */         }  continue;
/*     */       } 
/*  47 */       a(i, j, b1, paramXSSFSheet, bool);
/*  48 */       b1++;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(i parami, int paramInt, XSSFSheet paramXSSFSheet, boolean paramBoolean) {
/*     */     XSSFCellStyle xSSFCellStyle1, xSSFCellStyle2;
/*  54 */     e e = parami.b();
/*  55 */     MutableInt mutableInt = new MutableInt(0);
/*  56 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(paramInt + 1);
/*     */ 
/*     */ 
/*     */     
/*  60 */     if (paramBoolean) {
/*  61 */       xSSFCellStyle1 = a(a(paramXSSFSheet.getWorkbook(), false));
/*  62 */       xSSFCellStyle2 = a(a(paramXSSFSheet.getWorkbook()));
/*     */     } else {
/*  64 */       xSSFCellStyle1 = b(a(paramXSSFSheet.getWorkbook(), false));
/*  65 */       xSSFCellStyle2 = b(a(paramXSSFSheet.getWorkbook()));
/*     */     } 
/*     */     
/*  68 */     String str = e.K();
/*  69 */     if (!(e instanceof br.com.arremate.l.q.b.f) && !e.a().bD().isEmpty()) {
/*  70 */       str = str + " (" + e.a().bD() + ")";
/*     */     }
/*     */     
/*  73 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { "Fracassado", "", e.bo(), str, "", "", "", "", "", "" });
/*  74 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new Double[] { Double.valueOf(e.i()) });
/*  75 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { (e instanceof br.com.arremate.l.q.b.f) ? " " : e.a().bF() });
/*  76 */     a(xSSFCellStyle2, xSSFRow, mutableInt, new Double[] { Double.valueOf(0.0D), Double.valueOf(0.0D) });
/*     */   }
/*     */   protected void a(i parami, j paramj, int paramInt, XSSFSheet paramXSSFSheet, boolean paramBoolean) {
/*     */     XSSFCellStyle xSSFCellStyle1, xSSFCellStyle2;
/*  80 */     e e = parami.b();
/*  81 */     MutableInt mutableInt = new MutableInt(0);
/*  82 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(paramInt + 1);
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (paramBoolean) {
/*  87 */       xSSFCellStyle1 = a(a(paramXSSFSheet.getWorkbook(), false));
/*  88 */       xSSFCellStyle2 = a(a(paramXSSFSheet.getWorkbook()));
/*     */     } else {
/*  90 */       xSSFCellStyle1 = b(a(paramXSSFSheet.getWorkbook(), false));
/*  91 */       xSSFCellStyle2 = b(a(paramXSSFSheet.getWorkbook()));
/*     */     } 
/*     */     
/*  94 */     g g = (g)paramj;
/*     */     
/*  96 */     if (!g.g().bb() && g.g().j() == 1) {
/*  97 */       this.ak = false;
/*     */     }
/*     */     
/* 100 */     String str1 = " ";
/* 101 */     switch (null.j[e.a().ordinal()]) {
/*     */       
/*     */       case 1:
/* 104 */         if (!this.ak) {
/* 105 */           str1 = "Revertido"; break;
/*     */         } 
/* 107 */         str1 = "Ganho";
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 113 */         if (this.ak || e.f() == 0.0D) {
/* 114 */           str1 = "Desclassificado"; break;
/*     */         } 
/* 116 */         str1 = "Perdido";
/*     */         break;
/*     */       
/*     */       default:
/* 120 */         if (e.bB().equals("Fracassado")) {
/* 121 */           str1 = "Fracassado"; break;
/*     */         } 
/* 123 */         str1 = "";
/*     */         break;
/*     */     } 
/*     */     
/* 127 */     String str2 = e.K();
/* 128 */     if (!(e instanceof br.com.arremate.l.q.b.f) && !e.a().bD().isEmpty()) {
/* 129 */       str2 = str2 + " (" + e.a().bD() + ")";
/*     */     }
/*     */     
/* 132 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { str1, g
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 137 */           .g().j() + "º", e
/* 138 */           .bo(), str2, g
/*     */           
/* 140 */           .g().av(), g
/* 141 */           .g().ay(), g
/* 142 */           .g().bL(), g
/* 143 */           .g().bK(), g
/* 144 */           .g().bH(), g
/* 145 */           .g().bI() });
/*     */     
/* 147 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new Double[] { Double.valueOf(e.i()) });
/* 148 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { (e instanceof br.com.arremate.l.q.b.f) ? " " : e.a().bF() });
/* 149 */     a(xSSFCellStyle2, xSSFRow, mutableInt, new Double[] { Double.valueOf(a(g)), Double.valueOf(b(g)) });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */