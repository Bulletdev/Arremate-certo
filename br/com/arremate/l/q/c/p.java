/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class p
/*     */   extends n
/*     */ {
/*     */   private final ReentrantLock lock;
/*  22 */   protected static final String[] a = new String[] { "", "", "Posição", "Item", "Descrição", "Valor do Lance", "CNPJ", "Empresa", "Porte", "Modelo", "Marca", "Fabricante", "", "" };
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
/*  39 */   private static final Class[] b = new Class[] { Object.class, s.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class };
/*     */ 
/*     */   
/*     */   public static final int bX = 0;
/*     */   
/*     */   public static final int cz = 1;
/*     */   
/*     */   public static final int bG = 2;
/*     */   
/*     */   public static final int cA = 3;
/*     */   
/*     */   public static final int ce = 4;
/*     */   
/*     */   public static final int cH = 5;
/*     */   
/*     */   public static final int cB = 6;
/*     */   
/*     */   public static final int cC = 7;
/*     */   
/*     */   public static final int cD = 8;
/*     */   
/*     */   public static final int cE = 9;
/*     */   
/*     */   public static final int cF = 10;
/*     */   
/*     */   public static final int cG = 11;
/*     */   
/*     */   public static final int cI = 12;
/*     */   
/*     */   public static final int co = 13;
/*     */   
/*     */   private boolean am;
/*     */ 
/*     */   
/*     */   protected p() {
/*  74 */     super(a, b);
/*  75 */     this.am = false;
/*  76 */     this.lock = new ReentrantLock();
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(f paramf) {
/*  81 */     if (paramf == null) {
/*     */       return;
/*     */     }
/*  84 */     synchronized (this) {
/*  85 */       if (!M().stream().anyMatch(paramf2 -> (paramf2.b().v() == paramf1.b().v())) || paramf instanceof g) {
/*  86 */         M().add(paramf);
/*     */         
/*     */         try {
/*  89 */           fireTableDataChanged();
/*  90 */         } catch (Exception exception) {}
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object paramObject, int paramInt1, int paramInt2) {
/*     */     boolean bool;
/* 106 */     j j = (j)a(paramInt1);
/*     */     
/* 108 */     if (j == null) {
/*     */       return;
/*     */     }
/* 111 */     switch (paramInt2) {
/*     */       case 0:
/* 113 */         if (j instanceof i) {
/* 114 */           String str = String.valueOf(paramObject);
/* 115 */           boolean bool1 = !str.equals("/img/menos.png") ? true : false;
/* 116 */           setValueAt(Boolean.valueOf(bool1), paramInt1, 12);
/*     */         } 
/*     */         break;
/*     */       case 12:
/* 120 */         bool = ((Boolean)paramObject).booleanValue();
/*     */         
/* 122 */         if (j instanceof g) {
/* 123 */           j.R(bool); break;
/* 124 */         }  if (j instanceof i) {
/* 125 */           a(bool, (i)j, paramInt1);
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean, i parami, int paramInt) {
/* 132 */     synchronized (this) {
/* 133 */       if (this.am) {
/*     */         return;
/*     */       }
/* 136 */       this.am = true;
/*     */     } 
/* 138 */     (new Thread(() -> {
/*     */           try {
/*     */             if (paramBoolean) {
/*     */               boolean bool = ((M().parallelStream().filter(()).toArray()).length == 0) ? true : false;
/*     */ 
/*     */               
/*     */               a((i)null, parami, paramInt);
/*     */               
/*     */               if (bool) {
/*     */                 ArrayList arrayList = new ArrayList();
/*     */                 
/*     */                 M().parallelStream().filter(()).forEachOrdered(());
/*     */                 
/*     */                 if (!arrayList.isEmpty()) {
/*     */                   j.a().c(parami.b(), arrayList);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/*     */             a(paramBoolean, parami);
/* 158 */           } catch (Exception exception) {
/*     */             exception.printStackTrace();
/*     */           } finally {
/*     */             this.am = false;
/*     */             fireTableDataChanged();
/*     */           } 
/* 164 */         })).start();
/*     */   }
/*     */   
/*     */   public void a(i parami, i parami1, int paramInt) {
/* 168 */     this.lock.lock();
/*     */     
/*     */     try {
/* 171 */       boolean bool = M().parallelStream().anyMatch(paramf -> (paramf instanceof g && paramf.b().v() == parami.b().v()));
/*     */       
/* 173 */       if (bool) {
/*     */         return;
/*     */       }
/* 176 */       String str = parami1.cq();
/*     */       
/* 178 */       parami1.aG("/img/arrow_circle.png");
/* 179 */       fireTableCellUpdated(paramInt, 0);
/* 180 */       e e = parami1.b();
/*     */       
/* 182 */       if (!(e instanceof br.com.arremate.l.q.b.g)) {
/* 183 */         List list = parami1.a().a(parami1.b(), parami);
/* 184 */         list.forEach(paramh -> {
/*     */               g g = new g(parami.b(), paramh);
/*     */               
/*     */               a(g);
/*     */               if (paramh.bb()) {
/*     */                 parami.l(paramh.j());
/*     */               }
/*     */             });
/*     */       } 
/* 193 */       parami1.aG(str);
/*     */     } finally {
/* 195 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean, i parami) {
/* 200 */     M().parallelStream().filter(paramf -> paramf instanceof g).forEach(paramf -> {
/*     */           g g = (g)paramf;
/*     */           
/*     */           if (g.b().v() == parami.b().v()) {
/*     */             g.R(paramBoolean);
/*     */           }
/*     */         });
/*     */     
/* 208 */     String str = paramBoolean ? "/img/menos.png" : "/img/mais.png";
/* 209 */     parami.aG(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */