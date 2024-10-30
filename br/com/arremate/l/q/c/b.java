/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.c.c;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.n;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.apache.commons.lang3.mutable.MutableInt;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(b.class.getClass());
/*     */   
/*     */   private boolean aj;
/*     */   
/*     */   protected b(k paramk, g paramg) {
/*  38 */     super(paramk, paramg);
/*  39 */     a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(n paramn) {
/*     */     try {
/*  45 */       if (cs().isEmpty()) {
/*  46 */         int k = JOptionPane.showConfirmDialog(null, "Deseja exportar os itens encerrados com os melhores lances?", "Mensagem", 0, 1);
/*     */ 
/*     */         
/*  49 */         if (k != 0) {
/*  50 */           a(false);
/*  51 */           return false;
/*     */         } 
/*     */       } 
/*  54 */       p p = (p)paramn;
/*  55 */       int i = (int)p.M().parallelStream().filter(paramf -> paramf instanceof i).count();
/*     */       
/*  57 */       JOptionPane jOptionPane = new JOptionPane("Realizando o login no portal...");
/*  58 */       jOptionPane.setOptions((Object[])new String[] { "Esconder" });
/*  59 */       JDialog jDialog = jOptionPane.createDialog(null, "Carregamento dos melhores lances");
/*     */       
/*  61 */       SwingUtilities.invokeLater(() -> paramJDialog.setVisible(true));
/*     */ 
/*     */ 
/*     */       
/*  65 */       ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(20);
/*  66 */       j j = paramn.a(0).b().a();
/*     */       
/*  68 */       Future<i> future = c.a(j);
/*  69 */       i i1 = future.get();
/*  70 */       if (!i1.isRunning()) {
/*  71 */         jDialog.dispose();
/*     */         
/*  73 */         String str = "Falha ao realizar o login no portal";
/*  74 */         if (i1.getMessage() != null && !i1.getMessage().isEmpty()) {
/*  75 */           str = i1.getMessage();
/*     */         }
/*     */         
/*  78 */         JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*  79 */         return true;
/*     */       } 
/*     */       
/*  82 */       jOptionPane.setMessage("0 de " + i);
/*  83 */       ArrayList<Future<?>> arrayList = new ArrayList();
/*     */       
/*     */       byte b1;
/*  86 */       for (b1 = 0; b1 < p.getRowCount(); b1++) {
/*  87 */         f f = p.a(b1);
/*     */ 
/*     */         
/*  90 */         if (f instanceof i) {
/*     */ 
/*     */ 
/*     */           
/*  94 */           i i2 = (i)f;
/*  95 */           byte b2 = b1;
/*     */           
/*  97 */           arrayList.add(scheduledThreadPoolExecutor.submit(() -> {
/*     */                   try {
/*     */                     paramp.a(parami, parami1, paramInt1);
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/*     */                     SwingUtilities.invokeLater(());
/* 105 */                   } catch (Exception exception) {
/*     */                     a.error("Erro na exportação dos melhores lances do item {}", paramf.b().bo(), exception);
/*     */                   } 
/*     */                 }));
/*     */         } 
/*     */       } 
/* 111 */       for (Future<?> future1 : arrayList) {
/* 112 */         future1.get();
/*     */       }
/* 114 */       scheduledThreadPoolExecutor.shutdown();
/*     */       
/* 116 */       p.fireTableDataChanged();
/*     */ 
/*     */       
/* 119 */       if (i1.isRunning()) {
/* 120 */         for (b1 = 0; b1 < p.getRowCount(); b1++) {
/* 121 */           f f = p.a(b1);
/*     */ 
/*     */           
/* 124 */           if (f instanceof i) {
/*     */ 
/*     */ 
/*     */             
/* 128 */             i i2 = (i)f;
/* 129 */             p.a(i1, i2, b1);
/*     */           } 
/*     */         } 
/*     */         
/* 133 */         i1.b();
/*     */       } 
/*     */       
/* 136 */       jDialog.dispose();
/* 137 */       p.fireTableDataChanged();
/* 138 */     } catch (Exception exception) {
/* 139 */       a.error("Erro na exportação dos melhores lances", exception);
/*     */     } 
/*     */     
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet, k paramk) {
/* 147 */     byte b1 = 0;
/* 148 */     List<j> list = a(paramk);
/*     */     
/* 150 */     for (j j : list) {
/* 151 */       if (j instanceof i) {
/* 152 */         a(j, b1, paramXSSFSheet);
/* 153 */         b1++; continue;
/* 154 */       }  if (this.aj) {
/* 155 */         a(j, b1, paramXSSFSheet);
/* 156 */         b1++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<j> a(k paramk) {
/* 168 */     p p = (p)paramk.getModel();
/* 169 */     List<f> list = p.M();
/* 170 */     ArrayList<?> arrayList = new ArrayList();
/*     */     
/* 172 */     list.forEach(paramf -> paramList.add((j)paramf));
/*     */ 
/*     */ 
/*     */     
/* 176 */     Collections.sort(arrayList, (paramj1, paramj2) -> paramj1.ck().compareTo(paramj2.ck()));
/* 177 */     return (List)arrayList;
/*     */   }
/*     */   protected void a(j paramj, int paramInt, XSSFSheet paramXSSFSheet) {
/*     */     XSSFCellStyle xSSFCellStyle1;
/* 181 */     e e = paramj.b();
/* 182 */     int i = paramInt + 1;
/* 183 */     MutableInt mutableInt = new MutableInt(0);
/* 184 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(i);
/*     */     
/* 186 */     XSSFCellStyle xSSFCellStyle2 = a(paramXSSFSheet.getWorkbook());
/*     */     
/* 188 */     switch (null.j[e.a().ordinal()]) {
/*     */       case 1:
/* 190 */         xSSFCellStyle1 = c(paramXSSFSheet.getWorkbook().createCellStyle());
/* 191 */         xSSFCellStyle2 = c(xSSFCellStyle2);
/*     */         break;
/*     */       case 2:
/* 194 */         xSSFCellStyle1 = d(paramXSSFSheet.getWorkbook().createCellStyle());
/* 195 */         xSSFCellStyle2 = d(xSSFCellStyle2);
/*     */         break;
/*     */       case 3:
/* 198 */         xSSFCellStyle1 = e(paramXSSFSheet.getWorkbook().createCellStyle());
/* 199 */         xSSFCellStyle2 = e(xSSFCellStyle2);
/*     */         break;
/*     */       default:
/* 202 */         xSSFCellStyle1 = a(paramXSSFSheet.getWorkbook().createCellStyle());
/*     */         break;
/*     */     } 
/* 205 */     g g = (g)paramj;
/*     */     
/* 207 */     if (!g.g().bb()) {
/* 208 */       xSSFCellStyle1 = a(xSSFCellStyle1);
/* 209 */       xSSFCellStyle2 = a(xSSFCellStyle2);
/*     */     } 
/*     */     
/* 212 */     a((XSSFCellStyle)null, xSSFRow, mutableInt, new String[] { " " });
/* 213 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { g.g().j() + "º", " ", " " });
/*     */     
/* 215 */     if (n.bQ()) {
/* 216 */       a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { g
/* 217 */             .g().av(), g
/* 218 */             .g().ay(), g
/* 219 */             .g().bL(), g
/* 220 */             .g().bK(), g
/* 221 */             .g().bH(), g
/* 222 */             .g().bI() });
/*     */     }
/*     */     
/* 225 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { " ", " " });
/* 226 */     a(xSSFCellStyle2, xSSFRow, mutableInt, new Double[] { Double.valueOf(a(g)), Double.valueOf(b(g)) });
/*     */   }
/*     */ 
/*     */   
/*     */   protected int X() {
/* 231 */     return this.aj ? 3 : 2;
/*     */   }
/*     */   
/*     */   protected double a(g paramg) {
/* 235 */     e e = paramg.b();
/* 236 */     boolean bool = (e.a().aZ() || (!e.ay() && e.a().aZ())) ? true : false;
/* 237 */     double d = paramg.g().m();
/* 238 */     return bool ? d : (d / e.i());
/*     */   }
/*     */   
/*     */   protected double b(g paramg) {
/* 242 */     e e = paramg.b();
/* 243 */     boolean bool = (e.a().aZ() || (!e.ay() && e.a().aZ())) ? true : false;
/* 244 */     double d = paramg.g().m();
/* 245 */     return bool ? (d * e.i()) : d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean bz() {
/* 250 */     return this.aj;
/*     */   }
/*     */   
/*     */   protected boolean a(boolean paramBoolean) {
/* 254 */     return this.aj = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */