/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.i.b;
/*     */ import br.com.arremate.l.a.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c;
/*     */ import br.com.arremate.l.q.c.g;
/*     */ import br.com.arremate.l.q.c.j;
/*     */ import br.com.arremate.l.q.c.p;
/*     */ import br.com.arremate.l.q.d;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.math.BigDecimal;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
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
/*     */ public class r
/*     */   extends DefaultTableCellRenderer
/*     */ {
/*     */   private b a;
/*     */   
/*     */   public r(int paramInt) {
/*  35 */     setHorizontalAlignment(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/*  41 */     Component component = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/*     */     
/*  43 */     int i = paramJTable.convertRowIndexToModel(paramInt1);
/*     */     
/*  45 */     if (!paramBoolean1) {
/*  46 */       component = y.a(component, paramInt1);
/*  47 */       y.a(paramJTable, component, paramInt1);
/*     */     } 
/*     */     
/*  50 */     if (paramJTable instanceof br.com.arremate.l.q.b.h) {
/*  51 */       String str2; Color color = null;
/*  52 */       String str1 = null;
/*  53 */       i i1 = (i)paramJTable.getModel();
/*  54 */       e e = i1.b(i);
/*  55 */       boolean bool1 = (e.w() == v.a.v()) ? true : false;
/*     */ 
/*     */       
/*  58 */       boolean bool2 = bool1 ? ((e.l() >= e.k()) ? true : false) : ((e.l() <= e.k()) ? true : false);
/*     */ 
/*     */ 
/*     */       
/*  62 */       boolean bool3 = bool1 ? ((e.y().compareTo(BigDecimal.valueOf(e.f())) >= 0) ? true : false) : ((e.y().compareTo(BigDecimal.valueOf(e.f())) <= 0) ? true : false);
/*     */       
/*  64 */       if (e.bv() && (bool3 || e
/*  65 */         .y().compareTo(BigDecimal.ZERO) <= 0)) {
/*  66 */         color = y.h();
/*  67 */       } else if ((e.bt() && e
/*  68 */         .a() == br.com.arremate.f.r.b) || (e instanceof br.com.arremate.l.q.b.g && e
/*  69 */         .l() <= 0.0D) || e
/*  70 */         .bx()) {
/*  71 */         color = y.h();
/*  72 */       } else if (bool2 && e.k() > 0.0D) {
/*  73 */         color = y.g();
/*     */         
/*  75 */         if (bool1) {
/*  76 */           str1 = "Valor limite não configurado (valor da proposta igual/maior que o valor limite do item).";
/*     */         } else {
/*  78 */           str1 = "Valor limite não configurado (valor da proposta igual/menor que o valor limite do item).";
/*     */         } 
/*     */       } 
/*     */       
/*  82 */       switch (paramInt2) {
/*     */         case 11:
/*  84 */           if (e.a().a() == m.c && e
/*  85 */             .y().compareTo(BigDecimal.valueOf(e.l())) >= 0) {
/*  86 */             color = y.g();
/*  87 */             setToolTipText("Valor do lance fechado igual ao valor limite não é indicado.");
/*     */           } 
/*     */           break;
/*     */         case 10:
/*  91 */           str2 = y.a(paramJTable, component, paramInt1);
/*  92 */           setToolTipText(str2);
/*     */           break;
/*     */         case 15:
/*  95 */           setToolTipText("Quantidade de usuário online");
/*     */           break;
/*     */         case 16:
/*  98 */           setToolTipText("Quantidade de usuário offline");
/*     */           break;
/*     */         case 14:
/* 101 */           setToolTipText("Tempo para o próximo lance");
/*     */           break;
/*     */       } 
/*     */       
/* 105 */       if (e.a() instanceof a) {
/* 106 */         a a = (a)e.a();
/*     */         
/* 108 */         if (a.ap()) {
/* 109 */           str1 = "Encontrando dificuldades na captura de dados do lote, podendo apresentar lentidão na disputa";
/*     */         }
/*     */       } 
/*     */       
/* 113 */       if (str1 != null) {
/* 114 */         setToolTipText(str1);
/*     */       }
/*     */       
/* 117 */       if (color != null) {
/* 118 */         component.setForeground(color);
/*     */       }
/* 120 */     } else if (paramJTable.getModel() instanceof d) {
/* 121 */       c c = ((d)paramJTable.getModel()).a(paramInt1);
/*     */       
/* 123 */       if (c.g().bb()) {
/* 124 */         if (c.g().j() == 1) {
/* 125 */           component.setBackground(new Color(140, 207, 183));
/*     */         } else {
/* 127 */           component.setBackground(new Color(255, 153, 153));
/*     */         } 
/*     */         
/* 130 */         setToolTipText("Seu Último Lance");
/*     */       } else {
/* 132 */         setToolTipText(null);
/*     */       } 
/* 134 */     } else if (paramJTable instanceof br.com.arremate.l.q.c.m) {
/* 135 */       p p = (p)paramJTable.getModel();
/* 136 */       j j = (j)p.a(i);
/*     */       
/* 138 */       if (j instanceof g) {
/* 139 */         g g = (g)j;
/*     */         
/* 141 */         if (g.g().bb()) {
/* 142 */           if (g.g().j() == 1) {
/* 143 */             component.setBackground(new Color(140, 207, 183));
/*     */           } else {
/* 145 */             component.setBackground(new Color(255, 153, 153));
/*     */           } 
/* 147 */           setToolTipText("Seu Último Lance");
/*     */         } else {
/* 149 */           setToolTipText(null);
/*     */         } 
/*     */       } 
/* 152 */     } else if (paramJTable.getModel() instanceof br.com.arremate.l.q.a) {
/* 153 */       Object object = paramJTable.getValueAt(paramInt1, 0);
/*     */       
/* 155 */       if (object != null && ((Boolean)object).booleanValue()) {
/* 156 */         component = y.a(component);
/*     */       } else {
/* 158 */         component = y.a(component, paramInt1);
/*     */       } 
/*     */     } 
/*     */     
/* 162 */     if (this.a != null && paramObject != null) {
/* 163 */       setText(String.valueOf(this.a.transformValue(paramObject, i, paramInt2, paramJTable.getModel())));
/*     */     }
/*     */     
/* 166 */     return component;
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/* 170 */     this.a = paramb;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */