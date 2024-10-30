/*     */ package br.com.arremate.l.q.b;
/*     */ 
/*     */ import br.com.arremate.f.r;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */   extends AbstractTableModel
/*     */ {
/*  22 */   private static final Logger a = LoggerFactory.getLogger(i.class);
/*     */   
/*     */   public static final int bF = 18;
/*     */   
/*     */   public static final int bX = 0;
/*     */   
/*     */   public static final int bY = 1;
/*     */   
/*     */   public static final int bZ = 2;
/*     */   public static final int ca = 3;
/*     */   public static final int cc = 4;
/*     */   public static final int bG = 5;
/*     */   public static final int cd = 6;
/*     */   public static final int ce = 7;
/*     */   public static final int cf = 8;
/*     */   public static final int cg = 9;
/*     */   public static final int ch = 10;
/*     */   public static final int ci = 11;
/*     */   public static final int cj = 12;
/*     */   public static final int ck = 13;
/*     */   public static final int cl = 14;
/*     */   public static final int cm = 15;
/*     */   public static final int cn = 16;
/*     */   public static final int co = 17;
/*     */   private final List<e> C;
/*     */   private final String[] columnNames;
/*     */   private List<e> D;
/*     */   
/*     */   public i() {
/*  51 */     this(new String[] { "", "", "", "", "Disp. ME", "Disputando", "Item", "Descrição", "Situação", "Valor Proposta", "Valor Limite", "Lance Fechado", "Seu Último Lance", "Melhor Lance", "", "", "", "" });
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
/*     */ 
/*     */   
/*     */   public i(String[] paramArrayOfString) {
/*  74 */     this.columnNames = paramArrayOfString;
/*  75 */     this.C = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public void F(e parame) {
/*  79 */     if (parame != null) {
/*  80 */       this.C.add(parame);
/*     */       
/*  82 */       fireTableRowsInserted(this.C.size() - 1, this.C.size() - 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeRow(int paramInt) {
/*  87 */     if (paramInt < getRowCount()) {
/*  88 */       this.C.remove(paramInt);
/*     */       
/*  90 */       fireTableRowsDeleted(paramInt, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/*  96 */     return this.C.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 101 */     return this.columnNames.length;
/*     */   }
/*     */   
/*     */   public e b(int paramInt) {
/* 105 */     if (paramInt >= getRowCount() || paramInt < 0) {
/* 106 */       return null;
/*     */     }
/*     */     
/* 109 */     return this.C.get(paramInt);
/*     */   }
/*     */   
/*     */   public e a(int paramInt) {
/* 113 */     for (e e : this.C) {
/* 114 */       if (e.v() == paramInt) {
/* 115 */         return e;
/*     */       }
/*     */     } 
/*     */     
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   public e a(String paramString) {
/* 123 */     if (!"".equals(paramString)) {
/* 124 */       for (e e : this.C) {
/* 125 */         if (e.bo().equals(paramString)) {
/* 126 */           return e;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   public e b(String paramString) {
/* 135 */     if (!"".equals(paramString)) {
/* 136 */       for (e e : this.C) {
/* 137 */         if (e.bo().equals(paramString) && !(e instanceof g)) {
/* 138 */           return e;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 143 */     return null;
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
/*     */   public Object getValueAt(int paramInt1, int paramInt2) {
/* 155 */     e e = b(paramInt1);
/*     */     
/* 157 */     if (e != null) {
/* 158 */       return e.toArray()[paramInt2];
/*     */     }
/*     */     
/* 161 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {
/* 166 */     e e = b(paramInt1);
/*     */     
/* 168 */     if (e != null) {
/* 169 */       String str; boolean bool; switch (paramInt2) {
/*     */         case 0:
/* 171 */           str = String.valueOf(paramObject);
/* 172 */           bool = !str.equals("/img/menos.png") ? true : false;
/*     */           
/* 174 */           if (e instanceof f) {
/* 175 */             a(bool, (f)e); break;
/*     */           } 
/* 177 */           e.R(bool);
/*     */           break;
/*     */         
/*     */         case 5:
/* 181 */           e.i(String.valueOf(paramObject));
/*     */           break;
/*     */         case 3:
/* 184 */           e.a((r)paramObject);
/*     */           break;
/*     */         case 4:
/* 187 */           e.q(((Boolean)paramObject).booleanValue());
/*     */           break;
/*     */         case 8:
/* 190 */           e.N(String.valueOf(paramObject));
/*     */           break;
/*     */         case 11:
/* 193 */           if (e instanceof f) {
/*     */             break;
/*     */           }
/*     */           
/* 197 */           e.a().g(BigDecimal.valueOf(((Double)paramObject).doubleValue()));
/*     */           
/* 199 */           if (e instanceof g) {
/* 200 */             g g = (g)e;
/*     */             
/* 202 */             for (byte b = 0; b < this.C.size(); b++) {
/* 203 */               e e1 = this.C.get(b);
/*     */               
/* 205 */               if (e1 instanceof f && e1
/* 206 */                 .v() == g.a().v()) {
/* 207 */                 fireTableCellUpdated(b, 11);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 10:
/* 214 */           if (e instanceof f) {
/*     */             break;
/*     */           }
/*     */           
/*     */           try {
/* 219 */             e.a().o(((Double)paramObject).doubleValue());
/*     */             
/* 221 */             if (e.a().aY()) {
/* 222 */               fireTableCellUpdated(paramInt1, 11);
/*     */             }
/*     */             
/* 225 */             if (e instanceof g) {
/* 226 */               g g = (g)e;
/*     */               
/* 228 */               for (byte b = 0; b < this.C.size(); b++) {
/* 229 */                 e e1 = this.C.get(b);
/*     */                 
/* 231 */                 if (e1 instanceof f && e1
/* 232 */                   .v() == g.a().v()) {
/* 233 */                   fireTableCellUpdated(b, 10);
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/* 238 */           } catch (Exception exception) {
/* 239 */             a.warn("{} - Erro ao atualizar limite do item", e.bo(), exception);
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 12:
/* 244 */           e.h(((Double)paramObject).doubleValue());
/*     */           break;
/*     */         case 13:
/* 247 */           if (paramObject instanceof Double) {
/* 248 */             e.l(((Double)paramObject).doubleValue()); break;
/*     */           } 
/* 250 */           e.h((h)paramObject);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 15:
/* 255 */           e.ah(((Integer)paramObject).intValue());
/*     */           break;
/*     */         case 16:
/* 258 */           e.ai(((Integer)paramObject).intValue());
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/*     */     try {
/* 264 */       fireTableCellUpdated(paramInt1, paramInt2);
/* 265 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public int c(int paramInt) {
/* 270 */     for (byte b = 0; b < this.C.size(); b++) {
/* 271 */       if (b(b).a().v() == paramInt) {
/* 272 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 276 */     return -1;
/*     */   }
/*     */   
/*     */   public int indexOf(int paramInt) {
/* 280 */     for (byte b = 0; b < this.C.size(); b++) {
/* 281 */       if (b(b).v() == paramInt) {
/* 282 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 286 */     return -1;
/*     */   }
/*     */   
/*     */   public List<g> B() {
/* 290 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 292 */     L().stream().filter(parame -> !(parame instanceof f)).forEach(parame -> paramList.add(parame.a()));
/*     */ 
/*     */ 
/*     */     
/* 296 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<f> G() {
/* 300 */     ArrayList<f> arrayList = new ArrayList();
/*     */     
/* 302 */     L().stream().filter(parame -> parame instanceof f).forEach(parame -> {
/*     */           f f = (f)parame;
/*     */           
/*     */           paramList.add(f);
/*     */         });
/* 307 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<e> H() {
/* 311 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/* 313 */     L().forEach(parame -> {
/*     */           if (parame.bt()) {
/*     */             paramList.add(parame);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 320 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<e> I() {
/* 324 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/* 326 */     L().forEach(parame -> {
/*     */           if (parame.bt() || parame.au()) {
/*     */             paramList.add(parame);
/*     */           }
/*     */         });
/*     */     
/* 332 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<e> J() {
/* 336 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/* 338 */     L().forEach(parame -> {
/*     */           if (parame.bt() || parame.au() || parame.bx()) {
/*     */             paramList.add(parame);
/*     */           }
/*     */         });
/*     */     
/* 344 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<e> K() {
/* 348 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/* 350 */     L().forEach(parame -> {
/*     */           if (parame.bx()) {
/*     */             paramList.add(parame);
/*     */           }
/*     */         });
/*     */     
/* 356 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean by() {
/* 365 */     return this.C.stream().anyMatch(parame -> parame.bt());
/*     */   }
/*     */   
/*     */   public void clear() {
/* 369 */     this.C.clear();
/* 370 */     fireTableDataChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/* 375 */     if (paramInt >= getColumnCount()) {
/* 376 */       return "";
/*     */     }
/* 378 */     return this.columnNames[paramInt];
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
/*     */   public boolean isCellEditable(int paramInt1, int paramInt2) {
/* 391 */     return (!(b(paramInt1) instanceof f) && (paramInt2 == 10 || paramInt2 == 11));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int paramInt) {
/* 397 */     Class[] arrayOfClass = new Class[getColumnCount()];
/* 398 */     arrayOfClass[0] = Object.class;
/* 399 */     arrayOfClass[1] = Object.class;
/* 400 */     arrayOfClass[2] = Object.class;
/* 401 */     arrayOfClass[3] = r.class;
/* 402 */     arrayOfClass[4] = Boolean.class;
/* 403 */     arrayOfClass[5] = String.class;
/* 404 */     arrayOfClass[6] = String.class;
/* 405 */     arrayOfClass[7] = String.class;
/* 406 */     arrayOfClass[8] = String.class;
/* 407 */     arrayOfClass[9] = Double.class;
/* 408 */     arrayOfClass[11] = Double.class;
/* 409 */     arrayOfClass[10] = Double.class;
/* 410 */     arrayOfClass[12] = Double.class;
/* 411 */     arrayOfClass[13] = Double.class;
/* 412 */     arrayOfClass[14] = Integer.class;
/* 413 */     arrayOfClass[15] = Integer.class;
/* 414 */     arrayOfClass[16] = Integer.class;
/* 415 */     arrayOfClass[17] = String.class;
/*     */     
/* 417 */     return arrayOfClass[paramInt];
/*     */   }
/*     */   
/*     */   public List<e> L() {
/* 421 */     if (this.D == null || this.D.size() < this.C.size()) {
/* 422 */       this.D = new ArrayList<>(this.C);
/* 423 */       this.D.sort(Comparator.comparing(e::ck));
/*     */     } 
/*     */     
/* 426 */     return this.D;
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean, f paramf) {
/* 430 */     this.C.parallelStream().filter(parame -> parame instanceof g).forEach(parame -> {
/*     */           g g = (g)parame;
/*     */           
/*     */           if (g.a().v() == paramf.a().v()) {
/*     */             g.R(paramBoolean);
/*     */           }
/*     */         });
/* 437 */     String str = paramBoolean ? "/img/menos.png" : "/img/mais.png";
/* 438 */     paramf.aG(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */