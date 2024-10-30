/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.h;
/*     */ import java.awt.Component;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class p
/*     */ {
/*  21 */   protected static final Logger a = LoggerFactory.getLogger(p.class);
/*     */   
/*     */   private final b b;
/*     */   
/*     */   private e c;
/*     */   private h a;
/*     */   
/*     */   public p(b paramb) {
/*  29 */     this(paramb, null);
/*     */   }
/*     */   
/*     */   public p(b paramb, e parame) {
/*  33 */     this.b = paramb;
/*  34 */     this.c = parame;
/*     */   }
/*     */   
/*     */   public void d(double paramDouble) {
/*  38 */     if (!an() || a() == null) {
/*     */       return;
/*     */     }
/*  41 */     j.a().a(a(), paramDouble);
/*     */     
/*  43 */     boolean bool = true;
/*     */     
/*  45 */     if (paramDouble <= 0.0D) {
/*  46 */       bool = false;
/*  47 */       JOptionPane.showMessageDialog((Component)this.b, "Valor do lance deve ser maior que zero", "Erro", 0);
/*  48 */     } else if (!a().bt()) {
/*  49 */       bool = false;
/*  50 */       JOptionPane.showMessageDialog((Component)this.b, "O item não se encontra em uma situação que possibilita envio de lances", "Erro", 0);
/*     */     } else {
/*     */       
/*  53 */       boolean bool1 = (a().w() == v.b.v()) ? true : false;
/*  54 */       boolean bool2 = (paramDouble >= a().f()) ? true : false;
/*  55 */       boolean bool3 = (paramDouble < a().l()) ? true : false;
/*  56 */       String str1 = "menor";
/*     */       
/*  58 */       if (bool1) {
/*  59 */         bool2 = (paramDouble <= a().f()) ? true : false;
/*  60 */         bool3 = (paramDouble > a().l()) ? true : false;
/*  61 */         str1 = "maior";
/*     */       } 
/*     */       
/*  64 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*  65 */       String str2 = decimalFormat.format(paramDouble);
/*     */       
/*  67 */       if (bool2) {
/*  68 */         bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  76 */         String str = "O valor do lance manual deve ser " + str1 + " que seu último lance\n\nValor lance manual: " + str2 + "\nSeu último lance: " + a().f();
/*     */         
/*  78 */         JOptionPane.showMessageDialog((Component)this.b, str, "Erro", 0);
/*  79 */       } else if (bool3) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  85 */         String str = "Seu lance é " + str1 + " que o valor limite definido. Confirma o envio do lance no valor de R$" + str2 + "?";
/*     */         
/*  87 */         int i = JOptionPane.showConfirmDialog((Component)this.b, str, "Alerta", 0, 2);
/*     */         
/*  89 */         bool = (i == 0) ? true : false;
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     if (!bool) {
/*  94 */       a().cX();
/*     */       return;
/*     */     } 
/*  97 */     e(paramDouble);
/*     */   }
/*     */   
/*     */   protected void e(double paramDouble) {
/* 101 */     (new Thread(() -> {
/*     */           boolean bool = false;
/*     */           try {
/*     */             bool = a().a().d(a(), paramDouble);
/*     */             if (!bool) {
/*     */               bool = a().a().d(a(), paramDouble);
/*     */             }
/* 108 */           } catch (Exception exception) {
/*     */             a.error("Failed to send manual bid", exception);
/*     */           } finally {
/*     */             if (bool) {
/*     */               String str = "Lance registrado com sucesso, em breve seu lance será atualizado em tela";
/*     */               
/*     */               JOptionPane.showMessageDialog((Component)this.b, str, "Mensagem", 1);
/*     */             } else {
/*     */               JOptionPane.showMessageDialog((Component)this.b, "Lance não registrado, tente novamente", "Erro", 0);
/*     */             } 
/*     */             a().cX();
/*     */           } 
/* 120 */         })).start();
/*     */   }
/*     */   
/*     */   public boolean f(int paramInt) {
/* 124 */     i i = a().a();
/* 125 */     e e1 = i.a(Integer.toString(paramInt));
/*     */     
/* 127 */     if (e1 != null && e1.bt()) {
/* 128 */       B(e1);
/* 129 */       return true;
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   public boolean an() {
/* 135 */     return (this.c != null);
/*     */   }
/*     */   
/*     */   public b a() {
/* 139 */     return this.b;
/*     */   }
/*     */   
/*     */   public e a() {
/* 143 */     return this.c;
/*     */   }
/*     */   
/*     */   public void B(e parame) {
/* 147 */     this.c = parame;
/*     */   }
/*     */   
/*     */   private h a() {
/* 151 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(h paramh) {
/* 155 */     this.a = paramh;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */